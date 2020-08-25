package Project.climatechange;

import java.text.DecimalFormat;
import java.util.*;

/**
 * An object for each line in the data file. Implements ITemperature and Comparable {@literal
 * <ITemperature>}.
 */
public class Temperature implements ITemperature, Comparable<ITemperature> {

    /** Rounds decimals to two decimals places (HALF_EVEN) */
    private DecimalFormat df = new DecimalFormat("0.00");
    //Each column of the data file as a private instance variable
    private String country;
    private String countryCode;
    private String month;
    private int year;
    private double temperature;

    /**
     * Constructs Temperature object.
     *
     * @param line line of data as String
     */
    public Temperature(String line) {
        String[] data = line.split(",");
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].stripLeading();
        }
        temperature = Double.parseDouble(data[0]);
        year = Integer.parseInt(data[1]);
        month = data[2];
        country = data[3];
        countryCode = data[4];
    }

    public String getCountry() {
        return country;
    }

    public String getCountry3LetterCode() {
        return countryCode;
    }

    public String getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    /**
     * Gets the temperature in fahrenheit if getFahrenheit is true and celsius if getFahrenheit is
     * false.
     *
     * @param getFahrenheit temperature in fahrenheit if getFahrenheit is true and celsius if
     *                      getFahrenheit is false
     * @return temperature the temperature of this Temperature object
     */
    public double getTemperature(boolean getFahrenheit) {
        if (!getFahrenheit) {
            return temperature;
        } else
        //Convert from celsius to fahrenheit
        {
            return (temperature * 1.8 + 32);
        }
    }

    /**
     * Satisfies Comparable{@literal <ITemperature>}. Compares by temperature, then country, then
     * year (earliest wins), then month (earliest wins).
     *
     * @param o other object that implements ITemperature
     * @return negative integer, zero, or a positive integer if this object is less than, equal to,
     * or greater than the specified object
     */
    public int compareTo(ITemperature o) {
        int tempDiff = Double.compare(temperature, o.getTemperature(false));
        int countryDiff = o.getCountry().compareTo(country);
        int yearDiff = Integer.compare(year, o.getYear());

        if (tempDiff != 0) {
            return tempDiff;
        } else if (countryDiff != 0) {
            return countryDiff;
        } else if (yearDiff != 0) {
            return yearDiff;
        } else {
            return o.getMonth().compareTo(month);
        }
    }

    //Satisfies equals-hashcode contract.
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Temperature that = (Temperature) o;
        return year == that.year &&
                Double.compare(that.temperature, temperature) == 0 &&
                Objects.equals(country, that.country) &&
                Objects.equals(countryCode, that.countryCode) &&
                Objects.equals(month, that.month);
    }

    /**
     * Satisfies equals-hashcode contract. Gives a hash to each instance variable.
     *
     * @return hash for each instance variable
     */
    public int hashCode() {
        return Objects.hash(country, countryCode, month, year, temperature);
    }

    /**
     * Overrides toString method. Returns comma-separated values of: temperature(C and F), year,
     * month, country, and 3 letter country code.
     *
     * @return comma-separated values of: temperature(C and F), year, month, country, and 3 letter
     * country code.
     */
    public String toString() {
        return df.format(getTemperature(false)) + "(C) "
                + df.format(getTemperature(true))
                + "(F)," + getYear() + "," + getMonth() + "," + getCountry() + ","
                + getCountry3LetterCode();
    }
}
