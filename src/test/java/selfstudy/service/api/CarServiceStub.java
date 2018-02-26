package selfstudy.service.api;

import java.util.Arrays;
import java.util.List;

public class CarServiceStub implements ICarService {

	public List<String> getCarList(String owner) {
		return Arrays.asList("Toyota", "BMW", "", "None", "Opel", "Volvo");
	}

}
