package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.VerificationCode;

public interface VerificationDao  extends JpaRepository<VerificationCode,Integer> {

	VerificationCode findByUserIdAndVerificationCode(int userId, String verificationCode);   //  mapleme isimlendirme ile yapıyor.


}
