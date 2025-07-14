import java.io.Serializable;

public class Passenger implements Serializable {
    private String passengerID;
    private String name; // "Lastname_Firstname" format
    private String email;
    private String phone;
    private String address; // "Street_City" format
    private int age;
    private String seatNumber;
    private String flightID; // Association with Flight class
    
    // Constructor
    public Passenger(String passengerID, String name, String email, String phone, 
                    String address, int age, String seatNumber, String flightID) {
        this.passengerID = passengerID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.age = age;
        this.seatNumber = seatNumber;
        this.flightID = flightID;
    }
    
    // Getters and Setters
    public String getPassengerID() {
        return passengerID;
    }
    
    public void setPassengerID(String passengerID) {
        this.passengerID = passengerID;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getSeatNumber() {
        return seatNumber;
    }
    
    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
    
    public String getFlightID() {
        return flightID;
    }
    
    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }
    
    @Override
    public String toString() {
        return "Passenger ID: " + passengerID + ", Name: " + name + ", Email: " + email + 
               ", Phone: " + phone + ", Address: " + address + ", Age: " + age + 
               ", Seat: " + seatNumber + ", Flight: " + flightID;
    }
    
    // Method for file I/O
    public String toFileString() {
        return passengerID + "," + name + "," + email + "," + phone + "," + 
               address + "," + age + "," + seatNumber + "," + flightID;
    }
    
    // Static method to create Passenger from file string
    public static Passenger fromFileString(String fileString) {
        try {
            String[] parts = fileString.split(",");
            return new Passenger(parts[0], parts[1], parts[2], parts[3], 
                               parts[4], Integer.parseInt(parts[5]), parts[6], parts[7]);
        } catch (Exception e) {
            System.out.println("Error parsing passenger data: " + e.getMessage());
            return null;
        }
    }
}