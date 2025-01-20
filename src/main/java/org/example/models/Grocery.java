package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {

    public static List<String> groceryList = new ArrayList<>();

    public void startGrocery() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Lütfen 0, 1 veya 2 değer giriniz:");

        while (true) {
            System.out.println("0 - Uygulama sonlansın");
            System.out.println("1 - Malzeme ekleyin");
            System.out.println("2 - Malzeme kaldırın");
            System.out.print("Seçiminiz: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Temizlemek için

            switch (choice) {
                case 0:
                    System.out.println("Uygulama durduruldu.");
                    break;
                case 1:
                    System.out.println("Lütfen eklemek istediğiniz malzemeleri giriniz (virgülle ayırarak):");
                    String itemsToAdd = scanner.nextLine();
                    addItems(itemsToAdd);
                    break;
                case 2:
                    System.out.println("Lütfen kaldırmak istediğiniz malzemeleri giriniz (virgülle ayırarak):");
                    String removeToItems = scanner.nextLine();
                    removeItems(removeToItems);
                    break;
                default:
                    System.out.println("Geçersiz seçim! Lütfen 0, 1, 2 arasından seçim yapın.");
            }

            if (choice == 0) break;
            printSorted();
        }
        scanner.close();
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        if (groceryList.isEmpty()) {
            System.out.println("Liste boş.");
        } else {
            Collections.sort(groceryList);
            System.out.println("Grocery List:");
            for (String item : groceryList) {
                System.out.println(item);
            }
        }
    }

    public static void addItems(String input) {
        String[] items = input.split(",");
        boolean addedAnyItem = false;

        for (String item : items) {
            item = item.trim();
            if (!checkItemIsInList(item)) {
                groceryList.add(item);
                System.out.println("Listeye eklendi: " + item);
                addedAnyItem = true;
            } else {
                System.out.println("Zaten listede mevcut: " + item);
            }
            printSorted();
        }

        if (!addedAnyItem) {
            System.out.println("Hiçbir malzeme eklenmedi.");
        }
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        boolean removedAnyItem = false;

        for (String item : items) {
            item = item.trim();
            if (checkItemIsInList(item)) {
                groceryList.remove(item);
                System.out.println("Listeden silindi: " + item);
                removedAnyItem = true;
            } else {
                System.out.println("Ürün bulunamadı: " + item);
            }
            printSorted();
        }

        if (!removedAnyItem) {
            System.out.println("Hiçbir malzeme silinmedi.");
        }
    }
}
