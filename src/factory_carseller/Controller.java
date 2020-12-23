package factory_carseller;
import java.util.List;

import javax.swing.JOptionPane;

import factory_carseller.cars.Car;
import factory_carseller.factories.*;

//questa classe rappresenta la parte logica del Software
//evita che sia il display a controllare le richieste
public class Controller {
	
	private TypeAbstractFactory typeAbstractFactory = null;
	private String type = null;
	
	//acquisisce il brand desiderato dal display
	//ed istanzia l'oggetto figlio di TypeFactory adatto alla richiesta
	public void setBrand(String _brand) {
		typeAbstractFactory = BrandFactory.getBrand(_brand);
	}
	
	//gestisce la scelta del tipo
	public void setType(String _type) {
		type = _type;
	}
	
	//restituisce la lista di auto in base alla tipologia scelta
	public List<Car> getCars() {
		//per come è scritto il Display, questo errore non può comparire
		//ma per evitare bug ho preferito implementarlo comunque 
		if(typeAbstractFactory == null) {
			JOptionPane.showMessageDialog(null, "Errore", "Non hai scelto una marca", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		return typeAbstractFactory.getCars(type);
	}
	
	public void reset() {
		typeAbstractFactory = null;
		type = null;
	}
	
	
}
