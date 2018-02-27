package selfstudy.business;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import selfstudy.service.api.ICarService;

public class CarBusinessMockTest {
	@Test
	public void carListShouldNotBeEmpty() {
		ICarService carMockService = mock(ICarService.class);
		
		List<String> carActualList = Arrays.asList("Toyota", "BMW", "", "None", "Opel", "Volvo");
		when(carMockService.getCarList("Marry")).thenReturn(carActualList);
		
		CarBusiness carBusiness = new CarBusiness(carMockService);		
		
		List<String> cars = carBusiness.getRealCarList("Marry");		
		assertNotEquals(cars.size(), 0);
	}	
	
	@Test
	public void carListShouldBeEmpty() {
		ICarService carMockService = mock(ICarService.class);
		
		List<String> carActualList = Arrays.asList();
		when(carMockService.getCarList("Marry")).thenReturn( carActualList);
		
		CarBusiness carBusiness = new CarBusiness(carMockService);		
		
		List<String> cars = carBusiness.getRealCarList("Marry");		
		assertEquals(cars.size(), 0);
	}		

	@Test
	public void carListShouldNotContainNone() {		
		ICarService carMockService = mock(ICarService.class);
		
		List<String> carActualList = Arrays.asList("Toyota", "BMW", "", "None", "Opel", "Volvo");
		when(carMockService.getCarList("Marry")).thenReturn(carActualList);
		
		CarBusiness carBusiness = new CarBusiness(carMockService);	
		
		List<String> cars = carBusiness.getRealCarList("Marry");		
		assertThat(cars, not(hasItem("None")));
	}
	
	@Test
	public void carListShouldNotContainEmpty() {
		ICarService carMockService = mock(ICarService.class);
		
		List<String> carActualList = Arrays.asList("Toyota", "BMW", "", "None", "Opel", "Volvo");
		when(carMockService.getCarList("Marry")).thenReturn(carActualList);
		
		CarBusiness carBusiness = new CarBusiness(carMockService);			
		
		List<String> cars = carBusiness.getRealCarList("Marry");		
		assertThat(cars, not(hasItem("")));
	}

}
