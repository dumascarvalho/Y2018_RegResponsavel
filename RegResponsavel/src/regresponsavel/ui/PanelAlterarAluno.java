package regresponsavel.ui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import regresponsavel.model.AlunoModel;

public class PanelAlterarAluno extends PanelAbstractAluno {

    public PanelAlterarAluno() {
        
    }

    public PanelAlterarAluno(AlunoModel a) {
        super();
        lbTitulo.setText("Alterar Cadastro do Aluno");
        btAbstract.setText("Alterar");
        tfProntuario.setEnabled(false);
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
}
