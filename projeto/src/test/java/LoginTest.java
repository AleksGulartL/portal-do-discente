
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import automacao_sigaa.paginas.metodos;
import automacao_sigaa.paginas.Navegador;
import automacao_sigaa.paginas.PortalDiscente;


public class LoginTest {

    private PortalDiscente portal;
    private String usuario = "aleksander.lopes";
    private String senha = "Mudar123"; 
    private String cpf = "03854413041";
    private String dataNascimento = "03112005";


    @Before
    public void iniciar() {
        Navegador.abrirNavegador("https://sigaatre-tst.uffs.edu.br/sigaa");
        portal = new PortalDiscente();
    }

    @Test
    public void testLoginSigaa() {
        portal.login.logarSigaaTreinamentos(usuario, senha);
        // portal.login.logarSigaa();
        // portal.login.navegarMenuDiscente("outros", "validar e-mail"); 
        
        // portal.ensino.trancamentoDeMatriculaCCR(cpf, senha, dataNascimento,"trancar");
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
        // portal.relacoes_internacionais.realizar_inscricao();
        // portal.outros.ambientesVirtuais();
        // portal.outros.notificarAusenciaProfessor();
        // portal.outros.validarEmail();
        // portal.outros.navegarOutros();
        // portal.outros.forumDeCursos();
        // portal.outros.paginaDoCurso();
        // portal.outros.entrarEmContato();
        // portal.outros.consultarDefesas();
        // portal.outros.acervoDosDocentes();
        // portal.outros.auxilioFinanceiroAssinaturaDocumentosSIPAC();
        // portal.outros.psicologia();
        // portal.outros.atendimentoMedicoOdontologico();
        //portal.outros.RelatoriodeCargaHorariaDocente();
        // portal.outros.criarSenhaDeAcesso(); 
        // portal.outros.navegarOutros();
        // portal.biblioteca.compraDeLivros();
        portal.ensino.solicitarValidacaoDeDocumentosRegistroDeDiploma("src/test/resources/docs/ensino_medio.pdf", "src/test/resources/docs/identidade.pdf");
        

    }
 
    @After
    public void finalizar() {
        Navegador.fecharNavegador();
    }
}
