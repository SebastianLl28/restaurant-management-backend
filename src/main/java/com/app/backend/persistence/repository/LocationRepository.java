package com.app.backend.persistence.repository;

import com.app.backend.persistence.entity.Location;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {

  List<Location> findAllByStatus(Boolean status);
}
