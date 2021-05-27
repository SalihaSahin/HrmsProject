package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobTitle;
//interface interface i extend eder
//Crud operasyonları hazırlandı.
public interface JobTitleDao extends JpaRepository<JobTitle, Integer>{
	JobTitle findByTitleName(String titleName);
}
