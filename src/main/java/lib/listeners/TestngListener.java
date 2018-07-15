package lib.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import javax.naming.spi.DirStateFactory.Result;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

public class TestngListener implements IAnnotationTransformer,IRetryAnalyzer {
int maxcount=1;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(!result.isSuccess()&&maxcount<=1)
		{
			maxcount++;
		}
		return false;
	}

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub
		if(testMethod.getName().equals("EditLeadListener"))
		{
		annotation.setEnabled(false);
		}
		 
		if(testMethod.getName().equals("CreateLeadListener"))
		{
		annotation.setInvocationTimeOut(10000);
		}
		annotation.setRetryAnalyzer(this.getClass());
		
	}

}
