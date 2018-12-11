package regresponsavel.ui;

import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import regresponsavel.model.AlunoModel;
import regresponsavel.model.ResponsavelModel;

public class PanelAlterarAluno extends PanelAbstractAluno {
    
    public PanelAlterarAluno() {
        super();
        lbTitulo.setText("Alterar Cadastro do Aluno");
        btAbstract.setText("Alterar");
        tfNome.setEnabled(false);
        tfDataNascimento.setEnabled(false);
        tfTelefone.setEnabled(false);
        tfProntuario.setEnabled(true);
        btPesquisar.setVisible(true);
        tfProntuario.grabFocus();
    }

    public PanelAlterarAluno(AlunoModel a) {
        super();
        this.aluno = a;
        lbTitulo.setText("Alterar Cadastro do Aluno");
        btAbstract.setText("Alterar");
        tfProntuario.setEnabled(false);
        btPesquisar.setVisible(false);
        tfNome.grabFocus();
        
        responsaveis = rc.recuperar(a);
        preencherTabela(rc.recuperar(a));
    }

    @Override
    protected void limparCampos() {
        tfNome.setText("");
        tfDataNascimento.setText("");
        tfTelefone.setText("");
        tfNome.grabFocus();
    } 
    
    @Override
    protected void acaoRemover() {
        try {
            int linhaSelecionada = tbResponsaveis.getSelectedRow();
            rc.remover(responsaveis.get(linhaSelecionada));
            responsaveis.remove(linhaSelecionada);
            preencherTabela(responsaveis);
            JOptionPane.showMessageDialog(this, "Responsável removido com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);         
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Nenhum responsável foi selecionado, favor tentar novamente.", "Mensagem", JOptionPane.WARNING_MESSAGE);         
        }
    }
    
    @Override
    protected void acaoAdicionar() {
        System.out.println("\nAO ADICIONAR (ALUNO): " + aluno.getNome());
        System.out.println("AO ADICIONAR (LISTA): " + responsaveis.size());
        JFrame frame = new FrameCadastrarResponsavel(aluno);
        frame.setVisible(true);
    }
    
    @Override
    public void acaoAluno() {
        try {
            if (!"".equals(tfProntuario.getText())) {
                aluno.setNome(tfNome.getText());
                aluno.setProntuario(tfProntuario.getText());
                aluno.setDataNascimento(tfDataNascimento.getText());
                aluno.setTelefone(tfTelefone.getText());
                ac.alterar(aluno);

                Iterator<ResponsavelModel> i = responsaveis.iterator();

                while (i.hasNext()) {
                    ResponsavelModel responsavel = i.next();
                    rc.alterar(responsavel);
                    System.out.println("\nRESPONSÁVEL ALTERADO: " + responsavel.getNome());
                }
                
                JOptionPane.showMessageDialog(this, "Aluno e seus respectivos responsáveis alterados com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "O prontuário não foi informado!", "Mensagem", JOptionPane.WARNING_MESSAGE);
                tfProntuario.grabFocus();
            }
        } catch (Exception e) {
            e.printStackTrace();
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
                tfProntuario.grabFocus();
            } else {      
                aluno = ac.obter(prontuario);
                
                if (aluno != null) {
                    tfNome.setText(aluno.getNome());
                    tfDataNascimento.setText(aluno.getDataNascimento());
                    tfTelefone.setText(aluno.getTelefone());

                    tfNome.setEnabled(true);
                    tfDataNascimento.setEnabled(true);
                    tfTelefone.setEnabled(true);
                    responsaveis = aluno.getResponsavel();
                    
                    System.out.println("\nABS - LISTA DE OBJETOS: " + responsaveis.size());
                    System.out.println("ABS - RESPONSÁVEIS DO ALUNO: " + aluno.getResponsavel().size());
 
                    preencherTabela(responsaveis);
                } else {
                    JOptionPane.showMessageDialog(this, "Nenhum aluno foi encontrado, favor inserir um existente.", "Mensagem", JOptionPane.WARNING_MESSAGE);
                    tfProntuario.grabFocus();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Ocorreu um erro ao tentar pesquisar, favor tentar novamente.", "Mensagem", JOptionPane.ERROR_MESSAGE);
            tfNome.setEnabled(false);
            tfDataNascimento.setEnabled(false);
            tfTelefone.setEnabled(false);
            tfProntuario.setText("");
            preencherTabela(responsaveis);
            tfProntuario.grabFocus();
        }
    }
}
