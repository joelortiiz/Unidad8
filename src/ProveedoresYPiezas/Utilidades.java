package ProveedoresYPiezas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utilidades {

	public ArrayList<Pieza> leerPiezas(String filename) {
		ArrayList<Pieza> lista = new ArrayList<>();
		File f = new File(filename);
		String cadena = "";
		String linea[];
		try {
			Scanner entrada = new Scanner(f);
			entrada.nextLine();
			while (entrada.hasNext()) {
				cadena = entrada.nextLine();
				linea = cadena.split(";");
				lista.add(new Pieza(Integer.parseInt(linea[0]), linea[1], Integer.parseInt(linea[2]),
						Double.parseDouble(linea[3])));
			}
		}
//			for(Pieza p: lista) {
//				System.out.println(p);
//			}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	public static void main(String[] args) throws FileNotFoundException {

		Programa p = new Programa(); // Array list de piezas y proveedor
		Utilidades u = new Utilidades();// leer piezas y proveedores
		p.setPiezas(u.leerPiezas("piezas.csv"));
		p.setProveedores(u.leerPiezas("proveedor.csv"));

		p.generarFichero("proveedorPieza.txt");

	}

	public ArrayList<Proveedor> leerProveedor(String filename) {
		return null;
	}
}
