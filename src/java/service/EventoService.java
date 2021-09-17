package service;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import persistencia.Artigo;
import persistencia.Autor;
import persistencia.JPAArtigoDAO;
import persistencia.JPAAutorDAO;
import persistencia.JPAVolumeDAO;
import persistencia.Volume;

@Path("evento")
public class EventoService {
    
    
    @Context
    UriInfo uriInfo;

    public EventoService() {
    }
    
        
    
    /*
    =====================================================
    ====================  POST  =========================
    =====================================================
    */
    
    
    
    @POST
    @Path("volume")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    public void createVolume(@FormParam("sigla") String sigla, @FormParam("edicao") int edicao, @FormParam("cidade") String cidade, @FormParam("data_inicio") String data_inicio, @FormParam("descricao") String descricao, @FormParam("descricao_en") String descricao_en) {
        JPAVolumeDAO dao = new JPAVolumeDAO();
        Volume v = new Volume();
        v.setSigla(sigla);
        v.setEdicao(edicao);
        v.setCidade(cidade);
        v.setDataInicio(data_inicio);
        v.setDescricao(descricao);
        v.setDescricaoEn(descricao_en);
        dao.cria(v);
    }
    
    @POST
    @Path("artigo")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    public void createArtigo(@FormParam("ordem_volume") int ordem_volume, @FormParam("idioma") String idioma, @FormParam("titulo") String titulo, @FormParam("titulo_en") String titulo_en, @FormParam("resumo") String resumo, @FormParam("resumo_en") String resumo_en, @FormParam("palavras_chave") String palavra_chave, @FormParam("palavras_chave_en") String palavra_chave_en, @FormParam("volume") long volume_id) {
        JPAVolumeDAO volume_dao = new JPAVolumeDAO();
        Volume volume = volume_dao.recupera(volume_id);
        Artigo artigo = new Artigo();
        artigo.setOrdemVolume(ordem_volume);
        artigo.setIdioma(idioma);
        artigo.setTitulo(titulo);
        artigo.setTituloEn(titulo_en);
        artigo.setResumo(resumo);
        artigo.setResumoEn(resumo_en);
        artigo.setPalavrasChave(palavra_chave);
        artigo.setPalavrasChaveEn(palavra_chave_en);
        volume.addArtigo(artigo);
        volume_dao.atualiza(volume);
    }
    
    @POST
    @Path("autor")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    public void createAutor(@FormParam("ordem_artigo") int ordem_artigo, @FormParam("email") String email, @FormParam("nome_primeiro") String nome_primeiro, @FormParam("nome_meio") String nome_meio, @FormParam("nome_ultimo") String nome_ultimo, @FormParam("afiliacao") String afiliacao, @FormParam("afiliacao_en") String afiliacao_en, @FormParam("pais") String pais, @FormParam("orcid") String orcid, @FormParam("artigo") long artigo_id) {
        JPAArtigoDAO artigo_dao = new JPAArtigoDAO();
        Artigo artigo = artigo_dao.recupera(artigo_id);
        Autor autor = new Autor();
        autor.setOrdemArtigo(ordem_artigo);
        autor.setEmail(email);
        autor.setNomePrimeiro(nome_primeiro);
        autor.setNomeMeio(nome_meio);
        autor.setNomeUltimo(nome_ultimo);
        autor.setAfiliacao(afiliacao);
        autor.setAfiliacaoEn(afiliacao_en);
        autor.setPais(pais);
        autor.setOrcid(orcid);
        artigo.addAutor(autor);
        artigo_dao.atualiza(artigo);
    }
    
    
    
    /*
    =====================================================
    ====================  GET  ==========================
    =====================================================
    */
    
    
    /*
    ====================  Individuais
    */
    
    @GET
    @Path("volume/{id}")
    @Produces({MediaType.APPLICATION_XML})
    public Volume findVolume(@PathParam("id") Long id) {
        JPAVolumeDAO dao = new JPAVolumeDAO();
        return dao.recupera(id);
    }

    @GET
    @Path("artigo/{id}")
    @Produces({MediaType.APPLICATION_XML})
    public Artigo findArtigo(@PathParam("id") Long id) {
        JPAArtigoDAO dao = new JPAArtigoDAO();
        return dao.recupera(id);
    }

    @GET
    @Path("autor/{id}")
    @Produces({MediaType.APPLICATION_XML})
    public Autor findAutor(@PathParam("id") Long id) {
        JPAAutorDAO dao = new JPAAutorDAO();
        return dao.recupera(id);
    }
    
    /*
    ====================  Lista do mestre
    */
    
    @GET
    @Path("volume/{id}/artigos")
    @Produces({MediaType.APPLICATION_XML})
    public List<Artigo> findVolumeArtigos(@PathParam("id") Long id) {
        JPAVolumeDAO dao = new JPAVolumeDAO();
        Volume v = dao.recupera(id);
        return v.getListaArtigos();
    }
    
    @GET
    @Path("artigo/{id}/autores")
    @Produces({MediaType.APPLICATION_XML})
    public List<Autor> findArtigoAutores(@PathParam("id") Long id) {
        JPAArtigoDAO dao = new JPAArtigoDAO();
        Artigo a = dao.recupera(id);
        return a.getListaAutores();
    }
    
    /*
    ====================  Todos por classe
    */
    
    @GET
    @Path("volume")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Volume> findAllVolumes() {
        JPAVolumeDAO dao = new JPAVolumeDAO();
        return dao.recuperaTodos();
    }

    @GET
    @Path("artigo")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Artigo> findAllArtigos() {
        JPAArtigoDAO dao = new JPAArtigoDAO();
        return dao.recuperaTodos();
    }
    
    @GET
    @Path("autor")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Autor> findAllAutor() {
        JPAAutorDAO dao = new JPAAutorDAO();
        return dao.recuperaTodos();
    }
    
        
    
    /*
    =====================================================
    ====================  PUT  ==========================
    =====================================================
    */
    
    
    
    @PUT
    @Path("volume/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void editVolume(@PathParam("id") Long id, Volume entity) {
        JPAVolumeDAO dao = new JPAVolumeDAO();
        entity.setId(id);
        dao.atualiza(entity);
    }

    @PUT
    @Path("artigo/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void editArtigo(@PathParam("id") Long id, Artigo entity) {
        JPAArtigoDAO dao = new JPAArtigoDAO();
        entity.setId(id);
        dao.atualiza(entity);
    }

    @PUT
    @Path("autor/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void editAutor(@PathParam("id") Long id, Autor entity) {
        JPAAutorDAO dao = new JPAAutorDAO();
        entity.setId(id);
        dao.atualiza(entity);
    }
    
        
    
    /*
    ========================================================
    ====================  DELETE  ==========================
    ========================================================
    */
    
    
    
    @DELETE
    @Path("volume/{id}")
    public void removeVolume(@PathParam("id") Long id) {
        JPAVolumeDAO dao = new JPAVolumeDAO();
        dao.remove(id);
    }
    
    @DELETE
    @Path("volume/{id_volume}/artigo/{id_artigo}")
    public void removeArtigo(@PathParam("id_volume") Long id_volume, @PathParam("id_artigo") Long id_artigo) {
        JPAArtigoDAO artigo_dao = new JPAArtigoDAO();
        Artigo artigo = artigo_dao.recupera(id_artigo);
        JPAVolumeDAO volume_dao = new JPAVolumeDAO();
        Volume volume = volume_dao.recupera(id_volume);
        volume.removeArtigo(artigo);
        volume_dao.atualiza(volume);
    }
    
    @DELETE
    @Path("artigo/{id_artigo}/autor/{id_autor}")
    public void removeAutor(@PathParam("id_artigo") Long id_artigo, @PathParam("id_autor") Long id_autor) {
        JPAAutorDAO autor_dao = new JPAAutorDAO();
        Autor autor = autor_dao.recupera(id_autor);
        JPAArtigoDAO artigo_dao = new JPAArtigoDAO();
        Artigo artigo = artigo_dao.recupera(id_artigo);
        artigo.removeAutor(autor);
        autor_dao.atualiza(autor);
    }
}
