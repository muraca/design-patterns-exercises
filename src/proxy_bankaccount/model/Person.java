package proxy_bankaccount.model;

import java.util.ArrayList;

public class Person {
	
	private String name;
	private int age;
	private ArrayList<Person> parents;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		parents = new ArrayList<>();
	}
	
	public boolean isAdult() {
		return age >= 18;
	}

	public void addParent(Person p) {
		if(parents.size() < 2) {
			parents.add(p);
		}
	}
	
	public boolean isChildOf(Person parent) {
		for(Person p: parents)
			if(p == parent)
				return true;
		
		return false;
	}
	
	
}
