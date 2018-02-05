package Utility;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import resources.Constants;

public class TestListener implements ITestListener,Constants {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getName(); 
		try{ 
			Robot r=new Robot(); 
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();	
			Rectangle screenRect=new Rectangle(d); 
			BufferedImage img = r.createScreenCapture(screenRect); 
			SimpleDateFormat s=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss"); 
			String now = s.format(new Date()); 
			ImageIO.write(img, "png",new File(SUCCESS_PHOTO_PATH+testName+now+".png")); 
			Reporter.log("Success TestCase is:"+result.getName(),true);
		} 
		catch(Exception e){ }
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getName(); 
		try{ 
			Robot r=new Robot(); 
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();	
			Rectangle screenRect=new Rectangle(d); 
			BufferedImage img = r.createScreenCapture(screenRect); 
			SimpleDateFormat s=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss"); 
			String now = s.format(new Date()); 
			ImageIO.write(img, "png",new File(FAIL_PHOTO_PATH+testName+now+".png")); 
			Reporter.log("Failed TestCase is:"+result.getName(),true);
		} 
		catch(Exception e){ }
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
