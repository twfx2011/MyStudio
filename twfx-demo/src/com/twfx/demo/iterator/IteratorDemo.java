/**
 * 文件名：@IteratorDemo.java <br/>
 * 包名：com.twfx.demo <br/>
 * 项目名：twfx2011 <br/>
 * @author twfx <br/>
 */
package com.twfx.demo.iterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 类名：IteratorDemo  <br />
 *
 * 功能：迭代器示例
 * 
 * 试用场景：Iterator可用来遍历Set和List集合，只支持正向遍历
 *
 * @author twfx <br />
 * 创建时间：2019年7月3日 上午9:32:03  <br />
 * @version 2019年7月3日
 */
public class IteratorDemo {
	
	/**
	 * 功能：set<br/>
	 *
	 * @author twfx
	 * @version 2019年7月3日 上午9:33:42 <br/>
	 */
	public static void set_iterator() {
		Set<String> set = new HashSet<String>();
		set.add("张三");
		set.add("李四");
		set.add("王五");
		set.add("赵六");
		
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	/**
	 * 功能：list，iterator只支持正向遍历<br/>
	 *
	 * @author twfx
	 * @version 2019年7月3日 上午9:33:48 <br/>
	 */
	public static void list_iterator() {
		List<String> list = new ArrayList<String>();
		list.add("张三");
		list.add("李四");
		list.add("王五");
		list.add("赵六");
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	/**
	 * 功能:Map迭代器，Map是没有iterator方法的，我们可以通过map.entrySet()方法将其转换为set再调用set的iterator，间接的用迭代器实现<br/>
	 *
	 * @author twfx
	 * @version 2019年7月3日 上午9:33:48 <br/>
	 */
	public static void map_iterator() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("zhangsan", "张三");
		map.put("lisi", "李四");
		map.put("wangwu", "王五");
		map.put("zhaoliu", "赵六");
		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public static void main(String[] args) {
		
//		list_iterator();
//		set_iterator();
		map_iterator();
	}
}
