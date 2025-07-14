import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        BookingManager manager = new BookingManager();

        //create sample flights
         // System.out.println("Do you want to create base sample flights? (yes/no): ");
        // String answer = scn.next();
        // if (answer.equalsIgnoreCase("yes")) {
         //    FlightDataHelper.createSampleFlights();
     //}

        while (true) {
            System.out.println("=========  Welcome to the Flight Management Menu  =========");
            System.out.println("1. Create a new flight");
            System.out.println("2. List all existed flights");
            System.out.println("3. Search flights by any attribute");
            System.out.println("4. Sort flights by price");
            System.out.println("5. Sort flights by departure city");
            System.out.println("6. Sort flights by departure time");
            System.out.println("7. Edit a flight");
            System.out.println("8. Delete a flight");

            System.out.println("9. Filter by price range"); // BONUS 
            System.out.println("10. Filter by city"); // BONUS
            System.out.println("11. Filter by airline name"); // BONUS
            System.out.println("0. Exit");

            int choice = readInt(scn, "Choose an option: ");
            scn.nextLine(); // Clear buffer


            switch (choice) {
                case 1:
                    scn.nextLine();
                    System.out.println("User wants to create a new flight:");

                    System.out.print("Flight ID: ");
                    String flight_id = scn.nextLine();

                    System.out.print("Departure city: ");
                    String dept_city = scn.nextLine();

                    System.out.print("Arrival city: ");
                    String arr_city = scn.nextLine();

                    System.out.print("Departure time (yyyy-MM-dd HH:mm): ");
                    String dept_time = scn.nextLine();

                    System.out.print("Arrival time (yyyy-MM-dd HH:mm): ");
                    String arr_time = scn.nextLine();

                    int price = readInt(scn, "Price: ");
                    scn.nextLine(); 

                    System.out.print("Airline name: ");
                    String airline_name = scn.nextLine();

                    int seat_cap = readInt(scn, "Seat capacity: ");

                    Flight new_flight = new Flight(dept_city, arr_city, dept_time, arr_time, flight_id, airline_name, price, seat_cap);
                    manager.createFlight(new_flight);
                    break;

                case 2: //show all flights
                    System.out.println("User wants to list all existed flights");
                    manager.listFlights(); //prints all saved flights
                    break;

                case 3: //search for flights
                    System.out.print("Enter keyword: ");
                    String keyword = scn.nextLine();
                    List<Flight> results = manager.searchFlights(keyword);
                    if (results.isEmpty()) {
                        System.out.println("No flights found.");
                    } else {
                        for (Flight f : results) System.out.println(f);
                    }
                    break;
                    
                case 4: //sort by price
                    manager.sortFlightsByPrice();
                    manager.listFlights();
                    break;

                case 5: //sort by departure city
                    manager.sortFlightsByDepartureCity();
                    manager.listFlights();
                    break;

                case 6: //sort by departure time
                    manager.sortFlightsByDepartureTime();
                    manager.listFlights();
                    break;

                case 7: //edit flight's information
                    scn.nextLine(); 
                    System.out.print("Enter flight ID to edit: ");
                    String flightID = scn.nextLine();
                    manager.editFlight(flightID, scn);
                    break;

                case 8: ///delete a flight
                    scn.nextLine(); 
                    System.out.print("Enter flight ID to delete: ");
                    String deleteID = scn.nextLine();

                    // try to delete the flight
                    boolean deleted = manager.deleteFlight(deleteID);
                    System.out.println(deleted ? "Flight deleted." : "Flight not found.");
                    break;

                    //Bonus 

                    case 9: // BONUS: Filter by price range
                    int min = readInt(scn, "Minimum price: ");
                    int max = readInt(scn, "Maximum price: ");
                    manager.filterByPriceRange(min, max);
                    break;

                case 10: // BONUS: Filter by city
                    System.out.print("Enter departure or arrival city: ");
                    String city = scn.nextLine();
                    manager.filterByCity(city);
                    break;

                case 11: // BONUS: Filter by airline name
                    System.out.print("Enter airline name: ");
                    String airline = scn.nextLine();
                    manager.filterByAirline(airline);
                    break;

                case 0: // Exit
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }

            
            System.out.println("\nDo you want to continue? (yes/no): ");
            String cont = scn.next();
            if (!cont.equalsIgnoreCase("yes")) {
                System.out.println("Exiting system...");
                break;
            }
                        System.out.println("-----------------------------------------------------------");

        }

        scn.close();
    }

    //helps to read number safely
    public static int readInt(Scanner scn, String prompt) {
        int value;
        while (true) {
            try {
                System.out.print(prompt);
                value = Integer.parseInt(scn.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }
}


