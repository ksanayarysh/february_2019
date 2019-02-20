package lesson_4;

public class MainClass {
    public static void main(String[] args) {
        GameClass g = new GameClass(5, 4);
        g.printMap();
        while (true) {

            g.humanTurn();
            g.printMap();
            if (!g.checkWin(g.getHumanDot())) {
                System.out.println("checking...no");
            } else {
                System.out.println("You win!");
                break;
            }
            if (g.isMapFull()){
                System.out.println("dead heat");
                break;
            }
//            g.blabla();

            g.aiTurn();
            g.printMap();
            if (!g.checkWin(g.getAiDot())) {
                System.out.println("checking...no");
            } else {
                System.out.println("I win!");
                break;
            }
            if (g.isMapFull()){
                System.out.println("Dead heat");
                break;
            }

        }
    }
}
