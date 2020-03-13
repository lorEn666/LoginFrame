package clases;

import java.io.Serializable;

public class Contacto implements Serializable {
	private String nombre;
	private int telefono;

	public Contacto(String nombre, int telefono) {
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return String.format("%-11s %11s", nombre, telefono).trim();
	}
}
