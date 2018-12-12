package regresponsavel.ui;

import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import regresponsavel.model.AlunoModel;
import regresponsavel.model.ResponsavelModel;

public class PanelAlterarAluno extends PanelAbstractAluno {
    
    private final int tipo;
   
    public PanelAlterarAluno() {
        super();
        this.tipo = 1; // Alterar Alunos do Menu Principal
        lbTitulo.setText("Alterar Cadastro do Aluno");
        btAbstract.setText("Alterar");
        btPesquisar.setVisible(true);
        limparTudo();
    }

    public PanelAlterarAluno(AlunoModel a) {
        super();
        this.tipo = 2; // Alterar Alunos da Tela de Visualizar Alunos
        this.aluno = a;
        lbTitulo.setText("Alterar Cadastro do Aluno");
        btAbstract.setText("Alterar");  
        tfProntuario.setEnabled(false);
        btPesquisar.setVisible(false);
        preencherCampos();
    }
    
    @Override
    protected void limparCampos() {

        tfNome.setText("");
        tfDataNascimento.setText("");
        tfTelefone.setText("");
 
        if (tipo == 1) {
            limparTudo();
        } else {
            tfNome.grabFocus();
        }
    } 
    
    private void limparTudo() {
        btAdicionar.setEnabled(false);
        btRemover.setEnabled(false);
        tfNome.setText("");
        tfNome.setEnabled(false);
        tfDataNascimento.setText("");
        tfDataNascimento.setEnabled(false);
        tfTelefone.setText("");
        tfTelefone.setEnabled(false);
        tfProntuario.setText("");
        tfProntuario.setEnabled(true);
        tfProntuario.grabFocus();
        AlunoModel modelo = new AlunoModel(); 
        responsaveis = rc.obterResponsaveis(modelo);
        preencherTabela(responsaveis);
    }
    
    private void preencherCampos() {
        btAdicionar.setEnabled(true);
        btRemover.setEnabled(true);
        tfNome.setText(aluno.getNome());
        tfNome.setEnabled(true);
        tfDataNascimento.setText(aluno.getDataNascimento());
        tfDataNascimento.setEnabled(true);
        tfTelefone.setText(aluno.getTelefone());
        tfTelefone.setEnabled(true);
        tfProntuario.setText(aluno.getProntuario());
        tfProntuario.setEnabled(false);
        responsaveis = rc.obterResponsaveis(aluno);
        preencherTabela(responsaveis);
        tfNome.grabFocus();
    }
    
    @Override
    public void acaoAluno() {
        try {
            if (!"".equals(tfProntuario.getText())) {
                aluno.setNome(tfNome.getText());
                aluno.setProntuario(tfProntuario.getText());
                aluno.setDataNascimento(tfDataNascimento.getText());
                aluno.setTelefone(tfTelefone.getText());
                aluno.setResponsavel(responsaveis);
                ac.alterar(aluno);

                Iterator<ResponsavelModel> i = responsaveis.iterator();

                while (i.hasNext()) {
                    ResponsavelModel responsavel = i.next();
                    rc.alterar(responsavel);
                }
                
                JOptionPane.showMessageDialog(this, "Aluno e seus respectivos responsáveis alterados com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "O prontuário não foi informado!", "Mensagem", JOptionPane.WARNING_MESSAGE);
                tfProntuario.grabFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro durante a alteração do aluno e seus respectivos responsáveis.", "Mensagem", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void acaoCancelar() {
        JFrame framePrincipal = (JFrame) SwingUtilities.getWindowAncestor(this);
        framePrincipal.dispose();    
    }

    @Override
    public void acaoPesquisar() {
        try {
            String prontuario = tfProntuario.getText();
            if ("".equals(prontuario)) {
                JOptionPane.showMessageDialog(this, "Favor informar um prontuário válido!", "Mensagem", JOptionPane.WARNING_MESSAGE);
                tfProntuario.setText("");
                tfProntuario.grabFocus();
            } else {      
                aluno = ac.obter(prontuario);                
                if (aluno != null) {
                    preencherCampos();
                } else {
                    JOptionPane.showMessageDialog(this, "Nenhum aluno foi encontrado, favor inserir um existente.", "Mensagem", JOptionPane.WARNING_MESSAGE);
                    limparTudo();
                }
            }
        } catch (Exception e) {
            limparCampos();
            JOptionPane.showMessageDialog(this, "Ocorreu um erro ao tentar pesquisar, favor tentar novamente.", "Mensagem", JOptionPane.ERROR_MESSAGE);
            limparTudo();
        }
    }
    
    @Override
    public void acaoAdicionar() {
        JFrame frame = new FrameCadastrarResponsavel(aluno, 2);
        frame.setVisible(true);
    }
    
    @Override
    public void acaoRemover() {
        try {
            int linhaSelecionada;
            if((linhaSelecionada = tbResponsaveis.getSelectedRow()) != -1) {
                rc.remover(responsaveis.get(linhaSelecionada));
                responsaveis.remove(linhaSelecionada);
                aluno.setResponsavel(responsaveis);
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
