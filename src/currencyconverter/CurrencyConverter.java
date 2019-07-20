package currencyconverter;

import java.awt.Desktop;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
 * @author Munjal Shah
 */
public class CurrencyConverter {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Desktop desktop = java.awt.Desktop.getDesktop();

        List<String> currencyList = new LinkedList<>();
        List<String> currency = new LinkedList<>();
        
        currencyList.add("U.S. Dollars - USD");
        currencyList.add("Indian Rupee - INR");
        currencyList.add("Euro - EUR");
        currencyList.add("British Pound - GBP");
        currencyList.add("Australian Dollar - AUD");
        currencyList.add("Canadian Dollar - CAD");

        currency.add("USD");
        currency.add("INR");
        currency.add("EUR");
        currency.add("GBP");
        currency.add("AUD");
        currency.add("CAD");
        
        System.out.println("You will need internet connection to get the current currency rates!" + "\n");
        
        System.out.println("Convert currency from: " + currencyList);
        System.out.println("Enter currency code from this list " + currency + "\n");
        
        System.out.print("Enter currency code to convert: ");
        String from = scanner.nextLine();

        System.out.print("Enter currencycode to convert to: ");
        String to = scanner.nextLine();

        if (currency.contains(from) && currency.contains(to)) {
            try {
                System.out.print("Enter amount: ");
                String amount = scanner.nextLine();
                
                String urlString = "https://www.xe.com/currencyconverter/convert/?Amount=" + amount + "&From=" + from + "&To=" + to;
                URI uri = new URI(urlString);
                desktop.browse(uri);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Please enter correct currency code from given list: " + currency);
        }
    }
}
