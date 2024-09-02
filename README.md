# Sistema de Aluguel de Máquinas

## Descrição do Projeto

Este projeto foi desenvolvido para as disciplinas de **Programação Orientada a Objetos** e **Laboratório de Banco de Dados** do curso de **Tecnologia em Análise e Desenvolvimento de Sistemas (3º Semestre)**. O objetivo principal é criar um sistema completo de aluguel de máquinas, desde a modelagem de dados até o desenvolvimento do backend em Java.

## Objetivos

- Construir um Modelo de Entidade Relacional (MER).
- Criar um Diagrama de Entidade Relacional (DER) e um Diagrama de Classes.
- Construir as tabelas no MySQL e inserir dados.
- Desenvolver o backend do sistema em Java.

## Descrição do Sistema

O **Sistema de Aluguel de Máquinas** é uma plataforma online projetada para facilitar o processo de locação de máquinas e equipamentos para diversos fins, como uso pessoal, comercial ou industrial. A plataforma oferece um catálogo extenso de máquinas para aluguel, permitindo aos usuários navegar, selecionar, e alugar as máquinas de forma simples e conveniente.

### Funcionalidades Principais

- **Catálogo de Máquinas**: Visualização de máquinas com descrições detalhadas, especificações técnicas e imagens.
- **Aluguel de Máquinas**: Processo de aluguel com seleção de datas, horários e pagamento seguro online.
- **Avaliação e Feedback**: Sistema de avaliação para garantir a qualidade e segurança dos equipamentos.
- **Suporte ao Cliente**: Equipe de suporte disponível para assistência técnica e atendimento ao cliente.

## Modelagem de Dados

### Entidades e Atributos

- **Usuário**:
  - Atributos: `UserID` (chave primária), `Nome`, `Email`, `Senha`, `Número de telefone`.
  - Herança: `UsuarioFisico` (CPF), `UsuarioJuridico` (CNPJ).

- **Máquina**:
  - Atributos: `MachineID` (chave primária), `Nome da máquina`, `Descrição`, `Especificações técnicas`, `Imagens`, `Taxa de aluguel por hora`, `Categoria`.

- **Aluguel**:
  - Atributos: `RentalID` (chave primária), `UserID` (chave estrangeira), `MachineID` (chave estrangeira), `DataHora início`, `DataHora de término`, `Método de pagamento`, `Status`.

- **Avaliação**:
  - Atributos: `ReviewID` (chave primária), `UserID` (chave estrangeira), `MachineID` (chave estrangeira), `Avaliação` (classificação de 1 a 5), `Comentário`, `Data da avaliação`.

- **Equipe de Suporte**:
  - Atributos: `SupportID` (chave primária), `Nome do representante`, `Número de telefone de contato`, `Email de contato`.

### Relacionamentos

- Um usuário pode realizar **zero ou muitos aluguéis** (1:N entre Usuário e Aluguel).
- Uma máquina pode ser alugada em **zero ou muitos aluguéis** (1:N entre Máquina e Aluguel).
- Cada aluguel está associado a **um único usuário** e a **uma única máquina** (M:1 entre Aluguel e Usuário, M:1 entre Aluguel e Máquina).
- Uma avaliação está associada a **um único usuário** e **uma única máquina** (M:1 entre Avaliação e Usuário, M:1 entre Avaliação e Máquina).
- A equipe de suporte pode estar associada a **zero ou muitos aluguéis** para fornecer assistência (1:N entre Equipe de Suporte e Aluguel).

### Visualisar diagramas
- Para visualizar os diagramas de MER, DER e de classe, basta fazer download dos arquivos `Diagrama de entidade-relacionamento.docx` e `Modelo_de_classe_Case.docx` disponível no repositório!

## Tecnologias Utilizadas

- **Java**: Desenvolvimento do backend do sistema.
- **MySQL**: Modelagem e gerenciamento do banco de dados.
- **UML**: Criação de diagramas de classes e diagramas de entidade relacional.

## Estrutura do Projeto

- `src/`: Código-fonte do backend em Java.
- `docs/`: Documentação do projeto, incluindo diagramas e modelos de entidade-relacional.
- `sql/`: Scripts SQL para criação de tabelas e inserção de dados no MySQL.

## Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seuusuario/nome-do-repositorio.git
