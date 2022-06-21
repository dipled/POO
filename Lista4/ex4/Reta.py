import Ponto2D


class Reta:
    def __init__(self, a, b):
        self.__a = a
        self.__b = b

    def getB(self):
        return self.__b

    def getA(self):
        return self.__a

    def intercepta(self, reta):
        if self.__a == reta.getA() and self.__b != reta.getB():
            return False
        return True

    def estaNaReta(self, ponto):
        if ponto.getY() == self.__a * ponto.getX() + self.__b:
            return True
        return False

    def __str__(self):
        return 'a: {} b: {}'.format(self.__a, self.__b)
