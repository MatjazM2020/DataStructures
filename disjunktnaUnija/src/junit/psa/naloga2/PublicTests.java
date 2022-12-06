package psa.naloga2;

import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;

/**
 * insert Public Tests to this class. Public tests are written by the Instructor
 * and may be used for grading projects. This source code is made available to
 * students.
 */
public class PublicTests extends TestCase {

	private UnionFind uf;
	
	protected void setUp() throws Exception {
		uf = new UnionFind(10);
	}

	public void testUstvariUF() {
		for(int i = 0; i < uf.id.length; i++) {
			assertEquals(i, uf.id[i]);
		}
	}
	
	public void testFindSimple() {
		for(int i = 0; i < uf.id.length; i++) {
			assertEquals(i, uf.find(i));
			assertFalse(i-1 == uf.find(i));
		}
	}
	
	public void testUnionSimple() {
		for(int i = 0; i < uf.id.length; i+=2) {
			uf.unite(i, i+1);
		}
		for(int i = 0; i < uf.id.length; i+=2) {
			assertTrue(uf.find(i) == uf.find(i+1));
		}
	}

}
