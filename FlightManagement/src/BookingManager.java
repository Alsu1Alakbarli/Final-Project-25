import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookingManager {

    private ArrayList<Flight> flights = new ArrayList<>();
    private ArrayList<Passenger> passengers = new ArrayList<>();

    public BookingManager(){
        // read from local
    }

    public void createFlight(Flight flight){
        flights.add(flight);
        System.out.println("Flight created successfully.");
    }


    public void createPassenger(Passenger passenger){
        passengers.add(passenger);
        Flight flight = findFlightByID(passenger.getFlightID());

        if (flight != null){
            flight.getPassengers().add(passenger);
            System.out.println("Passenger booking created successfully");
        }
        else{
            System.out.println("All seats sold out!!!");
        }

    }

    public void listFlights(){
        System.out.println("Total number of flights: " + flights.size());
        for (Flight flight : flights) {
            flight.toString();
        }
    }


      public Flight findFlightByID(String flightID){
        for(Flight f: flights){
            if (f.getFlightID().equalsIgnoreCase(flightID)){
                return f;
            }
        }
        return null;

    }

    public List<Flight> searchFlights(String keyword){
        List<Flight> results =  new ArrayList<>();

        for (Flight flight : flights) {
            if (flight.getDeparture().equalsIgnoreCase(keyword) || 
                flight.getArrive().equalsIgnoreCase(keyword) ||
                flight.getArrival_time().equalsIgnoreCase(keyword) ||
                flight.getDeparture_time().equalsIgnoreCase(keyword) ||
                String.valueOf(flight.getPrice()).equals(keyword) ||
                flight.getFlightID().equalsIgnoreCase(keyword) ||
                flight.getAirlineName().equals(keyword) ||
                String.valueOf(flight.getSeatCapacity()).equals(keyword)     
                ){
                    results.add(flight);
                }
        }


        return results;
    }

    public void sortFlightsByPrice(){
        flights.sort(Comparator.comparingInt(Flight::getPrice));
        System.out.println("Flights sorted by price.");
    }

    // departime city

    // departure time
    
    
}
