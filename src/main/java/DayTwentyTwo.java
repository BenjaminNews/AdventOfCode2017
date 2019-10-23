import java.util.Arrays;
import java.util.stream.IntStream;

public class DayTwentyTwo {

    private long[][] grid;

    private int packetXPosition;
    private int packetYPosition;

    private boolean UP =    true;
    private boolean RIGHT = false;
    private boolean DOWN =  false;
    private boolean LEFT =  false;

    public void setup(String input, int size) {
        String[] startValues = input.split("\n");
        grid = new long[size - 1][size - 1];
        int center = Math.round(size / 2) - Math.round(startValues[0].length() / 2) - 1;
        int startX = center;
        int startY = center;

        for(String inputLine : startValues) {
            for(char c : inputLine.toCharArray()) {
                if(c == '#') {
                    grid[startX][startY] = 1;
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
        int infectedCount = 0;
        for(int burst = 0; burst < burstCount; burst++) {
            if(grid[packetXPosition][packetYPosition] == 1) {
                grid[packetXPosition][packetYPosition] = 0;
                turnRight();
            } else {
                grid[packetXPosition][packetYPosition] = 1;
                turnLeft();
                infectedCount++;
            }
            moveForward();
        }
        return infectedCount;
    }

    public int partTwo(int burstCount) {
        final int CLEAN = 0;
        final int WEAKENED = 2;
        final int INFECTED = 1;
        final int FLAGGED = 3;

        int infectedCount = 0;

        for(int burst = 0; burst < burstCount; burst++) {

//            Clean nodes become weakened.
//            Weakened nodes become infected.
//            Infected nodes become flagged.
//            Flagged nodes become clean.

//            If it is clean, it turns left.
//            If it is weakened, it does not turn, and will continue moving in the same direction.
//            If it is infected, it turns right.
//            If it is flagged, it reverses direction, and will go back the way it came.
            if(grid[packetXPosition][packetYPosition] == CLEAN) {
                turnLeft();
                grid[packetXPosition][packetYPosition] = WEAKENED;
            } else if(grid[packetXPosition][packetYPosition] == WEAKENED) {
                grid[packetXPosition][packetYPosition] = INFECTED;
                infectedCount++;
            } else if(grid[packetXPosition][packetYPosition] == INFECTED) {
                turnRight();
                grid[packetXPosition][packetYPosition] = FLAGGED;
            } else if(grid[packetXPosition][packetYPosition] == FLAGGED) {
                grid[packetXPosition][packetYPosition] = CLEAN;
                turnRight();
                turnRight();
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
        }else if (LEFT) {
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
        dayTwentyTwo.setup(input, 10_000);
        System.out.println(dayTwentyTwo.partOne(10_000));
        dayTwentyTwo.setup(input, 10_000);
        System.out.println(dayTwentyTwo.partOne(10_000_000));
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
