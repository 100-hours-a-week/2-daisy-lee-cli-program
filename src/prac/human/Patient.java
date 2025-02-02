package prac.human;

import prac.injury.Injuries;

import java.util.Scanner;

public class Patient extends Human {
    public static Patient patient = new Patient();
    int woundType;
    int injuryType; // TODO. Injuries -> int 자료형 수정 [O]
    String healerType;
    int payment;

    public Patient() {

    }

    Patient(String name) {
        super(name);
    }

    void pay() {

    }

    public int getWoundType() {
        return woundType;
    }
    public void setWoundType(int woundType) {
        this.woundType = woundType;
    }

    public int getInjuryType() {
        return injuryType;
    }
    public void setInjuryType(int injuryType) {
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
