package edu.ucalgary.ensf409;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.regex.*;



public class RobotDataLine {
    private String dataLine;
    private String robotID;
    private Sensor sensor;
    private Movement movement;
    private LocalDate date;
    private static final String DATE_REGEX = "\\[([0-9]{1,2})/([0-9]{1,2})/([0-9]{4})\\]";
    private static final String ROBOT_REGEX= "\\s([0-9]{3}[A-Z]{1})\\s";
    private static final Pattern DATE_PATTERN =Pattern.compile(DATE_REGEX);
    private static final Pattern ROBOT_PATTERN =Pattern.compile(ROBOT_REGEX);
    private int year;
    private int month;
    private int day;


    public RobotDataLine(String line) throws IllegalArgumentException{
        dataLine=line;
        try{
        Matcher match1=DATE_PATTERN.matcher(line);
        boolean matchFound = match1.find();
        if (matchFound==true){
            day=Integer.valueOf(match1.group(1));
            month=Integer.valueOf(match1.group(2));
            year=Integer.valueOf(match1.group(3));
            date=LocalDate.of(Integer.valueOf(match1.group(3)), Integer.valueOf(match1.group(2)), Integer.valueOf(match1.group(1)));
        }
        else{
            throw new IllegalArgumentException();
        }}
        catch(DateTimeException e){
            throw new IllegalArgumentException();
        }

        Matcher match2=ROBOT_PATTERN.matcher(line);
        boolean matchFound2 = match2.find();
        if (matchFound2==true){
            robotID=match2.group(1);
        }
        else{
            throw new IllegalArgumentException("wrong input "+ line);
        }

        sensor=new Sensor(line);

        movement = new Movement(line);
    }
    public String getRobotID() {
        return robotID;
    }
    public String getDataLine() {
        return dataLine;
    }
    public Sensor getSensor() {
        return sensor;
    }
    public Movement getMovement() {
        return movement;
    }
    public LocalDate getDate() {
        return date;
    }
    public Object clone() throws CloneNotSupportedException{
        RobotDataLine copy=(RobotDataLine)super.clone();
        copy.sensor=(Sensor)sensor.clone();
        copy.movement=(Movement)movement.clone();
        copy.dataLine=new String(dataLine);
        copy.robotID=new String(robotID);
        copy.date=LocalDate.of(year,month,day);
        return copy;
    }

                                                     
}
