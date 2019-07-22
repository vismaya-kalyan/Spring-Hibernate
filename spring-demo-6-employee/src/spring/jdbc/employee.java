package spring.jdbc;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity()
@Table(name="employee")
public class employee {
	@Id
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="company")
	private String company;
	
	@Column(name="date_of_birth")
    @Temporal(TemporalType.DATE)    
    private Date dateOfBirth;
	
	public employee() {
		
	}
	
	

	public employee(String firstName, String lastName, Date dateOfBirth, String company) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
		this.dateOfBirth = dateOfBirth;
	}



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "employee [firstName=" + firstName + ", lastName=" + lastName + ", company=" + company + ", dateOfBirth="
				+ dateOfBirth + "]";
	}

	
	
}
