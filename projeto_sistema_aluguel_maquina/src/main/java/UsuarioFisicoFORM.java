import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsuarioFisicoFORM extends JFrame{
    private JPanel Panel1;
    private JLabel CadastroLabel;
    private JTextField txtNome;
    private JTextField txtEmail;
    private JTextField txtTelefone;
    private JTextField txtSenha;
    private JButton buttonRemover;
    private JButton buttonAlterar;
    private JButton buttonPesquisar;
    private JButton buttonInserir;
    private JTextField txtCodigo;
    private JTextField txtCPF;

    public UsuarioFisicoFORM(){
        this.add(Panel1);
        this.setSize(500,700);
        this.setTitle("Cadastro de usuarios - pessoa física");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        buttonInserir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsuarioFisico obj = new UsuarioFisico();
                obj.setNome(txtNome.getText());
                obj.setCpf(txtCPF.getText());
                obj.setTelefone(txtTelefone.getText());
                obj.setEmail(txtEmail.getText());
                obj.setSenha(txtSenha.getText());
                obj.cadastrar();
            }
        });
        buttonRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsuarioFisico obj = new UsuarioFisico();
                obj.setCodigo(Integer.parseInt(txtCodigo.getText()));
                obj.remover();

            }
        });
        buttonAlterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsuarioFisico obj = new UsuarioFisico();
                obj.setNome(txtNome.getText());
                obj.setCpf(txtCPF.getText());
                obj.setTelefone(txtTelefone.getText());
                obj.setEmail(txtEmail.getText());
                obj.setSenha(txtSenha.getText());
                obj.setCodigo(Integer.parseInt(txtCodigo.getText()));
                obj.alterar();

            }
        });
        buttonPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsuarioFisicoDAO dao = new UsuarioFisicoDAO();
                UsuarioFisico obj = dao.retorna(Integer.parseInt(txtCodigo.getText()));
                txtNome.setText(obj.getNome());
                txtCPF.setText(obj.getCpf());
                txtEmail.setText(obj.getEmail());
                txtSenha.setText(obj.getSenha());
                txtTelefone.setText(obj.getTelefone());
            }
        });
    }


}
