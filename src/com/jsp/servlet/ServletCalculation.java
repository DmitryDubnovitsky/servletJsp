package com.jsp.servlet;
 
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
 
 
public class ServletCalculation extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // reading the user input
    	String result=null;
        int type = Integer.parseInt(request.getParameter("type"));
        String expression = request.getParameter("expression");
        PrintWriter out = response.getWriter();
        switch(type)
		{
		case 10:
			result=String.valueOf(Calculation.evaluate(expression, type));
		break;
		
		case 2:
			result=Integer.toBinaryString(Calculation.evaluate(expression, type));
		break;
		case 16:
			result=Integer.toHexString(Calculation.evaluate(expression, type));
		break;
		}
        out.println (
                  "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" +" +
                      "http://www.w3.org/TR/html4/loose.dtd\">\n" +
                  "<html> \n" +
                    "</head> \n" +
                    "<body> <div align='center'> \n" +
                      "<style= \"font-size=\"12px\" color='black'\"" + "\">" +
                    "Result="+ result +
                    "</font></body> \n" +
                  "</html>" 
                );      
        }
}