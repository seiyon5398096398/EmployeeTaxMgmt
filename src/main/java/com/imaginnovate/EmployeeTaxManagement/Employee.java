package com.imaginnovate.EmployeeTaxManagement;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long eid;
	
	@NotNull(message = "firstName is mandatory")
	private String firstname;
	
	@NotNull(message = "lastName is mandatory")
	private String lastname;
	
	@NotNull(message = "email is mandatory")
	@Email(message = "email should be valid")
	private String email;
	
	@NotEmpty(message = "Atlease one mobile number is mandatory")
	private List<Long> phonenumber;
	
	@NotNull(message = "Date of joining is mandatory")
	@Past(message = "Doj should be past date")
	private Date doj;
	
	@NotNull(message = "Salary should not be null")
	@Positive(message = "salary must be a natural number")
	private Long salary;
	
	
	
	public Employee() {
		super();
	}



	public Employee(Long eid, @NotNull(message = "firstName is mandatory") String firstname,
			@NotNull(message = "lastName is mandatory") String lastname,
			@NotNull(message = "email is mandatory") @Email(message = "email should be valid") String email,
			@NotEmpty(message = "Atlease one mobile number is mandatory") List<Long> phonenumber,
			@NotNull(message = "Date of joining is mandatory") @Past(message = "Doj should be past date") Date doj,
			@NotNull(message = "Salary should not be null") @Positive(message = "salary must be a natural number") Long salary) {
		super();
		this.eid = eid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phonenumber = phonenumber;
		this.doj = doj;
		this.salary = salary;
	}



	public Long getEid() {
		return eid;
	}



	public void setEid(Long eid) {
		this.eid = eid;
	}



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public List<Long> getPhonenumber() {
		return phonenumber;
	}



	public void setPhonenumber(List<Long> phonenumber) {
		this.phonenumber = phonenumber;
	}



	public Date getDoj() {
		return doj;
	}



	public void setDoj(Date doj) {
		this.doj = doj;
	}



	public Long getSalary() {
		return salary;
	}



	public void setSalary(Long salary) {
		this.salary = salary;
	}



	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", phonenumber=" + phonenumber + ", doj=" + doj + ", salary=" + salary + "]";
	}
	
	
}
