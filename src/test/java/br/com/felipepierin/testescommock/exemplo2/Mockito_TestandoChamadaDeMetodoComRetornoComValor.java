package br.com.felipepierin.testescommock.exemplo2;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class Mockito_TestandoChamadaDeMetodoComRetornoComValor {
  
  private final RepositorioDeAssinantes repositorioDeAssinantes = mock(RepositorioDeAssinantes.class);
  private final Editor editor = new Editor(repositorioDeAssinantes);
  
  @Test
  public void fazerUmAssinanteReceberUmaMensagemConhecida() {
    final String mensagem = "minha mensagem com mockito";
    final Assinante assinante = mock(Assinante.class);
    
    when(repositorioDeAssinantes.obterAssinante()).thenReturn(assinante);
    editor.publicar(mensagem);
    verify(assinante).recebe(mensagem);
  }

}
