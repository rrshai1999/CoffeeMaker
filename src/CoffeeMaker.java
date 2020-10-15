public class CoffeeMaker {

	/** Inventory in the coffee maker */
	private int coffee;
	private int milk;
	private int chocolate;

	/**
	 * Creates a coffee maker object with empty containers.
	 */
	public CoffeeMaker() {
		this.coffee = 0;
		this.milk = 0;
		this.chocolate = 0;
	}

	/**
	 * Returns the current number of chocolate units in 
	 * the coffee maker.
	 * @return int
	 */
	public int getChocolate() {
		return chocolate;
	}

	/**
	 * Returns the current number of coffee units in
	 * the coffee maker.
	 * @return int
	 */
	public int getCoffee() {
		return coffee;
	}

	/**
	 * Returns the current number of milk units in
	 * the coffee maker.
	 * @return int
	 */
	public int getMilk() {
		return milk;
	}

	/**
	 * Returns a string describing the current contents 
	 * of the inventory.
	 * @return String
	 */
	public String checkIngredients() {
		// TODO: code this method
		String coffeeAmt = Integer.toString(this.getCoffee());
		String milkAmt = Integer.toString(this.getMilk());
		String chocolateAmt = Integer.toString(this.getChocolate());
		StringBuffer buf = new StringBuffer();
		buf.append("Status of ingredients:");
		buf.append("\n");
		buf.append("Coffee units remaining: "+coffeeAmt);
		buf.append("\n");
		buf.append("Milk units remaining: "+milkAmt);
		buf.append("\n");
		buf.append("Chocolate units remaining: "+chocolateAmt);
		buf.append("\n");
		return buf.toString();
	}

	/**
	 * Cleanup coffee maker emptying all its content
	 */
	public void cleanup() {
		
		// TODO: code this method
	}

	/**
	 * Adds ingredients to the coffee maker
	 * @param amtCoffee
	 * @param amtMilk
	 * @param amtChocolate
	 * @return boolean
	 */
	public void addIngredients(int amtCoffee, int amtMilk, int amtChocolate) throws Exception {
		if (amtMilk < 0 || amtCoffee < 0 || amtChocolate < 0) {
			throw InventoryException();
		}
		this.milk = amtMilk;
		this.chocolate = amtChocolate;
		this.coffee = amtCoffee;
	}

	private Exception InventoryException() {
		System.out.print("Invalid number of units.");
		return null;
	}

	/**
	 * Make an espresso and return the change, or
	 * the user's money if the espresso cannot be made.
	 * An espresso uses one unit of coffee and costs one pound.
	 * @param amtPaid
	 * @return int
	 */
	public int makeEspresso(int amtPaid) {
		if (this.coffee >= 1 && amtPaid >= 1) {
			this.coffee--;
			StringBuffer buf = new StringBuffer();
			buf.append("Making Espresso...");
			buf.append("\n");
			return amtPaid-1;
		}
		else if (this.coffee >= 1 && amtPaid < 1) {
			StringBuffer buf = new StringBuffer();
			buf.append("Sorry, not enough paid. This drink costs £1.");
			buf.append("\n");
			return amtPaid;
		}
		else {
			StringBuffer buf = new StringBuffer();
			buf.append("Sorry, out of coffee. Returning change.");
			buf.append("\n");
			return amtPaid;
		}
	}

	/**
	 * Make a latte and return the change, or
	 * the user's money if the latte cannot be made.
	 * A latte uses two units of coffee and one unit of milk.
	 * @param amtPaid
	 * @return int
	 */
	public int makeLatte(int amtPaid) {
		if (this.coffee >= 2 && this.milk >= 1) {
			this.coffee -= 2;
			this.milk -= 1;
			StringBuffer buf = new StringBuffer();
			buf.append("Making Latte...");
			buf.append("\n");
			return amtPaid-1;
		}
		else if (this.coffee >= 2 && this.milk < 1) {
			StringBuffer buf = new StringBuffer();
			buf.append("Sorry, out of milk. Returning change.");
			buf.append("\n");
			return amtPaid;
		}
		else if (this.coffee < 2 && this.milk >= 1) {
			StringBuffer buf = new StringBuffer();
			buf.append("Sorry, out of coffee. Returning change.");
			buf.append("\n");
			return amtPaid;
		}
		else if (this.coffee < 2 && this.milk < 1) {
			StringBuffer buf = new StringBuffer();
			buf.append("Sorry, out of coffee and out of milk. Returning change.");
			buf.append("\n");
			return amtPaid;
		}
		else if (amtPaid < 1) {
			StringBuffer buf = new StringBuffer();
			buf.append("Sorry, not enough paid. This drink costs £1.");
			buf.append("\n");
			return amtPaid;
		}
		return -1;
	}    
}
