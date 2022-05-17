package com.some.playground.funs;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class RegularDemo {
    public static void main(String[] args) {
        List<String> matchesList = new ArrayList<>();

        String stringToSearch = "7801111111blahblah  780222222 mumbojumbo7803333333 thisnthat 7804444444";
        Pattern p1 = Pattern.compile("780{1}\\d{7}");
        Matcher m1 = p1.matcher(stringToSearch);

        // find() returns a boolean if a match is found
        while (m1.find()) {
            //group() It produces a String that represents the matched pattern.
            matchesList.add(m1.group());
        }

        int sizeOfNewArray = matchesList.size();
        String newArrayOfMatches[] = new String[sizeOfNewArray];
        matchesList.toArray(newArrayOfMatches);

        Stream.of(newArrayOfMatches).forEach(System.out::println);
    }
}
