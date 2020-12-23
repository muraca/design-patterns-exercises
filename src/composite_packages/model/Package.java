package composite_packages.model;

import java.util.ArrayList;

public class Package extends Component {
	
	private ArrayList<Component> children;
	
	public Package(String name) {
		super(name);
		children = new ArrayList<>();
	}

	public Package(String name, Package parent) {
		super(name, parent);
		children = new ArrayList<>();
	}
	
	@Override
	public String getName() {
		if(getPackage() == null)
			return super.getName();
		
		return getPackage().getName() + "." + super.getName();
	}
	
	public void addChildren(Component c) {
		children.add(c);
	}
	
	public Component getChildren(int index) {
		if(index >= 0 && index < children.size())
			return children.get(index);
		return null;
		
	}
	
	public void removeChildren(int index) {
		if(index >= 0 && index < children.size())
			children.remove(index);
	}
	
	@Override
	public String toString() {
		return "package " + super.toString();
	}
}
