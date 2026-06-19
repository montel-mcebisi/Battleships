import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BattleShips game = new BattleShips();
        game.placeShips();

        while (true) { 
            game.print();
            
            System.out.print("What row DO you want to fire on?: ");
            int row = input.nextInt();
            System.out.print("What column DO you want to fire on?: ");
            int col = input.nextInt();
            
            if(game.canFire(row,col)) {
                game.processFire(row,col);
            }
            if(game.gameOver()) {
                System.out.println("The game is over!");
                break;
            }
        }
    }
}
