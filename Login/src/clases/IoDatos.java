package clases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class IoDatos {

	public static boolean verificarLogin(String usuario, String password) {
		File fichero = new File("./datos/users.txt");
		try {
			Scanner sc = new Scanner(fichero);
			while (sc.hasNextLine()) {
				String[] linea = sc.nextLine().split("-");
				if (linea[0].equals(usuario) && linea[1].equals(password)) {
					return true;
				}
			}

		} catch (FileNotFoundException e) {
		}
		return false;
	}

	public static ArrayList<Contacto> inicioDeSesion(String usuario) {
		ArrayList<Contacto> vContacto = new ArrayList();
		File fichero = new File("./datos/" + usuario + ".dat");
		if (!fichero.exists()) {
			try {
				fichero.createNewFile();
			} catch (IOException e) {
			}
			return vContacto;
		}
		try {
			ObjectInputStream cargarContactos = new ObjectInputStream(new FileInputStream(fichero));
			vContacto = (ArrayList<Contacto>) cargarContactos.readObject();
			cargarContactos.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		}		
		return vContacto;
	}
}
