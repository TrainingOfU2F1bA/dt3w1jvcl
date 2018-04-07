package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        return IntStream.rangeClosed(leftBorder < rightBorder ? leftBorder : rightBorder, leftBorder > rightBorder ? leftBorder : rightBorder).filter(x -> x % 2 == 0).sum();
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        return IntStream.rangeClosed(leftBorder < rightBorder ? leftBorder : rightBorder, leftBorder > rightBorder ? leftBorder : rightBorder).filter(x -> x % 2 != 0).sum();
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().reduce((a, b) -> a + b).get().intValue() * 3 + 2 * arrayList.size();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map(x -> x % 2 != 0 ? x * 3 + 2 : x).collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().filter(x -> x % 2 != 0).map(x -> x * 3 + 5).reduce((a, b) -> a + b).get().intValue();
    }

    public double getMedianOfEvenIndex(List<Integer> arrayList) {
        List<Integer> list = arrayList.stream().filter(x -> x % 2 == 0).sorted().collect(Collectors.toList());
        return (list.get(0) + list.get(list.size() - 1)) / 2;
    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {
       return arrayList.stream().filter(x -> x % 2 == 0).mapToInt(x->x).average().getAsDouble();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream().filter(x -> x % 2 == 0).collect(Collectors.toList()).contains(specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().filter(x -> x % 2 == 0).distinct().collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        return arrayList.stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                boolean e1 = o1 % 2 == 1;
                boolean e2 = o2 % 2 == 1;
                if (!e1 && !e2) {
                    if (o1 < o2) return -1;
                } else if (e1 && e2) {
                    if (o1 > o2) return -1;
                } else if (!e1) {
                    return -1;
                }
                return 1;
            }
        }).collect(Collectors.toList());
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> subList = new ArrayList<Integer>(arrayList.subList(1, arrayList.size()));
        for (int i = 0; i < subList.size(); i++) {
           subList.set(i,(arrayList.get(i)+subList.get(i))*3);
        }
        return subList;
    }
}
