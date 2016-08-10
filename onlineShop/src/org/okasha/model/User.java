package org.okasha.model;

import org.okasha.databaseConnection.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User {
	private String Name, Email, Address, MobileNo, Password;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getMobileNo() {
		return MobileNo;
	}

	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public boolean insertUser() {
		mySQLConnection conc = new mySQLConnection();
		boolean f = conc
				.execute("INSERT INTO `OnlineShop`.`User`(`Email`,`Name`,`Mobile_No`,`Address`, `Password`)VALUES ('"
						+ Email + "', '" + Name + "', '" + MobileNo + "', '" + Address + "', '" + Password + "')");
		conc.close();
		return f;
	}

	public boolean getUser() {
		boolean isExisted = false;
		try {
			mySQLConnection op = new mySQLConnection();
			Statement stmt = op.getCon().createStatement();
			ResultSet user = stmt.executeQuery("SELECT * FROM `OnlineShop`.`User` WHERE `Name` = '" + Name
					+ "' AND `Password` = '" + Password + "' ");
			if (user.next()) {
				Email = user.getString("Email");
				Name = user.getString("Name");
				MobileNo = user.getString("Mobile_No");
				Address = user.getString("Address");
				Password = user.getString("Password");
				isExisted = true;
			}
			user.close();
			stmt.close();
			op.close();
		} catch (SQLException ex) {
			Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
		} 
		return isExisted;
	}
	public boolean getAllUsers() {
		mySQLConnection conc = new mySQLConnection();
		boolean f = conc.execute("SELECT * FROM User");
		
		conc.close();
		return f;
	}
}
