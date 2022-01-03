package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ListProductDAO;
import model.Cart;
import model.Product;

public class AddToCartController extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = -139234985545327452L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        resp.setContentType("text/html;charset=UTF-8");
        try {
            HttpSession session = req.getSession(true);
            String idd = req.getParameter("id");
            String action = req.getParameter("action");

            if(action != null && action.equalsIgnoreCase("add")) {
                if(session.getAttribute("cart") == null) {
                    session.setAttribute("cart", new Cart());
                }

                int id = Integer.parseInt(idd);
                Product p = new ListProductDAO().getProduct("" + id);
                Cart c = (Cart) session.getAttribute("cart");
                c.add(new Product(p.getId(), p.getName(), p.getDescription(), p.getPrice(), p.getSrc(), p.getType(), p.getBrand()));
            } else if(action != null && action.equalsIgnoreCase("delete")) {
				int id = Integer.parseInt(idd);
				Cart c = (Cart) session.getAttribute("cart");
				c.remove(id);
			}
			
			resp.sendRedirect("cart.jsp");

        } catch (Exception e) {
            //TODO: handle exception
            resp.getWriter().println(e); 
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }
    
}
