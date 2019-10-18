import java.util.Arrays;
import java.util.Scanner;

public class DayThree {

    private static long[][] spiral;

    public static int partOne(int size, int endPosition) {
        setupPartOne(size);
        return getDistanceFromStartPosition(endPosition);
    }

    private static int getDistanceFromStartPosition(int endPosition) {
        int[] end_X_Y = getX_Y_coordinates(endPosition);
        int[] start_X_Y = getX_Y_coordinates(1);
        return Math.abs(start_X_Y[0] - end_X_Y[0]) + Math.abs(start_X_Y[1] - end_X_Y[1]);
    }

    private static void setupPartOne(int size) {
        spiral = new long[size + 1][size + 1];
        int xCor = (int) Math.floor(size / 2);
        int yCor = (int) Math.floor(size / 2);

        if(xCor % 2 == 1)
            xCor++;
        if (yCor % 2 == 1)
            yCor++;
        boolean NORTH = false;
        boolean EAST  = true;
        boolean WEST  = false;
        int value = 1;

        for(int i = 0; i < (size * size); i++) {
            if(i == 0) {
                spiral[xCor][yCor] = value++;
                yCor++;
            } else {
                if(EAST) {
                    spiral[xCor][yCor] = value++;
                    if(spiral[xCor - 1][yCor] == 0) {
                        EAST = false; NORTH = true;
                        xCor--;
                    } else {
                        yCor++;
                    }
                } else if(NORTH) {
                    spiral[xCor][yCor] = value++;
                    if(spiral[xCor][yCor - 1] == 0) {
                        WEST = true; NORTH = false;
                        yCor--;
                    } else {
                        xCor--;
                    }
                } else if(WEST) {
                    spiral[xCor][yCor] = value++;
                    if(spiral[xCor + 1][yCor] == 0) {
                        xCor++;
                        WEST = false;
                    } else {
                        yCor--;
                    }
                } else {
                    spiral[xCor][yCor] = value++;
                    if(spiral[xCor][yCor + 1] == 0) {
                        yCor++;
                        EAST = true;
                    } else {
                        xCor++;
                    }
                }
            }
        }
    }

    public static long setupPartTwo(int size, int endPosition) {
        spiral = new long[size + 1][size + 1];
        int xCor = (int) Math.floor(size / 2);
        int yCor = (int) Math.floor(size / 2);

        if(xCor % 2 == 1)
            xCor++;
        if (yCor % 2 == 1)
            yCor++;
        boolean NORTH = false;
        boolean EAST  = true;
        boolean WEST  = false;

        boolean FOUND = false;
        int i = 0;
        while(!FOUND) {
            if(!FOUND) {
                if (i == 0) {
                    spiral[xCor][yCor] = 1;
                    yCor++;
                } else {
                    if (EAST) {
                        long temp = getSurroundingValue(xCor, yCor);
                        spiral[xCor][yCor] = temp;
                        if (spiral[xCor - 1][yCor] == 0) {
                            EAST = false;
                            NORTH = true;
                            xCor--;
                        } else {
                            yCor++;
                        }
                        if (temp > endPosition) {
                            return temp;
                        }
                    } else if (NORTH) {
                        long temp = getSurroundingValue(xCor, yCor);
                        spiral[xCor][yCor] = temp;

                        if (spiral[xCor][yCor - 1] == 0) {
                            WEST = true;
                            NORTH = false;
                            yCor--;
                        } else {
                            xCor--;
                        }
                        if (temp > endPosition) {
                            return temp;
                        }
                    } else if (WEST) {
                        long temp = getSurroundingValue(xCor, yCor);
                        spiral[xCor][yCor] = temp;
                        if (spiral[xCor + 1][yCor] == 0) {
                            xCor++;
                            WEST = false;
                        } else {
                            yCor--;
                        }
                        if (temp > endPosition) {
                            return temp;
                        }
                    } else {
                        long temp = getSurroundingValue(xCor, yCor);
                        spiral[xCor][yCor] = temp;
                        if (spiral[xCor][yCor + 1] == 0) {
                            yCor++;
                            EAST = true;
                        } else {
                            xCor++;
                        }
                        if (temp > endPosition) {
                            return temp;
                        }
                    }
                }
                i++;
            } else {
                break;
            }
        }
        return getSurroundingValue(xCor, yCor);
    }

    private static long getSurroundingValue(int xCor, int yCor) throws ArrayIndexOutOfBoundsException {
        long northValue = 0;
        try {
            northValue = spiral[xCor - 1] [yCor];
        } catch (ArrayIndexOutOfBoundsException ignored) { }

        long eastValue = 0;
        try {
            eastValue = spiral[xCor][yCor + 1];
        } catch (ArrayIndexOutOfBoundsException ignored) { }

        long southValue = 0;
        try {
            southValue = spiral[xCor + 1][yCor];
        }  catch (ArrayIndexOutOfBoundsException ignored) { }

        long westValue = 0;
        try {
            westValue = spiral[xCor][yCor - 1];
        } catch (ArrayIndexOutOfBoundsException ignored) { }

        long northWestValue = 0;
        try {
            northWestValue = spiral[xCor - 1][yCor - 1];
        } catch (ArrayIndexOutOfBoundsException ignored) { }

        long northEastValue = 0;
        try {
            northEastValue = spiral[xCor - 1][ yCor + 1];
        } catch (ArrayIndexOutOfBoundsException ignored) { }

        long southWestValue = 0;
        southWestValue = spiral[xCor + 1][yCor - 1];

        long southEastValue = 0;
        try {
            southEastValue = spiral[xCor + 1][yCor + 1];
        } catch (ArrayIndexOutOfBoundsException ignored) { }

        return  northValue +
                eastValue  +
                southValue +
                westValue  +
                northWestValue +
                northEastValue +
                southWestValue +
                southEastValue;
    }

    private static void print() {
        for (long[] arr : spiral) {
            StringBuilder segment = new StringBuilder();
            for (long i : arr) {
                if (i < 10) {
                    segment.append("   ").append(i);
                } else if (i < 100) {
                    segment.append("  ").append(i);
                } else if (i < 1000) {
                    segment.append(" ").append(i);
                }
            }
            System.out.println(segment);
        }
    }

    private static int[] getX_Y_coordinates(int position) {
        int[] x_y = new int[2];
        for (int x = 0; x < spiral.length; ++x) {
            for (int y = 0; y < spiral.length; ++y) {
                if (spiral[x][y] == position ) {
                    x_y[0] = x;
                    x_y[1] = y;
                    return x_y;
                }
            }
        }
        return x_y;
    }

    public static void main(String[] args) {
        System.out.printf("Part one: %d%n", DayThree.partOne(312051 / 100, 312051));
        System.out.printf("Part two: %d%n", DayThree.setupPartTwo(312051 / 100, 312051));
    }
}
