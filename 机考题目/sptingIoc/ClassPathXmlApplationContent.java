package com.main;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 简单实现IOC
 * dom4j + xml + 反射技术
 * @author commonsstring@gmail.com
 *
 */
public class ClassPathXmlApplationContent {
	
	// 存放对象
	private HashMap<String, Object> map = new HashMap<>();
	
	public Object getBean(String id) {
		return map.get(id);
	}
	
	public ClassPathXmlApplationContent(String path) {
		try {
			// 配置文件使用绝对路径
			File xml = new File(path);
			SAXReader reader = new SAXReader();
			Document document = reader.read(xml);
			// 获取XML中的根节点 <beans>
			Element root = document.getRootElement();
			// 遍历根节点，原因根节点有多个二级节点
			@SuppressWarnings("unchecked")
			Iterator<Element> it = root.elementIterator();
			while(it.hasNext()) {
				Element second = it.next();
				// 遍历二级节点
				@SuppressWarnings("unchecked")
				Iterator<Element> itSecond = second.elementIterator();
				// 构造函数创建对象/Set或Get
				Object objB = null;
				Object curObjA = null;
				while(itSecond.hasNext()) {
					Element third = itSecond.next();
					Attribute attrRef = third.attribute("ref");
					String ref = attrRef.getValue();
					// 查看Map
					if(map.containsKey(ref)) {
						objB = map.get(ref);
					}
				}
				Attribute attrId = second.attribute("id");
				String id = attrId.getValue();
				Attribute attrClass = second.attribute("class");
				String classPath = attrClass.getValue();
				// 开始反射
				Class<?> classR = Class.forName(classPath);
				if(objB != null) {
					Constructor<?> constructor = classR.getConstructor(objB.getClass());
					curObjA = constructor.newInstance(objB);
				} else {
					curObjA = classR.newInstance();
				}
				// 放入map
				map.put(id, curObjA);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
