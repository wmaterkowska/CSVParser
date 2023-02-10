package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSVParser {



    public static Boolean checkIfPersonPurchasedTicket(File CSVFile, String name) {

        try {
            Scanner sc = new Scanner(CSVFile);
            sc.useDelimiter(",");

            while(sc.hasNext()) {
                if (sc.next().contains(name)) {
                    return true;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        return false;
    }

    public static Integer checkHowManyTicketForPerson(File CVSFile, String name) {

        try {
            Scanner sc = new Scanner(CVSFile);
            sc.useDelimiter("\n");
            while (sc.hasNext()) {
                String line = sc.next();
                String[] nameTicketsArray = line.split(",");
                if (nameTicketsArray[0].equals(name)) {
                    return Integer.parseInt(nameTicketsArray[1]);
                }
            }

        } catch (FileNotFoundException e){
            System.out.println(e);
        }

        return 0;
    }



    public static void main(String[] args) {


        // take person's name
        // importCSV
        // check if name is on the list
        // check how many tickets person purchased

        Scanner inputName = new Scanner(System.in);
        System.out.println("Give name to check");
        String nameToCheck = "";
        if (inputName.hasNext()) {
            nameToCheck = inputName.nextLine();
        }

        File CSVFile = new File("ticketholders.csv");

        if (checkIfPersonPurchasedTicket(CSVFile, nameToCheck)) {
            System.out.println("Can come in.");
            Integer numberOfTicketsForPerson = checkHowManyTicketForPerson(CSVFile, nameToCheck);
            System.out.println("Number of tickets: " + numberOfTicketsForPerson);
        }




    }



}