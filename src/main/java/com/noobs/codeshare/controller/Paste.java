package com.noobs.codeshare.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.noobs.codeshare.dao.SourceCodeDAO;
import com.noobs.codeshare.model.SourceCode;

@WebServlet("/paste")
public class Paste extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in paste controller");
		SourceCodeDAO source_code_dao = new SourceCodeDAO();
		try {
			if (request.getParameterMap().containsKey("i")) {
				int id = Integer.parseInt(request.getParameter("i"));
				SourceCode source_code_details = source_code_dao.getDetailsByID(id);

				request.setAttribute("details", source_code_details);
				RequestDispatcher rd = request.getRequestDispatcher("views/show_source.jsp");
				rd.forward(request, response);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
