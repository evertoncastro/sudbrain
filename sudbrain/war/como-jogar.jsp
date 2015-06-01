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
    <link rel="stylesheet" type="text/css" href="_css/como_jogar.css"/>
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
    <td><label class="labLogin">${usuario.nome}</label></td>
    <td><a href="../servletLogin.do?acao=sair">  Sair</a></td>
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
    <li onmouseover="mudaImagem('_imagens/escrituras.png')" onmouseout="mudaImagem('_imagens/como-jogar.png')"><a href="../index.jsp">Home</a></li>
    <li onmouseover="mudaImagem('_imagens/sobre.png')" onmouseout="mudaImagem('_imagens/como-jogar.png')"><a href="../sobre.jsp">Sobre</a></li>
    <li onmouseover="mudaImagem('_imagens/como-jogar.png')" onmouseout="mudaImagem('_imagens/como-jogar.png')"><a href="../como-jogar.jsp">Como jogar</a></li>
    <li onmouseover="mudaImagem('_imagens/ranking.png')" onmouseout="mudaImagem('_imagens/como-jogar.png')"><a href="../opcoes_ranking.jsp">Ranking</a></li>
    </nav>


    </header>

    <section id="sessao">
    <iframe src="explicacoes.html" name="janela" id="iframe-como-jogar"></iframe>
    </section>

    <aside id="lateral">
    <img id="escrituras" src="_imagens/como-jogar.png">
    <nav id="menu-links">
    <ul>
    <li><a class="links-como-jogar" href="explicacoes.html#novo" target="janela">Acessando o Formul�rio</a></li>
    <li><a class="links-como-jogar" href="explicacoes.html#formulario" target="janela">Criando novo usu�rio</a></li>
    <li><a class="links-como-jogar" href="explicacoes.html#login" target="janela">Realizando acesso</a></li>
    <li><a class="links-como-jogar" href="explicacoes.html#acesso" target="janela">Painel de Jogos</a></li>
    <li><a class="links-como-jogar" href="explicacoes.html#painel-jogos" target="janela">Op��es de jogo</a></li>
    <li><a class="links-como-jogar" href="explicacoes.html#jogo" target="janela">Perguntas</a></li>
    <li><a class="links-como-jogar" href="explicacoes.html#resposta" target="janela">Respostas</a></li>
    <li><a class="links-como-jogar" href="explicacoes.html#auxilios" target="janela">Aux�lios</a></li>
    </ul>
    </nav>
    </aside>

    </div>


    <footer id="rodape">
    <label>By Everton de Castro</label>
    </footer>

    </body>





    </html>
    
