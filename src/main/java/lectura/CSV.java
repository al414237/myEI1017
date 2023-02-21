package lectura;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSV {

    /**
     * Lee el fichero que se le pasa como parámetro y crea una tabla a partir de los datos leídos en cada fila.
     * @param nombreFichero Nombre del fichero que se va a leer
     * @return Tabla del tipo Table
     */
    public Table readTable(String nombreFichero) throws IOException {
        BufferedReader fichero = new BufferedReader(new FileReader(nombreFichero));

        String fila = fichero.readLine();
        if (fila == null){
            throw new NullPointerException();
        }
        List<String> atributos = dividir(fila);

        Table table = lastOf(atributos).equals("class") ?
                      new TableWithLabels( atributos ):
                      new Table( atributos );

        while ( ( fila = fichero.readLine() ) != null ){
            table.addRow(fila);

            /**
             *  El profe me había dicho que mejor si le pasamos la lista hecha,
             *  pero no me sale a cuenta para tratar con las CSV con label
             */

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

