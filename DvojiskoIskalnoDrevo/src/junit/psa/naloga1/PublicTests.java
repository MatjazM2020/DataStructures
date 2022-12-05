package psa.naloga1;

import junit.framework.TestCase;

/**
 * Add Public Tests to this class. Public tests are written by the Instructor
 * and may be used for grading projects. This source code is made available to
 * students.
 */
public class PublicTests extends TestCase {
	private Seznam seznam;
	private Binarno binarno;

	protected void setUp() throws Exception {
		seznam = new Seznam();
		seznam.insert(2);
		seznam.insert(5);
		seznam.insert(4);
		seznam.insert(1);
		seznam.insert(8);
		seznam.insert(3);
		
		binarno = new Binarno();
		binarno.insert(2);
		binarno.insert(5);
		binarno.insert(4);
		binarno.insert(1);
		binarno.insert(8);
		binarno.insert(3);
	}

	public void testSeznamIskanjeUspesno() {
		assertTrue(seznam.search(3));
	}
	
	public void testSeznamIskanjeNeuspesno() {
		assertFalse(seznam.search(10));
	}
	
	public void testSeznamBrisanje() {
		seznam.delete(4);
		assertFalse(seznam.search(4));
	}
	
	public void testBinarnoIskanjeUspesno() {
		assertTrue(binarno.search(3));
	}
	
	public void testBinarnoIskanjeNeuspesno() {
		assertFalse(binarno.search(10));
	}
	
	public void testBinarnoBrisanje() {
		binarno.delete(4);
		assertFalse(binarno.search(4));
	}
}
