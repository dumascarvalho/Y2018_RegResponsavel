package regresponsavel.ui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import regresponsavel.model.AlunoModel;

public class PanelAlterarAluno extends PanelAbstractAluno {

    public PanelAlterarAluno() {
        super();
        lbTitulo.setText("Alterar Cadastro do Aluno");
        btAbstract.setText("Alterar");
        tfProntuario.setEnabled(true);
        btPesquisar.setVisible(true);
        tfProntuario.grabFocus();
    }

    public PanelAlterarAluno(AlunoModel a) {
        super();
        this.a = a;
        lbTitulo.setText("Alterar Cadastro do Aluno");
        btAbstract.setText("Alterar");
        tfProntuario.setEnabled(false);
        btPesquisar.setVisible(false);
        tfNome.grabFocus();
    }
    
    @Override
    public void acaoAluno() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void acaoCancelar() {
        JFrame framePrincipal = (JFrame) SwingUtilities.getWindowAncestor(this);
        framePrincipal.dispose();    
    }

    @Override
    public void acaoAdicionar() {
        JFrame frame = new FrameCadastrarResponsavel(a);
        frame.setVisible(true);
    }
}
