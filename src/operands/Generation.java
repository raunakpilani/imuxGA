/**
 * 
 */
package operands;

/**
 * @author Raunak
 *
 */
public class Generation {
	public Individual[] individualSet;
	public int populationSize;
	public int individualSize;
	
	public Generation(int populationSize, int individualSize) {
		this.populationSize = populationSize;
		this.individualSize = individualSize;
		
		individualSet = new Individual[populationSize];
		for(int pc = 0; pc < populationSize; pc++) {
			individualSet[pc] = new Individual(individualSize);
		}
	}
	
}
