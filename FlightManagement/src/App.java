import java.util.Scanner;

public class App {
 
    public static void main(String[] args) throws Exception {
 
        Scanner scn = new Scanner(System.in);
        BookingManager manager =  new BookingManager();

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

            System.out.println("\n");
            System.out.println("Please enter your choice: ");
        
            int user_in = scn.nextInt();
            
            switch (user_in) {
                case 1:
                    System.out.println("User wants to ccreate a new fligth:");
                    
                    System.out.print("Flight ID: ");
                    String fligt_id = scn.nextLine();

                    System.out.print("Departure city: ");
                    String dept_city = scn.nextLine();

                    System.out.print("Arrival city: ");
                    String arr_city = scn.nextLine();

                    System.out.print("Departure time: ");
                    String dept_time = scn.nextLine();

                    System.out.print("Arrival time: ");
                    String arr_time = scn.nextLine();
                    
                    System.out.print("Price:  ");
                    int price = scn.nextInt();

                    System.out.print("Airlinename: ");
                    String airline_name = scn.nextLine();

                    System.out.print("Seat capacity: ");
                    int seat_cap = scn.nextInt();
                    
                    
                    Flight new_filght = new Flight(dept_city, arr_city, dept_time, arr_time, fligt_id, airline_name, price, seat_cap);
                    manager.createFlight(new_filght);
                    
                    break;



                

                case 2:
                    System.out.println("User wants to list all existed flights");
                default:
                    break;
            }

            break;
        }


    }
}
