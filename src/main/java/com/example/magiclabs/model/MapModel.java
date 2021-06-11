package com.example.magiclabs.model;

import java.util.List;
import lombok.*;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Setter
@Getter
public class MapModel {
    String stationId;
    List<DateTemp> dateTemps;

}
