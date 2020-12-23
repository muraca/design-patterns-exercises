package factory_carseller.brands;

import java.util.ArrayList;
import java.util.List;

import factory_carseller.cars.Car;
import factory_carseller.factories.TypeAbstractFactory;

public class FiatFactory extends TypeAbstractFactory {
	
	private String marca = "Fiat";

	@Override
	public List<Car> getBerline() {
		List<Car> berline = new ArrayList<>();
		berline.add(new Car(marca, "Tipo", 15400.00f));
		berline.add(new Car(marca, "500 Berlina", 14550.00f));
		return berline;
	}

	@Override
	public List<Car> getUtilitarie() {
		List<Car> utilitarie = new ArrayList<>();
		utilitarie.add(new Car(marca, "500", 14450.00f));
		utilitarie.add(new Car(marca, "Panda", 11050.00f));
		utilitarie.add(new Car(marca, "Punto", 12500.00f));
		return utilitarie;
	}

	@Override
	public List<Car> getSportive() {
		List<Car> sportive = new ArrayList<>();
		return sportive;
	}

	@Override
	public List<Car> getFurgoncini() {
		List<Car> furgoncini = new ArrayList<>();
		furgoncini.add(new Car(marca, "Doblò", 14000.00f));
		furgoncini.add(new Car(marca, "Fiorino", 11000.00f));
		return furgoncini;
	}
	
}
