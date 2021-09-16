package persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class JPAArtigoDAO {
    
    private EntityManager em;
    
    public JPAArtigoDAO() {
    }
        
    public void salva(Artigo artigo) {
        
        em = JPAUtil.getEM();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(artigo);
        et.commit();
        em.close();
    }
    
    public Artigo recupera(Long id) {
        
        em = JPAUtil.getEM();
        EntityTransaction et = em.getTransaction();
        et.begin();
        Artigo artigo = em.find(Artigo.class, id);
        et.commit();
        em.close();
        return artigo;
    }
    
    public List<Artigo> recuperaTodos() {
        String jpqlQuery = "SELECT a FROM Artigo a";
        em = JPAUtil.getEM();
        Query query = em.createQuery(jpqlQuery);
        List<Artigo> artigo = query.getResultList();
        em.close();
        return artigo;
    }
    
    //Recupera os Artigos a partir da id de um Volume
    public List<Artigo> buscaPorVolume(long id) {
        String jpqlQuery = "SELECT a FROM Artigo a where a.id_volume = :volume order by ordem_volume";
        em = JPAUtil.getEM();
        Query query = em.createQuery(jpqlQuery);
        query.setParameter("volume", id);
        List<Artigo> artigo = query.getResultList();
        em.close();
        return artigo;
    }
    
    public void remove(Long id) {
        
        em = JPAUtil.getEM();
        EntityTransaction et = em.getTransaction();
        et.begin();
        Artigo a = em.find(Artigo.class, id);
        em.remove(a);
        et.commit();
        em.close();
    }
    
}
