package com.mentors.HiringProcess.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mentors.HiringProcess.builder.RecruiterBuilder;
import com.mentors.HiringProcess.builder.UserAccoutBuilder;
import com.mentors.HiringProcess.dto.RecruiterDto;
import com.mentors.HiringProcess.dto.RoleDto;
import com.mentors.HiringProcess.exceptions.RecruiterValidationException;
import com.mentors.HiringProcess.model.Recruiter;
import com.mentors.HiringProcess.model.Role;
import com.mentors.HiringProcess.model.UserAccout;
import com.mentors.HiringProcess.repository.RecruiterRepository;
import com.mentors.HiringProcess.repository.RoleRepository;
import com.mentors.HiringProcess.repository.UserAccoutRepository;
import com.mentors.HiringProcess.specification.RecruiterSpecifications;


@Service
@Transactional
public class RecruiterServiceImpl implements RecruiterServiceI {

	@Autowired
	private RecruiterRepository recruiterRepository;

	@Autowired
	private RecruiterBuilder recruiterBuilder;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserAccoutBuilder userAccoutBuilder;
	
	@Autowired
	private UserAccoutRepository userAccoutRepository;
	


//	@Override
//	public void add(RecruiterDto recruiterDto) {
//		if(recruiterRepository.findByEmail(recruiterDto.getEmail()).isPresent()) {
//			throw new RuntimeException("Email is Already Exit");
//		}
//		if(recruiterRepository.findByMobile(recruiterDto.getMobile()).isPresent()) {
//			throw new RuntimeException("Mobile is Already Exit");
//		}
//		recruiterRepository.save(recruiterBuilder.toModel(recruiterDto));
//	}
	@Override
	public void add(RecruiterDto recruiterDto) {
		// Validate required attributes
		validateRequiredAttributes(recruiterDto);

		// Check for existing email and mobile
		if (recruiterRepository.findByEmail(recruiterDto.getEmail()).isPresent()) {
			throw new RuntimeException("Email is Already Exist");
		}
		if (recruiterRepository.findByMobile(recruiterDto.getMobile()).isPresent()) {
			throw new RuntimeException("Mobile is Already Exist");
		}
		
		UserAccout userAccout= new UserAccout();
		List<Role> roles=roleRepository.findAll();
		
		Role role = roles.stream()
                .filter(r -> r.getName().equals("recruiter"))
                .findFirst()
                .orElse(null);
		
		userAccout.setRole(role);
		userAccout.setUserName(recruiterDto.getEmail());
		userAccout.setPassword(recruiterDto.getMobile());
		userAccout.setActive(true);
		recruiterDto.setCreatedTimestamp(LocalDateTime.now());
		recruiterDto.setUserAccout(userAccoutBuilder.toDto(userAccout));
        
		recruiterRepository.saveAndFlush(recruiterBuilder.toModel(recruiterDto));
	}

	public void validateRequiredAttributes(RecruiterDto recruiterDto) {
//		if (recruiterDto == null) {
//			throw new RecruiterValidationException("RecruiterDto cannot be null");
//		}

		if (recruiterDto.getFirstName() == null && recruiterDto.getLastName() == null && recruiterDto.getEmail() == null
				&& recruiterDto.getMobile() == null) {
			throw new RecruiterValidationException("can't be empty");
		}

		if (recruiterDto.getFirstName() != null && recruiterDto.getFirstName().isEmpty()) {
			throw new RecruiterValidationException("FirstName cannot be empty");
		}

		if (recruiterDto.getLastName() != null && recruiterDto.getLastName().isEmpty()) {
			throw new RecruiterValidationException("LastName cannot be empty");
		}

		if (recruiterDto.getEmail() != null && recruiterDto.getEmail().isEmpty()) {
			throw new RecruiterValidationException("Email cannot be empty");
		}


		if (recruiterDto.getMobile() != null) {
			String mobile = recruiterDto.getMobile();
			if (mobile.isEmpty()) {
				throw new RecruiterValidationException("Mobile cannot be empty");
			}
			if (!mobile.matches("\\d{10}")) {
				throw new RecruiterValidationException("Mobile must be 10 digits");
			}
		}
	}


	@Override
	public List<RecruiterDto> findAll() {
		// TODO Auto-generated method stub
		List<RecruiterDto> listDtos = new ArrayList<>();
		List<Recruiter> list = recruiterRepository.findAll();
		if (list != null) {
			list.forEach(recruiter -> {
				listDtos.add(recruiterBuilder.toDto(recruiter));
			});
		}
		return listDtos;
	}

//	@Override
//	public void update(Long id, RecruiterDto recruiterDto) {
//		// TODO Auto-generated method stub
//		Optional<Recruiter> dbRecruiter = recruiterRepository.findById(id);
//		if (dbRecruiter.isPresent()) {
//			recruiterRepository.save(recruiterBuilder.toModel(recruiterDto));
//		}
//	}
	@Override
	public void update(Long id, RecruiterDto recruiterDto) {
	    // Validate required attributes
	    validateRequiredAttributes(recruiterDto);

	    // Check if the recruiter with the given id exists in the database
	    Optional<Recruiter> dbRecruiter = recruiterRepository.findById(id);
	    
	    
	    if (dbRecruiter.isPresent()) {
	        // Update the existing recruiter with the new details
	        Recruiter existingRecruiter = dbRecruiter.get();
	        existingRecruiter.setFirstName(recruiterDto.getFirstName());
	        existingRecruiter.setLastName(recruiterDto.getLastName());
	        existingRecruiter.setEmail(recruiterDto.getEmail());
	        existingRecruiter.setMobile(recruiterDto.getMobile());
	        
	        //in user table also update with this details
	        Long userId = dbRecruiter.get().getUserAccout().getId();
	        Optional<UserAccout> userAccout= userAccoutRepository.findById(userId);
	        if(userAccout.isPresent()) {
	        	UserAccout updateUserAccout =userAccout.get();
	        	updateUserAccout.setUserName(recruiterDto.getEmail());
	        	updateUserAccout.setPassword(recruiterDto.getMobile());
	        	updateUserAccout.setActive(userAccout.get().isActive());
	        	updateUserAccout.setRole(userAccout.get().getRole());
	        	updateUserAccout.setCandidate(userAccout.get().getCandidate());
				
	        	existingRecruiter.setUserAccout(updateUserAccout);
	
	        }
			
			
	        // Save the updated recruiter
	        recruiterRepository.saveAndFlush(existingRecruiter);
	    } else {
	        // If recruiter with the given id does not exist, throw an exception
	        throw new RuntimeException("Recruiter with id " + id + " not found");
	    }
	}


	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		recruiterRepository.deleteById(id);
	}
	
		
	@Override
	public Page<RecruiterDto> getAllRecruiters(Pageable pageable, String code) {
	        Specification<Recruiter> spec = Specification.where(null); // Start with an empty specification

	        if (code != null && !code.isEmpty()) {
	            spec = spec.and(RecruiterSpecifications.hasFields(code));
	        }

	        Page<Recruiter> recruiterPage = recruiterRepository.findAll(spec, pageable);
	        return recruiterPage.map(recruiterBuilder::toDto);
	    }

	@Override
	public Page<RecruiterDto> getAllRecruitersWithPagination(Pageable pageable) {
		Page<Recruiter> recruiterPage = recruiterRepository.findAll(pageable);
        return recruiterPage.map(recruiterBuilder::toDto);
		
	}



}
