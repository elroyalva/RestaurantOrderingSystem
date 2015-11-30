package utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import bean.DishBean;
import bean.RestaurantBean;
import dataSource.DataSource;

public class RestaurantUtility {

	final String newLine = System.lineSeparator();
	final String tab = "\t";
	final static Logger logger = Logger.getLogger(RestaurantUtility.class);

	public String getMenu(String userName) {
		LoginUtility loginUtility = new LoginUtility();
		String JSON = null;
		try {
			int restaurantId = loginUtility.getRestaurantId(userName);
			RestaurantBean rest = getRestaurantInfo(restaurantId);
			List<DishBean> dishes = getDishes(restaurantId);
			JSON = getJSON(rest, dishes);
		} catch (Exception e) {
			logger.error("Exception :" + e.getStackTrace());
			logger.error("Message :" + e.getMessage());
			logger.info(e);
		}
		return JSON;
	}

	public String getJSON(RestaurantBean rest, List<DishBean> dishes) {
		StringBuilder str = new StringBuilder();
		str.append("{" + newLine);
		str.append(tab + "\"admin\": true," + newLine);
		str.append(tab + "\"id\":" + rest.getId() + "," + newLine);
		str.append(tab + "\"name\": \"" + rest.getName() + "\"," + newLine);
		str.append(tab + "\"address\": \"" + rest.getAddress() + "\"," + newLine);
		str.append(tab + "\"phoneNumber\": \"" + rest.getPhone() + "\"," + newLine);
		str.append(tab + "\"tablesCount\": \"" + rest.getTableCount() + "\"," + newLine);
		str.append(tab + "\"tax\": \"" + rest.getTax() + "\"," + newLine);
		str.append(tab + "\"image\": \"" + rest.getImage() + "\"," + newLine);
		str.append(tab + "\"logo\": \"" + rest.getLogo() + "\"," + newLine);
		str.append(tab + "\"menu\": [");
		appendDishes(dishes, str);
		str.append(tab + "]" + newLine);
		str.append("}");
		return str.toString();
	}

	private void appendDishes(List<DishBean> dishes, StringBuilder str) {
		for (DishBean dish : dishes) {
			appendSingleDish(str, dish);
		}
	}

	private void appendSingleDish(StringBuilder str, DishBean dish) {
		str.append(newLine + tab + tab + "{" + newLine);
		str.append(tab + tab + tab + "\"name\":\"" + dish.getDishName() + "\"," + newLine);
		str.append(
				tab + tab + tab + "\"veg\":\"" + ("V".equals(dish.getDishType()) ? "true" : "false") + "\"," + newLine);
		str.append(tab + tab + tab + "\"price\":\"" + dish.getDishCost() + "\"," + newLine);
		str.append(tab + tab + tab + "\"id\":\"" + dish.getDishId() + "\"," + newLine);
		str.append(tab + tab + tab + "\"description\":\"" + dish.getDishDesc() + "\"," + newLine);
		str.append(tab + tab + tab + "\"category\":\"" + dish.getCategoryName() + "\"," + newLine);
		str.append(tab + tab + tab + "\"image\":\"" + dish.getImage() + "\"," + newLine);
		str.append(tab + tab + tab + "\"glutenfree\":" + ("Y".equals(dish.getGlutenFree()) ? "true," : "false,")
				+ newLine);
		str.append(tab + tab + "},");
	}

	public List<DishBean> getDishes(int restaurantId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			List<DishBean> dishes = new ArrayList<DishBean>();
			con = DataSource.getInstance().getConnection();
			ps = con.prepareStatement(Queries.GET_DISH_INFO);
			ps.setInt(1, restaurantId);
			rs = ps.executeQuery();
			while (rs.next()) {
				DishBean dish = new DishBean();
				dish.setMenuName(rs.getString("m.menu_name"));
				dish.setCategoryName(rs.getString("c.category_name"));
				dish.setDishId(rs.getInt("d.dish_id"));
				dish.setDishName(rs.getString("d.dish_name"));
				dish.setDishDesc(rs.getString("d.dish_description"));
				dish.setDishCost(rs.getInt("d.dish_cost"));
				dish.setDishType(rs.getString("d.dish_type"));
				dish.setImage(rs.getString("d.image"));
				dish.setGlutenFree(rs.getString("d.gluten_free"));
				dishes.add(dish);
			}
			return dishes;
		} catch (SQLException e) {
			logger.info(e);
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				logger.info(e);
			}
		}
		return new ArrayList<DishBean>();
	}

	public RestaurantBean getRestaurantInfo(int restaurantId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			RestaurantBean bean = new RestaurantBean();
			con = DataSource.getInstance().getConnection();
			ps = con.prepareStatement(Queries.GET_RESTAURANT_INFO);
			ps.setInt(1, restaurantId);
			rs = ps.executeQuery();
			if (rs.next()) {
				bean.setId(rs.getInt("l.restaurant_id"));
				bean.setName(rs.getString("r.restaurant_name"));
				bean.setAddress(rs.getString("r.address"));
				bean.setPhone(rs.getString("r.phone_no"));
				bean.setEmail(rs.getString("r.email_id"));
				bean.setTableCount(rs.getInt("r.tables_count"));
				bean.setTax(rs.getInt("r.tax"));
				bean.setImage(rs.getString("r.image"));
				bean.setLogo(rs.getString("r.logo"));
			}
			return bean;
		} catch (SQLException e) {
			logger.info(e);
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				logger.info(e);
			}
		}
		return null;
	}

}
