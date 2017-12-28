package org.hibernate.tutorial.inheritance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hibernate.tutorial.hbm.Event;

public class SortIntArrayList {

	public static void main(String[] args) {
		List<Number> list = new ArrayList<Number>();
		// List<Integer> list = new ArrayList<Integer>();

		list.add(23);
		list.add(263);
		list.add(523);
		list.add(423);
		list.add(2);
		list.add(203);

		/*
		 * Collections.sort(list, new Comparator<Number>() {
		 * 
		 * @Override 
		 * public int compare(Number o1, Number o2) { 
		 *	return (o1.intValue() < o2.intValue() ? -1 : (o1.intValue() > o2.intValue()	? 1 : 0)); } });
		 */

		Collections.sort(list, new Comp2());

		/*
		 * Collections.sort(list,new Comparable<Number>() {
		 * 
		 * @Override public int compareTo(Number o) { return } });
		 */
		//System.out.println("abc".compareTo("abc"));
		for (Number i : list)
			System.out.println(i);
	}

}

class Comp implements Comparable<Event> {

	@Override
	public int compareTo(Event o) {
		// TODO Auto-generated method stub
		return 0;
	}

}

class Comp2 implements Comparator<Number> {

	@Override
	public int compare(Number o1, Number o2) {
		return (o1.intValue() < o2.intValue() ? -1 : o1.intValue() < o2.intValue() ? 1 : 0);
	}

}