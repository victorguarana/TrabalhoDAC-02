package persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class JPAVolumeDAO {
    
    private EntityManager em;
    
    public JPAVolumeDAO() {
    }
        
    public void salva(Volume volume) {
        
        em = JPAUtil.getEM();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(volume);
        et.commit();
        em.close();
    }
    
    public Volume recupera(Long id) {
        
        em = JPAUtil.getEM();
        EntityTransaction et = em.getTransaction();
        et.begin();
        Volume volume = em.find(Volume.class, id);
        et.commit();
        em.close();
        return volume;
    }
    
    public List<Volume> recuperaTodos() {
        String jpqlQuery = "SELECT v FROM Volume v";
        em = JPAUtil.getEM();
        Query query = em.createQuery(jpqlQuery);
        List<Volume> volume = query.getResultList();
        em.close();
        return volume;
    }
    
    public void remove(Long id) {
        
        em = JPAUtil.getEM();
        EntityTransaction et = em.getTransaction();
        et.begin();
        Volume v = em.find(Volume.class, id);
        em.remove(v);
        et.commit();
        em.close();
    }
}
