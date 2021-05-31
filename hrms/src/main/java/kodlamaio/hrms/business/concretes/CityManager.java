package kodlamaio.hrms.business.concretes;

import java.util.List;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.entities.concretes.City;

public class CityManager implements CityService{

	private CityDao cityDao;
	
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao=cityDao;
	}
	
	@Override
	public DataResult<List<City>> getAll() {
		
		return new SuccessDataResult<List<City>>(this.cityDao.findAll());
	}

	@Override
	public DataResult<City> getCityById(int cityId) {
	
		return new SuccessDataResult<City>(this.cityDao.getOne(cityId));
	}

}
