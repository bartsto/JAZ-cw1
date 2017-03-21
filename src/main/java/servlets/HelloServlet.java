package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	super.doPost(req, resp);
		String name = req.getParameter("name");
		String kwotakredytu = req.getParameter("kwotakredytu");
		String iloscrat = req.getParameter("iloscrat");
		String oprocentowanie = req.getParameter("oprocentowanie");
		String rodzajrat = req.getParameter("rodzajrat");
		if(name==null || name.equals("")
			||	kwotakredytu==null || kwotakredytu.equals("") 
			||	iloscrat==null || iloscrat.equals("")
			||	oprocentowanie==null || oprocentowanie.equals("")
			||	kwotakredytu==null || kwotakredytu.equals(""))
		{
			resp.sendRedirect("/");
		}
		resp.setContentType("text/html");
		resp.getWriter().println("<table border=\"1\"><tr><th> Imie:" + name
				+ "</th><th> Wnioskowana kwota kredytu:" + kwotakredytu
				+ "</th><th> Ilosc rat:" + iloscrat
				+ "</th><th> Oprocentowanie:" + oprocentowanie
				+ "</th><th> Rodzaj rat:" + rodzajrat
				+ "</th></tr></table><br>");
		
		
		double kwotakredytu1 = Double.parseDouble(req.getParameter("kwotakredytu")); //konwersja string na double
		double iloscrat1 = Double.parseDouble(req.getParameter("iloscrat"));
		double oprocentowanie1 = Double.parseDouble(req.getParameter("oprocentowanie"));

		
		double saldo = Math.round((kwotakredytu1)*100.0)/100.0;  //zaokr¹glenie double do dwoch miejsc po przecinku
		double kwota_odsetek = Math.round((saldo*(oprocentowanie1/100)*100.0))/100.0;
		
			
		if (rodzajrat.equals("malejaca")) {
			
			double rata_kapitalowa = Math.round((kwotakredytu1/iloscrat1)*100.0)/100.0;
		
			resp.getWriter().println("<table border=\"1\"><tr><th>Nr raty</th>"
					+ "<th>Saldo poczatkowe</th><th>Kwota kapita³u</th><th>Kwota odsetek</th>"
					+ "<th>Calkowita kwota raty</th></tr>"
					+ "<tr><th>" + 1 + "</th><th>" + saldo + "</th><th>" + rata_kapitalowa
					+ "</th><th>" + kwota_odsetek + "</th><th>" 
					+ (rata_kapitalowa + kwota_odsetek)
					+ "</table>");
			if (iloscrat1>1){
				for (int i=2; i<=iloscrat1; i++){
					saldo = Math.round((saldo - rata_kapitalowa)*100.0)/100.0;
					kwota_odsetek = Math.round((saldo*(oprocentowanie1/100)*100.0))/100.0;  
				resp.getWriter().println("<table border=\"1\"><tr><th>Nr raty</th>"
						+ "<th>Saldo poczatkowe</th><th>Kwota kapita³u</th><th>Kwota odsetek</th>"
						+ "<th>Calkowita kwota raty</th></tr>"
						+ "<tr><th>" + i + "</th><th>" + saldo + "</th><th>" + rata_kapitalowa
						+ "</th><th>" + kwota_odsetek + "</th><th>" 
						+ Math.round((rata_kapitalowa + kwota_odsetek)*100.0)/100.0
						+ "</table>");
				}
				
			}
		}
		
		else {			
			double rrk = kwotakredytu1*(oprocentowanie1/100)/(1-(Math.pow((1+(oprocentowanie1/100)),(-(iloscrat1)))));
			    //  rrk = rowna rata kredytu -> calkowita kwota raty
			rrk = Math.round(rrk*100.0)/100.0;
			double rata_kapitalowa = Math.round((rrk - kwota_odsetek)*100.0)/100.0;
			resp.getWriter().println("<table border=\"1\"><tr><th>Nr raty</th>"
					+ "<th>Saldo poczatkowe</th><th>Kwota kapita³u</th><th>Kwota odsetek</th>"
					+ "<th>Calkowita kwota raty</th></tr>"
					+ "<tr><th>" + 1 + "</th><th>" + saldo + "</th><th>" + rata_kapitalowa
					+ "</th><th>" + kwota_odsetek + "</th><th>" 
					+ rrk
					+ "</table>");
			if (iloscrat1>1){
				for (int i=2; i<=iloscrat1; i++){
					saldo = Math.round((saldo - rata_kapitalowa)*100.0)/100.0;
					kwota_odsetek = Math.round((saldo*(oprocentowanie1/100)*100.0))/100.0;
					rata_kapitalowa = Math.round((rrk - kwota_odsetek)*100.0)/100.0;
				resp.getWriter().println("<table border=\"1\"><tr><th>Nr raty</th>"
						+ "<th>Saldo poczatkowe</th><th>Kwota kapita³u</th><th>Kwota odsetek</th>"
						+ "<th>Calkowita kwota raty</th></tr>"
						+ "<tr><th>" + i + "</th><th>" + saldo + "</th><th>" + rata_kapitalowa
						+ "</th><th>" + kwota_odsetek + "</th><th>" 
						+ rrk
						+ "</table>");
				}
				
			}
		}		
		}
}
