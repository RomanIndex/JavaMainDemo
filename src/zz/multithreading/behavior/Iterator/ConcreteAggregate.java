package zz.multithreading.behavior.Iterator;

/**
 * 具体是 聚集 类，即需要迭代的
 */
public class ConcreteAggregate extends Aggregate{
	
	/**
	 * concrete
	 * adj.具体的，有形的，实在的，实际的; 固结成的，混凝土制的; 图案诗歌的;
	 * n.混凝土; 具体物; （图案式）有形诗; 〔建〕钢筋混凝土;
	 */
	
	private Object[] objArray = null;
	
	/**
	 * 返回 迭代子 对象
	 */
	@Override
    public Iterator createIterator() {
		System.out.println("ConcreteAggregate的@Override：返回："+new ConcreteIterator(this));
        return new ConcreteIterator(this);
    }
	
	/** 
     * 构造方法，传入聚合对象的具体内容 
     */  
    public ConcreteAggregate(Object[] objArray){
        this.objArray = objArray;  
    }

	/** 
     * 取值方法：向外界提供聚集元素 
     */  
    public Object getElement(int index){
          
        if(index < objArray.length){  
            return objArray[index];  
        }else{  
            return null;  
        }  
    }
    /** 
     * 取值方法：向外界提供聚集的大小 
     */  
    public int size(){  
        return objArray.length;  
    }

}
