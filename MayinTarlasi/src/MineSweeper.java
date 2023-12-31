/** @author Erhan YILDIRIM (Patika.dev) - 31.12.2023 */

import java.util.Random; //Rastgele sayı üretmek için kullanacağız.
import java.util.Scanner; //Kullanıcıdan bilgi çekmek için kullanacağız.

public class MineSweeper {

    private char[][] field; // Oyun alanını temsil eden matris.
    private boolean[][] mines; // Mayınların konumunu belirten matris, varsa "true" yoksa "false" olarak belirtilecek.
    private int rows, cols, openedCells;
    private boolean gameOver;

    public static void main(String[] args) {

    }

    public MineSweeper(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.field = new char[rows][cols];
        this.mines = new boolean[rows][cols];
        this.gameOver = false;
        this.openedCells = 0;
        initializeField();
        placeMines();
    }

    private void initializeField() { //Oyun tahtası alanını, verilen değerlere göre "-" ile doldurur.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                field[i][j] = '-';
            }
        }
    }

    private void placeMines() { //Mayınları oyun tahtasına dağıtıyoruz. While döngüsü ile toplam mayın sayısı kadar reastgele mayın ataması yapılacak.
        Random random = new Random();
        int totalMines = rows * cols / 4; // Mayın sayısı, eleman sayısının 1/4'ü olarak belirtilmişti.
        int count = 0;
        while (count < totalMines) {
            int x = random.nextInt(rows);
            int y = random.nextInt(cols);
            if (!mines[x][y]) {
                mines[x][y] = true;
                count++;
            }
        }
    }

    private void printField() { //Oyun tahtasını görsel olarak oluşturuyoruz.
        System.out.println("====================="); //Görsel olarak oyun tahtası ile üst satırların arasına belirgin olması için çizgi çekiyoruz.
        for (int i = 0; i < rows; i++) { //Her bir satı başına | çizgisini ekler.
            System.out.print("|");
            for (int j = 0; j < cols; j++) { //Her bir sütundaki hücreye | işaretini koyar.
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
    }

    // Aşağıdaki "isValidMove" metodu, girilen koordinat sayısının geçerli olup olmadığını kontrol eder.
    private boolean isValidMove(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols && field[x][y] == '-';
    }


    private int countMines(int x, int y) { //Koordinatı verilen hücrenin üst, alt, sağ ve sol kısımlarında mayın olup olmadığını bulan metod. Metodun güvenliği için private kullanılmıştır.
        int count = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && i < rows && j >= 0 && j < cols && mines[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    private void openField(int x, int y) { //Kullanıcının belirttiği koordinatta mayın olup olmadığını kontrol eden metod.
        if (mines[x][y]) {
            System.out.println("Eyvah! Mayına bastın, oyun bitti! :(");
            gameOver = true;
            return;
        }
        int adjacentMines = countMines(x, y); //Seçilen hücrenin etrafındaki mayınları ilgili hücreye Char değerinde gösterme.
        field[x][y] = (char) (adjacentMines + '0');
        openedCells++;

        if (openedCells == (rows * cols - (rows * cols / 4))) { //Oyundaki mayın harici hücre sayısına açık hücre sayısı eşit olduğunda oyun kazanılır.
            System.out.println("*** Tebrikler! Mayın Tarlası oyununu başarıyla tamamladınız. ***");
            gameOver = true;
            return;
        }

    }
    //Aşağıda oyunun genel döngüsünü sağlayacak kısımlar girilmiştir. Mayın denk gelmediği ve geçersiz hamle girilmediği sürece oyun tahtasını ekrana getir.
    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            printField();
            System.out.print("Satır numarası giriniz: ");
            int row = scanner.nextInt();
            System.out.print("Sütun numarası giriniz: ");
            int col = scanner.nextInt();

            if (!isValidMove(row, col)) {
                System.out.println("Geçersiz hamle! Lütfen farklı bir hücre seçiniz.");
                continue;
            }

            openField(row, col);
        }

    }

}
