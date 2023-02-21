package lectura;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<String> headers;
    private List<Row> rows;

    public Table() { super(); }

    public Table(List<String> atributos){
        headers = atributos;
        rows = new ArrayList<>();
    }

    public List<Double> getRowAt(int rowNumber){
        return null;
    }

    public boolean addRow(List<Double> fila){
        return rows.add(new Row(fila));
    }

    public String toString(){
        StringBuilder cadena = new StringBuilder();
        for (String attribute: headers) {
            cadena.append(attribute + "\t");
        }
        cadena.append("\n");

        for (Row row: rows){
            cadena.append(row+"\n");
        }

        return cadena.toString();
    }
}
