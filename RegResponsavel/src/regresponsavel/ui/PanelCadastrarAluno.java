package regresponsavel.ui;

import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import regresponsavel.model.AlunoModel;
import regresponsavel.model.ResponsavelModel;

public class PanelCadastrarAluno extends PanelAbstractAluno {
        
    public PanelCadastrarAluno() {
        super();
        lbTitulo.setText("Cadastrar Novo Aluno");
        btAbstract.setText("Cadastrar");
        tfProntuario.setEnabled(true);
        btPesquisar.setVisible(false);        
        reinicializar();
    }
    
    private void reinicializar() {
        aluno = new AlunoModel();
        responsaveis = rc.recuperar(aluno);
        preencherTabela(responsaveis);
    }
    
    private void limparTudo() {
        limparCampos();
        reinicializar();
    }

    @Override
    public void acaoAluno() {
        try {
            if (!"".equals(tfProntuario.getText())) {
                aluno.setNome(tfNome.getText());
                aluno.setProntuario(tfProntuario.getText());
                aluno.setDataNascimento(tfDataNascimento.getText());
                aluno.setTelefone(tfTelefone.getText());
                ac.cadastrar(aluno);

                Iterator<ResponsavelModel> i = aluno.getResponsavel().iterator();

                while (i.hasNext()) {
                    ResponsavelModel responsavel = i.next();                                     
                    rc.cadastrar(responsavel);
                    System.out.println("\nRESPONSÁVEL INSERIDO: " + responsavel.getNome());
                }

                limparTudo();
                JOptionPane.showMessageDialog(this, "Aluno e seus respectivos responsáveis cadastrados com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "O prontuário não foi informado!", "Mensagem", JOptionPane.WARNING_MESSAGE);
                tfProntuario.grabFocus();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Ocorreu um erro durante a inserção do aluno e seus respectivos responsáveis.", "Mensagem", JOptionPane.ERROR_MESSAGE);
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
    public void acaoPesquisar() {
    
    }
}