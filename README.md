# Blog

Vídeo de demonstração: https://www.youtube.com/watch?v=YdeGvApNcms

Se trata de uma API REST feita em Java/Spring Boot, utilizando banco de dados MySQL. A API possui funcionalidades de Login utilizando JWT, e os seguintes end-poinst: </br></br>
POST /user (cadastra usuário no banco e não precisa estar "logado")</br>
POST /login (faz login na API, que retorna um Token JWT que é utilizado no cabeçalho para fazer a autenticação por requisção, por se STATELESS e não precisa estar "logado")</br>
POST /post (cadastra uma nova postagem no blog e precisa estar "logado")</br>
DELETE /post/id (deleta um post da banco e precisa estar "logado")</br>
PUT /post/id (atualiza a mensagem de post no banco e precisa estar "logado")</br>
GET /post (retorna todos os posts e não precisa estar "logado")</br>
GET /post/id (retorna o posts do ID específico e não precisa estar "logado")</br>
GET /post?nomeAutor=Autor (retorna posts daquele autor em específico e não precisa estar "logado")
