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
        if (fila != null){
            Table tabla = new Table(filaDividida(fila));
            while ( ( fila = fichero.readLine() ) != null ){
                tabla.addRow(filaDividida(fila));
            }


        }
        return null;
    }

    private List<String> filaDividida(String linea){
        return List.of(linea.split(","));
    }
}

