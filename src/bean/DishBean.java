package bean;

public class DishBean {

	String menuName;
	String categoryName;
	int dishId;
	String dishName;
	String dishDesc;
	int dishCost;
	String dishType;
	String image;
	String glutenFree;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getGlutenFree() {
		return glutenFree;
	}

	public void setGlutenFree(String glutenFree) {
		this.glutenFree = glutenFree;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getDishId() {
		return dishId;
	}

	public void setDishId(int dishId) {
		this.dishId = dishId;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public String getDishDesc() {
		return dishDesc;
	}

	public void setDishDesc(String dishDesc) {
		this.dishDesc = dishDesc;
	}

	public int getDishCost() {
		return dishCost;
	}

	public void setDishCost(int dishCost) {
		this.dishCost = dishCost;
	}

	public String getDishType() {
		return dishType;
	}

	public void setDishType(String dishType) {
		this.dishType = dishType;
	}

}
