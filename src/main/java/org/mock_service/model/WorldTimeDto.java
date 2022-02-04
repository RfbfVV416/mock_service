package org.mock_service.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class WorldTimeDto {
    String date;
    String time;
    String timezone;
}
