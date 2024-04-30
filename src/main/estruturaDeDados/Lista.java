package estruturaDeDados;
public interface Lista extends EstruturaElementar{
    //Métodos Consultivos
    public int buscaIndice(int valor);
    
    //Metodos Modificadores
    public void insereElementoPosicao(int valor, int buscaIndice);
    public void insereInicio(int valor);
    public void insereFim(int valor);
    
    public void removeIndice(int indice);
    public void removeInicio();
    public void removeFim();
}
