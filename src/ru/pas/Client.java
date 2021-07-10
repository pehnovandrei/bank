package ru.pas;

import static java.lang.Math.random;

public class Client extends Thread {
    public Client(String s) {
        this.setName(s);
    }
    FrontSystem frontSystem = FrontSystem.getFrontSystem();
    @Override
    public void run(){
        pullRequest();
    }
    void pullRequest()
    {
        BankRequest request = new BankRequest((int)(random()*2) == 1?true:false, this.getName(), 1000);
        frontSystem.addRequest(request);
        if (request.operationType){
            System.out.println(request.clientName + ": Заявка {clientTreadName='" + request.clientName + "', amount=" + request.sum + ", requestType=REPAYMENT} отправленна в банк");
        }else{
            System.out.println(request.clientName + ": Заявка {clientTreadName='" + request.clientName + "', amount=" + request.sum + ", requestType=CREDIT} отправленна в банк");
        }
    }
}
