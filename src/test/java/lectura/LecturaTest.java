package lectura;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LecturaTest {
    final String RUTA = System.getProperty("user.dir") + "\\src\\main\\java\\archivos\\";

    @Test
    @DisplayName("Test para comprobar que se lee bien un fichero sin label")
    public void testReadingWithoutLabel() throws IOException {
        CSV csv = new CSV();
        Table tabla = csv.readTable(RUTA + "miles_dollars.csv");
        System.out.println(tabla);
    }

    @Test
    @DisplayName("Test para comprobar que se lee bien un fichero con label")
    public void testReadingWithLabel() throws IOException {
        CSV csv = new CSV();
        Table tabla = csv.readTable(RUTA + "iris.csv");
        System.out.println(tabla);
    }


    @Test
    @DisplayName("Test del tamano")
    public void testSizeWithoutLabel() throws IOException {
        CSV csv = new CSV();
        Table tabla = csv.readTable(RUTA + "miles_dollars.csv");
        assertEquals(25, tabla.numberOfRows());
        assertEquals(2, tabla.numberOfAttributes());
    }


    @Test
    @DisplayName("Test del tamano")
    public void testSizeWithLabel() throws IOException {
        CSV csv = new CSV();
        Table tabla = csv.readTable(RUTA + "iris.csv");
        assertEquals(150, tabla.numberOfRows());
        assertEquals(5, tabla.numberOfAttributes());
    }

    @Test
    @DisplayName("Test de las etiquetas")
    public void testLabelWithoutLabel() throws IOException {
        CSV csv = new CSV();
        Table tabla = csv.readTable(RUTA + "miles_dollars.csv");
        assertEquals("Miles", tabla.getHeaders().get(0));
        assertEquals("Dollars", tabla.getHeaders().get(1));
    }


    @Test
    @DisplayName("Test de las etiquetas")
    public void testLabelWithLabel() throws IOException {
        CSV csv = new CSV();
        Table tabla = csv.readTable(RUTA + "iris.csv");
        assertEquals("sepal length", tabla.getHeaders().get(0));
        assertEquals("sepal width", tabla.getHeaders().get(1));
        assertEquals("petal length", tabla.getHeaders().get(2));
        assertEquals("petal width", tabla.getHeaders().get(3));
        assertEquals("class", tabla.getHeaders().get(4));
    }

    @Test
    @DisplayName("Test de los datos")
    public void testDataWithoutLabel() throws IOException {
        // No sé cómo generalizarlo a todas las filas sin complicarlo en demasía
        CSV csv = new CSV();
        Table tabla = csv.readTable(RUTA + "miles_dollars.csv");
        List<Double> datoNum1 = tabla.getRows().get(1).getData();
        assertEquals(1345, datoNum1.get(0));
        assertEquals(2405, datoNum1.get(1));
    }

    @Test
    @DisplayName("Test de los datos")
    public void testDataWithLabel() throws IOException {
        // No sé cómo generalizarlo a todas las filas sin complicarlo en demasía
        CSV csv = new CSV();
        Table tabla = csv.readTable(RUTA + "iris.csv");
        List<Double> datoNum1 = tabla.getRows().get(1).getData();
        assertEquals(4.9, datoNum1.get(0));
        assertEquals(3.0, datoNum1.get(1));
        assertEquals(1.4, datoNum1.get(2));
        assertEquals(0.2, datoNum1.get(3));
        assertEquals(0, datoNum1.get(4));
    }



}