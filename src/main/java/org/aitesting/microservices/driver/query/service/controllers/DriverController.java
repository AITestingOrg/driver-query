package org.aitesting.microservices.driver.query.service.controllers;

import org.aitesting.microservices.driver.query.domain.models.Driver;
import org.aitesting.microservices.driver.query.service.repositories.DriverRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class DriverController {

    private static final Logger logger = LoggerFactory.getLogger(DriverController.class);

    @Autowired
    private DriverRepository driverRepository;

    @GetMapping("drivers")
    public ResponseEntity<List<Driver>> getDrivers() {
        logger.info(String.format("Request all drivers"));
        return new ResponseEntity<>(driverRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("driver/{id}")
    public ResponseEntity<Driver> getDriver(@PathVariable UUID id) {
        logger.info(String.format("Request for a driver with id: %s", id));
        Driver driver = driverRepository.findOne(id);
        if(driver != null) {
            logger.info(String.format("Found driver by ID: %s", id));
            return new ResponseEntity<>(driver, HttpStatus.OK);
        }
        logger.info(String.format("No drivers found by ID: %s", id));
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("driver/available")
    public ResponseEntity<Driver> getAvailableDriver() {
        logger.info(String.format("Request for an available driver"));
        List<Driver> availableDrivers = driverRepository.findByAvailable(true);
        if(availableDrivers.size() > 0) {
            return new ResponseEntity<>(availableDrivers.get(0), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("drivers/allavailable")
    public ResponseEntity<List<Driver>> getAllAvailableDrivers() {
        logger.info(String.format("Request for all available drivers"));
        List<Driver> availableDrivers =driverRepository.findByAvailable(true);
        if(availableDrivers.size() > 0) {
            return new ResponseEntity<>(availableDrivers, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
