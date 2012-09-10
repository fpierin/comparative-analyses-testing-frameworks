package br.com.felipepierin.testescommock.exemplo1;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import org.junit.Test;

import br.com.felipepierin.testescommock.exemplo1.Assinante;
import br.com.felipepierin.testescommock.exemplo1.Editor;

public class EasyMock_TestandoChamadaDeMetodoComRetornoVoid {
	

	// Instância de mocks de interfaces colaboradoras da classe em teste.
	// Com EasyMock, usase-se o método "createNiceMock"
	private final Assinante assinante = createNiceMock(Assinante.class);
	// Nesse momento, a interface criada não espera nenhuma chamada adicional.
	
	// Instância da classe que será testada.
	private final Editor editor = new Editor();
	
	@Test
	public void fazerUmAssinanteReceberUmaMensagemConhecida() throws Exception {
		// Primeiro se define os parâmetros utilizados.
		final String mensagemConhecida = "mensagem qualquer";

		// Definimos toda a sequência de invocações sobre mocks
		assinante.recebe(mensagemConhecida);
		
		// Até que encerramos o processo de gravação de expectativas.
		replay(assinante);
		
		// Realizamos chamadas sobre métodos públicos da classe para testar um contexto.
		editor.adiciona(assinante);
		editor.publica(mensagemConhecida);
		
		// Verificamos se nossas expectativas foram atendidas.
		verify(assinante);
	}

}