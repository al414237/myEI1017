package lectura;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private List<Double> data;

    public Row() { data = new ArrayList<>(); }
    public Row(List<Double> data){
        this.data = data;
    }
    public List<Double> getData(){
        return data;
    }

}
