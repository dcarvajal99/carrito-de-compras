package app;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class ProductoTest {

	Producto producto1;
	
	@Before
	public void setUp() {
		producto1 = new Producto("Apple Mac Pro M1", 2000000);
	}
	
	@Test
	public void testGetNombre() {
		 assertEquals("Apple Mac Pro M1", producto1.getNombre());
	}
	@Test
	public void testsetNombre() {
		producto1.setNombre("Iphone 14");
		assertEquals("Iphone 14", producto1.getNombre());
	}
	@Test
	public void testGetPrecio() {
		 assertEquals(2000000, producto1.getPrecio(),0.0);
	}
	@Test
	public void testSetPrecio() {
		producto1.setPrecio(799000);
		 assertEquals(799000, producto1.getPrecio(),0.0);
	}
	
}
