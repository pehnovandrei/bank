package ru.pas;

public class BackSystem {
    private static BackSystem myBackSystem;
    private BackSystem(){ }
    public static BackSystem getBackSystem(){
        if (myBackSystem == null){
            myBackSystem = new BackSystem();
        }
        return myBackSystem;
    }
    int balance = 2000;
    void pushRequest(BankRequest request, String handler){
        if (request.operationType) {
            balance += request.sum;
            System.out.println("��� �������: ������ {clientTreadName='" + request.clientName + "', amount=" + request.sum + ", requestType=REPAYMENT} ������� ���������. �������� �� " + handler + ". ������ �����: " + balance);
        } else {
            if (balance >= request.sum) {
                balance -= request.sum;
                System.out.println("��� �������: ������ {clientTreadName='" + request.clientName + "', amount=" + request.sum + ", requestType=CREDIT} ������� ���������. �������� �� " + handler + ". ������ �����: " + balance);
            }
            else{
                System.out.println("��� �������: ������ {clientTreadName='" + request.clientName + "', amount=" + request.sum + ", requestType=CREDIT} �� ���������. �������� �� " + handler + ". ����� ������ ������� �����. ������ �����: " + balance);
            }
        }
    }
}
