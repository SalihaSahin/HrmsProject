package kodlamaio.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

@Service("JobAdvertisementManager")
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;
	private ModelMapper modelMapper;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, ModelMapper modelMapper) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		
		this.jobAdvertisementDao.save(jobAdvertisement);
		
		return new SuccessResult("Job Advertisement added !");  
	
	}
	
	
	@Override
	public DataResult<List<JobAdvertisement>> getByIsActive() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActive(),"All active advertisement listed !");
		
	}

	
	@Override
	public DataResult<List<JobAdvertisement>> getAllSortedByReleaseDate() {
	
		Sort sort = Sort.by(Sort.Direction.DESC,"appealDeadline");
				
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort));
		
	}
	

	@Override
	public DataResult<List<JobAdvertisement>>getAllByEmployerId(int employerId) {
		 
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByEmployer_IdAndIsOpenedTrue(employerId));
	}
		
	@Override
	public Result update(JobAdvertisement jobAdvertisement) {
		
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Job Advertisement updated !");
	}
	
	@Override
	public Result delete(JobAdvertisement jobAdvertisement) {
 
		this.jobAdvertisementDao.delete(jobAdvertisement);

		return new SuccessResult("Job Advertisement deleted !");
	}


	@Override
	public Result toggleActive(int jobId) {
		
		JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.findById(jobId);
		if(!isJobAdvertisementExists(jobAdvertisement)) {
			
			return new ErrorResult("Job Advertisement doesn't exists");

		}
		
		jobAdvertisement.setIsActive(!jobAdvertisement.getIsActive());
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Toggled") ;
	}
	
	@Override
	public Result toggleVerifiedByEmployee(int jobId) {
		
		JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.findById(jobId);
		if(!isJobAdvertisementExists(jobAdvertisement)) {
			
			return new ErrorResult("Job Advertisement doesn't exists");

		}
		
		jobAdvertisement.setIsVerifiedByEmployee(true);
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Verified by Employee");
	}

    
	
	
	private boolean isJobAdvertisementExists(JobAdvertisement jobAdvertisement) {
		
		if(jobAdvertisement == null) {
			return false;
		}
		return true;
	}
	
	
	// mapping system is disabled.
	private List<JobAdvertisementDto> dtoGenerator(List<JobAdvertisement> advertisement){
		List<JobAdvertisementDto> jobAdvertisementDtos= new ArrayList<JobAdvertisementDto>(); 
		advertisement.forEach(item -> {
			JobAdvertisementDto dto=modelMapper.map(item, JobAdvertisementDto.class);
			dto.setCompanyName(item.getEmployer().getCompanyName());
			jobAdvertisementDtos.add(dto);
		});
		return jobAdvertisementDtos;
	
	}
	
}
