package br.com.felipepierin.testescommock.exemplo6;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMock.class)
public class JMock_TestandoChamadaDeMetodoComLancamentoDeExcecao {

  private final Mockery contexto = new Mockery();

  private RepositorioDeAssinantes repositorioDeAssinantes = contexto
      .mock(RepositorioDeAssinantes.class);
  private final Editor editor = new Editor(repositorioDeAssinantes);

  @Test(expected = RuntimeException.class)
  public void fazerUmAssinanteReceberUmaMensagemConhecida() {
    final String minhaMensagem = "mensagem";

    contexto.checking(new Expectations() {{
        oneOf(repositorioDeAssinantes).obterAssinante(); 
        will(throwException(new RuntimeException()));
    }});

    editor.publicar(minhaMensagem);
  }
}