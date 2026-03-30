package com.triveratravel.repository;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.stereotype.Component;

import com.triveratravel.model.PaymentStatus;

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
@Component
public class UpdateReservationQuery extends SqlUpdate {
	private static final String SQL = "UPDATE RESERVATIONS SET STATUS=? WHERE ID=?";

	@Autowired
	public UpdateReservationQuery(DataSource dataSource) {
		super(dataSource, SQL);
		declareParameter(new SqlParameter("STATUS", Types.VARCHAR));
		declareParameter(new SqlParameter("ID", Types.NUMERIC));
		compile();
	}

	public int execute(int reservationID, PaymentStatus status) {
		return update(status, reservationID);
	}

}
