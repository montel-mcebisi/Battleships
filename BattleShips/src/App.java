import java.util.Random;

class BattleShips {
    private char[][] grid = new char[10][10];

    public BattleShips() {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                grid[i][j] = ' ';
            }
        }
    }
    public void print() {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == ' ') {
                    System.out.print("[ ]");
                } else if(grid[i][j] == 'H') {
                    System.out.print("[H]");
                } else if(grid[i][j] == 'M') {
                    System.out.print("[M]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }
    public void placeShips() {
        Random rand = new Random();
        // boolean place = false;
        int count = 0;
        for(int i = 1; i < 6; i++) {
            boolean place = false;
            while(!place) {
            
                int size = i;
                int row = rand.nextInt(10);
                int bound = (grid[0].length - size) + 1;
                int col = rand.nextInt(bound);
                int end = col + size;
                boolean free = true;
                for(int j = col; j < end; j++) {
                    if(grid[row][j] != ' ') {
                        free = false;
                        break;
                    }
                }
                if(free) {
                    for(int k = col; k < end; k++) {
                        grid[row][k] = 'S';
                    }
                    place = true;
                }
                
            }
            
       }
    }
    public boolean canFire(int row, int col) {
        if(grid[row][col] == ' ' || grid[row][col] == 'S') {
            return true;
        }
        return false;
    }
    public void processFire(int row, int col) {
        if(grid[row][col] == 'S') {
            grid[row][col] = 'H';
        } else if(grid[row][col] != 'S') {
            grid[row][col] = 'M';
        }
    }
    public boolean gameOver() {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 'S') {
                    return false;
                }
            }
        }
        return true;
    }
}