package SUDOKU;

public class sudoku {
    private int[][] puzzle;
    private boolean[][] table;

    public sudoku(int[][] puzzle) {
        this.puzzle = puzzle;
        table = new boolean[9][9];
        makebooleantable();
    }

    public sudoku() {
        this.puzzle = new int[9][9];
    }

    public boolean solve(int x, int y) {
        if (y == 9) {
            return true;
        } else if(!table[y][x]) {
            if(y == 8 && x == 8) {
                return true;
            } else if(x == 8) {
                return solve(0, y + 1);
            }  else {
                return solve(x+1, y);
            }
        } else {
            for (int i = 1; i <= 9; i++) {
                puzzle[y][x] = i;
                if (works(x, y)) {
                    if (y == 8) {
                        if (x == 8) {
                            if (solve(0, 9)) {
                                return true;
                            }
                        } else {
                            if (solve(x + 1, y)) {
                                return true;
                            }
                        }
                    } else {
                        if (x == 8) {
                            if (solve(0, y + 1)) {
                                return true;
                            }
                        } else {
                            if (solve(x + 1, y)) {
                                return true;
                            }
                        }

                    }
                }
            }
            puzzle[y][x] = 0;
            return false;
        }
    }

    public boolean works(int x, int y) {
        if(!checkrow(y)) {
            return false;
        }
        int blockx;
        int blocky;
        if(x >= 0 && x <= 2) {
            blockx = 0;
        } else if(x >= 3 && x <= 5) {
            blockx = 3;
        } else {
            blockx = 6;
        }
        if(y >= 0 && y <= 2) {
            blocky = 0;
        } else if(y >= 3 && y <= 5) {
            blocky = 3;
        } else {
            blocky = 6;
        }
        int [] block = checkblock(blocky, blockx);
        if(noduplicates(block)) {
            return checkcolumn(x);
        } else {
            return false;
        }


    }

    public int[] checkblock(int y, int x) {
        int [] arr = new int[9];
        int curr = 0;
        int limx = x + 3;
        int limy = y + 3;
        for(int i = y; i < limy; i++){
            for(int j = x; j < limx; j++) {
                arr[curr] = puzzle[i][j];
                curr++;
            }
        }
        return arr;
    }

    public boolean checkcolumn(int x) {
        int[] arr = new int[9];
        for(int i = 0; i < 9; i++){
            arr[i] = puzzle[i][x];
        }
        return noduplicates(arr);
    }

    public boolean checkrow(int y) {
        int [] row  = puzzle[y];
        return noduplicates(row);
    }

    public boolean noduplicates(int [] arr) {
        for(int i = 0; i < 9; i++) {
            int curr = arr[i];
            for(int j = i + 1; j < 9; j++) {
                if(curr != 0 && curr == arr[j]) {
                    return false;
                }
            }
        }
        return true;
    }
    public void print() {
        for(int i  = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(puzzle[i][j]);
            }
            System.out.print("\n");
        }
    }

    private void makebooleantable() {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                table[i][j] = puzzle[i][j] == 0;
            }
        }
    }

    public boolean[][] returntable() {
        return table;
    }
}
