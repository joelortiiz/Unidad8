package ProveedoresYPiezas;

public class Proveedor {
	private int codProveedor;
	private String nombrePorveedor;
	private String localidad;
	
	public Proveedor(int codProveedor, String nombrePorveedor, String localidad) {
		super();
		this.codProveedor = codProveedor;
		this.nombrePorveedor = nombrePorveedor;
		this.localidad = localidad;
	}
	
	public int getCodProveedor() {
		return codProveedor;
	}
	public void setCodProveedor(int codProveedor) {
		this.codProveedor = codProveedor;
	}
	public String getNombrePorveedor() {
		return nombrePorveedor;
	}
	public void setNombrePorveedor(String nombrePorveedor) {
		this.nombrePorveedor = nombrePorveedor;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	@Override
	public String toString() {
		return "Proveedor [codProveedor=" + codProveedor + ", nombrePorveedor=" + nombrePorveedor + ", localidad="
				+ localidad + "]";
	}
	
}
