package ru.pas;

public class BankRequest {
    boolean operationType = false; // false взять из банка, true положить в банк
    String clientName = "";
    int sum;
    BankRequest (boolean operationType, String clientName, int sum){
        this.operationType = operationType;
        this.clientName = clientName;
        this.sum = sum;
    }
}
