
package automacao_sigaa.paginas;

public class PortalDiscente {
    public metodos login;
    public Ensino ensino;
    public Pesquisa pesquisa;
    public Extensao extensao;
    public Monitoria monitoria;
    public Biblioteca biblioteca;
    public Bolsas bolsas;
    public Estagio estagio;
    public Relaçoes_internacionais relacoes_internacionais;
    public Outros outros;

    public PortalDiscente() {
        this.login = new metodos();
        this.ensino = new Ensino();
        this.pesquisa = new Pesquisa();
        this.extensao = new Extensao();
        this.monitoria = new Monitoria();
        this.biblioteca = new Biblioteca();
        this.bolsas = new Bolsas();
        this.estagio = new Estagio();
        this.relacoes_internacionais = new Relaçoes_internacionais();
        this.outros = new Outros();

    }
}