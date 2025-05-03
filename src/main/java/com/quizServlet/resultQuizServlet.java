package com.quizServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/result")
public class resultQuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	// Calculates the result, ends the session and gives an option to go back to home page 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int score = 0;
		HttpSession session = request.getSession();
		
		String username = (String) session.getAttribute("name");
		
		if(((String)session.getAttribute("qNo1")).equals("getParameter()")) {
			score++;
		}
		if(((String)session.getAttribute("qNo2")).equals("GET")) {
			score++;
		}
		if(((String)session.getAttribute("qNo3")).equals("ServletContext")) {
			score++;
		}
		if(((String)session.getAttribute("qNo4")).equals("Session")) {
			score++;
		}
		if(((String)session.getAttribute("qNo5")).equals("@WebServlet")) {
			score++;
		}
		if(((String)session.getAttribute("qNo6")).equals("forward()")) {
			score++;
		}
		if(((String)session.getAttribute("qNo7")).equals("sendRedirect()")) {
			score++;
		}
		if(((String)session.getAttribute("qNo8")).equalsIgnoreCase("Client")) {
			score++;
		}
		if(((String)session.getAttribute("qNo9")).equals("PrintWriter")) {
			score++;
		}
		if(((String)session.getAttribute("qNo10")).equalsIgnoreCase("POST")) {
			score++;
		}
		boolean pass = (score>=6);
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		
		out.println("<html>");
		
		out.println("<head>");
		out.println("<title>Quiz Result</title>");
		out.println("<link rel='icon' href='https://files.codingninjas.in/article_images/servlet-interview-questions-1-1655563072.webp' type='image/x-icon'>");
		out.println("<link href=\"styles.css\" type = \"text/css\" rel = \"Stylesheet\">");
		out.println("</head>");
		
		out.println("<body>");
		out.println("<h1 class='hdr'>Result</h1>");
		
		out.println("<div class='resultBox'>");
		if(pass==true) {
			out.println("<p> Congratulations "+username+" !!</p>");
		}
		else {
			out.println("<p> Oops "+username+", Better Luck Next Time !!</p>");
		}
		out.println("<p> You Scored "+score+"/10 </p>");
		out.println("<br/><a href = 'quizApp.html'><button class='toHome'> Go To Home Page</button></a>");
		out.println("</div>");
		
		out.println("</body>");
		
		out.println("</html>");
		
		session.invalidate();
	}

}
