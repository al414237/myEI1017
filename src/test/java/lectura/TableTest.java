package lectura;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TableTest {
    final String RUTA = System.getProperty("user.dir") + "\\archivos\\";

    @Test
    @DisplayName("Test del numero de filas")
    public void testRows() throws IOException {
        CSV csv = new CSV();
        Table tabla = csv.readTable(RUTA + "miles_dollars.csv");
        assertEquals(25, tabla.numberOfRows());
    }

    @Test
    @DisplayName("Test del numero de columnas")
    public void testColumns() throws IOException {
        CSV csv = new CSV();
        Table tabla = csv.readTable(RUTA + "miles_dollars.csv");
        assertEquals(2, tabla.numberOfAttributes());
    }

    @Test
    @DisplayName("Test de las etiquetas")
    public void testHeaders() throws IOException {
        CSV csv = new CSV();
        Table tabla = csv.readTable(RUTA + "miles_dollars.csv");
        assertEquals("Miles", tabla.getHeaders().get(0));
        assertEquals("Dollars", tabla.getHeaders().get(1));
    }

    @Test
    @DisplayName("Test de los datos")
    public void testData() throws IOException {
        CSV csv = new CSV();
        Table tabla = csv.readTable(RUTA + "miles_dollars.csv");
        List<Double> datoNum1 = tabla.getRowAt(1).getData();
        assertEquals(1345, datoNum1.get(0));
        assertEquals(2405, datoNum1.get(1));
    }

}