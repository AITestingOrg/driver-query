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
        },
        Contract.make {
            description("When a GET request with driver not in DB, should get 404")
            request {
                method 'GET'
                url 'api/v1/driver/7a7ec638-7793-4bfe-a043-1dc667d7cb19444'
            }
            response {
                status 404
            }
        },
        Contract.make {
            description("When GET request with bad string id, should get 400")
            request {
                method 'GET'
                url 'api/v1/driver/badString'
            }
            response {
                status 400
            }
        }
]