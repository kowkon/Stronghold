import java.util.ArrayList;
import java.util.Iterator;

import buildings.Building;
import buildings.farm.AppleOrchard;
import buildings.foodProcessing.Bakery;
import buildings.foodProcessing.Mill;
import buildings.industry.IronMine;
import buildings.industry.Woodcutter;
import buildings.storage.Armory;
import buildings.storage.Granary;
import buildings.storage.Stockpile;
import buildings.weapon.FletchersWorkshop;
import castle.Castle;
import castle.ICastle;
import people.Peasant;

public class Test {
	
	public static void main(String[] args) {

		Castle castle = new Castle();
		Stockpile stock = new Stockpile(castle);
		Granary granary = new Granary(castle);
		Woodcutter w = new Woodcutter(castle);
		FletchersWorkshop f = new FletchersWorkshop(castle);
		Armory armor = new Armory(castle);
		IronMine i = new IronMine(castle);
		Mill m = new Mill(castle);
		
		
		
		while(true) {
			try {
				Thread.sleep(1000);
				for(Peasant p : castle.getPeasants()) {
					System.out.println(p.getFirstName() + " " + p.getLastName() + "\t\t\t" + p.getGender());
					
				}
				System.out.println("-------------");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
	}

}
