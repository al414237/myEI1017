package lectura;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TablaTest {
    final String RUTA = System.getProperty("user.dir") + "\\src\\main\\java\\archivos\\";

    @Test
    @DisplayName("Test del numero de filas")
    public void testRowsWithoutLabel() throws IOException {
        CSV csv = new CSV();
        Table tabla = csv.readTable(RUTA + "miles_dollars.csv");
        assertEquals(25, tabla.numberOfRows());
    }

    @Test
    @DisplayName("Test del numero de columnas")
    public void testColumnsWithoutLabel() throws IOException {
        CSV csv = new CSV();
        Table tabla = csv.readTable(RUTA + "miles_dollars.csv");
        assertEquals(2, tabla.numberOfAttributes());
    }

    @Test
    @DisplayName("Test del numero de filas con etiqueta")
    public void testRowsWithLabel() throws IOException {
        CSV csv = new CSV();
        TableWithLabels tabla = csv.readTableWithLabels(RUTA + "iris.csv");
        assertEquals(150, tabla.numberOfRows());
    }

    @Test
    @DisplayName("Test del numero de filas con etiqueta")
    public void testColumnsWithLabel() throws IOException {
        CSV csv = new CSV();
        TableWithLabels tabla = csv.readTableWithLabels(RUTA + "iris.csv");
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
    @DisplayName("Test de las etiquetas con etiqueta")
    public void testLabelWithLabel() throws IOException {
        CSV csv = new CSV();
        TableWithLabels tabla = csv.readTableWithLabels(RUTA + "iris.csv");
        assertEquals("sepal length", tabla.getHeaders().get(0));
        assertEquals("sepal width", tabla.getHeaders().get(1));
        assertEquals("petal length", tabla.getHeaders().get(2));
        assertEquals("petal width", tabla.getHeaders().get(3));
        assertEquals("class", tabla.getHeaders().get(4));
    }

    @Test
    @DisplayName("Test de los datos")
    public void testDataWithoutLabel() throws IOException {
        CSV csv = new CSV();
        Table tabla = csv.readTable(RUTA + "miles_dollars.csv");
        List<Double> datoNum1 = tabla.getRowAt(1).getData();
        assertEquals(1345, datoNum1.get(0));
        assertEquals(2405, datoNum1.get(1));
    }

    @Test
    @DisplayName("Test de los datos con etiqueta")
    public void testDataWithLabel() throws IOException {
        CSV csv = new CSV();
        TableWithLabels tabla = csv.readTableWithLabels(RUTA + "iris.csv");
        List<Double> datoNum1 = tabla.getRowAt(1).getData();
        assertEquals(4.9, datoNum1.get(0));
        assertEquals(3.0, datoNum1.get(1));
        assertEquals(1.4, datoNum1.get(2));
        assertEquals(0.2, datoNum1.get(3));
    }

    @Test
    @DisplayName("Test de la etiqueta")
    public void testLabel() throws IOException {
        CSV csv = new CSV();
        TableWithLabels tabla = csv.readTableWithLabels(RUTA + "iris.csv");
        RowWithLabel datoNum1 = tabla.getRowAt(1);
        assertEquals(0, datoNum1.getNumberClass());
    }

}