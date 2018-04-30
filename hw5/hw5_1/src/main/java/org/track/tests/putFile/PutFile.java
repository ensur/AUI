package org.track.tests.putFile;

import org.openqa.selenium.WebElement;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PutFile {
    public static void writer(List<WebElement> urlIn, List<WebElement> urlOut){
        try(FileWriter writer = new FileWriter(System.getProperty("path"), false))
        {
            // запись всей строки

            writer.write("Inside links: (found " + urlIn.size() + "):\n \n");
            urlIn.forEach(s -> {
                try {
                    writer.write(s.getAttribute("href").toString() + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            System.out.println(" \n");
            writer.write("Outside links (found " + urlOut.size() + "):\n \n");
            urlOut.forEach(s -> {
                try {
                    writer.write(s.getAttribute("href").toString() + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
