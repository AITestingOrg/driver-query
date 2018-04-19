package org.aitesting.microservices.driver.query.domain.eventhandlers;

import org.aitesting.microservices.driver.common.events.DriverAvailabilityChangedEvent;
import org.aitesting.microservices.driver.common.events.DriverCreatedEvent;
import org.aitesting.microservices.driver.common.events.DriverDeletedEvent;
import org.aitesting.microservices.driver.query.domain.models.Driver;
import org.aitesting.microservices.driver.query.service.repositories.DriverRepository;
import org.axonframework.eventhandling.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DriverEventHandler {
    protected static final Logger LOG = LoggerFactory.getLogger(DriverEventHandler.class);

    @Autowired
    private DriverRepository driverRepository;

    public DriverEventHandler() {}

    @EventHandler
    public void on(DriverCreatedEvent event) {
        LOG.info("Creating driver: {}", event.getId());
        driverRepository.save(new Driver(event.getId(), event.getFirstName(), event.getLastName(),
                event.getAddress(), event.getEmail(), event.getPhone(), event.getLicense()));
        LOG.info("DriverCreated: {}", event.getId());

    }

    @EventHandler
    public void on(DriverDeletedEvent event) {
        LOG.info("Deleting driver: {}", event.getId());
        driverRepository.delete(event.getId());
        LOG.info("Driver deleted: {}", event.getId());
    }

    @EventHandler
    public void on(DriverAvailabilityChangedEvent event) {
        LOG.info("Updating driver availability: {}", event.getId());
        Driver driver = driverRepository.findOne(event.getId());
        driver.setAvailable(event.isAvailable());
        driverRepository.save(driver);
        LOG.info("Driver availability updated: {}", event.getId());
    }
}
