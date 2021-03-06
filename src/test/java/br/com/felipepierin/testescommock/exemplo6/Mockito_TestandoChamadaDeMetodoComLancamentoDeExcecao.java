package br.com.felipepierin.testescommock.exemplo6;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class Mockito_TestandoChamadaDeMetodoComLancamentoDeExcecao {
  
  private final RepositorioDeAssinantes repositorioDeAssinantes = mock(RepositorioDeAssinantes.class);
  private final Editor editor = new Editor(repositorioDeAssinantes);
  
  @Test(expected = RuntimeException.class)
  public void fazerUmAssinanteReceberUmaMensagemConhecida() {
    final String mensagem = "minha mensagem com mockito";
    
    when(repositorioDeAssinantes.obterAssinante())
      .thenThrow(new RuntimeException());
    editor.publicar(mensagem);
  }

}
