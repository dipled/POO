import string


class Pessoa:
    def __init__(self):
        self.nome = ""

    def setNome(self, nome: string):
        self.nome = nome

    def getNome(self):
        return self.nome
