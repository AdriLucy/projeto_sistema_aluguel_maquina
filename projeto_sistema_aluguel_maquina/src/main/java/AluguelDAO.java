import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AluguelDAO {
    private Conexao conexao = new Conexao();

    public int inserir(Aluguel obj) {
        conexao.conectar();

        String Sql = "insert into aluguel(dataHoraInicio,dataHoraTermino, pagamento, status) " +
                "values(?,?,?,?)";

        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try {
            stmt.setDate(1, obj.getDataHoraInicio());
            stmt.setDate(2, obj.getDataHoraTermino());
            stmt.setString(3, obj.getPagamento());
            stmt.setString(4, obj.getStatus());

            return stmt.executeUpdate();
        } catch (SQLException err) {
            System.err.println(err.getMessage());
            return 0;
        } finally {
            conexao.desconectar();
        }
    }

    public int alterar(Aluguel obj) {
        conexao.conectar();

        String Sql = "update aluguel set dataHoraInicio=?,DataHoraTermino=?,pagamento=?,status=? where codigo=?";

        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try {
            stmt.setDate(1, obj.getDataHoraInicio());
            stmt.setDate(2, obj.getDataHoraTermino());
            stmt.setString(3, obj.getPagamento());
            stmt.setString(4, obj.getStatus());
            stmt.setInt(5,obj.getCodigoAluguel());

            return stmt.executeUpdate();
        } catch (SQLException err) {
            System.err.println(err.getMessage());
            return 0;
        } finally {
            conexao.desconectar();
        }
    }

    public int remover(int codigoAluguel) {
        conexao.conectar();

        String Sql = "delete from agenda where codigo=?";

        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try {
            stmt.setInt(1,codigoAluguel);
            return stmt.executeUpdate();
        } catch (SQLException err) {
            System.err.println(err.getMessage());
            return 0;
        } finally {
            conexao.desconectar();
        }
    }


    public Aluguel retorna(int codigo) {
        conexao.conectar();
        String Sql = "select codigo, dataHoraInicio,dataHoraTermino, pagamento, status from" +
                " aluguel where  codigo=?";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try {
            stmt.setInt(1, codigo);
            ResultSet retorno = stmt.executeQuery();

            if (retorno.next()) {
                Aluguel obj = new Aluguel();
                obj.setCodigoAluguel(retorno.getInt("codigo"));
                obj.setDataHoraInicio(retorno.getDate("dataHoraInicio"));
                obj.setDataHoraTermino(retorno.getDate("dataHoraTermino"));
                obj.setPagamento(retorno.getString("pagamento"));
                obj.setStatus(retorno.getString("status"));

                return obj;
            } else {
                return null;
            }
        } catch (SQLException err) {
            System.err.println(err.getMessage());
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            conexao.desconectar();
        }
    }



}