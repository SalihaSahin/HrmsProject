package kodlamaio.hrms.core.verification;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("VerificationManager")
public class VerificationManager implements VerificationService{

	
	@Override
	public void sendVerificationCode(String email) {
		UUID uuid = UUID.randomUUID();
		String verificationLink = "https://hrmsverificationmail/" + uuid.toString();
	}

	@Override
	public String codeGenerator() {
		UUID uuid = UUID.randomUUID();
		String verificationCode = uuid.toString();
		return verificationCode;
	}

}
