/** @author Erhan YILDIRIM (Patika.dev) - 31.12.2023 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); //Oyunun başlangıç ekranında kullanıcından oyun tahtası alanı bilgisi istenir.

        System.out.println("Patika.dev 'MAYIN TARLASI' oyununa hoşgeldiniz!");
        System.out.print("Oyun tahtasındaki satır sayısını giriniz: ");
        int rows = scanner.nextInt();
        System.out.print("Oyun tahtasındaki sütun sayısını giriniz: ");
        int cols = scanner.nextInt();

        MineSweeper game = new MineSweeper(rows, cols); //Kullanıcının girdiği satır ve sütun bilgisine göre yeni oyun açar.
        game.playGame();
    }
}