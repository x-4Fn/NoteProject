/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mainnote;

import java.util.Scanner;

public class Display {



    // Create instances of other classes
    AddNote obj2 = new AddNote();
    NoteDeleter deleter = new NoteDeleter();
    NoteModifier modi = new NoteModifier();

    // Method to display options to the user and execute their choice
    public void output() {
        // Display options

       System.out.println("(1) Add new note. ");
        System.out.println("(2) Delete a note.");
        System.out.println("(3) Modify a note.");

        // Get user input
        Scanner first = new Scanner(System.in);
        int input = first.nextInt();

        // Execute user choice using a switch statement
        switch (input) {
            case 1:
                obj2.output2(); // Call the "output2" method of the AddNote class
                break;
            case 2:
                deleter.deleteNote(); // Call the "deleteNote" method of the NoteDeleter class
                break;
            case 3:
                modi.modifyNote(); // Call the "modifyNote" method of the NoteModifier class
                break;
            default:
                System.out.println("Invalid choice. Please enter a number from 1 to 3.");
                break;
        }
    }
}

