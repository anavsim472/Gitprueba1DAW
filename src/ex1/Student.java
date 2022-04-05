/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.io.Serializable;

/**
 *
 * @author alumno
 */
public class Student implements Serializable {

    private int id;
    private String name;
    private String surname;
    private double mark1;
    private double mark2;
    private double mark3;

    public Student(int id,String name, String surname, double mark1, double mark2, double mark3) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
    }

    public Student(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public double getMark1() {
        return mark1;
    }

    public void setMark1(double mark1) {
        this.mark1 = mark1;
    }

    public double getMark2() {
        return mark2;
    }

    public void setMark2(double mark2) {
        this.mark2 = mark2;
    }

    public double getMark3() {
        return mark3;
    }

    public void setMark3(double mark3) {
        this.mark3 = mark3;
    }

    public double average() {
        return (mark1 + mark2 + mark3)/3.0 ;
    }

    @Override
    public String toString() {
        return "|ID: "+id+"| |Name: "+name+"| |Surname: "+surname+"| |Average: "+average()+"|";
    }
    
    
}
