package buildings;

import java.io.RandomAccessFile;

import buildings.storage.StorageBuilding;
import castle.Castle;
import items.Item;

public abstract class ProducerBuilding extends Building implements IProducerBuilding {

	private final static int classNameLength = 20;
	private final static int produceAmountLength = 4;

	protected int produceAmount;
	protected int speed;

	/**
	 * Constructor
	 * 
	 * @param castle
	 *            The castle that the building belongs
	 */
	public ProducerBuilding(Castle castle) {
		super(castle);
	}

	public abstract void work();

	public abstract StorageBuilding findProduceBuilding();

	public void produce(Item item) {
		StorageBuilding produceStorage;
		synchronized (noBuildingLock) {
			while ((produceStorage = findProduceBuilding()) == null) {
				try {
					noBuildingLock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		synchronized (produceStorage.addLock) {
			while (!produceStorage.addItem(item)) {
				try {
					produceStorage.addLock.wait();
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
			producers = new RandomAccessFile("producerConf.txt", "r");
			long fileLength = producers.length();
			int lineLength = classNameLength + produceAmountLength + 1;
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

	@Override
	public void updateSpeed(int speed) {
		setSpeed(speed);
	}

	// GETTERS AND SETTERS

	public int getProduceAmount() {
		return produceAmount;
	}

	public void setProduceAmount(int produceAmount) {
		this.produceAmount = produceAmount;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
