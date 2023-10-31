package graphMazeActivity;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  Created by Professor Josh Hug for UCB's Graphs Lab
 *  Updated for COMP128 to use java.beans as java.observer is deprecated 
 **/


public class MazeBreadthFirstPaths extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private int s;
    private int t;
    private boolean targetFound = false;
    private Maze maze;
    private Queue<Integer> workQueue;


    public MazeBreadthFirstPaths(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        distTo[s] = 0;
        edgeTo[s] = s;

        // TODO: Initialize the workQueue for breadth first search
        workQueue = new LinkedList<Integer>();
 
    }

    // Conducts a breadth first search of the maze starting at the source. 
    private void bfs(int s) {
        updateMazeDrawing();
        
        // TODO: complete the following algorithm for BFS
        // Step 1: if vertex s is our target vertex, change targetFound to be true, and return
        // Step 2: otherwise, we add vertex s to the work queue
        // Step 3: while work queue is not empty: 
        //         a) dequeue a vertex from the workqueue
        //         b) mark this vertex as visited and call updateMazeDrawing()
        //         c) if this vertex is our target vertex, return
        //         d) else, we find all vertices this vertex is adjacent to, and for each vertex
        //         e) if it is not visited, update the edge value to be its parent and add it to workQueue.
        //            as well as calling updateMazeDrawing()
        //         f) last, increment the distance by 1 
        
        if (s == t) {
            targetFound = true;
            return;
        }

        workQueue.add(s);
        while (!workQueue.isEmpty()) {
            int visitedNode = workQueue.poll();
            marked[visitedNode] = true;
            updateMazeDrawing();

            if (visitedNode == t) return;
            
            for (int i : maze.adj(visitedNode)) {
                if (!marked[i]) {
                    edgeTo[i] = visitedNode;
                    workQueue.add(i);
                    updateMazeDrawing();
                }
                distTo[i] = distTo[visitedNode] + 1;
            }
        }
    
    }

    @Override
    public void solve() {
        bfs(s);
    }

}

