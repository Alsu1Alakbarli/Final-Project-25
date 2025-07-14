import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class BookingManager {
    
    private ArrayList<Flight> flights;

     public BookingManager() {
        // Load flights from file
        flights = FlightDataHelper.loadFlights();
        System.out.println("Loaded " + flights.size() + " flights.");
    }
    public int getFlightCount() {
        return flights.size();
    }


    public void createFlight(Flight flight){
        flights.add(flight);
        FlightDataHelper.saveFlights(flights); // Save to file
        System.out.println("Flight created successfully.");
}


    public void listFlights(){
        System.out.println("Total number of flights: " + flights.size());
        for (Flight flight : flights) System.out.println(flight);

        }
    

    // Search flights by any attribute
    public List<Flight> searchFlights(String keyword) {
        List<Flight> result = new ArrayList<>();
        for (Flight f : flights) {
            if (f.getDeparture().equalsIgnoreCase(keyword)
                || f.getArrive().equalsIgnoreCase(keyword)
                || f.getDeparture_time().contains(keyword)
                || f.getArrival_time().contains(keyword)
                || f.getFlightID().equalsIgnoreCase(keyword)
                || f.getAirlineName().equalsIgnoreCase(keyword)
                || String.valueOf(f.getPrice()).equals(keyword)
                || String.valueOf(f.getSeatCapacity()).equals(keyword)) {
                result.add(f);
            }
        }
        return result;
    }


    public void sortFlightsByPrice(){
        flights.sort(Comparator.comparingInt(Flight::getPrice));
        System.out.println("Flights sorted by price.");
    }

    // departure city
    public void sortFlightsByDepartureCity(){
        flights.sort(Comparator.comparing(Flight::getDeparture));
        System.out.println("Flights sorted by departure city");
    }

    // departure time
    public void sortFlightsByDepartureTime(){
        flights.sort(Comparator.comparing(Flight:: getDeparture_time));
        System.out.println("Flights sorted by departure time");
    }

    public boolean deleteFlight(String flight_ID){
    Flight flight = findFlightByID(flight_ID);
    if (flight != null){
        flights.remove(flight);
        FlightDataHelper.saveFlights(flights);
        return true;
    }
    return false;
}

    public Flight findFlightByID(String flightID){
        for(Flight f: flights){
            if (f.getFlightID().equalsIgnoreCase(flightID)){
                return f;
            }
        }
        return null;

    }

    public boolean editFlight(String id, Scanner sc) {
        Flight f = findFlightByID(id);
        if (f == null) {
            System.out.println("Flight not found.");
            return false;
        }

        System.out.println("Editing flight. Type field name (Departure, Arrive, Price, etc.): ");
        String field = sc.nextLine();

        try {
            switch (field) {
                case "Departure":
                    System.out.print("New departure: ");
                    f.setDeparture(sc.nextLine());
                    break;
                case "Arrive":
                    System.out.print("New arrival: ");
                    f.setArrive(sc.nextLine());
                    break;
                case "Departure_time":
                    System.out.print("New departure time: ");
                    f.setDeparture_time(sc.nextLine());
                    break;
                case "Arrival_time":
                    System.out.print("New arrival time: ");
                    f.setArrival_time(sc.nextLine());
                    break;
                case "Price":
                    System.out.print("New price: ");
                    f.setPrice(Integer.parseInt(sc.nextLine()));
                    break;
                case "AirlineName":
                    System.out.print("New airline: ");
                    f.setAirlineName(sc.nextLine());
                    break;
                case "SeatCapacity":
                    System.out.print("New seat capacity: ");
                    f.setSeatCapacity(Integer.parseInt(sc.nextLine()));
                    break;
                default:
                    System.out.println("Invalid field.");
                    return false;
            }

            FlightDataHelper.saveFlights(flights); // Save after editing
            System.out.println("Flight updated.");
            return true;
        } catch (Exception e) {
            System.out.println("Error updating: " + e.getMessage());
            return false;
        }
    }

    // BONUS 

    // Bonus 1: price range
    public void filterByPriceRange(int min, int max) {
        System.out.println("Flights within price range:");
        for (Flight f : flights) {
            if (f.getPrice() >= min && f.getPrice() <= max) {
                System.out.println(f);
            }
        }
    }

    // Bonus 2:  city (departure or arrival)
    public void filterByCity(String city) {
        System.out.println("Flights with city '" + city + "':");
        for (Flight f : flights) {
            if (f.getDeparture().equalsIgnoreCase(city) || f.getArrive().equalsIgnoreCase(city)) {
                System.out.println(f);
            }
        }
    }

    // Bonus 3: airline name
    public void filterByAirline(String airline) {
        System.out.println("Flights operated by '" + airline + "':");
        for (Flight f : flights) {
            if (f.getAirlineName().equalsIgnoreCase(airline)) {
                System.out.println(f);
            }
        }
    }
    public void sortFlightsByArrivalCity(){
    flights.sort(Comparator.comparing(Flight::getArrive));
    System.out.println("Flights sorted by arrival city");
}

public void sortFlightsByArrivalTime(){
    flights.sort(Comparator.comparing(Flight::getArrival_time));
    System.out.println("Flights sorted by arrival time");
}

public void sortFlightsByFlightID(){
    flights.sort(Comparator.comparing(Flight::getFlightID));
    System.out.println("Flights sorted by flight ID");
}

public void sortFlightsByAirlineName(){
    flights.sort(Comparator.comparing(Flight::getAirlineName));
    System.out.println("Flights sorted by airline name");
}

public void sortFlightsBySeatCapacity(){
    flights.sort(Comparator.comparingInt(Flight::getSeatCapacity));
    System.out.println("Flights sorted by seat capacity");
}
}