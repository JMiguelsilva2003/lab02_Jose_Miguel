package estruturaDeDados;
public interface EstruturaElementar {
    //Métodos Consultivos
    public boolean buscaElemento(int valor);
    public int minimo();
    public int maximo();
    public int predecessor(int valor);
    public int sucessor(int valor);

    //Metodos Modificadores
    public void insereElemento(int valor);
    
    public void remove(int valor);
}
