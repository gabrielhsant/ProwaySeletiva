
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SomaTest {

	@Test
	void test() {
		Soma soma = new Soma();
		int ResultadoEsperado = 10;
		
		int resultado = Soma.Somar (4, 6);
		assertTrue(ResultadoEsperado == ResultadoEsperado);
		
	}
    void TesteSomarSemAnnotation () {
    	Soma soma = new Soma();
		int ResultadoEsperado = 10;
		
		int resultado = Soma.Somar (4, 6);
		assertTrue(ResultadoEsperado == ResultadoEsperado);        	
    }
    @Test
    void TesteNumerosNegativos() {
    	Soma soma = new Soma();
		int ResultadoEsperado = -10;
		
		int resultado = Soma.Somar (-4, -6);
		assertTrue(ResultadoEsperado == ResultadoEsperado);
		
    }
    
}
