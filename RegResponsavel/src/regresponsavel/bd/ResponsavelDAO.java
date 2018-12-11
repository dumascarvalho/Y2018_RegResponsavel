package regresponsavel.bd;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import regresponsavel.model.AlunoModel;
import regresponsavel.model.ResponsavelModel;

public class ResponsavelDAO implements IResponsavelDAO {
    
    private EntityManager em = null;

    @Override
    public void cadastrarResponsavel(ResponsavelModel r) {
        try {
            em = ConnectionFactory.obterConexao(); 
            em.getTransaction().begin();
            em.persist(r);
            em.getTransaction().commit();
        } catch (Exception e)  {
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            em.close();
        }
    }

    @Override
    public void alterarResponsavel(ResponsavelModel r) {
        try {
            em = ConnectionFactory.obterConexao();             
            em.getTransaction().begin();
            em.merge(r);
            em.getTransaction().commit();
        } catch (Exception e)  {
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            em.close();
        }
    }

    @Override
    public void removerResponsavel(ResponsavelModel r) {
        try {
            em = ConnectionFactory.obterConexao();              
            em.getTransaction().begin();
            em.remove(em.getReference(ResponsavelModel.class, r.getCodigoPessoa()));
            em.getTransaction().commit();
        } catch (Exception e)  {
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            em.close();
        }
    }

    @Override
    public List obterResponsaveis(AlunoModel a) {
        try {
            em = ConnectionFactory.obterConexao();                  
            Query hql = em.createQuery("select object(r) from ResponsavelModel as r where r.aluno = " + a.getCodigoPessoa());
            return hql.getResultList();
        } catch (Exception e)  {
            return null;
        } finally {
            em.close();
        }
    }
}
