package pack1;

public abstract class Orders {
	private String id;
	private String name;
	private String phone;
	private String meal;
	private String notes;
	private int price;

	public Orders(String id, String name, String phone, String meal, String notes, int price) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.meal = meal;
		this.notes = notes;
		this.price = price;
	}

	public abstract String totalMeal();
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}	

}
