package lectura;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSV {

    public CSV() { super(); }
    /**
     * Lee el fichero que se le pasa como parámetro y crea una
     * tabla a partir de los datos.
     * @param nombreFichero Nombre del fichero que se va a leer
     * @return Tabla del tipo Table
     */
    public Table readTable(String nombreFichero) throws IOException {
        BufferedReader fichero = new BufferedReader(new FileReader(nombreFichero));

        String row = fichero.readLine();
        if (row == null){
            throw new NullPointerException();
        }

        Table table = new Table( dividir(row) );
        while ( ( row = fichero.readLine() ) != null ){
            // DUDA: ¿podría evitar esta sintaxis sin tener que pasar al menos una vez?

            table.addRow(enlistar(row));
        }
        return table;

    }

    private List<Double> enlistar(String fila) {
        List<Double> datos = new ArrayList<>();
        for (String dato: dividir(fila)) {
            datos.add(Double.parseDouble(dato));
        }
        return datos;
    }

    private List<String> dividir(String linea){
        return List.of(linea.split(","));
    }
}

