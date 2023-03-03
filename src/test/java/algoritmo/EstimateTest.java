package algoritmo;

import lectura.CSV;
import lectura.TableWithLabels;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EstimateTest {
    final String RUTA = System.getProperty("user.dir") + "\\archivos\\";


    @Test
    @DisplayName("Estimar clase con coincidencia exacta")
    void testCoincideEjemplar() throws IOException {
        KNN algoritmoKNN = new KNN();
        CSV csv = new CSV();
        TableWithLabels tabla = csv.readTableWithLabels(RUTA + "iris.csv");
        algoritmoKNN.train(tabla);

        List<Double> data = new ArrayList<>();
        data.add(7.0);
        data.add(3.2);
        data.add(4.7);
        data.add(1.4);

        assertEquals(1, algoritmoKNN.estimate(data));
    }

    @Test
    @DisplayName("Estimar clase con coincidencia semejante")
    void testConDatosCercanos() throws IOException {
        KNN algoritmoKNN = new KNN();
        CSV csv = new CSV();
        TableWithLabels tabla = csv.readTableWithLabels(RUTA + "iris.csv");
        algoritmoKNN.train(tabla);

        List<Double> data = new ArrayList<>();
        data.add(5.0);
        data.add(3.25);
        data.add(1.5);
        data.add(0.4);

        assertEquals(0, algoritmoKNN.estimate(data));
    }

    @Test
    @DisplayName("Estimar clase con poca semejanza")
    void testConDatosAlejados() throws IOException {
        KNN algoritmoKNN = new KNN();
        CSV csv = new CSV();
        TableWithLabels tabla = csv.readTableWithLabels(RUTA + "iris.csv");
        algoritmoKNN.train(tabla);

        List<Double> data = new ArrayList<>();
        data.add(6.0);
        data.add(3.0);
        data.add(9.0);
        data.add(6.0);

        assertEquals(2, algoritmoKNN.estimate(data));
    }

    @Test
    @DisplayName("Estimar clase con un caso controlado")
    void testConDatosIntermedios() throws IOException {
        KNN algoritmoKNN = new KNN();
        CSV csv = new CSV();
        TableWithLabels tabla = csv.readTableWithLabels(RUTA + "testLabel.csv");
        algoritmoKNN.train(tabla);

        List<Double> data = new ArrayList<>();
        data.add(5.0);
        data.add(3.25);
        data.add(3.0);
        data.add(1.6);
        assertEquals(0, algoritmoKNN.estimate(data));
    }
}