package br.com.felipepierin.testescommock.exemplo6;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import org.junit.Test;

public class EasyMock_TestandoChamadaDeMetodoComLancamentoDeExcecao {

  private final RepositorioDeAssinantes repositorioDeAssinantes = createMock(RepositorioDeAssinantes.class);
  private final Editor editor = new Editor(repositorioDeAssinantes);

  @Test(expected = RuntimeException.class)
  public void fazerUmAssinanteReceberUmaMensagemConhecida() throws Exception {
    final String minhaMensagem = "mensagem qualquer";

    final Throwable throwable = new RuntimeException();
    
    expect(repositorioDeAssinantes.obterAssinante())
      .andThrow(throwable);
    
    replay(repositorioDeAssinantes);
    
    editor.publicar(minhaMensagem);
    
    verify(repositorioDeAssinantes);
  }

}