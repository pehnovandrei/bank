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
            System.out.println("Бэк система: Заявка {clientTreadName='" + request.clientName + "', amount=" + request.sum + ", requestType=REPAYMENT} УСПЕШНА ВЫПОЛНЕНА. Получена от " + handler + ". Баланс банка: " + balance);
        } else {
            if (balance >= request.sum) {
                balance -= request.sum;
                System.out.println("Бэк система: Заявка {clientTreadName='" + request.clientName + "', amount=" + request.sum + ", requestType=CREDIT} УСПЕШНА ВЫПОЛНЕНА. Получена от " + handler + ". Баланс банка: " + balance);
            }
            else{
                System.out.println("Бэк система: Заявка {clientTreadName='" + request.clientName + "', amount=" + request.sum + ", requestType=CREDIT} НЕ ВЫПОЛНЕНА. Получена от " + handler + ". Сумма больше баланса банка. Баланс банка: " + balance);
            }
        }
    }
}
