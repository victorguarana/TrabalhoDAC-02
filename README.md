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
|descricao_pt| String
|descricao_en| String
|lista_artigos| List\<Artigo\>	

### Listar Volumes
`GET /api/evento/volume`
### Selecionar Volume
`GET /api/evento/volume/{id}`
### Criar Volume
`POST /api/evento/volume`
 >  1. Os dados são recebidos via URL Encoded;
 >  2. O campo *' id'* é gerado automaticamente pela API, portanto, não deve ser enviado;
 >  3. O campo *'lista_artigos'* é preenchido automaticamente pela API, portanto, não deve ser enviado.
### Editar Volume
`PUT /api/evento/volume/{id}`
 >  1. Os dados são recebidos via URL Encoded;
 >  2. O campo *'lista_artigos'* é preenchido automaticamente pela API, portanto, não deve ser enviado.
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
|volume| Volume
|lista_autores| List\<Autor\>
### Listar Artigo
`GET /api/evento/artigo`
### Selecionar Artigo
`GET /api/evento/artigo/{id}`
### Criar Artigo
`POST /api/evento/artigo`
 >  1. Os dados são recebidos via URL Encoded;
 >  2. O campo *'id'* é gerado automaticamente pela API, portanto, não deve ser enviado;
 >  3. O campo *'volume'* recebe somente o campo *'id'* de seu Volume;
 >  4. O campo *'lista_autores'* é preenchido automaticamente pela API, portanto, não deve ser enviado.
### Editar Artigo
`PUT /api/evento/artigo/{id}`
 >  1. Os dados são recebidos via URL Encoded;
 >  2. O campo *'volume'* recebe somente o campo *'id'* de seu Volume;
 >  3. O campo *'lista_autores'* é preenchido automaticamente pela API, portanto, não deve ser enviado.
### Deletar Artigo
`DELETE /api/evento/artigo/{id}`

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
|artigo| Artigo

### Listar Autor
`GET /api/evento/autor`
### Selecionar Autor
`GET /api/evento/autor/{id}`
### Criar Autor
`POST /api/evento/autor`
 > 1. Os dados são recebidos via URL Encoded;
 > 2. O campo *'id'* é gerado automaticamente pela API, portanto, não deve ser enviado;
 > 3. O campo *'artigo'* recebe somente o campo *'id'* de seu Artigo, portanto, não deve ser enviado.
### Editar Autor
`PUT /api/evento/autor/{id}`
 > 1. Os dados são recebidos via URL Encoded;
 > 2. O campo *'artigo'* recebe somente o campo *'id'* de seu Artigo, portanto, não deve ser enviado.
### Deletar Autor
`DELETE /api/evento/autor/{id}`
