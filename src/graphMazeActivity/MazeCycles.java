package graphMazeActivity;

import java.util.ArrayList;

/**
 *  Created by Professor Josh Hug for UCB's Graphs Lab
 *  Updated for COMP128 to use java.beans as java.observer is deprecated 
 **/


public class MazeCycles extends MazeExplorer {
    /* Inherits public fields: 
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private Maze maze;

    // TODO: If you are implementing non-recursive approach, you will need to declare a stack object here
    // cycle is a variable that will be modified to be the vertex number when a cycle is detected
    private int cycle = -1;
    
    public MazeCycles(Maze m) {
        super(m);
        maze = m;

        // TODO: Make sure you initialize the stack
       
        
    }

    @Override
    public void solve() {
        // TODO: Implement your cycle checking algorithm here
        // You want to first run the depth first search, if a cycle is not detected, you don't need to draw anything
        // Otherwise, you want to draw the cycle detected - by setting marked[vertix in cycles] to be true
        // and then call updateMazeDrawing()


    }
   
   
}
