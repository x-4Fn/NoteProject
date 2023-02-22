/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mainnote;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddNote   {

    // Method to add a new note to a file
    public void output2() {

        // Display options for password or no password
        System.out.println("(1)Password note. ");
        System.out.println("(2)without password. ");
        Scanner pass = new Scanner(System.in);

        // Get user input
        int choice = pass.nextInt();

        // Execute user choice using a switch statement
        switch (choice) {
            case 1:
                System.out.println("This feature is not supported yet"); // If user chooses password option, display message that it's not supported yet
                break;
            case 2:
                // If user chooses no password option, prompt for title, note, and date
                System.out.println("Title: ");
                Scanner k = new Scanner(System.in);
                String title1 = k.nextLine();

                System.out.println("Write down your note:");
                Scanner m = new Scanner(System.in);
                String note1 = m.nextLine();

                System.out.println("Date:");
                Date thisDate1 = new Date();
                System.out.println(thisDate1);

                // Write title, note, and date to a file
                try {
                    FileWriter fw = new FileWriter("file.txt", true);
                    fw.write("Title: " + title1 + "\n");
                    fw.write("Note: " + note1 + "\n");
                    fw.write("Date: " + thisDate1 + "\n");
                    fw.write("---------------\n");
                    System.out.println("File written successfully.");
                    fw.close();
                } catch (IOException ex) {
                    Logger.getLogger(AddNote.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            default:
                System.out.println("Invalid choice");
                break;
        }
    }   
}

