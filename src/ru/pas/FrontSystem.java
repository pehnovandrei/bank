package ru.pas;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class FrontSystem {
    private static FrontSystem mySystem;
    private FrontSystem(){ }
    public static FrontSystem getFrontSystem(){
        if (mySystem == null){
            mySystem = new FrontSystem();
        }
        return mySystem;
    }
    LinkedList<BankRequest> requests = new LinkedList<BankRequest>();

    synchronized void addRequest(BankRequest request) {
        try {
            while (requests.size() == 2){
                wait();
            }
            requests.add(request);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    synchronized BankRequest pullRequest(){
        try {
            BankRequest takenRequest = requests.remove();
            return takenRequest;
        } catch (NoSuchElementException e){
            return null;
        } finally {
            notifyAll();
        }
    }
}
