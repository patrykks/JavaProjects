package edu.agh.jtplab.zad1;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.lang.reflect.Type;



public class Main
{
	public static void main(String [] argv)
	{
		// Create a File object on the root of the directory containing the class file
		File mean_file = new File("./plugins/MeanFilter.class");
		File median_file = new File("./plugins/MedianFilter.class");
		ClassLoader mean_class_loader = null;
		ClassLoader median_class_loader = null;
		try {
		    // Convert File to a URL
		    URL mean_url = mean_file.toURI().toURL();     
		    URL median_url = median_file.toURI().toURL();    
		    URL[] mean_urls = new URL[]{mean_url};
		    URL[] median_urls = new URL[]{median_url};

		    // Create a new class loader with the directory
		    mean_class_loader = new URLClassLoader(mean_urls);
		    median_class_loader = new URLClassLoader(median_urls);

		    // Load in the class; MyClass.class should be located in
		    // the directory file:/c:/myclasses/com/mycompany
		    Class mean_cls = mean_class_loader.loadClass("MeanFilter");
		    Class median_cls = median_class_loader.loadClass("MedianFilter");
		    System.out.println("--------------------Mean ----------------");
		    System.out.format("Class:%n  %s%n%n", mean_cls.getCanonicalName());
		    System.out.format("Modifiers:%n  %s%n%n",
			       Modifier.toString(mean_cls.getModifiers()));
		    Method[] mean_methods = mean_cls.getMethods();
		    if (mean_methods.length != 0) {
			for (Method mthds : mean_methods)
			    System.out.format("  %s%n", mthds.toString());
			System.out.format("%n");
		    } else {
			System.out.format("  -- No Implemented methods --%n%n");
		    }
		    
		    Type[] mean_intfs = mean_cls.getGenericInterfaces();
		    if (mean_intfs.length != 0) {
			for (Type intf : mean_intfs)
			    System.out.format("  %s%n", intf.toString());
			System.out.format("%n");
		    } else {
			System.out.format("  -- No Implemented Interfaces --%n%n");
		    }

		    System.out.println("--------------------Median ----------------");
		    System.out.format("Class:%n  %s%n%n", median_cls.getCanonicalName());
		    System.out.format("Modifiers:%n  %s%n%n",
			       Modifier.toString(median_cls.getModifiers()));
		    Method[] median_methods = median_cls.getMethods();
		    if (median_methods.length != 0) {
			for (Method mthds : median_methods)
			    System.out.format("  %s%n", mthds.toString());
			System.out.format("%n");
		    } else {
			System.out.format("  -- No Implemented methods --%n%n");
		    }
		    Type[] median_intfs = median_cls.getGenericInterfaces();
		    if (median_intfs.length != 0) {
			for (Type intf : median_intfs)
			    System.out.format("  %s%n", intf.toString());
			System.out.format("%n");
		    } else {
			System.out.format("  -- No Implemented Interfaces --%n%n");
		    }
			// Runnig dynamically loaded class methods
			final Object obj = median_cls.getConstructor(
					   String.class).newInstance("./mini.jpg");
			Method method = median_cls.getDeclaredMethod("process");
			method.invoke(obj);

		} catch (MalformedURLException e) {
		} catch (ClassNotFoundException e) {
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
