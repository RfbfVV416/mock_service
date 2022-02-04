package org.mock_service.service;

import lombok.RequiredArgsConstructor;
import org.mock_service.model.Area;
import org.mock_service.model.WorldTimeDto;
import org.mock_service.NoSuchEntityException;
import org.mock_service.model.Location;
import org.mock_service.repository.AreaRepository;
import org.mock_service.repository.LocationRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorldTimeServiceImpl implements WorldTimeService {

    private final LocationRepository locationRepository;
    private final AreaRepository areaRepository;

    @Override
    public WorldTimeDto getWorldTime(String locationName) {
       Location location = locationRepository.findByName(locationName).orElseThrow(
               () -> new NoSuchEntityException("No location found. Only russian cities are acceptable.")
       );
       Area area = areaRepository.findByLocation(location);
       return WorldTimeDto.builder()
               .date("2022-02-02")
               .time("12:00")
               .timezone(area.getName() + "/" + location.getName())
               .build();
    }
}
