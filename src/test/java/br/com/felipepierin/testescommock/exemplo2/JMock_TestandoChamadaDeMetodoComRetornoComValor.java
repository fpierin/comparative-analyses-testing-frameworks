package br.com.felipepierin.testescommock.exemplo2;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.felipepierin.testescommock.exemplo2.Assinante;
import br.com.felipepierin.testescommock.exemplo2.Editor;

@RunWith(JMock.class)
public class JMock_TestandoChamadaDeMetodoComRetornoComValor {

  private final Mockery contexto = new Mockery();

  private RepositorioDeAssinantes repositorioDeAssinantes = contexto
      .mock(RepositorioDeAssinantes.class);
  private final Editor editor = new Editor(repositorioDeAssinantes);

  @Test
  public void fazerUmAssinanteReceberUmaMensagemConhecida() {
    final String minhaMensagem = "mensagem";
    final Assinante assinante = contexto.mock(Assinante.class);

    contexto.checking(new Expectations() {{
        oneOf(repositorioDeAssinantes).obterAssinante(); 
        will(returnValue(assinante));
        oneOf(assinante).recebe(minhaMensagem);
    }});

    editor.publicar(minhaMensagem);
  }
}