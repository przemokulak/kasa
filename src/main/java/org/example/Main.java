package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        KasaFiskalna kasa = new KasaFiskalna();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Sprzedaj produkt");
            System.out.println("2. Drukuj paragon");
            System.out.println("3. Wyjście");

            int wybor = scanner.nextInt();

            switch (wybor) {
                case 1:
                    System.out.println("Podaj cenę produktu: ");
                    double cena = scanner.nextDouble();
                    kasa.sprzedazProduktu("NazwaProduktu", cena); // Zakładam, że musisz podać nazwę produktu
                    break;
                case 2:
                    kasa.drukujParagon();
                    break;
                case 3:
                    System.out.println("Do widzenia!");
                    System.exit(0);
                default:
                    System.out.println("Niepoprawny wybór. Spróbuj ponownie.");
            }
        }
    }
}
