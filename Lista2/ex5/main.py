from calendar import c
from dados import Filme
import json
filmes = []
f = open('filmes.json')
data = json.load(f)
cont = 0
for i in data:
    filme = Filme()
    filme.jsonInit(i)
    filmes.insert(cont,filme)
    cont += 1
filmes.sort(key =  lambda filme: filme.getNota(), reverse=True)
for i in filmes:
    print(i)


