package composite_packages.model;

import java.util.ArrayList;

public class Interface extends Component {
	
	private ArrayList<Interface> interfaces = null;
	private ArrayList<String> methods;

	public Interface(String name) {
		super(name);
		methods = new ArrayList<>();
	}
	
	public Interface(String name, Package pkg) {
		super(name, pkg);
		methods = new ArrayList<>();
	}
	
	public void implementsInterface(Interface implemented) {
		if(implemented instanceof Class)
			throw new Error("I can't implement a Class!");
		
		if(interfaces == null)
			interfaces = new ArrayList<>();
		interfaces.add(implemented);
	}
	
	public Interface getInterface(int index) {
		if(index >= 0 && index < interfaces.size())
			return interfaces.get(index);
		return null;
	}
	
	public void removeInterface(int index) {
		if(index >= 0 && index < interfaces.size())
			interfaces.remove(index);
	}
	
	public void addMethod(String method) {
		methods.add(method);
	}
	
	@Override
	public String runMethod(String method) {
		
		for(String s: methods) {
			if(method.equalsIgnoreCase(s))
				return "Method executed by interface " + getName();
		}
		if (interfaces != null)
			for(Interface i: interfaces) {
				String interf = i.runMethod(method);
				if(interf != null)
					return interf + ", interface of " + getName();
			}
			
		return null;
	}
	
	@Override
	public String toString() {
		return "interface " + getName() + " in package " + ((getPackage() != null) ? getPackage().getName() : "default");
	}

}
