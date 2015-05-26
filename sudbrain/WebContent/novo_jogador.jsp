<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html lang="pt-br">

    <head>
    <meta charset="utf-8">
    <title>Sudbrain</title>
    <link rel="stylesheet" type="text/css" href="_css/estilo.css"/>
    <link rel="stylesheet" type="text/css" href="_css/midias_sociais.css"/>
    <link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet' type='text/css'>
    </head>
    <script language="JavaScript" src="_javascript/funcoes.js"></script>
    <script>
    function verificaTamanhoLogin(){
    var login = document.getElementById('cLogin').value;
    var tamanho = login.length;
    if(tamanho<4){
    document.getElementById('lLogin').hidden = false;
    }else{
    document.getElementById('lLogin').hidden = true;
    }
    }
    function verificaTamanhoSenha(){
    var senha = document.getElementById('cSenha').value;
    var tamanho = senha.length;
    if(tamanho<6){
    document.getElementById('lSenha').hidden = false;
    }else{
    document.getElementById('lSenha').hidden = true;
    }
    }
    function comparaSenha(){
    var senha1 = document.getElementById('cSenha').value;
    var senha2 = document.getElementById('cSenha2').value;
    if(senha1 != senha2){
    document.getElementById('lSenha2').hidden = false;
    }else{
    document.getElementById('lSenha2').hidden = true;
    }
    }
    function verificaPreenchimento(){
    var verificador = 0;
    if(document.getElementById('cNome').value == ""){
    document.getElementById('cEnviar').hidden = false;
    verificador++;
    }if(document.getElementById('cLogin').value == ""){
    document.getElementById('cEnviar').hidden = false;
    verificador++;
    }if(document.getElementById('cSenha').value == ""){
    document.getElementById('cEnviar').hidden = false;
    verificador++;
    }if(document.getElementById('cSenha2').value == ""){
    document.getElementById('cEnviar').hidden = false;
    verificador++;
    }if(document.getElementById('cEmail').value == ""){
    document.getElementById('cEnviar').hidden = false;
    verificador++;
    }
    var senha1 = document.getElementById('cSenha').value;
    var senha2 = document.getElementById('cSenha2').value;
    if(senha1 == senha2){
    verificador++;
    }
    if(verificador==6){
        document.getElementById('cEnviar').hidden = false;
    }
    else{
        document.getElementById('cEnviar').hidden = true;
    }
    }

    function ativaBotao(){
    document.getElementById('botao-enviar').disabled = false;
    }

    </script>
    <body>

    <ul id="midias_sociais">
    <a href="https://www.facebook.com/everton.decastro.12" target="_blank"><li id="facebook"></li></a>
    <a href="https://www.linkedin.com/profile/view?id=181916977&trk=nav_responsive_tab_profile" target="_blank"><li id="linkedin"></li></a>
    <a href="https://instagram.com/evertoncastrosud/" target="_blank"><li id="instagram"></li></a>
    <a href="https://plus.google.com/u/0/+EvertondeCastrofatec/posts" target="_blank"><li id="gplus"></span></li></a>
    </ul>

    <div id="paginaHome">
    <header id="cabecalho">
    <img id="imagem-logo" src="_imagens/titulo-sudbrain.png">

    <form id="form-login" method="post" action="servletLogin.do" >
    <table id="tabela-login">
    <tr>
    <td><label class="labLogin">Login: </label></td>
    <td><input type="text" name="txtLogin" maxlength="15"></td>
    <td><label class="labLogin"> Senha: </label></td>
    <td><input type="password" name="txtSenha" maxlength="15"></td>
    <td><input id="botao-login" type="submit" value=""></td>
    </tr>
    <tr>
    <td colspan="5" id="celula-statusLogin">${statusLogin}</td>
    </tr>
    </table>
    </form>

    <nav id="menu">
    <ul>
    <li onmouseover="mudaImagem('_imagens/escrituras.png')" onmouseout="mudaImagem('_imagens/novo_jogador.png')"><a href="../sudbrain/index.jsp">Home</a></li>
    <li onmouseover="mudaImagem('_imagens/sobre.png')" onmouseout="mudaImagem('_imagens/novo_jogador.png')"><a href="../sudbrain/sobre.jsp">Sobre</a></li>
    <li onmouseover="mudaImagem('_imagens/como-jogar.png')" onmouseout="mudaImagem('_imagens/novo_jogador.png')"><a href="../sudbrain/como-jogar.jsp">Como jogar</a></li>
    <li onmouseover="mudaImagem('_imagens/ranking.png')" onmouseout="mudaImagem('_imagens/novo_jogador.png')"><a href="../sudbrain/opcoes_ranking.jsp">Ranking</a></li>
    </ul>
    </nav>


    </header>

    <section id="sessao">
    <form id="formulario-novo-jogador" method="post" action="servletInsereUsuario.do" >
    <fieldset id="dados-jogador"><legend>Preencha todos os campos</legend>
    <p><label for="cNome">Nome: </label><input id="cNome" name="txtNome" type="text" size="30" maxlength="50" placeholder="Nome completo" ></p>
    <p><label for="cLogin">Login:  </label><input id="cLogin" name="txtLogin" type="text" size="15" maxlength="15" placeholder="min 4, max 15"
    onchange="verificaTamanhoLogin();" onmouseout="ativaBotao();"><label class="label-alerta" id="lLogin" hidden="hidden">É preciso ter no mínimo 4 caracteres</label></p>
    <p><label for="cSenha">Senha: </label><input id="cSenha" name="txtSenha" type="password" size="15" maxlength="15" placeholder="min 6, max 15"
    onchange="verificaTamanhoSenha();" onmouseout="ativaBotao();"><label class="label-alerta" id="lSenha" hidden="hidden">É preciso ter no mínimo 6 caracteres </label></p>
    <p><label for="cSenha2">Repita a senha: </label><input id="cSenha2" name="txtSenha2" type="password" size="15" maxlength="15"
    onchange="comparaSenha();" onmouseout="ativaBotao();"><label class="label-alerta" id="lSenha2" hidden="hidden"> Senhas diferentes</label></p>
    <p><label for="cEmail">Email:  </label><input id="cEmail" name="txtEmail" type="email" size="35" maxlength="50" onmouseout="ativaBotao();"></p>
    <input id="botao-enviar" type="image" src="_imagens/bt_enviar.jpeg" onmouseover="verificaPreenchimento();" >
    <label class="label-alerta" id="cEnviar" hidden="hidden">Ainda há campos em branco</label>
    </fieldset>
    </form>

    </section>

    <aside id="lateral">
    <img id="escrituras" src="_imagens/novo_jogador.png">
    </aside>

    </div>

    <footer id="rodape">
    <label>By Everton de Castro</label>
    </footer>

    </body>

    </html>
    
