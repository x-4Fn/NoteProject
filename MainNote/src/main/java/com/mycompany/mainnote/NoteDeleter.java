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



// This code defines a class called NoteDeleter that allows the user to delete a note from a file based on the note's title.

public class NoteDeleter {
    
    // This method allows the user to delete a note from the file "file.txt" based on its title.
    public void deleteNote() {
        
        // Ask the user to enter the title of the note they want to delete.
        System.out.println("Enter the title of the note you want to delete:");
        Scanner titleScanner = new Scanner(System.in);
        String title = titleScanner.nextLine();
        
        try {
            // Create a new file called "tempFile.txt" to temporarily store the contents of "file.txt" without the deleted note.
            File inputFile = new File("file.txt");
            File tempFile = new File("tempFile.txt");
            
            // Use a BufferedReader to read the contents of "file.txt" line by line.
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            // Initialize variables for the line to remove and the current line being read.
            String lineToRemove = "Title: " + title;
            String currentLine;

            // Loop through each line of the file.
            while((currentLine = reader.readLine()) != null) {
                // Trim newline when comparing with lineToRemove.
                String trimmedLine = currentLine.trim();
                // If the line matches the title, skip the next three lines (which contain the note's content and date).
                if(trimmedLine.equals(lineToRemove)) {
                    reader.readLine();
                    reader.readLine();
                    reader.readLine();
                }
                // If the line does not match the title, write it to the new temporary file.
                else {
                    writer.write(currentLine + "\n");
                }
            }
            // Close the reader and writer.
            writer.close();
            reader.close();
            
            // Delete the original file and rename the temporary file to "file.txt".
            inputFile.delete();
            tempFile.renameTo(inputFile);
            
            // Print a message indicating whether the note was successfully deleted or not.
            System.out.println("Note with the title " + title + " has been successfully deleted.");
        } catch (IOException ex) {
            // If an error occurs, print a message indicating that the note was not deleted.
            System.out.println("An error occurred while deleting the note.");
        }
    }
}
