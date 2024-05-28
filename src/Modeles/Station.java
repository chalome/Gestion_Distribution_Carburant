package Modeles;

public class Station {

    private int stationID;
    private String stationNIF;
    private String stationRC;
    private String stationNom;
    private String stationAdresse;

    public Station() {
    }

    public Station(int stationID, String stationNIF, String stationRC, String stationNom, String stationAdresse) {
        this.stationID = stationID;
        this.stationNIF = stationNIF;
        this.stationRC = stationRC;
        this.stationNom = stationNom;
        this.stationAdresse = stationAdresse;
    }

    public Station(String stationNIF, String stationRC, String stationNom, String stationAdresse) {
        this.stationNIF = stationNIF;
        this.stationRC = stationRC;
        this.stationNom = stationNom;
        this.stationAdresse = stationAdresse;
    }

    public int getStationID() {
        return stationID;
    }

    public void setStationID(int stationID) {
        this.stationID = stationID;
    }

    public String getStationNIF() {
        return stationNIF;
    }

    public void setStationNIF(String stationNIF) {
        this.stationNIF = stationNIF;
    }

    public String getStationRC() {
        return stationRC;
    }

    public void setStationRC(String stationRC) {
        this.stationRC = stationRC;
    }

    public String getStationNom() {
        return stationNom;
    }

    public void setStationNom(String stationNom) {
        this.stationNom = stationNom;
    }

    public String getStationAdresse() {
        return stationAdresse;
    }

    public void setStationAdresse(String stationAdresse) {
        this.stationAdresse = stationAdresse;
    }

    @Override
    public String toString() {
        return stationNom;
    }

}
