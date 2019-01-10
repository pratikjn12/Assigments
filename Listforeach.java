package list;

import java.util.LinkedList;
import java.util.List;

public class Listforeach {

	public static void main(String[] args) {

		List<String> lst = new LinkedList<String>();
		lst.add("QA");
		lst.add("Pratik");
		lst.add("test");

		for (String item : lst)

		{
			int Count = item.length();
			System.out.println("Total Count" + Count);
		}
	}

}
