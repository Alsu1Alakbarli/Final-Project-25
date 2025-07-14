import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        BookingManager manager = new BookingManager();

        //create sample flights
        System.out.println("Do you want to create base sample flights? (yes/no): ");
        String answer = scn.next();
        if (answer.equalsIgnoreCase("yes")) {
            FlightDataHelper.createSampleFlights();
        }

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
            System.out.println("\nPlease enter your choice: ");

            int user_in = readInt(scn, "");

            switch (user_in) {
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
                    scn.nextLine(); 
                    System.out.println("Enter keyword to search flights:");
                    String keyword = scn.nextLine();

                    // show all matching flights
                    System.out.println("Search results:");
                    for (Flight f : manager.searchFlights(keyword)) {
                        System.out.println(f);
                    }
                    break;

                case 4: //sort by price
                    manager.sortFlightsByPrice();
                    break;

                case 5: //sort by departure city
                    manager.sortFlightsByDepartureCity();
                    break;

                case 6: //sort by departure time
                    manager.sortFlightsByDepartureTime();
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
                    if (deleted) {
                        System.out.println("Flight deleted successfully.");
                    } else {
                        System.out.println("Flight not found.");
                    }
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }

            System.out.println("\nDo you want to continue? (yes/no): ");
            String cont = scn.next();
            if (!cont.equalsIgnoreCase("yes")) {
                System.out.println("Exiting system...");
                break;
            }
        }

        scn.close();
    }

    //helps to read number safelu
    public static int readInt(Scanner scn, String message) {
        int value;
        while (true) {
            try {
                if (!message.isEmpty()) System.out.print(message); /// show prompt if not empty
                value = Integer.parseInt(scn.next()); // try to read number
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
                scn.nextLine(); 
            }
        }
        return value;
    }
}


