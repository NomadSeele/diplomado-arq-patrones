package src.com.diplomado.problema4.model;

import java.text.MessageFormat;

public class Shortcut implements Element {

	private String name;
	final long weight = 0;

	public Shortcut(String fName, long fWeight) {
		super();
		this.name = fName;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String fName) {
		this.name = fName;
	}

	@Override
	public long getWeight() {
		return weight;
	}

	@Override
	public String displayInfo(String indent) {
		return MessageFormat.format("{0}{1}{2}", indent, this.name, "\r\n");
	}

}
