import java.util.ArrayList;

/**
 * Demonstration of the Calendar and Appointment classes
 */
public class AppointmentDemo {
    public static void main(String[] args) {
    //Calendar calendar = new Calendar();
    //create some appointments and add them to our calendar
    //note the method calls here imply that
    //your Appointment class will need to have a 4 argument constructor
    //that accepts year, month, day, and description
    //the first call is year:2000, month: 8, day: 13

    /*calendar.add(new Daily(2000, 8, 13, "Brush your teeth."));
    calendar.add(new Monthly(2003, 5, 20, "Visit grandma."));
    calendar.add(new Onetime(2004, 11, 2, "Dentist appointment."));
    calendar.add(new Onetime(2004, 10, 31, "Trick or Treat."));
    calendar.add(new Monthly(2004, 11, 2, "Dentist appointment."));
    calendar.add(new Onetime(2004, 11, 2, "Dentist appointment."));*/

    ArrayList<String> calendar = new ArrayList<String>();
    calendar.add("Daily[Brush your teeth. Date: 8/13/2000]");
    calendar.add("Onetime[Dentist appointment. Date: 11/2/2004]");
    calendar.add("Monthly[Dentist appointment. Date: 11/2/2004]");
    calendar.add("Onetime[Dentist appointment. Date: 11/2/2004]");
    calendar.add("Monthly[Visit grandma. Date: 5/20/2003]");
    calendar.add("Onetime[Trick or Treat. Date: 10/31/2004]");
    


    //note here we can simply use + calendar because we have
    //implemented the toString() method
    System.out.println("\n" + "Before removal of appointment " + "\n" + calendar);
    calendar.remove(1);
    calendar.remove(2);
    calendar.remove(3);
    
    //note that the daily appointment is removed because it occurs on
    //11/2/2004 (as well as many other days).  
    System.out.println("\n" + "After removal of 11/2/2004 " + "\n" + calendar);
}

public void occursOn(int year, int month, int day) {
    int y = year;
    int m = month;
    int d = day;
}

class Appointment{
    
}
class Onetime extends Appointment{

    public Onetime(int i, int j, int k, String string) {
    }
    
}
class Daily extends Appointment{

    public Daily(int i, int j, int k, String string) {
    }
    
}
class Monthly extends Appointment{

    public Monthly(int i, int j, int k, String string) {
    }

}

class Calendar{
    /**
     * A method to add an appointment to the calendar
     * @param apt – the appointment object to add to the calendar.
    */
    public void add(Appointment apt) {
        Calendar calendar = new Calendar();
        calendar.add(new Daily(2000, 8, 13, "Brush your teeth."));
        calendar.add(new Monthly(2003, 5, 20, "Visit grandma."));
        calendar.add(new Onetime(2004, 11, 2, "Dentist appointment."));
        calendar.add(new Onetime(2004, 10, 31, "Trick or Treat."));
        calendar.add(new Monthly(2004, 11, 2, "Dentist appointment."));
        calendar.add(new Onetime(2004, 11, 2, "Dentist appointment."));

    }
    /**
     * A method to remove an appointment from the calendar.
     * This method uses the occursOn() method from the public
     * interface for the Appointment class.  Therefore, if parameters
     * are entered that occur after a start date for a given Daily 
     * appointment
     * the Daily appointment will be removed as well.  (Because occursOn()  * willreturn 
    true in this case).  This is a limitation we will
    * accept for now.
    * @param year - the year of the appointment to remove
    * @param month - the month of the appointment to remove
    * @param day - the day of the appointment to remove
    */
    public void remove(int year, int month, int day) {
    //this method needs to iterate over your list of appointments
    //and remove elements who's occursOn() method return true
    //when passed the parameters above.
    }
    /**
     * Method to return a string representation of this Calendar object.
     * Overrides the Object method toString (see page 448 in text).
     * (also see page 453 Special Topic 9.6)
     * @return a String representation of the Calendar object.
     */
    public String toString() {
    String ret = "";
    //this method needs to iterate over your list of appointments
    //and construct the return string
    //make sure to put each appointment on its own line
    //by using “\n”
    return ret;
    }
}

}