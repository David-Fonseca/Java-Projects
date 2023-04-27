package edu.ucalgary.ensf409;
import java.util.*;
public class DayMemory {
    public static void main(String[] args) throws CommandArgumentNotProvidedException, ArgFileNotFoundException{
        Scanner sc=new Scanner(System.in);
        System.out.print("enter translation code ");
        
        String str= sc.nextLine();
        if(str.equals(null)||str.equals("")){
            throw new CommandArgumentNotProvidedException();
        }
        Translator trans=new Translator(str);

    }
   /* Accept a command-line argument which specifies a translation file.
   * The argument should be in the form of a two-letter languageit code,
   * followed by a dash and a two-letter region code, e.g., en-US
   * which corresponds with files en-US.txt and en-US.ser
   * If no argument is specified, it throws a custom exception,
   * CommandArgumentNotProvidedException, which extends Exception. 
   * Additional arguments are ignored.
  */

}
