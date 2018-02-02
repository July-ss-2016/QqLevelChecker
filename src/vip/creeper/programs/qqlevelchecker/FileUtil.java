package vip.creeper.programs.qqlevelchecker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by July on 2018/2/2.
 */
public class FileUtil {
    public static String readFile(File file) {
        StringBuilder result = new StringBuilder();
        String lineSeparator = System.getProperty("line.separator");


        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                result.append(line).append(lineSeparator);
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }
}
