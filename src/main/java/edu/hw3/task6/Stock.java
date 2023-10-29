package edu.hw3.task6;

import java.util.Objects;

public class Stock {
    private int cost;

    public Stock(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        return ((Stock) obj).getCost() == cost;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cost);
    }
}
