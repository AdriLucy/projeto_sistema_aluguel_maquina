import javax.xml.crypto.Data;
import java.util.Date;

public class Avaliacao {
    private int codigoAvaliacao;
    private int avaliacao;
    private String comentario;
    private Data dataAvaliacao;

    public Avaliacao() {
    }

    public Avaliacao(int codigoAvaliacao, int avaliacao,
                     String comentario, Date dataAvaliacao){
        setCodigoAvaliacao(codigoAvaliacao);
        setAvaliacao(avaliacao);
        setComentario(comentario);
        setDataAvaliacao(dataAvaliacao);
    }

    public int getCodigoAvaliacao() { return codigoAvaliacao; }

    public void setCodigoAvaliacao(int codigoAvaliacao) { this.codigoAvaliacao = codigoAvaliacao; }

    public int getAvaliacao() { return avaliacao; }

    public void setAvaliacao(int avaliacao) { this.avaliacao = avaliacao; }

    public String getComentario() { return comentario; }

    public void setComentario(String comentario) { this.comentario = comentario; }

    public java.sql.Date getDataAvaliacao() { return (java.sql.Date) dataAvaliacao; }

    public void setDataAvaliacao(Date dataAvaliacao) { this.dataAvaliacao = (Data) dataAvaliacao; }

    public void cadastrar(){
        AvaliacaoDAO dao = new AvaliacaoDAO();
        if(dao.inserir(this)>=1){
            System.out.println("Avaliação inserida com sucesso !");
        } else {
            System.out.println("Ocorreu um erro ao inserir a avaliação !");
        }
    }

    public void alterar(){
        AvaliacaoDAO dao = new AvaliacaoDAO();
        if(dao.alterar(this)>=1){
            System.out.println("Avaliação alterada com sucesso !");
        } else {
            System.out.println("Ocorreu um erro ao alterar a avaliação!");
        }
    }
    public void remover(){
        AvaliacaoDAO dao = new AvaliacaoDAO();
        if(dao.remover(getCodigoAvaliacao())>=1){
            System.out.println("Avaliação de removida com sucesso !");
        } else {
            System.out.println("Ocorreu um erro ao remover a avaliação !");
        }
    }

    public void pesquisar(int codigoAvaliacao){
        AvaliacaoDAO dao = new AvaliacaoDAO();
        Avaliacao obj= dao.retorna(codigoAvaliacao);
        if(obj == null){
            System.out.println("Objeto nao encontrado !");
        } else {
            System.out.println("############# Avaliação ###############");
            System.out.println("Codigo: "+ obj.getCodigoAvaliacao());
            System.out.println("Avaliação: "+ obj.getAvaliacao());
            System.out.println("Comentario: "+ obj.getComentario());
            System.out.println("Data da avaliação: "+ obj.getDataAvaliacao());
        }
    }
}
