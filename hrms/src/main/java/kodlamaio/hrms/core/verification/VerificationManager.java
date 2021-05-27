package kodlamaio.hrms.core.verification;

import java.util.UUID;

public class VerificationManager implements VerificationService{

	@Override
	public void sendVerificationCode(String email) {
		UUID uuid = UUID.randomUUID();
		String verificationLink = "https://hrmsverificationmail/" + uuid.toString();
	}

	@Override
	public String codeGenerator() {//TODO tekrar düzenlenecek
		UUID uuid = UUID.randomUUID();
		String verificationCode = uuid.toString();
		return verificationCode;
	}

}
