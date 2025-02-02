package prac.human;

import prac.injury.Injuries;

import java.util.Scanner;

public class Patient extends Human {
    public static Patient patient = new Patient();
    Scanner sc = new Scanner(System.in);
    String woundType;
    Injuries injuryType;
    String healerType;
    int payment;

    public Patient() {

    }

    Patient(String name) {
        super(name);
    }

    void pay() {

    }

    public String getWoundType() {
        return woundType;
    }
    public void setWoundType(String woundType) {
        this.woundType = woundType;
    }

    public Injuries getInjuryType() {
        return injuryType;
    }
    public void setInjuryType(Injuries injuryType) {
        this.injuryType = injuryType;
    }

    public String getHealerType() {
        return healerType;
    }
    public void setHealerType(String healerType) {
        this.healerType = healerType;
    }

    public int getPayment() {
        return payment;
    }
    public void setPayment(int payment) {
        this.payment = payment;
    }
}
