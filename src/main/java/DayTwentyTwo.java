import java.util.HashMap;
import java.util.Map;

public class DayTwentyTwo {

    private Map<String, Integer> grid = new HashMap<>();

    private int packetXPosition;
    private int packetYPosition;

    private final static int CLEAN    = 0;
    private final static int INFECTED = 1;
    private final static int WEAKENED = 2;
    private final static int FLAGGED  = 3;

    private boolean UP =    true;
    private boolean RIGHT = false;
    private boolean DOWN =  false;
    private boolean LEFT =  false;

    public void setup(String input) {
        UP = true;
        String[] startValues = input.split("\n");
        int center = Math.round(startValues .length/ 2) - Math.round(startValues[0].length() / 2) - 1;
        int startX = center;
        int startY = center;

        for(String inputLine : startValues) {
            for(char c : inputLine.toCharArray()) {
                if(c == '#') {
                    grid.put("(" + startX + "," + startY + ")", 1);
                }
                startY++;
            }
            startY = center;
            startX++;
        }
        packetXPosition = center + startValues.length / 2;
        packetYPosition = center + startValues[0].length() / 2;
    }

    public int partOne(int burstCount) {
        final int CLEAN = 0;
        final int INFECTED = 1;
        int infectedCount = 0;
        for(int burst = 0; burst < burstCount; burst++) {
            String position = "(" + packetXPosition + "," + packetYPosition + ")";
            if(grid.containsKey(position) && grid.get(position) == INFECTED) {
                grid.put(position, CLEAN);
                turnRight();
            } else {
                grid.put(position, INFECTED);
                turnLeft();
                infectedCount++;
            }
            moveForward();
        }
        return infectedCount;
    }

    public int partTwo(int burstCount) {

        int infectedCount = 0;
        for(int burst = 0; burst < burstCount; burst++) {
            String position = "(" + packetXPosition + "," + packetYPosition + ")";
            if(grid.containsKey(position)) {
                int infectionStatus = grid.get(position);
                if(infectionStatus == CLEAN) {
                    grid.put(position, WEAKENED);
                    turnLeft();
                } else if(infectionStatus == WEAKENED) {
                    grid.put(position, INFECTED);
                    infectedCount++;
                } else if(infectionStatus == INFECTED) {
                    grid.put(position, FLAGGED);
                    turnRight();
                } else if(infectionStatus == FLAGGED) {
                    grid.put(position, CLEAN);
                    turnRight();
                    turnRight();
                }
            } else {
                grid.put(position, WEAKENED);
                turnLeft();
            }
            moveForward();
        }

        return infectedCount;
    }

    private void moveForward() {
        if(UP) {
            packetXPosition--;
        } else if(RIGHT) {
            packetYPosition++;
        } else if(DOWN) {
            packetXPosition++;
        } else if(LEFT) {
            packetYPosition--;
        }
    }

    private void turnLeft() {
        if(UP) {
            UP = false;
            LEFT = true;
        } else if (LEFT) {
            LEFT = false;
            DOWN = true;
        } else if (DOWN) {
            DOWN = false;
            RIGHT = true;
        } else if (RIGHT) {
            RIGHT = false;
            UP = true;
        }
    }

    private void turnRight() {
        if(UP) {
            UP = false;
            RIGHT = true;
        } else if (RIGHT) {
            RIGHT = false;
            DOWN = true;
        } else if (DOWN) {
            DOWN = false;
            LEFT = true;
        } else if (LEFT) {
            LEFT = false;
            UP = true;
        }
    }

    public static void main(String[] args) {
        DayTwentyTwo dayTwentyTwo = new DayTwentyTwo();
        dayTwentyTwo.setup(input);
        System.out.printf("Part one: %d", dayTwentyTwo.partOne(10_000));
        dayTwentyTwo = new DayTwentyTwo();
        dayTwentyTwo.setup(input);
        System.out.printf("\nPart two: %d", dayTwentyTwo.partTwo(10_000_000));
    }

    private static final String input = "..##.##.######...#.######\n" +
                                        "##...#...###....##.#.#.##\n" +
                                        "###.#.#.#..#.##.####.#.#.\n" +
                                        "..##.##...#..#.##.....##.\n" +
                                        "##.##...#.....#.#..#.####\n" +
                                        ".###...#.........###.####\n" +
                                        "#..##....###...#######..#\n" +
                                        "###..#.####.###.#.#......\n" +
                                        ".#....##..##...###..###.#\n" +
                                        "###.#..#.##.###.#..###...\n" +
                                        "####.#..##.#.#.#.#.#...##\n" +
                                        "##.#####.#......#.#.#.#.#\n" +
                                        "..##..####...#..#.#.####.\n" +
                                        ".####.####.####...##.#.##\n" +
                                        "#####....#...#.####.#..#.\n" +
                                        ".#..###..........#..#.#..\n" +
                                        ".#.##.#.#.##.##.#..#.#...\n" +
                                        "..##...#..#.....##.####..\n" +
                                        "..#.#...######..##..##.#.\n" +
                                        ".####.###....##...####.#.\n" +
                                        ".#####..#####....####.#..\n" +
                                        "###..#..##.#......##.###.\n" +
                                        ".########...#.#...###....\n" +
                                        "...##.#.##.#####.###.####\n" +
                                        ".....##.#.#....#..#....#.";
}
