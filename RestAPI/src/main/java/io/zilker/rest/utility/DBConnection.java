package io.zilker.rest.utility;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnection {

	private DataSource dataSource;
	InitialContext initialContext;
	Context environmentContext;

	public DBConnection() {

		try {
			initialContext = new InitialContext();
			environmentContext = (Context) initialContext.lookup("java:comp/env");
			this.dataSource = (DataSource) environmentContext.lookup("zbuy_db");
		} catch (NamingException e) {

			e.printStackTrace();
		}

	
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}

}
