package com.mentors.HiringProcess.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mentors.HiringProcess.model.Recruiter;
import com.mentors.HiringProcess.model.Role;
import com.mentors.HiringProcess.model.UserAccout;
import com.mentors.HiringProcess.repository.RecruiterRepository;
import com.mentors.HiringProcess.repository.RoleRepository;
import com.mentors.HiringProcess.repository.UserAccoutRepository;
@Component
public class DatabaseRunner implements CommandLineRunner{
	
	@Autowired
	private RecruiterRepository recruiterRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		
		List<Recruiter> recruiters = (List<Recruiter>) recruiterRepository.findAll();
		if (recruiters == null || recruiters.isEmpty()) {
        List<String> all = new ArrayList<String>();
	    all.add("All");
	    
	    Role role=new Role();
	    role.setName("Admin");
	    role.setDescription("testing");
		
		UserAccout userAccount=new UserAccout();
		userAccount.setUserName("admin");
		userAccount.setPassword("1234");
		userAccount.setActive(true);
		userAccount.setRole(role);
		
		Recruiter recruiter=new Recruiter();
		recruiter.setFirstName("Recruirer");
		recruiter.setLastName("Rec_lastname");
		recruiter.setEmail("recruiter@gmail.com");
		recruiter.setMobile("0123456789");
		recruiter.setUserAccout(userAccount);
		recruiterRepository.save(recruiter);
		}	
		
		
		}
			
	
}
