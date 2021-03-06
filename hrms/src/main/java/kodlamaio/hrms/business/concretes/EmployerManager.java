package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service("EmployerManager")
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}

	

	@Override
	public DataResult<Employer> getByEmail(String email) {
		
		return new SuccessDataResult<Employer>(this.employerDao.findByEmail(email));
	}
	
	@Override
	public Result add(Employer employer) {
		if(!this.checkIfEmailExists(employer.getEmail())) {
			return new ErrorResult("Email already exist... ");
		}
	
		if(!this.checkIfEqualEmailAndDomain(employer.getEmail(),employer.getWebSite())) {
			return new ErrorResult("Invalid mail adress...");
	}
		
		// TODO hrms person verification.
		
		this.employerDao.save(employer);
		return new SuccessResult("Employer added !");
	}
	
	@Override
	public Result update(Employer employer) {
        
		this.employerDao.save(employer);
		return new SuccessResult("Employer updated !");
	}

	@Override
	public Result delete(Employer employer) {
		this.employerDao.delete(employer);
		return new SuccessResult("Employer deleted !");
	}
	
	
	private boolean checkIfEmailExists(String email) {
		if(this.employerDao.findByEmail(email) !=null) {
			return false;
		}
		return true;
		
	}
	

	private boolean checkIfEqualEmailAndDomain(String email, String website) {
		String[] emailArr = email.split("@", 2);
		String domain = website.substring(4, website.length());

		if (emailArr[1].equals(domain)) {

			return true;
		}

		return false;
	}

	@Override
	public DataResult<Employer> getById(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Employer>(this.employerDao.findById(id).orElse(null));
	}
}
