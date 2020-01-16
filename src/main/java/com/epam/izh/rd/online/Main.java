package com.epam.izh.rd.online;

import com.epam.izh.rd.online.helper.Direction;
import com.epam.izh.rd.online.service.SimpleTextStatisticsAnalyzer;
import com.epam.izh.rd.online.service.StreamApiTextStatisticsAnalyzer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class Main {
    private static Comparator<String> getStringComparator(Direction direction) {
        return direction.equals(Direction.ASC) ?
                Comparator.comparing(String::length) :
                Comparator.comparing(String::length).reversed();
    }

    public static void main(String[] args) {
        StringBuilder strings = new StringBuilder();
        File file = new File("C:\\Ахив\\java-collections-template\\src\\main\\resources\\sample-text.txt");
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                strings.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        SimpleTextStatisticsAnalyzer utilTest = new SimpleTextStatisticsAnalyzer();
        StreamApiTextStatisticsAnalyzer streamApiTextStatisticsAnalyzer = new StreamApiTextStatisticsAnalyzer();
        System.out.println(utilTest.getWords(strings.toString()));
//        System.out.println(streamApiTextStatisticsAnalyzer.sortWordsByLength(strings.toString(),Direction.ASC));
        }
    }

