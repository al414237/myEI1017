package algoritmo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DistanceTest {

    @Test
    @DisplayName("Calcular distancia de dos conjuntos vacios")
    void testEmpty()  {
        KNN algoritmo = new KNN();

        List<Double> list1 = new ArrayList<>();
        List<Double> list2 = new ArrayList<>();

        assertEquals(0, algoritmo.distanciaEuclidea(list1, list2));
    }

    @Test
    @DisplayName("Calcular distancia de lista con ceros")
    void testZero() {
        KNN algoritmo = new KNN();

        List<Double> list1 = new ArrayList<>();
        List<Double> list2 = new ArrayList<>();
        list1.add(0.0);
        list1.add(2.0);
        list2.add(0.0);
        list2.add(2.0);

        assertEquals(0, algoritmo.distanciaEuclidea(list1, list2));
    }

    @Test
    @DisplayName("Calcular distancia de lista con sumas negativas")
    void testNegative() {
        KNN algoritmo = new KNN();

        List<Double> list1 = new ArrayList<>();
        List<Double> list2 = new ArrayList<>();
        list1.add(-1.5);
        list1.add(2.0);
        list2.add(1.5);
        list2.add(-2.0);

        assertEquals(5, algoritmo.distanciaEuclidea(list1, list2));
    }

    @Test
    @DisplayName("Calcular distancia de dos listas cualesquiera")
    void testExample() {
        KNN algoritmo = new KNN();

        List<Double> list1 = new ArrayList<>();
        List<Double> list2 = new ArrayList<>();
        list1.add(2.0);
        list1.add(3.0);
        list1.add(1.0);
        list2.add(-3.0);
        list2.add(2.0);
        list2.add(2.0);

        assertEquals(5.196, algoritmo.distanciaEuclidea(list1, list2), 0.001);
    }
}