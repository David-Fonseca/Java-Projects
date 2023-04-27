//by German Fonseca, 30061209

package edu.ucalgary.ensf409;

public class Trip {
    private String arrival;
    private String departure;
    private String city;
    private String country;

    // Returns a string in the format of:
    // value (key)
    public static String fmtString(String key, String value) {
        return value + " ("+key+")";//setting format to correct values
    }

    // Constructor
    public Trip(String[] array) {
        arrival=array[0];//setting private instance variables to correct values
        departure=array[1];
        city=array[2];
        country=array[3];

    }

    public Trip(){//default constructor
        arrival=new String("");//intialize default values to empty
        departure=new String("");
        city=new String("");
        country=new String("");
    }

    // Given a date string, return just the year
    public static int getYear(String date) {
        String[] y = date.split("-");//get year from date string
        return Integer.parseInt(y[0]);
    }




    // Given a date string, return just the month
    // Since it is an int, a date like "2022-01-12" returns 1
    public static int getMonth(String date) {
        String[] y = date.split("-");//get month from date string
        return Integer.parseInt(y[1]);
    }

    // Return a formatted string of key/value pairs, with commas
    // between each. See the output for an example.
    public String formatTrip() {
        return this.arrival+" (Arrival), "+this.departure+" (Departure), "+this.city+" (City), "+this.country+" (Country)";
        //format private variablees to desired output 
    }

    public String formatLocation(){
        return this.city+" (City), "+this.country+" (Country)";
        //format private variablees to desired output 
    }


    // Getter
    public String getArrival() {
        return this.arrival;//return arrival string
    }

    // Getter
    public String getDeparture() {
        return this.departure;//return departure string
    }

    // Getter
    public String getCity() {
        return this.city;//return city string
    }

    // Getter
    public String getCountry() {
        return this.country;//return country string
    }

    // Setter
    public void setArrival(String date) {
        this.arrival=date;//set arrival to desired date string
    }

    // Setter
    public void setDeparture(String date) {
        this.departure=date;//set departure to desired date string
    }

    // Setter 
    public void setCity(String city) {
        this.city=city;//set city to desired string
    }

    // Setter 
    public void setCountry(String country) {
        this.country=country;//set city to desired country
    }

}