package org.example;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KasaFiskalna {

    private List<Double> sprzedaneProdukty;
    private double saldo;
    private double podatekProcent = 23.0;
    private String[] produkty = {"Chleb", "Mleko", "Jajka", "Cukier", "Kawa", "Herbata", "Masło", "Pomidory", "Ser", "Papryka"};

    public KasaFiskalna() {
        sprzedaneProdukty = new ArrayList<>();
        saldo = 0.0;
    }

    public void sprzedazProduktu(String nazwaProduktu, double cena) {
        sprzedaneProdukty.add(cena);
        saldo += cena;
        System.out.println("Sprzedano " + nazwaProduktu + " za " + cena + " zł. Saldo: " + saldo + " zł");
    }

    public void drukujParagon() {
        System.out.println("Paragon fiskalny");
        System.out.println("Zakupione produkty:");

        for (int i = 0; i < sprzedaneProdukty.size(); i++) {
            System.out.println("- " + produkty[i] + " za " + sprzedaneProdukty.get(i) + " zł");
        }

        double sumaProduktow = sprzedaneProdukty.stream().mapToDouble(Double::doubleValue).sum();
        double podatek = (podatekProcent / 100.0) * sumaProduktow;

        DecimalFormat df = new DecimalFormat("#.##"); // Formatowanie do dwóch miejsc po przecinku
        System.out.println("Suma produktów: " + df.format(sumaProduktow) + " zł");
        System.out.println("Podatek (" + podatekProcent + "%): " + df.format(podatek) + " zł");
        System.out.println("Kwota do zapłaty (z podatkiem): " + df.format(saldo + podatek) + " zł");
        System.out.println("Dziękujemy za zakupy!");
        System.out.println("Zapraszamy ponownie!");
        sprzedaneProdukty.clear();
        saldo = 0.0;
    }



    public static void main(String[] args) {
        KasaFiskalna kasa = new KasaFiskalna();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Wybierz produkt:");
            for (int i = 0; i < kasa.produkty.length; i++) {
                System.out.println((i + 1) + ". " + kasa.produkty[i]);
            }
            System.out.println(kasa.produkty.length + 1 + ". Zakończ zakupy");

            int wyborProduktu = scanner.nextInt();

            if (wyborProduktu >= 1 && wyborProduktu <= kasa.produkty.length) {
                String nazwaProduktu = kasa.produkty[wyborProduktu - 1];
                double cenaProduktu = kasa.losujCene(); // Użyj metody z obiektu klasy KasaFiskalna
                kasa.sprzedazProduktu(nazwaProduktu, cenaProduktu);
            } else if (wyborProduktu == kasa.produkty.length + 1) {
                kasa.drukujParagon();
                System.exit(0);
            } else {
                System.out.println("Niepoprawny wybór. Spróbuj ponownie.");
            }
        }
    }

    // Funkcja do losowania ceny produktu
    private double losujCene() {
        return Math.round(Math.random() * 10.0 + 1.0); // Losowa cena od 1 do 11 zł
    }
}

