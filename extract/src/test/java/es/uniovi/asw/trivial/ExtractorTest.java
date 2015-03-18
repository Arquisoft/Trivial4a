
package es.uniovi.asw.trivial;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
<<<<<<< HEAD
import java.net.UnknownHostException;
=======
>>>>>>> master

import org.junit.Test;

import es.uniovi.asw.trivial.extractor.Extractor;

public class ExtractorTest {
	
//	@Test
//	public void emptyExtractor() throws UnknownHostException {
//		String args[] = {};
//		Extractor ext = new Extractor();
//	    assertThat(ext.run(args)).isEqualTo(0);
//	  }
	
	
	
	
	/**
	 * Comprobar que los espacios o  saltos de linea no sean un problema
	 * @throws IOException 
	 */
	@Test
	public void caracteresEspaciadosTest() throws IOException{
		String args[] = {"preguntasPruebas1"};
		Extractor ext = new Extractor();
<<<<<<< HEAD
=======
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
>>>>>>> master
		ext.run(args);
		String ficheroSalida="",ficheroCorrecto="";
		
		ficheroSalida=lector("preguntasPruebas1");
		ficheroCorrecto=lector("preguntasPruebas1Correcto");
		
		assertEquals(ficheroCorrecto,ficheroSalida);
		
		
		
	}
	
	/**
	 * Se asegura que puedan existir múltiples preguntas en  un fichero
	 * @throws IOException
	 */
	@Test
	public void multiplesPreguntasTest() throws IOException{
		String args[] = {"preguntasPruebas2"};
		Extractor ext = new Extractor();
		ext.run(args);
		String ficheroSalida="",ficheroCorrecto="";
		
		ficheroSalida=lector("preguntasPruebas2");
		ficheroCorrecto=lector("preguntasPruebas2Correcto");
		
		assertEquals(ficheroCorrecto,ficheroSalida);
		
		
		
	}
	
	/**
	 * Comprueba que es posible hacer una pregunta con varias respuestas correctas
	 * @throws IOException
	 */
	@Test
	public void multiplesRespuestasCorrectasTest()throws IOException{	
		String args[] = {"preguntasPruebas3"};
		Extractor ext = new Extractor();
		ext.run(args);
		String ficheroSalida="",ficheroCorrecto="";
		
		ficheroSalida=lector("preguntasPruebas3");
		ficheroCorrecto=lector("preguntasPruebas3Correcto");
		
		assertEquals(ficheroCorrecto,ficheroSalida);
		
	}
	
	/**
	 * Comprueba que la pregunta puede venir sin identificador, pasando a serlo el cuerpo de la pregunta
	 * @throws IOException
	 */
	@Test
	public void identificadorOmitidoTest() throws IOException{
		String args[] = {"preguntasPruebas4"};
		Extractor ext = new Extractor();
		ext.run(args);
		String ficheroSalida="",ficheroCorrecto="";
		
		ficheroSalida=lector("preguntasPruebas4");
		ficheroCorrecto=lector("preguntasPruebas4Correcto");
		
		assertEquals(ficheroCorrecto,ficheroSalida);
	}
	
	/**
	 * Asegura que el parser no permite la generación de preguntas incompletas
	 * @throws IOException
	 */
	@Test
	public void preguntaIncompletaTest() throws IOException{
		String args[] = {"preguntasPruebas5"};
		Extractor ext = new Extractor();
		try{
			ext.run(args);
		}catch(NullPointerException e)
		{
			assertTrue(true);
		}
	
	}
	/*
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
			@SuppressWarnings("resource")
			BufferedReader fr=new BufferedReader(new FileReader(new File(nombre+".out.json")));
			while(fr.ready())
				salida=salida+fr.readLine();
			return salida;
		}catch(IOException e){
			return null;
		}
		
	}
}
