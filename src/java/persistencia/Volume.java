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
public class Volume implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String sigla;
    private int edicao;
    private String cidade;
    private String data_inicio;
    private String descricao_pt;
    private String descricao_en;
    @OneToMany(
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    @JoinColumn(name = "volume")
    private List<Artigo> artigos = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla; 
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public int getEdicao() {
        return edicao; 
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public String getCidade() {
        return cidade; 
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getDataInicio() {
        return data_inicio; 
    }

    public void setDataInicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getDescricaoPt() {
        return descricao_pt; 
    }

    public void setDescricaoPt(String descricao_pt) {
        this.descricao_pt = descricao_pt;
    }

    public String getDescricaoEn() {
        return descricao_en; 
    }

    public void setDescricaoEn(String descricao_en) {
        this.descricao_en = descricao_en;
    }
    
    public List<Artigo> getListaArtigos() {
        return artigos; 
    }

    public void addArtigo(Artigo artigo) {
        this.artigos.add(artigo);
    }

    public void removeArtigo(Artigo artigo) {
        this.artigos.remove(artigo);
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
        if (!(object instanceof Volume)) {
            return false;
        }
        Volume other = (Volume) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.VolumeEntity[ id=" + id + " ]";
    }
    
}
