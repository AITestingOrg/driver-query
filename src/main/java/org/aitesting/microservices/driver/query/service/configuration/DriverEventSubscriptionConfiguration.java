package org.aitesting.microservices.driver.query.service.configuration;

import org.aist.libs.eventsourcing.configuration.configurations.AmqpEventSubscriptionConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DriverEventSubscriptionConfiguration extends AmqpEventSubscriptionConfiguration {
}
