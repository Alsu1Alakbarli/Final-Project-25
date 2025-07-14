import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BookingManager {

    private ArrayList<Flight> flights = new ArrayList<>();
    private ArrayList<Passenger> passengers = new ArrayList<>();

    public BookingManager() {
    flights = FlightDataHelper.loadFlights();
    System.out.println("Loaded " + flights.size() + " flights from file.");
}


    public void createFlight(Flight flight){
    flights.add(flight);
    FlightDataHelper.saveFlights(flights);
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
    public void sortFlightsByDepartureCity(){
        flights.sort(Comparator.comparing(Flight::getDeparture));
        System.out.println("Flights sorted by departure city");
    }

    // departure time
    public void sortFlightsByDepartureTime(){
        flights.sort(Comparator.comparing(Flight:: getDeparture_time));
        System.out.println("Flights sorted by departure time");
    }

    public boolean editFlight(String flightID, Scanner sc){
        Flight flight = findFlightByID(flightID);

        System.out.println("Now you are editing/updating flight info:");
        System.out.println("Which parameter do you want to edit from the following list: ");
        System.out.println("\t\t[Departure, Arrive, Departure_time, Arrival_time, Price, Flight_ID, AirlineName, SeatCapacity]");
        System.out.println("Please enter the attribte from the above list: ");

        String user_in = sc.nextLine();
        boolean flag = false;
        switch (user_in) {
            case "Departure":
                System.out.println("Please enter new departure destination: ");
                String new_departure = sc.nextLine();
                flight.setDeparture(new_departure);
                flag = true;
                break;

            case "Arrive":
                System.out.println("Please enter new arrive destination: ");
                String new_arrive = sc.nextLine();
                flight.setArrive(new_arrive);
                flag = true;
                break;
        
            case "Departure_time":
                System.out.println("Please enter new separture time: ");
                String new_dept_time = sc.nextLine();
                flight.setDeparture_time(new_dept_time);
                flag = true;
                break;

                
            case "Arrival_time":
                System.out.println("Please enter new arrival time: ");
                String new_arr_time = sc.nextLine();
                flight.setArrival_time(new_arr_time);
                flag = true;
                break;
            
                
            case "Price":
                System.out.println("Please enter new price: ");
                int new_price = sc.nextInt();
                flight.setPrice(new_price);
                flag=true;
                break;

             case "AirlineName":
                System.out.println("Please enter new AirlineName: ");
                String new_airline_name = sc.nextLine();
                flight.setAirlineName(new_airline_name);
                flag=true;
                break;

             case "SeatCapacity":
                System.out.println("Please enter new SeatCapacity: ");
                int new_seat_capacity = sc.nextInt();
                flight.setSeatCapacity(new_seat_capacity);
                flag = true;
                break;

            
            
            default:
                System.out.println("Your input is not reliable");
                break;
        }

        if (flag) {
    FlightDataHelper.saveFlights(flights);
    }


        return flag;

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

    
}
