package com.kuntimaddi.Cube;

import java.util.ArrayList;

/**
 *  CubeEdges is defined to contain all possible sets of Keys and Locks values of all the corresponding edges
 *  of a Cube oriented in a particular direction.
 */
public class CubeEdges {


	private ArrayList<String> key; 
	private ArrayList<String> lock;

    /**
     * Constructor of the class CubeEdge which initialises the Array List
     */
	public CubeEdges()
	{
		key = new ArrayList<String>();
		lock = new ArrayList<String>();
	}

    /**
     * Method to add Edges to the Cube
     * @param k Passes  the list of key elements
     * @param l Passes the list of lock elements
     */
	public void addEdges(ArrayList<String> k,ArrayList<String> l)
	{
		key = k;
		lock = l;
	}

    /**
     *
     * @param pos Passes the position of the required key in the List
     * @return Returns the value of a key at given position from the list
     */
	public String getKey(int pos)
	{
		return key.get(pos);
	}

    /**
     *
     * @param pos Passes the position of the required Lock in the List
     * @return Returns the value of a Lock at given position from the list
     */
	public String getLock(int pos)
	{
		return lock.get(pos);
	}
}

