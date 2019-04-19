package chapter5;

import java.util.ArrayList;
import java.util.List;

/**
 * 西洋骑士
 */
public class Knight {

    private static int[][] DIRECTIONS = {{-2, 1}, {-1, 2}, {1, 2},{2, 1},{2, -1},{1, -2},{-1, -2},{-2, -1}};

    private Map map;

    private int[] directionCounts;

    public void setMap(int size) {
        map = new Map();
        map.initMap(size);
        directionCounts = new int[size];
    }

    public int[][] getMap() {
        return map.getMap();
    }

    public boolean travel(int row, int col) {
        //对应骑士可走的八个方向

        List<Coordinate> nextCoordinate = new ArrayList<>();
        int pos, tmp, directionCount;

        Coordinate entry = new Coordinate(row, col);
        map.setVal(entry, 1);

        for(int step = 2; step <=64; step++) {
            nextCoordinate.clear();
            directionCount = 0;
            for (int i = 0; i < 8; i++) {
                directionCounts[i] = 0;
            }

            for (int[] direction : DIRECTIONS) {
                Coordinate coordinate = map.getNextCoordinate(
                        row, col, direction[0], direction[1]);
                if (coordinate == null) {
                    continue;
                }

                if (map.getVal(coordinate) == 0) {
                    nextCoordinate.add(coordinate);
                    directionCount++;
                }
            }

            if (directionCount == 0) {
                return false;
            } else if (directionCount == 1) {
                pos = 0;
            } else {
                //找出下一个位置的出路
                for (int j=0; j < directionCount; j++) {
                    //试探八个方向
                    for (int[] direction : DIRECTIONS) {
                        Coordinate coordinate = map.getNextCoordinate(
                                nextCoordinate.get(j).getRow(), nextCoordinate.get(j).getCol(), direction[0], direction[1]);

                        if (coordinate == null) {
                            continue;
                        }

                        if (map.getVal(coordinate) == 0) {
                            directionCounts[j]++;
                        }
                    }
                }

                tmp = directionCounts[0];
                pos = 0;
                for (int k = 1;k<directionCount;k++) {
                    if (directionCounts[k]<tmp) {
                        tmp = directionCounts[k];
                        pos = k;
                    }
                }
            }

            row = nextCoordinate.get(pos).getRow();
            col = nextCoordinate.get(pos).getCol();
            map.setVal(nextCoordinate.get(pos), step);
        }

        return true;
    }

    public static void main(String[] args) {
        int startX = 3;
        int startY = 4;

        Knight knight = new Knight();

        knight.setMap(8);

        if(knight.travel(startX,startY)) {
            System.out.println("Finished");
        } else {
            System.out.println("Failed");
        }

        int[][] result = knight.getMap();

        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

}
