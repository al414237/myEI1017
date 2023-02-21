package lectura;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<String> headers;
    private List<Row> filas;

    public Table(List<String> atributos){
        headers = atributos;
    }

    public List<Double> getRowAt(int rowNumber){
        return null;
    }

    public boolean addRow(List<String> fila){
        if (fila!=null){
            List<Double> datos = new ArrayList<>();
            for (String dato: fila) {
                datos.add(Double.parseDouble(dato));
            }

            filas.add(new Row(datos));

        }
        return fila!=null;
    }


}
