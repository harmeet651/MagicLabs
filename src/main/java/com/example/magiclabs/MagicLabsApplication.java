package com.example.magiclabs;

import com.example.magiclabs.dao.GetMinimum;
import com.example.magiclabs.dao.GetVariance;
import com.example.magiclabs.model.DateTemp;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.FileNotFoundException;
import java.util.*;

@SpringBootApplication
public class MagicLabsApplication {

	public static void main(String[] args) throws FileNotFoundException {
		//Start Application
		ConfigurableApplicationContext context = SpringApplication.run(MagicLabsApplication.class, args);

		//Get data in a map from CSV
		Map<String, List<DateTemp>> map = GetMappedData.getMappedData();

		//We can log the below outputs as well to our logs or table
		//PART 1
		String[] lowestTempStationAndDate = GetMinimum.getLowestTemprature(map);
		System.out.println(lowestTempStationAndDate[0]+ " station_id");
		System.out.println(lowestTempStationAndDate[1]+ " date");

		//PART 2
		String mostFlucStation = GetVariance.getStationVariance(map);
		System.out.println(mostFlucStation+ " station_id");

		//PART 3
		// We can add another method to the the GetVariance class and pass 2 dates to it, and calculate variance for the
		// entries that lay between those dates, stopping here to not exceed the 2 hour mark.

		//close application
		int exitCode = SpringApplication.exit(context, new ExitCodeGenerator() {
			@Override
			public int getExitCode() {
				return 0;
			}
		});
		System.exit(exitCode);
	}

}
