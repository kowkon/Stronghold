package people;

import castle.Castle;

public class PeasantGenerator extends Thread {

	private Castle castle;
	
	public PeasantGenerator(Castle castle) {
		this.castle = castle;
	}
	
	@Override
	public void run() {
		
		while(castle.getPopulation() < castle.getMaxPopulation() && castle.getPopulation() < 10) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			castle.getPeasants().add(new Peasant());
			castle.setPopulation(1 + castle.getPopulation());
		}
	}
	
}
