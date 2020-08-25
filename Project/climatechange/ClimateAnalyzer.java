package Project.climatechange;

import java.util.*;

//Again probably won't work because directories are all changed
/**
 * ClimateAnalyzer has three major level of tasks: A (Individual countries), B (All countries), and
 * C (Climate change detection). A has: Task A-1, Task A-2, Task A-3, Task A-4 (Each task has two
 * sub-tasks, except A-3 only has one sub-task). B has: Task B-1, Task B-2, Task B-3 (Each task has
 * two sub-tasks). C has: Task C-1 (Only one sub-task).
 */
public class ClimateAnalyzer implements IClimateAnalyzer {

    /** All data from the data file in an ArrayList */
    private static final ArrayList<ITemperature> ALL_TEMPERATURE_READINGS = new WeatherIO()
            .readDataFromFile("data/world_temp_2000-2016.csv");

    /**
     * Input a month as a integer value and get back a month as a String.
     *
     * @param month integer value of month from 1 - 12
     * @return month as a String
     */
    public String getStringMonth(int month) {
        switch (month) {
            case 1:
                return "Jan";
            case 2:
                return "Feb";
            case 3:
                return "Mar";
            case 4:
                return "Apr";
            case 5:
                return "May";
            case 6:
                return "Jun";
            case 7:
                return "Jul";
            case 8:
                return "Aug";
            case 9:
                return "Sep";
            case 10:
                return "Oct";
            case 11:
                return "Nov";
            case 12:
                return "Dec";
            default:
                return null;
        }
    }

    /**
     * Get lowest temperature for specified country and month.
     *
     * @param country full name of country (should be spelled the exact same way as in the data
     *                file)
     * @param month   month as an integer value from 1 - 12
     * @return lowest temperature for specified country and month
     */
    public ITemperature getLowestTempByMonth(String country, int month) {
        TreeSet<ITemperature> tempSet = new TreeSet<>();

        for (ITemperature t : ALL_TEMPERATURE_READINGS) {
            if (t.getCountry().equals(country) && t.getMonth().equals(getStringMonth(month))) {
                tempSet.add(t);
            }
        }
        return tempSet.first();
    }

    /**
     * Get highest temperature for specified country and month.
     *
     * @param country full name of country (should be spelled the exact same way as in the data
     *                file)
     * @param month   month as an integer value from 1 - 12
     * @return highest temperature for specified country and month
     */
    public ITemperature getHighestTempByMonth(String country, int month) {
        TreeSet<ITemperature> tempSet = new TreeSet<>();

        for (ITemperature t : ALL_TEMPERATURE_READINGS) {
            if (t.getCountry().equals(country) && t.getMonth().equals(getStringMonth(month))) {
                tempSet.add(t);
            }
        }
        return tempSet.last();
    }

    /**
     * Get lowest temperature for specified country, month, and year.
     *
     * @param country full name of country (should be spelled the exact same way as in the data
     *                file)
     * @param year    year from 2000-2016
     * @return lowest temperature for specified country, month, and year
     */
    public ITemperature getLowestTempByYear(String country, int year) {
        TreeSet<ITemperature> tempSet = new TreeSet<>();

        for (ITemperature t : ALL_TEMPERATURE_READINGS) {
            if (t.getCountry().equals(country) && t.getYear() == year) {
                tempSet.add(t);
            }
        }
        return tempSet.first();
    }

    /**
     * Get highest temperature for specified country, month, and year.
     *
     * @param country full name of country (should be spelled the exact same way as in the data
     *                file)
     * @param year    year from 2000-2016
     * @return highest temperature for specified country, month, and year
     */
    public ITemperature getHighestTempByYear(String country, int year) {
        TreeSet<ITemperature> tempSet = new TreeSet<>();

        for (ITemperature t : ALL_TEMPERATURE_READINGS) {
            if (t.getCountry().equals(country) && t.getYear() == year) {
                tempSet.add(t);
            }
        }
        return tempSet.last();
    }

    /**
     * Get all temperature data that falls within the given temperature range.
     *
     * @param country       full name of country (should be spelled the exact same way as in the
     *                      data file)
     * @param rangeLowTemp  minimum temperature (inclusive)
     * @param rangeHighTemp maximum temperature (inclusive)
     * @return all temperature data that falls within the given temperature range
     */
    public TreeSet<ITemperature> getTempWithinRange(String country, double rangeLowTemp,
            double rangeHighTemp) {
        TreeSet<ITemperature> temperaturesSet = new TreeSet<>();

        for (ITemperature t : ALL_TEMPERATURE_READINGS) {
            if (t.getCountry().equals(country)
                    && t.getTemperature(false) >= rangeLowTemp
                    && t.getTemperature(false) <= rangeHighTemp) {
                temperaturesSet.add(t);
            }
        }
        return temperaturesSet;
    }

    /**
     * Get the lowest temperatures amongst all data for a given country.
     *
     * @param country full name of country (should be spelled the exact same way as in the data
     *                file)
     * @return lowest temperature data amongst all data for a given country
     */
    public ITemperature getLowestTempYearByCountry(String country) {
        TreeSet<ITemperature> tempSet = new TreeSet<>();

        for (ITemperature t : ALL_TEMPERATURE_READINGS) {
            if (t.getCountry().equals(country)) {
                tempSet.add(t);
            }
        }
        return tempSet.first();
    }

    /**
     * Get the highest temperatures amongst all data for a given country.
     *
     * @param country full name of country (should be spelled the exact same way as in the data
     *                file)
     * @return highest temperature data amongst all data for a given country
     */
    public ITemperature getHighestTempYearByCountry(String country) {
        TreeSet<ITemperature> tempSet = new TreeSet<>();

        for (ITemperature t : ALL_TEMPERATURE_READINGS) {
            if (t.getCountry().equals(country)) {
                tempSet.add(t);
            }
        }
        return tempSet.last();
    }

    /**
     * Get top 10 countries with the lowest temperatures for a given month between 2000-2016.
     *
     * @param month month as an integer value from 1 - 12
     * @return top 10 countries with the lowest temperatures for a given month between 2000-2016
     */
    public ArrayList<ITemperature> allCountriesGetTop10LowestTemp(int month) {
        TreeSet<ITemperature> sorted = new TreeSet<>(ALL_TEMPERATURE_READINGS);
        Iterator<ITemperature> iterator = sorted.iterator();
        TreeSet<ITemperature> top10Low = new TreeSet<>();
        ArrayList<String> duplicate = new ArrayList<>();

        while (iterator.hasNext() && duplicate.size() <= 9) {
            ITemperature temp = iterator.next();
            if (!duplicate.contains(temp.getCountry()) && temp.getMonth()
                    .equals(getStringMonth(month))) {
                top10Low.add(temp);
                duplicate.add(temp.getCountry());
            }
        }
        return new ArrayList<>(top10Low);
    }

    /**
     * Get top 10 countries with the highest temperatures for a given month between 2000-2016.
     *
     * @param month month as an integer value from 1 - 12
     * @return top 10 countries with the highest temperatures for a given month between 2000-2016
     */
    public ArrayList<ITemperature> allCountriesGetTop10HighestTemp(int month) {
        TreeSet<ITemperature> sorted = new TreeSet<>(ALL_TEMPERATURE_READINGS);
        Iterator<ITemperature> iterator = sorted.descendingIterator();
        TreeSet<ITemperature> top10High = new TreeSet<>();
        ArrayList<String> duplicate = new ArrayList<>();

        while (iterator.hasNext() && duplicate.size() <= 9) {
            ITemperature temp = iterator.next();
            if (!duplicate.contains(temp.getCountry()) && temp.getMonth()
                    .equals(getStringMonth(month))) {
                top10High.add(temp);
                duplicate.add(temp.getCountry());
            }
        }
        return new ArrayList<>(top10High);
    }

    /**
     * Get top 10 countries with the lowest temperatures amongst all data from 2000-2016.
     *
     * @return top 10 countries with the lowest temperatures amongst all data from 2000-2016
     */
    public ArrayList<ITemperature> allCountriesGetTop10LowestTemp() {
        TreeSet<ITemperature> sorted = new TreeSet<>(ALL_TEMPERATURE_READINGS);
        Iterator<ITemperature> iterator = sorted.iterator();
        TreeSet<ITemperature> top10Low = new TreeSet<>();
        ArrayList<String> duplicate = new ArrayList<>();

        while (iterator.hasNext() && top10Low.size() <= 9) {
            ITemperature temp = iterator.next();
            if (!duplicate.contains(temp.getCountry())) {
                top10Low.add(temp);
            }
            duplicate.add(temp.getCountry());
        }
        return new ArrayList<>(top10Low);
    }

    /**
     * Get top 10 countries with the highest temperatures amongst all data from 2000-2016.
     *
     * @return top 10 countries with the highest temperatures amongst all data from 2000-2016
     */
    public ArrayList<ITemperature> allCountriesGetTop10HighestTemp() {
        TreeSet<ITemperature> sorted = new TreeSet<>(ALL_TEMPERATURE_READINGS);
        Iterator<ITemperature> iterator = sorted.descendingIterator();
        TreeSet<ITemperature> top10High = new TreeSet<>();
        ArrayList<String> duplicate = new ArrayList<>();

        while (iterator.hasNext() && top10High.size() <= 9) {
            ITemperature temp = iterator.next();
            if (!duplicate.contains(temp.getCountry())) {
                top10High.add(temp);
            }
            duplicate.add(temp.getCountry());
        }
        return new ArrayList<>(top10High);
    }

    /**
     * Get all countries that are within the given temperature range.
     *
     * @param lowRangeTemp  minimum temperature (inclusive)
     * @param highRangeTemp maximum temperature (inclusive)
     * @return all countries that are within the given temperature range
     */
    public ArrayList<ITemperature> allCountriesGetAllDataWithinTempRange(double lowRangeTemp,
            double highRangeTemp) {
        TreeSet<ITemperature> temperatureRange = new TreeSet<>();

        for (ITemperature t : ALL_TEMPERATURE_READINGS) {
            if (t.getTemperature(false) >= lowRangeTemp
                    && t.getTemperature(false) <= highRangeTemp) {
                temperatureRange.add(t);
            }
        }
        return new ArrayList<>(temperatureRange);
    }

    /**
     * Get the top 10 countries with the 10 largest differences (absolute value).
     *
     * @param month month as an integer value from 1 - 12
     * @param year1 first year from 2000-2016
     * @param year2 second year from 2000-2016
     * @return the top 10 countries with the 10 largest differences (absolute value)
     */
    public ArrayList<ITemperature> allCountriesTop10TempDelta(int month, int year1, int year2) {
        int yearDelta = Math.abs(year1 - year2);

        //Creates an ArrayList of temperature readings that match the specified month and match the
        //specified year1 or year2.
        ArrayList<ITemperature> tempData = new ArrayList<>();

        for (ITemperature t : ALL_TEMPERATURE_READINGS) {
            if ((t.getYear() == year1 || t.getYear() == year2) && t.getMonth()
                    .equals(getStringMonth(month))) {
                tempData.add(t);
            }
        }

        //Creates a TreeMap that will map the temperature delta to its temperature reading from the
        //ArrayList tempData.
        //
        //Also, it doesn't matter whether I map the value to the previous temperature or the
        //current one because I won't be using their temperature values, or their year values.
        //
        //I get the current temperature reading and the previous reading from the ArrayList tempData
        //because the input data file is set up so that the country names are in alphabetical order,
        //so when I go through them with the for loop above, it adds the two temperature readings
        //for each country for the two years right after another.
        TreeMap<Double, ITemperature> tempDiffMap = new TreeMap<>();

        for (int i = 0; i < tempData.size(); i++) {
            ITemperature current = tempData.get(i);
            if (i > 0 && current.getYear() == year2) {
                ITemperature previous = tempData.get(i - 1);
                double temperatureDiff = Math.abs(current.getTemperature(false)
                        - previous.getTemperature(false));
                tempDiffMap.put(temperatureDiff, current);
            }
        }

        //This is a special case of temperature readings, where the temperature column is replaced
        //with temperature delta and year is replaced with year delta, so I just created a new
        //Temperature object, instead of making another constructor.
        //
        //Now I will use the TreeMap to get the temperature reading from the tempData, and use it
        //to get the month, country, and 3 letter country code.
        //
        //Also, I will use the TreeMap to get the tempDelta, and the yearDelta is already calculated
        //at the top of the method.
        TreeSet<Double> tempDiffSet = new TreeSet<>(tempDiffMap.keySet());
        Iterator<Double> tempDiffSetIterator = tempDiffSet.descendingIterator();
        TreeSet<ITemperature> top10DeltaList = new TreeSet<>();

        while (tempDiffSetIterator.hasNext() && top10DeltaList.size() <= 9) {
            double tempDelta = tempDiffSetIterator.next();
            ITemperature temp = tempDiffMap.get(tempDelta);
            top10DeltaList.add(new Temperature(tempDelta + "," + yearDelta + ","
                    + temp.getMonth() + "," + temp.getCountry() + "," + temp
                    .getCountry3LetterCode()));
        }

        return new ArrayList<>(top10DeltaList);
    }

    /**
     * Runs ClimateAnalyzer The do-while loops ensure that when the user inputs an invalid input,
     * then they are asked to retype their input.
     */
    public void runClimateAnalyzer() {
        //Initializing variables that will be used across different methods
        String country;
        int month;
        int year;
        double rangeLowTemp;
        double rangeHighTemp;
        int year2;

        //Initializing the Scanner for input, and the WeatherIO class for output to a file
        Scanner in = new Scanner(System.in);
        IWeatherIO writer = new WeatherIO();

        //Initializing a list of countries that will be used to check for correct input
        ArrayList<String> countryList = new ArrayList<>();
        for (ITemperature t : ALL_TEMPERATURE_READINGS) {
            countryList.add(t.getCountry());
        }

        //Task A methods
        //A-1
        System.out.println("Task A-1: Get highest and lowest temperatures for a specified country "
                + "and month");
        while (true) {
            System.out.println("Country: ");
            country = in.nextLine();
            if (!countryList.contains(country)) {
                System.out.println("Invalid country please retype");
                continue;
            }
            break;
        }

        while (true) {
            System.out.println("Month (as an integer): ");
            try {
                month = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid month please retype");
                //Infinite loop happens if nextLine() is not added
                in.nextLine();
                continue;
            }
            if (getStringMonth(month) == null) {
                System.out.println("Invalid month please retype");
                continue;
            }
            break;
        }
        //Avoiding the nextInt() to nextLine() error
        in.nextLine();

        ArrayList<ITemperature> a1Low = new ArrayList<>();
        a1Low.add(getLowestTempByMonth(country, month));
        writer.writeDataToFile("data/taskA1_climate_info.csv",
                "Task A1: Lowest Temperature of " + country
                        + " for " + getStringMonth(month), a1Low);

        ArrayList<ITemperature> a1High = new ArrayList<>();
        a1High.add(getHighestTempByMonth(country, month));
        writer.writeDataToFile("data/taskA1_climate_info.csv",
                "Task A1: Highest Temperature of " + country
                        + " for " + getStringMonth(month), a1High);

        //A-2
        System.out.println("Task A-2: Get highest and lowest temperatures for a specified country "
                + "and year");
        while (true) {
            System.out.println("Country: ");
            country = in.nextLine();
            if (!countryList.contains(country)) {
                System.out.println("Invalid country please retype");
                continue;
            }
            break;
        }

        while (true) {
            System.out.println("Year: ");
            try {
                year = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid year please retype");
                //Infinite loop happens if nextLine() is not added
                in.nextLine();
                continue;
            }
            if (year < 2000 || year > 2016) {
                System.out.println("Invalid year please retype");
                continue;
            }
            break;
        }
        //Avoiding the nextInt() to nextLine() error
        in.nextLine();

        ArrayList<ITemperature> a2Low = new ArrayList<>();
        a2Low.add(getLowestTempByYear(country, year));
        writer.writeDataToFile("data/taskA2_climate_info.csv",
                "Task A2: Lowest Temperature of " + country
                        + " for " + year, a2Low);

        ArrayList<ITemperature> a2High = new ArrayList<>();
        a2High.add(getHighestTempByYear(country, year));
        writer.writeDataToFile("data/taskA2_climate_info.csv",
                "Task A2: Highest Temperature of " + country
                        + " for " + year, a2High);

        //A-3
        System.out.println("Task A-3: All temperature data that falls within the given temperature"
                + " range");
        while (true) {
            System.out.println("Country: ");
            country = in.nextLine();
            if (!countryList.contains(country)) {
                System.out.println("Invalid country please retype");
                continue;
            }
            break;
        }

        while (true) {
            System.out.println("Minimum temperature: ");
            try {
                rangeLowTemp = in.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid rangeLowTemp please retype");
                //Infinite loop happens if nextLine() is not added
                in.nextLine();
                continue;
            }
            break;
        }

        while (true) {
            System.out.println("Maximum temperature: ");
            try {
                rangeHighTemp = in.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid rangeHighTemp please retype");
                //Infinite loop happens if nextLine() is not added
                in.nextLine();
                continue;
            }
            break;
        }
        //Avoiding the nextDouble() to nextLine() error
        in.nextLine();

        ArrayList<ITemperature> a3 = new ArrayList<>(getTempWithinRange(country,
                rangeLowTemp, rangeHighTemp));
        writer.writeDataToFile("data/taskA3_climate_info.csv", "Task A3: Temperatures "
                + "of " + country + " from " + rangeLowTemp + " to " + rangeHighTemp, a3);

        //A-4
        System.out.println("Task A-4: Highest and lowest temperature amongst all data for a "
                + "country");
        while (true) {
            System.out.println("Country: ");
            country = in.nextLine();
            if (!countryList.contains(country)) {
                System.out.println("Invalid country please retype");
                continue;
            }
            break;
        }

        ArrayList<ITemperature> a4Low = new ArrayList<>();
        a4Low.add(getLowestTempYearByCountry(country));
        writer.writeDataToFile("data/taskA4_climate_info.csv", "Task A4: Lowest "
                + "Temperature of " + country, a4Low);

        ArrayList<ITemperature> a4High = new ArrayList<>();
        a4High.add(getHighestTempYearByCountry(country));
        writer.writeDataToFile("data/taskA4_climate_info.csv", "Task A4: Highest "
                + "Temperature of " + country, a4High);

        //Task B methods
        //B-1
        System.out.println("Task B-1: Top 10 countries with the lowest temperatures and top 10 "
                + "countries with the highest temperatures");

        while (true) {
            System.out.println("Month (as an integer): ");
            try {
                month = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid month please retype");
                //Infinite loop happens if nextLine() is not added
                in.nextLine();
                continue;
            }
            if (getStringMonth(month) == null) {
                System.out.println("Invalid month please retype");
                continue;
            }
            break;
        }

        writer.writeDataToFile("data/taskB1_climate_info.csv",
                "Task B1: Top 10 Countries with the "
                        + "Lowest Temperatures for " + getStringMonth(month),
                allCountriesGetTop10LowestTemp(month));

        writer.writeDataToFile("data/taskB1_climate_info.csv",
                "Task B1: Top 10 Countries with the "
                        + "Highest Temperatures for " + getStringMonth(month),
                allCountriesGetTop10HighestTemp(month));

        //B-2
        writer.writeDataToFile("data/taskB2_climate_info.csv",
                "Task B2: Top 10 Countries with the "
                        + "Lowest Temperatures", allCountriesGetTop10LowestTemp());

        writer.writeDataToFile("data/taskB2_climate_info.csv",
                "Task B2: Top 10 Countries with the "
                        + "Highest Temperatures", allCountriesGetTop10HighestTemp());

        //B-3
        System.out.println("Task B-3: All data within the given temperature range");
        while (true) {
            System.out.println("Minimum temperature: ");
            try {
                rangeLowTemp = in.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid rangeLowTemp please retype");
                //Infinite loop happens if nextLine() is not added
                in.nextLine();
                continue;
            }
            break;
        }

        while (true) {
            System.out.println("Maximum temperature: ");
            try {
                rangeHighTemp = in.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid rangeHighTemp please retype");
                //Infinite loop happens if nextLine() is not added
                in.nextLine();
                continue;
            }
            break;
        }

        writer.writeDataToFile("data/taskB3_climate_info.csv", "Task B3: Countries "
                        + "with Temperatures from " + rangeLowTemp + " to " + rangeHighTemp,
                allCountriesGetAllDataWithinTempRange(rangeLowTemp, rangeHighTemp));

        //Task C methods
        //C-1
        System.out.println("Task C-1: Top 10 countries with the largest temperature differences"
                + " (Absolute value)");
        while (true) {
            System.out.println("Month (as an integer): ");
            try {
                month = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid month please retype");
                //Infinite loop happens if nextLine() is not added
                in.nextLine();
                continue;
            }
            if (getStringMonth(month) == null) {
                System.out.println("Invalid month please retype");
                continue;
            }

            break;
        }

        while (true) {
            System.out.println("First year: ");
            try {
                year = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid year please retype");
                //Infinite loop happens if nextLine() is not added
                in.nextLine();
                continue;
            }
            if (year < 2000 || year > 2016) {
                System.out.println("Invalid year please retype");
                continue;
            }
            break;
        }

        while (true) {
            System.out.println("Second year: ");
            try {
                year2 = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid second year please retype");
                //Infinite loop happens if nextLine() is not added
                in.nextLine();
                continue;
            }
            if (year2 < 2000 || year2 > 2016) {
                System.out.println("Invalid second year please retype");
                continue;
            }
            break;
        }

        writer.writeDataToFile("data/taskC1_climate_info.csv", "Task C1: Top 10"
                        + " Countries with the Largest Temperature Differences For "
                        + getStringMonth(month) + " " + year + " and " + getStringMonth(month)
                        + " " + year2,
                allCountriesTop10TempDelta(month, year, year2));
        in.close();
    }

    //How I got my project findings
//    public static void main(String[] args) {
//        ClimateAnalyzer ca = new ClimateAnalyzer();
//        ArrayList<TreeSet<ITemperature>> temp = new ArrayList<>();
//        for (int i = 1; i <= 12; i++) {
//            temp.add((TreeSet<ITemperature>) new TreeSet<>(
//                    ca.allCountriesTop10TempDelta(i, 2000, 2010)).descendingSet());
//        }
//
//        TreeSet<ITemperature> allTemp = new TreeSet<>();
//        for (TreeSet<ITemperature> t : temp) {
//            allTemp.addAll(t);
//        }
//
//        for (ITemperature t1 : allTemp.descendingSet()) {
//            System.out.println(t1.toString());
//        }
//    }
}
