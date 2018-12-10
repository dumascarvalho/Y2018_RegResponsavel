package regresponsavel.bd;

import java.util.List;
import regresponsavel.model.AlunoModel;

public interface IAlunoDAO {
    
    public abstract void cadastrarAluno(AlunoModel a);
    
    public abstract void alterarAluno(AlunoModel a);
    
    public abstract void removerAluno(AlunoModel a);
    
    public abstract List obterAlunos();
}
