
package es.uniovi.asw.trivial;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import es.uniovi.asw.trivial.Extractor;

public class ExtractorTest {
	
	@Test
	public void emptyExtractor() {
		String args[] = {};
		Extractor ext = new Extractor();
	    assertThat(ext.run(args)).isEqualTo(0);
	  }
	
	
	
	
	/**
	 * Comprobar que los espacios o  saltos de linea no sean un problema
	 * @throws IOException 
	 */
	@Test
	public void caracteresEspaciadosTest() throws IOException{
		String args[] = {"preguntasPruebas1"};
		Extractor ext = new Extractor();
		String ficheroSalida="",ficheroCorrecto="";
		
		ficheroSalida=lector("ficheroPruebas1");
		ficheroCorrecto=lector("ficheroPruebas1Correcto");
		
		assertEquals(ficheroCorrecto,ficheroSalida);
		
		
		
	}
	/*
	@Test
	public void Test(){
		
	}
	
	@Test
	public void Test(){
		
	}
	@Test
	public void Test(){
		
	}
	@Test
	public void Test(){
		
	}
	@Test
	public void Test(){
		
	}*/
	
	private String lector(String nombre) throws IOException
	{
		String salida="";
		try{
			BufferedReader fr=new BufferedReader(new FileReader(new File(nombre+".out.json")));
			while(fr.ready())
				salida=salida+fr.readLine();
			return salida;
		}catch(IOException e){
			return null;
		}
		
	}
}
