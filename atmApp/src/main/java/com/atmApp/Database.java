package com.atmApp;

import java.util.HashMap;
import java.util.Map;

public class Database {
    HashMap<Integer,Account> accountDatabase = new HashMap<Integer,Account>();
    Account defaultAcc = new Account("John Wick","1234");
    public Database(){
        accountDatabase.put(defaultAcc.getId(),defaultAcc);
        System.out.println(defaultAcc.getId());
    }

    public Account newAccount(Account newAccount){

        accountDatabase.put(newAccount.getId(),newAccount);
        return newAccount;
    }

}
