package io.zilker.zbuy.utility;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnection {

	InitialContext initialContext;
	Context environmentContext;
	private DataSource dataSource;

	public DBConnection() {
		try {

			initialContext = new InitialContext();
			environmentContext = (Context) initialContext.lookup("java:/comp/env");
			this.dataSource = (DataSource) environmentContext.lookup("zbuy_db");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DataSource getDataSource() {

		return this.dataSource;
	}
}
