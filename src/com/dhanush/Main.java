package com.dhanush;

import java.util.Scanner;

import static com.dhanush.Robot.*;

public class Main
{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();
        int breadth = scanner.nextInt();
        scanner.nextLine();

        while(scanner.hasNext()){
            Robot robot = new Robot();
            robot.setLength(length);
            robot.setBreadth(breadth);

            int positionX = scanner.nextInt();
            int positionY = scanner.nextInt();
            robot.setPosX(positionX);
            robot.setPosY(positionY);

            String direction = scanner.nextLine().strip();
            if (direction.equals("N")) {
                robot.setCurrentDirection(Direction.North);
            } else if (direction.equals("S")) {
                robot.setCurrentDirection(Direction.South);
            } else if (direction.equals("E")){
                robot.setCurrentDirection(Direction.East);
            } else if (direction.equals("W")) {
                robot.setCurrentDirection(Direction.West);
            } else {
                throw new IllegalArgumentException("Given input " +
                        "direction is invalid!");
            }
            String movement = scanner.nextLine();
            System.out.println(FinalPosition(robot, movement));
        }

    }

    /*
        -The final output should be a string with the format
        "posX posY direction", where each value is separated by a space.
        -The function will accept two parameters: currentRobot and robotMovement.
        -Since there can be multiple robots, the currentRobot parameter
         ensures that the code remains consistent for all robots.
        -The robot's movement may differ for each robot, so the robotMovement
         parameter is passed alongside the currentRobot to reflect the
         specific movement instructions for each individual robot.
     */
    private static String FinalPosition(Robot currentRobot, String robotMovement) {

        /*
            using Enhanced-for-loop to loop around the characters of the
            Robot's movement
         */
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
                    throw new IllegalArgumentException("Invalid robot movement");
            }
        }

        String finalPosition = currentRobot.getPosX()+" "+currentRobot.getPosY()+" "+currentRobot.getCurrentDirection();
        return finalPosition;

    }
}
