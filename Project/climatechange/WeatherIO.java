package Project.climatechange;

import java.io.*;
import java.util.ArrayList;

/**
 * File I/O class. Takes input from data file and then outputs data for each task into separate
 * files.
 */
public class WeatherIO implements IWeatherIO {

    /** Used to check if a new task has started in writeDataToFile */
    private String filename;

    /**
     * Reads all data from data file.
     *
     * @param fileName name of data file
     * @return Array List of all the data in the data file
     */
    public ArrayList<ITemperature> readDataFromFile(String fileName) {
        ArrayList<ITemperature> temperatures = new ArrayList<>();
        File file = new File(fileName);
        try (FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr)) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                Temperature temp = new Temperature(line);
                temperatures.add(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temperatures;
    }

    /**
     * Writes the name for each task in the output file This should be done before the data returned
     * from the task is written into the output file.
     *
     * @param filename name of the output file
     * @param subject  name of the task
     */
    public void writeSubjectHeaderInFile(String filename, String subject) {
        File file = new File(filename);
        try (FileWriter fw = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(subject + "\n");
            if (filename.equals("data/taskC1_climate_info.csv")) {
                bw.write("Temperature Delta,Year Delta,Month,Country,Country_Code");
            } else {
                bw.write("Temperature,Year,Month,Country,Country_Code");
            }
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes data to individual task files. Every time it writes data for each task, it clears the
     * file and then writes new data. Also, it writes the title for each task before returning the
     * data.
     *
     * @param filename       "taskXX_climate_info.csv where XX" is replaced by the task id
     * @param topic          the title for each task
     * @param theWeatherList the output for each task
     */
    public void writeDataToFile(String filename, String topic,
            ArrayList<ITemperature> theWeatherList) {
        File file = new File(filename);
        //If a new task has started, then clears the file when it a PrintWriter is created
        if (!filename.equals(this.filename)) {
            try (PrintWriter pw = new PrintWriter(file)) {
            } catch (IOException e) {
            }
        }

        writeSubjectHeaderInFile(filename, topic);
        try (FileWriter fw = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(fw)) {
            for (ITemperature t : theWeatherList) {
                bw.write(t.toString());
                bw.newLine();
            }
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.filename = filename;
    }
}
