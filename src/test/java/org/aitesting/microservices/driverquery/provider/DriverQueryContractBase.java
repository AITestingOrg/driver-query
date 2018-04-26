package org.aitesting.microservices.driverquery.provider;

import static org.aitesting.microservices.driverquery.configurations.TestConstants.*;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.aitesting.microservices.driver.query.DriverQueryApplication;
import org.aitesting.microservices.driver.query.domain.models.Driver;
import org.aitesting.microservices.driver.query.service.repositories.DriverRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@Profile("test")
@SpringBootTest(classes = DriverQueryApplication.class)
public abstract class DriverQueryContractBase {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    DriverRepository driverRepository;

    @Before
    public void setUp() {
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
        driverRepository.deleteAll();
        Driver driverOne = new Driver(id1, fname1, lname1, address1, email1, phone1, license1);
        Driver driverTwo = new Driver(id2, fname2, lname2, address2, email2, phone2, license2);
        driverRepository.save(driverOne);
        driverRepository.save(driverTwo);
    }

    @After
    public void cleanUp() {
        driverRepository.deleteAll();
    }
}
