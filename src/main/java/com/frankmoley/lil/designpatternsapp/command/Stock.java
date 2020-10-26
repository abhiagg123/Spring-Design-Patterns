package com.frankmoley.lil.designpatternsapp.command;

public class Stock {
    public String symbol;
    public String name;

    public Stock(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void buyStock(){
        System.out.println("Bought stock : " + symbol);
    }

    public void sellStock(){
        System.out.println("Sold stock : " + symbol);
    }
}
