class Flight{

    private String departure;
    private String arrive;
    private String departure_time;
    private String arrival_time;
    private int price;
    // cosntructor
    // getter and setters

    public void delay(int delay_in_minute){
        this.departure_time = this.departure_time + delay_in_minute;
        this.arrival_time = this.arrival_time + delay_in_minute;
    }
}