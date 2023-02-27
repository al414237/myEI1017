package lectura;

import javax.management.remote.SubjectDelegationPermission;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableWithLabels extends Table{
    Map<String, Integer> labelsToIndex = new HashMap<>();

    public TableWithLabels() {super(); }
    public TableWithLabels(List<String> atributos){
        super(atributos);
    }
    
    /**
     * Crea una lista a partir de las columnas de la fila pasado como argumento
     * y las añade como una nueva fila de la tabla. En este caso, la última columna
     * es la etiqueta, y para guardarla en una Row le asignamos un número.
     * Si la etiqueta es nueva, la añade a labelsToIndex.
     * @param fila Es una fila leída de un archivo CSV, cuya última columna indica la etiqueta
     * @return True si se pudieron añadir los datos de la fila y False en caso contrario.
     */
    @Override
    public boolean addRow(String fila) {
        List<String> lista = List.of(fila.split(","));
        List<Double> datos = new ArrayList<>();
        String clase = null;
        
        for (int i = 0; i < lista.size(); i++){
                if ( i == lista.size() - 1 ){           /* etiqueta de class */
                    clase = lista.get(i);
                    if (!labelsToIndex.containsKey(clase)) {
                        labelsToIndex.put(clase, labelsToIndex.size());
                    }
                    datos.add(Double.valueOf(labelsToIndex.get(clase)));
                } else {
                    datos.add(Double.parseDouble(lista.get(i)));
                }
        }
        return getRows().add(new RowWithLabel(datos));
    }

    @Override
    public List<Row> getRows() {
        return super.getRows();
    }
}
