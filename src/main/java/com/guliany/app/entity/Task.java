package com.guliany.app.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "tasks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Size(min = 2, max = 15, message = "Name must be 2-15 characters long")
	@Column(name = "name")
	private String name;
	@Size(min = 6, message = "Description must be at least 6 Characters long")
	@Column(name = "description")
	private String description;
	@CreationTimestamp
	@Column(name="created", updatable = false)
	private LocalDateTime created;
	@UpdateTimestamp
	@Column(name="updated")
	private LocalDateTime updated;
	
}
