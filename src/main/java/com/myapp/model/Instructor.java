package com.myapp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Instructor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@ManyToMany
	@JoinTable(
			name="instructor_course",
			joinColumns=@JoinColumn(name="instructor_id",referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="course_id",referencedColumnName="id"))
	private List<Course> course;
	

}
