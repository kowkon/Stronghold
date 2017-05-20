package items;

import java.io.RandomAccessFile;

public abstract class Item {
	
	private static final int classNameLength = 20;
	private static final int stackLimitLegth = 4;
	
	protected int amount;
	protected int stackLimit;

	/**
	 * Constructs an Item with default amount 0.
	 */
	public Item() {
		setAmount(0);
	}

	/**
	 * Constructs an Item with given amount.
	 * 
	 * @param amount
	 *            Given amount for the item.
	 */
	public Item(int amount) {
		setAmount(amount);
	}

	public abstract Item create(int amount);

	/**
	 * Sums this class' amount and given item's amount.
	 * 
	 * @param item
	 *            that will be summed up.
	 * @return This item with summed up amount.
	 */
	public Item add(Item item) {
		this.amount += item.amount;
		return this;
	}

	/**
	 * Subtracts this class's amount and given item's amount.
	 * 
	 * @param item
	 *            that will be subtracted.
	 * @return This item with subtracted amount.
	 */
	public Item remove(Item item) {
		this.amount -= item.amount;
		return this;
	}
	
	public int findStackLimit() {
		int stackLimit = 0;
		RandomAccessFile items = null;
		String limit = "0";
		try {
			items = new RandomAccessFile("itemConf.txt", "r");
			long fileLength = items.length();
			int lineLength = classNameLength + stackLimitLegth + 1;
			int lines = (int) (fileLength / lineLength);
			for (int i = 0; i < lines; i++) {
				items.seek(i * lineLength);
				byte[] classNameByte = new byte[classNameLength];
				items.read(classNameByte);
				String className = new String(classNameByte);
				className = removeBlanks(className);
				if (className.equals(getClassName())) {
					byte[] limitByte = new byte[4];
					items.read(limitByte);
					limit = new String(limitByte);
					limit = removeBlanks(limit);
					break;
				}
			}
		} catch (Exception e) {
			
		}
		stackLimit = Integer.parseInt(limit);
		return stackLimit;
	}
	
	private String getClassName() {
		String className = "";
		className = getClass().getName();
		int last = className.lastIndexOf(".");
		++last;
		className = className.substring(last, className.length());
		return className;
	}

	private String removeBlanks(String s) {
		String result = s;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				result = s.substring(0, i);
				break;
			}
		}
		return result;
	}

	// GETTERS AND SETTERS

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		if (amount >= 0) // check if amount is non-negative
			this.amount = amount;
		else
			this.amount = 0;
	}

	public int getStackLimit() {
		return stackLimit;
	}

	public void setStackLimit(int stackLimit) {
		this.stackLimit = stackLimit;
	}

}
