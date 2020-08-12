package com.timiette.loottables;

import java.util.Random;

public class Seedable {

    int seed = 0;
    public void resetSeed() {
        seed = new Random(1000000000).nextInt();
    }

    public int getSeed() {
    return seed;
    }
}
