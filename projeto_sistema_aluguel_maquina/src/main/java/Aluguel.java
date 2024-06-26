
import java.util.Date;
import java.util.List;

public class Aluguel {
    private int codigoAluguel;
    private Date dataHoraInicio;
    private Date dataHoraTermino;
    private String pagamento;
    private String status;



    public Aluguel(){
    }

    private EquipeSuporte equipeSuporte;

    public Aluguel (int codigoAluguel, Date dataHoraInicio,
                    Date dataHoraTermino, String pagamento, String status){
        setCodigoAluguel(codigoAluguel);
        setDataHoraInicio(dataHoraInicio);
        setDataHoraTermino(dataHoraTermino);
        setPagamento(pagamento);
        setStatus(status);
    }


    public void setEquipeSuporte(EquipeSuporte equipeSuporte) {
        this.equipeSuporte = equipeSuporte;
    }

    public int getCodigoAluguel() { return codigoAluguel; }

    public void setCodigoAluguel(int codigoAluguel) { this.codigoAluguel = codigoAluguel; }


    public java.sql.Date getDataHoraInicio() { return (java.sql.Date) dataHoraInicio; }

    public void setDataHoraInicio(Date dataHoraInicio) { this.dataHoraInicio = dataHoraInicio; }

    public java.sql.Date getDataHoraTermino() { return (java.sql.Date) dataHoraTermino; }

    public void setDataHoraTermino(Date dataHoraTermino) { this.dataHoraTermino = dataHoraTermino; }

    public String getPagamento() { return pagamento; }

    public void setPagamento(String pagamento) { this.pagamento = pagamento; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public void cadastrar(){
        AluguelDAO dao = new AluguelDAO();
        if(dao.inserir(this)>=1){
            System.out.println("Aluguel cadastrado com sucesso !");
        } else {
            System.out.println("Ocorreu um erro ao inserir a aluguel !");
        }
    }

    public void alterar(){
        AluguelDAO dao = new AluguelDAO();
        if(dao.alterar(this)>=1){
            System.out.println("Aluguel alterado alterada com sucesso !");
        } else {
            System.out.println("Ocorreu um erro ao alterar a aluguel!");
        }
    }
    public void remover(){
        AluguelDAO dao = new AluguelDAO();
        if(dao.remover(getCodigoAluguel())>=1){
            System.out.println("Aluguel removido com sucesso !");
        } else {
            System.out.println("Ocorreu um erro ao remover a aluguel !");
        }
    }

    public void pesquisar(int codigoAluguel){
        AluguelDAO dao = new AluguelDAO();
        Aluguel obj= dao.retorna(codigoAluguel);
        if(obj == null){
            System.out.println("Objeto nao encontrado !");
        } else {
            System.out.println("############# Aluguel ###############");
            System.out.println("DataHoraInicio: "+ obj.getDataHoraInicio());
            System.out.println("DataHoraTermino: "+ obj.getDataHoraTermino());
            System.out.println("Pagamento: "+ obj.getPagamento());
            System.out.println("Status: "+ obj.getStatus());
        }
    }
}
