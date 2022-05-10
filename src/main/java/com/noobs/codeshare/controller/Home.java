package com.noobs.codeshare.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.noobs.codeshare.dao.LanguageDAO;
import com.noobs.codeshare.dao.UserDAO;
import com.noobs.codeshare.model.Language;
import com.noobs.codeshare.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		LanguageDAO lang_dao = new LanguageDAO();
		UserDAO user_dao = new UserDAO();
		ArrayList<Language> languages = lang_dao.getAllLanguages();
		ArrayList<User> users = new ArrayList<User>();

		request.setAttribute("languages", languages);
		request.setAttribute("poster", session.getAttribute("username"));
		request.setAttribute("cur_user", session.getAttribute("id") == null ? 0 : (int) session.getAttribute("id"));

		if (session.getAttribute("id") != null) {
			users = user_dao.getAllUsers((int) session.getAttribute("id"));
			request.setAttribute("share_users", users);
		}

		RequestDispatcher rd = request.getRequestDispatcher("views/home.jsp");
		rd.forward(request, response);
	}
}
