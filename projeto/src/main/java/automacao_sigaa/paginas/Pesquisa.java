package automacao_sigaa.paginas;

public class Pesquisa extends metodos {

    public void planoDeTrabalho() {
        navegarMenuDiscente("pesquisa", "plano de trabalho");
        visualizarOpcaoSubSubMenu("meus planos de trabalho");
        voltarAoMenuPrincipal();
    }

    public void consultarProjetos() {
        navegarMenuDiscente("pesquisa", "projetos de pesquisa");
        clicarBuscar();
        voltarAoMenuPrincipal();
    }

    public void projetosQueParticipo() {
        navegarMenuDiscente("pesquisa", "projetos de pesquisa");
        visualizarOpcaoSubSubMenu("projetos que participo");
        voltarAoMenuPrincipal();
    }

    public void projetoDePesquisa(String opcao) {
        if (opcao == null) return;
        if (opcao.equalsIgnoreCase("consultar projetos")) {
            consultarProjetos();
        } else if (opcao.equalsIgnoreCase("projetos que participo")) {
            projetosQueParticipo();
        } else if (opcao.equalsIgnoreCase("plano de trabalho")) {
            planoDeTrabalho();
        }
    }

    public void navegarPesquisa() {
        projetoDePesquisa("consultar projetos");
        projetoDePesquisa("projetos que participo");
        projetoDePesquisa("plano de trabalho");
        
    }
}
// nao é possivel acessar:
// Relatorios de iniciaçao cientifica / certificados e declaraçoes / congresso de iniciaçao cientica / 
