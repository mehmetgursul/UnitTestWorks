package selfstudy.business;

import java.util.ArrayList;
import java.util.List;

import selfstudy.service.api.ICarService;

// CarBusiness is System Under Test
// ICarService dependency
public class CarBusiness {
	private ICarService carService;

	public CarBusiness(ICarService carService) {
		this.carService = carService;
	}

	public List<String> getRealCarList(String owner) {
		List<String> filteredCars = new ArrayList<String>();
		List<String> cars = this.carService.getCarList(owner);
		
		for (String car: cars)
		{
			if (!car.isEmpty() && !car.contains("None"))
			{
				filteredCars.add(car);
			}				
		}
		
		return filteredCars;
	}

}
