package model;

import java.util.ArrayList;

public class Directory implements Element {

	private String name;
	private ArrayList<Element> subElements;

	public Directory(String name, ArrayList<Element> subElements) {
		super();
		this.name = name;
		this.subElements = subElements;
	}

	@Override
	public long getWeight() {
		long totalWeight = 0;
		for (Element element : this.subElements) {
			totalWeight += element.getWeight();
		}
		return totalWeight;
	}

	@Override
	public String printHierarchy(String indent) {
		String fullHierarchy = "";
		for (Element element : this.subElements) {
			fullHierarchy += (indent + element.getName() + "\r\n" + element.printHierarchy(indent + "--"));
		}
		return fullHierarchy;
	}

	public boolean deleteElement(String elementName) {
		Element elementDelete = null;
		for (Element element : this.subElements) {
			if (element.getName().equals(elementName))
				elementDelete = element;
		}
		return elementDelete != null ? this.subElements.remove(elementDelete) : false;
	}

	public void renameElement(String elementName, String newElementName) {
		for (Element element : this.subElements) {
			if (element.getName().equals(elementName))
				element.setName(newElementName);
		}
	}

	public boolean moveElement(String elementName, String subDirectory) {
		Element elementDir = null;
		Element elementMove = null;
		for (Element element : this.subElements) {
			if (element.getName().equals(elementName))
				elementMove = element;
			if (element.getName().equals(subDirectory))
				elementDir = element;
		}

		return elementDir != null
				? elementMove != null
						? (this.subElements.remove(elementMove) && elementDir.getSubElements().add(elementMove))
						: false
				: false;
	}

	@Override
	public ArrayList<Element> getSubElements() {
		return this.subElements;
	}

	@Override
	public void setSubElements(ArrayList<Element> fSubElements) {
		this.subElements = fSubElements;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

}
