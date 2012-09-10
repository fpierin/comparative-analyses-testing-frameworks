package br.com.felipepierin.testescommock.exemplo2;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import org.junit.Test;

public class EasyMock_TestandoChamadaDeMetodoComRetornoComValor {

  private final RepositorioDeAssinantes repositorioDeAssinantes = createMock(RepositorioDeAssinantes.class);
  private final Editor editor = new Editor(repositorioDeAssinantes);

  @Test
  public void fazerUmAssinanteReceberUmaMensagemConhecida() throws Exception {
    final Assinante assinante = createMock(Assinante.class);
    final String minhaMensagem = "mensagem qualquer";
    
    expect(repositorioDeAssinantes.obterAssinante()).andReturn(assinante);
    assinante.recebe(minhaMensagem);
    
    replay(repositorioDeAssinantes, assinante);
    
    editor.publicar(minhaMensagem);
    
    verify(assinante);
  }

}