package com.lab;
 
import java.util.Scanner;
 
public class App {
    static Minesweeper initMineField() {
        Minesweeper game = new Minesweeper(9, 9);
        game.setMineCell(0, 1);
        game.setMineCell(1, 5);
        game.setMineCell(1, 8);
        game.setMineCell(2, 4);
        game.setMineCell(3, 6);
        game.setMineCell(4, 2);
        game.setMineCell(5, 4);
        game.setMineCell(6, 2);
        game.setMineCell(7, 2);
        game.setMineCell(8, 6);
        return game;
    }
 
    static Minesweeper initMineFieldFromFile(String minefieldFile) {
        return new Minesweeper(minefieldFile);
    }
 
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
        Minesweeper game = null;
 
        System.out.println("=== Minesweeper Game ===");
        System.out.println("1. Use default minefield");
        System.out.println("2. Load minefield from file");
        System.out.print("Enter your choice: ");
 
        int choice = scanner.nextInt();
        scanner.nextLine(); 
 
        if (choice == 1) {
            game = initMineField();
        } else if (choice == 2) {
           
            game = initMineFieldFromFile("minefield/minefield01.txt");
        } else {
            System.out.println("Invalid choice. Exiting...");
            scanner.close();
            return;
        }
 
        game.displayField();
        scanner.close();
    }
}