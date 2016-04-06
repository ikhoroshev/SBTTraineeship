package ru.sberbank.sbt.traineeship.lesson1;

/**
 * Created by admintb on 05.04.2016.
 */
public enum Coin {
    COIN_1("Cuprum"),
    COIN_5("Silver"),
    COIN_10("Gold");

    public String metal;

    Coin(String metal) {
        this.metal = metal;
    }

    public static void main(String[] args) {
        System.out.println(COIN_1.ordinal());
        System.out.println(COIN_1.name());
        Coin.valueOf("COIN_1");
    }
}
