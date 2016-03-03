package edu.agh.jtplab.zad3;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class Main {
	public static void main(String [] argv)
	{
		boolean found = false;
	 	try {
		    Class<?> cls = Class.forName("edu.agh.jtplab.zad3.Const");
		    Field[] flds = cls.getDeclaredFields();
		    for (Field f : flds) {
	 		Class<?> c = f.getType();
			if (c.isArray()) {
			    found = true;
			    //System.out.println(f.get(null));

			    int length = Array.getLength(f.get(null));
			    for (int i=0;i<length;i++)
			    {
			    	System.out.print(Array.get(f.get(null), i)+"  ");
			    }
			    System.out.println("");
			    //System.out.format("%s%n"
	            //                   + "           Field: %s%n"
				//       + "            Type: %s%n"
				//       + "  Component Type: %s%n",
				//       f, f.getName(), c, c.getComponentType());
			}
		    }
		    if (!found) {
			System.out.format("No array fields%n");
		    }

	        // production code should handle this exception more gracefully
	 	} catch (ClassNotFoundException x) {
		    x.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
