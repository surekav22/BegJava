/*
Class point coordinates int x and y
 */

public class Point
{
    private int x;
    private int y;

    public Point ()
    {
        x =1;
        y = 1;
    }

    public Point(int x1, int y1 )
    {
        x=x1;
        y=y1;
    }

    public void modify (int value )
    {
        x = x*3;
        y= y*3;
    }

    public void setX (int x1)
    {
        x = x1;

    }

    public void setY (int y1)
    {
        y = y1;
    }

    public void makePoint(int p1x, int p1y)
    {
        x=p1x;
        y=p1y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void translate(int addX, int addY)
    {
        x = x+addX;
        y = y+addY;
    }

    public double distance(Point secondPoint)
    {
        return Math.sqrt( Math.pow((x - secondPoint.x), 2) + Math.pow((y - secondPoint.y), 2));
    }
}
