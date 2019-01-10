package arrayandarraylist;

public class indexarray {

	public static void main(String[] args) {

		int array[] = new int[5];

		array[0] = 15;
		array[1] = 34;
		array[2] = 43;
		array[3] = 65;
		array[4] = 54;

		for (int i = 0; i < array.length; i++) {
			System.out.println("Array Value as per the Index value:" + array[i]);
		}
	}

}
