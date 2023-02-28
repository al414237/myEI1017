package lectura;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSV {

    public Table readTable(String nombreFichero) throws IOException {
        BufferedReader fichero = new BufferedReader(new FileReader(nombreFichero));
        String fila = fichero.readLine();

        if (fila == null){
            throw new NullPointerException();
        }
        Table table = new Table( dividir(fila) );

        while ( ( fila = fichero.readLine() ) != null ){
            List<Double> datos = new ArrayList<>();
            for (String dato: dividir(fila)) {
                datos.add(Double.parseDouble(dato));
            }
            table.addRow(datos);
        }

        return table;
    }

    public TableWithLabels readTableWithLabels(String nombreFichero) throws IOException {
        BufferedReader fichero = new BufferedReader(new FileReader(nombreFichero));
        String fila = fichero.readLine();

        if (fila == null){
            throw new NullPointerException();
        }

        TableWithLabels table = new TableWithLabels( dividir(fila) );

        while ( ( fila = fichero.readLine() ) != null ){
            List<Double> numeros = new ArrayList<>();
            List<String> filaDividida = dividir(fila);
            for (String dato: filaDividida) {
                if ( ! dato.equals( lastOf(filaDividida) ) ){
                    numeros.add(Double.parseDouble(dato));
                } else {
                    String clase = dato;
                    table.addRow(numeros, clase);
                }
            }

        }

        return table;
    }

    private String lastOf(List<String> list) {
        return list.get( list.size() - 1 );
    }
    private List<String> dividir(String linea){
        return List.of(linea.split(","));
    }
}

