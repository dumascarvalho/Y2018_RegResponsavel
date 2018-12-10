package regresponsavel.bd;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import regresponsavel.model.AlunoModel;

public class AlunoDAO implements IAlunoDAO {
    
    private EntityManager em = null;

    @Override
    public void cadastrarAluno(AlunoModel a) {
        try {
            em = ConnectionFactory.obterConexao(); 
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
        } catch (Exception e)  {
            em.getTransaction().rollback();
            throw new RuntimeException("Exceção: " + e);
        } finally {
            em.close();
        }    
    }

    @Override
    public void alterarAluno(AlunoModel a) {
        try {
            em = ConnectionFactory.obterConexao();             
            em.getTransaction().begin();
            em.merge(a);
            em.getTransaction().commit();
        } catch (Exception e)  {
            em.getTransaction().rollback();
            throw new RuntimeException("Exceção: " + e);
        } finally {
            em.close();
        }
    }

    @Override
    public void removerAluno(AlunoModel a) {
        try {
            em = ConnectionFactory.obterConexao();              
            em.getTransaction().begin();
            em.remove(a);
            em.getTransaction().commit();
        } catch (Exception e)  {
            em.getTransaction().rollback();
            throw new RuntimeException("Exceção: " + e);
        } finally {
            em.close();
        }
    }
    
    @Override
    public List obterAlunos() {
        try {
            em = ConnectionFactory.obterConexao();                    
            Query q = em.createQuery("select object(a) from AlunoModel as a");
            return q.getResultList();
        } catch (Exception ex)  {
            throw new RuntimeException("Exceção: " + ex);
        } finally {
            em.close();
        }
    }
}
