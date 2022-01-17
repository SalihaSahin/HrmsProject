package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Skill;

public interface SkillService {

	Result add(Skill skill);
	
	Result update(Skill skill);
	
	Result delete(Skill skill);
	
	DataResult<List<Skill>> getAllByCandidateId(int candidateId);
}
