package edu.ucalgary.ensf409;
import java.util.ArrayList;

public class RobotDataRecord implements Cloneable{
private ArrayList<RobotDataLine> log;
private String[] arr;
private int len;
public RobotDataRecord(String[] array){
    arr=array;
    len=array.length;
    log= new ArrayList<RobotDataLine>();
    for (int i=0; i<array.length;i++){
        log.add(new RobotDataLine(array[i]));
    }
}
public RobotDataLine getLine(int index){
    Object[] lines =log.toArray();
    return (RobotDataLine)lines[index];

}
public ArrayList<RobotDataLine> getDataRecord(){
    return log;

}
public Object clone() throws CloneNotSupportedException{
    RobotDataRecord copy=(RobotDataRecord)super.clone();
    copy.log=new ArrayList<RobotDataLine>();
    copy.arr=new String[len];
    for(int i=0;i<len;i++){
        copy.arr[i]=new String(arr[i]);
    }
    for (int i=0;i<len;i++){
        copy.log.add(new RobotDataLine(arr[i]));
    }
    copy.arr=new String[len];

    return copy;
}
    
}
