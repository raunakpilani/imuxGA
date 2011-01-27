/**
 * 
 */
package operands;

/**
 * @author Raunak
 *
 */
public class Individual {
	public IPI[] ipiSet;
	public int individualSize;
	
	public Individual(int individualSize) {
		this.individualSize = individualSize;
		ipiSet = new IPI[individualSize];
	}
	/*
	double fitness(int choice) {
		switch (choice) {
		case 1: 
			for(int ic = 0; ic < individualSize; ic ++) {
				
			}
		}
	}*/
	
	
}
