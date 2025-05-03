package com.quizServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class questionServlet
 */
@WebServlet("/question")
public class questionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// String array for questions
    protected String[] questions = {
    		"Which method is used to get a parameter from a request?",
    		"Which HTTP method appends data in the URL?",
    		"Which interface provides information about servlet's environment across web page ?",
    		"Which object is used to store data across multiple requests?",
    		"Which annotation is used to define a servlet?",
    		"Which method forwards a request to another servlet?",
    		"Which method is used to redirect to a different URL?",
    		"Where are cookies stored – client or server?",
    		"What object is used to write output to the web page?",
    		"Which method handles form submission securely – GET or POST?"	
    };
    
    // String array for option 1 of answers
    protected String[] ansSet1 = {
    	"getAttribute()",
    	"GET",
    	"ServletConfig",
    	"Session",
    	"@URL",
    	"forward()",
    	"forward()",
    	"Client",
    	"PrintWriter",
    	"POST"
    };
    
    // String array for option 2 of answers
    protected String[] ansSet2 = {
    		"getParameter()",
    		"POST",
    		"ServletContext",
    		"Network",
    		"@WebServlet",
    		"sendRedirect()",
    		"sendRedirect()",
    		"Server",
    		"FileWriter",
    		"GET"
    };
    
    // This method would show question based on qNo of the current Session
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("name");
		int count = (int) session.getAttribute("qNo");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		
		out.println("<head>");
		out.println("<title>Quiz Questions</title>");
		out.println("<link rel='icon' href='https://files.codingninjas.in/article_images/servlet-interview-questions-1-1655563072.webp' type='image/x-icon'>");
		out.println("<link href=\"styles.css\" type = \"text/css\" rel = \"Stylesheet\">");
		out.println("</head>");
		
		out.println("<body>");
		
		out.println("<h3 class=\"ee\"> \' <strong>"+username+"</strong> is now attempting Quiz \'</h3>");
		
		out.println("<div class = 'question'>");
		
		out.println("<form action=\"question\" method=\"post\">"); // calls POST method of itself 
		out.println("<p>" + questions[count - 1] + "</p>");

		out.println("<br/><input class='rd' type='radio' id='ans1' name='latestAnswer' value='" + ansSet1[count - 1] + "' required>");
		out.println("<label for='ans1'>" + ansSet1[count - 1] + "</label>");

		out.println("<br/><input class='rd' type='radio' id='ans2' name='latestAnswer' value='" + ansSet2[count - 1] + "'>");
		out.println("<label for='ans2'>" + ansSet2[count - 1] + "</label>");

		out.println("<br/><input class='formButton' type='submit'>");
		out.println("</form>");

		out.println("</div>");
		
		out.println("</body>");
		out.println("</html>");
	}

	// Stores the answer of user for the session, calls GET of itself for next question and redirects to result on completion.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int getCount = (int)session.getAttribute("qNo");
		session.setAttribute("qNo"+getCount, request.getParameter("latestAnswer"));
		
		getCount++;
		
		if(getCount>questions.length) {
			response.sendRedirect("result");		
		}
		else {
			session.setAttribute("qNo", getCount);
			response.sendRedirect("question");
		}
	}

}
