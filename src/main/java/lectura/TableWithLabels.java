package lectura;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableWithLabels extends Table{
    private Map<String, Integer> labelsToIndex = new HashMap<>();

    public TableWithLabels(List<String> atributos){
        super(atributos);
    }

    public boolean addRow(List<Double> numeros, String clase) {
        if (!labelsToIndex.containsKey(clase)) {
            labelsToIndex.put(clase, labelsToIndex.size());
        }
        Integer numeroClase = labelsToIndex.get(clase);

        return getRows().add( new RowWithLabel(numeros, numeroClase) );
    }

    @Override
    public RowWithLabel getRowAt(int rowNumber) {
        return (RowWithLabel) super.getRowAt(rowNumber);
    }

    @Override
    public List<RowWithLabel> getRows(){
        return super.getRows();
    }
}
