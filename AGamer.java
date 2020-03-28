public abstract class AGamer
{
    protected String sign; //мітка
    abstract boolean shot(int x, int y); //постріл в координати х,у
    abstract boolean win(); //перевірка перемоги
}
