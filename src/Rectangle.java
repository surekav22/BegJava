/*
Varun Sureka
10/4/19
Java Period 2
*/
public class Rectangle
{
    /*
    Write an object class call Rectangle where you define it with two points (You must use at least one Point object as your field).
    You have to have at least two constructors (default and specific one)
    Make all the assessor and mutator methods
    -Assessor
        - Get methods
    -Mutator
        - Set methods
    Make a draw rectangle method
    - make 3 for loops
        - one for the first set of slashes for the with
        - one for the space on the inside
        - one for the slashes at the bottom
    Make a calculate area Method
    - use the distance formula for both lengths and then multiply them for the area
    Make a method that compare two rectangles and select which one has the greatest area.
    - make a compare method and use the rectangles as parameters
        - just compare the areas and print the respective rectangles and their areas
    */

   // private Point p1 = new Point();
   // private Point p2 = new Point();
    private Point p1;
    private Point p2;

    public Rectangle()
   {
 //      p1.makePoint(0,0);
 //      p2.makePoint( -5, -5);
       p1 = new Point(0,0);
       p2 = new Point(-5, -5);
   }

   public Rectangle(int p1x, int p1y, int p2x, int p2y)
   {
       p1 = new Point(p1x, p1y);
       p2 = new Point(p2x, p2y);
   }

   public int getp1x()
   {
       return p1.getX();
   }

   public int getp1y()
   {
       return p1.getY();
   }

   public int getp2x()
   {
       return p2.getX();
   }

   public int getp2y()
   {
       return p2.getY();
   }

   public void setp1(int x, int y)
   {
       p1.setX(x);
       p1.setY(x);
   }

   public void setp2(int x, int y)
   {
       p2.setX(x);
       p2.setY(x);
   }


   public void DrawRect()
   {
       int p1x = p1.getX();
       int p1y = p1.getY();
       int p2x = p2.getX();
       int p2y = p2.getY();

       for (int line = Math.abs(p1y - p2y); line > 0; line--)
       {
           if (line == Math.abs(p1y - p2y) || line == 1)
           {
               for (int horz = 0; horz < (Math.abs(p1.getX()-p2.getX())); horz++)
               {
                   System.out.print(".");
               }
           }
           else 
           {
               System.out.print(".");
               for (int horz = 0; horz < (Math.abs(p1.getX()-p2.getX())-2); horz++)
               {
                   System.out.print(" ");
               }
               System.out.print(".");
           }
           System.out.print('\n');
       }
   }

   public double Area()
   {
       int p1x = p1.getX();
       int p1y = p1.getY();
       int p2x = p2.getX();
       int p2y = p2.getY();

       double length = Math.sqrt( Math.pow((p2x-p1x), 2) + Math.pow((p1y-p1y), 2));
       double width = Math.sqrt( Math.pow((p2x-p2x), 2) + Math.pow((p2y-p1y), 2));
       return width*length;
   }

   public void Compare(Rectangle rec1, Rectangle rec2)
   {
       if (rec1.Area()>rec2.Area())
       {
           rec1.DrawRect();
           System.out.println("The bigger rectangle is the first one and its area is " + rec1.Area());
       }
       else if (rec2.Area()>rec1.Area())
       {
           rec2.DrawRect();
           System.out.println("The bigger rectangle is the second one and its area is " + rec2.Area());
       }
       else
           {
           rec1.DrawRect();
           System.out.println("The rectangles have the same area and their area is " + rec1.Area());
       }
   }
}
