package com.example.exercise.demo;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 对list string 进行去重，大小写忽略
 * https://stackoverflow.com/questions/51552616/java-8-remove-duplicate-strings-irrespective-of-case-from-a-list/51554285
 */
public class DeDuplicationTest {
    public static void main(String[] args) {
        String str = "aa bB Bb cc CC";

        //method1
        String result1 = Pattern.compile("\\s")
                .splitAsStream(str)
                .collect(Collectors.collectingAndThen(
                        Collectors.toMap(String::toLowerCase,//map的key，转小写
                                Function.identity(),//map的value，原值
                                (oldValue, newValue) -> oldValue,//冲突时保留原值还是替换为新值
                                LinkedHashMap::new),
                        m -> String.join(" ", m.values())));//将values转换为string
        System.out.println(result1);

        //method2
        String result2 = str.replaceAll("(?i)\\b(\\w+)\\s+\\1\\b", "$1");
        System.out.println(result2);

        //method3
        List<String> list = new ArrayList<>(Arrays.asList(str.split("\\s")));
        TreeSet<String> seen = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        list.removeIf(s -> !seen.add(s));
        System.out.println(list);
    }
}
