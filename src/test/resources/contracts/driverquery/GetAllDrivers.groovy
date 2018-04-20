package driverquery

import org.springframework.cloud.contract.spec.Contract

[
    Contract.make {
        description("When GET request for api/v1/drivers should get all drivers and 200 response")
        request {
            method 'GET'
            url "/api/v1/drivers"
        }
        response {
            status 200
        }
    }
]