package clases;

public class Contacto {
	private String nombre;
	private int telefono;

	public Contacto(String nombre, int telefono) {
		this.nombre = nombre;
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return nombre + "\t" + telefono;
	}
}
