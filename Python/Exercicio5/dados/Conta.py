import string


class Conta:
    def __init__(self):
        self.__valor = 0
        self.__desconto = False
        self.__itens_comprados = []
    def setValor(self, valor):
        self.__valor = valor
    def getValor(self):
        return self.__valor
    def setDesconto(self, desconto):
        self.__desconto = desconto
    def getDesconto(self):
        return self.__desconto
    def setItensComprados(self, itens_comprados):
        self.__itens_comprados = itens_comprados
    def getItensComprados(self):
        return self.__itens_comprados
    def __str__(self):
        if self.__desconto == True:
            self.__desconto_string = "Sim"
        else:
            self.__desconto_string = "Nao"
        return "Valor da conta: {}".format(self.__valor) + "\nHouve desconto: {}".format(self.__desconto_string) + "\nItens comprados: {}".format(self.__itens_comprados)
    
    