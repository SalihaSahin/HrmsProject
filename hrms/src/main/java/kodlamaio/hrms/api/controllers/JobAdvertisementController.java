package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

@RestController

@RequestMapping("api/jobadvertisements")
@CrossOrigin
public class JobAdvertisementController {
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
 

	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	
	@GetMapping("/getByIsActive")
	public DataResult<List<JobAdvertisement>> getByIsActive(){
		
		return this.jobAdvertisementService.getByIsActive();
	}
	
	
	@GetMapping("/getByAppealDeadline")
	public DataResult<List<JobAdvertisement>> getByAppealDeadline(){
		
		return this.jobAdvertisementService.getAllSortedByReleaseDate();
	}
	
	
	@GetMapping("/getAllOpenedPositionByCompanyName")
	public DataResult<List<JobAdvertisement>> getAllOpenedPositionByCompanyName(@RequestParam("employerId") int employerId){
		
		return this.jobAdvertisementService.getAllByEmployerId(employerId);
				
	
	}

	@GetMapping("/employeeVerified")
	public Result toggleVerifiedByEmployee(@RequestParam int jobAdvertisementId) {
		
		return this.jobAdvertisementService.toggleVerifiedByEmployee(jobAdvertisementId);
	}
	
	
	@GetMapping("/toggleactive")
	public Result update(@RequestParam int jobAdvertisementId) {
		return this.jobAdvertisementService.toggleActive(jobAdvertisementId);
	}
	

	@PostMapping("/update")  // yanl????. ama ??imdilik kals??n.
	public Result update(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.update(jobAdvertisement);
	}

	//TODO test et
	@PostMapping("/delete")
	public Result delete(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.delete(jobAdvertisement);
	}
	

}
