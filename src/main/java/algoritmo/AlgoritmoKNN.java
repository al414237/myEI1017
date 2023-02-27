package algoritmo;

import lectura.Row;
import lectura.Table;
import lectura.TableWithLabels;

import java.util.ArrayList;
import java.util.List;

public class AlgoritmoKNN implements KNN{

    List<TableWithLabels> datosAprendidos = new ArrayList<>();

    @Override
    public void train(TableWithLabels data) {
        datosAprendidos.add(data);
    }

    /**
     *  compara el ejemplar que se pasa como argumento con todos
     *  los ejemplares cargados mediante el método train, y devolverás
     *  como estimación el número de clase del ejemplar más cercano en
     *  la tabla que guardaste con la función train.
     * @param data
     * @return el número de clase del ejemplar más cercano, o -1 si no había datosAprendidos
     */
    @Override
    public Double estimate(List<Double> data) {
        double distanciaMinima = Double.POSITIVE_INFINITY;
        double claseDelMinimo = -1;

        for (TableWithLabels tabla: datosAprendidos){
            if (sonMismoTamaño(tabla, data)){                               /* la tabla concuerda con data */
                for (Row ejemplar: tabla.getRows()){
                    List<Double> dataEjemplar = ejemplar.getData();
                    double distanciaEjemplar = distanciaEuclidea(dataEjemplar, data);
                    if (distanciaEjemplar < distanciaMinima){
                        distanciaMinima = distanciaEjemplar;
                        claseDelMinimo = dataEjemplar.get(dataEjemplar.size()-1); // Si averiguo cómo, usar .getNumberClass
                    }
                }
            }
        }
        return claseDelMinimo;
    }

    private double distanciaEuclidea(List<Double> dataEjemplar, List<Double> data) {
        double distanciaActual = 0;
        for (int index = 0; index<data.size(); index++){
            distanciaActual += Math.pow(dataEjemplar.get(index) - data.get(index), 2);
        }
        return Math.sqrt(distanciaActual);
    }

    private boolean sonMismoTamaño(Table tabla, List<Double> data) {
        return tabla.numberOfAttributes() == data.size();
    }
}
