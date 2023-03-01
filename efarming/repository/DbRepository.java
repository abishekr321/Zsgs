package com.zsgs.efarming.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.zsgs.efarming.dto.Orders;
import com.zsgs.efarming.dto.Products;

public class DbRepository {
	private static DbRepository databaseAccess;
	private PreparedStatement statement;
	private static Connection connection;
	private static int farmerCount;
	private static int userCount;
	private static int productCount;

	private DbRepository() {
		statement = null;
		connection = null;
	}

	public static DbRepository getInstance() {
		if (databaseAccess == null) {
			databaseAccess = new DbRepository();
			connection = databaseAccess.executeConnection();

		}
		return databaseAccess;
	}

	private Connection executeConnection() {
		String url = "jdbc:mysql://localhost:3306/Efarming";
		String username = "root";
		String password = "Appu@321";
		try {
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String addFarmer(String userName, String userLName, String mobileNumber, String password) {
		String query = "insert into farmer values(?,?,?,?)";
		String userId = null;
		try {
			farmerCount++;
			userId = "FAR00" + farmerCount;
			statement = connection.prepareStatement(query);
			statement.setString(2, userName + " " + userLName);
			statement.setString(1, userId);
			statement.setString(3, mobileNumber);
			statement.setString(4, password);
			int val = statement.executeUpdate();
			if (val > 0) {
				return userId;
			} else {
				return null;
			}
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}

	}

	public boolean checkFarmerID(String userId, String userPassword) {
		String query = ("select * from farmer where farmerId=? and password=?");
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, userId);
			statement.setString(2, userPassword);
			ResultSet set = statement.executeQuery();
			if (set.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}
	}

	public String addUser(String userName, String userLName, String mobileNumber, String password, String address) {

		String query = "insert into users values(?,?,?,?,?)";
		String userId = null;
		try {
			userCount++;
			userId = "USE00" + userCount;
			statement = connection.prepareStatement(query);
			statement.setString(2, userName + " " + userLName);
			statement.setString(1, "USE00" + (++userCount));
			statement.setString(3, mobileNumber);
			statement.setString(4, address);
			statement.setString(5, password);
			int val = statement.executeUpdate();
			if (val > 0) {
				return userId;
			} else {
				return null;
			}
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}
	}

	public boolean checkUserID(String userId, String userPassword) {
		String query = ("select * from users where userId=? and password=?");
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, userId);
			statement.setString(2, userPassword);
			ResultSet set = statement.executeQuery();
			if (set.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}
	}

	public boolean addProducts(String productName, float quantity, float price) {
		String query = ("select * from products where productName=?");
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, productName);

			ResultSet set = statement.executeQuery();
			if (set.next()) {
				float oldQuantity = set.getFloat("quantity");
				float newQuantity = oldQuantity + quantity;
				String query2 = ("update products set quantity=?,price=? where productName=?");
				try {
					statement = connection.prepareStatement(query2);
					statement.setFloat(1, newQuantity);
					statement.setFloat(2, price);
					statement.setString(3, productName);
					int val = statement.executeUpdate();
					if (val > 0) {
						return true;
					} else {
						return false;
					}
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}

			} else {
				String query2 = ("insert into products values(?,?,?,?)");
				try {
					statement = connection.prepareStatement(query2);
					productCount++;
					String productId = "PRO00" + productCount;
					statement.setString(1, productId);
					statement.setString(2, productName);
					statement.setFloat(3, quantity);
					statement.setFloat(4, price);
					int val = statement.executeUpdate();
					if (val > 0) {
						return true;
					} else {
						return false;
					}
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}

	}

	public List<Products> getProducts() {
		List<Products> productList = new ArrayList();
		String query = ("select * from products");
		try {
			statement = connection.prepareStatement(query);
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				productList.add(new Products(set.getString("productId"), set.getString("productName"),
						set.getFloat("quantity"), set.getFloat("price")));
			}
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}

		return productList;
	}

	public boolean placeOrders(String userId, String productId, String productName, float quantity, float amount) {
		String query = ("insert into orders values(?,?,?,?,?,?)");
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, userId);
			statement.setString(2, productId);
			statement.setString(3, productName);
			statement.setFloat(4, quantity);
			statement.setFloat(5, amount);
			statement.setDate(6, Date.valueOf(LocalDate.now()));
			int val = statement.executeUpdate();
			if (val > 0) {
				String query1 = ("select * from products where productName=?");
				try {
					statement = connection.prepareStatement(query1);
					statement.setString(1, productName);
					ResultSet set = statement.executeQuery();
					if (set.next()) {
						float oldQuantity = set.getFloat("quantity");
						float newQuantity = oldQuantity - quantity;
						String query2 = ("update products set quantity=? where productName=?");
						try {
							statement = connection.prepareStatement(query2);
							statement.setFloat(1, newQuantity);
							statement.setString(2, productName);
							int val1 = statement.executeUpdate();
							if (val1 > 0) {
								return true;
							} else {
								return false;
							}
						} catch (SQLException e) {
							e.printStackTrace();
							return false;
						}

					}
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public List<Orders> getOrders(String userId) {
		List<Orders> orderList = new ArrayList();
		String query = ("select * from orders where userId=?");
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, userId);
			ResultSet set = statement.executeQuery();
			if (set.next()) {
				orderList.add(
						new Orders(set.getString("userId"), set.getString("productId"), set.getString("productName"),
								set.getFloat("quantity"), set.getFloat("price"), set.getDate("dateOfOrder")));
			}
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}

		return orderList;
	}

}
