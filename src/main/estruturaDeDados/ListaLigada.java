package estruturaDeDados;

import java.util.NoSuchElementException;

public class ListaLigada implements Lista{
    private No primeiro;
    private No ultimo;
    private int tamanho;

    public ListaLigada(){
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public No getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(No primeiro) {
        this.primeiro = primeiro;
    }

    public No getUltimo() {
        return ultimo;
    }

    public void setUltimo(No ultimo) {
        this.ultimo = ultimo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public boolean buscaElemento(int valor) {
        No atual = this.primeiro;
        while (atual != null) {
            if (atual.getValor() == valor) {
                return true;
            }
            atual = atual.getProximo();
        }
        return false;
    }
    @Override
    public int minimo() {
        if (this.primeiro == null) {
            throw new IllegalStateException("Lista vazia");
        }
        No atual = this.primeiro;
        int min = atual.getValor();
        while (atual != null) {
            if (atual.getValor() < min) {
                min = atual.getValor();
            }
            atual = atual.getProximo();
        }
        return min;

    }

    @Override
    public int maximo() {
        if (this.primeiro == null) {
            throw new IllegalStateException("Lista vazia");
        }
        No atual = this.primeiro;
        int max = atual.getValor();
        while (atual != null) {
            if (atual.getValor() > max) {
                max = atual.getValor();
            }
            atual = atual.getProximo();
        }
        return max;
    }

    @Override
    public int predecessor(int valor) {
        No atual = this.primeiro;
        No predecessor = null;
        while (atual != null) {
            if (atual.getValor() == valor) {
                if (predecessor != null) {
                    return predecessor.getValor();
                } else {
                    throw new IllegalArgumentException("Não há predecessor para o primeiro elemento da lista.");
                }
            }
            predecessor = atual;
            atual = atual.getProximo();
        }
        throw new IllegalArgumentException("Elemento não encontrado na lista.");
    }

    @Override
    public int sucessor(int valor) {
        No atual = this.primeiro;
        while (atual != null) {
            if (atual.getValor() == valor) {
                if (atual.getProximo() != null) {
                    return atual.getProximo().getValor();
                } else {
                    throw new IllegalArgumentException("Não há sucessor para o último elemento da lista.");
                }
            }
            atual = atual.getProximo();
        }
        throw new IllegalArgumentException("Elemento não encontrado na lista.");
    }

    @Override
    public void insereElemento(int valor) {
        No novoNo = new No(valor);
        if (this.primeiro == null && this.ultimo == null) {
            this.primeiro = novoNo;
            this.ultimo = novoNo;
        } else {
            this.ultimo.setProximo(novoNo);
            this.ultimo = novoNo;
        }
        this.tamanho++;
    }

    @Override
    public void remove(int valor) {
        No anterior = null;
        No atual = this.primeiro;
        for (int i = 0; i < this.getTamanho(); i++) {
            if (atual.getValor() == valor) {
                if (anterior != null) {
                    anterior.setProximo(atual.getProximo());
                } else {
                    this.primeiro = atual.getProximo();
                }
                this.tamanho--;
                break;
            }
            anterior = atual;
            atual = atual.getProximo();
        }
    }      

    @Override
    public int buscaIndice(int valor) {
        No atual = this.primeiro;
        int indice = 0;
        while (atual != null) {
            if (atual.getValor() == valor) {
                return indice;
            }
            atual = atual.getProximo();
            indice++;
        }
        return -1;
    }

    @Override
    public void insereElementoPosicao(int valor, int indice) {
        if (indice < 0 || indice > this.tamanho) {
            throw new IndexOutOfBoundsException("Índice fora dos limites da lista.");
        }
        if (indice == this.tamanho) {
            insereElemento(valor);
            return;
        }
        No novoNo = new No(valor);
        if (indice == 0) {
            novoNo.setProximo(this.primeiro);
            this.primeiro = novoNo;
        } else {
            No atual = this.primeiro;
            for (int i = 0; i < indice - 1; i++) {
                atual = atual.getProximo();
            }
            novoNo.setProximo(atual.getProximo());
            atual.setProximo(novoNo);
        }
        this.tamanho++;
    }



    @Override
    public void insereInicio(int valor) {
        insereElementoPosicao(valor, 0);
    }

    @Override
    public void insereFim(int valor) {
        insereElemento(valor);
    }

    public void removeIndice(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Índice fora dos limites");
        }
    
        if (indice == 0) {
            primeiro = primeiro.getProximo();
        } else {
            No atual = primeiro;
            for (int i = 0; i < indice - 1; i++) {
                atual = atual.getProximo();
            }
            atual.setProximo(atual.getProximo().getProximo());
        }
        tamanho--;
    }
    
    
    public void removeInicio() {
    if (tamanho == 0) {
        throw new NoSuchElementException("Lista vazia");
    }

    primeiro = primeiro.getProximo();
    tamanho--;

    if (tamanho == 0) {
        ultimo = null;
    }
}

    
    public void removeFim() {
        if (tamanho == 0) {
            throw new NoSuchElementException("Lista vazia");
        }

        if (tamanho == 1) {
            primeiro = null;
            ultimo = null;
        } else {
            No atual = primeiro;
            for (int i = 0; i < tamanho - 2; i++) {
                atual = atual.getProximo();
            }
            atual.setProximo(null);
            ultimo = atual;
        }
        tamanho--;
    }

}    