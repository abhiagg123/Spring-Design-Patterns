package com.frankmoley.lil.designpatternsapp.controller;

import com.frankmoley.lil.designpatternsapp.builder.Contact;
import com.frankmoley.lil.designpatternsapp.builder.ContactBuilder;
import com.frankmoley.lil.designpatternsapp.command.*;
import com.frankmoley.lil.designpatternsapp.factory.Pet;
import com.frankmoley.lil.designpatternsapp.factory.PetFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class MyController {

    @Autowired
    private PetFactory petFactory;

    @Autowired
    private Broker broker;

    @GetMapping
    public String getData(){
        return "Hello World";
    }

    @PostMapping("createPet/{type}/{name}")
    public Pet create(@PathVariable String type, @PathVariable String name){
        Pet pet = petFactory.createPet(type);
        pet.setName(name);
        pet.feed();
        return pet;
    }

    @GetMapping("contacts")
    public List<Contact> getContacts(){
        List<Contact> contacts = new ArrayList<>();

        // Way 1
        Contact contact = new Contact();
        contact.setFirstName("john first name");
        contact.setEmail("john email");
        contacts.add(contact);

        // Way 2
        contacts.add(new Contact("sam first", "sam last", null));

        // Way 3 - Builder
        contacts.add(new ContactBuilder().setFirstName("tom FN builder").setLastName("tom ln builder").build());
        return contacts;
    }

    @PostMapping("stocks/{symbol}/{name}")
    public Stock addStock(@PathVariable String symbol, @PathVariable String name){
        return new Stock(symbol, name);
    }

    @PostMapping("stocks/{symbol}/buy")
    public Stock buyStock(@PathVariable String symbol){
        Stock stock = new Stock(symbol, symbol);
        Command command = new StockBuyCommand(stock);
        broker.takeOrder(command);
        return stock;
    }

    @PostMapping("stocks/{symbol}/sell")
    public Stock sellStock(@PathVariable String symbol){
        Stock stock = new Stock(symbol, symbol);
        Command command = new StockSellCommand(stock);
        broker.takeOrder(command);
        return stock;
    }

    @GetMapping("stocks/execute")
    public void executeOrders(){
        broker.placeOrders();
    }
}
