
package es.uniovi.asw.trivial;

//import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
//import java.net.UnknownHostException;



import org.junit.Test;

import es.uniovi.asw.trivial.extractor.parser.Extractor;
import es.uniovi.asw.trivial.extractor.view.ConsoleExtract;
import es.uniovi.asw.trivial.persistence.JSonWriter;

public class ExtractorTest {
	
//	@Test
//	public void emptyExtractor() throws UnknownHostException {
//		String args[] = {};
//		Extractor ext = new Extractor();
//	    assertThat(ext.run(args)).isEqualTo(0);
//	  }
	
	@Test
	public void testTotal() throws IOException
	{
		
		ConsoleExtract.main(new String[]{"test"});
		String ruta=JSonWriter.ruta;
		String ficheroSalida=lector(ruta);
		String ficheroTest=lector("testFiles/testFile.json");
		assertTrue(ficheroSalida.equals(ficheroTest));
		
		
	}
	
	
	
	
	
	
	private String lector(String nombre) throws IOException
	{
		String salida="";
		try{
			@SuppressWarnings("resource")
			BufferedReader fr=new BufferedReader(new FileReader(new File(nombre)));
			while(fr.ready())
				salida=salida+fr.readLine();
			return salida;
		}catch(IOException e){
			return null;
		}
		
	}
}
