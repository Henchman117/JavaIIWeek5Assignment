package main.java.controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.model.KeySwitch;
import main.java.controller.KeySwitchHelper;

/**
 * Servlet implementation class AddKeyServlet
 */
@WebServlet("/addKeyServlet")
public class AddKeyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddKeyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String color = request.getParameter("color");
		String operatingForce = request.getParameter("operating force");
		String tactile = request.getParameter("tactile");
		
		KeySwitch key = new KeySwitch(color,Integer.parseInt(operatingForce),Boolean.parseBoolean(tactile));
		KeySwitchHelper keyHelper = new KeySwitchHelper();
		keyHelper.insertKey(key);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
