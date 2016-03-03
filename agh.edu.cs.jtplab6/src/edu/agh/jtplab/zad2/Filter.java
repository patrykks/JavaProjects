package edu.agh.jtplab.zad2;
import java.lang.reflect.InvocationTargetException;

import edu.agh.jtplab.zad0.iImageFilter;
import edu.agh.jtplab.zad0.MeanFilter;;

public class Filter {
	private iImageFilter imagine_filter;
	
	public Filter()
	{
		this.imagine_filter = new MeanFilter("./mini.jpg");
	}
	
	public void filter() throws Throwable
	{
		imagine_filter.process();
	}
	public void replaceObj() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
	{
		Class<?> c = Class.forName("edu.agh.jtplab.zad0.MedianFilter");
		imagine_filter = (iImageFilter) c.getConstructor(
				   String.class).newInstance("./mini.jpg");
	}


}
