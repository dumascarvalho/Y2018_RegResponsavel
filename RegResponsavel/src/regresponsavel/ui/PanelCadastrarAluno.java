package regresponsavel.ui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PanelCadastrarAluno extends PanelAbstractAluno {

    public PanelCadastrarAluno() {
        super();
        lbTitulo.setText("Cadastrar Novo Aluno");
        btAbstract.setText("Cadastrar");
        tfProntuario.setEnabled(true);
    }

    @Override
    public void acaoAluno() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void acaoCancelar() {
        JFrame framePrincipal = (JFrame) SwingUtilities.getWindowAncestor(this);
        framePrincipal.setContentPane(FramePrincipal.panelCentral);
        framePrincipal.setSize(FramePrincipal.panelCentral.getSize());
        framePrincipal.pack();
        framePrincipal.setLocationRelativeTo(null);
    }
}