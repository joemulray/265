/*
Joseph Mulray
Lab 9 jUnit
November 20 2016

Implement a Java class gInt (Gaussian Integer) 
and write a JUnit test suite. Use Ant to bring it all together.
*/

import java.util.*;
import java.io.*;

public class gInt{
	
	int a, b;
	double i = Math.sqrt(-1);



	public gInt( int r){

		a = r;
	}

	public gInt( int r, int i){

		a = r;
		b = i;

	}
	public int real(){
	
		return a;
	
	}	
	
	public int imag(){

		return b;

	}
	public gInt add( gInt rhs){

		gInt total = new gInt(rhs.real() + a, rhs.imag() + b);
		return total;
	}
	
	public gInt multiply( gInt rhs ){

		gInt product = new gInt(rhs.real() * a, rhs.imag() *b);
		return product;
	}
	
	public float norm(){
	
	return (float)Math.sqrt( (a * a) + (b * b) );

	}

	
}

