import java.math.BigInteger;
import java.util.HashMap;

public class DayTwentyThree {
    private HashMap<String, BigInteger> registerValues = new HashMap<String, BigInteger>();

    private int currentPosition = 0;

    private String[] instructions;

    public void setUp(String input) {
        String[] registerNames = new String[]{ "a", "b", "c", "d", "e", "f", "g", "h"};
        for(String s: registerNames) { registerValues.put(s, BigInteger.valueOf(0)); }
        instructions = input.split("\n");
    }

    private void set(String x, String y) {
        registerValues.put(x, getValueofKey(y));
        currentPosition++;
    }

    private void sub(String x, String y) {
        registerValues.put(x, getValueofKey(x).subtract(getValueofKey(y)));
        currentPosition++;
    }

    private void mul(String x, String y) {
        registerValues.put(x, getValueofKey(x).multiply(getValueofKey(y)));
        currentPosition++;
    }

    private void jnz(String x, String y) {
        currentPosition += getValueofKey(x).intValue() != 0 ? getValueofKey(y).intValue() : 1;
    }

    private BigInteger getValueofKey(String checkValue) {
        try {
            return BigInteger.valueOf((Long.parseLong(checkValue)));
        } catch(Exception e) {
            return(registerValues.get(checkValue));
        }
    }

    private int performAction() {
        int multiplyCount = 0;
        while(currentPosition < instructions.length) {
            String[] action = instructions[currentPosition].split(" ");
//            System.out.printf("%nCurrent position: %d     Value: %s   Key: %s  Instruction: %s", currentPosition, action[1], registerValues.get(action[1]), Arrays.toString(action));
            if(action[0].startsWith("set")) {
                set(action[1], action[2]);
            } else if(action[0].startsWith("sub")) {
                sub(action[1], action[2]);
            } else if(action[0].startsWith("mul")) {
                mul(action[1], action[2]);
                multiplyCount++;
            } else if(action[0].startsWith("jnz")) {
                jnz(action[1], action[2]);
            }
        }
        return multiplyCount;
    }

    private BigInteger performActionPartTwo() {
        while(currentPosition < instructions.length) {
            registerValues.put("a", BigInteger.valueOf(1));
            String[] action = instructions[currentPosition].split(" ");
//            System.out.printf("%nCurrent position: %d     key: %s   value: %s       Instruction: %s", currentPosition, action[1], registerValues.get(action[1]), Arrays.toString(action));
            if(action[0].startsWith("set")) {
                set(action[1], action[2]);
            } else if(action[0].startsWith("sub")) {
                sub(action[1], action[2]);
            } else if(action[0].startsWith("mul")) {
                mul(action[1], action[2]);
            } else if(action[0].startsWith("jnz")) {
                jnz(action[1], action[2]);
            }
            //System.out.println(registerValues.get("h"));
        }
        return registerValues.get("h");
    }

    public static void main(String[] args) {
        DayTwentyThree dayTwentyThree = new DayTwentyThree();
        dayTwentyThree.setUp(input);
        System.out.printf("%nPart one: %d", dayTwentyThree.performAction());

        dayTwentyThree = new DayTwentyThree();
        dayTwentyThree.setUp(input);
        System.out.printf("%nPart two: %d", dayTwentyThree.performActionPartTwo());
    }

    private static final String input = "set b 99\n" +
                                        "set c b\n" +
                                        "jnz a 2\n" +
                                        "jnz 1 5\n" +
                                        "mul b 100\n" +
                                        "sub b -100000\n" +
                                        "set c b\n" +
                                        "sub c -17000\n" +
                                        "set f 1\n" +
                                        "set d 2\n" +
                                        "set e 2\n" +
                                        "set g d\n" +
                                        "mul g e\n" +
                                        "sub g b\n" +
                                        "jnz g 2\n" +
                                        "set f 0\n" +
                                        "sub e -1\n" +
                                        "set g e\n" +
                                        "sub g b\n" +
                                        "jnz g -8\n" +
                                        "sub d -1\n" +
                                        "set g d\n" +
                                        "sub g b\n" +
                                        "jnz g -13\n" +
                                        "jnz f 2\n" +
                                        "sub h -1\n" +
                                        "set g b\n" +
                                        "sub g c\n" +
                                        "jnz g 2\n" +
                                        "jnz 1 3\n" +
                                        "sub b -17\n" +
                                        "jnz 1 -23";
}
