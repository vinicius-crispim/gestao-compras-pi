<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Produto</title>
</head>
<body>
<h2>Formulário de Cadastro de Produto</h2>
<form:form method="POST" action="/produto/addProduto">
   <table>
    <tr>
    	<td><form:label path="nome">nome</form:label></td>
        <td><form:input path="nome" /></td>
    </tr>
    <tr>
        <td><form:label path="descricao">descricao</form:label></td>
        <td><form:input path="descricao" /></td>
    </tr>
    <tr>
        <td><form:label path="estoque">estoque:</form:label></td>
        <td><form:input path="estoque" /></td>
    </tr>
    <tr>
        <td><form:label path="quantidademin">quantidademin:</form:label></td>
        <td><form:textarea path="quantidademin" /></td>
    </tr>
    <tr>
        <td><form:label path="preço">preço:</form:label></td>
        <td><form:input path="salario" /></td>
    </tr>
</table>
</form:form>
<a href="/cliente/listaProdutos">Lista</a>

</body>
</html>