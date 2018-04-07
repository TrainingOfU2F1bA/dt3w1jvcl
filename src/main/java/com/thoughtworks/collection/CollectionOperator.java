package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        return IntStream.rangeClosed(Math.min(left,right),Math.max(left,right)).boxed().sorted((a,b)->left<right?a-b:b-a).collect(Collectors.toList());
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        return getListByInterval(left,right).stream().filter(x->x%2==0).collect(Collectors.toList());
    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array).boxed().filter(x->x%2==0).collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        return array[array.length-1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> collect = Arrays.stream(firstArray).boxed().collect(Collectors.toList());
        return Arrays.stream(secondArray).filter(x->collect.contains(x)).boxed().collect(Collectors.toList());
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> collect = Arrays.stream(firstArray).collect(Collectors.toList());
        collect.addAll(Arrays.stream(secondArray).collect(Collectors.toList()));
        return collect.stream().distinct().collect(Collectors.toList());
    }
}
