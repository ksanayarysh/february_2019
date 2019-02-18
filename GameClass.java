package lesson_4;

import java.util.Arrays;
import java.util.Scanner;

public class GameClass {
    private int SIZE = 3;
    private int DOTS_TO_WIN = 3;
    private final char DOT_EMPTY = '•';
    private final char DOT_X = 'X';
    private final char DOT_O = 'O';
    private char[][] map;
    private int[][] weights;
    private Scanner sc = new Scanner(System.in);

    public char getHumanDot() {
        return DOT_X;
    }

    public char getAiDot() {
        return DOT_O;
    }

    GameClass(int size, int dotToWin) {
        SIZE = size;
        DOTS_TO_WIN = dotToWin;
        map = new char[SIZE][SIZE];
        weights = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
                weights[i][j] = 0;
            }

        }
    }

    public void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private boolean isCellValid(int x, int y) {
        if ((x < 0 || x >= SIZE || y < 0 || y >= SIZE) || (!(map[x][y] == DOT_EMPTY))) return false;
        return true;
    }


    public boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    /*
     * комптютер в свой ход сначала проверяет, может ли он выиграть в один ход
     * если да, то он ставить O туда
     * если нет, он проверяет, может ли выиграть человек
     * если да, он блокирует этот вариант
     * если нет, он взвешивает клетки на основании того, что рядом, и выбирает клетку с максимальным весом
     * */

    public void aiTurn() {
        //      int x, y;
        int[] cell;
        cell = canWin(DOT_O); // компьютер проверяет, может ли он выиграть, если да, ставит туда
        if (cell[0] != -1) map[cell[0]][cell[1]] = DOT_O;
        else {  // проверяем, можно ли заблокировать ход
            cell = canWin(DOT_X);
            if (cell[0] != -1) map[cell[0]][cell[1]] = DOT_O;
            else {

                // иначе ориентируемся на веса
                do {
                    cell = setWeights();
                } while (!isCellValid(cell[0], cell[1]));
                map[cell[0]][cell[1]] = DOT_O;
            }
        }
//            cell = setWeights();
//            x = rand.nextInt(SIZE);
//            y = rand.nextInt(SIZE);
        System.out.println("My choice is  " + (cell[0] + 1) + " " + (cell[1] + 1));
//        map[x][y] = DOT_O;
    }


    public void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[x][y] = DOT_X;
    }

    /* Проверяем победу
    ищем все квадраты DOTS_TO_WIN на DOTS_TO_WIN
    проверяем там диагонали вертикали и горизонтали
    * */


    public boolean checkWin(char simb) {
        for (int offset_x = 0; offset_x <= SIZE - DOTS_TO_WIN; offset_x++) {
            for (int offset_y = 0; offset_y <= SIZE - DOTS_TO_WIN; offset_y++) {

                boolean diag1 = true;
                boolean diag2 = true;

//                for (int i = offset_x; i < offset_x + DOTS_TO_WIN; i++) {
//                    diag1 &= (simb == map[i][i]); // может так
//                    diag2 &= (simb == map[i][SIZE - i - 1]);
//                }
                for (int i = 0; i < DOTS_TO_WIN; i++) {
                    diag1 &= (simb == map[i + offset_x][i + offset_y]); // может так
                    diag2 &= (simb == map[i + offset_x][offset_y + DOTS_TO_WIN - i - 1]);
                }

                if (diag1 || diag2) return true;

                boolean rows, cols;
                for (int i = offset_x; i < offset_x + DOTS_TO_WIN; i++) {
                    rows = true;
                    cols = true;
                    for (int j = offset_y; j < offset_y + DOTS_TO_WIN; j++) {
                        rows &= (map[j][i] == simb);
                        cols &= (map[i][j] == simb);
                    }
                    if (rows || cols) return true;
                }

            }
        }
        return false;

    }

    /* Составление матрицы весов
     * Если map[i][j], то вес = -1
     * дальше для каждой клетки проверяем DOTS_TO_WIN клетов вверх, вниз, по бокам и по диагонали
     * если там есть рядом занятые клетки, то увеличиваем вес
     * игнорируем клетки, если понятно, что нет места, чтобы заполнить 4 клетки
     * потом ходим в клетку с максимальным весом */

    public int[] setWeights() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int w = 0;
                weights[i][j] = 0;
                if (map[i][j] != DOT_EMPTY) weights[i][j] = -1;
                else {
                    int k = 1;
                    while (k < DOTS_TO_WIN) {
                        if (i + k < SIZE) {
                            if (map[i + k][j] == DOT_X) {
                                w = (i - k + DOTS_TO_WIN <= SIZE) ? w + 5 : w + 1;
                            } else if (map[i + k][j] == DOT_O) w = -1;
                        }

                        if (i - k >= 0) {
                            if (map[i - k][j] == DOT_X) w += 1;
                            else if (map[i - k][j] == DOT_O) w = -1;
                        }

                        if (j + k < SIZE) {
                            if (map[i][j + k] == DOT_X) {
                                w = (j - k + DOTS_TO_WIN <= SIZE) ? w + 1 : w + 5;
                            } // по строке вправо

                            else if (map[i][j + k] == DOT_O) w = -1;
                        }

                        if (j - k >= 0) {
                            if (map[i][j - k] == DOT_X)
                                w = (j - k - DOTS_TO_WIN >= 0) ? w + 1 : w + 5;
                            else if (map[i][j - k] == DOT_O) w = -1;
                        } // по строке влево


                        // Проверяем диагонали

                        if (i + k < SIZE && j + k < SIZE) {
                            if (map[i + k][j + k] == DOT_X)
                                w = (j - k + DOTS_TO_WIN <= SIZE && i - k + DOTS_TO_WIN <= SIZE) ? w + 1 : w + 5;
                            else if (map[i + k][j + k] == DOT_O) w = -1;
                        }

                        if (i + k < SIZE && j - k >= 0) {
                            if (map[i + k][j - k] == DOT_X)
                                w = (j - k - DOTS_TO_WIN >= 0 && i - k + DOTS_TO_WIN <= SIZE) ? w + 1 : w + 5;
                            else if (map[i + k][j - k] == DOT_O) w = -1;
                        }

                        if (i - k >= 0 && j + k < SIZE) {
                            if (map[i - k][j + k] == DOT_X)
                                w = (j - k + DOTS_TO_WIN <= SIZE && i - k - DOTS_TO_WIN >= 0) ? w + 1 : w + 5;
                            else if (map[i - k][j + k] == DOT_O) w = -1;
                        }

                        if (i - k >= 0 && j - k >= 0) {
                            if (map[i - k][j - k] == DOT_X)
                                w = (j - k - DOTS_TO_WIN >= 0 && i - k - DOTS_TO_WIN >= 0) ? w + 1 : w + 5;
                            else if (map[i - k][j - k] == DOT_O) w = -1;
                        }
                        k++;
                    }
                    weights[i][j] = w;
                }
            }

        }

        // Ищем координаты элемента с наибольшим весом и возвращаем их

        int maxI = 0, maxJ = 0, maxValue = weights[0][0];
        System.out.println("weights");
        for (int i = 0; i < SIZE; i++) {
            System.out.println();
            for (int j = 0; j < SIZE; j++) {
                if (weights[i][j] > maxValue) {
                    maxI = i;
                    maxJ = j;
                    maxValue = weights[i][j];
                }
                System.out.print(" " + weights[i][j]);
            }

        }
        System.out.println(" max weight i " + maxI + " j " + maxJ);
        System.out.println();
        int[] setWeights = {maxI, maxJ};
        return setWeights;
    }


    // функция для проверки возможности выигрыша
    // компьютер сначала проверяет возможность своего выигрыша, если да, то ставит O в эту точку
    // Если нет, то проверяет возможность выигрыша человева
    // если да, то блокирует

    private int[] canWin(char symbol) {
        int[] canWin = {-1, -1};
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    map[i][j] = symbol;
                    if (checkWin(symbol)) {
                        canWin[0] = i;
                        canWin[1] = j;
                        map[i][j] = DOT_EMPTY;
                        return canWin;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }
        return canWin;
    }


}
