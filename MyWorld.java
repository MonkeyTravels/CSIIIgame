import mayflower.*;


public class MyWorld extends World {

    private Cat cat;
    private Dog dog;
    private String[][] tiles;
    /*
    private Dog dog;
    private Ninja ninja;
    private Jack jack;
    */
    
    public MyWorld() 
    {
        setBackground("img/BG/BG.png");
        
        tiles = new String[6][16];
        buildWorld();
        addRandomObjects();
        cat = new Cat();
        addObject(cat, 400, 100);
        dog = new Dog();
        addObject(dog, 300, 100);
        Mayflower.showBounds(true);
        showText("Score: " + cat.getScore() + " Lives: ?", 10, 30, Color.BLACK);
    }
    
    public void act()
    {
    }
    
    public void buildWorld()
    {
        for(int r = 0; r < tiles.length; r++)
        {
            for(int c = 0; c < tiles[r].length; c++)
            {
                tiles[r][c] = "";
            }
        }
        for(int i = 0; i < tiles[4].length; i++)
        {
            tiles[5][i] = "ground";
        }
        for(int r = 0; r < tiles.length; r++)
        {
            for(int c = 0; c < tiles[r].length; c++)
            {
               if(tiles[r][c].equals("ground"))
               {
                   addObject(new Block(), c * 100, r * 100);
               }
            }
        }
    }
    
    public void addRandomObjects()
    {
        for(int r = 0; r < tiles.length - 1; r++)
        {
            for(int c = 0; c < tiles[r].length; c++)
            {
               int rand = (int)(Math.random()*(tiles.length));
               if(rand < 1 && tiles[r][c].equals(""))
               {
                  addObject(new Banana(), c * 100, r * 100);
                  tiles[r][c] = "Banana";
               }
            }
        }
        for(int r = 4; r < 5; r++)
        {
            for(int c = 0; c < tiles[r].length; c++)
            {
               int rand = (int)(Math.random()*(tiles.length));
               if(rand < 1 && tiles[4][c].equals(""))
               {
                  addObject(new Jack(), c * 100, r * 100);
                  tiles[5][c] = "Jack";
               }
            }
        }
    }
}