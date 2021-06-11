package com.example.magiclabs.dao;

import com.example.magiclabs.model.DateTemp;

import java.util.List;
import java.util.Map;

public class GetVariance {
    public static String getStationVariance(Map<String, List<DateTemp>> map) {
        Double max = Double.MIN_VALUE;
        String res = "";
        for (Map.Entry<String, List<DateTemp>> entry : map.entrySet()) {
            double varianvce = varianceOfStation(entry.getValue());
            if(max<varianvce) {
                max = varianvce;
                res = entry.getKey();
            }
        }
        return res;
    }

    private static double varianceOfStation(List<DateTemp> list) {
        double sum = 0.0;
        for(int i=0;i<list.size();i++) {
            double temp = Double.parseDouble(list.get(i).getTemerature());
            sum+=temp;
        }
        double mean = sum/(double)list.size();
        double sqDiff = 0;
        for (int i = 0; i < list.size(); i++) {
            sqDiff += (Double.parseDouble(list.get(i).getTemerature()) - mean) *
                    (Double.parseDouble(list.get(i).getTemerature()) - mean);
        }
        return sqDiff/list.size();
    }
}
