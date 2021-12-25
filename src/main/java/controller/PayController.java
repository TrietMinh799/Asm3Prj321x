package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrdersDao;
import model.Cart;
import model.Orders;

public class PayController extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        try {
            HttpSession session = req.getSession(true);

            if(session.getAttribute("cart") == null) {
            }

            OrdersDao dao = new OrdersDao();
            Cart cart  = (Cart) session.getAttribute("cart");
            String username = req.getParameter("name");
            String discount = req.getParameter("discount");
            String address = req.getParameter("address");
            Orders d = new Orders(username, 2, discount, address, "", null);
            dao.insertOrder(d, cart);
            resp.sendRedirect("/index");;
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }
    
}
