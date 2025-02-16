# Desafio - Testes Automatizados no Sistema de Relatório de Pedidos ✅

## 🎯 Objetivo do Desafio
O objetivo deste desafio é praticar a implementação de testes automatizados no projeto, garantindo a confiabilidade e a qualidade do código refatorado. Os alunos devem escrever testes unitários e de integração para validar as principais funcionalidades do sistema de processamento de pedidos.

## 📝 Tarefas

1. **Configuração do Ambiente de Testes**
   - Adicione as dependências necessárias para testes no `pom.xml` (JUnit, Mockito, AssertJ, etc.).
   - Organize os testes na estrutura correta dentro do diretório `src/test/java`.

2. **Criação de Testes Unitários**
   - Escreva testes unitários para validar métodos críticos do sistema, como:
     - Leitura e processamento de arquivos (CSV, JSON e XML).
     - Cálculo de indicadores do relatório (montante de vendas, pedidos mais caros e baratos, total de categorias, etc.).
   - Utilize mocks quando necessário para simular dependências.

3. **Criação de Testes de Integração**
   - Implemente testes para validar a integração entre diferentes camadas do sistema.
   - Certifique-se de que os arquivos de entrada (CSV, JSON, XML) são processados corretamente e geram os resultados esperados.

4. **Execução Automatizada**
   - Configure o Maven para rodar os testes automaticamente (`mvn test`).

## 🚀 Desafio: Cobertura de Código
- Pesquise sobre o **JaCoCo** e descubra como utilizá-lo para medir a cobertura dos testes no seu projeto.
- Adicione o **JaCoCo** ao `pom.xml` e gere relatórios de cobertura de código.
- Analise os resultados e, se necessário, amplie a cobertura dos testes para abranger classes críticas do sistema.

---

### 🔍 Pontos de Atenção
- **Correção**: Os testes cobrem os principais fluxos e casos de borda?
- **Boas Práticas**: Os testes são organizados, claros e seguem boas práticas?
- **Execução Automatizada**: O projeto roda os testes de forma automática e eficiente?
- **Reflexão sobre Cobertura**: O que os relatórios do JaCoCo revelam sobre a qualidade dos testes?

💡 **Dica:** Utilize `TDD` sempre que possível e siga a pirâmide de testes para balancear testes unitários, de integração e de aceitação.

🚀 **Mãos à obra!** Escreva seus testes e garanta um código mais confiável! ✅
