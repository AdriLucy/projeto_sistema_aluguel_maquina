import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioJuridicoDAO {
    private Conexao conexao = new Conexao();

    public int inserir(UsuarioJuridico obj) {
        conexao.conectar();

        String Sql = "insert into usuario(nome,documento, senha,email, telefone) " +
                "values(?,?,?,?,?)";

        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try {
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCnpj());
            stmt.setString(3, obj.getSenha());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());

            return stmt.executeUpdate();
        } catch (SQLException err) {
            System.err.println(err.getMessage());
            return 0;
        } finally {
            conexao.desconectar();
        }
    }

    public int alterar(UsuarioJuridico obj) {
        conexao.conectar();

        String Sql = "update usuario set nome = ?,documento = ?, senha = ?,email = ?, telefone = ? where codigo=?";

        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try {
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCnpj());
            stmt.setString(3, obj.getSenha());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setInt(6,obj.getCodigo());

            return stmt.executeUpdate();
        } catch (SQLException err) {
            System.err.println(err.getMessage());
            return 0;
        } finally {
            conexao.desconectar();
        }
    }

    public int remover(int codigo) {
        conexao.conectar();

        String Sql = "delete from usuario where codigo=?";

        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try {
            stmt.setInt(1,codigo);
            return stmt.executeUpdate();
        } catch (SQLException err) {
            System.err.println(err.getMessage());
            return 0;
        } finally {
            conexao.desconectar();
        }
    }


    public UsuarioJuridico retorna(int codigo) {
        conexao.conectar();
        String Sql = "select codigo, nome,documento, senha, email, telefone from" +
                " usuario where codigo=?";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try {
            stmt.setInt(1, codigo);
            ResultSet retorno = stmt.executeQuery();

            if (retorno.next()) {
                UsuarioJuridico obj = new UsuarioJuridico();
                obj.setCodigo(retorno.getInt("codigo"));
                obj.setNome(retorno.getString("nome"));
                obj.setCnpj(retorno.getString("documento"));
                obj.setSenha(retorno.getString("senha"));
                obj.setEmail(retorno.getString("email"));
                obj.setTelefone(retorno.getString("telefone"));
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