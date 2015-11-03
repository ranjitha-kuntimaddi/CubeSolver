package com.kuntimaddi.Cube;

/**
 *  Face class represents a face of a cube. It holds a square integer matrix of size - [size][size]
 *
 */
public class Face {

	private String name;
	private char[][] matrix;
	private int size;

    /**
     * Constructor the the class Face to initialise with the name and all the elements are initially in filled state
	 * excepts at the edges
     * @param str- Name of the Face corresponding to a cube.
     * @param s - Size of the integer matrix.
     */
	public Face(String str,int s)
	{
		size = s;
		name =str;
		matrix = new char[size][size];		
		
		for(int i=0;i<size;++i)
		{
			for(int j=0;j<size;++j)
			{
				if(((i==0)&&(j==0))||(j==size-1)||(i==size-1))
				{
					matrix[i][j] = ' ';
				}else{
					matrix[i][j] = '0';
				}
			}
		}
	}

    /**
     * Initializes the Faces of the cube with corresponding edges.
	 * The top and bottom edge are of size 's' and the right and left edege are initialize to hold 's-2' elements
     * @param top- Corresponds to the top edge of a face
     * @param bottom - Corresponds to the bottom edge of a face
     * @param right - Corresponds to the right edge of a face
     * @param left - Corresponds to the left edge of a face
     * @return
     */
	public boolean initializeFace(String top,String bottom,String right,String left)
	{
		int length = top.length();
		if(length==size)
		{
			for(int k=0;k<size;++k)
			{			
				matrix[0][k] = top.charAt(k);
				matrix[size-1][k] = bottom.charAt(k);
				
			}
		}else
		{
			for(int k=0;k<size-2;++k)
			{			
				matrix[0][k+1] = top.charAt(k);
				matrix[size-1][k+1] = bottom.charAt(k);				
			}
		}		
		for(int k=0;k<size-2;++k)
		{			
			matrix[k+1][size-1] = right.charAt(k);
			matrix[k+1][0] = left.charAt(k);
		}
		
		return true;
	}

    /**
     * Displays the face cube in the matrix form
     */
	public void displayMatrix()
	{
		System.out.println("\n"+name+" :");
		for(int i=0;i<size; ++i)
		{
			System.out.println();			
			for(int j=0;j<size;++j)
			{
				char ch = matrix[i][j];
				if(ch== '1')
				{
					System.out.print(" " + " ");
				}else
				{
					System.out.print(ch+ " ");
				}
				
			}
		}
	}
	
}
