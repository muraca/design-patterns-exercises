package factory_carseller.factories;

import java.util.List;

import factory_carseller.cars.Car;
//interfaccia di tipo AbstractFactory
public abstract class TypeAbstractFactory {
	public List<Car> getCars(String selectedItem) {
		if(selectedItem.equals("Berlina"))
			return getBerline();
		if(selectedItem.equals("Utilitaria"))
			return getUtilitarie();
		if(selectedItem.equals("Sportiva"))
			return getSportive();
		if(selectedItem.equals("Furgoncino"))
			return getFurgoncini();
		return null;
	}
	
	public abstract List<Car> getBerline();
	public abstract List<Car> getUtilitarie();
	public abstract List<Car> getSportive();
	public abstract List<Car> getFurgoncini();
}
