import java.io.*; 
import java.util.ArrayList; 


public class FlightDataHelper {

    // This is filr all flight data will be saved
    private static final String FILE_NAME = "data/flights.dat";

    // saves a list of flights to the file
    public static void saveFlights(ArrayList<Flight> flights) {
        try {
            // Make sure the 'data' folder exists
            File dir = new File("data");
            if (!dir.exists()) dir.mkdir(); // create folder if missing

        
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));

            // save entire list of flights into the file
            oos.writeObject(flights);

            
            oos.close();
        } catch (IOException e) {
            System.out.println("Error saving flights: " + e.getMessage());
        }
    }

    // loads the list of flights from thr file
    @SuppressWarnings("unchecked") // ignore type-casting warning
    public static ArrayList<Flight> loadFlights() {
        File file = new File(FILE_NAME);

        //if the file doesn't exist yet, return an empty list
        if (!file.exists()) return new ArrayList<>();

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME));
            ArrayList<Flight> flights = (ArrayList<Flight>) ois.readObject();

           
            ois.close();

            return flights;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading flights: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    //creates 10 example flights and saves them
    public static void createSampleFlights() {
        ArrayList<Flight> sampleFlights = new ArrayList<>();

        //add 10 different flight examples to the list
        sampleFlights.add(new Flight("Baku", "Istanbul", "2025-07-20 08:00", "2025-07-20 10:30", "AZ1001", "AZAL", 250, 150));
        sampleFlights.add(new Flight("Baku", "London", "2025-07-21 12:00", "2025-07-21 15:30", "AZ1002", "AZAL", 400, 100));
        sampleFlights.add(new Flight("Ganja", "Dubai", "2025-07-22 15:00", "2025-07-22 19:00", "GJ2001", "FlyDubai", 350, 80));
        sampleFlights.add(new Flight("Baku", "Moscow", "2025-07-23 07:30", "2025-07-23 10:00", "AZ1003", "Aeroflot", 300, 200));
        sampleFlights.add(new Flight("Lankaran", "Tbilisi", "2025-07-23 10:00", "2025-07-23 12:00", "LN1001", "GeorgianAirways", 150, 70));
        sampleFlights.add(new Flight("Baku", "Berlin", "2025-07-24 14:00", "2025-07-24 18:30", "AZ1004", "Lufthansa", 450, 120));
        sampleFlights.add(new Flight("Baku", "Rome", "2025-07-25 09:00", "2025-07-25 13:30", "AZ1005", "AZAL", 380, 130));
        sampleFlights.add(new Flight("Baku", "Paris", "2025-07-26 11:00", "2025-07-26 15:00", "AZ1006", "AirFrance", 420, 110));
        sampleFlights.add(new Flight("Sumgait", "Kiev", "2025-07-27 06:30", "2025-07-27 09:30", "SM1001", "UkraineAir", 220, 90));
        sampleFlights.add(new Flight("Nakhchivan", "Istanbul", "2025-07-28 10:00", "2025-07-28 12:00", "NK1001", "TurkishAirlines", 270, 100));

        ///save the list of sample flights to the file
        saveFlights(sampleFlights);

        //llet user know that sample flights were created
        System.out.println("Sample flights created and saved.");
    }
}
