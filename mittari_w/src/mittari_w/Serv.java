package mittari_w;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Serv")
public class Serv extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		URL url = new URL("http://tuftuf.gambitlabs.fi/feed.txt");
		Scanner sc = new Scanner(url.openStream(), StandardCharsets.UTF_8.toString());
		StringBuilder body = new StringBuilder();
		
		body.append(sc.nextLine() + "<br>");
		body.append("<hr>");
		
			while (sc.hasNextLine())
			{
			//append lines and add linebreaks
			body.append(sc.nextLine() + "<br>"); 
			}
		sc.close();
		//converts to string and sends to ${content} at index.jsp 
		request.setAttribute("content", body.toString());
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}
}
