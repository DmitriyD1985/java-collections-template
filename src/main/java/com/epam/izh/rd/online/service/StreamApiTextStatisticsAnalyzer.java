package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.helper.Direction;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.*;

/**
 * Данный класс обязан использовать StreamApi из функционала Java 8. Функциональность должна быть идентична
 * {@link SimpleTextStatisticsAnalyzer}.
 */
public class StreamApiTextStatisticsAnalyzer implements TextStatisticsAnalyzer {
    @Override
    public int countSumLengthOfWords(String text) {
        return 0;
    }

    @Override
    public int countNumberOfWords(String text) {
        return 0;
    }

    @Override
    public int countNumberOfUniqueWords(String text) {
        return 0;
    }

    @Override
    public List<String> getWords(String text) {
        return Arrays.asList(text.split("\\p{Punct}"))
                .stream()
                .map(s -> s.replace(" ", ""))
                .collect(Collectors.toList());
    }

    @Override
    public Set<String> getUniqueWords(String text) {
        return Arrays.asList(text.split("\\p{Punct}"))
                .stream()
                .map(s -> s.replace(" ", ""))
                .collect(Collectors.toSet());
    }
    @Override
    public Map<String, Integer> countNumberOfWordsRepetitions(String text) {
        Map<String, Integer> wordCounts = new HashMap<>();

        wordCounts = getWords(text).stream().filter(s -> !getWords(text).contains(s))
                    .collect(groupingBy(identity(), summingInt(s -> 1)));
    }

    @Override
    public List<String> sortWordsByLength(String text, Direction direction) {
        return emptyList();
    }
}
