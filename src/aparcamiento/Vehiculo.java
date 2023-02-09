package aparcamiento;

import java.io.Serializable;

public abstract class Vehiculo implements Valida, Serializable {
	protected String matricula;
	protected String color;
	protected String marca;
	protected String modelo;

}
