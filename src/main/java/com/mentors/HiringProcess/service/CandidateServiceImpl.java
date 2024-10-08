package com.mentors.HiringProcess.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.mentors.HiringProcess.builder.CandidateBuilder;
import com.mentors.HiringProcess.builder.EmailTemplateBuilder;
import com.mentors.HiringProcess.builder.UserAccoutBuilder;
import com.mentors.HiringProcess.builder.VendorBuilder;
import com.mentors.HiringProcess.dto.CandidateDto;
import com.mentors.HiringProcess.dto.TalentPoolDto;
import com.mentors.HiringProcess.dto.VendorDto;
import com.mentors.HiringProcess.model.Candidate;
import com.mentors.HiringProcess.model.EmailTemplate;
import com.mentors.HiringProcess.model.HiringFlowActivity;
import com.mentors.HiringProcess.model.HiringFlowType;
import com.mentors.HiringProcess.model.Role;
import com.mentors.HiringProcess.model.UserAccout;

import com.mentors.HiringProcess.repository.CandidateRepository;
import com.mentors.HiringProcess.repository.EmailTemplateRepository;
import com.mentors.HiringProcess.repository.HiringFlowActivityRepository;
import com.mentors.HiringProcess.repository.RoleRepository;
import com.mentors.HiringProcess.repository.UserAccoutRepository;
import com.mentors.HiringProcess.specification.CandidateSpecifications;

@Service
@Transactional
public class CandidateServiceImpl implements CandidateServiceI {
	private static Logger log = Logger.getGlobal();

	@Autowired
	private CandidateRepository candidateRepository;

	@Autowired
	private CandidateBuilder candidateBuilder;

	@Autowired
	private EmailService emailService;

	@Autowired
    private EmailTemplateRepository  emailTemplateRepository;
	
	@Autowired
	private HiringFlowActivityRepository hiringFlowActivityRepository;

	
	@Autowired
	private UserAccoutRepository userAccoutRepository;
	

	@Autowired
	private EmailTemplateBuilder emailTemplateBuilder;

	@Autowired
	private EmailTemplateServiceImpl emailTemplateServiceImpl;

	@Autowired
	private VendorService vendorService;

	@Autowired
	private VendorBuilder vendorBuilder;
  
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserAccoutBuilder userAccoutBuilder;
	
	@Autowired
	private UserAccoutRepository userRepository;
  
  @Override
	public void add(CandidateDto candidateDto) {
		if(candidateRepository.findByEmail(candidateDto.getEmail()).isPresent()) {
			throw new RuntimeException("Email is Already Exit");
		}
		if(candidateRepository.findByMobile(candidateDto.getMobile()).isPresent()) {
			throw new RuntimeException("Mobile is Already Exit");
		}
		UserAccout userAccout= new UserAccout();
        List<Role> roles=roleRepository.findAll();
		
		Role role = roles.stream()
                .filter(r -> r.getName().equals("candidate"))
                .findFirst()
                .orElse(null);
		
		userAccout.setRole(role);
		userAccout.setUserName(candidateDto.getEmail());
		userAccout.setPassword(candidateDto.getMobile());
		userAccout.setActive(true);
		candidateDto.setUserAccout(userAccoutBuilder.toDto(userAccout));
		candidateDto.setStatus(true);
		candidateDto.setCreatedTimestamp(LocalDateTime.now());
		candidateDto.setStage(HiringFlowType.Sourced);
	    Candidate candidate = candidateBuilder.toModel(candidateDto);
	    List<HiringFlowActivity> hiringFlowActivities =new ArrayList<>();
	    hiringFlowActivities.add(createdHiringFlowDetails(candidate.getStage(),candidate.getModifiedBy(),candidate));
	    
	    candidate.setHiringFlowActivity(hiringFlowActivities);
	  	
		candidateRepository.saveAndFlush(candidate);
		//for email service code
		try {
		String candidateName = candidateDto.getFirstName();
		String uploadDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		EmailTemplate emailTemplate  = emailTemplateRepository.findByTitle(candidateDto.getStage().toString());
		String body=emailTemplate.getBody();
		String updatedBody = body.replace("[CandidateName]", candidateName)
                 .replace("[UploadDate]", uploadDate);
		emailService.sendSimpleMessage(candidateDto.getEmail(), emailTemplate.getSubject(),updatedBody,null, null, null);
		}
		catch (Exception e) {
			log.info("Email sent failure"+e.getMessage());
		}
		
		
	                
	                
		 
	}
  
  
  
  @Override
	public void addWithCandidateResumeFileName(CandidateDto candidateDto, MultipartFile file) {
	  if(candidateRepository.findByEmail(candidateDto.getEmail()).isPresent()) {
			throw new RuntimeException("Email is Already Exit");
		}
		if(candidateRepository.findByMobile(candidateDto.getMobile()).isPresent()) {
			throw new RuntimeException("Mobile is Already Exit");
		}
		UserAccout userAccout= new UserAccout();
      List<Role> roles=roleRepository.findAll();
		
		Role role = roles.stream()
              .filter(r -> r.getName().equals("candidate"))
              .findFirst()
              .orElse(null);
		
		if (candidateDto.getJob() == null) {
	        
			candidateDto.setJob(null);
	    }
		
		userAccout.setRole(role);
		userAccout.setUserName(candidateDto.getEmail());
		userAccout.setPassword(candidateDto.getMobile());
		userAccout.setActive(true);
		candidateDto.setUserAccout(userAccoutBuilder.toDto(userAccout));
		candidateDto.setStatus(true);
		candidateDto.setCreatedTimestamp(LocalDateTime.now());
		candidateDto.setStage(HiringFlowType.Sourced);
		candidateDto.setFileName(file.getOriginalFilename());
	    Candidate candidate = candidateBuilder.toModel(candidateDto);
	    List<HiringFlowActivity> hiringFlowActivities =new ArrayList<>();
	    hiringFlowActivities.add(createdHiringFlowDetails(candidate.getStage(),candidate.getModifiedBy(),candidate));
	    
	    candidate.setHiringFlowActivity(hiringFlowActivities);
	  	
		candidateRepository.saveAndFlush(candidate);
		//for email service code
		try {
		String candidateName = candidateDto.getFirstName();
		String uploadDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		EmailTemplate emailTemplate  = emailTemplateRepository.findByTitle(candidateDto.getStage().toString());
		String body=emailTemplate.getBody();
		String updatedBody = body.replace("[CandidateName]", candidateName)
               .replace("[UploadDate]", uploadDate);
		emailService.sendSimpleMessage(candidateDto.getEmail(), emailTemplate.getSubject(),updatedBody,null, null, null);
		}
		catch (Exception e) {
			log.info("Email sent failure"+e.getMessage());
		}
		
		
	                
	                
		 

		
	}
	
	public HiringFlowActivity  createdHiringFlowDetails(HiringFlowType hiringFlowType,UserAccout userAccount,Candidate candidate) {
		HiringFlowActivity  hiringFlowActivity1=new HiringFlowActivity();
		
		hiringFlowActivity1.setCreatedDate(LocalDateTime.now());
		hiringFlowActivity1.setUserAccount(userAccount);
		hiringFlowActivity1.setHiringFlowType(hiringFlowType);
		hiringFlowActivity1.setCandidate(candidate);
		//hiringFlowActivityRepository.save(hiringFlowActivity1);
		
		
		
		return hiringFlowActivity1;
	}

	@Override
	public void update(Long id, CandidateDto candidateDto) {
		// TODO Auto-generated method stub
		Optional<Candidate> opCandidate = candidateRepository.findById(id);
		if (opCandidate.isPresent()) {
			candidateDto.setModifiedTimestamp(LocalDateTime.now());
			Candidate candidate =candidateBuilder.toModel(candidateDto);
			
			//candidate.setCreatedBy(userAccoutRepository.findById(candidate.getCreatedBy().getId()).get());
			candidate.setModifiedBy(userAccoutRepository.findById(candidate.getModifiedBy().getId()).get());
			HiringFlowType  candidageStage =candidateDto.getStage();
			if (candidageStage.name().equals("Reject")) {
		        candidateDto.setStatus(false);
		        
		    }
			 
			 
			 Candidate candidateDB = opCandidate.get();
			 if(candidateDB.getStage().name() != candidateDto.getStage().name()) {
				 try {
				 String candidateName = candidateDto.getFirstName();
					String uploadDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
					EmailTemplate emailTemplate  = emailTemplateRepository.findByTitle(candidateDto.getStage().toString());
					String body=emailTemplate.getBody();
					String updatedBody = body.replace("[CandidateName]", candidateName)
			                 .replace("[UploadDate]", uploadDate);
					emailService.sendSimpleMessage(candidateDto.getEmail(), emailTemplate.getSubject(),updatedBody,null, null, null);
				 }
				 catch (Exception e) {
					log.info("candidate Stage Update sent mail failure:"+e.getMessage());
				}
					
				 
			 }
				 
				 candidate =candidateRepository.save(candidateBuilder.toModel(candidateDto));
			
			
			 hiringFlowActivityRepository.save(createdHiringFlowDetails(candidate.getStage(),candidate.getModifiedBy(),candidate));
			 
		}
	}



	

  

	@Override
	public List<CandidateDto> getAll() {
		// TODO Auto-generated method stub
		List<CandidateDto> candidateDtos = new ArrayList<>();
		List<Candidate> candidates = candidateRepository.findAll();
		if (candidates != null) {
			candidates.forEach(candidate -> {
				candidateDtos.add(candidateBuilder.toDto(candidate));
			});
		}
		return candidateDtos;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		candidateRepository.deleteById(id);
	}

	@Override
	public CandidateDto findOne(Long id) {
		// TODO Auto-generated method stub
		Optional<Candidate> dbaCandidate = candidateRepository.findById(id);
		if (dbaCandidate.isPresent()) {
			System.out.println("candidate is present-----------");
			return candidateBuilder.toDto(dbaCandidate.get());
		} else {
			return null;
		}
	}

	// Filter Api for canidate
	public List<CandidateDto> getCandidatesByCriteria(String firstName, String lastName, String email) {
		List<CandidateDto> candidateDtoList = new ArrayList<>();
		List<Candidate> candidatelist = candidateRepository.findByCriteria(firstName, lastName, email);
		for (Candidate candidate : candidatelist) {
			CandidateDto candidateDto = candidateBuilder.toDto(candidate);
			candidateDtoList.add(candidateDto);

		}
		return candidateDtoList;
	}

	@Override
	public Page<CandidateDto> getAllCandidates(Pageable pageable, String code) {
		Specification<Candidate> spec = Specification.where(null); // Start with an empty specification

		if (code != null && !code.isEmpty()) {
			spec = spec.and(CandidateSpecifications.hasFields(code));
		}

		Page<Candidate> candidatePage = candidateRepository.findAll(spec, pageable);
		return candidatePage.map(candidateBuilder::toDto);
	}

//	@Override
//	public Page<CandidateDto> getAllCandidatesWithPagination(Pageable pageable) {
//		//Page<Candidate> recruiterPage = candidateRepository.findAll(pageable);
//		Page<Candidate> recruiterPage = candidateRepository.findAllActiveCandidates(pageable);
//		return recruiterPage.map(candidateBuilder::toDto);
//	}
	
	@Override
	public List<CandidateDto> getCandidatesByVendorId(Long vendorId) {
		// Retrieve the Vendor entity based on the vendorId
		Optional<VendorDto> vendorOptional = vendorService.findById(vendorId);
		VendorDto vendorDto = vendorOptional
				.orElseThrow(() -> new RuntimeException("Vendor not found with ID: " + vendorId));

		// Retrieve candidates associated with the vendor
		List<Candidate> candidates = candidateRepository.findByVendor(vendorBuilder.toModel(vendorDto));

		// Convert the list of Candidate entities to a list of CandidateDto objects
		return candidates.stream().map(candidateBuilder::toDto).collect(Collectors.toList());
	}

	@Override
	public Page<CandidateDto> getAllInCandidatesWithPagination(Pageable pageable) {
		Page<Candidate> recruiterPage = candidateRepository.findAllInActiveCandidates(pageable);
		return recruiterPage.map(candidateBuilder::toDto);
	}

	@Override
	public CandidateDto getCandidateDetailsByUserId(Long userId) {
		if(userId !=null) {
			Optional<UserAccout> user = userRepository.findById(userId);
			if(user.isPresent()) {
				String userEmailId = user.get().getUserName();
				if(userEmailId !=null)
				{
					Optional<Candidate> candidate =candidateRepository.findByEmail(userEmailId);
					return candidateBuilder.toDto(candidate.get());
				}
			}
			
		}
	
		return null;
	}

	@Override
	public List<CandidateDto> getCandidatesDettailsByStage(HiringFlowType stage) {
		List<CandidateDto> candidateDtosList = new ArrayList<>();
		if(stage != null) {
			List<Candidate> candidatesList = candidateRepository.findByStage(stage);
		     for (Candidate candidate : candidatesList) {
		    	 if(candidate!=null) {
		    		 CandidateDto candidateDto =candidateBuilder.toDto(candidate);
		    		 candidateDtosList.add(candidateDto);
		    	 }
		    	 
		     }
		     return candidateDtosList;
		}
		
		return null;
	}

	@Override
	public Page<CandidateDto> getCandidatesDettailsByStagewithPagination(HiringFlowType stage, Pageable pageable) {
		
		
		if(stage != null) {
			Page<Candidate> candidatesList = candidateRepository.findByStage(stage,pageable);
		     
		     return candidatesList.map(candidateBuilder::toDto);
		}
		
		return null;
	}

	@Override
	public Page<CandidateDto> getAllCandidatesWithPaginationAndSort(Pageable pageable) {
		Page<Candidate> recruiterPage = candidateRepository.findAllActiveCandidates(pageable);
	    return recruiterPage.map(candidateBuilder::toDto);

	}

	
	

}
