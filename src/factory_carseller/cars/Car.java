package factory_carseller.cars;

//classe automobile, con i principali attributi e metodi di get
public class Car {
	private String marca;
	private String nome;
	private Float prezzo;
	
	public Car(String marca, String nome, Float prezzo) {
		this.marca = marca;
		this.nome = nome;
		this.prezzo = prezzo;
	}

	public String getMarca() {
		return marca;
	}

	public String getNome() {
		return nome;
	}

	public Float getPrezzo() {
		return prezzo;
	}
	
	@Override
	public String toString() {
		return marca + " " + nome + " €" + prezzo.toString();
	}
}
