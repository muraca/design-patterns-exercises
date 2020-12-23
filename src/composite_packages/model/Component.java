package composite_packages.model;

public abstract class Component {

	private String name;
	private Package pkg;
	
	public Component(String name) {
		this.name = name;
		this.pkg = null;
	}
	
	public Component(String name, Package parent) {
		this.name = name;
		this.pkg = parent;
		parent.addChildren(this);
	}
	
	public Package getPackage() {
		return pkg;
	}
	
	public String getName() {
		return name;
	}
	
	public void addMethod(String method) {}
	public String runMethod(String method) {

		throw new Error("I'm " + getName() + ", I can't run methods.");
	}
	
	public String toString() {
		return name + ((pkg != null) ? " in package " + pkg.getName() : "");
	}
}
