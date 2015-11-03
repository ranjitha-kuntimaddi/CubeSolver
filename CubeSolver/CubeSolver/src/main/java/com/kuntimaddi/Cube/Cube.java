
package com.kuntimaddi.Cube;

import java.util.ArrayList;

/**
 * Class cube represents cube and inherits Cube Edges
 *
 * A cube is made up of 6 Faces which contain an square integer matrix for a given size-[size][size]
 *
 * 1.Front Face
 * 2.Back Face
 * 3.Right Face
 * 4.Left Face
 * 5.Top Face
 * 6.Bottom Face
 *
 * The cube has 12 edges with sets of 4 Edges oriented along 3 Coordinate axes - X-Axis,Y-Axis,Z-Axis
 *
 * The elements of the edges corresponding to each orientation are encapsulated through CubeEdge class objects
 * that can store all possible key and lock Elements of an Edge generated from Edge Generator class
 *
 * X-Axis- The axis which contains all the corner elements of a cube edge. A cube of size '5' contains a list of all
 *         possible [1][5] integer matrix of both Locks and Keys. This matrix fills all the 8 corners of a cube
 *         through the edge elements of the matrix.
 *
 * Y-Axis- The axis which contains all the inner elements of a cube edge along y direction. A cube of size '5' contains
 *         a list of all possible [1][3] integer matrix of both Locks and Keys as the corners are already filled by
 *         X-Axis elements.
 *
 * Z-Axis- The axis which contains all the corner elements of a cube edge along z direction. A cube of size '5' contains
 *          a list of all possible [1][3] integer matrix of both Locks and Keys similar to Y-Axis elements.
 *
 * Each axis at a time holds 4 sets of (Locks,Keys)and 3 axis would form 12 sets of (Lock,Keys) to a complete cube
 */
public class Cube extends CubeEdges{

    private Face frontFace;
    private Face backFace;
    private Face rightFace;
    private Face leftFace;
    private Face topFace;
    private Face bottomFace;
    private CubeEdges xAxis;
    private CubeEdges yAxis;
    private CubeEdges zAxis;
    private int size;

    /**
     * Constructor for the class Cube
     * Initialisation of all the Face ans axis
     * Each face is initialised to have all the elements as filled objects.
     *
     * @param s Size of the cube...Can have values greater than 5
     */
    public Cube(int s)
    {
        super();
        size=s;
        xAxis = new CubeEdges();
        yAxis = new CubeEdges();
        zAxis = new CubeEdges();
        frontFace = new Face("Front face",size);
        backFace = new Face("Back Face",size);
        rightFace = new Face("Right Face",size);
        leftFace = new Face("Left Face",size);
        topFace = new Face("Top Face",size);
        bottomFace = new Face("Bottom Face",size);

    }



    /**
     * This method is defined to add the lock and key elements of a edges of a cube to their respective axis through a switch case
     * @param k List containing key elements of the axis
     * @param l List containing lock elements of the axis
     * @param axis Specifies the axis of the cube{[1-X Axis],[2-Y Axis],[3-Z Axis]} to which the lock and keys have to assigned
     * @return
     */
    public boolean assginAxis(ArrayList<String> k,ArrayList<String> l, int axis)
    {
        switch(axis)
        {
            case 1: xAxis.addEdges(k, l);
                break;
            case 2: yAxis.addEdges(k, l);
                break;
            case 3: zAxis.addEdges(k, l);
                break;
            default: return false;
        }

        return true;
    }



    /**
     * Initialize and assign values of each face with their corresponding locks and keys when each face join with another face of the cube
     *
     * Each face is made up of a square integer matrix that can store values
     * "1" - Corresponds to empty space
     * "0" - Corresponds to filled space
     * Two faces when joined together forms a complete edge.
     * First face of the joint is assigned with a Lock sand second face of the joint is assigned with a Key
     * And each matrix is contains 4 edges and
     *
     * 1.Top Edge
     * 2.Bottom Edge
     * 3.Right edge
     * 4.Left Edge
     *
     * Each Face joins each in an ordered fashion to form the complete cube
     *
     * Front Face:- 1.Top Edge - Joins with  Bottom edge of Top Face
     *              2.Bottom Edge - Joins top edge of Bottom Face
     *              3.Right edge - Joins with left edge of Right Face
     *              4.Left Edge - Joins with right edge of Left Face
     *
     * Back Face:-  1.Top Edge - Joins with  Bottom edge of Bottom Face
     *              2.Bottom Edge - Joins top edge of Top Face
     *              3.Right edge - Joins with right edge of Right Face
     *              4.Left Edge - Joins with left edge of Left Face
     *
     * Top Face:-   1.Top Edge - Joins with  Bottom edge of Back Face
     *              2.Bottom Edge - Joins top edge of Front Face
     *              3.Right edge - Joins with top edge of Right Face
     *              4.Left Edge - Joins with top edge of Left Face
     *
     *
     * @return
     */
    public boolean assignFaces()
    {
        int i=0,j=i+1,k=i+2,l=i+3;
        frontFace.initializeFace(xAxis.getKey(i), xAxis.getLock(j), zAxis.getKey(i), zAxis.getLock(j));
        rightFace.initializeFace(yAxis.getKey(i), yAxis.getLock(j), zAxis.getKey(l), zAxis.getLock(i));
        backFace.initializeFace(xAxis.getKey(k), xAxis.getLock(l), zAxis.getLock(l), zAxis.getKey(k));
        leftFace.initializeFace(yAxis.getKey(l), yAxis.getLock(k), zAxis.getKey(j), zAxis.getLock(k));
        StringBuilder str = new StringBuilder(yAxis.getLock(i));
        StringBuilder str2 = new StringBuilder(yAxis.getLock(l));
        topFace.initializeFace(xAxis.getKey(l), xAxis.getLock(i), str.reverse().toString(),str2.reverse().toString());
        str = new StringBuilder(yAxis.getKey(j));
        str2 = new StringBuilder(yAxis.getKey(k));
        bottomFace.initializeFace(xAxis.getKey(j), xAxis.getLock(k),str.reverse().toString() ,str2.reverse().toString());

        return true;
    }

    /**
     * Displays each face of cube in matrix form through Face class method display()
     */
    public void display()
    {

        frontFace.displayMatrix();
        bottomFace.displayMatrix();
        backFace.displayMatrix();
        topFace.displayMatrix();
        rightFace.displayMatrix();
        leftFace.displayMatrix();


    }


}
