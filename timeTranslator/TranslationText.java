package edu.ucalgary.ensf409;
public class TranslationText implements java.io.Serializable{
    private String[] days=new String[31];
    private String[] months= new String[12];
    private String sentence;
    static final long serialVersionUID=19L;
    /* TranslationText
 * Serializable representation of the data file. Has the serialVersionUID of 19.
*/

   public String getSentence(){
       return sentence;
   }
   /* Getter method, returns String
  */

   public String[] getMonths(){
       return months;
   }
   /* Getter method, returns String[]
  */

  public String[] getDays(){
      return days;
  }
   /* Getter method, returns String[]
  */

   public String getMonth(int b){
       return months[b];
   }
   /* Accepts an integer 0-11 corresponding to an index in the months array,
   * and returns the value at that index. (e.g., 0 = January)
  */

  public String getDay(int a){
      return days[a];
  }
   /* Accepts an integer 0-30 corresponding to an index in the day array,
   * and returns the value at that index. (e.g., 30 = 31st)
  */
public TranslationText(String[] months, String[] days, String formatted){
for(int j=0;j<31;j++){
    this.days[j]=days[j];
}
for(int j=0;j<12;j++){
    this.months[j]=months[j];
}
this.sentence=formatted;
}
  /* Constructor
   * Accepts a String array of months, a String array of days, and a String 
   * containing a sentence with formatting.
  */

}
