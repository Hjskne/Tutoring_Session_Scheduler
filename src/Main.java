/**
 * This program tells the user which tutor is avaiable and the time and days they can meet with them
 * the program will then ask for the user to input a file with the course, time and day, along with a description of what they need help with
 * then the program outputs to confirm the time and day for the session then asks if the user wants to input another file or not
 *
 * @Author Zander Wofford
 * @Version 1.0
 *
 * I pledge I wrote this code and did not cheat
 */

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {

                System.out.println("This program helps users schedule tutoring sessions.");

                // lines 21- 23 setting up the tutor object for the TutorScheduler class and the arrays
                TutorScheduler tutor = new TutorScheduler("Matt",
                        new String[]{"Monday", "Tuesday", "Wednesday", "Thursday"},
                        new Double[]{10.00, 11.00, 12.00, 13.00, 14.00, 15.00, 16.00, 17.00, 18.00, 19.00, 20.00});

                Scanner stdin = new Scanner(System.in); // scanner set up
                String choice = "Y"; // for string choice

                while (choice.equalsIgnoreCase("Y")) { // this loop continues the user input and output using y
                    // line 30 -42 Using getter methods to display tutor details
                    System.out.println("Available Tutor: " + tutor.getTutorName());
                    System.out.print("Available Times: ");
                    for (Double time : tutor.getTimeSlots()) {
                        String period = (time >= 12.00) ? "pm" : "am";
                        System.out.printf("%.2f %s ", time, period);
                    }


                    System.out.println("\nAvailable Days: ");
                    for (String day : tutor.getAvailableDays()) {
                        System.out.print(day + " ");
                    }
                    System.out.println("\n");

                    // Prompt user for input file
                    System.out.println("Please enter your file name with the course, day, and description of what you want to work on: ");
                    String fileName = stdin.nextLine();

                    try {
                        //lines 50 -51 set up scanner to read the file
                        File inputFile = new File(fileName);
                        Scanner fileIn = new Scanner(inputFile);
                        // lines 53-55 list to store the information
                        List<String> courses = new ArrayList<>();
                        List<String> days = new ArrayList<>();
                        List<String> descriptions = new ArrayList<>();
                        //lines 57 - 61 reads each line of the file and stores the data
                        while (fileIn.hasNextLine()) {
                            courses.add(fileIn.nextLine());
                            days.add(fileIn.nextLine());
                            descriptions.add(fileIn.nextLine());
                        }


                        //loop that prints out all the store data
                        for (int i = 0; i < courses.size(); i++) {
                            System.out.println("Course: " + courses.get(i));
                            System.out.println("Day: " + days.get(i));
                            System.out.println("Description: " + descriptions.get(i));
                            System.out.println();
                        }

                    } catch (FileNotFoundException e) {
                        // if there is not that exist file it outputs a message
                        System.out.println("Error: File not found. Please check the file name and try again.");
                    }

                    //line 78 - 83 asks the user if they want to update the tutors name using Y/N
                    System.out.println("Would you like to update the tutor's name? (Y/N)");
                    String updateChoice = stdin.nextLine();
                    if (updateChoice.equalsIgnoreCase("Y")) {
                        System.out.println("Enter the new tutor name: ");
                        tutor.setTutorName(stdin.nextLine());
                    }

                    //lines 86 -89 askes if the user wants to enter in another file
                    System.out.println("Would you like to enter another file? (Y/N)");
                    choice = stdin.next();
                    stdin.nextLine(); // Consume newline
                }
    }
}