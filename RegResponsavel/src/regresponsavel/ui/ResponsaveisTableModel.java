package regresponsavel.ui;

import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.table.AbstractTableModel;
import regresponsavel.model.ResponsavelModel;

public class ResponsaveisTableModel extends AbstractTableModel implements Observer {
    
    private List<ResponsavelModel> listaResponsaveis;
    private final String[] colunas = {"Nome", "Data de Nascimento", "Telefone"};

    public ResponsaveisTableModel(List<ResponsavelModel> r) {
               
        this.listaResponsaveis = r;
        Iterator<ResponsavelModel> i = listaResponsaveis.iterator();
        
        while (i.hasNext()) {
            ResponsavelModel responsavel = i.next();
            responsavel.getAluno().addObserver(this);
            responsavel.addObserver(this);
        }
    }

    public ResponsaveisTableModel() {
        
    }
    
    @Override
    public int getRowCount() {
        return listaResponsaveis.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ResponsavelModel responsavel = listaResponsaveis.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return responsavel.getNome();
            case 1:
                return responsavel.getDataNascimento();
            case 2:
                return responsavel.getTelefone();
            default:
                return "Dado inválido";
        }
    }
    
    @Override 
    public void setValueAt(Object dado, int rowIndex, int columnIndex) {
        ResponsavelModel r = listaResponsaveis.get(rowIndex);
        switch(columnIndex) {
            case 0:
                String nome = (String) dado;
                r.setNome(nome);
                break;
            case 1:
                String dataNascimento = (String) dado;
                r.setDataNascimento(dataNascimento);
                break;
            case 2:
                String telefone = (String) dado;
                r.setTelefone(telefone);
                break;
        }
        listaResponsaveis.set(rowIndex, r);
    }  

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
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
