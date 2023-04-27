package edu.ucalgary.ensf409;
import java.util.regex.*;
import java.io.*;
public class Translator {
    private TranslationText text;
    private static final String REGEX = "^[a-z]{2}-[A-Z]{2}$";
    private static final Pattern PATTERN =Pattern.compile(REGEX);
    private String code;
    String[] months=new String[12];
    String[] days= new String[31];
    String message;
     public TranslationText getTranslation(){
   //getter method returning a stored TranslationText object.
        return text;
    }

    public String translate(int month, int day, int year) throws IllegalArgumentException{
        if (month>12||day>31||month<1||day<1||year>2021){
            throw new IllegalArgumentException();
        }
        return String.format(text.getSentence(),text.getDay(day-1),text.getMonth(month-1),year);
    }
   /* Accepts a month number (e.g., 1 for January), a day number (e.g., 31 for
   * the 31st), and a year. Note that years may be any previous year in the common era 
   * (CE) from 0 to the previous year, or they may be before the common era (BCE),
   * represented by negative numbers. Thus 2021, 800, and -1600 are all valid years.
   * Method throws an IllegalArgumentException if monthNum or dayNum is not
   * valid. Returns the formatted sentence as a String. Notice that the String
   * containing formatting uses numbered arguments - this is because some languages
   * will put the words in the sentence in a different order, but the translate()
   * method must be able to work without knowledge of the language structure.
   * Note: You do not have to check if a day is valid for a particular month/year;
   * February 31 or February 29, 2021 can both be accepted, but out of range values
   * e.g., month 15 day 0, are not valid and should be handled with an 
   * IllegalArgumentException. 
  */

  /* Constructor
   * Accepts a String of a two-letter language code (lowercase), dash, and two-letter 
   * region (caps) code, e.g., te-IN and throws an IllegalArgumentException if the language 
   * and region code are not in the correct format. Language codes are ISO 639-1 and
   * region codes are ISO 3166, but this method only checks the format of the String, 
   * not if the region and language codes are valid according to the ISO specifications. it calls importTranslation().*/
   public Translator(String input) throws IllegalArgumentException, ArgFileNotFoundException{
       Matcher match= PATTERN.matcher(input);
       boolean matchFound=match.find();
       if (matchFound){
           this.code=input;
           
           this.importTranslation();
           
       }
       else{
           throw new IllegalArgumentException();
       }  
   }


   private void importTranslation() throws ArgFileNotFoundException{
    File f=new File(this.code+".ser");
    if(f.exists()){
        this.deserialize();
    }
    else{
    
    this.importFromText();}
   }
   //* Calls deserialize() if the appropriate file exists, otherwise calls importFromText().
   //* No arguments. Returns void.


   public void importFromText() throws ArgFileNotFoundException{
       int i=0;
        BufferedReader reader;
       try{
           reader=new BufferedReader(new FileReader(this.code+".txt"));
        String line=reader.readLine();
        while(line!=null){
            if(i<12){
                this.months[i]=line;
            }
            if(i>11&&i<43){
                this.days[i-12]=line;
            }
            if(i==43){
                this.message=line;
            }
            i++;
            line=reader.readLine();
        }
        reader.close();
     
       } 
       catch(FileNotFoundException a){
        throw new ArgFileNotFoundException();
    }
    catch(IOException e){e.printStackTrace();}
       this.text=new TranslationText(months, days, message);
       this.serialize();
   }
   /* Reads in from a the two-letter language code, dash, two-letter region code text 
   * file, in the form of ab-XY.txt, and instantiates a TranslationText object with
   * the data. It can throw I/O exceptions. Throw a custom ArgFileNotFoundException
   * when the file isn't found. 
   * We expect the .txt file to be in a valid format. The file is expected to be in the same 
   * directory. The files en-US.txt and el-GR.txt are examples of a valid .txt files. They will 
   * always consist of the month names, one per line, followed by the day names, one per line, 
   * followed by the sentence containing formatting strings. This is the last line in the file. You
   * cannot make any assumptions about what will appear on each line, only that each line
   * will contain only one data element, and that it will not contain an empty line.
   * No arguments. Returns void.
  */

 /* 
  /* Creates a serialized object file of the TranslationText object, with the
  * name format la-CO.ser, where la is the two-letter language code and CO is
  * the two-letter region code. An example of a serialized object file can be
  * found in the exercise directory as es-BO.ser
  * I/O exceptions can be thrown.
  * No arguments. Returns void.
  */     

  public void serialize(){
    ObjectOutputStream output=null;
    TranslationText record=null;
    try{
        output=new ObjectOutputStream(new FileOutputStream(this.code+".ser"));

    }catch(IOException i){
        System.out.println("error opening file");
        System.exit(1);
    }
    try{
        output.writeObject(text);
    }
    catch(Exception e){
        System.err.println("Gen error handler");
        e.printStackTrace();
    }
    finally{
        try{
            if(output!=null){
                output.close();
            }
        }
        catch(IOException e){
            System.err.println("error closing file");
            System.exit(1);
        }
    }
}
public void deserialize(){

    ObjectInputStream input=null;
    TranslationText record=null;
    
    try{
        input=new ObjectInputStream(new FileInputStream(this.code+".ser"));
    }
    catch(IOException e){
        System.err.println("error opening file");
        System.exit(1);
    }
    try{
        record = (TranslationText)input.readObject();
        
        this.text=new TranslationText((String[])record.getMonths(),(String[])record.getDays(),(String)record.getSentence());
    }
    catch(Exception e){
        e.printStackTrace();
    }
    finally{
        try{
            if(input!=null){
                input.close();
            }
        }
        catch(IOException e){
            System.err.println("error closing file");
            System.exit(1);
        }
    }
}
   /*
   /* Creates a TranslationText object from a .ser file. The files are named
   * xx-YY.ser, where xx is the two-letter language code and YY is the two-
   * letter region code. es-BO.ser is an example. It can throw I/O exceptions.
   * No arguments. Returns void.
  */
}
