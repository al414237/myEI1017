package lectura;

import java.util.List;

public class RowWithLabel extends Row {
    private int numberClass;

    public RowWithLabel(List<Double> data){ //añadir argumento de Int clase
        super(data);
        numberClass = ultimoValor(data);;
    }

    private int ultimoValor(List<Double> data) {
        return (int) Math.round(data.get( data.size() - 1));
    }

    public Integer getNumberClass() {
        return numberClass;
    }
}
