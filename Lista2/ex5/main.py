from fileinput import close
from dados import Filme
import json
filmes = []
f = open('filmes.json','r')
data = json.load(f)
for i in data:
    filme = Filme()
    filme.jsonInit(i)
    filmes.append(filme)
filmes.sort(key = (lambda filme: filme.getNota()), reverse=True)
for i in filmes:
    print(i)
del filmes
f = close()
