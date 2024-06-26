import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MaquinaDAO {
    private Conexao conexao = new Conexao();

    public int inserir(Maquina obj) {
        conexao.conectar();

        String Sql = "insert into maquina(nomeMaquina,descricao,especificacaoTecnica,img,txAluguelHora,categoria) " +
                "values(?,?,?,?,?,?)";

        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try {
            stmt.setString(1, obj.getNomeMaquina());
            stmt.setString(2, obj.getDescricao());
            stmt.setString(3, obj.getEspecificacaoTecnica());
            stmt.setString(4, obj.getImagens());
            stmt.setDouble(5, obj.getTaxaAluguelHora());
            stmt.setString(6, obj.getCategoria());

            return stmt.executeUpdate();
        } catch (SQLException err) {
            System.err.println(err.getMessage());
            return 0;
        } finally {
            conexao.desconectar();
        }
    }

    public int alterar(Maquina obj) {
        conexao.conectar();

        String Sql = "update maquina set nomeMaquina=?,descricao=?,especificacaoTecnica=?,img=?,txAluguelHora=?,categoria=? where codigo=?";

        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try {
            stmt.setInt(1, obj.getCodigoMaquina());
            stmt.setString(2, obj.getNomeMaquina());
            stmt.setString(3, obj.getDescricao());
            stmt.setString(4, obj.getEspecificacaoTecnica());
            stmt.setString(5, obj.getImagens());
            stmt.setDouble(6, obj.getTaxaAluguelHora());
            stmt.setString(7, obj.getCategoria());

            return stmt.executeUpdate();
        } catch (SQLException err) {
            System.err.println(err.getMessage());
            return 0;
        } finally {
            conexao.desconectar();
        }
    }

    public int remover(int codigoMaquina) {
        conexao.conectar();

        String Sql = "delete from maquina where codigo=?";

        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try {
            stmt.setInt(1,codigoMaquina);
            return stmt.executeUpdate();
        } catch (SQLException err) {
            System.err.println(err.getMessage());
            return 0;
        } finally {
            conexao.desconectar();
        }
    }


    public Maquina retorna(int codigoMaquina) {
        conexao.conectar();
        String Sql = "select codigo, nomeMaquina,descricao,especificacaoTecnica,img,txAluguelHora,categoria from" +
                " maquina where codigo=?";
        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try {
            stmt.setInt(1, codigoMaquina);
            ResultSet retorno = stmt.executeQuery();

            if (retorno.next()) {
                Maquina obj = new Maquina();
                obj.setCodigoMaquina(retorno.getInt("codigo"));
                obj.setNomeMaquina(retorno.getString("nomeMaquina"));
                obj.setDescricao(retorno.getString("descricao"));
                obj.setEspecificacaoTecnica(retorno.getString("especificacaoTecnica"));
                obj.setImagens(retorno.getString("img"));
                obj.setTaxaAluguelHora(retorno.getDouble("txAluguelHora"));
                obj.setCategoria(retorno.getString("categoria"));

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