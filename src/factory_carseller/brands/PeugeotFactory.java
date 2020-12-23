package factory_carseller.brands;

import java.util.ArrayList;
import java.util.List;

import factory_carseller.cars.Car;
import factory_carseller.factories.TypeAbstractFactory;

public class PeugeotFactory extends TypeAbstractFactory {
	
	private String marca = "Peugeot";

	@Override
	public List<Car> getBerline() {
		List<Car> berline = new ArrayList<>();
		berline.add(new Car(marca, "308", 21850.00f));
		berline.add(new Car(marca, "508", 35000.00f));
		return berline;
	}

	@Override
	public List<Car> getUtilitarie() {
		List<Car> utilitarie = new ArrayList<>();
		utilitarie.add(new Car(marca, "108", 12050.00f));
		utilitarie.add(new Car(marca, "208", 14800.00f));
		return utilitarie;
	}

	@Override
	public List<Car> getSportive() {
		List<Car> sportive = new ArrayList<>();
		sportive.add(new Car(marca, "308 GTi", 37400.00f));
		return sportive;
	}

	@Override
	public List<Car> getFurgoncini() {
		List<Car> furgoncini = new ArrayList<>();
		furgoncini.add(new Car(marca, "Traveller", 33000.00f));
		return furgoncini;
	}
}