package org.aitesting.microservices.driverquery.unit;

import static org.mockito.Mockito.*;

import java.util.UUID;
import org.aitesting.microservices.driver.common.events.DriverAvailabilityChangedEvent;
import org.aitesting.microservices.driver.common.events.DriverCreatedEvent;
import org.aitesting.microservices.driver.common.events.DriverDeletedEvent;
import org.aitesting.microservices.driver.query.domain.eventhandlers.DriverEventHandler;
import org.aitesting.microservices.driver.query.domain.models.Driver;
import org.aitesting.microservices.driver.query.service.repositories.DriverRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DriverEventHandlerUnitTests {

    @InjectMocks
    private DriverEventHandler driverEventHandler = new DriverEventHandler();

    @Mock
    private static DriverRepository driverRepository;

    @Mock
    private static DriverCreatedEvent driverCreatedEvent;

    @Mock
    private static DriverDeletedEvent driverDeletedEvent;

    @Mock
    private static DriverAvailabilityChangedEvent driverAvailabilityChangedEvent;

    @Mock
    private static Driver driver;

    @Before
    public void setUp() {
        when(driverRepository.findOne(any(UUID.class))).thenReturn(driver);
    }

    @Test
    public void onDriverCreatedEvent_SaveIsCalled() {
        //arrange

        //act
        driverEventHandler.on(driverCreatedEvent);

        //assert
        verify(driverRepository, times(1)).save(any(Driver.class));
    }

    @Test
    public void onDriverDeletedEvent_DeleteIsCalled() {
        //arrange

        //act
        driverEventHandler.on(driverDeletedEvent);

        //assert
        verify(driverRepository, times(1)).delete(any(UUID.class));
    }

    @Test
    public void onDriverAvailabilityChangedEvent_FindOneIsCalled() {
        //arrange

        //act
        driverEventHandler.on(driverAvailabilityChangedEvent);

        //assert
        verify(driverRepository, times(1)).findOne(any(UUID.class));
    }

    @Test
    public void onDriverAvailabilityChangedEvent_SaveIsCalled() {
        //arrange

        //act
        driverEventHandler.on(driverAvailabilityChangedEvent);

        //assert
        verify(driverRepository, times(1)).save(any(Driver.class));
    }
}
