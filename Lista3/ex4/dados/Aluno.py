from dados.Pessoa import Pessoa
class Aluno(Pessoa):
    def __init__(self):
        Pessoa.__init__(self)
        self.__notas = []
    
    def setNotas(self, notas: list):
        self.__notas = notas
    
    def getNotas(self):
        return self.__notas
    
    def calcularMedia(self):
        soma = 0
        for i in self.__notas:
            soma += i
        return soma/len(self.__notas)
    
    def __repr__(self):
        string = "Nome: {} | ".format(self.nome) + "Media: {} | ".format(self.calcularMedia()) + "Notas: "
        size = len(self.__notas)
        for i in self.__notas:
            size -= 1
            if(size == 0):
                string += "{} ".format(i)    
            else:
                string += "{}, ".format(i)
        if(self.calcularMedia() >= 7):
            string += "| Status: Aprovado"
        else:
            string += "| Status: Reprovado"
        return string