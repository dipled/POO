import string


class Funcionario:
    def __init__(self):
        self.__nome = ""
        self.__idade = 0
        self.__sexo = ""
    def setNome(self, nome):
        self.__nome = nome
    def getNome(self):
        return self.__nome
    def setIdade(self, idade):
        self.__idade = idade
    def getIdade(self):
        return self.__idade
    def setSexo(self, sexo):
        self.__sexo = sexo
    def getSexo(self):
        return self.__sexo
    def __str__(self):
        return "Nome do funcionario: {}".format(self.__nome) + "\nIdade: {}".format(self.__idade) + "\nSexo: {}".format(self.__sexo)