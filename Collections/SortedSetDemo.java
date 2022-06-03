package Collections;

import java.util.TreeSet;

public class SortedSetDemo {

	public static void main(String[] args) {
		// methods specific
		// first,last, headset, tailset, subset, comparator
		TreeSet nameSet = new TreeSet();
		nameSet.add("Uday sai");
		nameSet.add("Shubham");

		nameSet.add("Chandrakala");
		nameSet.add("Bharath");
		nameSet.add("Poojesh");
		nameSet.add("Priya");
		nameSet.add("Shara");
		System.out.println(nameSet);
		System.out.println(nameSet.first());
		System.out.println(nameSet.last());
		System.out.println(nameSet.headSet("Priya"));
		System.out.println(nameSet.tailSet("Shara"));
		System.out.println(nameSet.subSet("Uday sai", "Pojeesh"));
		System.out.println(nameSet.size());
		System.out.println(nameSet.contains("Bharath"));
		System.out.println(nameSet.containsAll(nameSet));

	}

}