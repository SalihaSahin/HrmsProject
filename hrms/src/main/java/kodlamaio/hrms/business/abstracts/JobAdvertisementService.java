package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService{
	


	DataResult<List<JobAdvertisement>> getByIsActive();

	DataResult<List<JobAdvertisement>> getAllSortedByReleaseDate();

	DataResult<List<JobAdvertisement>> getAllByEmployerId(int employerId);
	
	Result toggleActive(int jobId);
	
	Result toggleVerifiedByEmployee(int jobId);
	
	Result add(JobAdvertisement jobAdvertisement);
	
	Result update(JobAdvertisement jobAdvertisement);
	
	Result delete(JobAdvertisement jobAdvertisement);
}
	

