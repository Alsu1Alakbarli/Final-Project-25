import java.io.Serializable;
import java.util.ArrayList;

class Flight implements Serializable{

    private String departure;
    private String arrive;
    private String departure_time;
    private String arrival_time;
    private int price;
    private String flightID;
    private String airlineName;
    private int seatCapacity;
    
    // cosntructor
    public Flight(String departure, String arrive, String departure_time, String arrival_time, String flightID, String airlineName, int price, int seatCapacity) {
        this.departure = departure;
        this.arrive = arrive;
        this.departure_time = departure_time;
        this.arrival_time = arrival_time;
        this.flightID = flightID;
        this.airlineName = airlineName;
        this.price = price;
        this.seatCapacity = seatCapacity;
    }
    // getter and setters
    public String getDeparture() {
        return departure;
    }
    public void setDeparture(String departure) {
        this.departure = departure;
    }
    public String getArrive() {
        return arrive;
    }
    public void setArrive(String arrive) {
        this.arrive = arrive;
    }
    public String getDeparture_time() {
        return departure_time;
    }
    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }
    public String getArrival_time() {
        return arrival_time;
    }
    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getFlightID() {
        return flightID;
    }
    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }
    public String getAirlineName() {
        return airlineName;
    }
    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }
    public int getSeatCapacity() {
        return seatCapacity;
    }
    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public void delay(int delay_in_minute){
        this.departure_time = this.departure_time + delay_in_minute;
        this.arrival_time = this.arrival_time + delay_in_minute;
    }

    public String toString(){
        return "Flight ID: " + flightID + ", Airline: " + airlineName + ", From: " + departure + ", To: " + arrive + 
        ", Departure: " + departure_time + ", Arrival: " + arrival_time + ", Price: " + price + ", Seats: " + seatCapacity;
    }


}
