package curs20;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestExample {
	
	
	
	@Test(invocationCount = 4)
	public void runMultipleTimes() {
		System.out.println("TestNg print");
	}
	
	@RunMultipleTimes(times=4)
	@Test
	public void testAnnotation() {
		System.out.println("Annotation test print");
	}
	
	
	
	@BeforeClass
	public void setUp() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		TestExample testObj =  new TestExample();
		
		for(Method method: testObj.getClass().getDeclaredMethods()) {
			
			if(method.isAnnotationPresent(RunMultipleTimes.class)) {
				
				RunMultipleTimes annotation = method.getAnnotation(RunMultipleTimes.class);
				
				for(int i=0; i< annotation.times(); i++) {
					
					method.invoke(testObj);
				}
				
			}
			
		}
		
	}

}
