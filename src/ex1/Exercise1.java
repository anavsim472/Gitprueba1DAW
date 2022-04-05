/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class Exercise1 {

    public static void main(String[] args) {
        Scanner scs = new Scanner(System.in);
        Scanner sci = new Scanner(System.in);
        ObjectOutputStream output = null;
        ObjectInputStream input = null;
        Student s = null;
        try {
            output = new ObjectOutputStream(new FileOutputStream("students.ser"));
        } catch (IOException ex) {
            Logger.getLogger(Exercise1.class.getName()).log(Level.SEVERE, null, ex);
        }

        do {
            System.out.println("Type the ID of the student");
            int id = sci.nextInt();
            if (id == 0) {
                break;
            }
            System.out.println("Input the name of the student:");
            String name = scs.nextLine();
            System.out.println("Input the surname: ");
            String surname = scs.nextLine();
            System.out.println("Input the first mark: ");
            double mark1 = sci.nextDouble();
            System.out.println("Input the second mark: ");
            double mark2 = sci.nextDouble();
            System.out.println("Input the third mark: ");
            double mark3 = sci.nextDouble();

            s = new Student(id, name, surname, mark1, mark2, mark3);

            try {
                output.writeObject(s);
            } catch (IOException ex) {
                Logger.getLogger(Exercise1.class.getName()).log(Level.SEVERE, null, ex);
            }

        } while (true);

        if (output != null) {
            try {
                output.close();
            } catch (IOException ex) {
                Logger.getLogger(Exercise1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {
            input = new ObjectInputStream(new FileInputStream("students.ser"));
        } catch (IOException ex) {
            Logger.getLogger(Exercise1.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (true) {
            try {
                s = (Student) input.readObject();
                System.out.println(s);
            } catch (EOFException eof) {
                break;
            } catch (IOException ex) {
                Logger.getLogger(Exercise1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Exercise1.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (input!=null) {
            try {
                input.close();
            } catch (IOException ex) {
                Logger.getLogger(Exercise1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
