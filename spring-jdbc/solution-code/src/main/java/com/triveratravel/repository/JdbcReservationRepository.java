package com.triveratravel.repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.triveratravel.model.PaymentStatus;
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
@Repository
public class JdbcReservationRepository implements ReservationRepository {
	final String INSERT_SQL = "INSERT INTO RESERVATIONS (NAME, ARRIVAL_DATE, NIGHTS, STATUS) VALUES (?,?,?,?) ";
	final String SELECT_SQL = "SELECT * FROM RESERVATIONS";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void addReservation(Reservation reservation) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		PreparedStatementCreator psc = connection -> {
			PreparedStatement stmt = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, reservation.getNameOnReservation());
			stmt.setDate(2, Date.valueOf(reservation.getArrivalDate()));
			stmt.setInt(3, reservation.getNumberOfNights());
			stmt.setString(4, reservation.getPaymentStatus().toString());
			return stmt;
		};
		jdbcTemplate.update(psc, keyHolder);
		int id = keyHolder.getKey().intValue();
		reservation.setId(id);
	}

	public List<Reservation> findAll() {
		RowMapper<Reservation> rowMapper = (rs, rowNum) -> {
			Reservation reservation = new Reservation();
			reservation.setId(rs.getInt("ID"));
			reservation.setArrivalDate(rs.getDate("ARRIVAL_DATE").toLocalDate());
			reservation.setNameOnReservation(rs.getString("NAME"));
			reservation.setNumberOfNights(rs.getInt("NIGHTS"));
			reservation.setPaymentStatus(PaymentStatus.valueOf(rs.getString("STATUS")));
			return reservation;
		};
		List<Reservation> reservations = jdbcTemplate.query(SELECT_SQL, rowMapper);
		return reservations;
	}

}
