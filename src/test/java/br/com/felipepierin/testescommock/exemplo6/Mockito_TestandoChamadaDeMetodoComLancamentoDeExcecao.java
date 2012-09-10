package br.com.felipepierin.testescommock.exemplo6;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import br.com.felipepierin.testescommock.exemplo1.Assinante;
import br.com.felipepierin.testescommock.exemplo1.Editor;

public class Mockito_TestandoChamadaDeMetodoComLancamentoDeExcecao {
  
  // Instância de mocks de interfaces colaboradoras da classe em teste.
  // No caso do mockito, usamos o método "mock".
  private final Assinante assinante = mock(Assinante.class);
  
  // Instância da classe que será testada.
  private final Editor editor = new Editor();
  
  @Test
  public void fazerUmAssinanteReceberUmaMensagemConhecida() {
    // Primeiro se define os parâmetros utilizados.
    final String mensagem = "minha mensagem com mockito";
    
    // Realizamos chamadas sobre métodos públicos da classe para testar um contexto.
    editor.adiciona(assinante);
    editor.publica(mensagem);

    // Verificamos se nossas expectativas foram atendidas.    
    verify(assinante).recebe(mensagem);
  }

}
