from dados.Pessoa import Pessoa


class Professor(Pessoa):
    def __init__(self):
        Pessoa.__init__(self)
        self.__salario = 0

    def setSalario(self, salario: int):
        self.__salario = salario

    def getSalario(self):
        return self.__salario

    def __repr__(self):
        string = "Nome: {} | ".format(
            self.nome)+"Salario: {}".format(self.__salario)
        return string
