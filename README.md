# GerenciadorDeRestauranteREF

Refatoramento do projeto https://github.com/pedrobtenorio/GerenciadorDeRestaurante

bad smells encontrados que estou corrigindo:

*Codigo repetido sg.java linha 16 public void addSG e public garcom. java linha 16 void addGarcom e cozinheiro.java linha 22 public void addCozinheiro

*As classes mesa.java e cozinha.java sao muito grandes e e estao fazendo o trabalho de outras classes (large class)

*as classes sg.java cozinheiro.java e Garcom.java estao fazendo muito pouco (lazy class)
