package pack1;

public class vmeal extends Orders {
	private String drink;
	private String carbo;

	public vmeal(String id, String name, String phone, String meal, String carbo, String drink, String notes, int price) {
		super(id, name, phone, meal, notes, price);
		this.drink = drink;
		this.carbo = carbo;
	}

	@Override
	public String totalMeal() {
		String totalMeal = this.getMeal() + "(" + drink + " + " + carbo + ")";
		return totalMeal;
	}

	

}
