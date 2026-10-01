# 🔎 API Compliance

API backend desenvolvida em **Java 25 e Spring Boot** com o objetivo de realizar verificações de compliance através da integração com serviços externos.

O projeto simula um cenário em que uma empresa precisa realizar análises de **sanções, risco e exposição política (PEP)** antes de prosseguir com o cadastro ou relacionamento com uma empresa/pessoa.

A aplicação utiliza **Spring Cloud OpenFeign** para comunicação com APIs externas e **Circuit Breaker com Resilience4j** para aumentar a resiliência das integrações.

---

# 🎯 O que a API faz?

A API recebe informações de uma empresa e realiza um processo de **screening de compliance**.

Durante esse processo, a aplicação pode consultar serviços especializados para obter informações relacionadas a:

- 🚨 Sanções
- ⚠️ Score de risco
- 🚩 Indicadores de risco
- 🏛️ Pessoas Politicamente Expostas (PEP)
- 👤 Exposição política
- 📋 Listas de sanções
- 🔍 Confiança dos resultados encontrados

O resultado dessas consultas é transformado em objetos de domínio próprios da aplicação.

---

# 🔄 Fluxo da aplicação

O fluxo principal pode ser representado da seguinte forma:

```text
                    Cliente
                       │
                       ▼
              ┌─────────────────┐
              │    REST API      │
              └────────┬────────┘
                       │
                       ▼
              ┌─────────────────┐
              │   Application   │
              │      Layer      │
              └────────┬────────┘
                       │
                       ▼
              ┌─────────────────┐
              │     Domain      │
              │ Compliance      │
              │    Screening    │
              └────────┬────────┘
                       │
              ┌────────┴─────────┐
              ▼                  ▼
      ┌───────────────┐  ┌────────────────┐
      │ Feign Client  │  │  Repository    │
      └───────┬───────┘  └────────────────┘
              │
              ▼
      ┌───────────────────┐
      │ Serviços externos │
      │ de Compliance     │
      └─────────┬─────────┘
                │
                ▼
        Circuit Breaker
                │
                ▼
          Resilience4j
