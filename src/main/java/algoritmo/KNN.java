package algoritmo;

import lectura.RowWithLabel;
import lectura.TableWithLabels;

import java.util.List;

public class KNN {
    private TableWithLabels trainingData;

    public void train(TableWithLabels data) {
        trainingData = data;
    }

    public Integer estimate(List<Double> data) {
        double distanciaMinima = Double.POSITIVE_INFINITY;
        int claseDelMinimo = -1;

        for (RowWithLabel ejemplar: trainingData.getRows()){ // DEJAR DE USAR GETrows y usar getRowAt
            List<Double> dataEjemplar = ejemplar.getData();
            double distanciaEjemplar = distanciaEuclidea(dataEjemplar, data);

            if (distanciaEjemplar < distanciaMinima){
                distanciaMinima = distanciaEjemplar;
                claseDelMinimo = ejemplar.getNumberClass();
            }
        }

        return claseDelMinimo;
    }

    public double distanciaEuclidea(List<Double> dataEjemplar, List<Double> data) {
        double distanciaActual = 0;
        for (int index = 0; index < data.size(); index++){
            distanciaActual += Math.pow(dataEjemplar.get(index) - data.get(index), 2);
        }
        return Math.sqrt(distanciaActual);
    }
}
