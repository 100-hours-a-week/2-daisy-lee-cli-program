package prac;

import prac.injury.ExternalWound;
import prac.injury.Injuries;
import prac.injury.Injury;
import prac.injury.InternalWound;

import java.util.Scanner;

import static prac.human.Patient.patient;
import static prac.injury.Injury.injury;

public class Description {
    public static final Scanner sc = new Scanner(System.in);
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
        setPatientInjury();         // 부상 분류 설정
        setPatientName();           // 환자 이름 설정
        setPatientWound();          // 치료 부위 설정
        if(patient.getInjuryType() == 1) {   // 외상일 경우, 추가 시나리오
            askPatient();
        }
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
        int answer;
        nurseSmile();
        System.out.println("\'" + patient.getName() + "\' 님, 해당 부위에 대한 추가적인 정보가 필요합니다.");
        System.out.println("      어떤 [" + Injuries.of(patient.getInjuryType()) + "]에 해당하는지 선택해주세요.");

        injury.woundList(); // 환자가 택한 부상 종류에 따른 치료 부위 출력
        select();
        answer = sc.nextInt();
        patient.setWoundType(answer);   // 치료 부위 설정
        moveToHospital();
    }

    public void moveToHospital(){
        String hospital = injury.findHospital();
        loadingDots(hospital);
    }

    public void askPatient() {
        doctorSmile();
        System.out.println("안녕하세요. \'" + patient.getName() + "\' 님, 치료에 앞서 진단을 할 예정입니다.");
        System.out.println("     제가 하는 질문에 Y 또는 N으로 \'정직하게\' 대답해주세요.");
        injury.questions();
        if(injury.isAllNo()) {
            expelPatient();
        }
    }

    private void loadingDots(String hospital) {
        line();
        System.out.print(" " + hospital + " (으)로 이동 중입니다");
        try {
            for(int i = 0; i < 3; i++) {
                System.out.print(" ·");
                Thread.sleep(1500);
                System.out.flush();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print(" 🏥");
        System.out.println();
        line();
    }

    private void expelPatient() {
        String expelTexts[] = {
                ". ", ". ", "?",
                "     환자분, 병원은 장난이 아닙니다.",
                "     그렇게 아프시지 않은가 본데, 다른 환자분들 진료가 더 급한 것 같네요.",
                "     엄연한 업무 방해죄 입니다.",
                "     저희 병원에서 나가주세요. 😡"
        };
        doctorFrown();
        try {
            for(int i = 0; i < 3; i++) {    // ..? 찍기 위한.. for문
                System.out.print(expelTexts[i]);
                Thread.sleep(400);
                System.out.flush();
            }
            System.out.println();
            for(int i = 3; i < expelTexts.length; i++) {
                System.out.println(expelTexts[i]);
                Thread.sleep(1000);
                System.out.flush();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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
    private void doctorSmile() {
        System.out.print("🤓 : ");
    }
    private void doctorFrown() {
        System.out.print("🤨 : ");
    }

}
