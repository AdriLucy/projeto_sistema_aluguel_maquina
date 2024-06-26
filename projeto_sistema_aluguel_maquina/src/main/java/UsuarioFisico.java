import javax.swing.*;
import java.util.List;

public class UsuarioFisico extends Usuario {
    private String cpf;

    public UsuarioFisico() {
    }

    public UsuarioFisico(int codigo, String nome, String email, String senha,
                         String telefone, String cpf, List<Aluguel> alugueis,List<Avaliacao> avaliacoes) {
        super(codigo, nome, email, senha, telefone,alugueis,avaliacoes);
        setCpf(cpf);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void cadastrar(){
        UsuarioFisicoDAO dao = new UsuarioFisicoDAO();
        if(dao.inserir(this)>=1){
            System.out.println("Usuario inserido com sucesso !");
        } else {
            System.out.println("Ocorreu um erro ao inserir o usuario !");
        }
    }

    public void alterar(){
        UsuarioFisicoDAO dao = new UsuarioFisicoDAO();
        if(dao.alterar(this)>=1){
            System.out.println("Usuario alterado com sucesso !");
        } else {
            System.out.println("Ocorreu um erro ao alterar o usuario !");
        }
    }
    public void remover(){
        UsuarioFisicoDAO dao = new UsuarioFisicoDAO();
        if(dao.remover(getCodigo())>=1){
            System.out.println("Usuario removido com sucesso !");
        } else {
            System.out.println("Ocorreu um erro ao remover o usuario !");
        }
    }

    public void pesquisar(int codigo){
        UsuarioFisicoDAO dao = new UsuarioFisicoDAO();
        UsuarioFisico obj = dao.retorna(codigo);
        if(obj == null){
            System.out.println("Objeto nao encontrado !");
        } else {
            System.out.println("############# Usuario ###############");
            System.out.println("Codigo: "+ obj.getCodigo());
            System.out.println("Nome: "+ obj.getNome());
            System.out.println("CPF: "+ obj.getCpf());
            System.out.println("senha: "+ obj.getSenha());
            System.out.println("email: "+ obj.getEmail());
            System.out.println("telefone: "+ obj.getTelefone());
        }
    }



    @Override
    public void alugar() {
        super.alugar();
    }

    @Override
    public void login() {
    }

    @Override
    public void avalia() {
        super.avalia();
    }

}