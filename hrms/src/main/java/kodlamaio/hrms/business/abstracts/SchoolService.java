package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.School;

public interface SchoolService {
	DataResult<List<School>> getAllByCandidateIdOrderByGraduationYear(int candidateId);

	DataResult<List<School>> getAllByCandidateId(int candidateId);
	
	Result add(School school);
	
	Result update(School school);
	
	Result delete(School school);
}
