package factory_carseller.factories;

import factory_carseller.brands.*;
//classe scritta seguendo le direttive di Factory
//in questo caso ho utilizzato un parametro per creare oggetti diversi
//generalmente non è una scelta consigliabile, ma in questo caso mi sembrava la più adatta
public class BrandFactory {
	
	//la scelta di un brand restituisce un oggetto di una classe figlia dell'interfaccia TypeFactory
	//il metodo è statico in quanto non serve creare oggetti di tipo BrandFactory
	public static TypeAbstractFactory getBrand(String selectedItem) {
		if(selectedItem.equals("Fiat"))
			return new FiatFactory();
		if(selectedItem.equals("Audi"))
			return new AudiFactory();
		if(selectedItem.equals("Peugeot"))
			return new PeugeotFactory();
		return null;
	}
}
