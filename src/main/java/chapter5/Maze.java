package chapter5;

import java.util.ArrayList;
import java.util.List;

public class Maze {

    private int[][] map = {
            {2,2,2,2,2,2,2},
            {0,0,0,0,0,0,2},
            {2,0,2,0,2,0,2},
            {2,0,0,2,0,2,2},
            {2,2,0,2,0,2,2},
            {2,0,0,0,0,0,2},
            {2,2,2,2,2,0,2}
    };

    private static int[][] DIRECTIONS = {{ 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0}};

    private static int ROAD = 0;

    private static int VISITED = 1;

    private static int WALL = 2;

    private static int EXIT = 3;

    private int exitRow;

    private int exitCol;

    private int entryRow;

    private int entryCol;

    public int[][] getMap() {
        return map;
    }

    public void setEntry(int row, int col) {
        setEntryRow(row);
        setEntryCol(col);
    }

    public void setExit(int row, int col) {
        setExitRow(row);
        setExitCol(col);

        map[row][col] = EXIT;
    }

    private void setEntryRow(int row) {
        entryRow = row;
    }

    private void setEntryCol(int col) {
        entryCol = col;
    }

    public int getEntryRow() {
        return entryRow;
    }

    public int getEntryCol() {
        return entryCol;
    }

    private boolean isValidLocation(int row, int col) {
        return map[row][col] == ROAD || map[row][col] == EXIT;
    }

    private boolean isWall(int row, int col) {
        return map[row][col] == WALL;
    }

    private boolean isExplored(int row, int col) {
        return map[row][col] == VISITED;
    }

    private void setVisited(int row, int col) {
        if (map[row][col] == 0) {
            map[row][col] = VISITED;
        }
    }

    private void setNotPath(int row, int col) {
        if (map[row][col] == VISITED) {
            map[row][col] = 4;
        }
    }

    public boolean isExit(int row, int col) {
        return map[row][col] == EXIT;
    }

    private Coordinate getNextCoordinate(int row, int col, int i, int j) {
        return new Coordinate(row + i, col + j);
    }

    private boolean explore(int row, int col, List<Coordinate> path) {
        if (!isValidLocation(row, col)
                || isWall(row, col)
                || isExplored(row, col)) {
            return false;
        }

        path.add(new Coordinate(row, col));
        setVisited(row, col);

        if (isExit(row, col)) {
            return true;
        }

        for (int[] direction : DIRECTIONS) {
            Coordinate coordinate = getNextCoordinate(
                    row, col, direction[0], direction[1]);
            if (explore(coordinate.getRow(),coordinate.getCol(),path)) {
                return true;
            }
        }

        setNotPath(row, col);
        path.remove(path.size() - 1);

        return false;
    }

    public int getExitCol() {
        return exitCol;
    }

    public void setExitCol(int exitCol) {
        this.exitCol = exitCol;
    }

    public int getExitRow() {
        return exitRow;
    }

    public void setExitRow(int exitRow) {
        this.exitRow = exitRow;
    }

    public static void main(String[] args) {
        Maze maze = new Maze();

        List<Coordinate> path = new ArrayList<>();

        maze.setEntry(1, 0);

        maze.setExit(6, 5);

        maze.explore(maze.getEntryRow(), maze.getEntryCol(), path);

        int[][] map = maze.getMap();

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                if (map[row][col] == 2) {
                    System.out.print("# ");
                } else if (map[row][col] == 0 || map[row][col] == 4) {
                    System.out.print("  ");
                } else if (map[row][col] == 1 || map[row][col] == 3) {
                    System.out.print("* ");
                }
            }

            System.out.println();
        }

    }
}
