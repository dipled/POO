from fileinput import close
from dados import Filme
import json
filmes = []
f = open('filmes.json')
data = json.load(f) #isso transforma cada bloco do json num dicionario e adiciona em "data", que eh uma lista de dicionarios
for i in data:
    filme = Filme()
    filme.jsonInit(i)
    filmes.append(filme)
filmes.sort(key = (lambda filme: filme.getNota()), reverse=True) #funcao que ordena baseada na nota do filme (tem uma funcao lambda gostosinha ali hasuhahsu)
for i in filmes:
    print(i)
del filmes
f = close()
