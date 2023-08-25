package org.banking;

// import org.banking.Utils.Utils;

import java.util.ArrayList;
import java.util.Scanner;

public class Agency {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Account> bankAccounts;

    public static void main(String[] args) {
        bankAccounts = new ArrayList<>();
        Operations();
    }

    public static void Operations() {
        System.out.println("1 - Criar conta");
        System.out.println("2 - Depositar");
        System.out.println("3 - Sacar");
        System.out.println("4 - Transferir");
        System.out.println("5 - Listar");
        System.out.println("6 - Sair");

        int operation = input.nextInt();

        switch (operation) {
            case 1:
                // Utils.Clear();
                createAccount();
            case 2:
                // Utils.Clear();
                Deposit();
            case 3:
                // Utils.Clear();
                Withdraw();
            case 4:
                // Utils.Clear();
                Transfer();
            case 5:
                // Utils.Clear();
                List();
            case 6:
                // Utils.Clear();
                System.out.println("Obrigado pela preferencia!");
                System.exit(0);
            default:
                System.out.println("Opção inválida");
                Operations();
        }
    }

    public static void createAccount() {
        System.out.println("\nNome: ");
        String name = input.next();

        System.out.println("\nCPF: ");
        String cpf = input.next();

        System.out.println("\nE-Mail: ");
        String email = input.next();

        Person person = new Person(name, cpf, email);

        Account account = new Account(person);

        bankAccounts.add(account);
        System.out.println("Sua conta foi criada com sucesso!");

        Operations();
    }

    private static Account findAccount(int accountNumber) {
        Account account = null;
        if (!bankAccounts.isEmpty()) {
            for (Account c: bankAccounts) {
                if (c.getAccountNumber() == accountNumber) {
                    account = c;
                }
            }
        }
        return account;
    }

    public static void Deposit() {
        System.out.println("Número da conta: ");
        int accountNumber = input.nextInt();

        Account account = findAccount(accountNumber);

        if (account != null) {
            System.out.println("Qual valor deseja depositar?");
            Double depositValue = input.nextDouble();
            account.Deposit(depositValue);
            System.out.println("Valor depositado com sucesso!");
        } else {
            System.out.println("Conta não encontrada!");
        }
        Operations();
    }

    public static void Withdraw() {
        System.out.println("Número da conta: ");
        int accountNumber = input.nextInt();

        Account account = findAccount(accountNumber);

        if (account != null) {
            System.out.println("Qual valor deseja Sacar?");
            Double withdrawValue = input.nextDouble();
            account.Withdraw(withdrawValue);
            System.out.println("Valor sacado com sucesso!");
        } else {
            System.out.println("Conta não encontrada!");
        }
        Operations();
    }

    public static void Transfer() {
        System.out.println("Número da conta do remetente: ");
        int accountSenderNumber = input.nextInt();

        Account accountSender = findAccount(accountSenderNumber);

        if (accountSender != null) {
            System.out.println("Número da conta do destinatário: ");
            int accountAddresseeNumber = input.nextInt();

            Account accountAddressee = findAccount(accountAddresseeNumber);

            if (accountAddressee != null) {
                System.out.println("Valor da transferência: ");
                Double value = input.nextDouble();

                accountSender.Transfer(accountAddressee, value);
            }
        }
        Operations();
    }

    public static void List() {
        if (!bankAccounts.isEmpty()) {
            for (Account c: bankAccounts) {
                System.out.println(c);
            }
        } else {
            System.out.println("Não há contas cadastradas!");
        }
        Operations();
    }
}
