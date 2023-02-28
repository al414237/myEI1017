package lectura;

import java.util.ArrayList;
import java.util.List;

public class Table<T> {
    private List<String> headers;
    private List<Row> rows;

    public Table() {
        headers = new ArrayList<>();
        rows = new ArrayList<>();
    }

    public Table(List<String> atributos){
        headers = atributos;
        rows = new ArrayList<>();
    }

    public List<Double> getRowAt(int rowNumber){
        return rows.get(rowNumber).getData();
    }

    public boolean addRow(List<Double> datos){
        return rows.add(new Row(datos));
    }


    public int numberOfRows(){
        return rows.size();
    }

    public int numberOfAttributes(){
        return headers.size();
    }

    public List<String> getHeaders(){
        return headers;
    }

    public List< Row > getRows(){
        return rows;
    }

}
