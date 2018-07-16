package negocio;

public class ItemVenta {
	
	private int cantidad;
	private Prenda prenda;
	
	public ItemVenta(int cantidad, Prenda prenda){
		this.cantidad = cantidad;
		this.prenda = prenda;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public Prenda getPrenda() {
		return prenda;
	}
	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
	}

}