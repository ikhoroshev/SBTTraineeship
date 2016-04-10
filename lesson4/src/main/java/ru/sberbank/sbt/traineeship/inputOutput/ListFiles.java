package ru.sberbank.sbt.traineeship.inputOutput;

import java.io.File;

/**
 * Created by фвьшт on 10.04.2016.
 */
public class ListFiles {
    public static void main(String[] args) {
        File dir = new File("d:\\work\\tutoring\\SBTTraineeship\\lesson4");
        System.out.println ("Exists: " + dir.exists() + " Directory: " + dir.isDirectory());
        String[] dirNames = dir.list();
        for (String dirName : dirNames){
            System.out.println(dirName);
        }
    }
}
