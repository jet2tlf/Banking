package org.banking;

import org.banking.Utils.Utils;

import javax.swing.*;

public class Account {
    private static int AccountCounter = 1;

    private int accountNumber;
    private Person person;
    private Double balance = 0.0;

    public Account(Person person) {
        this.accountNumber =  AccountCounter;
        this.person = person;
        AccountCounter += 1;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String toString() {
        return "\nNúmero da conta: " + this.getAccountNumber() + "\nNome: " + this.person.getName() + "\nCPF: " + this.person.getCpf() + "\nE-Mail: " + this.person.getEmail() + "\nSaldo: " + Utils.dubleToString(this.getBalance()) + "\n";
    }

    public void Deposit(Double value) {
        if (value > 0) {
            setBalance(getBalance() + value);
            JOptionPane.showMessageDialog(null, "Seu depósito foi realizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possivel realizar o depósito!");
        }
    }

    public void Withdraw(Double value) {
        if (value > 0 && this.getBalance() >= value) {
            setBalance(getBalance() - value);
            JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possivel realizar o saque!");
        }
    }

    public void Transfer(Account accountToDeposit, Double value) {
        if (value > 0 && this.getBalance() >= value) {
            setBalance(getBalance() - value);
            accountToDeposit.balance = accountToDeposit.getBalance() + value;
            JOptionPane.showMessageDialog(null, "Transferência realizada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possivel realizar a transferência!");
        }
    }
}
