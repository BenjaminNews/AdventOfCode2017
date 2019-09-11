import java.time.LocalDateTime;
import java.util.Date;

public class DayFifthteen {

    private static final long divisor = 2_147_483_647;
    private static final long generatorAMultiplyValue = 16_807;
    private static final long generatorBMultiplyValue = 48_271;
    private static int matchCount;

    public static int getResult(long generatorAValue, long generatorBValue, long generations) {
        matchCount = 0;
        for(int cycle = 0; cycle < generations; cycle++) {
            generatorAValue = (generatorAValue * generatorAMultiplyValue) % divisor;
            generatorBValue = (generatorBValue *generatorBMultiplyValue) % divisor;
            checkForMatch(generatorAValue, generatorBValue);
        }
        return matchCount;
    }

    public static int getResultPartTwo(long generatorAValue, long generatorBValue, long generations) {
        matchCount = 0;
        for (int i = 0; i < generations; i++) {
            do {
                generatorAValue = (generatorAValue * generatorAMultiplyValue) % 2147483647;
            } while (generatorAValue % 4 != 0);
            do {
                generatorBValue = (generatorBValue * generatorBMultiplyValue) % 2147483647;
            } while (generatorBValue % 8 != 0);
            checkForMatch(generatorAValue, generatorBValue);
        }
        return matchCount;
    }

    private static void checkForMatch(long generatorAValue, long generatorBValue) {
        if((updateString(Long.toBinaryString(generatorAValue))).equalsIgnoreCase(updateString(Long.toBinaryString(generatorBValue)))) {
            matchCount++;
        }
    }

    private static String updateString(String generatorBiniaryString) {
        StringBuilder startingZeros = new StringBuilder();
        if(generatorBiniaryString.length() >= 16) {
            return generatorBiniaryString.substring(generatorBiniaryString.length() - 16);
        }
        for(int i = 0; i < 16 - generatorBiniaryString.length(); i++) {
            startingZeros.append("0");
        }
        return startingZeros + generatorBiniaryString;
    }

    public static void main(String[] args) {
        System.out.printf("Part one: %d generations: %d", DayFifthteen.getResult(591, 393, 40_000_000), 40_000_000);
        System.out.printf("%nPart two: %d generations: %d", DayFifthteen.getResultPartTwo(591, 393, 5_000_000), 5_000_000);
    }
}
