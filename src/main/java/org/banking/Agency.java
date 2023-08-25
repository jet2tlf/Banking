package org.banking;

import javax.swing.*;
import java.util.ArrayList;

public class Agency {
    static ArrayList<Account> bankAccounts;

    public static void main(String[] args) {
        bankAccounts = new ArrayList<>();
        Operations();
    }

    public static void Operations() {
        int operation = Integer.parseInt(JOptionPane.showInputDialog("""
                Selecione uma opção
                1 - Criar conta
                2 - Depositar
                3 - Sacar
                4 - Transferir
                5 - Listar
                6 - Sair"""));


        switch (operation) {
            case 1 -> createAccount();
            case 2 -> Deposit();
            case 3 -> Withdraw();
            case 4 -> Transfer();
            case 5 -> List();
            case 6 -> {
                JOptionPane.showMessageDialog(null, "Obrigado pela preferencia!");
                System.exit(0);
            }
            default -> {
                JOptionPane.showMessageDialog(null, "Opção inválida");
                Operations();
            }
        }
    }

    public static void createAccount() {
        Person person = new Person();

        person.setName(JOptionPane.showInputDialog("Nome:"));
        person.setCpf(JOptionPane.showInputDialog("CPF:"));
        person.setEmail(JOptionPane.showInputDialog("E-Mail:"));

        Account account = new Account(person);

        bankAccounts.add(account);
        JOptionPane.showMessageDialog(null, "Sua conta foi criada com sucesso!");

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
        int accountNumber = Integer.parseInt(JOptionPane.showInputDialog("Número da conta para deposito:"));

        Account account = findAccount(accountNumber);

        if (account != null) {
            Double depositValue = Double.parseDouble(JOptionPane.showInputDialog("Valor de deposito:"));
            account.Deposit(depositValue);
        } else {
            JOptionPane.showMessageDialog(null, "Conta não encontrada!");
        }
        Operations();
    }

    public static void Withdraw() {
        int accountNumber = Integer.parseInt(JOptionPane.showInputDialog("Número da conta para saque:"));

        Account account = findAccount(accountNumber);

        if (account != null) {
            Double withdrawValue = Double.parseDouble(JOptionPane.showInputDialog("Valor de saque:"));
            account.Withdraw(withdrawValue);
        } else {
            JOptionPane.showMessageDialog(null, "Conta não encontrada!");
        }
        Operations();
    }

    public static void Transfer() {
        int accountSenderNumber = Integer.parseInt(JOptionPane.showInputDialog("Número da conta do remetente:"));

        Account accountSender = findAccount(accountSenderNumber);

        if (accountSender != null) {
            int accountAddresseeNumber = Integer.parseInt(JOptionPane.showInputDialog("Número da conta do destinatário:"));

            Account accountAddressee = findAccount(accountAddresseeNumber);

            if (accountAddressee != null) {
                Double value = Double.parseDouble(JOptionPane.showInputDialog("Valor da transferência:"));

                accountSender.Transfer(accountAddressee, value);
            } else {
                JOptionPane.showMessageDialog(null, "Conta para deposito não encontrada!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Conta para transferência não encontrada!");
        }
        Operations();
    }

    public static void List() {
        if (!bankAccounts.isEmpty()) {
            for (Account c: bankAccounts) {
                JOptionPane.showMessageDialog(null, c);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não há contas cadastradas!");
        }
        Operations();
    }
}
