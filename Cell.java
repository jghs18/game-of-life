
public class Cell
{
    public int x = 0;
    public int y = 0;
    public boolean isAlive = false;
    
    public Cell(){
        
    }
    
    public Cell(int x, int y){
        this.x = x;
        this.y = y;
        this.isAlive = false;
    }
    
    public Cell(int x, int y, boolean isAlive){
        this.x = x;
        this.y = y;
        this.isAlive = isAlive;
    }
    
    public void change_isAlive(){
        this.isAlive = !this.isAlive;
    }

    public void set_isAlive(boolean b){
        this.isAlive = b;
    }
    
    public boolean get_isAlive(){
        return this.isAlive;
    }
    
    
    public String toString(){
        if(isAlive)
            return "*";
        return " ";
    }
}
