package regresponsavel.ui;

import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.table.AbstractTableModel;
import regresponsavel.model.AlunoModel;

public class AlunosTableModel extends AbstractTableModel implements Observer {
    
    private List<AlunoModel> listaAlunos;
    private final String[] colunas = {"Prontuário", "Nome", "Qnt. de Responsáveis"};

    public AlunosTableModel(List<AlunoModel> a) {
               
        this.listaAlunos = a;
        Iterator<AlunoModel> i = listaAlunos.iterator();
        
        while (i.hasNext()) {
            AlunoModel aluno = i.next();
            aluno.addObserver(this);
        }
    }

    public AlunosTableModel() {
        
    }
    
    @Override
    public int getRowCount() {
        return listaAlunos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        AlunoModel aluno = listaAlunos.get(rowIndex);
       
        switch (columnIndex) {
            case 0:
                return aluno.getProntuario();
            case 1:
                return aluno.getNome();
            case 2:
                return aluno.getResponsavel().size();
            default:
                return "Dado inválido";
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public void update(Observable o, Object arg) {
        this.fireTableDataChanged();
    }
}
