package utility;

public interface Queries {

	String LOGIN_QUERY = "select * from login where username = ? and password = " + "? and type = ?";
	String GET_RESTAURANT_ID_QUERY = "select restaurant_id from login where username=?";
	String GET_RESTAURANT_INFO = "SELECT distinct l.restaurant_id, r.restaurant_name, r.address, r.phone_no, r.email_id, r.tables_count, r.tax, r.image, r.logo FROM Login l INNER JOIN Restaurant r on l.restaurant_id = r.restaurant_id WHERE l.restaurant_id = ?";
	String GET_DISH_INFO = "SELECT distinct m.menu_name, c.category_name, d.dish_id, d.dish_name, d.dish_description, d.dish_cost, d.dish_type, d.image, d.gluten_free FROM Login l INNER JOIN Menu m on l.restaurant_id = m.restaurant_id INNER JOIN Category c on l.restaurant_id = c.restaurant_id INNER JOIN Dish d on l.restaurant_id = d.restaurant_id AND c.category_id = d.category_id WHERE l.restaurant_id = ? ORDER BY c.category_name";
	String GET_MAX_ID = "SELECT MAX(restaurant_id) FROM restaurant";
	String INSERT_INTO_RESTAURANT = "INSERT INTO restaurant values(?,?,?,?,?,?,?,?,?)";
	String INSERT_INTO_LOGIN = "INSERT INTO login values(?,?,?,?)";
	String TABLE_DATA = "SELECT restaurant_id,tables_count FROM restaurant";

}
