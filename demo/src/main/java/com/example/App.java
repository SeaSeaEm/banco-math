package com.example;

import java.util.Scanner;

public class App {
    protected static int ACC_COUNT = 10;
    protected static Account[] accs = new Account[ACC_COUNT];

    public static void main(String[] args) {
        App app = new App();

        // lets fill them up
        for (int i = 0; i < accs.length; i++) {
            int rndAccNumber = (int) Math.floor(Math.random() * 99) + 100;
            double rndAccBalance = Math.floor(Math.random() * 99) + 1000;

            accs[i] = new Account(rndAccNumber, rndAccBalance);
        }

        int menuOption = 0;
        while (menuOption != 5) {
            menuOption = app.displayMenu();
            app.handleMenuOption(menuOption);
        }

        return;
    }

    protected void handleMenuOption(int menuOption) {
        switch (menuOption) {
            case 1: // Saque
                withdraw();
                break;
            case 2: // Depositar
                deposit();
                break;
            case 3: // Consultar Saldo
                Scanner scanner = new Scanner(System.in);
                Account acc = getAccount(getAccountInput(scanner));

                if (acc == null) {
                    System.out.println("Conta nao existe");
                    return;
                }

                System.out.println(
                        String.format("\nNumero da Conta: %d - Saldo: %.2f", acc.getAccountNumber(), acc.getBalance()));
                break;
            case 4: // Listar Contas
                for (int i = 0, j = 1; i < accs.length; i++, j++) {
                    System.out.println(String.format("%d - Numero da Conta: %d", j, accs[i].getAccountNumber()));
                }
                break;
            case 5: // Sair
                break;
            default:
                break;
        }
    }

    protected void deposit() {
        Scanner scanner = new Scanner(System.in);
        Account acc = getAccount(getAccountInput(scanner));

        if (acc == null) {
            System.out.println("Conta nao existe");
            return;
        }

        double depositValue = 0;
        boolean validOperation = false;

        while (!validOperation && acc != null) {
            System.out.println(String.format("Digite o valor a ser depositado"));
            
            depositValue = Double.parseDouble(scanner.nextLine());

            if (depositValue <= 0)
                System.out.println("Valor invalido");
            else
                validOperation = true;
        }

        acc.deposit(depositValue);
        System.out.println(String.format("Saldo atual: %.2f", acc.getBalance()));
    }

    protected void withdraw() {
        Scanner scanner = new Scanner(System.in);
        Account acc = getAccount(getAccountInput(scanner));

        if (acc == null) {
            System.out.println("Conta nao existe");
            return;
        }

        double withdrawValue = 0;
        boolean validOperation = false;

        while (!validOperation && acc != null) {
            System.out.println("Digite o valor a ser sacado");
            withdrawValue = scanner.nextDouble();

            if (withdrawValue == 0)
                System.out.println("Digite um valor valido");
            else if (acc.getBalance() - withdrawValue < 0) {
                System.out.println("Saldo insuficiente");
                return;
            } else {
                acc.withdraw(withdrawValue);
                System.out.println("Saque realizado com sucesso");
                System.out.println(String.format("Saldo atual: %.2f", acc.getBalance()));
                break;
            }
        }
    }

    protected Account getAccount(int accNumber) {
        if (accNumber <= 0)
            return null;

        for (int i = 0; i < accs.length; i++) {
            if (accNumber == accs[i].getAccountNumber()) {
                return accs[i];
            }
        }

        return null;
    }

    protected int getAccountInput(Scanner scanner) {
        int accNumber = 0;

        System.out.println(String.format("\nDigite a conta"));
        accNumber = Integer.parseInt(scanner.nextLine());

        return accNumber;
    }

    protected int displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int i = 1;

        System.out.println(String.format("%d - Sacar", i++));
        System.out.println(String.format("%d - Depositar", i++));
        System.out.println(String.format("%d - Consultar Saldo", i++));
        System.out.println(String.format("%d - Listar Contas", i++));
        System.out.println(String.format("%d - Sair", i));

        int option = 0;
        option = scanner.nextInt();
        scanner.close();

        return option;
    }
}
