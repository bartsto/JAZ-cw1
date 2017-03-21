<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content=Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="hello" method="post">
<label>Imie: <input type="text" id="name" name="name"/></label> <br> <br>
<label>Wnioskowana kwota kredytu: <input type="text" id="kwotakredytu" name="kwotakredytu"/></label> <br><br>
<label>Ilosc rat w miesiacach: <input type="text" id="iloscrat" name="iloscrat"/></label> <br> <br>
<label>Oprocentowanie [od 0.1%]: <input type="text" id="oprocentowanie" name="oprocentowanie"/></label> <br><br>
<label>Rodzaj rat: <input type="radio" id="rodzajrat" name="rodzajrat" value="malejaca" checked/>Malejaca
					<input type="radio" id="rodzajrat"  name="rodzajrat" value="stala" />Stala</label> <br><br>
<input type="submit" value="wyslij"/> <br>
</form>
</body>
</html>