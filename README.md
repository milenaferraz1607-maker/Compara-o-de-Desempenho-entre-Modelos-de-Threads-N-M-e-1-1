# Compara-o-de-Desempenho-entre-Modelos-de-Threads-N-M-e-1-1
Comparação de Desempenho entre Modelos de Trheads N:M e 1:1


Comparação de Desempenho entre Modelos de Threads N:M e 1:1

Milena Ferraz  
Linguagem: Java  

O objetivo deste trabalho é comparar o desempenho entre dois modelos de execução de threads:

- Modelo 1:1: cada thread de usuário é mapeada diretamente para uma thread do sistema operacional.
- Modelo N:M: múltiplas threads de usuário são multiplexadas sobre um conjunto menor de threads do sistema operacional.

A comparação é feita com base no tempo total de execução para diferentes quantidades de threads, permitindo analisar a eficiência e a escalabilidade de cada modelo.

 Como Executar


No terminal, dentro da pasta do projeto:

```bash
javac NMModel.java OneToOneModel.java Task.java

Execução do modelo 1:1
java OneToOneModel <num_threads> <iterations>

Exemplo:
java OneToOneModel 100 50

Execução do modelo N:M
java NMModel <num_threads> <pool_size> <iterations>

Exemplo:
java NMModel 100 8 50
<num_threads> → número total de threads simuladas
<pool_size> → quantidade de threads no pool (M)
<iterations> → quantidade de iterações da tarefa



