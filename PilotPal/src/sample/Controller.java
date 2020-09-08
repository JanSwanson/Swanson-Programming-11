package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    public ListView shipsDisplay;
    public ArrayList<Ship> shipLog = new ArrayList<>();
    public ArrayList<Ship> tempLog = new ArrayList<>();
    public Ship selectedShip;
    public TextField searchShipsTxt;
    public Button searchShipsBtn;
    public TextField shipNameDisplay;
    public TextField shipTypeDisplay;
    public TextField thrusterDisplay;
    public TextField thrusterHPDisplay;
    public Button deleteShipBtn;
    public TextField leadAftDisplay;
    public TextField quarterDisplay;
    public TextField shoulderDisplay;
    public TextField leadFwdDisplay;
    public TextField wheelDirectionDisplay;
    public TextField asternAheadDisplay;
    public TextField bridgeDistanceDisplay;
    public TextField centerlineDistanceDisplay;
    public TextArea commentsDisplay;
    public TextField shipNameTxt;
    public TextField shipTypeTxt;
    public CheckBox thrusterCheckBox;
    public TextField thrusterHPTxt;
    public TextField leadAftTxt;
    public TextField quarterTxt;
    public TextField shoulderTxt;
    public TextField leadFwdTxt;
    public TextField wheelDirectionTxt;
    public TextField asternAheadTxt;
    public TextField centerlineDistanceTxt;
    public TextField bridgeDistanceTxt;
    public TextArea commentsTxt;
    public Button addShipBtn;
    public Button saveChangesBtn;

    //Requires: txt file: "ShipLog.txt"
    //Modifies: this
    //Effects: upon opening of program, reads ships from txt, loads ships to shipLog, loads ships to shipsDisplay
    public void initialize() throws IOException {
        shipLog = Utility.readShips();
        setShipsDisplay(shipLog);
        if (shipLog.size() > 0) {
            shipsDisplay.setDisable(false);
        }
        resetSelectedShip();
    }

    //Requires: entries in "add ship" page, (shipNameTxt|| shipTypeTxt) != "&$/__/$&"
    //Modifies: this, ShipLog.txt
    //Effects: adds new Ship based on entries to shipLog and display, saves shipLog to ShipLog.txt
    public void addShip(ActionEvent actionEvent) throws IOException {
        String name = Utility.checkForText(shipNameTxt.getText());
        String shipType = Utility.checkForText(shipTypeTxt.getText());
        String thruster;
        if (thrusterCheckBox.isSelected()) {
            thruster = "yes";
        } else {
            thruster = "no";
        }
        double thrusterHP = Utility.checkForDouble(thrusterHPTxt.getText());
        double leadAft = Utility.checkForDouble(leadAftTxt.getText());
        double quarter = Utility.checkForDouble(quarterTxt.getText());
        double shoulder = Utility.checkForDouble(shoulderTxt.getText());
        double leadFwd = Utility.checkForDouble(leadFwdTxt.getText());
        String wheelDirection = Utility.checkForText(wheelDirectionTxt.getText());
        double asternAhead = Utility.checkForDouble(asternAheadTxt.getText());
        double bridgeDistance = Utility.checkForDouble(bridgeDistanceTxt.getText());
        double centerlineDistance = Utility.checkForDouble(centerlineDistanceTxt.getText());
        String comments;
        if (!commentsTxt.getText().equals("")) {
            comments = commentsTxt.getText();
        } else {
            comments = " ";
        }
        shipLog.add(new Ship(name, shipType, thruster, thrusterHP, leadAft, quarter, shoulder, leadFwd, wheelDirection, asternAhead, bridgeDistance, centerlineDistance, comments));
        shipsDisplay.setDisable(false);
        setShipsDisplay(shipLog);
        resetAddShip();
        Utility.save(shipLog);
    }

    //Requires: a ship in listView is selected
    //Modifies: this, ShipLog.txt
    //Effects: removes selected Ship from shipLog and display, saves shipLog to ShipLog.txt
    public void deleteShip(ActionEvent actionEvent) throws IOException {
        resetSelectedShip();
        shipsDisplay.getItems().remove(selectedShip);
        shipLog.remove(selectedShip);
        if (!searchShipsTxt.getText().equals("")) {
            tempLog.remove(selectedShip);
        }
        if (shipsDisplay.getItems().size() < 1) {
            shipsDisplay.setDisable(true);
        }
        Utility.save(shipLog);
    }

    //Requires: shipsDisplay disable= false
    //Modifies: this
    //Effects: sets this.selectedShip to selected ship, enables selected ship displays and sets them accordingly
    public void selectShip(MouseEvent mouseEvent) {
        selectedShip = (Ship) shipsDisplay.getSelectionModel().getSelectedItem();
        shipNameDisplay.setText(selectedShip.getName());
        shipNameDisplay.setDisable(false);
        shipTypeDisplay.setText(selectedShip.getShipType());
        shipTypeDisplay.setDisable(false);
        thrusterDisplay.setText(selectedShip.getThruster());
        thrusterDisplay.setDisable(false);
        thrusterHPDisplay.setText(String.valueOf(selectedShip.getThrusterHP()));
        thrusterHPDisplay.setDisable(false);
        leadAftDisplay.setText(String.valueOf(selectedShip.getLeadAft()));
        leadAftDisplay.setDisable(false);
        quarterDisplay.setText(String.valueOf(selectedShip.getQuarter()));
        quarterDisplay.setDisable(false);
        shoulderDisplay.setText(String.valueOf(selectedShip.getShoulder()));
        shoulderDisplay.setDisable(false);
        leadFwdDisplay.setText(String.valueOf(selectedShip.getLeadFwd()));
        leadFwdDisplay.setDisable(false);
        wheelDirectionDisplay.setText(selectedShip.getWheelDirection());
        wheelDirectionDisplay.setDisable(false);
        asternAheadDisplay.setText(String.valueOf(selectedShip.getAsternAhead()));
        asternAheadDisplay.setDisable(false);
        bridgeDistanceDisplay.setText(String.valueOf(selectedShip.getBridgeDistance()));
        bridgeDistanceDisplay.setDisable(false);
        centerlineDistanceDisplay.setText(String.valueOf(selectedShip.getCenterlineDistance()));
        centerlineDistanceDisplay.setDisable(false);
        commentsDisplay.setText(selectedShip.getComments());
        commentsDisplay.setDisable(false);
        deleteShipBtn.setDisable(false);
        saveChangesBtn.setDisable(false);
    }

    //Requires: input from searchShipsTxt
    //Modifies: this
    //Effects: searches shipLog for names with starting letters equal to user input, sets shipsDisplay to these. If blank, returns to displaying shipLog
    public void searchShips(ActionEvent actionEvent) {
        if (searchShipsTxt.getText().length() > 0) {
            tempLog.clear();
            for (Ship i : shipLog) {
                if (i.getName().substring(0, searchShipsTxt.getText().length()).equals(searchShipsTxt.getText())) {
                    tempLog.add(i);
                }
            }
            setShipsDisplay(tempLog);
        } else {
            setShipsDisplay(shipLog);
            if (shipLog.size() > 0) {
                shipsDisplay.setDisable(false);
            }
        }
    }

    //Requires: changed ship stats
    //Modifies: this, ShipLog.txt
    //Effects: updates selected Ship to user specifications, saves shipLog to ShipLog.txt
    public void saveChanges(ActionEvent actionEvent) throws IOException {
        selectedShip.setName(Utility.checkForText(shipNameDisplay.getText()));
        selectedShip.setShipType(Utility.checkForText(shipTypeDisplay.getText()));
        selectedShip.setThruster(Utility.checkForText(thrusterDisplay.getText()));
        selectedShip.setThrusterHP(Utility.checkForDouble(thrusterHPDisplay.getText()));
        selectedShip.setLeadAft(Utility.checkForDouble(leadAftDisplay.getText()));
        selectedShip.setQuarter(Utility.checkForDouble(quarterDisplay.getText()));
        selectedShip.setShoulder(Utility.checkForDouble(shoulderDisplay.getText()));
        selectedShip.setLeadFwd(Utility.checkForDouble(leadFwdDisplay.getText()));
        selectedShip.setWheelDirection(Utility.checkForText(wheelDirectionDisplay.getText()));
        selectedShip.setAsternAhead(Utility.checkForDouble(asternAheadDisplay.getText()));
        selectedShip.setBridgeDistance(Utility.checkForDouble(bridgeDistanceDisplay.getText()));
        selectedShip.setCenterlineDistance(Utility.checkForDouble(centerlineDistanceDisplay.getText()));
        selectedShip.setComments(Utility.checkForText(commentsDisplay.getText()));
        setShipsDisplay(shipLog);
        Utility.save(shipLog);
    }

    //Modifies: this
    //Effects: clears all entries in add ship pane
    public void resetAddShip() {
        shipNameTxt.clear();
        shipTypeTxt.clear();
        thrusterCheckBox.setSelected(false);
        thrusterHPTxt.clear();
        leadAftTxt.clear();
        quarterTxt.clear();
        shoulderTxt.clear();
        leadFwdTxt.clear();
        wheelDirectionTxt.clear();
        asternAheadTxt.clear();
        bridgeDistanceTxt.clear();
        centerlineDistanceTxt.clear();
        commentsTxt.clear();
    }

    //Modifies: this
    //Effects: clears all entries in selected ship section and accurately disables everything
    public void resetSelectedShip() {
        shipNameDisplay.setText("");
        shipNameDisplay.setDisable(true);
        shipTypeDisplay.setText("");
        shipTypeDisplay.setDisable(true);
        thrusterDisplay.setText("");
        thrusterDisplay.setDisable(true);
        thrusterHPDisplay.setText("");
        thrusterHPDisplay.setDisable(true);
        leadAftDisplay.setText("");
        leadAftDisplay.setDisable(true);
        quarterDisplay.setText("");
        quarterDisplay.setDisable(true);
        shoulderDisplay.setText("");
        shoulderDisplay.setDisable(true);
        leadFwdDisplay.setText("");
        leadFwdDisplay.setDisable(true);
        wheelDirectionDisplay.setText("");
        wheelDirectionDisplay.setDisable(true);
        asternAheadDisplay.setText("");
        asternAheadDisplay.setDisable(true);
        bridgeDistanceDisplay.setText("");
        bridgeDistanceDisplay.setDisable(true);
        centerlineDistanceDisplay.setText("");
        centerlineDistanceDisplay.setDisable(true);
        commentsDisplay.clear();
        commentsDisplay.setDisable(true);
        deleteShipBtn.setDisable(true);
        saveChangesBtn.setDisable(true);
    }

    //Requires: ArrayList Ships
    //Modifies: this
    //Effects: makes setting the ListView "shipsDisplay" to an ArrayList easier
    public void setShipsDisplay(ArrayList<Ship> input) {
        shipsDisplay.getItems().clear();
        for (Ship i : input) {
            shipsDisplay.getItems().add(i);
        }
    }
}