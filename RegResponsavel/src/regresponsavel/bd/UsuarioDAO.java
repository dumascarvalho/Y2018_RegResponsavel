package regresponsavel.bd;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import regresponsavel.model.UsuarioModel;

public class UsuarioDAO implements IUsuarioDAO {
    
    private EntityManager em = null;

    @Override
    public void cadastrarUsuario(UsuarioModel u) {
        try {
            em = ConnectionFactory.obterConexao(); 
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        } catch (Exception e)  {
            em.getTransaction().rollback();
            throw new RuntimeException("Exceção: " + e);
        } finally {
            em.close();
        }
    }

    @Override
    public void alterarSenha(UsuarioModel u) {
        try {
            em = ConnectionFactory.obterConexao();             
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
        } catch (Exception e)  {
            em.getTransaction().rollback();
            throw new RuntimeException("Exceção: " + e);
        } finally {
            em.close();
        }
    } 

    @Override
    public boolean autenticarUsuario(String prontuario, String senha) {
        try {
            em = ConnectionFactory.obterConexao();
            em.getTransaction().begin();
            Query hql = em.createQuery("select object(u) from UsuarioModel as u where u.prontuario = :prontuario and u.senha = :senha")
                    .setParameter("prontuario", prontuario)
                    .setParameter("senha", senha);            
            List usuarios = hql.getResultList(); 
            em.getTransaction().commit();
            return (usuarios != null && !usuarios.isEmpty());
        } catch (Exception e)  {
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }   
    }

    @Override
    public UsuarioModel obterUsuario(String prontuario) {
        try {
            em = ConnectionFactory.obterConexao();
            UsuarioModel u = em.find(UsuarioModel.class, prontuario);
            return u;
        } catch (Exception e)  {
            throw new RuntimeException("Exceção: " + e);
        } finally {
            em.close();
        }    
    }
}
