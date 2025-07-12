import java.io.Serializable; //object can be saved to a file in binary format(.dat)

public class Passenger implements Serializable{
    

    private String name;
    private String surname;
    private String passportID;
    private String seat;
    private String flightID;
    private String passengerID;

    // constructor
    public Passenger(String name, String surname, String passportID, String seat, String flightID, String passengerID) {
        this.name = name;
        this.surname = surname;
        this.passportID = passportID;
        this.seat = seat;
        this.flightID = flightID;
        this.passengerID = passengerID;
    }

    // getter and settes
    public String getName(){
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getPassportID() {
        return passportID;
    }
    public String getSeat() {
        return seat;
    }
    public String getFlightID() {
        return flightID;
    }
    public String getPassengerID() {
        return passengerID;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }
    public void setSeat(String seat) {
        this.seat = seat;
    }
    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }
    public void setPassengerID(String passengerID) {
        this.passengerID = passengerID;
    }

    public void changeSeat(String newSeat){
        this.seat = newSeat;
    }

    @Override //returns all passenger info as one line of text (CSV format)
    public String toString() {
        return passengerID + "," + name + "," + surname + "," + passportID + "," + seat + "," + flightID;
    }

    public static Passenger fromString(String line) { //creates Passenger object from line of text
        String[] parts = line.split(",");
        return new Passenger(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]); //then Create new Passenger using the parts from the line
    }



}
