package com.mentors.HiringProcess.model;

import java.sql.Blob;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="file_upload")
public class FileUpload {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String fileName;
    
//    private byte[] content;
    
//    @Lob // Use Lob annotation to specify large object data type
//    private Blob content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

//	public Blob getContent() {
//		return content;
//	}
//
//	public void setContent(Blob content) {
//		this.content = content;
//	}

//	public byte[] getContent() {
//		return content;
//	}
//
//	public void setContent(byte[] content) {
//		this.content = content;
//	}
	
	
//    
	
    
	

}
