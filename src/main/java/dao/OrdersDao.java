package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import context.DBContext;
import model.Cart;
import model.Orders;
import model.Product;

public class OrdersDao {

	// insert information of Order to data source, that including list of
	// products in cart (c) and information of buyer in Orders o
	public int insertOrder(Orders o, Cart c) throws Exception {
		DBContext db = new DBContext();
		Connection connection = db.getConnection();
		PreparedStatement pStatment;
		String sql = "";
		int status = 0;

		try {
			sql = "insert into Orders(user_mail, order_status, order_date, order_discount_code, order_address) values ("
					+ "?, ?, ?, ?, ?)";
			pStatment = connection.prepareStatement(sql);
			pStatment.setString(1, o.getUserMail());
			pStatment.setInt(2, 2);
			pStatment.setTimestamp(3, new java.sql.Timestamp(new java.util.Date().getTime()));
			pStatment.setString(4, o.getDiscount());
			pStatment.setString(5, o.getAddress());

			status = pStatment.executeUpdate();

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		status = 0;
		connection = db.getConnection();

		sql = "select count (*) from Orders";
		Statement stmt = connection.createStatement();
		ResultSet rSet = stmt.executeQuery(sql);
		rSet.next();
		int count = rSet.getInt(1);
		o.setOrderId(count);

		try {
			for (int i = 0; i < c.getItems().size(); i++) {
				Product p = c.getItems().get(i);

				sql = "insert into Orders_detail(order_id, product_id, amount_product, price_product) values ("
						+ "?,?,?,?)";
				pStatment = connection.prepareStatement(sql);
				pStatment.setInt(1, o.getOrderId());
				pStatment.setInt(2, p.getId());
				pStatment.setInt(3, p.getNumber());
				pStatment.setFloat(4, p.getPrice());

				status = pStatment.executeUpdate();
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
}
