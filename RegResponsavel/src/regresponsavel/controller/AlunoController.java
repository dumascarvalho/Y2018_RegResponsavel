package regresponsavel.controller;

import java.util.List;
import regresponsavel.bd.AlunoDAO;
import regresponsavel.model.AlunoModel;

public class AlunoController {
    
    private final AlunoDAO dao = new AlunoDAO();
    
    public AlunoController() {
        
    }

    public void cadastrar(AlunoModel a) {
        dao.cadastrarAluno(a);
    }

    public void alterar(AlunoModel a) {
        dao.alterarAluno(a);
    }
    
    public void remover(AlunoModel a) {
        dao.removerAluno(a);
    }
    
    public List recuperar() {
        return dao.obterAlunos();
    }
    
    public AlunoModel obter(String prontuario) {
        return dao.obterDados(prontuario);
    }
}
