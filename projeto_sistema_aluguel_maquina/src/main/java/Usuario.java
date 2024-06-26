import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
        private int codigo;
        private String nome;
        private String email;
        private String senha;
        private String telefone;
        private List<Aluguel> alugueis;
        private List<Avaliacao> avaliacoes;

    public Usuario() {
    }

    public Usuario(int codigo, String nome, String email, String senha, String telefone,List<Aluguel> alugueis,List<Avaliacao> avaliacoes ) {
        setCodigo(codigo);
        setNome(nome);
        setEmail(email);
        setSenha(senha);
        setTelefone(telefone);
        setAlugueis(alugueis);
        setAvaliacoes(avaliacoes);
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public List<Aluguel> getAlugueis() {
        return alugueis;
    }

    public void setAlugueis(List<Aluguel> alugueis) {
        this.alugueis = alugueis;
    }

    public int getCodigo() { return codigo; }

    public void setCodigo(int codigo) { this.codigo = codigo; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }


    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() { return telefone; }

    public void setTelefone(String telefone) { this.telefone = telefone; }

    public void alugar(){
        List<Aluguel> lista = new ArrayList<Aluguel>();
        Aluguel a1 = new Aluguel();

    }

    public void login(){
        //todo
    }

    public void avalia(){
        Avaliacao av1 = new Avaliacao();
        av1.cadastrar();
    }

}
