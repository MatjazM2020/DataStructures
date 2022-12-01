package psa.naloga0;

import junit.framework.TestCase;

/**
 * Add Public Tests to this class. Public tests are written by the Instructor
 * and may be used for grading projects. This source code is made available to
 * students.
 */
public class PublicTests extends TestCase {
	Naloga bloom;

	protected void setUp() throws Exception {
		bloom = new Naloga(255, 4);
	}
	
	public void testAddElement() {
		bloom.add("test");
		for (int i = 0; i < bloom.podatki.length; i++) {
			if(i == 152 || i == 57 || i == 103 || i == 185) 
				assertTrue(bloom.podatki[i]);
			else {
				assertFalse(bloom.podatki[i]);
			}
		}
	}
	
	public void testContainsElement() {
		bloom.add("test");
		assertTrue(bloom.contains("test"));
		assertFalse(bloom.contains("test2"));
	}
}

