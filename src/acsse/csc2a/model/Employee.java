/**
* @author KGOSIEMANG_TA_217011260_CSC02A2_P04
* @version P04
*/
package acsse.csc2a.model;

public class Employee implements IValidation{
	
	public String EmployeeID;
	public String firstName;
	public String lastName;
	public Ship ship;

	public Employee(String EmployeeID,String firstName,String lastName) {
		
		this.EmployeeID = EmployeeID;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public boolean validate() {
		if(EmployeeID.length() == 6)
		{
			return true;
		}else
		return false;
	}
	
	
	public void printMessages(Ship ship)
	{
		System.out.println("--------EMPLOYEE INFO------------");
		System.out.printf("ID: %s *****NAME: %s >< LASTNAME: %s\n",this.EmployeeID,this.firstName,this.lastName);
		System.out.println("--------SHIP INFO------------");
		System.out.printf("ID: %s AND   NAME: %s\n--------MESSAGE INFO------------\n",ship.getID(),ship.getName());
		for(Message msg : ship.getMessages())
		{
			if(msg instanceof SOSMessage)
			{
				SOSMessage sos =(SOSMessage)msg;
				System.out.printf("**SOSMESSAGE**\n%s %s %s %s %s\n",sos.ID,sos.contents,sos.planet_source.toString(),sos.planet_destination.toString(),sos.message_type.toString());
			}else if(msg instanceof NormalMessage)
			{
				NormalMessage normal =(NormalMessage)msg;
				System.out.printf("**NORMALMESSAGE**\n%s %s %s %s %s\n", normal.ID, normal.contents, normal.planet_source.toString(), normal.planet_destination.toString(), normal.message_type.toString());
			}else if(msg instanceof EncryptedMessage)
			{
				EncryptedMessage encypted =(EncryptedMessage)msg;
				System.out.printf("**ENCYPTEDMESSAGE**\n%s %s %s %s %s\n", encypted.ID, encypted.contents, encypted.planet_source.toString(), encypted.planet_destination.toString(), encypted.message_type.toString());
			}
		}
		
	}
	
	public  boolean sendMessages(Ship ship)
	{
		
		for(Message msg : ship.getMessages())
		{
			if(msg instanceof SOSMessage)
			{
				SOSMessage sos =(SOSMessage)msg;
				if(!sos.validate())
				{
					return false;
				}
			}else if(msg instanceof NormalMessage)
			{
				NormalMessage normal =(NormalMessage)msg;
				if(!normal.validate())
				{
					return false;
				}
			}else if(msg instanceof EncryptedMessage)
			{
				EncryptedMessage encypted =(EncryptedMessage)msg;
				if(!encypted.validate())
				{
					return false;
				}
			}
		}
		
	        return true;
		
	}
	

	/**
	 * @return the employeeID
	 */
	public String getEmployeeID() {
		return EmployeeID;
	}

	/**
	 * @param employeeID the employeeID to set
	 */
	public void setEmployeeID(String employeeID) {
		EmployeeID = employeeID;
	}

}
