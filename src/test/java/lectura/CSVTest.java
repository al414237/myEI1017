package lectura;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class CSVTest {

    @Test
    public void testLectura() throws FileNotFoundException {
        CSV csv = new CSV();
        csv.readTable("miles_dollars");
    }

}