package edu.hw3.task6;

import java.util.PriorityQueue;
import java.util.Queue;

public class SimpleStockMarket implements StockMarket {

    private final Queue<Stock> stocks = new PriorityQueue<>(new StockComparator());

    @Override
    public void add(Stock stock) {
        stocks.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        stocks.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return stocks.peek();
    }
}
