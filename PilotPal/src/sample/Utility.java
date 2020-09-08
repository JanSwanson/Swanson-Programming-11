package sample;


import java.io.*;
import java.util.ArrayList;

public class Utility {

    //Requires: txt file:"ShipLog.txt"
    //Effects: parses each variable for each ship saved in ShipLog.txt. Returns loaded ships
    public static ArrayList<Ship> readShips() throws IOException {
        FileReader fr = new FileReader("ShipLog.txt");
        BufferedReader br = new BufferedReader(fr);
        ArrayList<Ship> loadedShips = new ArrayList<>();
        String line;
        String name;
        String type;
        String thruster;
        double thrusterHP;
        double leadAft;
        double quarter;
        double shoulder;
        double leadFwd;
        String wheelDirection;
        double asternAhead;
        double bridgeDistance;
        double centerlineDistance;
        String comments;
        while ((line = br.readLine()) != null) {
            name = line.substring(8, line.indexOf("&$/02/$&"));
            type = line.substring(line.indexOf("&$/02/$&") + 8, line.indexOf("&$/03/$&"));
            thruster = line.substring(line.indexOf("&$/03/$&") + 8, line.indexOf("&$/04/$&"));
            thrusterHP = Double.parseDouble(line.substring(line.indexOf("&$/04/$&") + 8, line.indexOf("&$/05/$&")));
            leadAft = Double.parseDouble(line.substring(line.indexOf("&$/05/$&") + 8, line.indexOf("&$/06/$&")));
            quarter = Double.parseDouble(line.substring(line.indexOf("&$/06/$&") + 8, line.indexOf("&$/07/$&")));
            shoulder = Double.parseDouble(line.substring(line.indexOf("&$/07/$&") + 8, line.indexOf("&$/08/$&")));
            leadFwd = Double.parseDouble(line.substring(line.indexOf("&$/08/$&") + 8, line.indexOf("&$/09/$&")));
            wheelDirection = line.substring(line.indexOf("&$/09/$&") + 8, line.indexOf("&$/10/$&"));
            asternAhead = Double.parseDouble(line.substring(line.indexOf("&$/10/$&") + 8, line.indexOf("&$/11/$&")));
            bridgeDistance = Double.parseDouble(line.substring(line.indexOf("&$/11/$&") + 8, line.indexOf("&$/12/$&")));
            centerlineDistance = Double.parseDouble(line.substring(line.indexOf("&$/12/$&") + 8, line.indexOf("&$/13/$&")));
            comments = line.substring(line.indexOf("&$/13/$&") + 8, line.indexOf("&$/14/$&"));
            loadedShips.add(new Ship(name, type, thruster, thrusterHP, leadAft, quarter, shoulder, leadFwd, wheelDirection, asternAhead, bridgeDistance, centerlineDistance, comments));
        }
        br.close();
        return loadedShips;
    }

    //Requires: Arraylist of ships
    //Modifies: txt file: "ShipLog.txt"
    //Effects: gets encrypted version of all ships in shipLog and writes to ShipLog.txt (no append)
    public static void save(ArrayList<Ship> shipLog) throws IOException {
        FileWriter fw = new FileWriter("ShipLog.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        if (shipLog.size() > 0) {
            for (Ship i : shipLog) {
                bw.write(i.encrypt());
            }
        } else {
            bw.write("");
        }
        bw.close();
    }

    //Requires: valid String from TextField or Area
    //Effects: checks if user inputted anything, if not, replaces nothing with space. When decrypting it gives the program something to find
    public static String checkForText(String inputTxt) {
        if (!inputTxt.equals("") && !inputTxt.equals("&$/01/$&") && !inputTxt.equals("&$/02/$&") && !inputTxt.equals("&$/03/$&") && !inputTxt.equals("&$/04/$&") && !inputTxt.equals("&$/05/$&") && !inputTxt.equals("&$/06/$&") && !inputTxt.equals("&$/07/$&") && !inputTxt.equals("&$/08/$&") && !inputTxt.equals("&$/09/$&") && !inputTxt.equals("&$/10/$&") && !inputTxt.equals("&$/11/$&") && !inputTxt.equals("&$/12/$&") && !inputTxt.equals("&$/13/$&") && !inputTxt.equals("&$/14/$&")) {
            return inputTxt;
        } else {
            return " ";
        }
    }

    //Requires: valid textField fx:id
    //Effects: if valid entry (a number) parses to double. else(if entry not valid) returns default 0
    public static double checkForDouble(String inputTxt) {
        try {
            return Double.parseDouble(inputTxt);
        } catch (Exception e) {
            return 0;
        }
    }

}
