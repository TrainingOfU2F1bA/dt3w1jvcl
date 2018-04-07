package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {
    }

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {
        int m = this.random.nextInt(3);
        return IntStream.range(0, number).boxed().filter(x -> (number - x) % m == 0).sorted((a,b)->b-a).collect(Collectors.toList());
    }
}
