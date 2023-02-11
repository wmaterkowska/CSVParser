import org.example.CSVParser;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CSVParserTest {

    private File CSVFile;

    @Test
    public void parseCSVTest() {

        CSVFile = new File("ticketholders.csv");

        ArrayList<List<String>> nameTicketListTest = new ArrayList<List<String>>();
        // nameTicketListTest.add(List.of("Name:", "Quantity:"));
        nameTicketListTest.add(List.of("Jessica Jones", "2"));
        nameTicketListTest.add(List.of("Rebecca Johnson", "3"));
        nameTicketListTest.add(List.of("Sarah Roberts", "1"));

        assertEquals(nameTicketListTest, CSVParser.parseCSV(CSVFile));

    }

    @Test
    public void checkIfPersonPurchasedTicketTest() {

        CSVFile = new File("ticketholders.csv");

        String testName = "Jessica Jones";

        assertTrue(CSVParser.checkIfPersonPurchasedTicket(CSVFile, testName));

    }

    @Test
    public void checkHowManyTicketForPerson() {
        CSVFile = new File("ticketholders.csv");

        String testName = "Sarah Roberts";

        assertEquals(1, CSVParser.checkHowManyTicketForPerson(CSVFile, testName));

    }



}
