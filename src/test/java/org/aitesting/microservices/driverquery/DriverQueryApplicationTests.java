package org.aitesting.microservices.driverquery;

import org.aitesting.microservices.driver.query.DriverQueryApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Profile("test")
@SpringBootTest(classes = DriverQueryApplication.class)
public class DriverQueryApplicationTests {

    @Test
    public void contextLoads() {
    }
}
