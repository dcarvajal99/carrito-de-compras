package app;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class CarritoTest {

	//sujeto de pruebaas
	private Carrito carrito;
	private Producto producto1;
	private Producto producto2;
	
	
	// configuracion inicial antes de cada @test (metodo de prueba
	
	@Before
	public void setUp() {
		carrito = new Carrito();
		producto1 = new Producto("Monitor gamer Asus", 250000);
		producto2 = new Producto("Mouse Razer", 65000);
		carrito.agregarProducto(producto1);
	}
	
	@Test
	public void testAgregarProducto() {
		//assertEquals 
		assertEquals(1, carrito.getProductos().size());
		carrito.agregarProducto(producto2);
		assertEquals(2, carrito.getProductos().size());
	}
	
	@Test
	public void testEliminarProducto() {
		carrito.eliminarProducto(producto1);
		//verificar que la cantidad de productos sea correcta
		assertEquals(0, carrito.getProductos().size());
	}
	
	@Test
	public void testCalcularTotal() {
		double total = carrito.calcularTotal();
		assertEquals(250000,total,0.0);
	}
	
}
