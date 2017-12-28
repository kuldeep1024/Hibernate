package org.hibernate.tutorial.inheritance;

import java.util.ArrayList;
import java.util.Collections;

public class StringTest {

	public static void main(String[] args) {
		String a = "abc";

		System.out.println(a.equals(null));

		ArrayList<String> teamsName = new ArrayList<String>();
		teamsName.add("abc");
		teamsName.add("111");
		teamsName.add("ccc");
		teamsName.add("sss");
		teamsName.add("bbb");

		Collections.sort(teamsName.subList(3, teamsName.size()));

		for (String s : teamsName) {
			System.out.println(s);
		}

	}

}

class Teest {

	private int id;
	private String fname;
	private String lname;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + id;
		result = prime * result + ((lname == null) ? 0 : lname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teest other = (Teest) obj;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		if (id != other.id)
			return false;
		if (lname == null) {
			if (other.lname != null)
				return false;
		} else if (!lname.equals(other.lname))
			return false;
		return true;
	}

}