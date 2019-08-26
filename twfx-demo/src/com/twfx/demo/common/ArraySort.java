/**
 * 文件名：@ArraySort.java <br/>
 * 包名：com.twfx.demo.common <br/>
 * 项目名：twfx-demo <br/>
 * @author twfx <br/>
 */
package com.twfx.demo.common;

/**
 * 类名：ArraySort <br />
 *
 * 功能：数组排序
 *
 * @author twfx <br />
 *         创建时间：2019年8月26日 上午9:54:32 <br />
 * @version 2019年8月26日
 */
public class ArraySort {

	/**
	 * 功能：冒泡排序<br/>
	 * 说明：冒泡排序是一种交换排序,冒泡排序就是把小的元素往前调或者把大的元素往后调。
	 * 方式：从前往后比较
	 * @author twfx
	 * @version 2019年8月26日 上午10:01:30 <br/>
	 */
	public static void bubbleSort(int[] array) {

		printAll(array, "冒泡排序前：");
		
		int temp = 0; // 存在用于交换的临时数
		for (int i = 0; i < array.length - 1; i++) {
			// 比较相邻两个元素，较大的数往后冒泡
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j + 1]; // 把第一个元素值保存到临时变量中
					array[j + 1] = array[j]; // 把第二个元素值转移到第一个元素变量中
					array[j] = temp; // 把临时变量（第一个元素的原值）保存到第二个元素中
				}
			}
			printAll(array, String.format("第 %d 趟：\t", i));
		}
		
		printAll(array, "冒泡排序后：");
	}
	
	
	/**
	 * 功能：优化后冒泡排序<br/>
	 * 说明：对冒泡排序常见的改进方法是加入标志性变量changeFlag，用于标志某一趟排序过程中是否有数据交换。
	 * 如果进行某一趟排序时并没有进行数据交换，则说明所有数据已经有序，可立即结束排序，避免不必要的比较过程。
	 * 方式：从前往后比较
	 * @author twfx
	 * @version 2019年8月26日 上午10:01:30 <br/>
	 */
	public static void bubbleSort_2(int[] array) {

		printAll(array, "冒泡排序前：");
		
		int temp = 0; // 存在用于交换的临时数
		boolean changeFlag = false;
		for (int i = 0; i < array.length - 1; i++) {
			changeFlag = false;
			// 比较相邻两个元素，较大的数往后冒泡
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j + 1]; // 把第一个元素值保存到临时变量中
					array[j + 1] = array[j]; // 把第二个元素值转移到第一个元素变量中
					array[j] = temp; // 把临时变量（第一个元素的原值）保存到第二个元素中
					changeFlag = true;
				}
			}
			
			// 如果标志为false，说明本轮遍历没有交换，已经是有序数列，可以结束排序
	        if (!changeFlag)
	            break;
	        
	        printAll(array, String.format("第 %d 趟：\t", i));
		}
		
		printAll(array, "冒泡排序后：");
	}
	
	/**
	 * 功能：优化后冒泡排序<br/>
	 * 说明：对冒泡排序常见的改进方法是加入标志性变量changeFlag，用于标志某一趟排序过程中是否有数据交换。
	 * 如果进行某一趟排序时并没有进行数据交换，则说明所有数据已经有序，可立即结束排序，避免不必要的比较过程。
	 * 方式：从后往前比较
	 * @author twfx
	 * @version 2019年8月26日 上午10:01:30 <br/>
	 */
	public static void bubbleSort_3(int[] array) {

		printAll(array, "冒泡排序前：");
		
		int temp = 0; // 存在用于交换的临时数
		boolean changeFlag = false;
		// 要遍历的次数
		for (int i = 0; i < array.length - 1; i++) {
			changeFlag = false;
			// 从后向前依次的比较相邻两个数的大小，遍历一次后，把数组中第i小的数放在第i个位置上
			for (int j = array.length - 1; j > i; j--) {
				if (array[j - 1] > array[j]) {
					temp = array[j - 1]; // 把第一个元素值保存到临时变量中
					array[j - 1] = array[j]; // 把第二个元素值转移到第一个元素变量中
					array[j] = temp; // 把临时变量（第一个元素的原值）保存到第二个元素中
					changeFlag = true;
				}
			}
			
			// 如果标志为false，说明本轮遍历没有交换，已经是有序数列，可以结束排序
	        if (!changeFlag)
	            break;
	        
	        printAll(array, String.format("第 %d 趟：\t", i));
		}
		
		printAll(array, "冒泡排序后：");
	}
	
	/**
	 * 功能：<br/>
	 *
	 * @author twfx
	 * @version 2019年8月26日 上午11:27:47 <br/>
	 */
	private static void printAll(int[] array, String remark) {
		System.out.print(remark);
		for (int i = 0; i < array.length; i++) {
			System.out.print(" " + array[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] array = { 80, 100, 90, 63, 70 };
		bubbleSort_2(array);
		
	}
}
