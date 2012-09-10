package br.com.felipepierin.testescommock.exemplo1;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.felipepierin.testescommock.exemplo1.Assinante;
import br.com.felipepierin.testescommock.exemplo1.Editor;

// Para que o JMock funcione em conjunto om JUnit, devemos usar a anotacao RunWith.
@RunWith(JMock.class)
public class JMock_TestandoChamadaDeMetodoComRetornoVoid {

    // Criamos uma intância do gerenciador de mocks do JMock;
	private final Mockery contexto = new Mockery();
	
	// Criamos instâncias dos objetos colaboradores da classe que será testada.
	private final Assinante assinante = contexto.mock(Assinante.class);
	
	// Instaciamos a classe em teste com seus colaboradores necessários
	private final Editor editor = new Editor();
	
	@Test
	public void fazerUmAssinanteReceberUmaMensagemConhecida() {
	    // Definimos todos os parâmetros que serão usados durante o teste
		final String mensagemConhecida = "mensagem";
		
		editor.adiciona(assinante);

		// Atribuimos todas as expectativas sobre os objetos que foram mocados.
		contexto.checking(new Expectations() {{
		    // Nesse caso, queremos apenas uma interação com um método especifico do mock.
		    // No caso de ocorrerem novas interações, acontecerá uma falha de teste.
			oneOf(assinante).recebe(mensagemConhecida);
		}});

		editor.publica(mensagemConhecida);
		
	}

}
