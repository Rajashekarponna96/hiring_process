package com.mentors.HiringProcess.dto;

public class JobSummaryDto {
	  private String title;
	    private long openings;

	    // Constructor, getters, and setters
	    public JobSummaryDto(String title, long openings) {
	        this.title = title;
	        this.openings = openings;
	    }

	    // Getters and setters
	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public long getOpenings() {
	        return openings;
	    }

	    public void setOpenings(long openings) {
	        this.openings = openings;
	    }
}
