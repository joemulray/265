/*
Joseph Mulray
Lab 9 jUnit
November 20 2016
*/

import java.util.*;
import java.io.*;
import junit.framework.*;

public class gIntTest extends TestCase{

	private gInt test1;
	private gInt test2;
	private gInt test3;
	private gInt test4;

	public gIntTest( String name){

	super(name);

	}
	
	protected void setUp(){

	test1 = new gInt(1,2);
	test2 = new gInt(2,3);
	test3 = new gInt(3,4);
	test4 = new gInt(4,5);

	}


	public void testAdd(){
		
		gInt expected = new gInt(3,5);
		gInt addResult = test1.add(test2);
	
		//test if expected and add results are equal
		Assert.assertEquals(expected.real(), addResult.real());
		Assert.assertEquals(expected.imag(), addResult.imag());
		
	}
	
	public void testMultiply(){

		gInt expected = new gInt(6,12);
		gInt mResult = test2.multiply(test3);

		//test if expected and mutiply result are equal
		Assert.assertEquals(expected.real(), mResult.real());
		Assert.assertEquals(expected.imag(), mResult.imag());
	}


	public void testNorm(){
	
		float expected = (float)Math.sqrt(41);
		float nResult = test4.norm();
	
		//test if expected and norm result are equal
		Assert.assertEquals(expected, nResult);

	}

	public static Test suite(){
	
		TestSuite suite = new TestSuite();
		
		//suite.addTest( new gIntTest( "setUp" ));	
		suite.addTest( new gIntTest( "testAdd" ));	
		suite.addTest( new gIntTest( "testMultiply" ));
		suite.addTest( new gIntTest( "testNorm" ));
		
		return suite;
	}

	public static void main(String [] args){

		String[] caseName = {gIntTest.class.getName()};
		junit.textui.TestRunner.main(caseName);
	}

}
