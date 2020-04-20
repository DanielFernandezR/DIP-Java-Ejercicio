package org.formacion.di.negocio;

public class ControladorEstoc implements ApiInventario {

	private final ApiInventario inventario;
	
	public ControladorEstoc(ApiInventario inventario) {
		this.inventario = inventario;
	}

	@Override
	public int numeroProductos(String tienda, String producto) {
		return inventario.numeroProductos(tienda, producto);
	}
	
	/**
	 * Nuestros sesudos estudios han descubierto que los clientes compran mas
	 * productos cuando el nombre de este producto es mas largo
	 * Por eso, el estoc no puede ser inferior a 100 * la longitud del nombre del producto
	 * p.e: necesitamos al menos 400 mesas (mesa : 4 letras) y
	 *    al menos 700 lamparas (lampara: 7 letras)
	 */
	public boolean necesitaReponer (String tienda, String producto) {
		int cantidadActual = numeroProductos(tienda, producto);
		
		return  cantidadActual < producto.length() * 100;
	}

}
