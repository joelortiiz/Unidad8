package Alumno;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
		CorreoRibera c=new CorreoRibera();
		//Leer fichero y mostrarlo por pantalla
		Scanner entrada;
		String cursoN="";
		try {
			entrada = new Scanner(new File("AlumnosDAW.csv"));
		
			//Salto las líneas que no me interesan
			entrada.nextLine();
			entrada.nextLine();
			entrada.nextLine();
			entrada.nextLine();
			entrada.nextLine();
			String lineaEntera="";
			String lineasplit[];
			while(entrada.hasNext()) {
				lineaEntera=entrada.nextLine();
				//System.out.println(lineaEntera);
				lineasplit=lineaEntera.split(";");
				String nombreApellidos=lineasplit[0];
				cursoN=lineasplit[2];
				String curso=lineasplit[2].toLowerCase().substring(0, lineasplit[2].length()-1);
				//System.out.println(nombreApellidos+" "+curso);
				String nombre=c.getNombre(nombreApellidos);
				
				String ape1=c.getApellido(nombreApellidos);
				//System.out.println(nombre+" "+ape1+" "+curso);
				String correo=curso+"_"+nombre+ape1+"@riberadeltajo.es";
				//System.out.println(correo);
				c.getListaCorreo().add(new Correo(nombre, ape1, curso, correo));
				
			}//while
			
			c.generarFicheroTexto(cursoN);
			c.generarFicheroCSV(cursoN);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void generarFicheroCSV(String curso) {
		// Genera un fichero con los datos y el correo de los alumnos
		File f = new File("Correos" + curso.toUpperCase() + ".csv");
		try {
			PrintWriter salida = new PrintWriter(f);
			salida.println("Correos electrónicos de los alumnos de " + curso.toUpperCase());
			salida.println("Número;Correo");
			int numero=1;
			for (Correo c : this.getListaCorreo()) {
				salida.println(numero+";"+c.getCorreo());
				numero++;
			}
			salida.flush();
			salida.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Fichero: Correos" + curso.toUpperCase() + ".csv" +" creado");
	}

	private void generarFicheroTexto(String curso) {
		// Genera un fichero con los datos y el correo de los alumnos
		File f=new File("Correos"+curso.toUpperCase()+".txt");
		try {
			PrintWriter salida=new PrintWriter(f);
			salida.println("Correos electrónicos de los alumnos de "+curso.toUpperCase());
			for(Correo c: this.getListaCorreo()) {
				salida.println(c.getCorreo());
			}
			salida.flush();
			salida.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Fichero: Correos" + curso.toUpperCase() + ".txt" +" creado");
		
		
	}

	private String getApellido(String nombreApellidos) {
		// apellido1 apellido2, nombre
		String partes[]=nombreApellidos.split(" ");
		String ape1=partes[0].toLowerCase().trim();
				
		return this.quitaTildes(ape1);
	}

	private String getNombre(String nombreApellidos) {
		// apellido1 apellido2, nombre
		String partes[]=nombreApellidos.split(",");
		String nombre=partes[1].toLowerCase().trim();
		
		return this.quitaTildes(nombre);
	}
	
	private String quitaTildes(String palabra) {
		String []partes;
		for(int i=0; i<palabra.length(); i++) {
			if(palabra.charAt(i)=='á') {
				palabra=palabra.replace('á', 'a');
			}
			if(palabra.charAt(i)=='é') {
				palabra=palabra.replace('é', 'e');
			}
			if(palabra.charAt(i)=='í') {
				palabra=palabra.replace('í', 'i');
			}
			if(palabra.charAt(i)=='ó') {
				palabra=palabra.replace('ó', 'o');
			}
			if(palabra.charAt(i)=='ú') {
				palabra=palabra.replace('ú', 'u');
			}
			if(palabra.charAt(i)=='ñ') {
				palabra=palabra.replace('ñ', 'n');
			}
			if(palabra.charAt(i)==' ') {
				partes=palabra.split(" ");
				palabra=partes[0]+partes[1];
			}
		}//for
		return palabra;
	}
	
}