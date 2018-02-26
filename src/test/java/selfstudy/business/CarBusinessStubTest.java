package selfstudy.business;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import selfstudy.service.api.CarServiceStub;
import selfstudy.service.api.ICarService;

public class CarBusinessStubTest {
	static CarBusiness carBusiness;
	
	@BeforeClass
	public static void initialize() {
		ICarService carservice = new CarServiceStub();
		carBusiness = new CarBusiness(carservice);
	}

	@Test
	public void carListShouldNotContainNone() {
		List<String> cars = carBusiness.getCarList("Marry");		
		assertThat(cars, not(hasItem("None")));
	}
	
	@Test
	public void carListShouldNotContainEmpty() {
		List<String> cars = carBusiness.getCarList("Marry");		
		assertThat(cars, not(hasItem("")));
	}

}
