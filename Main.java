package com.matej.files;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("./src/com/matej/files/res/"));

        chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".txt")
                        || f.isDirectory();
            }

            public String getDescription() {
                return "GIF Images";
            }
        });

        int r = chooser.showOpenDialog(new JFrame());
        File selectedFile = null;
        if (r == JFileChooser.APPROVE_OPTION) {
            String name = chooser.getSelectedFile().getName();
            System.out.println(name);
            selectedFile = chooser.getSelectedFile();
        }
        Scanner scanner = null;
        try {
            if (selectedFile != null) {
                scanner = new Scanner(selectedFile);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (scanner != null) {
            while(scanner.hasNextInt()){
                System.out.println(scanner.nextInt());
            }
        }
    }
}