package composite_packages.model;

import java.util.ArrayList;

public class Class extends Interface {
	
	private Class superClass = null;
	private ArrayList<String> methods;

	public Class(String name) {
		super(name);
		methods = new ArrayList<>();
	}
	
	public Class(String name, Package pkg) {
		super(name, pkg);
		methods = new ArrayList<>();
	}

	public void extendsClass(Class superClass) {
		this.superClass = superClass;
	}
	
	public Class getSuperClass() {
		return superClass;
	}
	
	@Override
	public void addMethod(String method) {
		methods.add(method);
	}
	
	@Override
	public String runMethod(String method) {
		
		for(String s: methods) {
			if(method.equalsIgnoreCase(s))
				return "Method executed by class " + getName();
		}
		if(superClass != null) {
			String sup = superClass.runMethod(method);
			if(sup != null)
				return sup + ", superclass of " + getName();
		}
		return super.runMethod(method);
	}
	
	@Override
	public String toString() {
		return "class " + getName() + " in package " + ((getPackage() != null) ? getPackage().getName() : "default");
	}
}
