package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmploymentTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmploymentTypeDao;
import kodlamaio.hrms.entities.concretes.EmploymentType;

@Service("EmploymentTypeManager")
public class EmploymentTypeManager implements EmploymentTypeService {

	private EmploymentTypeDao employmentDao;
	
	@Autowired
	public EmploymentTypeManager(EmploymentTypeDao employmentDao) {
		super();
		this.employmentDao = employmentDao;
	}

	@Override
	public Result add(EmploymentType employmentType) {
		this.employmentDao.save(employmentType);
		return new SuccessResult("Employment Type Added !");
	}

	@Override
	public DataResult<List<EmploymentType>> getAll() {
		
		
		return new SuccessDataResult<List<EmploymentType>>(this.employmentDao.findAll(),"Types are listed !");
	}

}
