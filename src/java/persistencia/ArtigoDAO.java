package persistencia;

import java.util.List;

public interface ArtigoDAO {
    void salva(Artigo e);    
    
    Artigo recupera(long id);
    
    List<Artigo> recuperaTodos();
    
    List<Artigo> buscaPorVolume(long id);
    
    void remove(long id);

}
