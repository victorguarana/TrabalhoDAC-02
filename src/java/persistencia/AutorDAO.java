package persistencia;

import java.util.List;

public interface AutorDAO {
    void salva(Autor e);    
    
    Autor recupera(long id);
    
    List<Autor> recuperaTodos();
    
    List<Autor> buscaPorArtigo(long id);

    void remove(long id);

}
