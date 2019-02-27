package com.singleMain;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaClass;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.LazyDynaBean;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.beanutils.BasicDynaClass;

import java.util.Map;
import java.util.List;
import java.util.Date;
import java.util.HashMap;
import java.util.GregorianCalendar;

public class DynaBeansExample {

	public static void main(String args[]) throws Exception {
	    Object movie = createMovieBean();
	    //System.err.println(BeanUtils.getProperty(movie, "title"));
	    //System.err.println(BeanUtils.getProperty(movie, "director.name"));
	    System.out.println(BeanUtils.getProperty(movie, "title"));
	    System.out.println(BeanUtils.getProperty(movie, "director.name"));
	  }

	  private static Object createMovieBean() throws Exception {

	    // first create the properties
	    DynaProperty properties[] = new DynaProperty[] {
	      new DynaProperty("title", String.class),//电影名字
	      new DynaProperty("dateOfRelease", Date.class),//上映时间
	      new DynaProperty("keywords", String[].class),//关键字
	      new DynaProperty("genre", Map.class),//类型
	      new DynaProperty("actors", List.class),//演员表
	      new DynaProperty("director", DynaBean.class)//导演，监制人
	    };

	    // next using the properties define the class
	    DynaClass movieClass = new BasicDynaClass("movie", null, properties);

	    // now, with the class, create a new instance
	    DynaBean movieBean = movieClass.newInstance();

	    // set its properties
	    movieBean.set("title", "The Italian Job");
	    movieBean.set("dateOfRelease", new GregorianCalendar(1969, 0, 1).getTime());
	    movieBean.set("keywords", new String[] {"Italy", "Bank Robbery"});

	    Map genre = new HashMap();
	    genre.put("THR", "Thriller");

	    movieBean.set("genre", genre);
	    movieBean.set("genre", "ACT", "Action");

	    DynaBean director = createPersonBean();
	    director.set("name", "Peter Collinson");
	    director.set("gender", new Integer(1));

	    movieBean.set("director", director);

	    return movieBean;
	  }

	  private static DynaBean createPersonBean() {
	    DynaBean person = new LazyDynaBean();
	    return person;
	  }
}
