/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.util.Comparator;

/**
 *
 * @author alumno
 */
public class SurnameComparator implements Comparator<Contact> {
        @Override
    public int compare(Contact t, Contact t1) {
        if(!t.surname.equalsIgnoreCase(t1.surname))
        return t.surname.compareToIgnoreCase(t1.surname);
        else return t.name.compareToIgnoreCase(t1.name);
    }
}
