package ProveedoresYPiezas;

public class Pieza {

	private int codPieza;
	private String nombrePieza;
	private int porveedor;
	private double peso;
	
	public Pieza(int codPieza, String nombrePieza, int porveedor, double peso) {
		super();
		this.codPieza = codPieza;
		this.nombrePieza = nombrePieza;
		this.porveedor = porveedor;
		this.peso = peso;
	}

	public int getCodPieza() {
		return codPieza;
	}

	public void setCodPieza(int codPieza) {
		this.codPieza = codPieza;
	}

	public String getNombrePieza() {
		return nombrePieza;
	}

	public void setNombrePieza(String nombrePieza) {
		this.nombrePieza = nombrePieza;
	}

	public int getPorveedor() {
		return porveedor;
	}

	public void setPorveedor(int porveedor) {
		this.porveedor = porveedor;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Pieza [codPieza=" + codPieza + ", nombrePieza=" + nombrePieza + ", porveedor=" + porveedor + ", peso="
				+ peso + "]";
	}
	
}
