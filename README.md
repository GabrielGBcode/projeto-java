# API de Gestão de Oficina Mecânica

## Sobre o projeto

Este projeto é uma API acadêmica para gestão de uma oficina mecânica, desenvolvida com foco em praticar programação orientada a objetos, organização de entidades, regras de negócio e persistência de dados.

A proposta do sistema é auxiliar no controle de clientes, veículos, funcionários, estoque, orçamentos e serviços realizados pela oficina.

---

## Objetivo

O objetivo principal do projeto é simular um sistema interno de oficina mecânica, permitindo organizar processos comuns do dia a dia, como:

* cadastro de clientes;
* cadastro de veículos;
* controle de funcionários;
* gerenciamento de estoque;
* criação de orçamentos;
* aprovação de orçamento antes da execução do serviço;
* registro de serviços realizados.

---

## Funcionalidades

### Clientes

* Cadastro de clientes;
* Consulta de clientes;
* Edição de informações;
* Associação de veículos ao cliente.

### Veículos

* Cadastro de veículos;
* Vinculação de um ou mais veículos a um cliente;
* Consulta de veículos cadastrados.

### Funcionários

* Cadastro de funcionários;
* Consulta de funcionários;
* Edição de dados cadastrais.

### Estoque

* Controle de peças e produtos;
* Registro de itens disponíveis;
* Atualização de quantidade em estoque.

### Orçamentos

* Criação de orçamento para um serviço;
* Aprovação ou reprovação do orçamento;
* Liberação do serviço apenas após aprovação.

### Serviços

* Registro dos serviços realizados;
* Associação entre cliente, veículo, orçamento e funcionário responsável.

---

## Regras de negócio

* Um cliente pode possuir um ou mais veículos;
* Um veículo deve estar associado a um cliente;
* Um serviço só pode ser realizado após aprovação do orçamento;
* O estoque deve ser consultado antes da execução de serviços que utilizem peças;
* Os dados devem ser organizados para permitir consultas futuras.

---

## Tecnologias utilizadas

* Java
* Programação Orientada a Objetos
* Manipulação de arquivos
* Git e GitHub

---

## Conceitos praticados

* Classes e objetos;
* Encapsulamento;
* Organização de pacotes;
* Métodos de cadastro, consulta e edição;
* Relacionamento entre entidades;
* Persistência simples de dados;
* Separação de responsabilidades;
* Estruturação de regras de negócio.

---

## Estrutura esperada do projeto

```text
projeto-java
├── cliente
│   ├── Cadastro_Cliente.java
│   ├── Consulta_Cliente.java
│   └── Editar_Cliente.java
│
├── funcionario
│   ├── Cadastro_Funcionario.java
│   ├── Consulta_Funcionario.java
│   └── Editar_Funcionario.java
│
├── orcamento
│   ├── Solicitacao_Orcamento.java
│   └── Aprovacao_Orcamento.java
│
├── servico
│   └── Main.java
│
└── arquivos de dados
```

---

## Como executar

Clone o repositório:

```bash
git clone https://github.com/GabrielGBcode/projeto-java.git
```

Acesse a pasta do projeto:

```bash
cd projeto-java
```

Compile os arquivos Java:

```bash
javac caminho/do/arquivo/Main.java
```

Execute o projeto:

```bash
java caminho.do.pacote.Main
```

> Os comandos podem variar de acordo com a estrutura final de pacotes e pastas do projeto.

---

## Status do projeto

> Projeto acadêmico em desenvolvimento.

O sistema ainda pode passar por melhorias na organização do código, persistência dos dados, validações e documentação técnica.

---

## Melhorias futuras

* Melhorar a organização das classes;
* Criar uma camada de serviço para concentrar regras de negócio;
* Substituir arquivos `.txt` por JSON ou banco de dados;
* Adicionar validações de CPF, e-mail e telefone;
* Criar tratamento de erros mais robusto;
* Melhorar a estrutura de menus;
* Documentar exemplos de uso;
* Adicionar testes automatizados.

---

## Autor

Desenvolvido por **Gabriel Gomes Batista** como projeto acadêmico para praticar Java, orientação a objetos e modelagem de sistemas.
