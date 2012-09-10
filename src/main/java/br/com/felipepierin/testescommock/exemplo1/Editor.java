package br.com.felipepierin.testescommock.exemplo1;


public class Editor {

  private Assinante assinante;

  public Editor() {
  }

  public void publica(final String mensagem) {
    assinante.recebe(mensagem);
  }

  public void adiciona(Assinante assinante) {
    this.assinante = assinante;
  }

}
