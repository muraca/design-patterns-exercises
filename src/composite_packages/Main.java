package composite_packages;

import java.util.ArrayList;

import composite_packages.model.Component;
import composite_packages.model.Package;
import composite_packages.model.Class;
import composite_packages.model.Interface;

public class Main {
	 public static void main(String[] args) {
		 Package def = new Package("default");
		 Package classes = new Package("classes", def);
		 
		 System.out.println(def.toString());
		 
		 ArrayList<Component> comps = new ArrayList<>();
		 
		 comps.add(new Interface("int0", def));
		 comps.get(0).addMethod("method0");
		 for(int i = 1; i < 5; i++) {
			 Interface ifc = new Interface("int" + i, def);
			 ifc.addMethod("method"+i);
			 ifc.implementsInterface((Interface) comps.get(i-1));
			 comps.add(ifc);
		 }
		 
		 Class cl5 = new Class("class5", classes);
		 cl5.addMethod("method5");
		 cl5.implementsInterface((Interface) comps.get(4));
		 comps.add(cl5);
		 
		 for(int i = 6; i < 9; i++) {
			 Class cl = new Class("class"+i, classes);
			 cl.addMethod("method"+i);
			 cl.extendsClass((Class) comps.get(i-1));
			 comps.add(cl);
		 }
		 
		 System.out.println(comps.get(comps.size()-1).runMethod("method3"));
		 System.out.println(comps.get(comps.size()-1).runMethod("method7"));
		 

		 System.out.println(comps.get(0).toString());
	}
	 
}
