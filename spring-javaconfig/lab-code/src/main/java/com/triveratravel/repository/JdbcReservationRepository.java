package com.triveratravel.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.triveratravel.model.Reservation;

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

public class JdbcReservationRepository implements ReservationRepository {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Reservation> findAll() {
		final String SQL = "SELECT * FROM RESERVATIONS";
		RowMapper<Reservation> rowMapper = (rs, rowNum) -> {
			Reservation reservation = new Reservation();
			reservation.setId(rs.getInt("ID"));
			reservation.setArrivalDate(rs.getDate("ARRIVAL_DATE").toLocalDate());
			reservation.setNameOnReservation(rs.getString("NAME"));
			reservation.setNumberOfNights(rs.getInt("NIGHTS"));

			return reservation;
		};
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Reservation> reservations = jdbcTemplate.query(SQL, rowMapper);
		return reservations;
	}

}
