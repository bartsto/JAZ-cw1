package georgeusweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Mockito;

import servlets.HelloServlet;

public class TestHelloServlet extends Mockito{

@Test
public void servlet_should_not_greet_the_user_if_the_kwota_kredytu_is_null() throws IOException, ServletException {
	HttpServletRequest req = mock(HttpServletRequest.class);
	HttpServletResponse resp = mock(HttpServletResponse.class);
	HelloServlet servlet = new HelloServlet();
	PrintWriter writer = mock(PrintWriter.class);
	when(resp.getWriter()).thenReturn(writer);
	when(req.getParameter("name")).thenReturn(null);
	
	servlet.doPost(req, resp);
	
	verify(resp).sendRedirect("/");
}

@Test
public void servlet_should_not_greet_the_user_if_the_kwota_kredytu_is_empty() throws IOException, ServletException {
	HttpServletRequest req = mock(HttpServletRequest.class);
	HttpServletResponse resp = mock(HttpServletResponse.class);
	PrintWriter writer = mock(PrintWriter.class);
	when(resp.getWriter()).thenReturn(writer);
	
	HelloServlet servlet = new HelloServlet();
	
	when(req.getParameter("name")).thenReturn("");
	
	servlet.doPost(req, resp);
	
	verify(resp).sendRedirect("/");
}
	
}
