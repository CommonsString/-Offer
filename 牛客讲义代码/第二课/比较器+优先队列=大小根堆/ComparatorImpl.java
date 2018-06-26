package nuiKe;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author commonsstring@gmail.com
 * 
 * 比较器的实现
 * 返回负数, 第一个参数放在前面
 * 返回正数, 第二个参数放在前面
 * 返回0, 一样大不改变位置
 */
public class ComparatorImpl {

	public static class Student{
		private int id;
		private String name;
		private int age;
		
		public Student(int id, String name, int age) {
			this.id = id;
			this.name = name;
			this.age = age;
		}
		
		@Override
		public String toString() {
			return this.id + "  " + this.name + "  " + this.age;
		}
	}

	//按照ID, 降序
	public static class idDescCompartor implements Comparator<Student>{
		@Override
		public int compare(Student o1, Student o2) {
			return o2.id - o1.id;
		}
	}
	
	//按照ID, 写法2
	public static class idDescCompartor2 implements Comparator<Student>{
		@Override
		public int compare(Student o1, Student o2) {
			if(o1.age < o2.age){
				return -1;
			}else if(o1.age > o1.age){
				return 1;
			}else{
				return 0;
			}
		}
	}
	
	//按照ID, 升序
	public static class idAscCompartor implements Comparator<Student>{
		@Override
		public int compare(Student o1, Student o2) {
			return o1.id - o2.id;
		}
	}	
	
	//打印
	public static void show(Student[] sutudents){
		for(int i = 0; i < sutudents.length; i++){
			System.out.println(sutudents[i].id + "  " + sutudents[i].name + "  " + sutudents[i].age);
		}
	}
	
	
	public static void main(String[] args) {
		//优先队列 + 比较器  = 大/小根堆
		PriorityQueue<Student> heap = new PriorityQueue<Student>(new idDescCompartor());
		Student s1 = new Student(1, "名字1", 20);
		Student s2 = new Student(2, "名字2", 30);
		Student s3 = new Student(3, "名字3", 40);
		heap.add(s1);
		heap.add(s2);
		heap.add(s3);
		System.out.println(heap.poll().toString());
	}
	
}
