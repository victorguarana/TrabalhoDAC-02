
# Trabalho de Desenvolvimento de Aplicações Corporativas - 02 


A API desenvolvida nesse trabalho está disponibilizada no caminho `http://{host}/api/evento`

## Volume
| Property   |Type
|----------------|-------------------------------|
|id | Long
|sigla| String
|edicao| Int
|cidade| String
|data| String
|descricao| String
|descricao_en| String

### Listar Volumes
`GET /api/evento/volume`
### Selecionar Volume
`GET /api/evento/volume/{id}`
### Criar Volume
`POST /api/evento/volume`
 >  1. Os dados são recebidos via URL Encoded;
 >  2. O campo *' id'* é gerado automaticamente pela API, portanto, não deve ser enviado.
### Editar Volume
`PUT /api/evento/volume/{id}`
 >  1. Os dados devem ser enviados no formato XML.
##### Exemplo de XML
    <volume>
    	<cidade>Cidade</cidade>
    	<dataInicio>01/01/2021</dataInicio>	
    	<descricao>Descrição em portugês</descricao>
    	<descricaoEn>Description in English</descricaoEn>
    	<edicao>1</edicao>
    	<sigla>SIGLA</sigla>
    </volume>
### Deletar Volume
`DELETE /api/evento/volume/{id}`

## Artigo
| Property   |Type
|----------------|-------------------------------|
|id | Long
|ordem_volume| Int
|idioma| String
|titudo| String
|titulo_en| String
|resumo| String
|resumo_en| String	
|palavras_chave| String
|palavras_chave_en| String	
### Listar Artigo
`GET /api/evento/artigo`
### Selecionar Artigo
`GET /api/evento/artigo/{id}`
### Listar Artigos de determinado Volume
`GET /api/evento/volume/{id_volume}/artigos`
### Criar Artigo
`POST /api/evento/artigo`
 >  1. Os dados são recebidos via URL Encoded;
 >  2. O campo *'id'* é gerado automaticamente pela API, portanto, não deve ser enviado;
 >  3. Deve ser incluído um campo chamado *'volume'* com a *id* do volume que este artigo será relacionado.
### Editar Artigo
`PUT /api/evento/artigo/{id}`
 >  1. Os dados devem ser enviados no formato XML.
 >  2. O campo *'volume'* recebe somente o campo *'id'* de seu Volume.
##### Exemplo de XML:
     <artigo>
    	<idioma>PT-BR</idioma>
    	<ordemVolume>1</ordemVolume>
    	<palavrasChave>Palavras Chave</palavrasChave>
    	<palavrasChaveEn>Key Words</palavrasChaveEn>
    	<resumo>Resumo</resumo>
    	<resumoEn>Summary</resumoEn>
    	<titulo>Titulo</titulo>
    	<tituloEn>Title</tituloEn>
    </artigo>
### Deletar Artigo
`DELETE /api/evento/volume/{id_volume}/artigo/{id_artigo}`

## Autor
| Property   |Type
|----------------|-------------------------------|
|id | Long
|ordem_artigo| Int
|email| String
|nome_primeiro| String
|nome_meio| String
|nome_ultimo| String
|afiliacao| String	
|afiliacao_en| String	
|pais| String	
|orcid| String

### Listar Autor
`GET /api/evento/autor`
### Selecionar Autor
`GET /api/evento/autor/{id}`
### Listar Autores de determinado Artigo
`GET /api/evento/volume/{id_volume}/autores`
### Criar Autor
`POST /api/evento/autor`
 > 1. Os dados são recebidos via URL Encoded;
 > 2. O campo *'id'* é gerado automaticamente pela API, portanto, não deve ser enviado;
 > 3. Deve ser incluído um campo chamado *'artigo'* com a *id* do artigo que este autor será relacionado.
### Editar Autor
`PUT /api/evento/autor/{id}`
 > 1. Os dados devem ser enviados no formato XML.
##### Exemplo de XML:

    <autor>
    	<afiliacao>Afiliacao</afiliacao>
    	<afiliacaoEn>Afiliacao</afiliacaoEn>
    	<email>e-mail</email>
    	<nomePrimeiro>Primeiro</nomePrimeiro>
    	<nomeMeio>Meio</nomeMeio>
    	<nomeUltimo>Ultimo</nomeUltimo>
    	<orcid>XXXXXXX</orcid>
    	<ordemArtigo>1</ordemArtigo>
    	<pais>Br</pais>
    </autor>

### Deletar Autor
`DELETE /api/evento/artigo/{id_artigo}autor/{id_autor}`
