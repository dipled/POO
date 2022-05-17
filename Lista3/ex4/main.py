from dados import *
alunos = []
professores = []
professor1 = Professor()
professor2 = Professor()

aluno1 = Aluno()
aluno2 = Aluno()
aluno3 = Aluno()
aluno4 = Aluno()
aluno5 = Aluno()

aluno1.setNome("Haskell Curry")
aluno1.setNotas([10,9.5,8])

aluno2.setNome("Cleber")
aluno2.setNotas([5,5.5,8])

aluno3.setNome("Douglas")
aluno3.setNotas([0,0,0])

aluno4.setNome("Josias")
aluno4.setNotas([7,7,7])

aluno5.setNome("Raymond Smullyan")
aluno5.setNotas([10,10,10])

professor1.setNome("Rafael")
professor1.setSalario(10000)

professor2.setNome("Bilbo Bolseiro")
professor2.setSalario(0)

print(professor1.__repr__())
print(professor2.__repr__())
print(aluno1.__repr__())
print(aluno2.__repr__())
print(aluno3.__repr__())
print(aluno4.__repr__())
print(aluno5.__repr__())

