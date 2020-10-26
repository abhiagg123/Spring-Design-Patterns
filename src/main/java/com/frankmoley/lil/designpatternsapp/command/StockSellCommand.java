package com.frankmoley.lil.designpatternsapp.command;

public class StockSellCommand implements Command{

    @Override
    public Stock getStock() {
        return stock;
    }

    private Stock stock;

    @Override
    public void execute() {
        stock.sellStock();
    }

    public StockSellCommand(Stock stock) {
        this.stock = stock;
    }
}
