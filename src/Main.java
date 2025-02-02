import prac.Description;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Description description = new Description();

        description.load();
        description.setPatientInfo(); // 환자 정보 입력(injury, name, wound)
        // 치료자 선택
        // 수술 시작
        // 종료
        // description.setInjury();
    }
}