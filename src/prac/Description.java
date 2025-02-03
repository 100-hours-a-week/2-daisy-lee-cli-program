package prac;

import prac.human.*;
import prac.injury.ExternalWounds;
import prac.injury.Injuries;
import prac.injury.InternalWounds;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static prac.human.Patient.patient;
import static prac.injury.Injuries.EXTERNAL;
import static prac.injury.Injury.injury;

public class Description {
    public static final Scanner sc = new Scanner(System.in);
    // Healer 하위 클래스 선언 및 초기화
    final Healer intern = new Intern("1년 미만 실습생", 100000, 30, 50);
    final Healer resident = new Resident("3년 이상 레지던트", 200000, 50, 60);
    final Healer expert = new Expert("10년 이상 베테랑", 700000, 70, 80);
    final Healer oneself = new Oneself("본인 (⚠️ 권장하지 않습니다!)", 0, 0, 100);
    final Healer healer = new Healer();
    Healer[] healers = {intern, resident, expert, oneself};

    public Description() {

    }

    public void start() {
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
//        if(patient.getInjuryType() == EXTERNAL) {   // 외상일 경우, 추가 시나리오 .. 미구현
//            askPatient();
//        }
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
        System.out.println("      어떤 [" + patient.getInjuryType().getInjuryName() + "]에 해당하는지 선택해주세요.");

        injury.woundList(); // 환자가 택한 부상 종류에 따른 치료 부위 출력
        select();
        answer = sc.nextInt();
        patient.setWoundType(answer);   // 치료 부위 설정
        moveToHospital();
    }

    public void moveToHospital(){
        String hospital = injury.findHospital();
        injury.setHospitalName(hospital);
        loadingDots();
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

    private void loadingDots() {
        line();
        System.out.print(" " + injury.getHospitalName() + " (으)로 이동 중입니다");
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
            for(int i = 0; i < 3; i++) {    // ..? 출력하기 위한.. for문
                System.out.print(expelTexts[i]);
                Thread.sleep(400);
                System.out.flush();
            }
            System.out.println();
            for(int i = 3; i < expelTexts.length; i++) {    // 문장을 출력하기 위한 for문
                System.out.println(expelTexts[i]);
                Thread.sleep(1000);
                System.out.flush();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void setHealer() {
        line();
        doctorSmile();
        try {
            System.out.println("어서오세요 환자분, 이제 수술 진행할건데");
            Thread.sleep(1000);
            System.out.println("     저희 병원은 환자분의 \'수술 진행자 선택 권리\'를 제공합니다.");
            Thread.sleep(1000);
            System.out.println("     참 친절하지요? 아래에서 수술 진행자를 선택하세요.");
            Thread.sleep(1000);
            System.out.flush();
            System.out.println();
            healer.healerList(healers);
            select();
            int answer = sc.nextInt();
            patient.setHealerType(healers[answer-1]);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void handlePay() {
        int finalPayment = 0;
        line();
        doctorSmile();
        System.out.println("결제하시면 수술실로 안내하겠습니다 ^^.");
        System.out.println("     결제 내역은 아래와 같습니다.");
        printReceipt();
        doctorSmile();
        System.out.printf("총 지불하셔야 하는 금액 ₩ %s 되십니다~ ", String.format("%,d", patient.getPayment()));

        while(finalPayment < patient.getPayment()) {
            System.out.println();
            System.out.print(" >> 지불할 금액 : ");
            finalPayment = sc.nextInt();
            if(finalPayment < patient.getPayment()) {
                doctorFrown();
                System.out.println(".. 설마 돈이 부족하신 건 아니죠?");
            } else {
                doctorSmile();
                System.out.printf("거스름돈은 ₩ %s 입니다~", String.format("%,d", finalPayment - patient.getPayment()));
            }
        }

    }

    public void startOperation() {

    }

    private void printReceipt() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        Date now = new Date();
        Injuries injuryInfo = patient.getInjuryType();
        int woundCost;
        String woundName;
        if(injuryInfo == EXTERNAL) {
            woundCost = ExternalWounds.of(patient.getWoundType()).getWoundCost();
            woundName = ExternalWounds.of(patient.getWoundType()).getWoundName();
        } else {
            woundCost = InternalWounds.of(patient.getWoundType()).getWoundCost();
            woundName = InternalWounds.of(patient.getWoundType()).getWoundName();
        }

        patient.pay(patient.getInjuryType().getInjuryCost()); // 부상
        patient.pay(woundCost); // 치료 부위
        patient.pay(patient.getHealerType().getCost()); // 수술 진행 비용

        System.out.println(" ┌──────────────────────────────────────┐");
        System.out.println("           《  영    수    증  》");
        System.out.println();
        System.out.printf("   성함 : %s\n", patient.getName());
        System.out.printf("   부상 종류 - [%s]\n", patient.getInjuryType().getInjuryName());
        System.out.printf("    ⇒ [%s] 으로 인한 통증 호소\n", woundName);
        System.out.printf("   (₩ %s + ₩ %s)\n", String.format("%,d", patient.getInjuryType().getInjuryCost()), String.format("%,d", woundCost));
        System.out.println();
        System.out.printf("   수술 진행 병원 : [%s] \n", injury.getHospitalName());
        System.out.printf("   수술 진행자 : [%s] (₩ %s)\n", patient.getHealerType().getType(), String.format("%,d", patient.getHealerType().getCost()));
        System.out.println();
        System.out.printf("   { 합계 : ₩ %s }\n", String.format("%,d", patient.getPayment()));
        System.out.println("  - - - - - - - - - - - - - - - - - - - -");
        System.out.printf("                  %s", sdf.format(now)); // 실행 시킨 날짜
        System.out.println("\n");
        System.out.println("          ꕥ 운수좋은날 종합병원 ꕥ");
        System.out.println("     \"당신이 가장 운 좋은 환자가 되길 바라며!\"");
        System.out.println(" └──────────────────────────────────────┘");
    }

    public void endOperation() {

    }

    public void end() {

    }

    private void line() {
        System.out.println("─────────────────────────────────────");
    }
    private void select() { System.out.print(" >> "); }
    private void nurseSmile() {
        System.out.print("😄 : ");
    }
    private void doctorSmile() {
        System.out.print("🤓 : ");
    }
    private void doctorFrown() {
        System.out.print("🤨 : ");
    }

}
