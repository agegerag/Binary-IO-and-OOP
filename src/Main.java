/**
* @author KGOSIEMANG_TA_217011260_CSC02A2_P04
* @version P04
*/

import acsse.csc2a.file.DataReader;
import acsse.csc2a.model.Employee;
import acsse.csc2a.model.Ship;

public class Main {

	public static void main(String[] args) {
		
        Employee employee = new Employee("199636", "TA", "KGOSIEMANG");
        
        if(employee.validate())
        {
        	System.out.println("Validation Successful");
        }else
        {
        	System.err.println("Validation Unsuccessful");
        }
        
        String ShipFile = "data/ship.dat";
        String MessageFile = "data/messages.dat";
        
        Ship ship = DataReader.readship(ShipFile, MessageFile);
        
        employee.printMessages(ship);
        if(employee.sendMessages(ship))
        {
        	System.out.println("Validation Successful, Message Sent!!!!!!");
        }else
        {
        	System.err.println("Validation Unsuccessful, Message was not sent");
        }
	}

}
