package lectura;

import javax.management.remote.SubjectDelegationPermission;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableWithLabels<T> extends Table{
    Map<String, Integer> labelsToIndex = new HashMap<>();

    public TableWithLabels() {super(); }
    public TableWithLabels(List<String> atributos){
        super(atributos);
    }


    public boolean addRow(List<Double> numeros, String clase) {
        if (!labelsToIndex.containsKey(clase)) {
            labelsToIndex.put(clase, labelsToIndex.size());
        }
        //numeros.add( Double.valueOf( labelsToIndex.get(clase) ) );

        return getRows().add( new RowWithLabel(numeros) ); //pasar clase
    }
}
