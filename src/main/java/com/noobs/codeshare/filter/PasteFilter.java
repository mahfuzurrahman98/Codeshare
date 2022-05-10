package com.noobs.codeshare.filter;

import java.io.IOException;

import com.noobs.codeshare.dao.SourceCodeDAO;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/paste")
public class PasteFilter extends HttpFilter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest _request = (HttpServletRequest) request;
		HttpServletResponse _response = (HttpServletResponse) response;
		SourceCodeDAO source_code_dao = new SourceCodeDAO();
		HttpSession session = _request.getSession();
		
		int cur_user_id = (int) session.getAttribute("id");
		
		int id = Integer.parseInt(_request.getParameter("i"));
		int visibility = source_code_dao.getVisibility(id);

		if (visibility == 1) { // public
			chain.doFilter(request, response); // go
		} else if (visibility == 2) { // protected
			if (1) {
				chain.doFilter(request, response); // go
			}else {
				_response.sendRedirect("home");
			}
		} else { // private
			if (1) {
				chain.doFilter(request, response); // go
			}else {
				_response.sendRedirect("home");
			}
		}
	}
}
