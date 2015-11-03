package com.kuntimaddi.Cube;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * This class is designed to generate all possible sets of edges that can be formed for a given size.
 *
 * A cube of given size-'s' contains an edge of length - 's'.
 * A string is used as the base element to hold all the calculated sets and provide manipulative flexibility
 * and the string is defined to contain '1' and '0' values.
 * "1" - Corresponds to empty space and
 * "0" - Corresponds to filled space in a cube.
 *
 * Due to the possability of only two different  types of variables('1','0') to be placed as a single element and
 * in a given given edge of size-'s'. The total number of possible edges are- [2^s].
 * For a cube of size '5' it would be computed to 2^5 = 32 elements.
 *
 * These computed elements are stored in a map [pairSet] in the form of Keys and Locks was they are complements to each other
 * and when joined together they form a completely filled side of an cube.
 *
 *
 */
public class EdgeGenerator{

    private Map<String,String> pairSet = new TreeMap<String,String>();
    private int size;

    /*
     * Class initialization with the size of and edge side
     */
    public EdgeGenerator(int s)
    {
        size =s;
    }

    /**
     * It generates all possible Outer and inner edges of a cube for a given size.
     *
     * Integer starting from 1 to 2^s are created and converted into a binary string then the string is padded
     * with '0' element to form the edge of size 's'. The generated sets are divided into lock and keys and stored in
     * the Map 'pairSet'.
     *
     */
    void generate()
    {
        ArrayList<String> possibleSet = new ArrayList<String>();
        String pad = "0";
        int p =size;
        while(--p>0)
        {
            pad = pad +"0";
        }
        for(int i=1;i<Math.pow(2,size)-1;++i)
        {
            String str = Integer.toBinaryString(i);

            if(str.length()<size)
            {
                str = pad.substring(str.length()) + str;
            }
            possibleSet.add(str);
        }
        for(int i=0,j = possibleSet.size()-1;i<possibleSet.size()/2;++i,--j)
        {
            pairSet.put(possibleSet.get(i),possibleSet.get(j));
        }
        pairSet.put(pairSet.get(possibleSet.get(size-2)),possibleSet.get(size-2));
    }

	/**
	 * This method filters the generated Locks and Keys to remove the elements with a single filled corner pieces
	 */

    public void filter()
    {
        Collection<String> c = pairSet.keySet();
        Iterator<String> itr = c.iterator();

        while(itr.hasNext())
        {
            String key = (String) itr.next();
            String value = pairSet.get(key.toString());
            if(key.startsWith("10")||(value.startsWith("10")))
            {
                itr.remove();
                pairSet.remove(key);
            }else if(key.substring(key.length()-2).startsWith("01")||(value.substring(value.length()-2).equals("01")))
            {
                itr.remove();
                pairSet.remove(key);
            }
        }

    }

    /**
     * Returns the Key list of the generated edges values
     */
    public ArrayList<String> getKeysList()
    {
        ArrayList<String> keys = new ArrayList<String>();
        Set<String> keySet = pairSet.keySet();
        for(String key:keySet)
        {
            keys.add(key);
        }

        return keys;
    }


    /**
     * Returns the Lock list of the generated edges values
     */
    public ArrayList<String> getlocksList()
    {
        ArrayList<String> locks = new ArrayList<String>();
        Collection<String> c = pairSet.values();
        Iterator<String> itr = c.iterator();

        while(itr.hasNext())
        {
            locks.add(itr.next());
        }

        return locks;
    }

    /**
     * Returns the size of the Array list
     */
    public int size()
    {
        return pairSet.size();
    }

}








