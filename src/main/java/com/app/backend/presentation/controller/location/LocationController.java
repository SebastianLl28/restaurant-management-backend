package com.app.backend.presentation.controller.location;

import com.app.backend.persistence.entity.Location;
import com.app.backend.persistence.repository.LocationRepository;
import com.app.backend.util.AppConstant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {

  @Autowired
  private LocationRepository locationRepository;

  @GetMapping(AppConstant.PUBLIC_BASE_ENDPOINT + "/location")
  public List<Location> findAllLocation() {
    return locationRepository.findAllByStatus(Boolean.TRUE);
  }



}
