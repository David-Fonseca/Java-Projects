package edu.ucalgary.ensf409;
import java.util.regex.*;
public class Movement implements FormattedOutput, Cloneable{
    private String action;
    private String direction;
    private static final String REGEX="\"([A-Z]+) - ([A-Z]{1,2})";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    public Movement(String movement) throws IllegalArgumentException{
        Matcher match1=PATTERN.matcher(movement);
        boolean matchFound = match1.find();
        if (matchFound==true){
            String a=match1.group(1);
            String d=match1.group(2);
            //Directions dd=Directions.valueOf(d);
            direction=d;
            Actions aa=Actions.valueOf(a);
            action=aa.toString();

        }
        else{
            throw new IllegalArgumentException("wrong input "+movement);
        }


    }

    public String getAction(){
        return action;
    }

    public String getDirection(){
        return direction;
    }
    public Object clone() throws CloneNotSupportedException{
        Movement copy=(Movement)super.clone();
        copy.action=new String(action);
        copy.direction=new String(direction);
        return copy;
    }
    @Override
    public String getFormatted(){
        Directions dd=Directions.valueOf(direction);
        String fullD=dd.toString();
        return "Action: "+ action+", "+"Direction: "+fullD;

    }
}
