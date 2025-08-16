package src.com.diplomado.problema4.model;

import java.text.MessageFormat;

public class File implements Element {

	private String name;
	private long weight;

	public File(String fName, long fWeight) {
		super();
		this.name = fName;
		this.weight = fWeight;
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

	public void setWeight(long fWeight) {
		this.weight = fWeight;
	}

	@Override
	public String displayInfo(String indent) {
		return MessageFormat.format("{0}{1}{2}", indent, this.name, "\r\n");
	}

}
