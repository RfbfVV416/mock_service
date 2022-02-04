package org.mock_service.repository;

import org.mock_service.model.Area;
import org.mock_service.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {
    Area findByLocation(Location location);
}
