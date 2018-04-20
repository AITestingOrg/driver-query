package driverquery

import org.springframework.cloud.contract.spec.*
[
        Contract.make {
            description("When a GET request with a driverId is made, the driver is returned")
            request {
                method 'GET'
                url '/api/v1/driver/1f13bafe-9236-4edf-ac47-bf2f1d3caec6'
            }
            response {
                status 200
            }
        }
]