package chapter5;

public class EightQueen {

    private int[] queenRow;

    private static int INITIAL = -9999;

    private void setMap(int size) {
        queenRow = new int[size];
        for (int i = 0; i < size; i++) {
            queenRow[i] = INITIAL;
        }
    }

    public boolean valid(int row, int col) {
        for (int i = 0; i < queenRow.length; ++i) {
            if (queenRow[i] == col || Math.abs(i - row) == Math.abs(queenRow[i] - col))
                return false;
        }

        return true;
    }

    public void print() {
        int i, j;
        for (i = 0; i < queenRow.length; ++i) {
            for (j = 0; j < queenRow.length; ++j) {
                if (queenRow[i] != j)
                    System.out.print(". ");
                else
                    System.out.print("# ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("--------------------------------");
    }

    public void find() {
        int n = 0;
        int i = 0, j = 0;
        while (i < queenRow.length) {
            while (j < queenRow.length) {
                if(valid(i, j)) {
                    queenRow[i] = j;
                    j = 0;
                    break;
                } else {
                    ++j;
                }
            }
            if(queenRow[i] == INITIAL) {
                if (i == 0) {
                    break;
                } else {
                    --i;
                    j = queenRow[i] + 1;
                    queenRow[i] = INITIAL;
                    continue;
                }
            }
            if (i == queenRow.length - 1) {
                System.out.printf("answer %d : \n", ++n);
                print();
                j = queenRow[i] + 1;
                queenRow[i] = INITIAL;
                continue;
            }
            ++i;
        }
    }

    public static void main(String[] args) {

        EightQueen eightQueen = new EightQueen();
        eightQueen.setMap(8);

        eightQueen.find();

    }

}
