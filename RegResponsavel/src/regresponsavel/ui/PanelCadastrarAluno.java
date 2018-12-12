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
        limparTudo();
    }
    
    private void reinicializar() {
        aluno = new AlunoModel();
        responsaveis = rc.obterResponsaveis(aluno);
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
                
                if (ac.obter(aluno.getProntuario()) == null) {
                    ac.cadastrar(aluno);

                    responsaveis = aluno.getResponsavel();
                    Iterator<ResponsavelModel> i = responsaveis.iterator();

                    while (i.hasNext()) {
                        ResponsavelModel responsavel = i.next();                                     
                        rc.cadastrar(responsavel);
                    }

                    limparTudo();
                    JOptionPane.showMessageDialog(this, "Aluno e seus respectivos responsáveis cadastrados com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Prontuário informado já existe, favor informar um novo!", "Mensagem", JOptionPane.WARNING_MESSAGE);
                    tfProntuario.setText("");
                    tfProntuario.grabFocus();
                }
            } else {
                JOptionPane.showMessageDialog(this, "O prontuário não foi informado!", "Mensagem", JOptionPane.WARNING_MESSAGE);
                tfProntuario.grabFocus();
            }
        } catch (Exception e) {
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
    
    @Override
    public void acaoAdicionar() {
        JFrame frame = new FrameCadastrarResponsavel(aluno, 1);
        frame.setVisible(true);
    }

    @Override
    public void acaoRemover() {        
        responsaveis = aluno.getResponsavel();        
        try {
            int linhaSelecionada;
            if ((linhaSelecionada = tbResponsaveis.getSelectedRow()) != -1) {
                responsaveis.remove(linhaSelecionada);
                preencherTabela(responsaveis); 
                JOptionPane.showMessageDialog(this, "Responsável removido com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);        
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum responsável foi selecionado, favor tentar novamente.", "Mensagem", JOptionPane.WARNING_MESSAGE);         
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro durante a remoção do responsável.", "Mensagem", JOptionPane.ERROR_MESSAGE);         
        }
    }
}