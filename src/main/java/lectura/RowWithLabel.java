package lectura;

import java.util.List;

public class RowWithLabel extends Row {
    private int numberClass;

    public RowWithLabel(List<Double> data, int numeroClase){
        super(data);
        numberClass = numeroClase;
        data.add( (double) numberClass );
    }

    public Integer getNumberClass() {
        return numberClass;
    }
}
