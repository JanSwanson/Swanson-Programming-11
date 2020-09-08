import org.junit.Before;
import org.junit.Test;
import sample.Ship;
import sample.Utility;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestUtility {

    ArrayList<Ship> testLog;

    @Before
    public void setup() {
        testLog = new ArrayList<>();
        testLog.add(new Ship("Andromeda", "car", "yes", 2400, 24.5, 40.9, 27.2, 49.7, "R", 3400, 128.4, 60.8, "Thruster is not operational, under repair"));
        testLog.add(new Ship("Siegfried", "grain", "no", 0, 25.6, 39.2, 32.3, 51.9, "L", 2900, 148.2, 70.8, "Slow reaction time, weak steerage"));
    }

    @Test
    public void testSave() throws IOException {
        Utility.save(testLog);
        FileReader fr = new FileReader("ShipLog.txt");
        BufferedReader br = new BufferedReader(fr);
        ArrayList<String> encryptShips = new ArrayList<>();
        for (Ship i : testLog) {
            encryptShips.add(i.encrypt());
        }
        ArrayList<String> lines = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            lines.add(line + "\r");
        }
        br.close();
        assertEquals(encryptShips, lines);
    }

    @Test
    public void testRead() throws IOException {
        Utility.save(testLog);
        ArrayList<Ship> testLoadedShips = Utility.readShips();
        ArrayList<String> testLogEncrypt = new ArrayList<>();
        ArrayList<String> loadedShipsEncrypt = new ArrayList<>();
        for (Ship i : testLog) {
            testLogEncrypt.add(i.encrypt());
        }
        for (Ship i : testLoadedShips) {
            loadedShipsEncrypt.add(i.encrypt());
        }
        assertEquals(loadedShipsEncrypt, testLogEncrypt);
    }

    @Test
    public void testCheckTest() {
        //if input is "":
        assertEquals(" ", Utility.checkForText(""));
        //if input is valid:
        assertEquals("Oogabooga", Utility.checkForText("Oogabooga"));
        //if input equals encryption spacer:
        assertEquals(" ", Utility.checkForText("&$/13/$&"));
    }

    @Test
    public void testCheckDouble() {
        //if input is letter
        assertEquals(0.0, Utility.checkForDouble("lob"), 0);
        //if input is symbol
        assertEquals(0.0, Utility.checkForDouble("$"), 0);
        //if input is nothing
        assertEquals(0.0, Utility.checkForDouble(""), 0);
        //if input is valid
        assertEquals(56.9, Utility.checkForDouble("56.9"), 0);
    }
}