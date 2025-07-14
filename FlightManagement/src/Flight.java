import java.io.Serializable;
import java.util.ArrayList;

public class Flight implements Serializable {
    private String departure;
    private String arrive;
    private String departure_time;
    private String arrival_time;
    private int price;
    private String flightID;
    private String airlineName;
    private int seatCapacity;
    private ArrayList<Passenger> passengers; // Association with Passenger class

    // Constructor
    public Flight(String departure, String arrive, String departure_time, String arrival_time, String flightID, String airlineName, int price, int seatCapacity) {
        this.departure = departure;
        this.arrive = arrive;
        this.departure_time = departure_time;
        this.arrival_time = arrival_time;
        this.flightID = flightID;
        this.airlineName = airlineName;
        this.price = price;
        this.seatCapacity = seatCapacity;
        this.passengers = new ArrayList<>(); // Initialize passengers list
    }

    // Getters and Setters
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

    // Association getter/setter
    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    // Method to add a passenger
    public boolean addPassenger(Passenger passenger) {
        if (passengers.size() < seatCapacity) {
            passengers.add(passenger);
            return true;
        }
        return false; // Flight is full
    }

    // Method to remove a passenger
    public boolean removePassenger(Passenger passenger) {
        return passengers.remove(passenger);
    }

    // Get available seats
    public int getAvailableSeats() {
        return seatCapacity - passengers.size();
    }

    // Delay method (bonus feature)
    public void delay(int delay_in_minute) {
        // Note: This is a simple string concatenation. For real time handling,
        // you'd want to use proper date/time classes
        this.departure_time = this.departure_time + " (delayed " + delay_in_minute + " min)";
        this.arrival_time = this.arrival_time + " (delayed " + delay_in_minute + " min)";
    }

    @Override
    public String toString() {
        return "Flight ID: " + flightID + ", Airline: " + airlineName + ", From: " + departure + ", To: " + arrive +
               ", Departure: " + departure_time + ", Arrival: " + arrival_time + ", Price: $" + price + 
               ", Seats: " + getAvailableSeats() + "/" + seatCapacity;
    }

    // Method for file I/O (if needed)
    public String toFileString() {
        return flightID + "," + airlineName + "," + departure + "," + arrive + "," + 
               departure_time + "," + arrival_time + "," + price + "," + seatCapacity;
    }

    // Static method to create Flight from file string
    public static Flight fromFileString(String fileString) {
        try {
            String[] parts = fileString.split(",");
            return new Flight(parts[2], parts[3], parts[4], parts[5], parts[0], parts[1], 
                            Integer.parseInt(parts[6]), Integer.parseInt(parts[7]));
        } catch (Exception e) {
            System.out.println("Error parsing flight data: " + e.getMessage());
            return null;
        }
    }
}