
package es.uniovi.asw.trivial;

//import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
//import java.net.UnknownHostException;




import org.junit.Test;

import es.uniovi.asw.main.GameLoader;
import es.uniovi.asw.trivial.extractor.view.ConsoleExtract;
import es.uniovi.asw.trivial.persistence.JSonFileWriter;

public class TrivialCoreTest {
	
//	@Test
//	public void emptyExtractor() throws UnknownHostException {
//		String args[] = {};
//		Extractor ext = new Extractor();
//	    assertThat(ext.run(args)).isEqualTo(0);
//	  }
	
	@Test
	public void testTotal() throws IOException
	{
		
		GameLoader.main(new String[]{""});
		
		
	}
	
	
	
}
