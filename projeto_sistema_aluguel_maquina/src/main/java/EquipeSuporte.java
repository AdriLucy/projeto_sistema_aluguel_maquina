import java.util.List;

public class EquipeSuporte {
    private int codigoEquipe;
    private String nomeRepresentante;
    private String telefone;
    private String email;
    private List<Aluguel> alugueis;

    public EquipeSuporte(){
    }

    public EquipeSuporte(int codigoEquipe, String nomeRepresentante, String telefone, String email,List<Aluguel> alugueis ) {
        setCodigoEquipe(codigoEquipe);
        setNomeRepresentante(nomeRepresentante);
        setTelefone(telefone);
        setEmail(email);
        setAlugueis(alugueis);
    }

    public EquipeSuporte(List<Aluguel> alugueis) {
        this.alugueis = alugueis;
    }

    public List<Aluguel> getAlugueis() {
        return alugueis;
    }

    public void setAlugueis(List<Aluguel> alugueis) {
        this.alugueis = alugueis;
    }

    public int getCodigoEquipe() { return codigoEquipe; }

    public void setCodigoEquipe(int codigoEquipe) { this.codigoEquipe = codigoEquipe; }

    public String getNomeRepresentante() { return nomeRepresentante; }

    public void setNomeRepresentante(String nomeRepresentante) { this.nomeRepresentante = nomeRepresentante; }

    public String getTelefone() { return telefone; }

    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public void cadastrar(){
        EquipeSuporteDAO dao = new EquipeSuporteDAO();
        if(dao.inserir(this)>=1){
            System.out.println("Equipe inserida com sucesso !");
        } else {
            System.out.println("Ocorreu um erro ao inserir a equipe de suporte !");
        }
    }

    public void alterar(){
        EquipeSuporteDAO dao = new EquipeSuporteDAO();
        if(dao.alterar(this)>=1){
            System.out.println("Equipe de suporte alterada com sucesso !");
        } else {
            System.out.println("Ocorreu um erro ao alterar a equipe !");
        }
    }
    public void remover(){
        EquipeSuporteDAO dao = new EquipeSuporteDAO();
        if(dao.remover(getCodigoEquipe())>=1){
            System.out.println("Equipe de suporte removida com sucesso !");
        } else {
            System.out.println("Ocorreu um erro ao remover a equipe !");
        }
    }

    public void pesquisar(int codigoEquipe){
        EquipeSuporteDAO dao = new EquipeSuporteDAO();
        EquipeSuporte obj= dao.retorna(codigoEquipe);
        if(obj == null){
            System.out.println("Objeto nao encontrado !");
        } else {
            System.out.println("############# Equipe de suporte ###############");
            System.out.println("Codigo: "+ obj.getCodigoEquipe());
            System.out.println("Nome do representante: "+ obj.getNomeRepresentante());
            System.out.println("Telefone: "+ obj.getTelefone());
            System.out.println("Email: "+ obj.getEmail());
        }
    }

    public void auxilia(){
        //todo
    }
}
