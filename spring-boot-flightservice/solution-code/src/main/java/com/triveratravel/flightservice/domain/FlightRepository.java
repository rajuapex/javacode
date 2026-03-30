package com.triveratravel.flightservice.domain;
/**
 * <p>
 * This component and source code may be used for instructional and evaluation
 * purposes only. No part of this component or its source code may be sold,
 * transferred, or publicly posted, nor may it be used in a commercial or
 * production environment, without the express written consent of the Trivera
 * Technologies, LLC.
 * <p>
 * Copyright (c) 2021 Trivera Technologies, LLC. http://www.triveratech.com
 *
 * 
 * </p>
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "departures")
public interface FlightRepository extends JpaRepository<Flight, Long> {
}
