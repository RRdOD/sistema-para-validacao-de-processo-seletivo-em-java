# Sistema para validação de processo seletivo em java

## Explicação do Código:
- Análise de Candidatos: O método analisarCandidato avalia cada candidato com base no salário pretendido.

- Seleção de Candidatos: O método selecaoCandidatos: Percorre uma lista de candidatos, Gera um salário pretendido aleatório para cada um, Seleciona aqueles que pediram salário igual ou abaixo do base (R$2000), 
Para quando atinge 5 selecionados

- Impressão de Selecionados: O método imprimirSelecionados mostra a lista de duas formas diferentes (com índice e simplificada).

- Tentativas de Contato: O método entrarEmContato: Tenta contatar cada candidato selecionado, Faz até 3 tentativas, Para se conseguir contato antes, Usa um método auxiliar tentarLigar que simula uma chance de 30% de atender

- Valores Aleatórios: O método valorPretendido gera valores entre 1800 e
2200 para simular as pretensões salariais.
