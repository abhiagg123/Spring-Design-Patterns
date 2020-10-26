package com.frankmoley.lil.designpatternsapp.command;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Broker {
    List<Command> orders = new ArrayList<>();
    public void takeOrder(Command command){
        orders.add(command);
    }

    public void placeOrders(){
        for(Command c : orders){
            System.out.println(c.getStock().symbol);
            c.execute();
        }

        orders.clear();
    }
}
