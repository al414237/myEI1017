package lectura;

import java.util.List;
import java.util.Map;

public class RowWithLabel extends Row {
    private int numberClass;

    public RowWithLabel(List<Double> data, int labelNumber){
        super(data);
        numberClass = labelNumber;
    }

    public int getNumberClass() {
        return numberClass;
    }
}
