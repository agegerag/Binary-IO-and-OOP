/**
* @author KGOSIEMANG_TA_217011260_CSC02A2_P04
* @version P04
*/
package acsse.csc2a.model;

public class EncryptedMessage extends Message{

	public String stringLength;
	public EncryptedMessage(String iD, String contents, PLANET_TYPE planet_source, PLANET_TYPE planet_destination,
			MESSAGE_TYPE message_type) {
		super(iD, contents, planet_source, planet_destination, message_type);
		this.stringLength = "KJDNDJDBDH";
	}

	@Override
	public boolean validate() {
		if(stringLength.length() > 10)
		{
			return true;
		}else
		return false;
	}

	/**
	 * @return the stringLength
	 */
	public String getStringLength() {
		return stringLength;
	}

	/**
	 * @param stringLength the stringLength to set
	 */
	public void setStringLength(String stringLength) {
		this.stringLength = stringLength;
	}

}
