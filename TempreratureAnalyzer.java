import java.util.Scanner;

public class TemperatureAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int[] temperatures = new int[7];
        double[] celsiusTemperatures = new double[7];

        // Input temperatures for each day
        for (int i = 0; i < 7; i++) {
            System.out.print("Enter temperature for " + daysOfWeek[i] + ": ");
            temperatures[i] = scanner.nextInt();
            celsiusTemperatures[i] = convertToCelsius(temperatures[i]);
        }

        // Calculate total temperature
        int totalTemp = 0;
        for (int temp : temperatures) {
            totalTemp += temp;
        }

        // Calculate average temperature
        double averageTemp = (double) totalTemp / 7;

        // Count number of even temperatures
        int numEvenTemps = 0;
        for (int temp : temperatures) {
            if (temp % 2 == 0) {
                numEvenTemps++;
            }
        }

        // Find the highest temperature and its day
        int highestTemp = temperatures[0];
        String highestTempDay = daysOfWeek[0];
        for (int i = 1; i < 7; i++) {
            if (temperatures[i] > highestTemp) {
                highestTemp = temperatures[i];
                highestTempDay = daysOfWeek[i];
            }
        }

        // Count number of days with temperature >= 70
        int numDaysAbove70 = 0;
        for (int temp : temperatures) {
            if (temp >= 70) {
                numDaysAbove70++;
            }
        }

        // Find highest change in temperature
        int maxChange = 0;
        for (int i = 0; i < 6; i++) {
            int change = Math.abs(temperatures[i] - temperatures[i + 1]);
            if (change > maxChange) {
                maxChange = change;
            }
        }

        // Print results
        System.out.println("Total temperature: " + totalTemp);
        System.out.println("Average temperature: " + averageTemp);
        System.out.println("Number of even temperatures: " + numEvenTemps);
        System.out.println("Highest temperature: " + highestTemp + " on " + highestTempDay);
        System.out.println("Number of days with temperature >= 70: " + numDaysAbove70);
        System.out.println("Highest change in temperature: " + maxChange);

        // Print Celsius temperatures
        System.out.println("\nCelsius Temperatures:");
        for (int i = 0; i < 7; i++) {
            System.out.println(daysOfWeek[i] + ": " + celsiusTemperatures[i] + "°C");
        }

        scanner.close();
    }

    public static double convertToCelsius(int fahrenheitTemp) {
        return (fahrenheitTemp - 32) * 5.0 / 9.0;
    }
}
