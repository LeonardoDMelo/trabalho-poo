# Trabalho Programação Orientada à Objetos

## Grupo Code Line Trouble (CLT)

### Descrição do Projeto:

Casa Já é um projeto de gerenciamento de Eventos de Casamento, com cadastro, leitura, remoção e atualização dos mesmos.

### Integrantes:

- Leonardo Davi de Melo
- Arthur

### Requisitos:

- [x] Pessoa
- [x] Usuário
- [x] Fornecedor
- [*] Evento
- [*] Cerimonial
- [*] Igreja
- [*] Cartório
- [*] Convidado
	- [*] Individual
	- [*] Familiar
- [x] Presentes
- [x] Mural de Recados
- [x] Pagamento

### Organização do Projeto:

- `/configs`: implementa a camada de configuração (onde as Views são devidamente inicializadas);
- `/constants`: implementa a camada de constantes utilizadas globalmente no projeto;
- `/controllers`: implementa a camada de roteamento (onde envia cada requisição para a regra de negócio certa dentro do service);
- `/daos`: implementa a camada de persistencia de dados (data access object);
- `/dtos`: implementa a camada de visualização de dados para o usuário (data transfer objects)
- `/entities`: implementa a camada de dados persistentes com o banco
- `/enums`: implementa a camada de estados dos dados;
- `/mappers`: implementa a camada de mapeamento de dados (de entidade para DTO e vice-versa);
- `/services`: implementa a camada de regras de negócio (onde fica todo o processamento bruto e lógica);
- `/views` -> implementa a camada de interação com o usuário (no caso, pelo console/terminal)

### Tecnologias Utilizadas:

- Java
- Orientação à Objetos
- Arquitetura Monolítica em Camadas
- Git e GiHub
- PostgreSQL
