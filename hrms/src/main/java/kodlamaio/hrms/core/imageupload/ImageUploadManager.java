package kodlamaio.hrms.core.imageupload;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;

public class ImageUploadManager implements ImageUploadService{
	 
	
		private Cloudinary cloudinary;

		@Autowired // beanden alıyor buraya yapıştırıyor.
		public ImageUploadManager(Cloudinary cloudinary) {
	         
			this.cloudinary =cloudinary;
		}

		@Override
		public DataResult<Map> uploadImageFile(MultipartFile imageFile) {
	        
			try {
				@SuppressWarnings("unchecked")
				Map<String,String> resultMap =(Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());
				
				return new SuccessDataResult<Map>(resultMap);
			} catch (IOException e) {
				
				e.printStackTrace();
			}

			return new ErrorDataResult<Map>("Cannot added !");
		}

}
