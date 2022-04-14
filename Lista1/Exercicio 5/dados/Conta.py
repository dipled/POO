import string


class Conta:
    def __init__(self, valor:float, desconto:bool, itens_comprados:list):
        self.valor = valor
        self.desconto = desconto
        self.itens_comprados = itens_comprados
        
    def __str__(self):
        if self.desconto == True:
            self.desconto_string = "Sim"
        else:
            self.desconto_string = "Nao"
        return "Valor da conta: {}".format(self.valor) + "\nHouve desconto: {}".format(self.desconto_string) + "\nItens comprados: {}".format(self.itens_comprados)
    
