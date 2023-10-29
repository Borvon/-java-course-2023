package edu.hw3.task6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SimpleStockMarketTest {

    @Test
    @DisplayName("Task 6")
    void test() {
        StockMarket market = new SimpleStockMarket();

        market.add(new Stock(543));
        market.add(new Stock(1543));
        market.add(new Stock(43));
        market.add(new Stock(5543));
        market.add(new Stock(5543));
        assertThat(market.mostValuableStock().getCost()).isEqualTo(5543);

        market.remove(new Stock(5543));
        assertThat(market.mostValuableStock().getCost()).isEqualTo(5543);

        market.remove(new Stock(5543));
        assertThat(market.mostValuableStock().getCost()).isEqualTo(1543);

        market.remove(new Stock(1543));
        assertThat(market.mostValuableStock().getCost()).isEqualTo(543);
    }

}
