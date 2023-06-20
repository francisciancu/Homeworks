package Homework11.Ex1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GeneratePropertiesFile {
    public void writePropertiesFile() {

        try (FileOutputStream outPutStream =  new FileOutputStream("test.properties")) {

            Properties propFile =  new Properties();
            propFile.setProperty("portocala", "47");
            propFile.setProperty("mar", "52");
            propFile.setProperty("ananas", "50");
            propFile.setProperty("banana", "89");
            propFile.setProperty("lamaie", "29");
            propFile.store(outPutStream,"saved");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void readPropertiesFile(String key) {

        try (FileInputStream inputStream = new FileInputStream("test.properties")) {

            Properties propFile = new Properties();
            propFile.load(inputStream);
            if (propFile.getProperty(key) == null){
                System.out.println("Nu vindem aceasta leguma");
            }else {
                System.out.println("Leguma/Fructul ales de tine are "+propFile.getProperty(key)+" calorii.");
            }



        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
