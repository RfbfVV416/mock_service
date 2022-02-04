package org.mock_service;

import lombok.RequiredArgsConstructor;
import org.mock_service.model.WorldTimeDto;
import org.mock_service.service.WorldTimeService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class WorldTimeController {

    private final WorldTimeService worldTimeService;

    @GetMapping("/{location}")
    private WorldTimeDto getWorldTime(@PathVariable String location){
        return worldTimeService.getWorldTime(location);
    }
}
