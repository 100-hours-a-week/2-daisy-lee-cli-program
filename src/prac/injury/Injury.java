package prac.injury;

import java.util.Scanner;
import static prac.human.Patient.patient;

public class Injury {
    Scanner sc = new Scanner(System.in);
    int answer;

    public Injury() {

    }

    // 부상 종류 출력 및 선택
    public void injuryList() {
        Injuries[] injuryArr = Injuries.values();
        for(Injuries injury : injuryArr) {
            int cost = injury.getInjuryCost();
            String costStr = String.format("%,d", cost);
            System.out.printf(" %d. %s (+ ₩" + costStr + ")", injury.getInjuryNumber(), injury.getInjuryName());
            System.out.println();
        }
    }

    public void setInjury() {
        answer = sc.nextInt();
        patient.setInjuryType(Injuries.of(answer));
        System.out.println();
    }

    public void checkInjury() {
        Injuries patientInjury = patient.getInjuryType();
        System.out.println("네, [" + patientInjury.getInjuryName() + "] 으로 접수해드리겠습니다.");
    }

}
