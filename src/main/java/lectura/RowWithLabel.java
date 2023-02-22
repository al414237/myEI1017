package lectura;

import java.util.List;

public class RowWithLabel extends Row {
    private Double numberClass;

    public RowWithLabel(List<Double> data){
        super(data);
        numberClass = data.get( data.size() - 1);
    }

    public Double getNumberClass() {
        return numberClass;
    }
}
