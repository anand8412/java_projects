package com.jspserv.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jspserv.model.User;

public class UserDAO implements IUserDAO {

	@Override
	public void insert(User user) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection conn = getConnection();
		try {
			stmt = conn.prepareStatement("insert into user (firstname,lastname,age,gender,isMarried) values(?,?,?,?,?)");
			stmt.setString(1, user.getFirstname());
			stmt.setString(2, user.getLastname());
			stmt.setInt(3, user.getAge());
			stmt.setString(4, user.getGender());
			stmt.setString(5, user.getIsMarried());
			stmt.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) {
					sqlEx.printStackTrace();
				}

				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
					sqlEx.printStackTrace();
				}
				stmt = null;
			}
		}

	}

	@Override
	public void delete(int userId) {

		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection conn = getConnection();
		try {
			stmt = conn.prepareStatement("delete from user where userid=?");
			stmt.setInt(1, userId);
			stmt.execute();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) {
					sqlEx.printStackTrace();
				}

				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
					sqlEx.printStackTrace();
				}
				stmt = null;
			}
		}

	}

	@Override
	public void update(User user) {

		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection conn = getConnection();
		try {
			stmt = conn.prepareStatement(
					"update user set firstname =?,lastname=?,age=?,gender=?,isMarried=? where userid=?");
			stmt.setString(1, user.getFirstname());
			stmt.setString(2, user.getLastname());
			stmt.setInt(3, user.getAge());
			stmt.setString(4, user.getGender());
			stmt.setString(5, user.getIsMarried());
			stmt.setInt(6, user.getUserId());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) {
					sqlEx.printStackTrace();
				}

				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
					sqlEx.printStackTrace();
				}
				stmt = null;
			}
		}

	}

	@Override
	public User getUser(int userId) {

		User user = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection conn = getConnection();
		try {
			stmt = conn.prepareStatement("select * from user where userid=?");
			stmt.setInt(1, userId);
			rs = stmt.executeQuery();
			user = new User();
			if (rs.next()) {
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setAge(rs.getInt("age"));
				user.setIsMarried(rs.getString("isMarried"));
				user.setUserId(rs.getInt("userid"));
				user.setGender(rs.getString("gender"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) {
					sqlEx.printStackTrace();
				}

				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
					sqlEx.printStackTrace();
				}
				stmt = null;
			}
		}

		return user;

	}

	@Override
	public User[] getUsers() {

		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection conn = getConnection();
		User user = null;
		int empCount = 0;
		User[] users = null;
		try {
			stmt = conn.prepareStatement("select count(*) from user");
			rs = stmt.executeQuery();
			if (rs.next()) {
				empCount = rs.getInt(1);
			}
			users = new User[empCount];
			conn.close();
			stmt.close();
			rs.close();

			conn = getConnection();
			stmt = conn.prepareStatement("select * from user");
			rs = stmt.executeQuery();
			
			int i = 0;
			while (rs.next()) {
				user = new User();
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setAge(rs.getInt("age"));
				user.setIsMarried(rs.getString("isMarried"));
				user.setUserId(rs.getInt("userid"));
				user.setGender(rs.getString("gender"));
				users[i] = user;
				i++;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) {
					sqlEx.printStackTrace();
				}

				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
					sqlEx.printStackTrace();
				}
				stmt = null;
			}
		}

		return users;

	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost/ecomm?" + "user=root&password=root");
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
