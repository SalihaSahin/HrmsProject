package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmploymentType;

public interface EmploymentTypeService {
	Result add(EmploymentType employmentType);
	DataResult<List<EmploymentType>> getAll();
}
