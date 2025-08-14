package model;

import java.util.ArrayList;

public class Shortcut implements Element {

	private String name;
	final long weight = 0;

	public Shortcut(String fName, long fWeight) {
		super();
		this.name = fName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String fName) {
		this.name = fName;
	}

	public long getWeight() {
		return weight;
	}

	@Override
	public String printHierarchy(String indent) {
		return "";
	}

	@Override
	public ArrayList<Element> getSubElements() {
		return null;
	}

	@Override
	public void setSubElements(ArrayList<Element> fSubElements) {
	}

}
