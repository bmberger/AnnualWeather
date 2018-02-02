/**
 * Annual Weather description: The program uses a weather data set of Gainesville, FL for 12 months. With the data, the program provides the user the
 * information in a clean structure and prints the information according to the user's preference for temperature scale and precipitation scale. 
 * 
 * @author Briana Berger
 * @version 12/23/2017
 *
 */
import java.util.Scanner;
public class AnnualWeatherV2
{
    public static void main (String [ ] args)
    {

        //Declare and initialize variables
        Scanner in = new Scanner(System.in);
        String city = "Gainesville";
        String state = "Florida";
        double sumTemp = 0.0;
        double sumPrecip = 0.0;
        double averageTemp = 0.0;
        String tempLabel = "F";
        String precipLabel = "in.";
  
        String [] month = {"Jan.", "Feb.", "Mar.", "Apr.", "May ", "Jun.", "Jul.", "Aug.", "Sep.", "Oct.", "Nov.", "Dec."};
        
        double [] temperature = {54.3, 57.0, 62.5, 67.6, 74.3, 79.2, 80.9, 80.4, 77.8, 70.1, 62.8, 56.3}; //initialize with Fahrenheit values
        //in F
        
        double [] precipitation = {3.5, 3.4, 4.3, 2.9, 3.2, 6.8, 6.1, 6.6, 4.4, 2.5, 2.2, 2.6}; //initialize with inch values
        //in inches
        
        System.out.printf("Choose the temperature scale (F = Fahrenheit, C = Celsius): ");
        String tempScale = in.next();
        tempScale = tempScale.toUpperCase();
        
        //Converts all temperatures from F to C if user's choice was Celcius (c or C).
        if (tempScale.equals("C"))
        {
            tempLabel = "C";
            for( int index = 0; index < temperature.length; index++)
            {
                 temperature[index] = Math.round((((temperature[index]) * 1.8) + 32) * 10);
                 temperature[index] = temperature[index]/10;
            }
        }
        else if(!tempScale.equals("F"))
        {
            System.out.println("Invalid temperature scale choice. Please try again.");
            return;
        }
        
        System.out.printf("Choose the precipitation scale (i = inches, c = centimeters): ");
        String precipScale = in.next();
        precipScale = precipScale.toUpperCase();
        
        //Converts all precipitations from inches to cm if user's choice was (c or C).
        if (precipScale.equals("C") || precipScale.equals("c"))
        {
            precipLabel = "cm.";
            for( int index = 0; index < precipitation.length; index++)
            {
                 precipitation[index] = Math.round(((precipitation[index]) * 2.54) * 10);
                 precipitation[index] = precipitation[index]/10;
            }
        }
        else if(!precipScale.equals("I"))
        {
            System.out.println("Invalid precipitation scale choice. Please try again.");
            return;
        }
        
        //Processing - calculate total temperature and total precipitation
        for( int index = 0; index < temperature.length; index++)
        {
            sumTemp += temperature[index];
            sumPrecip += precipitation[index];
        }
    
        averageTemp = Math.round((sumTemp/12) * 10);
        averageTemp = averageTemp/10;
        sumPrecip = Math.round(sumPrecip * 10);
        sumPrecip = sumPrecip/10;
        
        //Output: display table of weather data including average and total
        System.out.printf("%n");
        System.out.printf("%30s %n", "Weather Data");
        System.out.printf("%38s %n","Location: " + city +", " + state);
        System.out.printf("%s %22s %25s %n","Month", "Temperature (" +  tempLabel + ")", "Precipitation (" + precipLabel + ")");
        System.out.printf("%s %n", "******************************************************");
        for( int index = 0; index < temperature.length; index++)
        {
            System.out.printf("%5s %15s %20s %n",month[index], temperature[index], precipitation[index]);
        }
        System.out.printf("%s %n", "******************************************************");
        System.out.printf("%s %30s %n","Avg. Temperature: " + averageTemp, "Total Precipitation: " + sumPrecip);

    }//end main
}//end class