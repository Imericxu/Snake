package com.imericxu.components;

import java.util.ArrayList;
import java.util.Objects;

public class Snake
{
    /**
     * All the points the snake contains in order
     */
    private ArrayList<Pos> path;
    /**
     * The direction the snake is currently facing
     */
    private Direction direction;
    
    public Snake(int row, int col)
    {
        path = new ArrayList<>();
        path.add(new Pos(row, col));
    }
    
    /**
     * Adds a {@link Pos} to the end of the path based on calculated direction
     */
    public void increaseLength()
    {
        Pos end = path.get(path.size() - 1);
        Direction dir;
        
        if (path.size() > 1)
        {
            Pos secToLast = path.get(path.size() - 2);
            dir = Pos.calcDirection(secToLast, end);
        }
        else dir = direction;
        
        int row = end.getRow();
        int col = end.getCol();
        
        switch (Objects.requireNonNull(dir))
        {
        case NORTH -> path.add(new Pos(row - 1, col));
        case EAST -> path.add(new Pos(row, col + 1));
        case SOUTH -> path.add(new Pos(row + 1, col));
        case WEST -> path.add(new Pos(row, col - 1));
        }
    }
    
    private void moveUp()
    {
        Pos head = path.get(0);
        path.add(0, new Pos(head.getRow() - 1, head.getCol()));
        path.remove(path.size() - 1);
    }
    
    private void moveDown()
    {
        Pos head = path.get(0);
        path.add(0, new Pos(head.getRow() + 1, head.getCol()));
        path.remove(path.size() - 1);
    }
    
    private void moveLeft()
    {
        Pos head = path.get(0);
        path.add(0, new Pos(head.getRow(), head.getCol() - 1));
        path.remove(path.size() - 1);
    }
    
    private void moveRight()
    {
        Pos head = path.get(0);
        path.add(0, new Pos(head.getRow(), head.getCol() + 1));
        path.remove(path.size() - 1);
    }
    
    public ArrayList<Pos> getPath()
    {
        return path;
    }
    
    public void setPath(ArrayList<Pos> path)
    {
        this.path = path;
    }
    
    public Direction getDirection()
    {
        return direction;
    }
    
    public void setDirection(Direction direction)
    {
        this.direction = direction;
    }
}