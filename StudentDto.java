package com.shashi.restservice.dto;

import java.io.Serializable;

/**
 * author:Ganesh
 */
public class StudentDto implements Serializable {

	
	private static final long serialVersionUID = -7471233423487474477L;
	
	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private String branch;
	
	public StudentDto() {
	}

	public StudentDto(Integer id, String firstName, String lastName, String branch) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.branch = branch;
	}
	
	

}
