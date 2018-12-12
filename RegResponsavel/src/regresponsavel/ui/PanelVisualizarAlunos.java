package regresponsavel.ui;

import java.util.Collections;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import regresponsavel.controller.AlunoController;
import regresponsavel.model.AlunoModel;
import regresponsavel.model.ComparadorAlunosPorProntuario;
import regresponsavel.model.ComparadorResponsaveisPorQuantidade;

public class PanelVisualizarAlunos extends javax.swing.JPanel {

    private List<AlunoModel> alunos;
    private final AlunoController ac = new AlunoController();
    private final JFrame alterarAluno = new JFrame();
    
    public PanelVisualizarAlunos() {
        initComponents();
        obterTodosAlunos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitulo = new javax.swing.JLabel();
        btOrdenarProntuario = new javax.swing.JButton();
        btOrdenarResponsavel = new javax.swing.JButton();
        btOrdenarNome = new javax.swing.JButton();
        btAlterarAluno = new javax.swing.JButton();
        btRemover = new javax.swing.JButton();
        lbProcurar = new javax.swing.JLabel();
        btProcurarAluno = new javax.swing.JButton();
        tfProntuarioProcurar = new javax.swing.JTextField();
        jsBarraRolagem = new javax.swing.JScrollPane();
        tbAlunos = new javax.swing.JTable();
        btCancelar = new javax.swing.JButton();

        lbTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo.setText("Visualização de Alunos");

        btOrdenarProntuario.setText("Ordernar por Prontuário do Aluno");
        btOrdenarProntuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOrdenarProntuarioActionPerformed(evt);
            }
        });

        btOrdenarResponsavel.setText("Ordernar por Maior Qnt. de Responsáveis");
        btOrdenarResponsavel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOrdenarResponsavelActionPerformed(evt);
            }
        });

        btOrdenarNome.setText("Ordernar por Nome do Aluno");
        btOrdenarNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOrdenarNomeActionPerformed(evt);
            }
        });

        btAlterarAluno.setText("Alterar");
        btAlterarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarAlunoActionPerformed(evt);
            }
        });

        btRemover.setText("Remover");
        btRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverActionPerformed(evt);
            }
        });

        lbProcurar.setText("Procurar pelo Prontuário:");

        btProcurarAluno.setText("Procurar");
        btProcurarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProcurarAlunoActionPerformed(evt);
            }
        });

        tfProntuarioProcurar.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        tbAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jsBarraRolagem.setViewportView(tbAlunos);

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbProcurar)
                        .addGap(18, 18, 18)
                        .addComponent(tfProntuarioProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btProcurarAluno)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btOrdenarNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btOrdenarProntuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btOrdenarResponsavel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(btAlterarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jsBarraRolagem, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lbTitulo)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbProcurar)
                    .addComponent(btProcurarAluno)
                    .addComponent(tfProntuarioProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jsBarraRolagem, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btOrdenarProntuario)
                    .addComponent(btRemover)
                    .addComponent(btAlterarAluno)
                    .addComponent(btCancelar))
                .addGap(18, 18, 18)
                .addComponent(btOrdenarNome)
                .addGap(16, 16, 16)
                .addComponent(btOrdenarResponsavel)
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void obterTodosAlunos() {
        alunos = ac.recuperar();
        preencherTabela(alunos);
    }
    
    private void preencherTabela(List<AlunoModel> alunos) {
        AlunosTableModel modeloTabela = new AlunosTableModel(alunos);
        tbAlunos.setModel(modeloTabela);
    }
    
    private void abrirAlterarAluno(AlunoModel aluno) {
        if (!alterarAluno.isVisible()) {
            alterarAluno.setContentPane(new PanelAlterarAluno(aluno));
            alterarAluno.setSize(this.getPreferredSize());
            alterarAluno.pack();
            alterarAluno.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            alterarAluno.setLocationRelativeTo(null);
            alterarAluno.setTitle("Alterar Cadastro do Aluno");
            alterarAluno.setResizable(false);
            alterarAluno.setVisible(true);
        } else {
            alterarAluno.setContentPane(new PanelAlterarAluno(aluno));
            alterarAluno.validate();
            alterarAluno.setLocationRelativeTo(null);
            alterarAluno.requestFocus();
        }
    }
    
    private void btOrdenarProntuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOrdenarProntuarioActionPerformed
        alunos = ac.recuperar();
        alunos.sort(new ComparadorAlunosPorProntuario());
        preencherTabela(alunos);
    }//GEN-LAST:event_btOrdenarProntuarioActionPerformed

    private void btOrdenarResponsavelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOrdenarResponsavelActionPerformed
        alunos = ac.recuperar();
        alunos.sort(new ComparadorResponsaveisPorQuantidade());
        preencherTabela(alunos);
    }//GEN-LAST:event_btOrdenarResponsavelActionPerformed

    private void btOrdenarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOrdenarNomeActionPerformed
        alunos = ac.recuperar();
        Collections.sort(alunos);
        preencherTabela(alunos);
    }//GEN-LAST:event_btOrdenarNomeActionPerformed

    private void btAlterarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarAlunoActionPerformed
        try {
            int linhaSelecionada;
            if ((linhaSelecionada = tbAlunos.getSelectedRow()) != -1) {
                AlunoModel aluno;
                aluno = alunos.get(linhaSelecionada);
                abrirAlterarAluno(aluno);
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum aluno foi selecionado, favor tentar novamente!", "Mensagem", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro ao abrir o painél de alterações do aluno.", "Mensagem", JOptionPane.ERROR_MESSAGE);
        }        
    }//GEN-LAST:event_btAlterarAlunoActionPerformed

    private void btRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverActionPerformed
        try {
            int linhaSelecionada;
            if ((linhaSelecionada = tbAlunos.getSelectedRow()) != -1) {
                AlunoModel aluno;
                aluno = alunos.get(linhaSelecionada);
                ac.remover(aluno);
                obterTodosAlunos();
                JOptionPane.showMessageDialog(this, "O aluno foi removido com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum aluno foi selecionado, favor tentar novamente!", "Mensagem", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Ocorreu um erro ao remover o aluno selecionado.", "Mensagem", JOptionPane.ERROR_MESSAGE);
        }   
    }//GEN-LAST:event_btRemoverActionPerformed

    private void btProcurarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProcurarAlunoActionPerformed
        try {
            String filtro = tfProntuarioProcurar.getText();            
            AlunoModel modelo;
            modelo = ac.obter(filtro);
            if (modelo != null) {
                alunos.clear();
                alunos.add(modelo);            
                preencherTabela(alunos);     
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum aluno foi encontrado, favor tentar novamente!", "Mensagem", JOptionPane.WARNING_MESSAGE);
                tfProntuarioProcurar.setText("");
                tfProntuarioProcurar.grabFocus();
                obterTodosAlunos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro ao buscar pelo aluno informado.", "Mensagem", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btProcurarAlunoActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        JFrame framePrincipal = (JFrame) SwingUtilities.getWindowAncestor(this);
        framePrincipal.setContentPane(FramePrincipal.panelCentral);
        framePrincipal.setSize(FramePrincipal.panelCentral.getSize());
        framePrincipal.pack();
        framePrincipal.setLocationRelativeTo(null);
    }//GEN-LAST:event_btCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterarAluno;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btOrdenarNome;
    private javax.swing.JButton btOrdenarProntuario;
    private javax.swing.JButton btOrdenarResponsavel;
    private javax.swing.JButton btProcurarAluno;
    private javax.swing.JButton btRemover;
    private javax.swing.JScrollPane jsBarraRolagem;
    private javax.swing.JLabel lbProcurar;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JTable tbAlunos;
    private javax.swing.JTextField tfProntuarioProcurar;
    // End of variables declaration//GEN-END:variables
}
