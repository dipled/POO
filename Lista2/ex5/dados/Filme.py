import json
import string
class Filme:
    def __init__(self):
        self.__titulo = ""
        self.__ano = 0
        self.__classificacao = ""
        self.__nota = 0.0
    def setTitulo(self, titulo: string):
        self.__titulo = titulo
    def getTitulo(self):
        return self.__titulo
    def setAno(self, ano: int):
        self.__ano = ano
    def getAno(self):
        return self.__ano
    def setClassificacao(self, classificacao: string):
        self.__classificacao = classificacao
    def getClassificacao(self):
        return self.__classificacao
    def setNota(self, nota: float):
        self.__nota = nota
    def getNota(self):
        return self.__nota
    def jsonInit(self, json:dict):
        self.setTitulo(json['titulo'])
        self.setAno(json['ano'])
        self.setClassificacao(json['classificacao'])
        self.setNota(json['nota'])

    def __str__(self):
        return "Titulo: {} | ".format(self.__titulo) + "Ano: {} | ".format(self.__ano)+ "Classificacao: {} | ".format(self.__classificacao) +"Nota {}".format(self.__nota)