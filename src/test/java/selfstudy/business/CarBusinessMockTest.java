package selfstudy.business;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import selfstudy.service.api.ICarService;

public class CarBusinessMockTest {
	static CarBusiness carBusiness;
	
	@BeforeClass
	public static void initialize() {
		ICarService carMockService = mock(ICarService.class);
		
		List<String> cars = Arrays.asList("Toyota", "BMW", "", "None", "Opel", "Volvo");
		when(carMockService.getCarList("Marry")).thenReturn(cars);
		
		carBusiness = new CarBusiness(carMockService);
	}
	
	@Test
	public void carListShouldNotBeEmpty() {
		List<String> cars = carBusiness.getRealCarList("Marry");		
		assertNotEquals(cars.size(), 0);
	}	

	@Test
	public void carListShouldNotContainNone() {
		List<String> cars = carBusiness.getRealCarList("Marry");		
		assertThat(cars, not(hasItem("None")));
	}
	
	@Test
	public void carListShouldNotContainEmpty() {
		List<String> cars = carBusiness.getRealCarList("Marry");		
		assertThat(cars, not(hasItem("")));
	}

}
