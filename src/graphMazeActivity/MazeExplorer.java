package graphMazeActivity;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *  Created by Professor Josh Hug for UCB's Graphs Lab
 *  Updated for COMP128 to use java.beans as java.observer is deprecated 
 **/

public abstract class MazeExplorer {
    public int[] distTo; // Distances to draw over the maze from starting vertex on Canvas
    public int[] edgeTo; // Edges to draw on maze (from the adjacent vertex)
    public boolean[] marked; // keep track of visited vertices
    public Maze maze;

    // Used for property change listener
    private PropertyChangeSupport support;
    private String message = " ";

    
    // Notify the listener to update the canvas
    protected void updateMazeDrawing() {
        PropertyChangeEvent event = new PropertyChangeEvent(this, "Property change", this.message, "Update Maze");
        support.firePropertyChange(event);
    }

    // Add and remove propertychangelistener
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
        
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }



    public MazeExplorer(Maze m) {
        maze = m;
        support = new PropertyChangeSupport(this);

        distTo = new int[maze.V()];
        edgeTo = new int[maze.V()];
        marked = new boolean[maze.V()];
        for (int i = 0; i < maze.V(); i += 1) {
            distTo[i] = Integer.MAX_VALUE;
            edgeTo[i] = Integer.MAX_VALUE;
        }
        addPropertyChangeListener(maze);
    }

    /** Solves the maze, modifying distTo and edgeTo as it goes. */
    public abstract void solve();
}
