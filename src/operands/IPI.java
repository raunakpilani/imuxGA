/**
 * 
 */
package operands;

/**
 * @author Raunak
 * 
 */
public class IPI {
	public int callToken;
	public int[] pathSet;
	public int ipiSize;
	
	/**
	 * Create a random IPI using CallTokenSet and ViableSet
	 * @param ipiSize Number of paths allowed in the pathSet
	 * @param ipiIndex Index of IPI in the Individual 
	 */
	public IPI(int ipiSize, int ipiIndex) {
		this.ipiSize = ipiSize;
		this.pathSet = new int[this.ipiSize];
		//this.callToken = randomFromSet(CallTokenSet); // generates a new call token not alreasy used in the calltokenset 
		for (int pc = 0; pc < ipiSize; pc++) {
			//pathSet[pc] = randomFromSet(ViableSet);
		}
	}
}
