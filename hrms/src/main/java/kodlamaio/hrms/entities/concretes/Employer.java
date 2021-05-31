package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employers")
@PrimaryKeyJoinColumn(name="user_id",referencedColumnName = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
@EqualsAndHashCode(callSuper=false) 
public class Employer extends User{
	
	@Column(name="web_site")
	private String webSite;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="is_email_verfied")
	private Boolean isEmailVerified;
	
	@Column(name="is_verfied_by_employee")
	private Boolean is_verfied_by_employee;
	
	@Column(name="company_name")
	private String companyName;

	 @OneToMany(mappedBy="employer")
     private List<JobAdvertisement> jobAdvertisements;
}
