/**
 *  Created by Professor Josh Hug for UCB's Graphs Lab
 *  Updated for COMP128 to use java.beans as java.observer is deprecated 
 **/


package graphMazeActivity;


class MazeDemo {
    /* Runs a breadth first search or depth first search from (1, 1) to (N, N) on the graph in the config file. */
    public static void main(String[] args) {
        Maze maze = new Maze("maze.config");

        int startX = 1;
        int startY = 1;
        int targetX = maze.N();
        int targetY = maze.N();

        /* uncomment the following to run a depth first search */
        // MazeExplorer mdfp = new MazeDepthFirstPaths(maze, startX, startY, targetX, targetY);
        // mdfp.solve();

        /* uncomment the following to run a breadth first search */
        MazeExplorer mbfp = new MazeBreadthFirstPaths(maze, startX, startY, targetX, targetY);
        mbfp.solve();

        /* uncomment the following to detect a cycle */
        // MazeCycles mc = new MazeCycles(maze);
        // mc.solve();
    }

}
