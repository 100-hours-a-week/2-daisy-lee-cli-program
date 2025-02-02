package prac.injury;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// enum이 복수형태 이기 때문에 Injury.java와 분리
public enum Injuries{
    EXTERNAL(1, "외상", 5000),
    INTERNAL(2, "내상", 8000);

    private final int injuryNumber;
    private final String injuryName;
    private final int injuryCost;

    // injuryMap - (key: injuryNumber, value: injuryName)
    private static Map<Integer, String> injuryMap = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(Injuries::getInjuryNumber, Injuries::getInjuryName))
    );

    // injuryNumber를 통해 injuryName을 추출하는 함수
    public static String of(final int injuryNumber) {
        return Objects.requireNonNull(Arrays.stream(values())
                        .filter(val -> injuryNumber == val.injuryNumber)
                        .findFirst()
                        .orElse(null))
                .getInjuryName();
    }

    Injuries(int injuryNumber, String injuryName, int injuryCost) {
        this.injuryNumber = injuryNumber;
        this.injuryName = injuryName;
        this.injuryCost = injuryCost;
    }

    int getInjuryNumber() {
        return injuryNumber;
    }
    public String getInjuryName() { return injuryName; }
    int getInjuryCost() { return injuryCost; }
}
