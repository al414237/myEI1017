package algoritmo;

import lectura.Row;
import lectura.Table;
import lectura.TableWithLabels;

import java.util.*;

public class Kmeans {
    private int numClusters;
    private int numIterations;
    private long seed;
    private List<Row> centroides;
    //private List<Row> centroidesAnteriores
    private Table trainingData;
    private List<Integer> asignacionesData;

    public Kmeans(int numClusters, int numIterations, long seed){
        this.numClusters = numClusters;
        this.numIterations = numIterations;
        this.seed = seed;

        centroides = new ArrayList(numClusters);
    }

    public void train(Table datos){
        trainingData = datos;
        asignacionesData = new ArrayList<>(datos.numberOfRows());

        inicializaCentroides();
        for (int i=0; i < numIterations; i++){
            asignarDatosACentroides();
            recalculaCentroides();
        }
    }

    public Integer estimate(List<Double> dato){
        return 0;
    }

    /**
     * Aleatoriamente, pero con la semilla, reordena la tabla
     * datos para escoger los K primeros ejemplares y de ahí
     * saca los centroides.
     */
    private void inicializaCentroides(){
        List<Integer> randomIndex = indicesCentroides();
        for (int i=0; i<numClusters; i++){
            int index = randomIndex.get(i);
            centroides.add(trainingData.getRowAt(index));
        }
    }

    private List<Integer> indicesCentroides() {
        Random random = new Random(seed);
        List<Integer> lista = new ArrayList<>();

        for (int i=0; i<trainingData.numberOfRows(); i++){
            lista.add(i);
        }
        Collections.shuffle(lista);
        return lista.subList(0,numClusters);
    }

    private void asignarDatosACentroides(){
        for (int indexEjemplar=0; indexEjemplar < trainingData.numberOfRows(); indexEjemplar++){
            Row ejemplar = trainingData.getRowAt(indexEjemplar);
            double distanciaMinima = Double.POSITIVE_INFINITY;
            int indiceCentroideMinimo = -1;

            for (int indexCentroide=0; indexCentroide < numClusters; indexCentroide++){
                Row centroide = centroides.get(indexCentroide);
                double distanciaCentroideActual = distanciaEuclidea(ejemplar.getData(), centroide.getData());

                if (distanciaCentroideActual < distanciaMinima){
                    distanciaMinima = distanciaCentroideActual;
                    indiceCentroideMinimo = indexCentroide;
                }
            }
            asignacionesData.set(indexEjemplar, indiceCentroideMinimo);
        }
    }

    private void recalculaCentroides() {
    }

    private double distanciaEuclidea(List<Double> dataEjemplar, List<Double> data) { // lo he copiado del KNN
        double distanciaActual = 0;
        for (int index = 0; index < data.size(); index++){
            distanciaActual += Math.pow(dataEjemplar.get(index) - data.get(index), 2);
        }
        return Math.sqrt(distanciaActual);
    }
}
