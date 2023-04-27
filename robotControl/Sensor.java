package edu.ucalgary.ensf409;
import java.util.regex.*;

public class Sensor implements FormattedOutput, Cloneable{
    private String sensor;
    private static final String REGEX="\\(([a-z]+)\\)";
    private static final Pattern PATTERN= Pattern.compile(REGEX);

    public Sensor(String sensor) throws IllegalArgumentException{
        Matcher match1=PATTERN.matcher(sensor);
        boolean matchFound = match1.find();
        if (matchFound==true){
            this.sensor=match1.group(1);
        }
        else{
            throw new IllegalArgumentException("wrong input "+sensor);
        }
    }
    public String getSensor() {
        return sensor;
    }
    public Object clone() throws CloneNotSupportedException{
        Sensor copy=(Sensor)super.clone();
        copy.sensor=new String(sensor);
        return copy;
    }
    @Override
    public String getFormatted() {
        // TODO Auto-generated method stub
        return "Sensor: "+ sensor;
    }
}
