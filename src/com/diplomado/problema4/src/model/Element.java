package model;

import java.util.ArrayList;

public interface Element {

	public String getName();

	public void setName(String name);

	public ArrayList<Element> getSubElements();

	public void setSubElements(ArrayList<Element> fSubElements);

	public long getWeight();

	public String printHierarchy(String indent);

}
