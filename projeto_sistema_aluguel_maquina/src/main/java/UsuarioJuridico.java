import java.util.List;

public class UsuarioJuridico extends Usuario {
    private String cnpj;

    public UsuarioJuridico() {
    }

    public UsuarioJuridico(int codigo, String nome, String email, String senha,
                           String telefone, String cnpj, List<Aluguel> alugueis,List<Avaliacao> avaliacoes) {
        super(codigo, nome, email, senha, telefone,alugueis,avaliacoes);
        setCnpj(cnpj);
    }


    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void cadastrar(){
        UsuarioJuridicoDAO dao = new UsuarioJuridicoDAO();
        if(dao.inserir(this)>=1){
            System.out.println("Usuario inserido com sucesso !");
        } else {
            System.out.println("Ocorreu um erro ao inserir o usuario !");
        }
    }

    public void alterar(){
        UsuarioJuridicoDAO dao = new UsuarioJuridicoDAO();
        if(dao.alterar(this)>=1){
            System.out.println("Usuario alterado com sucesso !");
        } else {
            System.out.println("Ocorreu um erro ao alterar o usuario !");
        }
    }
    public void remover(){
        UsuarioJuridicoDAO dao = new UsuarioJuridicoDAO();
        if(dao.remover(getCodigo())>=1){
            System.out.println("Usuario removido com sucesso !");
        } else {
            System.out.println("Ocorreu um erro ao remover o usuario !");
        }
    }

    public void pesquisar(int codigo){
        UsuarioJuridicoDAO dao = new UsuarioJuridicoDAO();
        UsuarioJuridico obj = dao.retorna(codigo);
        if(obj == null){
            System.out.println("Objeto nao encontrado !");
        } else {
            System.out.println("############# Usuario ###############");
            System.out.println("Codigo: "+ obj.getCodigo());
            System.out.println("Nome: "+ obj.getNome());
            System.out.println("CPF: "+ obj.getCnpj());
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
