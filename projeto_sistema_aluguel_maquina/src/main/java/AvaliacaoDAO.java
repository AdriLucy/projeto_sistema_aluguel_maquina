import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AvaliacaoDAO {
    private Conexao conexao = new Conexao();

    public int inserir(Avaliacao obj) {
        conexao.conectar();

        String Sql = "insert into aluguel(avaliacao,comentario, dataAvaliacao) " +
                "values(?,?,?)";

        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try {
            stmt.setInt(1, obj.getAvaliacao());
            stmt.setString(2, obj.getComentario());
            stmt.setDate(3, obj.getDataAvaliacao());

            return stmt.executeUpdate();
        } catch (SQLException err) {
            System.err.println(err.getMessage());
            return 0;
        } finally {
            conexao.desconectar();
        }
    }

    public int alterar(Avaliacao obj) {
        conexao.conectar();

        String Sql = "update avaliacao set avaliacao=?,comentario=?,dataAvaliacao=? where codigo=?";

        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try {
            stmt.setInt(1, obj.getAvaliacao());
            stmt.setString(2, obj.getComentario());
            stmt.setDate(3, obj.getDataAvaliacao());
            stmt.setInt(4,obj.getCodigoAvaliacao());

            return stmt.executeUpdate();
        } catch (SQLException err) {
            System.err.println(err.getMessage());
            return 0;
        } finally {
            conexao.desconectar();
        }
    }

    public int remover(int codigoAvaliacao) {
        conexao.conectar();

        String Sql = "delete from avaliacao where codigo=?";

        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try {
            stmt.setInt(1,codigoAvaliacao);
            return stmt.executeUpdate();
        } catch (SQLException err) {
            System.err.println(err.getMessage());
            return 0;
        } finally {
            conexao.desconectar();
        }
    }


    public Avaliacao retorna(int codigoAvaliacao) {
        conexao.conectar();
        String Sql = "select codigo, avaliacao,comentario,dataAvaliacao from" +
                " avaliacao where  codigo=?";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try {
            stmt.setInt(1, codigoAvaliacao);
            ResultSet retorno = stmt.executeQuery();

            if (retorno.next()) {
                Avaliacao obj = new Avaliacao();
                obj.setCodigoAvaliacao(retorno.getInt("codigo"));
                obj.setAvaliacao(retorno.getInt("avaliacao"));
                obj.setDataAvaliacao(retorno.getDate("dataAvaliacao"));

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