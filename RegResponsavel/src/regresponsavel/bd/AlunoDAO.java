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
            throw new RuntimeException(e);
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
            throw new RuntimeException(e);
        } finally {
            em.close();
        }
    }

    @Override
    public void removerAluno(AlunoModel a) {
        try {
            em = ConnectionFactory.obterConexao();              
            em.getTransaction().begin();
            em.remove(em.getReference(AlunoModel.class, a.getCodigoPessoa()));
            em.getTransaction().commit();
        } catch (Exception e)  {
            em.getTransaction().rollback();
            throw new RuntimeException(e);
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
        } catch (Exception e)  {
            throw new RuntimeException(e);
        } finally {
            em.close();
        }
    }

    @Override
    public AlunoModel obterDados(String prontuario) {
        try {
            em = ConnectionFactory.obterConexao();
            em.getTransaction().begin();

            Query hql = em.createQuery("select object(a) from AlunoModel as a where a.prontuario = :prontuario")
                    .setParameter("prontuario", prontuario);
            if (!hql.getResultList().isEmpty()) {
                AlunoModel a = (AlunoModel) hql.getSingleResult();
                em.getTransaction().commit();
                return a;
            } else {
                return null;
            }
        } catch (Exception e)  {
            return null;
        } finally {
            em.close();
        }   
    }
}
