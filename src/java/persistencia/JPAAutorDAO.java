package persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class JPAAutorDAO {
    
    private EntityManager em;
    
    public JPAAutorDAO() {
    }
        
    public void cria(Autor autor) {
        em = JPAUtil.getEM();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(autor);
        et.commit();
        em.close();
    }
    
    public void atualiza(Autor autor) {
        em = JPAUtil.getEM();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(autor);
        et.commit();
        em.close();
    }
        
    public Autor recupera(Long id) {
        
        em = JPAUtil.getEM();
        EntityTransaction et = em.getTransaction();
        et.begin();
        Autor autor = em.find(Autor.class, id);
        et.commit();
        em.close();
        return autor;
    }
    
    public List<Autor> recuperaTodos() {
        String jpqlQuery = "SELECT a FROM Autor a";
        em = JPAUtil.getEM();
        Query query = em.createQuery(jpqlQuery);
        List<Autor> autor = query.getResultList();
        em.close();
        return autor;
    }
    
    //Recupera os Autores a partir da id de um artigo
    public List<Autor> buscaPorArtigo(long id) {
        String jpqlQuery = "SELECT a FROM Autor a where a.id_artigo = :artigo order by a.ordem_artigo";
        em = JPAUtil.getEM();
        Query query = em.createQuery(jpqlQuery);
        query.setParameter("artigo", id);
        List<Autor> autor = query.getResultList();
        em.close();
        return autor;
    }
    
}
