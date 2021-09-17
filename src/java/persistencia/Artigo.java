package persistencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Artigo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int ordem_volume;
    private String idioma;
    private String titulo;
    private String titulo_en;
    private String resumo;
    private String resumo_en;
    private String palavras_chave;
    private String palavras_chave_en;
    
    @OneToMany(
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    @JoinColumn(name = "artigo")
    private List<Autor> autores = new ArrayList<>();
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOrdemVolume() {
        return ordem_volume; 
    }

    public void setOrdemVolume(int ordem_volume) {
        this.ordem_volume = ordem_volume;
    }

    public String getIdioma() {
        return idioma; 
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getTitulo() {
        return titulo; 
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTituloEn() {
        return titulo_en; 
    }

    public void setTituloEn(String titulo_en) {
        this.titulo_en = titulo_en;
    }

    public String getResumo() {
        return resumo; 
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }
    
    public String getResumoEn() {
        return resumo_en; 
    }

    public void setResumoEn(String resumo_en) {
        this.resumo_en = resumo_en;
    }

    public String getPalavrasChave() {
        return palavras_chave; 
    }

    public void setPalavrasChave(String palavras_chave) {
        this.palavras_chave = palavras_chave;
    }

    public String getPalavrasChaveEn() {
        return palavras_chave_en; 
    }

    public void setPalavrasChaveEn(String palavras_chave_en) {
        this.palavras_chave_en = palavras_chave_en;
    }

    public List<Autor> getListaAutores() {
        return autores; 
    }

    public void addAutor(Autor autor) {
        this.autores.add(autor);
    }
    
    public void removeAutor(Autor autor) {
        this.autores.remove(autor);
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Artigo)) {
            return false;
        }
        Artigo other = (Artigo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.ArtigoEntity[ id=" + id + " ]";
    }
    
}
