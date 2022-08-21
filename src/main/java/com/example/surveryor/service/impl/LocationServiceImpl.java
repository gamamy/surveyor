package com.example.surveryor.service.impl;

import com.example.surveryor.entity.Location;
import com.example.surveryor.repository.LocationRepository;
import com.example.surveryor.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    LocationRepository locationRepository;

    @Override
    public void createLocation(String name) {
        Location newLocation = new Location();

        newLocation.setName(name);

        locationRepository.insert(newLocation);
    }
}
