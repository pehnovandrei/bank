package ru.pas;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    public static void main(String[] args) {
        FrontSystem front = FrontSystem.getFrontSystem();
        BackSystem back = BackSystem.getBackSystem();
        List<Client> clients = new ArrayList<>();
        List<RequestHandler> handlers = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            int j = i + 1;
            clients.add(i, new Client("Клиент №" + j));
            clients.get(i).start();
        }
        for (int i = 0; i < 2; i ++){
            int j = i + 1;
            handlers.add(i, new RequestHandler("Обработчик заявок №" + j));
            handlers.get(i).start();
        }
    }
}
