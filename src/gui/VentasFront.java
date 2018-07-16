package gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.SistemaVentas;
import vista.PrendaView;

public class VentasFront extends JFrame {
	
	private static final long serialVersionUID = 7667349463576622582L;
	
	private JLabel lblPrenda, lblCantidad;
	private JComboBox<PrendaView> prendas;
	private JTextField txtCantidad, txtNroVenta;
	private JButton btnNuevaVenta, btnAgregarPrenda;
	
	public VentasFront(){
		configurar();
		eventos();
	}
	
	private void configurar(){
		
		Container c = this.getContentPane();
		c.setLayout(null);
		
		lblPrenda = new JLabel("Prenda");
		lblPrenda.setBounds(10, 10, 100, 30);		
		c.add(lblPrenda);
		
		prendas = new JComboBox<PrendaView>();
		
		Collection<PrendaView> prendaViews = SistemaVentas.getInstance().obtenerPrendas();
		prendaViews.forEach(p -> prendas.addItem(p));
		
		prendas.setBounds(100, 10, 300, 30);
		c.add(prendas);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 45, 100, 30);
		c.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(100, 45, 30, 30);
		c.add(txtCantidad);
		
		btnNuevaVenta = new JButton("Nueva Venta");
		btnNuevaVenta.setBounds(10, 100, 150, 30);
		c.add(btnNuevaVenta);
		
		btnAgregarPrenda = new JButton("Agregar Prenda");
		btnAgregarPrenda.setBounds(175, 100, 150, 30);
		btnAgregarPrenda.setVisible(false);
		c.add(btnAgregarPrenda);
		
		txtNroVenta = new JTextField();
		txtNroVenta.setBounds(10, 145, 30, 30);
		c.add(txtNroVenta);
		
		this.setSize(800, 600);
		this.setVisible(true);
	}
	
	private void eventos() {
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		btnNuevaVenta.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {				
				SistemaVentas sistema = SistemaVentas.getInstance();
				
				int cantidad = Integer.parseInt(txtCantidad.getText());			
				PrendaView pv = (PrendaView) prendas.getSelectedItem();															
				sistema.crearNuevaVenta(cantidad, pv.getNombre(), pv.getTalle(), pv.getColor());
				btnAgregarPrenda.setVisible(true);
				btnNuevaVenta.setEnabled(false);
			}			
		});
		
		
		btnAgregarPrenda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				SistemaVentas sistema = SistemaVentas.getInstance();
				
				int nroVenta = Integer.parseInt(txtNroVenta.getText());
				int cantidad = Integer.parseInt(txtCantidad.getText());
				
				PrendaView pv = (PrendaView) prendas.getSelectedItem();	
				sistema.agregarPrendaAVenta(nroVenta, cantidad, pv.getNombre(), pv.getTalle(), pv.getColor());							
			}
		});
		
	}
}