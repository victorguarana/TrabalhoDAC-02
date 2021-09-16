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
    
    @POST
    @Path("volume")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    public void createVolume(@FormParam("sigla") String sigla, @FormParam("edicao") int edicao, @FormParam("cidade") String cidade, @FormParam("data_inicio") String data_inicio, @FormParam("descricao_pt") String descricao_pt, @FormParam("descricao_en") String descricao_en) {
        JPAVolumeDAO dao = new JPAVolumeDAO();
        Volume v = new Volume();
        v.setSigla(sigla);
        v.setEdicao(edicao);
        v.setCidade(cidade);
        v.setDataInicio(descricao_en);
        v.setDescricaoPt(descricao_pt);
        v.setDescricaoEn(descricao_en);
        dao.salva(v);
    }
    
    @POST
    @Path("artigo")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    public void createArtigo(@FormParam("ordem_volume") int ordem_volume, @FormParam("idioma") String idioma, @FormParam("titulo") String titulo, @FormParam("titulo_en") String titulo_en, @FormParam("resumo") String resumo, @FormParam("resumo_en") String resumo_en, @FormParam("palavra_chave") String palavra_chave, @FormParam("palavra_chave_en") String palavra_chave_en, @FormParam("volume") long volume_id) {
        JPAArtigoDAO dao = new JPAArtigoDAO();
        Artigo a = new Artigo();
        a.setOrdemVolume(ordem_volume);
        a.setIdioma(idioma);
        a.setTitulo(titulo);
        a.setTituloEn(titulo_en);
        a.setResumo(resumo);
        a.setResumoEn(resumo_en);
        a.setPalavrasChave(palavra_chave);
        a.setPalavrasChaveEn(palavra_chave_en);
        a.setVolume(volume_id);
        dao.salva(a);
    }
    
    @POST
    @Path("autor")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    public void createAutor(@FormParam("ordem_artigo") int ordem_artigo, @FormParam("email") String email, @FormParam("nome_primeiro") String nome_primeiro, @FormParam("nome_meio") String nome_meio, @FormParam("nome_ultimo") String nome_ultimo, @FormParam("afiliacao") String afiliacao, @FormParam("afiliacao_en") String afiliacao_en, @FormParam("pais") String pais, @FormParam("orcid") String orcid, @FormParam("artigo_id") long artigo_id) {
        JPAAutorDAO dao = new JPAAutorDAO();
        Autor a = new Autor();
        a.setOrdemArtigo(ordem_artigo);
        a.setEmail(email);
        a.setNomePrimeiro(nome_primeiro);
        a.setNomeMeio(nome_meio);
        a.setNomeUltimo(nome_ultimo);
        a.setAfiliacao(afiliacao);
        a.setAfiliacaoEn(afiliacao_en);
        a.setPais(pais);
        a.setOrcid(orcid);
        a.setArtigo(artigo_id);
        dao.salva(a);
    }
    
    @GET
    @Path("volume/{id}")
    @Produces({MediaType.APPLICATION_XML})
    public Volume findVolume(@PathParam("id") Long id) {
        JPAVolumeDAO dao = new JPAVolumeDAO();
        return dao.recupera(id);
    }
    
    @GET
    @Path("volume/{id}/artigos")
    @Produces({MediaType.APPLICATION_XML})
    public List<Artigo> findVolumeArtigos(@PathParam("id") Long id) {
        JPAVolumeDAO dao = new JPAVolumeDAO();
        Volume v = dao.recupera(id);
        return v.getListaArtigos();
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
    
    @PUT
    @Path("volume/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void editVolume(@PathParam("id") Long id, Volume entity) {
        JPAVolumeDAO dao = new JPAVolumeDAO();
        dao.salva(entity);
    }

    @PUT
    @Path("artigo/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void editArtigo(@PathParam("id") Long id, Artigo entity) {
        JPAArtigoDAO dao = new JPAArtigoDAO();
        dao.salva(entity);
    }

    @PUT
    @Path("autor/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void editAutor(@PathParam("id") Long id, Autor entity) {
        JPAAutorDAO dao = new JPAAutorDAO();
        dao.salva(entity);
    }
    
    @DELETE
    @Path("volume/{id}")
    public void removeVolume(@PathParam("id") Long id) {
        JPAVolumeDAO dao = new JPAVolumeDAO();
        dao.remove(id);
    }
    
    @DELETE
    @Path("artigo/{id}")
    public void removeArtigo(@PathParam("id") Long id) {
        JPAArtigoDAO dao = new JPAArtigoDAO();
        dao.remove(id);
    }
    
    @DELETE
    @Path("autor/{id}")
    public void removeAutor(@PathParam("id") Long id) {
        JPAAutorDAO dao = new JPAAutorDAO();
        dao.remove(id);
    }
}
