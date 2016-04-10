package ru.sberbank.sbt.traineeship.inputOutput;

import java.io.*;

/**
 * Created by salexandrov on 10.04.2016.
 */
public class UnicodeFileExample {
    private static final int BUF_SIZE = 200;
    private static final String FILE_NAME = "d:\\work\\tutoring\\SBTTraineeship\\lesson4\\doc\\sampletext.txt";
    public static void main(String[] args){
        Reader reader = null;
        try {
            reader = new InputStreamReader(new FileInputStream(FILE_NAME), "utf8");
//            reader = new FileReader(FILE_NAME);

            char[] buf = new char[BUF_SIZE];
            int count = 0;
            while ((count = reader.read(buf)) != -1){
                System.out.print(buf);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
