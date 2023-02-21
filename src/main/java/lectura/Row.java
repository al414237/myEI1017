package lectura;

import java.util.List;

public class Row {
    private List<Double> data;

    public Row() { super(); }
    public Row(List<Double> data){
        this.data = data;
    }
    public List<Double> getData(){
        return data;
    }

    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder();
        for (Double num: data)
            cadena.append(num+"\t");
        return cadena.toString();
    }
}
