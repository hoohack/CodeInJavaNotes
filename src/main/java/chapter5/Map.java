package chapter5;

public class Map {

    private int[][] map;

    private int size;

    public void initMap(int size) {
        this.size = size;
        map = new int[size][size];
    }

    public int[][] getMap() {
        return map;
    }

    public Coordinate getNextCoordinate(int row, int col, int i, int j) {
        if (row +i < 0 ||
                col + j < 0 ||
                row + i > this.size - 1 ||
                col + j > this.size - 1) {
            return null;
        }
        return new Coordinate(row + i, col + j);
    }

    public void setVal(Coordinate coordinate, int value) {
        map[coordinate.getRow()][coordinate.getCol()] = value;
    }

    public int getVal(Coordinate coordinate) {
        return map[coordinate.getRow()][coordinate.getCol()];
    }

    public int getSize() {
        return size;
    }

}
