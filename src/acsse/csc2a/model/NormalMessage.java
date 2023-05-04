/**
* @author KGOSIEMANG_TA_217011260_CSC02A2_P04
* @version P04
*/
package acsse.csc2a.model;

public class NormalMessage extends Message{
     public int MESSAGE_LENGTH;
     
	public NormalMessage(String iD, String contents, PLANET_TYPE planet_source, PLANET_TYPE planet_destination,
			MESSAGE_TYPE message_type) {
		super(iD, contents, planet_source, planet_destination, message_type);
	    this.MESSAGE_LENGTH = 525457;
	}

	@Override
	public boolean validate() {
		if((1 <= MESSAGE_LENGTH) && (MESSAGE_LENGTH <= 40))
		{
			return true;
		}else
		
		return false;
	}

	/**
	 * @return the mESSAGE_LENGTH
	 */
	public int getMESSAGE_LENGTH() {
		return MESSAGE_LENGTH;
	}

	/**
	 * @param mESSAGE_LENGTH the mESSAGE_LENGTH to set
	 */
	public void setMESSAGE_LENGTH(int mESSAGE_LENGTH) {
		MESSAGE_LENGTH = mESSAGE_LENGTH;
	}

	

}
