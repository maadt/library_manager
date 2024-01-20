package com.example.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "LOGS")
public class Log {
	
	@Id
	@SequenceGenerator(name = "LOG_ID_GENERATOR", sequenceName = "LOG_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOG_ID_GENERATOR")
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "LIBRARY_ID")
	private Integer libraryId;
	
	@Column(name = "USER_ID")
	private Integer userId;
	
	@Column(name = "RENT_DATE")
	private Date rentDate;
	
	@Column(name = "RETURN_DATE")
	private Date returnDate;
	
	@Column(name = "RETURN_DUE_DATE")
	private Date returnDueDate;
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getLibraryId() {
		return this.libraryId;
	}
	
	public void setLibraryId(Integer libraryId) {
		this.libraryId = libraryId;
	}
	
	public Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Date getRentDate() {
		return this.rentDate;
	}
	
	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}
	
	public Date getReturnDate() {
		return this.returnDate;
	}
	
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
	public Date getReturnDueDate() {
		return this.returnDueDate;
	}
	
	public void setReturnDueDate(Date returnDueDate) {
		this.returnDueDate = returnDueDate;
	}
}
