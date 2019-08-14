/**
 * 文件名：@ListIteratorDemo.java <br/>
 * 包名：com.twfx.demo <br/>
 * 项目名：twfx2011 <br/>
 * @author twfx <br/>
 */
package com.twfx.demo.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * 类名：ListIteratorDemo  <br />
 *
 * 功能：List迭代器示例
 * 
 * 试用场景：ListIterator只能用来遍历List集合，可以正向遍历也可以反向遍历
 *
 * @author twfx <br />
 * 创建时间：2019年7月3日 上午10:22:37  <br />
 * @version 2019年7月3日
 */
public class ListIteratorDemo {

	/**
	 * 功能：ListIterator正向输出<br/>
	 *
	 * @author twfx
	 * @version 2019年7月3日 上午9:27:07 <br/>
	 */
	public static void listIterator_next() {
		List<String> list = new ArrayList<String>();
		list.add("张三");
		list.add("李四");
		list.add("王五");
		list.add("赵六");
		ListIterator<String> it = list.listIterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	/**
	 * 功能：ListIterator反向输出<br/>
	 *
	 * @author twfx
	 * @version 2019年7月3日 上午9:27:07 <br/>
	 */
	public static void listIterator_previous() {
		List<String> list = new ArrayList<String>();
		list.add("张三");
		list.add("李四");
		list.add("王五");
		list.add("赵六");
		ListIterator<String> it = list.listIterator(list.size()); // 反向遍历时记得将迭代器指针置到最后
		while(it.hasPrevious()) {
			System.out.println(it.previous());
		}
	}
	
	public static void main(String[] args) {
		
//		listIterator_previous();
		
		listIterator_next();
	}
}
