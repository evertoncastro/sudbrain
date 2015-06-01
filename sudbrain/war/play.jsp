<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <head>
    <meta charset="utf-8">
    <title>Sudbrain</title>

    <link rel="stylesheet" type="text/css" href="_css/play-format.css"/>

    </head>
    <script language="JavaScript" src="_javascript/funcoes.js"></script>


    <body id="corpo" onload="verificaEscritura(${numeroEscritura})">


    <div id="paginaHome">
    <header id="cabecalho">
    <label id="label-f5">Pressione F5 ou Atualizar para reiniciar</label>
    <label id="label-usuario">${usuario.nome}</label>
    <a href="servletLimpaDados.do"> SAIR</a>
    </header>

    <section id="sessao">

    <fieldset id="fieldQuest"><legend>Pergunta <c:out value="${pergunta.nivel}"></c:out></legend>
    <h1>${pergunta.pergunta}</h1>
    </fieldset>

    <table id="tabela-alternativas">
    <tr>
    <td class="button"><label class="label-alternativa" for="radio1">1</label><input class="radioButton" id="radio1" type="radio" name="alter" value="1" onclick="ativaBotaoEnvia();"></td>
    <td><label id="label-alternativa1" class="texto-resposta" for="radio1" onmouseover="desativaAvisoSelecao();">${pergunta.alternativa_A}</label></td>
    </tr>
    <tr>
    <td class="button"><label class="label-alternativa" for="radio2">2</label><input class="radioButton" id="radio2" type="radio" name="alter" value="2" onclick="ativaBotaoEnvia();"></td>
    <td><label id="label-alternativa2" class="texto-resposta" for="radio2" onmouseover="desativaAvisoSelecao();">${pergunta.alternativa_B}</label></td>
    </tr>
    <tr>
    <td class="button"><label class="label-alternativa" for="radio3">3</label><input class="radioButton" id="radio3" type="radio" name="alter" value="3" onclick="ativaBotaoEnvia();"></td>
    <td><label id="label-alternativa3" class="texto-resposta" for="radio3" onmouseover="desativaAvisoSelecao();">${pergunta.alternativa_C}</label></td>
    </tr>
    <tr>
    <td class="button"><label class="label-alternativa" for="radio4">4</label><input class="radioButton" id="radio4" type="radio" name="alter" value="4" onclick="ativaBotaoEnvia();"></td>
    <td><label id="label-alternativa4" class="texto-resposta" for="radio4" onmouseover="desativaAvisoSelecao();">${pergunta.alternativa_D}</label></td>
    </tr>
    </table>

    <form id="formResp" method="post" action="${servletChamada}" onmouseover="avisoSelecao();">
    <table id="tabela-botoes">
    <tr>
    <td><input class="botoes-perguntas" id="bt-envia-resposta" type="button" value="Enviar" disabled onclick="verificaResposta(${pergunta.resposta}, ${numeroEscritura});"></td>
    <td><input class="botoes-perguntas" id="bt-proxima" type="submit" value="Proxima" disabled onclick="desativaBotaoProxima();"></td>
    </tr>
    </table>

    <label id="label-informacao" hidden="hidden">Escolha uma alternativa antes de prosseguir</label>

    </form>
    <form method="post" action="servletCalculaPontuacao.do">
    <input id="bt-encerra" type="submit" value="Encerrar" hidden="hidden">
    </form>

    </section>

    <aside id="lateral">
    <img id="status-resposta" src="_imagens/espaco_branco.png">



    <table id="tabela-acoes">

    <tr>
    <td class="acoes-imagens"><img id="img-pulos" src="_imagens/pulo.png" onload="controlaAcao(${acao.qtdPulo}, ${acao.qtdAjuda}, ${ajuda.janelaAjuda}, ${acao.qtdSorteio});">
    <label id="label-pulos">3</label></td>
    <td class="acoes-imagens"><img id="img-ajuda" src="_imagens/ajuda.png">
    <label id="label-ajuda">1</label></td>
    <td class="acoes-imagens"><img  id="acao-sorteio" src="_imagens/dado.png" onload="desativaAlternativaErrada(${sorteio.alternativa1}, ${sorteio.alternativa2}, ${sorteio.alternativa3}, ${sorteio.alternativa4});">
    <label id="label-sorteio">1</label></td>
    </tr>
    <tr>
    <form method="post" action="${puloChamado}">
    <td class="acoes-botoes"><input id="botao-pulos" class="botoes-acoes" type="submit" value="Pulo"></td>
    </form>
    <td class="acoes-botoes"><a href="servletAjuda.do"><input id="botao-ajuda" class="botoes-acoes" type="button" value="Ajuda"></a></td>
    <td class="acoes-botoes"><a href="servletSorteio.do"><input id="botao-sorteio" class="botoes-acoes" type="button" value="Sorteio"></a></td>

    </tr>
    </table>
    <table id="resultado-acoes" hidden="hidden">
    <tr>
    <td class="linha-resultado"><img src="_imagens/ajuda1.png"></td>
    <td class="linha-resultado"><img src="_imagens/ajuda2.png"></td>
    <td class="linha-resultado"><img src="_imagens/ajuda3.png" onload="imagemSorteio(${sorteio.imagemSorteio})"></td>
    </tr>
    <tr>
    <td class="resposta-ajuda" id="linha-ajuda1">${ajuda.ajuda1}</td>
    <td class="resposta-ajuda" id="linha-ajuda2">${ajuda.ajuda2}</td>
    <td class="resposta-ajuda" id="linha-ajuda3">${ajuda.ajuda3}</td>
    </tr>
    </table>

    </section>


    </aside>
    </div>
    </body>
    </html>