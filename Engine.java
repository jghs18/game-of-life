
public class Engine
{
    public static void main(String[] args){
        Grid my_grid = new Grid();

        System.out.println("Before:");
        my_grid.output_grid();
        int count=0;
        for(int i = 1; i <= 5; i++){
            my_grid.play_life();
            count++;
        }
        System.out.println("After:" + count);
        my_grid.output_grid();
        my_grid.output_living();
    }
}
