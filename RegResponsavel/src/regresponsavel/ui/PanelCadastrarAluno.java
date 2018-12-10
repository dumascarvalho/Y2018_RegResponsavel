package regresponsavel.ui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import regresponsavel.controller.AlunoController;
import regresponsavel.model.AlunoModel;

public class PanelCadastrarAluno extends PanelAbstractAluno {
    
    private final AlunoController ac = new AlunoController();
    
    public PanelCadastrarAluno() {
        super();
        lbTitulo.setText("Cadastrar Novo Aluno");
        btAbstract.setText("Cadastrar");
        tfProntuario.setEnabled(true);
        btPesquisar.setVisible(false);
    }

    @Override
    public void acaoAluno() {
        try {
            a = new AlunoModel();
            a.setNome(tfNome.getText());
            a.setProntuario(tfProntuario.getText());
            a.setDataNascimento(tfDataNascimento.getText());
            a.setTelefone(tfTelefone.getText());
            ac.cadastrar(a);
        } catch (Exception e) {
            
        }
    }

    @Override
    public void acaoCancelar() {
        JFrame framePrincipal = (JFrame) SwingUtilities.getWindowAncestor(this);
        framePrincipal.setContentPane(FramePrincipal.panelCentral);
        framePrincipal.setSize(FramePrincipal.panelCentral.getSize());
        framePrincipal.pack();
        framePrincipal.setLocationRelativeTo(null);
    }

    @Override
    public void acaoAdicionar() {
        JFrame frame = new FrameCadastrarResponsavel(a);
        frame.setVisible(true);
    }
}