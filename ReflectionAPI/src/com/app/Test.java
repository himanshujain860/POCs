package com.app;

import java.lang.reflect.Method;

/**
 * Class used as main method class to invoke method in
 * @author h.g.jain
 *
 */
public class Test {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object executeMethod(String className, String methodName, Class[] parameterTypes, Object[] parameters)throws Exception{
		Class clazz = Class.forName(className);
		Method method = clazz.getMethod(methodName, parameterTypes);
		return method.invoke(clazz.newInstance(), parameters);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object executeStaticMethod(String className, String methodName, Class[] parameterTypes, Object[] parameters)throws Exception{
		Class clazz = Class.forName(className);
		Method method = clazz.getMethod(methodName, parameterTypes);
		return method.invoke(clazz.newInstance(), parameters);
	}

	public static void main(String[] args) throws Exception {
		Parameter x = new Parameter();
		x.setValue(5);
		Class[] parameterTypes = {Parameter.class};
		Object[] parameters = {x};
		executeMethod("com.app.User", "display", parameterTypes, parameters);
		Class[] parameterTypes2 = {Parameter.class, String.class};
		Object[] parameters2 = {x, new String("Himanshu")};
		executeMethod("com.app.User2", "display", parameterTypes2, parameters2);
		executeMethod("com.app.User2", "act", new Class[]{}, new Object[]{});
	}
}