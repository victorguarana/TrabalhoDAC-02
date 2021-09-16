package persistencia;

import java.util.List;

public interface VolumeDAO {
    void salva(Volume e);    
    
    Volume recupera(long id);
    
    List<Volume> recuperaTodos();
    
    void remove(long id);
    
}
