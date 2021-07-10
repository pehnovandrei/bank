package ru.pas;

public class RequestHandler extends Thread {
    public RequestHandler (String name){this.setName(name);}
    FrontSystem frontSystem = FrontSystem.getFrontSystem();
    BackSystem backSystem = BackSystem.getBackSystem();
    @Override
    public void run(){
        while (!Thread.currentThread().isInterrupted()) {
            try {
                BankRequest request = frontSystem.pullRequest();
                System.out.println(this.getName() + ": Получена заявка на обработку - " + request.clientName);
                backSystem.pushRequest(request, this.getName());
            } catch (NullPointerException e){}
        }
    }
}
