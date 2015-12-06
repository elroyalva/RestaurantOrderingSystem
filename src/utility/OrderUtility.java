package utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import bean.DishBean;
import dataSource.DataSource;

public class OrderUtility {

	final static Logger logger = Logger.getLogger(LoginUtility.class);

	public boolean insertOrder(JSONObject jsonObj) {
		int restId = jsonObj.getInt("restID");
		int orderId = getOrderId();
		int tableNo = jsonObj.getInt("tableno");
		JSONArray orders = jsonObj.getJSONArray("orders");
		Map<String, DishBean> ordersMap = new HashMap<String, DishBean>();
		DishBean dish = null;
		JSONObject obj = null;
		int bill = 0;
		for (int i = 0; i < orders.length(); i++) {
			obj = (JSONObject) orders.get(i);
			if (ordersMap.get(obj.getString("text")) != null) {
				DishBean existingDish = ordersMap.get(obj.getString("text"));
				existingDish.setDishCount(existingDish.getDishCount() + 1);
				bill = bill + getCost(existingDish.getDishName(), restId);
			} else {
				dish = new DishBean();
				dish.setDishName(obj.getString("title"));
				dish.setDishId(getDishId(obj.getString("title"), restId));
				dish.setDishCount(1);
				dish.setCategoryId(getCategoryId(obj.getString("category"), restId));
				dish.setMenuId(getMenuId(restId));
				ordersMap.put(obj.getString("text"), dish);
				bill = bill + getCost(dish.getDishName(), restId);
			}
		}

		insertIntoResTable(tableNo,restId);
		boolean commit = false;
		Iterator<Entry<String, DishBean>> it = ordersMap.entrySet().iterator();
		while (it.hasNext()) {
			dish = it.next().getValue();
			commit = insertDish(dish, orderId, restId, tableNo, bill);
		}
		insertIntoOrderBill(orderId,bill);
		return commit;
	}

	private void insertIntoOrderBill(int orderId, int bill) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DataSource.getInstance().getConnection();
			ps = con.prepareStatement(Queries.INSERT_INTO_ORDER_BILL);
			ps.setInt(1, orderId);
			ps.setInt(2, bill);
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.info(e);
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				logger.info(e);
			}
		}
	}

	private void insertIntoResTable(int tableNo, int restId) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DataSource.getInstance().getConnection();
			ps = con.prepareStatement(Queries.INSERT_INTO_RES_TABLE);
			ps.setInt(1, tableNo);
			ps.setInt(2, restId);
			ps.setString(3, "Y");
			ps.setString(4, "N");
			ps.setString(5, "N");
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.info(e);
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				logger.info(e);
			}
		}
	}

	private int getCost(String name, int restId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DataSource.getInstance().getConnection();
			ps = con.prepareStatement(Queries.GET_DISH_COST);
			ps.setString(1, name);
			ps.setInt(2, restId);
			rs = ps.executeQuery();
			if (rs.next()) {
				int retVal = rs.getInt(1);
				return retVal;
			}
			return -1;
		} catch (SQLException e) {
			logger.info(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				logger.info(e);
			}
		}
		return -1;
	}

	private boolean insertDish(DishBean dish, int orderId, int restId, int tableNo, int bill) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DataSource.getInstance().getConnection();
			ps = con.prepareStatement(Queries.INSERT_INTO_FOOD_ORDER);
			ps.setInt(1, orderId);
			ps.setInt(2, restId);
			ps.setInt(3, tableNo);
			ps.setInt(4, dish.getDishId());
			ps.setInt(5, dish.getDishCount());
			ps.setInt(6, dish.getCategoryId());
			ps.setInt(7, dish.getMenuId());
			int commit = ps.executeUpdate();
			if (commit > 0)
				return true;
		} catch (SQLException e) {
			logger.info(e);
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				logger.info(e);
			}
		}
		return false;
	}

	private int getMenuId(int restId) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DataSource.getInstance().getConnection();
			ps = con.prepareStatement(Queries.GET_MENU_ID);
			ps.setInt(1, restId);
			rs = ps.executeQuery();
			if (rs.next()) {
				int retVal = rs.getInt(1);
				return retVal;
			}
			return -1;
		} catch (SQLException e) {
			logger.info(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				logger.info(e);
			}
		}
		return -1;

	}

	private int getCategoryId(String string, int restId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DataSource.getInstance().getConnection();
			ps = con.prepareStatement(Queries.GET_CATEGORY_ID);
			ps.setString(1, string);
			ps.setInt(2, restId);
			rs = ps.executeQuery();
			if (rs.next()) {
				int retVal = rs.getInt(1);
				return retVal;
			}
			return -1;
		} catch (SQLException e) {
			logger.info(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				logger.info(e);
			}
		}
		return -1;
	}

	private int getOrderId() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DataSource.getInstance().getConnection();
			ps = con.prepareStatement(Queries.GET_ORDER_ID);
			rs = ps.executeQuery();
			if (rs.next()) {
				int retVal = rs.getInt(1);
				return retVal + 1;
			}
			con.close();
			return 1;
		} catch (SQLException e) {
			logger.info(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				logger.info(e);
			}
		}
		return 1;
	}

	private int getDishId(String name, int restId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DataSource.getInstance().getConnection();
			ps = con.prepareStatement(Queries.GET_DISH_ID);
			ps.setString(1, name);
			ps.setInt(2, restId);
			rs = ps.executeQuery();
			if (rs.next()) {
				int retVal = rs.getInt(1);
				return retVal;
			}
			return -1;
		} catch (SQLException e) {
			logger.info(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				logger.info(e);
			}
		}
		return -1;
	}

}
