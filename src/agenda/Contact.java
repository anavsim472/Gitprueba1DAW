/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.io.Serializable;

/**
 *
 * @author alumno
 */
//Class contact
public class Contact implements Serializable {
    protected String name;
    protected String surname;
    protected String address;
    protected String city;
    protected int phone_number;

    public Contact(String name, String surname, String address, String city, int phone_number) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.city = city;
        this.phone_number = phone_number;
    }
    
    public Contact(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "Contact{" + "name=" + name + ", surname=" + surname + ", address=" + address + ", city=" + city + ", phone_number=" + phone_number + '}';
    }
    
}
