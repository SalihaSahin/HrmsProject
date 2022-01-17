package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.School;

@RestController

@RequestMapping("api/schools")
@CrossOrigin
public class SchoolsController {

	
	private SchoolService schoolService;

	@Autowired
	public SchoolsController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	@PostMapping("/add")
	public Result add(@RequestBody School school) {
		
		return this.schoolService.add(school);
	}
	
	//TODO test edilecek
	
	@PostMapping("/update")
	public Result update(@RequestBody School school) {
		
		return this.schoolService.update(school);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody School school) {
		
		return this.schoolService.delete(school);
	}
}