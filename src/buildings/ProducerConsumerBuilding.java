package buildings;

import java.io.RandomAccessFile;

import buildings.storage.StorageBuilding;
import castle.Castle;
import items.Item;

public abstract class ProducerConsumerBuilding extends ProducerBuilding {

	private final static int classNameLength = 20;
	private final static int produceAmountLength = 4;
	private final static int consumeAmountLength = 4;
	
	protected int consumeAmount;

	/**
	 * Constructor
	 * 
	 * @param castle
	 *            The castle that the building belongs
	 */
	public ProducerConsumerBuilding(Castle castle) {
		super(castle);
	}

	public abstract StorageBuilding findComsumeBuilding();

	public void consume(Item item) {
		StorageBuilding consumeStorage;
		synchronized (noBuildingLock) {
			while ((consumeStorage = findComsumeBuilding()) == null) {
				try {
					noBuildingLock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		synchronized (consumeStorage.removeLock) {
			while (!consumeStorage.removeItem(item)) {
				try {
					consumeStorage.removeLock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public int findProduceAmount() {
		int produceAmount = 0;
		RandomAccessFile producers = null;
		String amount = "0";
		try {
			producers = new RandomAccessFile("producerConsumerConf.txt", "r");
			long fileLength = producers.length();
			int lineLength = classNameLength + produceAmountLength + consumeAmountLength + 1;
			int lines = (int) (fileLength / lineLength);
			for (int i = 0; i < lines; i++) {
				producers.seek(i * lineLength);
				byte[] classNameByte = new byte[classNameLength];
				producers.read(classNameByte);
				String className = new String(classNameByte);
				className = removeBlanks(className);
				if (className.equals(getClassName())) {
					byte[] amountByte = new byte[4];
					producers.read(amountByte);
					amount = new String(amountByte);
					amount = removeBlanks(amount);
					break;
				}
			}
		} catch (Exception e) {
			
		}
		produceAmount = Integer.parseInt(amount);
		return produceAmount;
	}
	
	public int findConsumeAmount() {
		int consumeAmount = 0;
		RandomAccessFile producers = null;
		String amount = "0";
		try {
			producers = new RandomAccessFile("producerConsumerConf.txt", "r");
			long fileLength = producers.length();
			int lineLength = classNameLength + produceAmountLength + consumeAmountLength + 1;
			int lines = (int) (fileLength / lineLength);
			for (int i = 0; i < lines; i++) {
				producers.seek(i * lineLength);
				byte[] classNameByte = new byte[classNameLength];
				producers.read(classNameByte);
				String className = new String(classNameByte);
				className = removeBlanks(className);
				if (className.equals(getClassName())) {
					byte[] amountByte = new byte[4];
					producers.read(amountByte);
					producers.read(amountByte);
					amount = new String(amountByte);
					amount = removeBlanks(amount);
					break;
				}
			}
		} catch (Exception e) {
			
		}
		consumeAmount = Integer.parseInt(amount);
		return consumeAmount;
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

	//GETTERS AND SETTERS
	
	public int getConsumeAmount() {
		return consumeAmount;
	}

	public void setConsumeAmount(int consumeAmount) {
		this.consumeAmount = consumeAmount;
	}

}
