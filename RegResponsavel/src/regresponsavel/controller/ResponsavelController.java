package regresponsavel.controller;

import java.util.List;
import regresponsavel.bd.ResponsavelDAO;
import regresponsavel.model.AlunoModel;
import regresponsavel.model.ResponsavelModel;

public class ResponsavelController {
    
    private final ResponsavelDAO dao = new ResponsavelDAO();
    
    public ResponsavelController() {
        
    }

    public void cadastrar(ResponsavelModel r) {
        dao.cadastrarResponsavel(r);
    }

    public void alterar(ResponsavelModel r) {
        dao.alterarResponsavel(r);
    }
    
    public void remover(ResponsavelModel r) {
        dao.removerResponsavel(r);
    }
    
    public List recuperar(AlunoModel a) {
        return dao.obterResponsaveis(a);
    }
}