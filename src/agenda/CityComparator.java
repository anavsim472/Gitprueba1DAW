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
public class CityComparator implements Comparator<Contact> {

    public int compare(Contact t, Contact t1) {
        if (!t.city.equalsIgnoreCase(t1.city)) {
            return t.city.compareToIgnoreCase(t1.city);
        } else {
            return t.phone_number - t1.phone_number;
        }
    }

}
