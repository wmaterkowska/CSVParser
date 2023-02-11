package org.example;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CSVParser {


    public static ArrayList<List<String>> parseCSV(File CSVFile) {

        try {

            BufferedReader br = new BufferedReader(new FileReader(CSVFile));

            ArrayList<List<String>> nameTicketArray = new ArrayList<>();
            String line = "";
            while ((line = br.readLine()) != null) {
                nameTicketArray.add(Arrays.stream(line.split(",")).toList());
            }
            return nameTicketArray;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static Boolean checkIfPersonPurchasedTicket(File CSVFile, String name) {

        ArrayList<List<String>> nameTicketList = parseCSV(CSVFile);

        for(List<String> list: nameTicketList) {
            if (list.contains(name)) {
                return true;
            }
        }
        return false;
    }

    public static Integer checkHowManyTicketForPerson(File CSVFile, String name) {

        ArrayList<List<String>> nameTicketList = parseCSV(CSVFile);

        for(List<String> list: nameTicketList) {
            if(list.get(0).equals(name)) {
                return Integer.parseInt(list.get(1));
            }
        }
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