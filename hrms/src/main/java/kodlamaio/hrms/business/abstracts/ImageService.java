package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Image;

public interface ImageService {

	DataResult<Image> getByCandidateId(int candidateId);
	
	DataResult<List<Image>> getAll();
	
	DataResult<Image> getById(int id);
	
	Result add(Image image,  MultipartFile imageFile);
	 
	Result update(Image image);
	
	Result delete(Image image);
}
