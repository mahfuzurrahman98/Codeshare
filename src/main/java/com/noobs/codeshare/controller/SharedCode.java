package com.noobs.codeshare.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import com.noobs.codeshare.dao.SourceCodeDAO;
import com.noobs.codeshare.model.SourceCode;

@WebServlet("/shared")
public class SharedCode extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		SourceCodeDAO source_code_dao = new SourceCodeDAO();
		ArrayList<SourceCode> source_list = source_code_dao.getSharedSourceByUser((int) session.getAttribute("id"));
		request.setAttribute("source_list", source_list);
		
		RequestDispatcher rd = request.getRequestDispatcher("views/shared_sources.jsp");
		rd.forward(request, response);
	}
}
