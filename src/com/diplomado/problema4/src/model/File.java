package model;

import java.util.ArrayList;

public class File implements Element {

	private String name;
	private long weight;

	public File(String fName, long fWeight) {
		super();
		this.name = fName;
		this.weight = fWeight;
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

	public void setWeight(long fWeight) {
		this.weight = fWeight;
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
