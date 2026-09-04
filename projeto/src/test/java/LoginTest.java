
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import automacao_sigaa.paginas.metodos;
import automacao_sigaa.paginas.Navegador;
import automacao_sigaa.paginas.PortalDiscente;


public class LoginTest {

    private PortalDiscente portal;
    private String usuario = "aleksander.lopes";
    private String senha = "Aleks15872704";
    private String cpf = "03854413041";
    private String dataNascimento = "03112005";


    @Before
    public void iniciar() {
        Navegador.abrirNavegador("https://sigaa-hom.uffs.edu.br");
        portal = new PortalDiscente();
    }

    @Test
    public void testLoginSigaa() {
        portal.login.logarSigaa(usuario, senha);
        portal.login.navegarMenuDiscente("bolsas", "oportunidades de bolsa");
        
        // portal.ensino.trancamentoDeMatriculaCCR(cpf, senha, dataNascimento,
        // "trancar");
        // portal.ensino.matriculaExtraordinaria("Chapecó", cpf, "123", dataNascimento);
        // portal.ensino.suspensaoDoPrograma(cpf, "", dataNascimento);
        // portal.ensino.consultasGerais("Consultar Turma");
        // portal.pesquisa.projetoDePesquisa("consultar projetos");
        // portal.extensao.navegarExtensao("consultar ações");
        // portal.pesquisa.projetosQueParticipo();
        // portal.monitoria.meusCertificados();
        // portal.biblioteca.pesquisarArtigo();
        // portal.biblioteca.pesquisarMaterial();
        // portal.biblioteca.emprestimos();
        // portal.biblioteca.cadastrarInteresseAcervo();
        // portal.estagio.navegarNoMenu();
        // portal.bolsas.cadastroUnico();
        // portal.bolsas.declaracaoBolsista(cpf, senha, dataNascimento);

    }

    @After
    public void finalizar() {
        Navegador.fecharNavegador();
    }
}
