import java.text.DecimalFormat;
import java.util.List;

public class Maquina {
    private int codigoMaquina;
    private String nomeMaquina;
    private String descricao;
    private String especificacaoTecnica;
    private double taxaAluguelHora;
    private String imagens;
    private String categoria;
    private List<Avaliacao> avaliacao;
    private List<Aluguel> alugueis;



    public Maquina(){
    }

    public Maquina(int codigoMaquina,String nomeMaquina, String descricao, String especificacaoTecnica,
                   String tecnicas, String imagens, double taxaAluguelHora, String categoria, List<Avaliacao> avaliacao, List<Aluguel> alugueis){
        setCodigoMaquina(codigoMaquina);
        setNomeMaquina(nomeMaquina);
        setDescricao(descricao);
        setEspecificacaoTecnica(especificacaoTecnica);
        setImagens(imagens);
        setTaxaAluguelHora(taxaAluguelHora);
        setCategoria(categoria);
        setAvaliacao(avaliacao);
        setAlugueis(alugueis);
    }

    public List<Aluguel> getAlugueis() {
        return alugueis;
    }

    public void setAlugueis(List<Aluguel> alugueis) {
        this.alugueis = alugueis;
    }

    public List<Avaliacao> getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(List<Avaliacao> avaliacao) {
        this.avaliacao = avaliacao;
    }

    public int getCodigoMaquina() {
        return codigoMaquina;
    }

    public void setCodigoMaquina(int codigoMaquina) {
        this.codigoMaquina = codigoMaquina;
    }

    public String getNomeMaquina() {
        return nomeMaquina;
    }

    public void setNomeMaquina(String nomeMaquina) {
        this.nomeMaquina = nomeMaquina;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEspecificacaoTecnica() {
        return especificacaoTecnica;
    }

    public void setEspecificacaoTecnica(String especificacaoTecnica) {
        this.especificacaoTecnica = especificacaoTecnica;
    }

    public double getTaxaAluguelHora() {
        return taxaAluguelHora;
    }

    public void setTaxaAluguelHora(double taxaAluguelHora) {
        this.taxaAluguelHora = taxaAluguelHora;
    }

    public String getImagens() {
        return imagens;
    }

    public void setImagens(String imagens) {
        this.imagens = imagens;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void cadastrar(){
        MaquinaDAO dao = new MaquinaDAO();
        if(dao.inserir(this)>=1){
            System.out.println("Maquina inserida com sucesso !");
        } else {
            System.out.println("Ocorreu um erro ao inserir a maquina !");
        }
    }

    public void alterar(){
        MaquinaDAO dao = new MaquinaDAO();
        if(dao.alterar(this)>=1){
            System.out.println("Maquina alterada com sucesso !");
        } else {
            System.out.println("Ocorreu um erro ao alterar a maquina !");
        }
    }
    public void remover(){
        MaquinaDAO dao = new MaquinaDAO();
        if(dao.remover(getCodigoMaquina())>=1){
            System.out.println("Maquina removida com sucesso !");
        } else {
            System.out.println("Ocorreu um erro ao remover a maquina !");
        }
    }

    public void pesquisar(int codigoMaquina){
        MaquinaDAO dao = new MaquinaDAO();
        Maquina obj= dao.retorna(codigoMaquina);
        if(obj == null){
            System.out.println("Objeto nao encontrado !");
        } else {
            System.out.println("############# Maquina ###############");
            System.out.println("Codigo: "+ obj.getCodigoMaquina());
            System.out.println("Nome da maquina: "+ obj.getNomeMaquina());
            System.out.println("Descrição: "+ obj.getDescricao());
            System.out.println("Especificação tecnica: "+ obj.getEspecificacaoTecnica());
            System.out.println("Taxa de aluguel por hora: "+ obj.getTaxaAluguelHora());
            System.out.println("Categoria: "+ obj.getCategoria());
        }
    }



}
