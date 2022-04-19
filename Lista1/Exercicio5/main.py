from dados import Funcionario
from dados import Conta

conta = Conta()
conta.setDesconto(False)
conta.setItensComprados(["abacate", "manga", "pera"])
conta.setValor(19.95)

func = Funcionario()

func.setNome("Jarbas")
func.setIdade(69)
func.setSexo("Homem")

print('\n')
print(conta)
print('\n\n')
print(func)