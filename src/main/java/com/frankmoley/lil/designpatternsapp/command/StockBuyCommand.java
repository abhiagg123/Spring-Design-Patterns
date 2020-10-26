package com.frankmoley.lil.designpatternsapp.command;

public class StockBuyCommand implements Command{

    @Override
    public Stock getStock() {
        return stock;
    }

    private Stock stock;

    @Override
    public void execute() {
        stock.buyStock();
    }

    public StockBuyCommand(Stock stock) {
        this.stock = stock;
    }
}
