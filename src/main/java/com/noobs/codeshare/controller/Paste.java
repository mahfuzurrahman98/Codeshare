package com.noobs.codeshare.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.noobs.codeshare.dao.SourceCodeDAO;
import com.noobs.codeshare.model.SourceCode;

@WebServlet("/paste")
public class Paste extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SourceCodeDAO source_code_dao = new SourceCodeDAO();
		HttpSession session = request.getSession();

		int cur_user_id = (int) session.getAttribute("id");
		int id = Integer.parseInt(request.getParameter("i"));
		SourceCode source_code_details = source_code_dao.getDetailsByID(id);
		
		request.setAttribute("details", source_code_details);
		RequestDispatcher rd = request.getRequestDispatcher("views/show_code.jsp");
		rd.forward(request, response);
	}

}
