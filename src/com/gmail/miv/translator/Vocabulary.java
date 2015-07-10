package com.gmail.miv.translator;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement(name = "vocabulary")
public class Vocabulary {

    @XmlElement
    private Map<String, String> map = new HashMap<>();

    public void put(String key, String value) {
        map.put(key, value);
    }

    public String get(String key) {
        return map.get(key);
    }

    public String translate(String input) {
        String result = "";
        String[] words = input.split(" ");
        for (String word : words) {
            result += (map.get(word) == null) ? word : map.get(word) + " ";
        }
        return result;
    }

    @Override
    public String toString() {
        return "Vocabulary{" +
                "map=" + map +
                '}';
    }
}
