<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Perguntas</title>
</head>
<body>

    <form method="post" action="servletCadastraPergunta.do">
       <label>Pergunta: </label><input type="text" name="txtPergunta" maxlength="255" size="150"><br><br>

       <label>Nível: </label><input type="number" name="txtNivel"><br><br>

       <label>Alternativa 1: </label><input type="text" name="txtAlternativa1" size="50"><br><br>
       <label>Alternativa 2: </label><input type="text" name="txtAlternativa2" size="50"><br><br>
       <label>Alternativa 3: </label><input type="text" name="txtAlternativa3" size="50"><br><br>
       <label>Alternativa 4: </label><input type="text" name="txtAlternativa4" size="50"><br><br>

       <label>Resposta: </label><input type="number" name="txtResposta" size="10"><br><br>

       <input type="submit" value="Salvar">


    </form>
    <br>
    <label>${mensagem} </label>

</body>
</html>