package psa.naloga3;

import junit.framework.TestCase;

/**
 * insert Public Tests to this class. Public tests are written by the Instructor
 * and may be used for grading projects. This source code is made available to
 * students.
 */
public class PublicTests extends TestCase {

	private HashTable ht;
	private HashTable2 ht2;
		
	protected void setUp() throws Exception {
		ht = new HashTable();
		ht2 = new HashTable2();
	}
	
	public void testInsertHashTable2() {
		ht2.insert(1);
		assertTrue(ht2.data[53] == 1);
	}
	
	public void testSearchHashTable2Success() {
		ht2.insert(10);
		ht2.insert(15);
		assertTrue(ht2.search(10));
		assertTrue(ht2.search(15));
	}
	
	public void testSearchHashTable2Fail() {
		assertFalse(ht2.search(15));
		ht2.insert(10);
		assertFalse(ht2.search(17));
	}
	
	public void testVnosZeObstojecegaHasthTable2() {
		ht.insert(201);
		assertFalse(ht.insert(201));
	}

	public void testInsert() {
		ht.insert(0);
		assertTrue(ht.data[0].data[0] == 0);
	}
	
	public void testVnosZeObstojecega() {
		ht.insert(2);
		assertFalse(ht.insert(2));
	}
}
