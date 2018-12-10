package regresponsavel.ui;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import regresponsavel.model.ResponsavelModel;

public class ResponsaveisTableModel extends AbstractTableModel {
    
    private final List<ResponsavelModel> listaResponsaveis;
    private final String[] colunas = {"Nome", "Data de Nascimento", "Telefone"};

    public ResponsaveisTableModel(List<ResponsavelModel> r) {
        listaResponsaveis = r;
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
}
