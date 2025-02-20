package com.lab;

import java.util.Random;
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

        // คำพูดเปิดเกมแบบสุ่ม
        String[] funIntros = {
                "Welcome to the Ultimate Minesweeper Challenge!",
                "Warning: Highly Explosive Mines Ahead!",
                "Think fast or BOOM!",
                "Test your luck in the ultimate minefield!",
                "Can you outsmart the mines? Let's find out!"
        };

        Random random = new Random();
        System.out.println("===================================");
        System.out.println(funIntros[random.nextInt(funIntros.length)]);
        System.out.println("===================================");

        while (true) {
            // เมนูเลือกโหมด
            System.out.println("Choose Your Challenge:");
            System.out.println("1. Default Minefield (Classic Mode)");
            System.out.println("2. Load Minefield from File");
            System.out.println("3. Reverse 1 (Flipped Mode)");
            System.out.println("4. Reverse 2 (Flipped Mode)");
            System.out.println("5. Exit");
            System.out.println("6. SECRET MODE (Try if you dare!)");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                game = initMineField();
                System.out.println("You chose Default Minefield. Good luck!");
            } else if (choice == 2) {
                System.out.println("Loaded Minefield from file! Beware of hidden traps!");
                game = initMineFieldFromFile("minefield/minefield01.txt");
            } else if (choice == 3) {
                game = initMineField();
                mirrorField(game);
                System.out.println("Reverse Mode Activated! Everything is flipped!");
            } else if (choice == 4) {
                System.out.println("File-Based Minefield Reversed! Can you handle the challenge?");
                game = initMineFieldFromFile("minefield/minefield01.txt");
                mirrorField(game);
            } else if (choice == 5) {
                System.out.println("Thanks for playing! See you next time!");
                scanner.close();
                return;
            } else if (choice == 6) {
                secretMode();
                return;
            } else {
                System.out.println("Invalid choice! Self-destructing in 3...2...1...BOOM!");
                scanner.close();
                return;
            }

            if (game != null) {
                game.displayField();
            }
        }
    }

    // กลับขวา-ซ้าย
    static void mirrorField(Minesweeper game) {
        for (int i = 0; i < game.fieldX; i++) {
            for (int j = 0; j < game.fieldY / 2; j++) {
                int temp = game.cells[i][j];
                game.cells[i][j] = game.cells[i][game.fieldY - j - 1];
                game.cells[i][game.fieldY - j - 1] = temp;
            }
        }
    }

    // โหมดลับ! (Secret Mode)
    static void secretMode() {
        String[] secretMessages = {
                "Self-destructing in 3...2...1...BOOM!",
                "Self-destructing in 3...2...1...BOOM!",
                "Self-destructing in 3...2...1...BOOM!",
        };

        Random random = new Random();
        System.out.println("\n========== SECRET MODE ==========");
        System.out.println(secretMessages[random.nextInt(secretMessages.length)]);
        System.out.println("=================================\n");
    }
}
