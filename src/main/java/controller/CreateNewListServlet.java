package main.java.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.model.*;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		KeySwitchHelper ksh = new KeySwitchHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: " + listName);
		
		String creatorName = request.getParameter("creatorName");
		String[] selectedKeys = request.getParameterValues("allKeysToAdd");
		List<KeySwitch> selectedKeysInList = new ArrayList<KeySwitch>();
		if (selectedKeys != null && selectedKeys.length > 0) {
			for(int i = 0; i < selectedKeys.length; i++) {
				System.out.println(selectedKeys[i]);
				KeySwitch c = ksh.searchForItemById(Integer.parseInt(selectedKeys[i]));
				selectedKeysInList.add(c);
			}
		}
		Creator creator = new Creator(creatorName);
		ListDetails list = new ListDetails(listName, creator);
		list.setListOfKeys(selectedKeysInList);
		ListDetailsHelper ldh = new ListDetailsHelper();
		ldh.insertNewListDetails(list);
		
		System.out.println("Success!");
		System.out.println(list.toString());
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
