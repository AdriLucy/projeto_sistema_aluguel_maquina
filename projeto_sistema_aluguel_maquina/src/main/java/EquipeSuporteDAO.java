import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EquipeSuporteDAO {
    private Conexao conexao = new Conexao();

    public int inserir(EquipeSuporte obj) {
        conexao.conectar();

        String Sql = "insert into equipe(nome,telefone,email) " +
                "values(?,?,?)";

        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try {
            stmt.setString(1, obj.getNomeRepresentante());
            stmt.setString(2, obj.getTelefone());
            stmt.setString(3, obj.getEmail());

            return stmt.executeUpdate();
        } catch (SQLException err) {
            System.err.println(err.getMessage());
            return 0;
        } finally {
            conexao.desconectar();
        }
    }

    public int alterar(EquipeSuporte obj) {
        conexao.conectar();

        String Sql = "update equipe set nome=?,telefone=?,email=? where codigo=?";

        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try {
            stmt.setString(1, obj.getNomeRepresentante());
            stmt.setString(2, obj.getTelefone());
            stmt.setString(3, obj.getEmail());
            stmt.setInt(4,obj.getCodigoEquipe());

            return stmt.executeUpdate();
        } catch (SQLException err) {
            System.err.println(err.getMessage());
            return 0;
        } finally {
            conexao.desconectar();
        }
    }

    public int remover(int codigoEquipe) {
        conexao.conectar();

        String Sql = "delete from equipe where codigo=?";

        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try {
            stmt.setInt(1,codigoEquipe);
            return stmt.executeUpdate();
        } catch (SQLException err) {
            System.err.println(err.getMessage());
            return 0;
        } finally {
            conexao.desconectar();
        }
    }


    public EquipeSuporte retorna(int codigoEquipe) {
        conexao.conectar();
        String Sql = "select codigo, nome,telefone,email from" +
                " equipe where codigo=?";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try {
            stmt.setInt(1, codigoEquipe);
            ResultSet retorno = stmt.executeQuery();

            if (retorno.next()) {
                EquipeSuporte obj = new EquipeSuporte();
                obj.setCodigoEquipe(retorno.getInt("codigo"));
                obj.setNomeRepresentante(retorno.getString("nome"));
                obj.setTelefone(retorno.getString("telefone"));
                obj.setEmail(retorno.getString("email"));

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