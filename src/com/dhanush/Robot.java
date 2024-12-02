package com.dhanush;

public class Robot {

    //Warehouse rectangle dimensions
    private int length;
    private int breadth;

    //Robot's position
    private int posX;
    private int posY;
    private Direction currentDirection;

    public enum Direction {
        North,
        South,
        East,
        West;

        private Direction right;
        private Direction left;

        static {
            North.right = East;
            North.left = West;

            East.right = South;
            East.left = North;

            South.right = West;
            South.left = East;

            West.right = North;
            West.left = South;
        }

        public Direction getRightDirection() {
            return right;
        }

        public Direction getLeftDirection() {
            return left;
        }
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getBreadth() {
        return breadth;
    }

    public void setBreadth(int breadth) {
        this.breadth = breadth;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }

    public void incrementPosX()
    {
        this.posX = this.posX + 1;
    }

    public void incrementPosY()
    {
        this.posY = this.posY + 1;
    }

    public void decrementPosX()
    {
        this.posX = this.posX - 1;
    }

    public void decrementPosY()
    {
        this.posY = this.posY - 1;
    }



}

