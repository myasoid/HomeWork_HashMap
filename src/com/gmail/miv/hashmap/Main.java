package com.gmail.miv.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[] array = new int[(int)1e6];
        Random rn = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rn.nextInt(20);
        }

        Map<Integer, Integer> map = new HashMap<>();

        int key;
        int value;

        for (int i = 0; i < array.length; i++) {
            key = array[i];
            value = (map.get(key) == null) ? 0 : map.get(key);
            map.put(key, value + 1);
        }

        System.out.println(map);

    }

}
