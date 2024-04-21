## Projeto HL7 FHIR Server

Este projeto consiste na implementação de um servidor HL7 FHIR (Fast Healthcare Interoperability Resources) utilizando tecnologias baseadas em Spring Framework.

### Objetivo

O objetivo principal deste projeto é fornecer uma base para o desenvolvimento de um servidor FHIR capaz de lidar com recursos de saúde interoperáveis de forma eficiente.

### Tecnologias Utilizadas

- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Quartz
- Thymeleaf
- Spring Boot DevTools
- Spring Boot Test
- Spring Boot Mail
- HAPI FHIR
- Lombok

### Funcionalidades Principais

- Implementação de um servidor FHIR capaz de lidar com recursos de saúde conforme o padrão FHIR.
- Utilização do HAPI FHIR para fornecer suporte ao protocolo FHIR.
- Integração com o banco de dados utilizando Spring Data JPA para persistência de dados.
- Agendamento de tarefas utilizando Spring Quartz.
- Envio de emails utilizando o Spring Boot Mail.

### Classes Principais

#### PatientProvider

Esta classe é responsável por prover recursos relacionados a pacientes (patients) seguindo as especificações do FHIR. Ela implementa a interface `IResourceProvider` do HAPI FHIR e disponibiliza métodos para operações CRUD (Create, Read, Update, Delete) de pacientes.

#### Patient

A classe `Patient` representa a entidade de paciente no contexto do servidor FHIR. Ela é mapeada como uma entidade JPA e possui atributos como id, nome e data de nascimento.

#### PatientConverter

Esta classe é responsável por converter objetos entre o modelo de dados do servidor FHIR e o modelo de dados utilizado pela aplicação. Ela realiza a conversão de objetos do tipo `Patient` para `com.mv.course.fhirplainserver.models.Patient` e vice-versa.

### Como Executar

1. Clone o repositório.
2. Certifique-se de ter o Java JDK e o Maven instalados.
3. Navegue até o diretório raiz do projeto no terminal.
4. Execute o comando `mvn spring-boot:run`.
5. O servidor estará em execução e pronto para receber requisições FHIR.

Este é um projeto em desenvolvimento e está sujeito a alterações. Sinta-se à vontade para explorar, contribuir e utilizar como referência para seus próprios projetos relacionados a FHIR.

Para dúvidas ou sugestões, por favor, entre em contato ou abra uma issue. Obrigado por visitar!
