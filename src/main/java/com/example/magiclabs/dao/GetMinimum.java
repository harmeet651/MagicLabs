package com.example.magiclabs.dao;

import com.example.magiclabs.model.DateTemp;

import java.util.*;

public class GetMinimum {
    // If we want to fetch lowest temperature a lot and we have stream of data we can use a Priority with with a min heap
    // to save the top few lowest temperatures, we can also construct a tree or sort the temperatures and do a binary search
    // but to build these structures we will have to at least do go through list once so, time to build will be 0(n)
    // hence for this use case I only did a linear search on the map, because we are fetching the result only once
    public static String[] getLowestTemprature(Map<String, List<DateTemp>> map) {
        String[] ans = new String[2];
        Double min = Double.MAX_VALUE;
        for (Map.Entry<String, List<DateTemp>> entry : map.entrySet()) {
            for(int i=0;i<entry.getValue().size();i++) {
                DateTemp value = entry.getValue().get(i);
                Double temperature = Double.parseDouble(value.getTemerature());
                if(min>temperature) {
                    // we can make a list if we see same temperatures here and throw random one if we want from here
                    min = temperature;
                    ans[0] = entry.getKey();
                    ans[1] = entry.getValue().get(i).getDate();
                }
            }
		}
        return ans;
    }
}
