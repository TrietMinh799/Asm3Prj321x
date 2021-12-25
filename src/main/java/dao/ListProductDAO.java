package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Product;

public class ListProductDAO {

	// return the list of products by product name
	public List<Product> search(String characters) throws Exception {

		List<Product> list = new ArrayList<>();
		DBContext dbContext = new DBContext();

		String sql = "select * from Products where LOWER(product_name) like'%" + characters.toLowerCase() + "%'";

		if (characters.equals("")) {
			sql = "select * from Products";
		}

		Connection connection = dbContext.getConnection();

		Statement statement = connection.createStatement();
		ResultSet rSet = statement.executeQuery(sql);

		while (rSet.next()) {
			Product product = new Product(rSet.getInt(1), rSet.getString(2), rSet.getString(3), rSet.getFloat(4),
					rSet.getString(5), rSet.getString(6), rSet.getString(7));
			list.add(product);
		}

		connection.close();

		return list;
	}

	// get the products
	public Product getProduct(String characters) throws Exception {
		Product product = null;
		DBContext dbContext = new DBContext();
		String sql = "select * from Products where product_id like '%" + characters + "%'";

		try {
			Connection connection = dbContext.getConnection();

			Statement statement = connection.createStatement();
			ResultSet rSet = statement.executeQuery(sql);
			
			while (rSet.next()) {
				product = new Product(rSet.getInt(1), rSet.getString(2), rSet.getString(3), rSet.getFloat(4),
						rSet.getString(5), rSet.getString(6), rSet.getString(7));

			}
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return product;
	}

}
