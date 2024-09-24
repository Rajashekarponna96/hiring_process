package com.mentors.HiringProcess.controller;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
//import org.springdoc.core.converters.models.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mentors.HiringProcess.dto.CandidateDto;
import com.mentors.HiringProcess.model.HiringFlowType;
import com.mentors.HiringProcess.repository.CandidateRepository;
import com.mentors.HiringProcess.repository.EmailTemplateRepository;
import com.mentors.HiringProcess.service.CandidateServiceI;
import com.mentors.HiringProcess.service.EmailService;



@RestController
@RequestMapping(value = "/candidate")
@CrossOrigin
public class CandidateController {
	
	@Autowired
	private CandidateServiceI candidateServiceI;
	
	
	@Autowired
	public CandidateRepository candidateRepository;
	
	@Autowired
	public EmailTemplateRepository emailTemplateRepository;
	
	@Autowired
	public EmailService emailService;
	
	@PostMapping(value = "/")
	public void add(@RequestBody CandidateDto candidateDto) {
		candidateDto.validateREquiredAttibutes(candidateDto);
		candidateServiceI.add(candidateDto);
	}
	//candidate details with resume file name 
	@PostMapping(value = "/add")
	public void addWithCandidateResumeFileName(@RequestBody CandidateDto candidateDto,@RequestParam("file") MultipartFile file) {
		candidateDto.validateREquiredAttibutes(candidateDto);
		candidateServiceI.addWithCandidateResumeFileName(candidateDto,file);
	}
	
	
	@PutMapping(value = "/{id}")
	public void update(@PathVariable Long id,@RequestBody CandidateDto candidateDto) {
		candidateServiceI.update(id,candidateDto);
	}
	
	@GetMapping(value = "/all")
	public List<CandidateDto> getAll() {
		return candidateServiceI.getAll();
	}
	
	@GetMapping(value = "/{id}")
	public CandidateDto findOne(@PathVariable Long id) {
		
		return candidateServiceI.findOne(id);
		
		
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Long id) {
		candidateServiceI.delete(id);
	}
	
	//Filter Api For  candidate
	@GetMapping("/candidates")
    public List<CandidateDto> getCandidatesByCriteria(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String email
//            @RequestParam(required = false) String mobile,
//            @RequestParam(required = false) String alterMobile,
//            @RequestParam(required = false) String source,
//            @RequestParam(required = false) String stage,
//            @RequestParam(required = false) String current
            )
	{
        return candidateServiceI.getCandidatesByCriteria(firstName, lastName, email);
    }
	
	//Globel Search
	@GetMapping("/searchpage")
	public Page<CandidateDto> getAllRecruiters(@RequestParam int page, @RequestParam int size,
	        @RequestParam String code) {
	    //Pageable pageable = PageRequest.of(page, size);
		Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdTimestamp"));
	    return candidateServiceI.getAllCandidates(pageable,code);
	}
	
	
	   //candidate list with pagination
//		@GetMapping("/candidatelistwithpagination")
//		public Page<CandidateDto> getAllCandidatesWithPagination(@RequestParam int page, @RequestParam int size) {
//		    Pageable pageable = PageRequest.of(page, size);
//		    return candidateServiceI.getAllCandidatesWithPagination(pageable);
//		}
	//candidate list with pagination and desc sorting also	
		@GetMapping("/candidatelistwithpagination")
		public Page<CandidateDto> getAllCandidatesWithPaginationAndSort(@RequestParam int page, @RequestParam int size) {
		    Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdTimestamp"));
		    return candidateServiceI.getAllCandidatesWithPaginationAndSort(pageable);
		}
		
		@GetMapping("/inactivecandidatelistwithpagination")
		public Page<CandidateDto> getAllInCandidatesWithPagination(@RequestParam int page, @RequestParam int size) {
		    Pageable pageable = PageRequest.of(page, size);
		    return candidateServiceI.getAllInCandidatesWithPagination(pageable);
		}
		
		@GetMapping("/userid/{id}")
		public CandidateDto getCandidateDetailsByUserId(@PathVariable("id") Long userId) {
			return candidateServiceI.getCandidateDetailsByUserId(userId);
		}
		
		@GetMapping("/candidateStage/{stage}")
		public List<CandidateDto> getCandidatesDettailsByStage(@PathVariable("stage") HiringFlowType stage){
			return candidateServiceI.getCandidatesDettailsByStage(stage);
		}
		
		//candidate list based on stage with pgination
		@GetMapping("/candidateStage1/{stage}")
		public Page<CandidateDto> getCandidatesDettailsByStagewithPagination(@PathVariable("stage")HiringFlowType stage,@RequestParam int page, @RequestParam int size){
//			Pageable pageable = PageRequest.of(page, size);
			 Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdTimestamp"));
			   
			return candidateServiceI.getCandidatesDettailsByStagewithPagination(stage,pageable);
		}
		



}
