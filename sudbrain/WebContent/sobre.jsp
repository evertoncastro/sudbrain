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
    <li onmouseover="mudaImagem('_imagens/escrituras.png')" onmouseout="mudaImagem('_imagens/sobre.png')"><a href="../sudbrain/index.jsp">Home</a></li>
    <li onmouseover="mudaImagem('_imagens/sobre.png')" onmouseout="mudaImagem('_imagens/sobre.png')"><a href="../sudbrain/sobre.jsp">Sobre</a></li>
    <li onmouseover="mudaImagem('_imagens/como-jogar.png')" onmouseout="mudaImagem('_imagens/sobre.png')"><a href="../sudbrain/como-jogar.jsp">Como jogar</a></li>
    <li onmouseover="mudaImagem('_imagens/ranking.png')" onmouseout="mudaImagem('_imagens/sobre.png')"><a href="../sudbrain/opcoes_ranking.jsp">Ranking</a></li>
    </nav>


    </header>

    <section id="sessao">
    <p class="texto-sobre">O Sudbrain � um aplicativo criado exclusivamente para o membros da Igreja para ser uma op��o em uma atividade descontra�da entre familiares e amigos. Al�m de ser uma oportunidade de aumentar seu conhecimento sobre eventos e personagens das escrituras.</p>
    <p class="texto-sobre">Trata-se de um jogo de perguntas e respostas sobre as quatro <a href="https://www.lds.org/manual/true-to-the-faith/scriptures.p1?lang=por" target="blank">obras padr�o</a> da Igreja.</p>
    <p class="texto-sobre">Al�m das quatro alternativas de escrituras o jogo possui uma tabela de Ranking por escritura, o que traz mais emo��o para os participantes, como por exemplo, em uma atividade de jovens no semin�rio ou mutual da ORM.</p>
    <p class="texto-sobre">Convidamos voc� a aproveitar essa divers�o e compartilhar com seus amigos essa experi�ncia.</p>

    </section>

    <aside id="lateral">
    <img id="escrituras" src="_imagens/sobre.png">
    <img id="imagem-obras-padrao" src="_imagens/obras_padrao.png">
    </aside>

    </div>


    <footer id="rodape">
    <label>By Everton de Castro</label>
    </footer>

    </body>





    </html>
    
