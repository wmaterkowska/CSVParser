package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVParser {


    public static ArrayList<List<String>> parseCSV(File CSVFile) {
        return null;
    }

    public static Boolean checkIfPersonPurchasedTicket(File CSVFile, String name) {
        return false;
    }

    public static Integer checkHowManyTicketForPerson(File CVSFile, String name) {
        return 0;
    }



    public static void main(String[] args) {


        // take person's name
        // importCSV to array
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