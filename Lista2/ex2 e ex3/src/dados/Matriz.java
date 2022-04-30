package dados;

import dados.Quadrante;
import java.util.LinkedList;
import java.util.List;

public class Matriz<T> {

    private int m, n;
    private T[][] matriz;

    public Matriz(int m, int n) {
        this.m = m;
        this.n = n;
        this.matriz = (T[][]) new Object[this.m][this.n];
    }

    public boolean set(T objeto, int i, int j) {
        if (i > this.m || j > this.n) {
            return false;
        } else {
            this.matriz[i][j] = objeto;
            return true;
        }
    }

    public T get(int i, int j) {
        if (i > this.m || j > this.n) {
            return null;
        } else {
            return this.matriz[i][j];
        }
    }

    public List<T> getLinha(int linha) {
        List<T> retorno = new LinkedList<>();
        for (int i = 0; i < this.n; i += 1) {
            retorno.add(this.matriz[linha][i]);
        }
        return retorno;
    }

    public List<T> getColuna(int coluna) {
        List<T> retorno = new LinkedList<>();
        for (int i = 0; i < this.m; i += 1) {
            retorno.add(this.matriz[i][coluna]);
        }
        return retorno;
    }

    public List<T> getElementosQuadrante(Quadrante quadrante) {
        List<T> aux = new LinkedList<T>();
        if (this.m % 2 != 0 && this.n % 2 != 0) {
            if (quadrante == Quadrante.PRIMEIRO) {
                for (int i = 0; i < (this.m / 2) + 1; i += 1) {
                    for (int j = 0; j < (this.n / 2) + 1; j += 1) {
                        aux.add(this.matriz[i][j]);
                    }
                }
            } else if (quadrante == Quadrante.SEGUNDO) {
                for (int i = 0; i < this.m / 2 + 1; i += 1) {
                    for (int j = this.n / 2 + 1; j < this.n; j += 1) {
                        aux.add(this.matriz[i][j]);
                    }
                }
            } else if (quadrante == Quadrante.TERCEIRO) {
                for (int i = this.m / 2 + 1; i < this.m; i += 1) {
                    for (int j = 0; j < this.n / 2 + 1; j += 1) {
                        aux.add(this.matriz[i][j]);
                    }
                }
            } else if (quadrante == Quadrante.QUARTO) {
                for (int i = this.m / 2 + 1; i < this.m; i += 1) {
                    for (int j = this.n / 2 + 1; j < this.n; j += 1) {
                        aux.add(this.matriz[i][j]);
                    }
                }
            }
        } else {
            if (quadrante == Quadrante.PRIMEIRO) {
                for (int i = 0; i < (this.m / 2); i += 1) {
                    for (int j = 0; j < (this.n / 2); j += 1) {
                        aux.add(this.matriz[i][j]);
                    }
                }
            } else if (quadrante == Quadrante.SEGUNDO) {
                for (int i = 0; i < this.m / 2; i += 1) {
                    for (int j = this.n / 2; j < this.n; j += 1) {
                        aux.add(this.matriz[i][j]);
                    }
                }
            } else if (quadrante == Quadrante.TERCEIRO) {
                for (int i = this.m / 2 ; i < this.m; i += 1) {
                    for (int j = 0; j < this.n / 2; j += 1) {
                        aux.add(this.matriz[i][j]);
                    }
                }
            } else if (quadrante == Quadrante.QUARTO) {
                for (int i = this.m / 2; i < this.m; i += 1) {
                    for (int j = this.n / 2; j < this.n; j += 1) {
                        aux.add(this.matriz[i][j]);
                    }
                }
            }

        }
        return aux;
    }
}