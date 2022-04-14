import string


class Funcionario:
    def __init__(self,nome:string, idade:int, sexo: string):
        self.nome = nome
        self.idade = idade
        self.sexo = sexo
    def __str__(self):
        return "Nome do funcionario: {}".format(self.nome) + "\nIdade: {}".format(self.idade) + "\nSexo: {}".format(self.sexo)