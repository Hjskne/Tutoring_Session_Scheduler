/**
 * A class to manage tutor schedules, including availabe days and time slots.
 */

public class TutorScheduler {
    private String tutorName;
    private Double[] timeSlots;
    private String[] availableDays;

    /**
     * construtor for the TutorScheduler class
     * @param tutorName the name of the tutor
     * @param availableDays the available days
     * @param timeSlots the available time slots
     */
    public TutorScheduler(String tutorName,String[] availableDays,Double[] timeSlots){
        this.tutorName = tutorName;
        this.timeSlots = timeSlots;
        this.availableDays = availableDays;
    }
// lines 22 - 32 getter methods
    public String getTutorName(){
        return tutorName;
    }

    public Double[] getTimeSlots(){
        return timeSlots;
    }

    public String[] getAvailableDays(){
        return availableDays;
    }
// lines 34 - 44 setter methods if needed to update
    public void setAvailableDays(String[] availableDays) {
        this.availableDays = availableDays;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }

    public void setTimeSlots(Double[] timeSlots) {
        this.timeSlots = timeSlots;
    }

// lines 47 - 62 display all the details of each variable
    public void displayTutorDetails() {
        System.out.println("Available Tutor: " + tutorName);
        System.out.print("Available Times: ");

        for (Double time : timeSlots) {
            String period = (time >= 12.00) ? "pm" : "am";
            System.out.printf("%.2f %s ", time, period);
        }

        System.out.println("\nAvailable Days: ");
        for (String day : availableDays) {
            System.out.print(day + " ");
        }

        System.out.println(); // Add a line break for clarity
    }
}


