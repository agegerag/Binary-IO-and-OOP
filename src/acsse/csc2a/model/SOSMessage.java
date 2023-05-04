/**
* @author KGOSIEMANG_TA_217011260_CSC02A2_P04
* @version P04
*/
package acsse.csc2a.model;

public class SOSMessage extends Message{

	public RECIPIENT_TYPE type;
	
	public SOSMessage(String iD, String contents, PLANET_TYPE planet_source, PLANET_TYPE planet_destination,
			MESSAGE_TYPE message_type) {
		super(iD, contents, planet_source, planet_destination, message_type);
		this.type = RECIPIENT_TYPE.PUBLIC;
	}

	@Override
	public boolean validate() {
		
		if(type.equals(RECIPIENT_TYPE.GOVERNMENT))
		{
			return true;
		}else if(type.equals(RECIPIENT_TYPE.PUBLIC))
		{
			return true;
		}
		return false;
	}

	/**
	 * @return the type
	 */
	public RECIPIENT_TYPE getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(RECIPIENT_TYPE type) {
		this.type = type;
	}

}
