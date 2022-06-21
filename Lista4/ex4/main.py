from Ponto2D import Ponto2D
from Reta import Reta
from EspacoGeometrico import EspacoGeometrico
from ObjetoSobrepostoException import ObjetoSobrepostoException


R = Reta(1, 2)
Q = Reta(1, 1)
S = Reta(2, -2)
A = Ponto2D(3, 4)
B = Ponto2D(2, 3)
C = Ponto2D(4, 6)
D = Ponto2D(3, 2)
espaco = EspacoGeometrico()

try:
    espaco.adicionarReta(R)
    espaco.adicionarReta(Q)
    espaco.adicionarReta(S)
except ObjetoSobrepostoException as e:
    print(e)
try:
    espaco.adicionarPonto(A)
except ObjetoSobrepostoException as e:
    print(e)
try:
    espaco.adicionarPonto(B)
except ObjetoSobrepostoException as e:
    print(e)
try:
    espaco.adicionarPonto(D)
except ObjetoSobrepostoException as e:
    print(e) #Nao foi printado, pois nao esta em nenhuma reta (Nao foi lancada a excecao)
