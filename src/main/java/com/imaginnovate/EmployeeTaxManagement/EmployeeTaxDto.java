package com.imaginnovate.EmployeeTaxManagement;

public class EmployeeTaxDto {
	
	private Long eid;
    private String firstname;
    private String lastname;
    private long yearlysalary;
    private double taxamount;
    private double cessamount;
    
    
	public EmployeeTaxDto() {
		super();
	}


	public EmployeeTaxDto(Long eid, String firstname, String lastname, long yearlysalary, double taxamount,
			double cessamount) {
		super();
		this.eid = eid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.yearlysalary = yearlysalary;
		this.taxamount = taxamount;
		this.cessamount = cessamount;
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


	public long getYearlysalary() {
		return yearlysalary;
	}


	public void setYearlysalary(long yearlysalary) {
		this.yearlysalary = yearlysalary;
	}


	public double getTaxamount() {
		return taxamount;
	}


	public void setTaxamount(double taxamount) {
		this.taxamount = taxamount;
	}


	public double getCessamount() {
		return cessamount;
	}


	public void setCessamount(double cessamount) {
		this.cessamount = cessamount;
	}


	@Override
	public String toString() {
		return "EmployeeTaxDto [eid=" + eid + ", firstname=" + firstname + ", lastname=" + lastname + ", yearlysalary="
				+ yearlysalary + ", taxamount=" + taxamount + ", cessamount=" + cessamount + "]";
	}
    


}
