package com.app.javafx;
/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */

import java.util.ArrayList;
import java.util.function.Predicate;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ButtonController {
    ArrayList<Account> accountList = new ArrayList<>();
    TextField ownerSearchBar;
    TextField numberSearchBar;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Predicate<Account> matchAccountOwner = a -> a.getAccountOwner().equals(ownerSearchBar.getText());  //Replace null
    Predicate<Account> matchAccountNumber = a -> String.valueOf(a.getAccountNumber()).equals(numberSearchBar.getText()); //Replace null

    
    public ButtonController(ArrayList list, TextField o, TextField n, Button b1, Button b2, Button b3, Button b4, Button b5, Button b6, Button b7, Button b8){
        accountList = list;
        ownerSearchBar = o;
        numberSearchBar = n;
        btn1 = b1;
        btn2 = b2;
        btn3 = b3;
        btn4 = b4;
        btn5 = b5;
        btn6 = b6;
        btn7 = b7;
        btn8 = b8;
        interactions();
    }
    
    //Which method do you call when a button is pressed?
    private void interactions(){
    	btn1.setOnMousePressed(e -> button1Pressed());
        btn2.setOnMousePressed(e -> button2Pressed());
        btn3.setOnMousePressed(e -> button3Pressed());
        btn4.setOnMousePressed(e -> button4Pressed());
        btn5.setOnMousePressed(e -> button5Pressed());
        btn6.setOnMousePressed(e -> button6Pressed());
        btn7.setOnMousePressed(e -> button7Pressed());
        btn8.setOnMousePressed(e -> button8Pressed());        
    }
    
    //Print details for each account belonging to the specified owner.
    private void button1Pressed(){
    	accountList.stream()
        .filter(matchAccountOwner)
        .forEach(a -> {
            a.printDetails();
        });        
    }
    
    //Close each account belonging to the specified owner.
    private void button2Pressed(){
        accountList.stream()
                .filter(matchAccountOwner)
                .forEach(a -> {
                    System.out.println("CLOSING");
                    a.printDetails();
                });
        accountList.removeIf(matchAccountOwner);
    }
    
    //Deposit $200 into the specified account.
    private void button3Pressed(){
        accountList.stream()
                .filter(matchAccountNumber) 
                .forEach(a -> a.deposit(200));
    }
    
    //Withdraw $200 from the specified account.
    private void button4Pressed(){
    	accountList.stream()
        .filter(matchAccountNumber) 
        .forEach(a -> a.withdraw(200));        
    }
    
    //Deposit a bonus $20 for each savings account with a balance of at least $20,000.
    private void button5Pressed(){
    	accountList.stream()
        .filter(a -> a.getAccountType().equals("Savings Account")
        		&& a.getBalance()>=20000)
        .forEach(a -> a.deposit(20));        
    }
    
    //Earn interest for each savings account.
    private void button6Pressed(){
        accountList.stream()
                .filter(a -> a.getAccountType().equals("Savings Account"))
                .forEach(a -> ((SavingsAccount)a).earnInterest());
    }
    
    //Charge a $35 fee for each checking account with fewer than 1 transactions.
    private void button7Pressed(){
    	accountList.stream()
        .filter(a -> a.getAccountType().equals("Checking Account")
        		&& a.getTransactions()<1)
        .forEach(a -> a.withdraw(35));        
    }
    
    //Reset all transactions to 0.
    private void button8Pressed(){
    	accountList.stream()
        .forEach(a -> a.resetTransactions());        
    }
    
}
