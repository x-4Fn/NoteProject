/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mainnote;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NoteModifier {
    
    // Method to modify a note
    public void modifyNote() {
        System.out.println("Enter the title of the note you want to modify:");
        Scanner titleScanner2 = new Scanner(System.in);
        String title = titleScanner2.nextLine();
        try {
            // Open the input and temp files
            File inputFile = new File("file.txt");
            File tempFile = new File("tempFile.txt");

            // Create readers and writers for the input and temp files
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            // Get the title to modify and the new note text from the user
            String lineToModify = "Title: " + title;
            String currentLine;
            boolean modified = false;

            // Read each line of the input file and write to temp file,
            // except for the line with the title to modify
            while((currentLine = reader.readLine()) != null) {
                String trimmedLine = currentLine.trim();
                if(trimmedLine.equals(lineToModify)) {
                    // Skip the current line with the title, and prompt user for the new note
                    reader.readLine();
                    System.out.println("Enter the new note:");
                    Scanner sc = new Scanner(System.in);
                    String newNote = sc.nextLine();
                    
                    // Write the title, new note, and remaining line to temp file
                    writer.write(lineToModify + "\n");
                    writer.write("Note: " + newNote + "\n");
                    currentLine = reader.readLine();
                    writer.write(currentLine + "\n");
                    
                    // Set the modified flag to true
                    modified = true;
                }
                else {
                    // Write the current line to temp file
                    writer.write(currentLine + "\n");
                }
            }
            
            // Close readers and writers
            writer.close();
            reader.close();
            
            // Delete the input file and rename the temp file to input file
            inputFile.delete();
            tempFile.renameTo(inputFile);

            // Print success message if modified, error message otherwise
            if (modified) {
                System.out.println("Note with the title " + title + " has been successfully modified.");
            } else {
                System.out.println("Note with title '" + title + "' not found.");
            }
        } catch (IOException ex) {
            System.out.println("An error occurred while modifying the note.");
        }
    }
}
