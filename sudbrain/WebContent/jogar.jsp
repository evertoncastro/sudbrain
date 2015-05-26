<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html lang="pt-br">

    <head>
    <meta charset="utf-8">
    <title>Sudbrain</title>
    <link rel="stylesheet" type="text/css" href="_css/estilo.css"/>
    <link rel="stylesheet" type="text/css" href="_css/escrituras.css"/>
    <link rel="stylesheet" type="text/css" href="_css/midias_sociais.css"/>
    <link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet' type='text/css'>
    </head>
    <script language="JavaScript" src="_javascript/funcoes.js"></script>
    <body onload="controlaLayoutIndex(${logado})">

    <ul id="midias_sociais">
    <a href="https://www.facebook.com/everton.decastro.12" target="_blank"><li id="facebook"></li></a>
    <a href="https://www.linkedin.com/profile/view?id=181916977&trk=nav_responsive_tab_profile" target="_blank"><li id="linkedin"></li></a>
    <a href="https://instagram.com/evertoncastrosud/" target="_blank"><li id="instagram"></li></a>
    <a href="https://plus.google.com/u/0/+EvertondeCastrofatec/posts" target="_blank"><li id="gplus"></span></li></a>
    </ul>

    <div id="paginaHome">
    <header id="cabecalho">
    <img id="imagem-logo" src="_imagens/titulo-sudbrain.png">

    <form id="form-login" method="post" action="servletLogin.do">

    <table id="tabela-usuarioLogado" hidden="hidden">
    <tr class="linha-tabela-usuarioLogado">
    <td><a href="../sudbrain/jogar.jsp">Jogar </a></td>
    <td><label class="labLogin">${usuario.getNome()}</label></td>
    <td><a href="../sudbrain/servletLogin.do?acao=sair">  Sair</a></td>
    </tr>

    </table>

    <table id="tabela-jogar" hidden="hidden">

    <tr>
    <td>${mensagem}</td>
    </tr>
    <tr>
    <td>${mensagemPontos}</td>
    </tr>
    </table>

    <table id="tabela-login">
    <tr>
    <td></td>
    <td><label class="labLogin">Login: </label></td>
    <td><input type="text" name="txtLogin" maxlength="15"></td>
    <td><label class="labLogin"> Senha: </label></td>
    <td><input type="password" name="txtSenha" maxlength="15"></td>
    <td><input id="botao-login" type="submit" value=""></td>
    </tr>
    <tr>
    <td colspan="5" id="celula-statusLogin">${statusLogin}</td>

    <td><a href="../sudbrain/novo_jogador.jsp"><img id="botao-novo" src="_imagens/botao_novo.png"></a></td>
    </tr>
    <tr>
    <td colspan="5" id="mensagem-novo-usuario">${mensagem}</td>
    </tr>

    </table>
    </form>

    <nav id="menu">
    <ul>
    <li onmouseover="mudaImagem('_imagens/escrituras.png')" onmouseout="mudaImagem('_imagens/icone_jogar.png')"><a href="../sudbrain/index.jsp">Home</a></li>
    <li onmouseover="mudaImagem('_imagens/sobre.png')" onmouseout="mudaImagem('_imagens/icone_jogar.png')"><a href="../sudbrain/sobre.jsp">Sobre</a></li>
    <li onmouseover="mudaImagem('_imagens/como-jogar.png')" onmouseout="mudaImagem('_imagens/icone_jogar.png')"><a href="../sudbrain/como-jogar.jsp">Como jogar</a></li>
    <li onmouseover="mudaImagem('_imagens/ranking.png')" onmouseout="mudaImagem('_imagens/icone_jogar.png')"><a href="../sudbrain/opcoes_ranking.jsp">Ranking</a></li>
    </nav>


    </header>

    <section id="sessao">
    <label id="titulo-opcoes-escrituras">Escolha as perguntas por escritura</label>
    <ul id="opcoes-escrituras">
    <a href="servletIniciarJogo.do?escritura=mormon"><li id="escritura1"><span>Click para jogar</span></li></a>
    <a href="servletIniciarJogo.do?escritura=doutrina"><li id="escritura2"><span>Click para jogar</span></li></a>
    <a href="servletIniciarJogo.do?escritura=velho"><li id="escritura3"><span>Click para jogar</span></li></a>
    <a href="servletIniciarJogo.do?escritura=novo"><li id="escritura4"><span>Click para jogar</span></li></a>
    </ul>

    </section>

    <aside id="lateral">
    <img id="escrituras" src="_imagens/icone_jogar.png">
    </aside>

    </div>


    <footer id="rodape">
    <label>By Everton de Castro</label>
    </footer>

    </body>





    </html>
    
