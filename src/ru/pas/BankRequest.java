package ru.pas;

public class BankRequest {
    boolean operationType = false; // false ����� �� �����, true �������� � ����
    String clientName = "";
    int sum;
    BankRequest (boolean operationType, String clientName, int sum){
        this.operationType = operationType;
        this.clientName = clientName;
        this.sum = sum;
    }
}
