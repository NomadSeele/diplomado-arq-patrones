package src.com.diplomado.problema4.model;

import java.text.MessageFormat;
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
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public long getWeight() {
		long totalWeight = 0;
		for (Element element : this.subElements) {
			totalWeight += element.getWeight();
		}
		return totalWeight;
	}

	public ArrayList<Element> getSubElements() {
		return this.subElements;
	}

	public void setSubElements(ArrayList<Element> fSubElements) {
		this.subElements = fSubElements;
	}

	public String printHierarchy(String indent) {
		return displayInfo(indent);
	}

	@Override
	public String displayInfo(String indent) {
		String fullHierarchy = MessageFormat.format("{0}{1}{2}", indent, this.name, "\r\n");
		for (Element element : this.subElements) {
			fullHierarchy += element.displayInfo(indent + "--");
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
		Directory elementDir = null;
		Element elementMove = null;
		for (Element element : this.subElements) {
			if (element.getName().equals(elementName))
				elementMove = element;
			if (element.getName().equals(subDirectory))
				elementDir = (Directory)element;
		}

		return elementDir != null
				? elementMove != null
						? (this.subElements.remove(elementMove) && elementDir.getSubElements().add(elementMove))
						: false
				: false;
	}

}
