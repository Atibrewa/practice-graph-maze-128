package graphMazeActivity;

/**
 *  Created by Professor Josh Hug for UCB's Graphs Lab
 *  Updated for COMP128 to use java.beans as java.observer is deprecated 
 **/

public class MazeDepthFirstPaths extends MazeExplorer {
    /* 
    Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private int s;
    private int t;
    private boolean targetFound = false;
    private Maze maze;


    public MazeDepthFirstPaths(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        distTo[s] = 0;
        edgeTo[s] = s;
    }

    private void dfs(int v) {

        // The following is a recursive version of the depth first search algorithm:

        // 1. mark the current vertex as visited 
        // 2. If the current vertex is our target, return
        // 3. otherwise, we first find all vertices that v is adjacent to 
        //    and for each vertex w, if it is not visited
        //         a. update edge in edgeTo (for drawing)
        //         b. update the distant in distTo (for drawing)
        //         c. recursively run dfs on the vertex
            
    
        marked[v] = true;
        updateMazeDrawing();
        
        if (v == t) {
            targetFound = true;
        }

        if (targetFound) {
            return;
        }

        for (int w : maze.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                updateMazeDrawing();
                distTo[w] = distTo[v] + 1;
                dfs(w);
                if (targetFound) {
                    return;
                }
            }
        }
    }

    @Override
    public void solve() {
        dfs(s);
    }
}

