package com.triveratravel.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.triveratravel.repository.JdbcReservationRepository;
import com.triveratravel.repository.ReservationRepository;

/**
 * <p>
 * This component and its source code representation are copyright protected and
 * proprietary to Trivera Technologies, LLC., Worldwide
 *
 * This component and source code may be used for instructional and evaluation
 * purposes only. No part of this component or its source code may be sold,
 * transferred, or publicly posted, nor may it be used in a commercial or
 * production environment, without the express written consent of the Trivera
 * Technologies, LLC.
 *
 * Copyright (c) 2023 Trivera Technologies, LLC. http://www.triveratech.com
 * </p>
 * 
 * 
 */
@Configuration
@ConditionalOnClass(name = "org.apache.derby.jdbc.EmbeddedDriver")
public class RepositoryConfig {

	@Bean
	ReservationRepository reservationRepository() {
		JdbcReservationRepository repository = new JdbcReservationRepository();
		repository.setDataSource(dataSource());
		return repository;
	}

	@Bean
	DataSource dataSource() {
		EmbeddedDatabase dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.DERBY)
				.ignoreFailedDrops(true).addScript("ReservationDDL.sql").addScripts("ReservationData.sql").build();
		return dataSource;
	}
}
