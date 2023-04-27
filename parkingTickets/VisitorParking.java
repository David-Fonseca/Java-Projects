package edu.ucalgary.ensf409;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.*;
import java.util.*;

public class VisitorParking {
   HashMap<String, TreeSet<LocalDate>> parkingRecord = new HashMap<String, TreeSet<LocalDate>>();
   

    public VisitorParking(String in){
        String license1=Parking.standardizeAndValidateLicence(in);
        LocalDate a=LocalDate.now();
        LocalDate a1=a.plusDays(1);
        LocalDate a2=a1.plusDays(1);
        TreeSet<LocalDate> ts=new TreeSet<LocalDate>();
        ts.add(a);
        ts.add(a1);
        ts.add(a2);
        ts=(TreeSet<LocalDate>)ts.descendingSet();
        parkingRecord.put(license1,ts);
  
    }
    public VisitorParking(String in, LocalDate a) throws IllegalArgumentException{
        String license1=Parking.standardizeAndValidateLicence(in);
   

        
        LocalDate today = LocalDate.now();
        if (a.isBefore(today)) {
            throw new IllegalArgumentException();
        }

        LocalDate a1=a.plusDays(1);
        LocalDate a2=a1.plusDays(1);
        TreeSet<LocalDate> ts=new TreeSet<LocalDate>();
        ts.add(a);
        ts.add(a1);
        ts.add(a2);
        ts=(TreeSet<LocalDate>)ts.descendingSet();
        parkingRecord.put(license1,ts);
    }
    public VisitorParking(){}

    public void addVisitorReservation(String in){
        String license2=Parking.standardizeAndValidateLicence(in);
        LocalDate a=LocalDate.now();
        LocalDate a1=a.plusDays(1);
        LocalDate a2=a1.plusDays(1);
        TreeSet<LocalDate> ts=new TreeSet<LocalDate>();
        ts.add(a);
        ts.add(a1);
        ts.add(a2);
       
        alreadyReserved(license2,a);
       
        
        tooManyPermits(a);
        
        if(parkingRecord.containsKey(license2)){
            TreeSet<LocalDate> ts1=parkingRecord.get(license2);
            for (LocalDate b:ts1){
                ts.add(b);
            }
        }
        ts=(TreeSet<LocalDate>)ts.descendingSet();
        parkingRecord.put(license2,ts);
    }
    public void addVisitorReservation(String in, LocalDate a)throws IllegalArgumentException{
        String license2=Parking.standardizeAndValidateLicence(in);
        
        LocalDate today = LocalDate.now(ZoneId.systemDefault());
        if (a.isBefore(today)) {
            throw new IllegalArgumentException();
        }
        LocalDate a1=a.plusDays(1);
        LocalDate a2=a1.plusDays(1);
        TreeSet<LocalDate> ts=new TreeSet<LocalDate>();
        ts.add(a);
        ts.add(a1);
        ts.add(a2);
        
        alreadyReserved(license2,a);
        tooManyPermits(a);

        if(parkingRecord.containsKey(license2)){
            TreeSet<LocalDate> ts1=parkingRecord.get(license2);
            for (LocalDate b:ts1){
                ts.add(b);
            }
        }
        ts=(TreeSet<LocalDate>)ts.descendingSet();
        parkingRecord.put(license2,ts);
        
 
 
    }

    private void alreadyReserved(String license,LocalDate a)throws IllegalArgumentException{
        for(Map.Entry<String,TreeSet<LocalDate>> entry:parkingRecord.entrySet()){
            String key=entry.getKey();
            TreeSet<LocalDate> ts1=entry.getValue();
            if(license==key){
                if(ts1.contains(a)){
                    throw new IllegalArgumentException();
                }
                    }
                }
        return;
    }

    private void tooManyPermits(LocalDate a)throws IllegalArgumentException{
        int dateCounter=0;
        for (TreeSet<LocalDate> value:parkingRecord.values()){
            if (value.contains(a)){
                dateCounter++;
            }
            if (dateCounter>1){
                throw new IllegalArgumentException();
            }
        }
    return;
    }

    public boolean licenceIsRegisteredForDate(String in, LocalDate a){
        String licence=Parking.standardizeAndValidateLicence(in);
        if(parkingRecord.containsKey(licence)){
            TreeSet<LocalDate> ts1=parkingRecord.get(licence);
            if(ts1.contains(a)){
                return true;
            }
        }
    return false;
    }
    public boolean licenceIsRegisteredForDate(String in){
        String licence=Parking.standardizeAndValidateLicence(in);
        LocalDate a=LocalDate.now();
        if(parkingRecord.containsKey(licence)){
            TreeSet<LocalDate> ts1=parkingRecord.get(licence);
            if(ts1.contains(a)){
                return true;
            }
        }
    return false;
    }
    
    public ArrayList<String> getLicencesRegisteredForDate(){
        LocalDate today=LocalDate.now();
        ArrayList<String> licenses=new ArrayList<String>();
        for(Map.Entry<String,TreeSet<LocalDate>>entry:parkingRecord.entrySet()){
            String key=entry.getKey();
            TreeSet<LocalDate> ts1=entry.getValue();
            if(ts1.contains(today)){
                licenses.add(key);
            }
            
    } 
    return licenses;
}

public ArrayList<String> getLicencesRegisteredForDate(LocalDate Date1){
    ArrayList<String> licenses=new ArrayList<String>();
    for(Map.Entry<String,TreeSet<LocalDate>>entry:parkingRecord.entrySet()){
        String key=entry.getKey();
        TreeSet<LocalDate> ts1=entry.getValue();
        if(ts1.contains(Date1)){
            licenses.add(key);
        }
        
} 
return licenses;
}

public ArrayList<LocalDate> getAllDaysLicenceIsRegistered(String licence){
    licence=Parking.standardizeAndValidateLicence(licence);
    TreeSet<LocalDate> dates=new TreeSet<LocalDate>();
         if(parkingRecord.containsKey(licence)){
            for(LocalDate a:parkingRecord.get(licence)){
                dates.add(a);
            }
        }
    ArrayList<LocalDate>list=new ArrayList<LocalDate>();
    list.addAll(dates);

return list;
}

public ArrayList<LocalDate> getStartDaysLicenceIsRegistered(String licence){
    licence=Parking.standardizeAndValidateLicence(licence);
    TreeSet<LocalDate> dates=new TreeSet<LocalDate>();
    TreeSet<LocalDate> startDates=new TreeSet<LocalDate>();
    if(parkingRecord.containsKey(licence)){
        for(LocalDate a:parkingRecord.get(licence)){
            dates.add(a);
        }
        int i=0;
        for(LocalDate a:dates){
            if(i==0){
                startDates.add(a);
                }
                if(i%3==0){
                    startDates.add(a);
                }
                i++;
            }
        }
    ArrayList<LocalDate>list=new ArrayList<LocalDate>();
    list.addAll(startDates);

return list;
}

public HashMap<String, TreeSet<LocalDate>> getParkingRecord() {
    HashMap<String, TreeSet<LocalDate>> pR = new HashMap<String, TreeSet<LocalDate>>();
    
    for(String key:parkingRecord.keySet()){
        TreeSet<LocalDate> startDates=new TreeSet<LocalDate>(this.getStartDaysLicenceIsRegistered(key));
        startDates=(TreeSet<LocalDate>)startDates.descendingSet();
        pR.put(key,startDates);
    }

 return pR;
}

}




