package junit;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import bean.DishBean;
import bean.RestaurantBean;
import utility.RestaurantUtility;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JunitRestaurantUtilityTesting {

	RestaurantUtility resUtility;
	RestaurantBean rBean;
	List<DishBean> dish;
	String username;
	int restaurantid;

	@Before
	public void setUp() {
		resUtility = new RestaurantUtility();
		username = "Starbucks";
		restaurantid = 45;
	}

	@Test
	public void Test4Menu() {
		String json = resUtility.getMenu(username);
		assertNotNull(json);
		// assertEquals(json, "");
	}

	@Test
	public void Test1getDish()  {
		dish = resUtility.getDishes(restaurantid);
		assertNotNull(dish);

	}

	@Test
	public void Test2getRestaurantInfo()  {
		rBean = resUtility.getRestaurantInfo(restaurantid);
		assertNotNull(rBean);
	}

	@Test
	public void Test3getJSON()  {
		dish = resUtility.getDishes(restaurantid);
		rBean = resUtility.getRestaurantInfo(restaurantid);
		String url = resUtility.getJSON(rBean, dish);
		assertNotNull(url);
		// assertEquals(url , "");
	}

}
