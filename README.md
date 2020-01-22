# GerenciadorDeRestauranteREF

Refatoramento do projeto https://github.com/pedrobtenorio/GerenciadorDeRestaurante

bad smells encontrados que estou corrigindo:

1 - Codigo repetido (duplicated code)
Garcom.java linha 16 void addGarcom 
Cozinheiro.java linha 22 public void addCozinheiro
Esses metodos eram usados para adicionar os funcionarios, eram extremamente parecidos.


2 - As classes Mesas.java e Cozinha.java sao muito grandes e e estao fazendo o trabalho de outras classes (large class)

3 - as classes  cozinheiro.java e Garcom.java estao fazendo muito pouco (lazy class)

Soluções:

1 - Foi criado na super classe Funcionario.java o metodo addFuncionario na linha 20 que serve para adicionar qualquer tipo de funcionario e identifica em tempo de execução o tipo.

2 - Foram removidos os metodos public void anotarPedido e public void entregarPedido da classe Mesas.java, pois esses metodos depende da ação de um Garçom e não faz sentido a mesa estar implementando eles 
Foram removidos os metodos public void colocarEmAndamento e public void mudarParaPronto da classe Cozinha.java, pois esses metodos depende da ação de um Cozinheiro e não faz sentido a Cozinha estar implementando eles 

3 - As classes Garcom.java e Cozinheiro.java so serviam para adicionar esses tipos de funcionarios com os metodos addGarcom e addCozinheiro.
Na classe Garcom.java foram adicionados os metodos retirados da classe Mesas.java, public void anotarPedido e public void entregarPedido, fazendo a classe Garcom ter mais utilidade. 
Na classe Cozinheiro.java foram adicionados os metodos retirados da classe Cozinha.java,public void colocarEmAndamento e public void mudarParaPronto, fazendo a classe Cozinheiro ter mais utilidade



