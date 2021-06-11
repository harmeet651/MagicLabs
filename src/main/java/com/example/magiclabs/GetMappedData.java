package com.example.magiclabs;

import com.example.magiclabs.model.DateTemp;
import com.example.magiclabs.model.MapModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GetMappedData {

    //This throws exception if FileNotFound, we can use try/catch if needed as per our need, not adding it to complete project within 2 hours
    public static Map<String, List<DateTemp>> getMappedData() throws FileNotFoundException {
        //parsing a CSV file into Scanner class constructor
        Scanner sc = new Scanner(new File("C:\\Users\\Harmeet Singh\\IdeaProjects\\MagicLabs\\src\\main\\java\\com\\example\\data.csv"));

        //A map to keep stations as Keys and Date and Temperature as Values using the model classes
        Map<String, List<DateTemp>> map = new HashMap<>();

        //Iterate over the CSV to fill the map
        while (sc.hasNext()) { //returns a boolean value
            String current = sc.nextLine();

            String[] entry = current.split(",");
            String key = entry[0];
            String date = entry[1];
            String temperature = entry[2];

            DateTemp dateTemp = new DateTemp(date, temperature);

            if(map.containsKey(key)) {
                List<DateTemp> list = map.get(key);

                if(list.contains(dateTemp)) continue;

                else {
                    list.add(dateTemp);
                }
                MapModel mapModel = new MapModel(key, list);
                map.put(mapModel.getStationId(), mapModel.getDateTemps());
            }
            else {
                List<DateTemp> list = new ArrayList<>();
                list.add(dateTemp);
                MapModel mapModel = new MapModel(key, list);
                map.put(mapModel.getStationId(), mapModel.getDateTemps());
            }
        }
        sc.close();  //closes the scanner
        return map;
    }
}
