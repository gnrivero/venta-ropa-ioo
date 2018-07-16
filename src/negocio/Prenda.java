package negocio;

import vista.PrendaView;

public class Prenda {
	
	private String nombre;
	private String color;
	private int talle;
	private int stock;
	private float precio;
	
	public Prenda(String nombre, String color, int talle, int stock, float precio){		
		this.setNombre(nombre);
		this.setColor(color);
		this.setTalle(talle);
		this.setStock(stock);
		this.setPrecio(precio);
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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public boolean soyLaPrenda(String nombre, String color, int talle){				
		return (this.nombre.compareToIgnoreCase(nombre) == 0  
					&& this.color.compareToIgnoreCase(color) == 0 
						&& this.talle == talle);
	}
	
	public boolean tengoStock(int cantidad){
		return this.stock >= cantidad;
	}
	
	public void descontarStock(int cantidad){
		this.stock = this.stock - cantidad;
	}
	
	public PrendaView toView(){
		return new PrendaView(nombre, color, talle);
	}

}