package com.kuntimaddi.Cube;

import java.util.ArrayList;

/**
 * Cube Solver is the main class of the program.
 * It creates an edge generator class and generates all possible sets of locks and keys
 * for a given size-'s' of the puzzle. The locks and keys are assigned to different cubes edges to form all
 * possible cubes for a given size-'s'.
 *
 *
 */
public class CubeSolver 
{
	
	private EdgeGenerator xEdge;
	private EdgeGenerator yEdge;
	private EdgeGenerator zEdge; 
	private ArrayList<Cube> cubes;	
	private ArrayList<String> yKeys;
	private ArrayList<String> yLocks;
	private ArrayList<String> zKeys;
	private ArrayList<String> zLocks;
	private ArrayList<String> xKeys;
	private ArrayList<String> xLocks;	
	private int size;

    /**
     * This constructor initializes of all the lock and keys of different axis.
     * @param s
     */
	public CubeSolver(int s)
	{
		size=s;
		cubes = new ArrayList<Cube>();
		
		xEdge = new EdgeGenerator(size);		
		xEdge.generate();
		xEdge.filter();
		xKeys = xEdge.getKeysList();
		xLocks = xEdge.getlocksList();
		
		yEdge =  new EdgeGenerator(size-2);	
		yEdge.generate();
		yKeys = yEdge.getKeysList();		
		yLocks = yEdge.getlocksList();
		
		zEdge =  new EdgeGenerator(size-2);	
		zEdge.generate();	
		zKeys = zEdge.getKeysList();		
		zLocks = zEdge.getlocksList();
	
	}

    /**
     * The method generates all possible solutions of cubes by rotating the sets of edges of X,Y,Z axis elements
	 * of a cube.
     */
	public void combinationGenerator()
	{
		int combinations=0;
		
		for(int k=0;k<xEdge.size();++k)
		{
			Cube cube = new Cube(size);
			cubes.add(cube);
			axisAllocator(combinations);
			++combinations;
			xKeys = rotateList(xKeys);
			xLocks = rotateList(xLocks);
			yKeys = rotateList(yKeys);
			yLocks = rotateList(yLocks);
			zKeys = rotateList(zKeys);
			zLocks = rotateList(zLocks);
		}		
					
	}

    /**
     * A method to assign all the keys and locks after
     * getting the position of the cube with respect to
     * the axis
     * @param position
     */
	public void axisAllocator(int position)
	{
		cubes.get(position).assginAxis(xKeys,xLocks,1);
		cubes.get(position).assginAxis(yKeys,yLocks,2);
		cubes.get(position).assginAxis(zKeys,zLocks,3);
		cubes.get(position).assignFaces();		
	}

    /**
     * Rotates the Array list in upward direction.
     * @param actualList
     * @return
     */
	
	public ArrayList<String> rotateList(ArrayList<String> actualList)
	{		
		actualList.add(actualList.get(0));
		actualList.remove(0);
		return actualList;
	}

    /**
     * Displays the cube with all the Faces
     */
	public void displayCubes()
	{
		for(int i=0;i<cubes.size();++i)
		{
			System.out.println("\n\nThe "+ (i+1) +"th combination of " + (size) + " edged cube is");
			cubes.get(i).display();
		}
	}

    /**
     *Main function to Create,Generate and display all possible Cube solutions.
     * @param args
     */
	public static void main(String[] args)
	{
			
		CubeSolver solver = new CubeSolver(5);
		
		solver.combinationGenerator();
				
		solver.displayCubes();
				
	}
	
}
