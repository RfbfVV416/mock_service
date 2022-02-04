package org.mock_service.service;

import lombok.RequiredArgsConstructor;
import org.mock_service.model.Area;
import org.mock_service.model.Location;
import org.mock_service.repository.AreaRepository;
import org.mock_service.repository.LocationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@RequiredArgsConstructor
public class TestDataLoader implements CommandLineRunner {

    private static final String[] EUROPEAN_LOCATIONS_LIST = {
            "Moscow",
            "Saratov",
            "Samara"
    };

    private static final String[] ASIAN_LOCATIONS_LIST = {
            "Omsk",
            "Tomsk",
            "Magadan"
    };

    private final LocationRepository locationRepository;
    private final AreaRepository areaRepository;

    @Override
    public void run(String... args) {
        List<Area> areas = createAreasIfNotExists();
        createLocationsIfNotExist(areas);
    }

    private void createLocationsIfNotExist(List<Area> areas){
        if (locationRepository.count() != 0) {
            return;
        }

        for (Area area: areas) {
            if ("Europe".equals(area.getName())){
                for (String locationName: EUROPEAN_LOCATIONS_LIST) {
                    createLocation(locationName, area);
                }
            }
            if ("Asia".equals(area.getName())){
                for (String locationName: ASIAN_LOCATIONS_LIST) {
                    createLocation(locationName, area);
                }
            }
        }
    }

    private List<Area> createAreasIfNotExists(){
        if (areaRepository.count() != 0) {
            return getListFromIterator(areaRepository.findAll());
        }
        return List.of(createArea("Europe"), createArea("Asia"));
    }

    private void createLocation(String name, Area area){
        Location location = new Location();
        location.setName(name);
        location.setArea(area);
        locationRepository.save(location);
    }

    private Area createArea(String name){
        Area area = new Area();
        area.setName(name);
        return areaRepository.save(area);
    }

    private <T> List<T> getListFromIterator(Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }
}
