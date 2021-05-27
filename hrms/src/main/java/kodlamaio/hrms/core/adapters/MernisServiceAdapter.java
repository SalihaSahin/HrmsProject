package kodlamaio.hrms.core.adapters;

import java.time.LocalDate;

import kodlamaio.hrms.mernisService.FakeMernisService;

public class MernisServiceAdapter implements UserCheckService{

	@Override
	public boolean checkIfRealPerson(long nationalityId, String firstName, String lastName, LocalDate dateOfBirth) {
		
		FakeMernisService client= new FakeMernisService();
		
		boolean result = client.TCKimlikDogrula(nationalityId, firstName, lastName, dateOfBirth);
		

		return result;
	}

}
