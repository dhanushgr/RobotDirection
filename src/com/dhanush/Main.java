package com.dhanush;

import static com.dhanush.Robot.*;

public class Main
{
    public static void main(String[] args) {

        //Inputs for Robot1
        Robot robot1 = new Robot();
        robot1.setLength(5);
        robot1.setBreadth(5);

        robot1.setPosX(1);
        robot1.setPosY(0);

        robot1.setCurrentDirection(Direction.North);
        String robot1Movement = "MMRMMLMMR";

        Robot robot2 = new Robot();
        robot2.setLength(5);
        robot2.setBreadth(5);
        robot2.setPosX(3);
        robot2.setPosY(2);
        robot2.setCurrentDirection(Direction.East);
        String robot2Movement = "MLLMMRMM";

        System.out.println(FinalPosition(robot1, robot1Movement));
        System.out.println(FinalPosition(robot2, robot2Movement));
    }

    private static String FinalPosition(Robot currentRobot, String robotMovement) {

        for (char ch: robotMovement.toCharArray()){
            Robot.Direction currentDirection =  currentRobot.getCurrentDirection();
            Robot.Direction newDirection;
            switch (ch){
                case 'M':
                    if(currentDirection == Direction.North){
                        currentRobot.incrementPosY();
                    } else if (currentDirection == Direction.East) {
                        currentRobot.incrementPosX();
                    } else if (currentDirection == Direction.South) {
                        currentRobot.decrementPosY();
                    } else if (currentDirection == Direction.West){
                        currentRobot.decrementPosX();
                    }
                    break;

                case 'R':
                    newDirection = currentDirection.getRightDirection();
                    currentRobot.setCurrentDirection(newDirection);
                    break;
                case 'L':
                    newDirection = currentDirection.getLeftDirection();
                    currentRobot.setCurrentDirection(newDirection);
                    break;

                default:
                    System.out.println("Invalid robot movement");
                    break;
            }
        }

        String finalPosition = currentRobot.getPosX()+" "+currentRobot.getPosY()+" "+currentRobot.getCurrentDirection();

        return finalPosition;

    }
}
