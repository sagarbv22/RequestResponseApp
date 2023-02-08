package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LocalDateTime date = LocalDateTime.now();

		PrintWriter out = response.getWriter();

		int hour = date.getHour();
		String msg = "";

		if (hour < 12)
			msg += "GoodMorning";
		else if (hour < 16)
			msg += "GoodAfterNoon";
		else if (hour < 20)
			msg += "GoodEvening";
		else
			msg += "GoodNight";

		out.println("<h1 style='color:blue; text-align:center;'>Hello Welcome to Servlet Coding..</h1>");
		out.println("<h1>Greeting from the Server::" + msg + "</h1>");
		out.println("<h1>Current Request Object address::" + request.hashCode() + "</h1>");
		out.println("<h1>Current Response Object address::" + response.hashCode() + "</h1>");
		out.println("<h1>Current Servlet Object address::" + this.hashCode() + "</h1>");
		out.println("<h1>Current Request Thread Object address::" + Thread.currentThread().hashCode() + "</h1>");
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.close();

	}

}
