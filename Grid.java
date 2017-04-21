import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Grid
{
    private int w = 21;
    private int h = 21;
    private Cell[][] my_grid = new Cell[w][h];
    private int rowTen=0;
    private int colTen=0;
    private int totalAlive=0;
    public Grid(){
        this.my_grid = new Cell[w][h];
        for(int y = 0; y < h; y++){
            for(int x = 0; x < w; x++){
                my_grid[x][y] = new Cell(x,y);
            }
        }
        populate_grid();
    }

    public int getW(){
        return w;
    }
    public void output_living()
    {
        for(int x=0;x<my_grid[0].length;x++){
            for(int y=0;y<my_grid.length;y++){
                if(x==10&&my_grid[10][y].get_isAlive()) rowTen++;
                if(y==10&&my_grid[x][10].get_isAlive()) colTen++;
                if(my_grid[x][y].get_isAlive()) totalAlive++;
            }
        }
        System.out.println("Number in Row 10  ---> "+ rowTen);
        System.out.println("Number in Column 10  ---> " + colTen);
        System.out.println("Total number  ---> " + totalAlive);
    }
    

    public int getH(){
        return h;
    }

    public boolean get_cell_status(int x, int y){
        return my_grid[x][y].get_isAlive();        
    }

    public void set_cell_status(int x, int y, boolean status){
        my_grid[x][y].set_isAlive(status);
    }

    public void output_grid(){
        for(int x=0;x<my_grid[0].length;x++){
            for(int y=0;y<my_grid.length;y++){
                System.out.print(my_grid[x][y].toString());
            }
            System.out.println();
        }
    }

    public int count_neighbors(int x, int y){
        int count=0; 
        if(x>0&&my_grid[x-1][y].get_isAlive()){
            count++;
        }
        if(x<w-1&&my_grid[x+1][y].get_isAlive()){
            count++;
        }
        if(y>0&&my_grid[x][y-1].get_isAlive()){
            count++;
        }
        if(y<h-1&&my_grid[x][y+1].get_isAlive())
        {
            count++;
        }
        if(x>0&&y>0&&my_grid[x-1][y-1].get_isAlive())
        {            
            count++;
        }
        if(x<w-1&&y<h-1&&my_grid[x+1][y+1].get_isAlive())
        {            
            count++;
        }
        if(x>0&&y<h-1&&my_grid[x-1][y+1].get_isAlive())
        {
            count++;     
        }
        if(x<w-1&&y>0&&my_grid[x+1][y-1].get_isAlive())
        {
            count++;
        }
        return count;
    }

    public Cell[][] get_Grid(){
        return my_grid;
    }

    public void play_life(){
        //create temp grid
        /* Your code here*/
        Cell[][] temp_grid= new Cell[w][h];

        //evaluate each spot and save next position in temp grid
        for(int y=0;y<h;y++){
            for(int x=0;x<w;x++){
                boolean temp = my_grid[x][y].get_isAlive();
                temp_grid[x][y]=new Cell(x,y,temp);
            }
        }
        //loop through each cell

        for(int y = 0; y < h; y++){
            for(int x = 0; x < w; x++){
                /////count neighbors
                int neighbors=this.count_neighbors(x,y);
                /* Your code here*/
                if(neighbors <= 1){// die.loneliness
                    temp_grid[x][y].set_isAlive(false);
                }else if(neighbors == 2 ){//has two neighbors
                    //do nothing
                }else if(neighbors == 3 ){// make alive
                    temp_grid[x][y].set_isAlive(true);
                }else if(neighbors >= 4){// die. overcrowding
                    temp_grid[x][y].set_isAlive(false);
                }else{
                    temp_grid[x][y].set_isAlive(false);
                }
            }
        }
        my_grid = temp_grid;
    }

    public void populate_grid(){
        try{
            File text = new File ("life100a.txt");
            Scanner in = new Scanner(text);
            //int line_num = 0;
            while(in.hasNextLine()){
                String line = in.nextLine();

                //if(line_num > 1){
                String[] values = line.split(" ");
                int x = Integer.parseInt(values[0]);
                int y = Integer.parseInt(values[1]);
                set_cell_status(x,y,true);
                //}
                //line_num++;           
            }

        } catch (FileNotFoundException f) {
            System.err.println("Caught FileNotFoundException: " + f.getMessage());
        }
    }
}
