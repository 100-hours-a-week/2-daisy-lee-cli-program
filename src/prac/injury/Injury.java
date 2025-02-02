package prac.injury;

import java.util.Scanner;

import static prac.Description.sc;
import static prac.human.Patient.patient;

// TODO. 외상/내상 리스트 함수
public class Injury {
    public static Injury injury = new Injury();
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
        if(answer == 1) {   // 외상으로 다시 선언
            injury = new ExternalWound();
        } else {            // 내상으로 다시 선언
            injury = new InternalWound();
        }
        patient.setInjuryType(answer);
        System.out.println();
    }

    public void checkInjury() {
        System.out.println("네, [" + Injuries.of(patient.getInjuryType()) + "] 으로 접수해드리겠습니다.");
    }

    // 외상/내상에 따른 치료부위 목록 출력
    public void woundList() {
        System.out.println("부위를 선택합니다.");
    }

    // 치료부위에 따른 병원 이송
    public String findHospital() {
        System.out.println("환자를 이송합니다.");
        return null;
    }

    public void questions(){

    }

    public boolean isAllNo() {
        // ExternalWound 일 경우 체크
        return false;
    }
}
