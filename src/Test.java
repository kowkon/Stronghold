import people.Peasant;

public class Test {

	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			Peasant p = new Peasant();
		}
		long finish = System.currentTimeMillis();
		System.out.println(finish - start);

	}

}
