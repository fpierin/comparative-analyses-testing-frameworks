package br.com.felipepierin.testescommock.exemplo6;


public class Editor {

  private final RepositorioDeAssinantes repositorioDeAssinantes;

  public Editor(RepositorioDeAssinantes repositorioDeAssinantes) {
    this.repositorioDeAssinantes = repositorioDeAssinantes;
  }

  public void publicar(String mensagem) {
    Assinante assinante = repositorioDeAssinantes.obterAssinante();
    assinante.recebe(mensagem);
  }

}
