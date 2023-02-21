package lectura;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CSVTest {
    final String RUTA = System.getProperty("user.dir") + "\\src\\main\\java\\archivos\\";

    @Test
    @DisplayName("Test para comprobar que se lee bien el fichero")
    public void testLectura() throws IOException {
        CSV csv = new CSV();
        Table tabla = csv.readTable(RUTA+"miles_dollars.csv");
        System.out.println(tabla);

    }

}