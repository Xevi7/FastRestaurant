package pack1;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	Scanner scan = new Scanner(System.in);
	
	void cls() {
		for(int i = 0; i < 30; i++) {
			System.out.println();
		}
	}

	void view(Vector<Orders> ordersVec) {
		if(ordersVec.isEmpty()) {
			System.out.println("No Order");
			System.out.println();
			return;
		}
		
		System.out.println("=====================================================================================================================");
		System.out.println("| Order ID | Customer Name  | Customer Phone | Meal                                     | Price   | Notes           |");
		System.out.println("=====================================================================================================================");
		for (Orders orders : ordersVec) {			
			System.out.printf("| %-8s | %-14s | %-14s | %-40s | %-7d | %-15s |\n", orders.getId(), orders.getName(), orders.getPhone(), orders.totalMeal(), orders.getPrice(), orders.getNotes());
		}
		System.out.println("=====================================================================================================================");
		System.out.println();
	}
	
	void menu1(Vector<Orders> ordersVec) {
		String tempName;
		do {
			System.out.print("Input Customer Name [Must not empty] : ");
			tempName = scan.nextLine();
		}while(tempName.isEmpty());
		
		String tempPhone;
		do {
			System.out.print("Input Customer Phone [Must not empty] : ");
			tempPhone = scan.nextLine();
		}while(tempPhone.isEmpty());
		
		String tempMeal;
		do {
			System.out.print("Choose Meal [Value Meal | Kids Meal] [Case Insensitive] : ");
			tempMeal = scan.nextLine();
		}while(!tempMeal.equalsIgnoreCase("Value Meal") && !tempMeal.equalsIgnoreCase("Kids Meal"));
		
		String tempIncludes = "";
		if(tempMeal.equalsIgnoreCase("Value Meal")) {
			do {
				System.out.print("Choose Drink [Coca Cola | Teh Botol | RB Float] [Case Sensitive] : ");
				tempIncludes = scan.nextLine();				
			}while(!tempIncludes.equals("Coca Cola") && !tempIncludes.equals("Teh Botol") && !tempIncludes.equals("RB Float"));
		}
		else if(tempMeal.equalsIgnoreCase("Kids Meal")) {
			do {
				System.out.print("Choose Extra Toy [Iron Man | Captain America | Spider Man] [Case Sensitive] : ");
				tempIncludes = scan.nextLine();				
			}while(!tempIncludes.equals("Iron Man") && !tempIncludes.equals("Captain America") && !tempIncludes.equals("Spider Man"));
		}
		
		String tempExtras = "";
		int tempPrice = 0;
		if(tempMeal.equalsIgnoreCase("Value Meal")) {
			do {
				System.out.print("Choose Between [Rice | French Fries] [Case Sensitive] : ");
				tempExtras = scan.nextLine();				
			}while(!tempExtras.equals("Rice") && !tempExtras.equals("French Fries"));
			
			if(tempExtras.equals("Rice")) {
				tempPrice = 17000;
			}
			else if(tempExtras.equals("French Fries")) {
				tempPrice = 22000;
			}
		}
		else if(tempMeal.equalsIgnoreCase("Kids Meal")) {
			do {
				System.out.print("Choose Milkshake [Chocolate | Strawberry | Vanilla] [Case Sensitive] : ");
				tempExtras = scan.nextLine();				
			}while(!tempExtras.equals("Chocolate") && !tempExtras.equals("Strawberry") && !tempExtras.equals("Vanilla"));
			tempPrice = 20000;
		}
		
		String tempNotes = "";
		System.out.print("Input Notes : ");
		tempNotes = scan.nextLine();
		
		String tempId = "OR";
		Random rand = new Random();
		Integer numId;
		for(int i = 0; i < 3; i++) {
			numId = rand.nextInt(10);
			tempId += numId.toString();
		}
		
		if(tempMeal.equalsIgnoreCase("Value Meal")) {			
			ordersVec.addElement(new vmeal(tempId, tempName, tempPhone, tempMeal, tempExtras, tempIncludes, tempNotes, tempPrice));
		}
		else if(tempMeal.equalsIgnoreCase("Kids Meal")) {
			ordersVec.addElement(new vmeal(tempId, tempName, tempPhone, tempMeal, tempIncludes, tempExtras, tempNotes, tempPrice));			
		}
		System.out.println("Success Order");
	}
	
	int idxSearch(Vector<Orders> ordersVec, String id) {
		if(id.length() > 5) {
			return -1;
		}
		
		int idx = 0;
		
		for (Orders orders : ordersVec) {
			if(orders.getId().equals(id)) {
				return idx;
			}
			idx += 1;
		}
		
		return -1;
	}
	
	void menu2(Vector<Orders> ordersVec) {
		if(ordersVec.isEmpty()) {
			System.out.println("No Order");
			System.out.println();
			return;
		}
		view(ordersVec);
		
		String tempId;
		int idx;
		do {
			System.out.print("Choose Order to be proceed [Case Sensitive | 'Cancel' to cancel] : ");
			tempId = scan.nextLine();
			idx = idxSearch(ordersVec, tempId);
		}while(idx == -1 && !tempId.equals("Cancel"));
		
		if(!tempId.equals("Cancel")) {
			ordersVec.remove(idx);
			System.out.println("Succeed Proceed Order " + tempId);
		}
	}
	
	public Main() {
		int put;
		Vector<Orders> ordersVec = new Vector<>();
		
		do {
			cls();
			view(ordersVec);
			System.out.println("Fast Restaurant");
			System.out.println("1. Order");
			System.out.println("2. Proceed Order");
			System.out.println("3. Exit");
			do {
				System.out.print("Choose: ");
				try {
					put = scan.nextInt();
					scan.nextLine();
				} catch (Exception e) {
					put = -1;
					scan.nextLine();
				}
			}while(put < 1 || put > 3);
			
			switch(put) {
				case 1:{
					menu1(ordersVec);
					System.out.println("Press enter to continue...");
					scan.nextLine();
				}break;
				
				case 2:{
					menu2(ordersVec);
					System.out.println("Press enter to continue...");
					scan.nextLine();
				}break;
			}
		}while(put != 3);
	}

	public static void main(String[] args) {
		new Main();
	}

}
