package regresponsavel.bd;

import java.util.List;
import regresponsavel.model.AlunoModel;
import regresponsavel.model.ResponsavelModel;

public interface IResponsavelDAO {
    
    public abstract void cadastrarResponsavel(ResponsavelModel r);
    
    public abstract void alterarResponsavel(ResponsavelModel r);
    
    public abstract void removerResponsavel(ResponsavelModel r);
    
    public abstract List obterResponsaveis(AlunoModel a);
    
    public abstract List obterTodosResponsaveis();
}
