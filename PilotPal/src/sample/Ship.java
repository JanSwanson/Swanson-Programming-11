package sample;

public class Ship {

    private String name;
    private String shipType;
    private String thruster;
    private double thrusterHP;
    private double leadAft;
    private double quarter;
    private double shoulder;
    private double leadFwd;
    private String wheelDirection;
    private double asternAhead;
    private double bridgeDistance;
    private double centerlineDistance;
    private String comments;

    public Ship(String name, String shipType, String thruster, double thrusterHP, double leadAft, double quarter, double shoulder, double leadFwd, String wheelDirection, double asternAhead, double bridgeDistance, double centerlineDistance, String comments) {
        this.name = name;
        this.shipType = shipType;
        this.thruster = thruster;
        this.thrusterHP = thrusterHP;
        this.leadAft = leadAft;
        this.quarter = quarter;
        this.shoulder = shoulder;
        this.leadFwd = leadFwd;
        this.wheelDirection = wheelDirection;
        this.asternAhead = asternAhead;
        this.bridgeDistance = bridgeDistance;
        this.centerlineDistance = centerlineDistance;
        this.comments = comments;
    }

    //Requires: all fields != ""
    //Effects: puts all fields of object into string with unique identifiable spacers
    public String encrypt() {
        String txt = "&$/01/$&" + name + "&$/02/$&" + shipType + "&$/03/$&" + thruster + "&$/04/$&" + thrusterHP + "&$/05/$&" + leadAft + "&$/06/$&" + quarter + "&$/07/$&" + shoulder + "&$/08/$&" + leadFwd + "&$/09/$&" + wheelDirection + "&$/10/$&" + asternAhead + "&$/11/$&" + bridgeDistance + "&$/12/$&" + centerlineDistance + "&$/13/$&" + comments + "&$/14/$&" + "\r";
        return txt;
    }

    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public String getShipType() {
        return shipType;
    }

    public String getThruster() {
        return thruster;
    }

    public double getThrusterHP() {
        return thrusterHP;
    }

    public double getLeadAft() {
        return leadAft;
    }

    public double getQuarter() {
        return quarter;
    }

    public double getShoulder() {
        return shoulder;
    }

    public double getLeadFwd() {
        return leadFwd;
    }

    public String getWheelDirection() {
        return wheelDirection;
    }

    public double getAsternAhead() {
        return asternAhead;
    }

    public double getBridgeDistance() {
        return bridgeDistance;
    }

    public double getCenterlineDistance() {
        return centerlineDistance;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShipType(String shipType) {
        this.shipType = shipType;
    }

    public void setThruster(String thruster) {
        this.thruster = thruster;
    }

    public void setThrusterHP(double thrusterHP) {
        this.thrusterHP = thrusterHP;
    }

    public void setLeadAft(double leadAft) {
        this.leadAft = leadAft;
    }

    public void setQuarter(double quarter) {
        this.quarter = quarter;
    }

    public void setShoulder(double shoulder) {
        this.shoulder = shoulder;
    }

    public void setLeadFwd(double leadFwd) {
        this.leadFwd = leadFwd;
    }

    public void setWheelDirection(String wheelDirection) {
        this.wheelDirection = wheelDirection;
    }

    public void setAsternAhead(double asternAhead) {
        this.asternAhead = asternAhead;
    }

    public void setBridgeDistance(double bridgeDistance) {
        this.bridgeDistance = bridgeDistance;
    }

    public void setCenterlineDistance(double centerlineDistance) {
        this.centerlineDistance = centerlineDistance;
    }
}