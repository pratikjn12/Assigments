package list;

import java.util.Iterator;
import java.util.LinkedList;

public class list {

	public static void main(String[] args) {

		LinkedList<Object> lst = new LinkedList<>();
		lst.add(11);
		lst.add(12);
		lst.add("Hello");
		lst.add(15);

		Iterator<Object> itr = lst.iterator();
		{
			while (itr.hasNext())

			{
				System.out.println(" Data " + itr.next());
				
				if (!(itr.hasNext()))
					
				{
					System.out.println("No Data");
				}
			}
		}

	}

}
