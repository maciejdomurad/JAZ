<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <meta http-equiv="content-type" content="text/html"; charset="UTF-8">
    <title>rankomat</title>
</head>

<body>
<form action="/harmonogram" method="post">
    <fieldset>
        <legend><h1 align="center">Rankomat</h1></legend>
        <table>
            <tr><td>Kwota: </td><td><input type="number" step=".01" min="100" id="LoanAmount" name="LoanAmount" required /></tr>
            <tr><td>Oprocentowanie: </td><td><input type="number" step=".01" max="20" id="InterestRate" name="InterestRate" required /></td></tr>
			<tr><td>Ilość rat: </td><td><input type="number" min="3" id="PaymentNumber" name="PaymentNumber" required /></td></tr>
            <tr><td>Opłata stała: </td><td><input type="number" step=".01" id="Fee" name="Fee" required /></td></tr>
            <tr><td>Rodzaj rat: </td><td><select id="PaymentType" name="PaymentType">
            <option value="stala">Raty stałe</option>
            <option value="malejaca">Raty malejące</option>
        </select></td></tr>
            <tr><td><br></td></tr>
            <tr><td><input type="submit" value="submit"/></td></tr>
        </table>
    </fieldset>
</form>
</body>
</html>