package com.example.magiclabs;

import com.example.magiclabs.dao.GetMinimum;
import com.example.magiclabs.dao.GetVariance;
import com.example.magiclabs.model.DateTemp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class MagicLabsApplicationTests {

	public static Map<String, List<DateTemp>> getMap() {
		//Add dummy data for testing to map
		Map<String, List<DateTemp>> map = new HashMap<>();

		DateTemp obj1 = new DateTemp("2000.001", "5.0");
		DateTemp obj2 = new DateTemp("2000.002", "-10.0");
		DateTemp obj3 = new DateTemp("2000.003", "5.0");
		List<DateTemp> list1 = new ArrayList<>();
		list1.add(obj1);
		list1.add(obj2);
		list1.add(obj3);

		DateTemp obj4 = new DateTemp("2000.004", "100.0");
		DateTemp obj5 = new DateTemp("2000.005", "0.0");
		DateTemp obj6 = new DateTemp("2000.006", "100.0");
		List<DateTemp> list2 = new ArrayList<>();
		list2.add(obj4);
		list2.add(obj5);
		list2.add(obj6);

		map.put("1", list1);
		map.put("2", list2);

		return map;
	}

	@Test
	void testPart1() {
		Map<String, List<DateTemp>> map = getMap();
		String[] lowestTempStationAndDate = GetMinimum.getLowestTemprature(map);
		//check lowest temperature station_id
		Assertions.assertEquals(lowestTempStationAndDate[0], "1");
		//check lowest temperature date
		Assertions.assertEquals(lowestTempStationAndDate[1], "2000.002");
	}

	@Test
	void testPart2() {
		Map<String, List<DateTemp>> map = getMap();
		String mostFlucStation = GetVariance.getStationVariance(map);
		//check fluctuation
		Assertions.assertEquals(mostFlucStation, "2");
	}

}
