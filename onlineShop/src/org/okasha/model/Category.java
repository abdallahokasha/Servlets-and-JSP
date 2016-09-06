package org.okasha.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.okasha.databaseConnection.mySQLConnection;

public class Category {
	private String Name;

	public void setName(String name) {
		Name = name;
	}

	public String getName(String name) {
		return name;
	}

	public boolean insertCategory() {
		mySQLConnection conc = new mySQLConnection();
		boolean f = conc.execute("INSERT INTO `OnlineShop`.`Category`(`Name`)VALUES ('" + Name + "')");
		conc.close();
		return f;
	}

	public boolean getAllCategories() {
		mySQLConnection conc = new mySQLConnection();
		boolean f = conc.execute("SELECT * FROM Category");
		conc.close();
		return f;
	}
	public boolean CategorySearch() {
		boolean isExisted = false;
		try {
			mySQLConnection op = new mySQLConnection();
			Statement stmt = op.getCon().createStatement();
			ResultSet category = stmt.executeQuery("SELECT * FROM `OnlineShop`.`Category` WHERE `Name` = '" + Name);
			if (category.next()) {
				Name = category.getString("Name");
				isExisted = true;
			}
			category.close();
			stmt.close();
			op.close();
		} catch (SQLException ex) {
			Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
		}
		return isExisted;
	}
}