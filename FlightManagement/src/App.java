import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        BookingManager manager = new BookingManager();

        // // Create sample flights
        // System.out.println("Do you want to create base sample flights? (yes/no): ");
        // String answer = scn.nextLine();
        // if (answer.equalsIgnoreCase("yes")) {
        //     FlightDataHelper.createSampleFlights();
        // }

        while (true) {
            System.out.println("=========  Welcome to the Flight Management Menu  =========");
            System.out.println("1. Create a new flight");
            System.out.println("2. List all flights");
            System.out.println("3. Search flights (with edit/delete options)");
            System.out.println("4. Sort flights by price");
            System.out.println("5. Sort flights by departure city");
            System.out.println("6. Sort flights by departure time");
            System.out.println("7. Sort flights by arrival city");
            System.out.println("8. Sort flights by arrival time");
            System.out.println("9. Filter by price range"); // BONUS 
            System.out.println("10. Filter by city"); // BONUS
            System.out.println("11. Filter by airline name"); // BONUS
            System.out.println("0. Exit");

            int choice = readInt(scn, "Choose an option: ");

            switch (choice) {
                case 1: // Create a new flight
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

                    System.out.print("Airline name: ");
                    String airline_name = scn.nextLine();

                    int seat_cap = readInt(scn, "Seat capacity: ");

                    Flight new_flight = new Flight(dept_city, arr_city, dept_time, arr_time, flight_id, airline_name, price, seat_cap);
                    manager.createFlight(new_flight);
                    break;

                case 2: // List all flights
                    System.out.println("User wants to list all flights:");
                    manager.listFlights();
                    break;

                case 3: // Search flights (with edit/delete options)
                    System.out.print("Enter search keyword: ");
                    String keyword = scn.nextLine();
                    List<Flight> results = manager.searchFlights(keyword);
                    
                    if (results.isEmpty()) {
                        System.out.println("No flights found.");
                    } else {
                        System.out.println("Found " + results.size() + " flight(s):");
                        for (int i = 0; i < results.size(); i++) {
                            System.out.println((i + 1) + ". " + results.get(i));
                        }
                        
                        // After showing search results, offer edit/delete options
                        System.out.println("\nWhat would you like to do with the search results?");
                        System.out.println("1. Edit a flight");
                        System.out.println("2. Delete a flight");
                        System.out.println("3. Go back to main menu");
                        
                        int action = readInt(scn, "Choose option: ");
                        
                        switch(action) {
                            case 1: // Edit flight
                                int editIndex = readInt(scn, "Enter flight number to edit (1-" + results.size() + "): ");
                                if (editIndex >= 1 && editIndex <= results.size()) {
                                    Flight selectedFlight = results.get(editIndex - 1);
                                    System.out.println("Editing flight: " + selectedFlight.getFlightID());
                                    boolean edited = manager.editFlight(selectedFlight.getFlightID(), scn);
                                    if (!edited) {
                                        System.out.println("Edit failed.");
                                    }
                                } else {
                                    System.out.println("Invalid flight number.");
                                }
                                break;
                                
                            case 2: // Delete flight
                                int deleteIndex = readInt(scn, "Enter flight number to delete (1-" + results.size() + "): ");
                                if (deleteIndex >= 1 && deleteIndex <= results.size()) {
                                    Flight selectedFlight = results.get(deleteIndex - 1);
                                    System.out.println("Deleting flight: " + selectedFlight.getFlightID());
                                    boolean deleted = manager.deleteFlight(selectedFlight.getFlightID());
                                    System.out.println(deleted ? "Flight deleted successfully." : "Failed to delete flight.");
                                } else {
                                    System.out.println("Invalid flight number.");
                                }
                                break;
                                
                            case 3: // Go back
                                System.out.println("Returning to main menu...");
                                break;
                                
                            default:
                                System.out.println("Invalid choice.");
                        }
                    }
                    break;
                    
                case 4: // Sort flights by price
                    manager.sortFlightsByPrice();
                    System.out.println("Flights after sorting:");
                    manager.listFlights();
                    break;

                case 5: // Sort flights by departure city
                    manager.sortFlightsByDepartureCity();
                    System.out.println("Flights after sorting:");
                    manager.listFlights();
                    break;

                case 6: // Sort flights by departure time
                    manager.sortFlightsByDepartureTime();
                    System.out.println("Flights after sorting:");
                    manager.listFlights();
                    break;

                case 7: // Sort flights by arrival city
                    manager.sortFlightsByArrivalCity();
                    System.out.println("Flights after sorting:");
                    manager.listFlights();
                    break;

                case 8: // Sort flights by arrival time
                    manager.sortFlightsByArrivalTime();
                    System.out.println("Flights after sorting:");
                    manager.listFlights();
                    break;

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
                    scn.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println("\nDo you want to continue? (yes/no): ");
            String cont = scn.nextLine();
            if (!cont.equalsIgnoreCase("yes")) {
                System.out.println("Exiting system...");
                break;
            }
            System.out.println("-----------------------------------------------------------");
        }

        scn.close();
    }

    // Helper method to read integers safely
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