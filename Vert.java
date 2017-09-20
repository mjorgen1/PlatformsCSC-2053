import ch09.graphs.*;
public class Vert {
	public String name;

	public Vert() {
		name = "";
	}
	public Vert(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		Vert other = (Vert)o;
		if(name.equals(other.name))
			return true;
		else
			return false;
	}
}
