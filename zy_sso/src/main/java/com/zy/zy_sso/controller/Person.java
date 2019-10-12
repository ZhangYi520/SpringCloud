package com.zy.zy_sso.controller;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

class Note {
    public static void main(String[] args) {
        List<Person> personList = Lists.newArrayList();
        personList.add(Person.builder().id(10).name("apple").msg("shanghai").build());
        personList.add(Person.builder().id(10).name("apple").msg("shanghai").build());
        personList.add(Person.builder().id(10).name("apple").msg("shanghai").build());
        personList.add(Person.builder().id(12).name("apple").msg("wuhan").build());
        personList.add(Person.builder().id(16).name("apple").msg("nanjing").build());
        personList.forEach(System.out::println);

        Map<Object, List<Person>> collect = personList.stream().collect(Collectors.groupingBy(a -> a.getId()));
        System.out.println(collect);
    }
}
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person{
    Integer id;
    String name;
    String msg;
}