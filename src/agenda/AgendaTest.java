/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import ex1.Exercise1;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import myOOS.MyObjectOutputStream;

/**
 *
 * @author alumno
 */
public class AgendaTest {

    private static List<Contact> agenda = new ArrayList();
    private static Scanner scs = new Scanner(System.in);
    private static Scanner sci = new Scanner(System.in);
    private static ObjectOutputStream output = null;
    private static ObjectInputStream input = null;
    private static MyObjectOutputStream write = null;
    private static Contact c = null;

    public static void main(String[] args) {
        int option, index;
        do {
            System.out.println("*******MENU********");
            System.out.println("1.- Insert a new contact into the agenda");
            System.out.println("2.- Search a contact in the agenda.");
            System.out.println("3.- Edit a contact of the agenda");
            System.out.println("4.- Remove a contact from the agenda");
            System.out.println("5.- Sort the agenda by different fields");
            System.out.println("6.- Exit and create a serializable file with data");
            System.out.println("CHOOSE AN OPTION :");
            option = sci.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter the name of the contact:");
                    String name = scs.nextLine();
                    System.out.println("Enter the surname:");
                    String surname = scs.nextLine();
                    System.out.println("Enter the address:");
                    String address = scs.nextLine();
                    System.out.println("Enter the city:");
                    String city = scs.nextLine();
                    System.out.println("Enter the phone number:");
                    int phone = sci.nextInt();

                    c = new Contact(name, surname, address, city, phone);
                    agenda.add(c);

                    break;
                case 2:
                    System.out.println(agenda.get(searchContact()));
                    break;
                case 3:
                    index = searchContact();
                    System.out.println("1. Name");
                    System.out.println("2. Surname");
                    System.out.println("3. Address");
                    System.out.println("4. City");
                    System.out.println("5. Phone number");
                    System.out.println("Choose the field to be updated: ");
                    int option2 = sci.nextInt();
                    switch (option2) {
                        case 1:
                            System.out.println("Input the new name: ");
                            agenda.get(index).setName(scs.nextLine());
                            System.out.println("Name changed succesfully");
                            break;
                        case 2:
                            System.out.println("Input the new surname: ");
                            agenda.get(index).setSurname(scs.nextLine());
                            System.out.println("Surname changed succesfully");
                            break;
                        case 3:
                            System.out.println("Input the new address: ");
                            agenda.get(index).setAddress(scs.nextLine());
                            System.out.println("Address changed succesfully");
                            break;
                        case 4:
                            System.out.println("Input the new city: ");
                            agenda.get(index).setCity(scs.nextLine());
                            System.out.println("City changed succesfully");
                            break;
                        case 5:
                            System.out.println("Input the new phone: ");
                            agenda.get(index).setPhone_number(sci.nextInt());
                            System.out.println("Phone changed succesfully");
                            break;
                        default:
                            System.out.println("Wrong input");
                    }

                    break;
                case 4:
                    index = searchContact();
                    agenda.remove(agenda.get(index));
                    System.out.println("Contact deleted");
                    break;
                case 5:
                    System.out.println("1.- Order by surname");
                    System.out.println("2.- Order by city");
                    System.out.println("Choose an option: ");
                    int option3 = sci.nextInt();
                    switch (option3) {
                        case 1:
                            Collections.sort(agenda, new SurnameComparator());
                            System.out.println("The Agenda was sorted by surnames.");
                            break;
                        case 2:
                            Collections.sort(agenda, new CityComparator());
                            System.out.println("The agenda was sorted by cities");
                            break;
                        default:
                            System.out.println("WRONG INPUT");
                    }
                    break;
                case 6:
                    File file = new File("agenda.ser");
                    if (!file.exists()) {
                        createFile();
                        readFile();
                        closeFile();
                        System.out.println("File created succesfully");
                    } else {
                        System.out.println("The file exists, you want to delete it or add records?");
                        System.out.println("1.- DELETE");
                        System.out.println("2.- ADD");
                        int choose = sci.nextInt();
                        switch (choose) {
                            case 1:
                                file.delete();
                                System.out.println("The file was deleted");
                                break;
                            case 2:
                                writeFile();
                                readFile();
                                closeFile();
                                System.out.println("Data added succesfully");
                                break;
                            default:
                                System.out.println("Wrong input");
                                break;
                        }
                    }   
                    break;
                default:
                    System.out.println("WRONG INPUT, TRY AGAIN");
            }
        } while (option != 6);

    }

    public static int searchContact() {
        for (int i = 0; i < agenda.size(); i++) {
            System.out.println((i + 1) + "." + agenda.get(i).getSurname() + ", " + agenda.get(i).getName());
        }
        System.out.println("----------");
        System.out.println("Type the index of the contact?");
        int index = sci.nextInt();
        return index - 1;
    }

    public static void createFile() {
        try {
            output = new ObjectOutputStream(new FileOutputStream("agenda.ser"));
        } catch (IOException ex) {
            Logger.getLogger(Exercise1.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Contact ct : agenda) {
            try {
                output.writeObject(ct);
            } catch (IOException ex) {
                Logger.getLogger(Exercise1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void writeFile() {
        try {
            write = new MyObjectOutputStream(new FileOutputStream("agenda.ser", true));
        } catch (IOException ex) {
            Logger.getLogger(Exercise1.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Contact ct : agenda) {
            try {
                write.writeObject(ct);
            } catch (IOException ex) {
                Logger.getLogger(Exercise1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void readFile() {
        try {
            input = new ObjectInputStream(new FileInputStream("agenda.ser"));
        } catch (IOException ex) {
            Logger.getLogger(AgendaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (true) {
            try {
                c = (Contact) input.readObject();
                System.out.println(c);
            } catch (EOFException eof) {
                break;
            } catch (IOException ex) {
                Logger.getLogger(AgendaTest.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AgendaTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void closeFile() {
        if (input != null) {
            try {
                input.close();
            } catch (IOException ex) {
                Logger.getLogger(Exercise1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (output != null) {
            try {
                output.close();
            } catch (IOException ex) {
                Logger.getLogger(AgendaTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (write != null) {
            try {
                write.close();
            } catch (IOException ex) {
                Logger.getLogger(AgendaTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
