package org.aitesting.microservices.driver.query.service.repositories;

import org.aitesting.microservices.driver.query.domain.models.Driver;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface DriverRepository extends MongoRepository<Driver, UUID> {
}
