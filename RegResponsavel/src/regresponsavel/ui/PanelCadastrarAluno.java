package regresponsavel.ui;

import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import regresponsavel.controller.AlunoController;
import regresponsavel.controller.ResponsavelController;
import regresponsavel.model.AlunoModel;
import regresponsavel.model.ResponsavelModel;

public class PanelCadastrarAluno extends PanelAbstractAluno {
    
    private final AlunoController ac = new AlunoController();
    private final ResponsavelController rc = new ResponsavelController();
    
    public PanelCadastrarAluno() {
        super();
        lbTitulo.setText("Cadastrar Novo Aluno");
        btAbstract.setText("Cadastrar");
        tfProntuario.setEnabled(true);
        btPesquisar.setVisible(false);
        
        reinicializar();
    }
    
    private void reinicializar() {
        a = new AlunoModel();
        responsaveis = rc.recuperar(a);
        preencherTabela(responsaveis);
    }
    
    private void limparTudo() {
        limparCampos();
        reinicializar();
    }

    @Override
    public void acaoAluno() {
        try {
            a.setNome(tfNome.getText());
            a.setProntuario(tfProntuario.getText());
            a.setDataNascimento(tfDataNascimento.getText());
            a.setTelefone(tfTelefone.getText());
            ac.cadastrar(a);
            
            Iterator<ResponsavelModel> i = responsaveis.iterator();

            while (i.hasNext()) {
                ResponsavelModel responsavel = i.next();
                rc.cadastrar(responsavel);  
            }
            
            limparTudo();            
            JOptionPane.showMessageDialog(this, "Aluno e seus responsáveis cadastrados com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);               
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Não foi possível realizar o cadastro, favor tentar novamente.", "Mensagem", JOptionPane.WARNING_MESSAGE);         
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
}