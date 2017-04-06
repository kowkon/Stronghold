import java.util.ArrayList;

import buildings.farm.WheatFarm;
import buildings.foodProcessing.Bakery;
import buildings.foodProcessing.Mill;
import buildings.industry.OxTether;
import buildings.industry.Quarry;
import buildings.industry.Woodcutter;
import buildings.storage.Granary;
import buildings.storage.Stack;
import buildings.storage.Stockpile;
import buildings.weapon.FletchersWorkshop;
import castle.Castle;
import items.Item;
import items.food.Apple;
import items.food.Meat;
import items.industrial.Stone;
import items.industrial.Wood;

public class Test {

	public static void main(String[] args) {

		Castle castle = new Castle();
		Stockpile stock = new Stockpile(castle);
		Granary granary = new Granary(castle);
		WheatFarm w = new WheatFarm(castle);
		Woodcutter wood = new Woodcutter(castle);
		Woodcutter wood1 = new Woodcutter(castle);
		Woodcutter wood2 = new Woodcutter(castle);
		Bakery b = new Bakery(castle);
		Mill m = new Mill(castle);
		Quarry q = new Quarry(castle);
		OxTether o = new OxTether(castle, new Stone());
		FletchersWorkshop f = new FletchersWorkshop(castle);
		f.start();
		wood.start();
		
		while (true) {
			try {
				Thread.sleep(1000);
				for (Item i : stock.rooms)
					System.out.println(i.getClass().getName() + " " + i.getAmount());
				System.out.println();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
