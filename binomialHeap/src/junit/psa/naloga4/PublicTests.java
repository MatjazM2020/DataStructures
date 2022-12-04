package psa.naloga4;

import junit.framework.TestCase;

/**
 * insert Public Tests to this class. Public tests are written by the Instructor
 * and may be used for grading projects. This source code is made available to
 * students.
 */

public class PublicTests extends TestCase {
	BinomialHeap heap;
	int cmpsAtStart;
	int cmpsAtEnd;

	protected void setUp() throws Exception {
		heap = new BinomialHeap();
	}
	
	public void testInsert() {
		heap.insert(2);
		assertEquals(2, heap.data[0].getKey());
	}
	
	public void testResize() {
		heap.insert(7);
		heap.insert(2);
		assertEquals(2, heap.data.length);
	}
	
	public void testMerge() {
		heap.insert(7);
		heap.insert(2);
		assertEquals(2, heap.data[1].getKey());
		assertEquals(7, heap.data[1].getChilds().elementAt(0).getKey());
	}
	
	public void testNegativeNumers() {
		heap.insert(-17);
		heap.insert(-32);
		assertEquals(-32, heap.data[1].getKey());
		assertEquals(-17, heap.data[1].getChilds().elementAt(0).getKey());
	}
	
	public void testGetMin() {
		heap.insert(-17);
		heap.insert(-32);
		heap.insert(7);
		heap.insert(22);
		heap.insert(-7);
		heap.insert(26);
		assertEquals(-32, heap.getMin());
	}
	
	public void testDelMin() {
		heap.insert(-17);
		heap.insert(-32);
		heap.insert(7);
		heap.insert(22);
		heap.insert(-7);
		heap.insert(26);
		assertEquals(-32, heap.getMin());
		assertTrue(heap.delMin());
		assertEquals(-17, heap.getMin());
	}
}
