package Alumnos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CorreoRibera {
	private ArrayList<Correo>listaCorreo;
	
	public CorreoRibera() {
		this.listaCorreo=new ArrayList<>();
	}

	public ArrayList<Correo> getListaCorreo() {
		return listaCorreo;
	}

	public void setListaCorreo(ArrayList<Correo> listaCorreo) {
		this.listaCorreo = listaCorreo;
	}
	
	public static void main(String[] args) {
		//Leer fichero y mostrar.
		Scanner entrada;
		try {
			 entrada = new Scanner(new File("AlumnosDAW.csv"));
		//Salto las cinco entradas que no me sirven
		entrada.nextLine();
		entrada.nextLine();
		entrada.nextLine();
		entrada.nextLine();
		entrada.nextLine();
		String lineaEntera="";
		String lineaSplit[];
		while(entrada.hasNext()){
			lineaEntera=entrada.nextLine();
//			System.out.println(lineaEntera);
			lineaSplit=lineaEntera.split(";");
			String nombreApellidos=lineaSplit[0];
			String curso=lineaSplit[2];
			System.out.println(nombreApellidos+" "+curso);
		}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
