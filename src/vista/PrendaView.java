package vista;

public class PrendaView {
	
	private String nombre;
	private String color;
	private int talle;
	
	public PrendaView(){}
	
	public PrendaView(String nombre, String color, int talle){		
		this.setNombre(nombre);
		this.setColor(color);
		this.setTalle(talle);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getTalle() {
		return talle;
	}

	public void setTalle(int talle) {
		this.talle = talle;
	}
	
	@Override
	public String toString() {
		return nombre + " - " + color + " - " + talle;
	}	

}