/**
 * Player.java
 * 
 * The player for the MonsterGame.
 *
 * @author Given Tanri
 * Wheaton College, CSCI 235, Spring 2020
 * Project 4
 * 20200324
 */

public class Player {

    /**
     * Instance variables:
     * xPos: The x position of this Player
     * yPos: The y position of this Player
     * xSize: The size of the grid, x-coordinate
     * ySize: The size of the grid, y-coordinate
     * isVisible: The indicator whether this Player is visible
     */
    private int xPos;
    private int yPos;
    private int xSize;
    private int ySize;
    private boolean isVisible;

    /**
     * Constructor for initializing a Player's instance variables.
     */
    public Player(int x, int y, int xSize, int ySize) { 
	this.xPos = x;
	this.yPos = y;
	this.xSize = xSize;
        this.ySize = ySize;
	this.isVisible = true; 
    }

    
    /**
     * Return the current x position of this Player.
     * @return xPos The x position of this Player
     */
    public int getXPos() { return xPos; }

    
    /**
     * Return the current y position of this Player
     * @return yPos The y position of this Player
     */
    public int getYPos() { return yPos; }

    
    /**
     * Move this Player up by one unit
     * by incrementing the y position.
     *
     * Nothing is performed if the Player is 
     * on the top edge of the grid. 
     */
    public void up() {
	if (yPos < ySize - 1) yPos++; 		
    }

    
    /**
     * Move this Player down by one unit
     * by decrementing the y position.
     *
     * Nothing is performed if the Player is 
     * on the bottom edge of the grid. 
     */
    public void down() { 
	if (yPos > 0) yPos--;	
    }

    
    /**
     * Move this Player to the left by one unit
     * by decrementing the x position.
     *
     * Nothing is performed if the Player is 
     * on the left-most edge of the grid. 
     */
    public void left() { 
	if (xPos > 0) xPos--;        
    }

    
    /**
     * Move this Player to the right by one unit
     * by decrementing the x position.
     *
     * Nothing is performed if the Player is 
     * on the right-most edge of the grid. 
     */
    public void right() { 
	if (xPos < xSize - 1) xPos++;
    }

    
    /**
     * Make this Player disappear when visible,
     * and reappear when invisible. 
     */
    public void disOrReappear() { 
	isVisible = !isVisible;
    }

    
    /**
     * Return the character 'P' when this Player is visible,
     * or the character ' ' (space) when invisible.
     * @return c The character returned 
     */
    public char getIcon() { 
	char c;
	
        if (isVisible) c = 'P';
	else c = ' ';
	
	return c; 
    }

}
