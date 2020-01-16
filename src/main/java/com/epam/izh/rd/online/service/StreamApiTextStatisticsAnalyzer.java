package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.helper.Direction;


import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Данный класс обязан использовать StreamApi из функционала Java 8. Функциональность должна быть идентична
 * {@link SimpleTextStatisticsAnalyzer}.
 */
public class StreamApiTextStatisticsAnalyzer implements TextStatisticsAnalyzer {
    @Override
    public int countSumLengthOfWords(String text) {
        return getWords(text).stream()
                .mapToInt((s) -> s.length()).sum();
    }

    @Override
    public int countNumberOfWords(String text) {
       return  (int)getWords(text).stream().count();
    }

    @Override
    public int countNumberOfUniqueWords(String text) {
        return  (int)getUniqueWords(text).stream().count();
    }

    @Override
    public List<String> getWords(String text) {
        return Stream.of(text.split("\\P{Alpha}+"))
                .map(elem -> new String(elem))
                .collect(Collectors.toList());


    }
    @Override
    public Set<String> getUniqueWords(String text) {
        return new HashSet<>(getWords(text));

    }
    @Override
    public Map<String, Integer> countNumberOfWordsRepetitions(String text) {
        return  getWords(text).stream().collect(Collectors.toConcurrentMap(
                        w -> w, w -> 1, Integer::sum));
    }

    @Override
    public List<String> sortWordsByLength(String text, Direction direction) {
        List<String> list = null;
        if(direction.equals(Direction.DESC))
        {
            list = getWords(text).stream().sorted(Comparator.comparingInt(String::length).reversed()).collect(toList());
        }
        if(direction.equals(Direction.ASC))
        {
            list = getWords(text).stream().sorted(Comparator.comparingInt(String::length)).collect(toList());
        }
        return list;
    }
}
