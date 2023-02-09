package ProveedoresYPiezas;

import java.io.PrintWriter;
import java.util.ArrayList;

public class Programa {
	
		ArrayList<Pieza> proveedores=new ArrayList<>();
		ArrayList<Pieza>piezas=new ArrayList<>();
		public Programa() {
			
		}
		public ArrayList<Pieza> getProveedores() {
			return proveedores;
		}
		public void setProveedores(ArrayList<Pieza> proveedores) {
			this.proveedores = proveedores;
		}
		public ArrayList<Pieza> getPiezas() {
			return piezas;
		}
		public void setPiezas(ArrayList<Pieza> piezas) {
			this.piezas = piezas;
		}
		
		@Override
		public String toString() {
			return "Programa [proveedores=" + proveedores + ", piezas=" + piezas + "]";
		}
	
	public void generarFichero(String filename) throws FileNotFoundException {
		
		PrintWriter salida=new PrintWriter(filename);
		for(Proveedor prov: this.getProveedores()) {
			salida.println("El proveedor "+prov.getCodProveedor()+" suministra: "+prov.get);
			for(Pieza pie: this.getPiezas()) {
				salida.println("");
			}
		}
		
	}
	public static void main(String[] args) {
		
	}
}
