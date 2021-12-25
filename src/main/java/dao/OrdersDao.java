package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

import context.DBContext;
import model.Cart;
import model.Orders;
import model.Product;

public class OrdersDao {

    // insert information of Order to data source, that including list of
    // products in cart (c) and information of buyer in Orders o
    public int insertOrder(Orders o, Cart c) throws Exception {
        DBContext context = new DBContext();
        Connection connection = context.getConnection();

        int status = 0;
        String sql = "insert into Orders(user_mail, order_status, order_date, order_discount_code, order_address) values ("
                + "?, ?, ?, ?, ?)";

        int count = 0;

        PreparedStatement pStatement = null;
        try {
            pStatement = connection.prepareStatement(sql);

            ResultSet rSet = pStatement.executeQuery();

            rSet.next();
            count = rSet.getInt(1);

        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        o.setOrderId(count);

        try {
            pStatement.setString(1, o.getUserMail());
            pStatement.setInt(2, 2);
            pStatement.setDate(3, new Date(15));
            pStatement.setString(4, o.getDiscount());
            pStatement.setString(5, o.getAddress());

            status = pStatement.executeUpdate();

            connection.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        status = 0;
        connection = context.getConnection();

        sql = "select count (*) from Orders";
        Statement statement = connection.createStatement();

        ResultSet set = statement.executeQuery(sql);

        set.next();
        try {
            for (int i = 0; i < c.getItems().size(); i++) {
                Product product = c.getItems().get(i);

                sql = "insert into Orders_detail(order_id, product_id, amount_product, price_product) values ("
                        + "?, ?, ?, ?)";

                pStatement = connection.prepareStatement(sql);
                pStatement.setInt(1, o.getOrderId());
                pStatement.setInt(2, product.getId());
                pStatement.setInt(3, product.getNumber());
                pStatement.setFloat(4, product.getPrice());

                status = pStatement.executeUpdate();
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}
