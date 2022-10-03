package pack1;

public class kmeal extends Orders {
	
	private String toy;
	private String milkshake;

	public kmeal(String id, String name, String phone, String meal, String toy, String milkshake, String notes, int price) {
		super(id, name, phone, meal, notes, price);
		this.toy = toy;
		this.milkshake = milkshake;
	}

	@Override
	public String totalMeal() {
		String totalMeal = this.getMeal() + "(" + toy + " + " + milkshake + ")";
		return totalMeal;
	}

}
