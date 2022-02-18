package main.java.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.model.KeySwitch;

/**
 * Servlet implementation class EditKeyServlet
 */
@WebServlet("/editKeyServlet")
public class EditKeyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditKeyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response); // Delete Me
		
		KeySwitchHelper key = new KeySwitchHelper();
		
		String color = request.getParameter("color");
		String operatingForce = request.getParameter("operatingForce");
		String tactile = request.getParameter("tactile");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		KeySwitch keyToUpdate = key.searchForItemById(tempId);
		keyToUpdate.setColor(color);
		keyToUpdate.setOperatingForce(Integer.parseInt(operatingForce));
		keyToUpdate.setTactile(Boolean.parseBoolean(tactile));
		
		key.updateItem(keyToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllKeysServlet").forward(request, response);
		
	}

}
