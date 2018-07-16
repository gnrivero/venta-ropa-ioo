package negocio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

public class Venta {
	
	private static int numerador;
	
	private int nroVenta;
	private Date fecha;
	private String estado;
	private float importe;
	private Collection<ItemVenta> itemsVenta;
	
	public Venta(){
		numerador++;
		nroVenta = numerador;
		fecha = Calendar.getInstance().getTime();
		estado = "pendiente";
		importe = 0;
		itemsVenta = new ArrayList<ItemVenta>();
	}
		
	public static int getNumerador() {
		return numerador;				
	}
	
	public int getNroVenta() {
		return nroVenta;
	}
	public void setNroVenta(int nroVenta) {
		this.nroVenta = nroVenta;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public float getImporte() {
		return importe;
	}
	public void setImporte(float importe) {
		this.importe = importe;
	}
	public Collection<ItemVenta> getItemsVenta() {
		return itemsVenta;
	}
	public void setItemsVenta(Collection<ItemVenta> itemsVenta) {
		this.itemsVenta = itemsVenta;
	}
	
	
	//Metodos de instancia
	public void agregarItemYactualizarImporte(Prenda prenda, int cantidad){
		
		ItemVenta item = new ItemVenta(cantidad, prenda);
		this.itemsVenta.add(item);
		
		this.importe = prenda.getPrecio() * cantidad;		
	}
	
	public boolean soyLaVenta(int nroVenta){
		return this.nroVenta == nroVenta;
	}

}