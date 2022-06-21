from ObjetoSobrepostoException import ObjetoSobrepostoException
from Ponto2D import Ponto2D
from Reta import Reta


class EspacoGeometrico():

    def __init__(self):
        self.__retas = []
        self.__pontos = []

    def adicionarReta(self, reta):

        if not self.__retas:
            self.__retas.append(reta)
        else:
            for r in self.__retas:
                try:
                    if r.intercepta(reta):
                        raise ObjetoSobrepostoException('Retas Sobrepostas {} e {}'.format(r,reta))
                except ObjetoSobrepostoException:
                    raise ObjetoSobrepostoException('Retas Sobrepostas {} e {}'.format(r,reta))
            self.__retas.append(reta)

    def adicionarPonto(self, ponto):

        if not self.__retas:
            self.__pontos.append(ponto)
        else:
            for r in self.__retas:
                try:
                    if r.estaNaReta(ponto):
                        raise ObjetoSobrepostoException('Objetos Sobrepostos. Reta {} e Ponto {}'.format(r,ponto))
                except ObjetoSobrepostoException:
                    raise ObjetoSobrepostoException('Objetos Sobrepostos. Reta {} e Ponto {}'.format(r,ponto))
            self.__pontos.append(ponto)

    def retas(self):
        return len(self.__retas)
