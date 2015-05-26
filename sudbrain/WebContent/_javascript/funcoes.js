function controlaLayoutIndex(logado){
    if(logado){
        document.getElementById('tabela-usuarioLogado').hidden = false;
        document.getElementById('tabela-jogar').hidden = false;
        document.getElementById('tabela-login').hidden = true;
    }else{
        document.getElementById('tabela-usuarioLogado').hidden = true;
        document.getElementById('tabela-jogar').hidden = true;
        document.getElementById('tabela-login').hidden = false;
    }
}

function mudaImagem(imagem){
    document.getElementById("escrituras").src = imagem;
}


function verificaResposta(respostaBanco, numero){
    var valueRadio1 = document.getElementById('radio1').checked;
    var valueRadio2 = document.getElementById('radio2').checked;
    var valueRadio3 = document.getElementById('radio3').checked;
    var valueRadio4 = document.getElementById('radio4').checked;

    var respostaUsuario=0;

    if(valueRadio1){
        respostaUsuario = 1;
    }else if(valueRadio2){
        respostaUsuario = 2;
    }else if(valueRadio3){
        respostaUsuario = 3;
    }else if(valueRadio4){
        respostaUsuario = 4;
    }

    if(respostaUsuario == respostaBanco){
        document.getElementById('radio1').disabled = true;
        document.getElementById('radio2').disabled = true;
        document.getElementById('radio3').disabled = true;
        document.getElementById('radio4').disabled = true;
        document.getElementById("bt-proxima").disabled = false;
        document.getElementById("bt-envia-resposta").disabled = true;
        if(numero == 1){
            document.getElementById("status-resposta").src = "_imagens/resposta_correta_1.png";
        }else if(numero == 2){
            document.getElementById("status-resposta").src = "_imagens/resposta_correta_2.png";
        }else if(numero == 3){
            document.getElementById("status-resposta").src = "_imagens/resposta_correta_3.png";
        }else if(numero == 4){
            document.getElementById("status-resposta").src = "_imagens/resposta_correta_4.png";
        }
        return respostaUsuario;
    }else{
        document.getElementById('radio1').disabled = true;
        document.getElementById('radio2').disabled = true;
        document.getElementById('radio3').disabled = true;
        document.getElementById('radio4').disabled = true;
        document.getElementById('bt-encerra').hidden = false;
        document.getElementById("bt-envia-resposta").disabled = true;
        document.getElementById("botao-pulos").hidden = true;
        document.getElementById("botao-ajuda").hidden = true;
        document.getElementById("botao-sorteio").hidden = true;

        if(numero == 1){
            document.getElementById("status-resposta").src = "_imagens/resposta_incorreta_1.png";
        }else if(numero == 2){
            document.getElementById("status-resposta").src = "_imagens/resposta_incorreta_2.png";
        }else if(numero == 3){
            document.getElementById("status-resposta").src = "_imagens/resposta_incorreta_3.png";
        }else if(numero == 4){
            document.getElementById("status-resposta").src = "_imagens/resposta_incorreta_4.png";
        }

    }
}

function pularQuestao(atual){
    window.location.href="servletPularQuestao.do";
}

function avisoSelecao(){
    var cont = 0;
    if(document.getElementById('radio1').checked == false){
        cont++;
    }if(document.getElementById('radio2').checked == false){
        cont++;
    }if(document.getElementById('radio3').checked == false){
        cont++;
    }if(document.getElementById('radio4').checked == false){
        cont++;
    }
    if(cont==4){
        document.getElementById('label-informacao').hidden=false;
    }
}

function desativaBotaoProxima(){
    document.getElementById("bt-proxima").disabled = false;
    window.history.forward(1);
}

function desativaAvisoSelecao(){
    document.getElementById('label-informacao').hidden=true;
}

function ativaBotaoEnvia() {
    document.getElementById("bt-envia-resposta").disabled = false;
}

function verificaEscritura(numero){
    if(numero == 1){
        document.getElementById('status-resposta').src = '_imagens/livrodemormon_1.png';
    }else if(numero == 2){
        document.getElementById('status-resposta').src = '_imagens/d&c_2.png';
    }else if(numero == 3){
        document.getElementById('status-resposta').src = '_imagens/velhotestamento_3.png';
    }else if(numero == 4){
        document.getElementById('status-resposta').src = '_imagens/novotestamento_4.png';
    }

    document.getElementById('imagem-pulos').disabled = true;

}


function controlaAcao(pulos, ajuda, janelaAjuda, sorteio){
    if(pulos <= 0){
        document.getElementById('botao-pulos').hidden = true;
    }
    document.getElementById('label-pulos').innerHTML = pulos;

    if(ajuda <= 0){
        document.getElementById('botao-ajuda').hidden = true;
    }
    document.getElementById('label-ajuda').innerHTML = ajuda;

    if(sorteio <= 0){
        document.getElementById('botao-sorteio').hidden = true;
    }
    document.getElementById('label-sorteio').innerHTML = sorteio;

    if(janelaAjuda){
        document.getElementById('resultado-acoes').hidden = false;
    }else{
        document.getElementById('resultado-acoes').hidden = true;
    }
}

function imagemSorteio(sorteio){
    if(sorteio==1){
        document.getElementById('acao-sorteio').src = "_imagens/lado1.png";
    }else if(sorteio==2){
        document.getElementById('acao-sorteio').src = "_imagens/lado2.png";
    }else if(sorteio==3){
        document.getElementById('acao-sorteio').src = "_imagens/lado3.png";
    }
}

function desativaAlternativaErrada(alter1, alter2, alter3, alter4){
    if(!alter1){
        document.getElementById('radio1').disabled = true;
        document.getElementById('label-alternativa1').hidden = true;
    }
    if(!alter2){
        document.getElementById('radio2').disabled = true;
        document.getElementById('label-alternativa2').hidden = true;
    }
    if(!alter3){
        document.getElementById('radio3').disabled = true;
        document.getElementById('label-alternativa3').hidden = true;
    }
    if(!alter4){
        document.getElementById('radio4').disabled = true;
        document.getElementById('label-alternativa4').hidden = true;
    }
}

