package org.mock_service.service;

import org.mock_service.model.WorldTimeDto;

public interface WorldTimeService {
    WorldTimeDto getWorldTime(String location);
}
