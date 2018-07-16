package controlador;

import java.util.ArrayList;
import java.util.Collection;

import negocio.Prenda;
import negocio.Venta;
import vista.PrendaView;

public class SistemaVentas {
	
	private static SistemaVentas instance;
	
	Collection<Prenda> prendas;
	Collection<Venta> ventas;
	
	public static  SistemaVentas getInstance(){
		
		if (instance == null){
			instance = new SistemaVentas();
		}
		
		return instance;
	}
	
	
	private SistemaVentas() {		
		prendas = new ArrayList<Prenda>();
		ventas = new ArrayList<Venta>();
		cargarPrendas();
	}
	
	
	//Helper
	private void cargarPrendas(){
		prendas.add(new Prenda("Camisa", "Azul", 42, 10, 500));
		prendas.add(new Prenda("Pantalon", "Gris", 38, 10, 1400));
		prendas.add(new Prenda("Zapatos", "Negro", 45, 10, 2000));
	}
	
	public Collection<PrendaView> obtenerPrendas(){
		
		Collection<PrendaView> prendasViews = new ArrayList<PrendaView>();
				
		for (Prenda prenda : prendas){
			prendasViews.add(prenda.toView());
		}
		
		return prendasViews;
	}
	
		
	//Metodos
	public void crearNuevaVenta(int cantidad, String nombre, int talle, String color){
		
		Prenda prendaNueva = buscarPrenda(nombre, talle, color);
		
		if(prendaNueva != null && prendaNueva.tengoStock(cantidad)){
			Venta nuevaVenta = new Venta();
			nuevaVenta.agregarItemYactualizarImporte(prendaNueva, cantidad);						
			prendaNueva.descontarStock(cantidad);
			this.ventas.add(nuevaVenta);			
		}		
	}
	
	public void agregarPrendaAVenta(int nroVenta, int cantidad, String nombre, int talle, String color){
		
		Prenda prendaNueva = buscarPrenda(nombre, talle, color);
		
		if(prendaNueva != null && prendaNueva.tengoStock(cantidad)){
			Venta venta = buscarVenta(nroVenta);
			venta.agregarItemYactualizarImporte(prendaNueva, cantidad);						
			prendaNueva.descontarStock(cantidad);
		}
		
	}
	
	private Prenda buscarPrenda(String nombre, int talle, String color){
		
		Prenda prenda = null;
		
		for(Prenda prendaToCheck : prendas){
			if (prendaToCheck.soyLaPrenda(nombre, color, talle)){
				prenda = prendaToCheck;
				break;
			}
		}		
		
		return prenda;
	}
	
	private Venta buscarVenta(int nroVenta){
		
		Venta venta = null;
		
		for(Venta ventaToCkeck : ventas){
			if (ventaToCkeck.soyLaVenta(nroVenta)){
				venta = ventaToCkeck;
				break;
			}
		}		
		
		return venta;
	}
	

}
