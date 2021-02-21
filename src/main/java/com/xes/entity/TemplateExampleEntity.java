package com.xes.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@Entity
@Table(name="template_example_test")
@EntityListeners(AuditingEntityListener.class)
public class TemplateExampleEntity {
	
	@Id @GeneratedValue
	private Integer id;
	@Column(name="user_name")
	private String userName;
	private String name;
	private String mobile;
	private String email;
	@CreatedDate
	@Column(name="register_date")
	private LocalDateTime registerDate;
	@LastModifiedDate
	@Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

}
