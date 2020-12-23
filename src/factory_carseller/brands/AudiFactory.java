package factory_carseller.brands;

import java.util.ArrayList;
import java.util.List;

import factory_carseller.cars.Car;
import factory_carseller.factories.TypeAbstractFactory;

public class AudiFactory extends TypeAbstractFactory {
	
	private String marca = "Audi";

	@Override
	public List<Car> getBerline() {
		List<Car> berline = new ArrayList<>();
		berline.add(new Car(marca, "A4", 37000.00f));
		return berline;
	}

	@Override
	public List<Car> getUtilitarie() {
		List<Car> utilitarie = new ArrayList<>();
		utilitarie.add(new Car(marca, "A1", 24000.00f));
		return utilitarie;
	}

	@Override
	public List<Car> getSportive() {
		List<Car> sportive = new ArrayList<>();
		sportive.add(new Car(marca, "R8", 130000.00f));
		return sportive;
	}

	@Override
	public List<Car> getFurgoncini() {
		List<Car> furgoncini = new ArrayList<>();
		return furgoncini;
	}

}
