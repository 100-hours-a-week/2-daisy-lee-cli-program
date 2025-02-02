package prac;

import prac.injury.ExternalWound;
import prac.injury.Injuries;
import prac.injury.Injury;
import prac.injury.InternalWound;

import java.util.Scanner;

import static prac.human.Patient.patient;

public class Description {
    Scanner sc = new Scanner(System.in);
    Injury injury = new Injury();
    ExternalWound externalWound = new ExternalWound();
    InternalWound internalWound = new InternalWound();

    public Description() {

    }

    public void load() {
        System.out.println("━━━━━━━━━━━━━━━ ➕ ━━━━━━━━━━━━━━━━━━\n");
        System.out.println("        ꕥ 운수좋은날 종합병원 ꕥ");
        System.out.println("  \"당신이 가장 운 좋은 환자가 되길 바라며!\"\n");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
        nurseSmile();
        System.out.println(" 안녕하세요~ 어디가 아파서 오셨나요?");
    }

    public void setPatientInfo() {
        setPatientInjury();        // 부상 분류 선택
        setPatientName();   // 환자 이름 설정
        setPatientWound();
    }

    public void setPatientInjury() {
        injury.injuryList();
        select();
        injury.setInjury();
        line();
        nurseSmile();
        injury.checkInjury();
    }

    public void setPatientName() {
        System.out.println("     성함은 어떻게 되실까요? ");
        select();
        String name = sc.next();
        patient.setName(name);
        line();
    }

    public void setPatientWound() {
        nurseSmile();
        System.out.println("\'" + patient.getName() + "\' 님, 해당 부위에 대한 추가적인 정보가 필요합니다.");
        System.out.println("      어떤 [" + patient.getInjuryType().getInjuryName() + "]에 해당하는지 선택해주세요.");

        if(patient.getInjuryType() == Injuries.EXTERNAL) { // 외상
            externalWound.externalWoundList();
        } else { // 내상
            internalWound.internalWoundList();
        }
        select();
    }


    private void line() {
        System.out.println("─────────────────────────────────────");
    }
    private void select() { System.out.print(" >> "); }
    private void nurseSmile() {
        System.out.print("😄 : ");
    }
    private void nurseFrown() {
        System.out.print("'_' : ");
    }

}
