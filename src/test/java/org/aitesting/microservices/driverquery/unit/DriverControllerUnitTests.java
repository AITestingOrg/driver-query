package org.aitesting.microservices.driverquery.unit;

import static org.aitesting.microservices.driverquery.configurations.TestConstants.id1;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.aitesting.microservices.driver.query.service.controllers.DriverController;
import org.aitesting.microservices.driver.query.service.repositories.DriverRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DriverControllerUnitTests {

    @InjectMocks
    private DriverController driverController = new DriverController();

    @Mock
    private DriverRepository driverRepository;

    @Test
    public void getAllDrivers_FindAllIsCalled() {
        //arrange

        //act
        driverController.getDrivers();

        //assert
        verify(driverRepository, times(1)).findAll();
    }

    @Test
    public void getDriver_FindOneIsCalled() {
        //arrange

        //act
        driverController.getDriver(id1);

        //assert
        verify(driverRepository, times(1)).findOne(id1);
    }

    @Test
    public void getAvailableDriver_FindByAvailableIsCalled() {
        //arrange

        //act
        driverController.getAvailableDriver();

        //assert
        verify(driverRepository, times(1)).findByAvailable(true);
    }

    @Test
    public void getAllAvailableDrivers_FindByAvailableIsCalled() {
        //arrange

        //act
        driverController.getAllAvailableDrivers();

        //assert
        verify(driverRepository, times(1)).findByAvailable(true);
    }
}
