package com.iotengine.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 
 * @author amiyakumar.m
 *
 *         Encapsulate DB Connection logic or else we can go for hibernate or
 *         any ORM layer as well.
 */

public class ConnectionUtil {
	
	protected ConnectionUtil() {

	}

	/**
	 * @return Connection
	 */
	public static Connection getConnection() {

		return null;
	}

	public static void cleanup(Connection con, Statement ps, ResultSet rs) {
		try {
			if (con != null && !con.isClosed())
				con.close();
			if (ps != null && !ps.isClosed())
				con.close();
			if (rs != null && !rs.isClosed())
				con.close();
		} catch (Exception e) {
		}
	}
}
