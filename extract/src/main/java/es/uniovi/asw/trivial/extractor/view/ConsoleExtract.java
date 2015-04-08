package es.uniovi.asw.trivial.extractor.view;

import es.uniovi.asw.trivial.extractor.parser.Extractor;

import java.io.FileNotFoundException;
import java.net.UnknownHostException;

public class ConsoleExtract {

    public static void main(String[] args) {
        try {
            new Extractor().run(args);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
