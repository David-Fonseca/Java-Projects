//by German Fonseca, 30061209

package edu.ucalgary.ensf409;
import java.time.Month;
import java.util.Arrays;
    public class Itinerary {
        private Trip[] trips = new Trip[20];
        private int trueLength;//variable specifiying exactly how many trip objects should be created

    
        // Returns a string in the format of:
        // value (key)
        public static String fmtString(String key, String value) {
            return value+" ("+key+")";//Return a string in the desired format
        }
    
        // Constructor
        public Itinerary(String[][] myTrips) {
            trueLength=myTrips.length;//getting the true number of trips
            for (int i = 0; i<20;i++){
                trips[i]=new Trip();//initializing "trips"
            }
            for(int i=0;i<trueLength;i++){//assigning correct values to trips
                    trips[i].setArrival(myTrips[i][0]);
                    trips[i].setDeparture(myTrips[i][1]);
                    trips[i].setCity(myTrips[i][2]);
                    trips[i].setCountry(myTrips[i][3]);

            }
                
        }
    
        // Getter
        public Trip[] getTrips() {
            return this.trips;//return trips obejct array
        }
    
       public String formatByArrival() {
           
           String thisY=String.valueOf(trips[0].getYear(trips[0].getArrival()));//get year of first trip
           String thisM=String.valueOf(trips[0].getMonth(trips[0].getArrival()));//get month of first trip
           StringBuilder Output=new StringBuilder(350);//create a string builder to store formatted output
           
           Output.append(fmtString("Year", thisY));//format for first year of trips
           Output.append("\n--");
           Output.append(fmtString("Month", thisM));//format for first month in first year of trips
           Output.append("\n");
           
           for (int i=0; i<trueLength;i++){
               if(trips[i]!=null){//if there is a trip in trips[i] do the following:
                   String Year=String.valueOf(trips[i].getYear(trips[i].getArrival()));//get year of trip
                   String Month=String.valueOf(trips[i].getMonth(trips[i].getArrival()));//get month of trip
                   
                   if(!(Year.equals(thisY))){//if current year is different as year from last index do the following:
                    Output.append(fmtString("Year", Year));//add new year to output
                    Output.append("\n");//add new line, to match example output
                       thisY=Year;//set last index year to current year
                   }
                   
                   if(!(Month.equals(thisM))){//if current month is the same as last index year:
                    Output.append("--");//add "--" to match example output
                    Output.append(fmtString("Month",Month));//add new month to formatted output
                    Output.append("\n");
                       thisM=Month;
                   }
                   Output.append("----");//add "----" before city and country to match formatted output
                   Output.append(fmtString("City", trips[i].getCity()));//add the city to output
                   Output.append(", ");// add ", " between city and country in output
                   Output.append(fmtString("Country", trips[i].getCountry()));//add country to output
                   Output.append(" (Place)\n");//add a new line between trips for formatted output
                }
           }
           String Output2=Output.toString();//convert StringBuilder to string in order to match correct return type
           
           return Output2.trim();//get rid of the "\n" at the end of the string which is made by default from creating a"\n" between trips

        }
    
        // The first array holds years (2021-2023).
        // The second array holds months.
        // The third array holds formatLocation() fitting the criteria
        String[][][] byDate() {
        String[][][] res=new String[3][12][20]; //initialize output string
        int thisY= trips[0].getYear(trips[0].getArrival());//get year of first trip
        int thisM=trips[0].getMonth(trips[0].getArrival());//get month of first trip
        int thisD=0;
        res[thisY-2021][thisM-1][thisD]=trips[0].formatLocation();//store first trip info on the correct indeces based on year and month
        
        for (int i=1;i<trueLength;i++){//starting on the second trip and ending at the last:
            if (trips[i]!=null){//if trip exists at trips[i] do the following:
                int year=trips[i].getYear(trips[i].getArrival());//get year of current trip
                int month=trips[i].getMonth(trips[i].getArrival());//get month of current trip
                
                    if (thisM==month){//if we are in the same month as last index
                        thisD++;//add 1 to the number of trips in the same month
                        res[year-2021][month-1][thisD]=trips[i].formatLocation();//add info of trip to correct indeces of 3D array
                    }
                    if(thisM!=month){//if we are in same year but new month
                        thisD=0;//set the number of trips in the same month to 0
                        res[year-2021][month-1][thisD]=trips[i].formatLocation();//add info of trip to correct indeces of 3D array
                        thisM=month;//update month
                    }
             
            
        }
            
           
        }

        return res;//return 3D array with info on all trips
        }
    
    }
