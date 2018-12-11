package regresponsavel.bd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
    
    private static EntityManagerFactory emf;

    public static EntityManager obterConexao() {
        try {
            if (emf == null)
                emf = Persistence.createEntityManagerFactory("RegResponsavelPU");
            return emf.createEntityManager();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;        
    }     
}
