/**
* @author KGOSIEMANG_TA_217011260_CSC02A2_P04
* @version P04
*/
package acsse.csc2a.file;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import acsse.csc2a.model.EncryptedMessage;
import acsse.csc2a.model.MESSAGE_TYPE;
import acsse.csc2a.model.Message;
import acsse.csc2a.model.NormalMessage;
import acsse.csc2a.model.PLANET_TYPE;
import acsse.csc2a.model.SOSMessage;
import acsse.csc2a.model.Ship;

public class DataReader {
	
	public static Ship readship(String ShipName, String MessageName)
	{
		Ship ship = null;
		Message[] messages = new Message[7];
		DataInputStream dataShip = null;
		DataInputStream dataMessage = null;
		
		try {
			FileInputStream shipStream = new FileInputStream(ShipName);
			FileInputStream messageStream = new FileInputStream(MessageName);
			
			BufferedInputStream bufferShip = new BufferedInputStream(shipStream);
			BufferedInputStream bufferMessage = new BufferedInputStream(messageStream);
			
			dataShip = new DataInputStream(bufferShip);
			dataMessage = new DataInputStream(bufferMessage);
			
			String ID = dataShip.readUTF();
			String name = dataShip.readUTF();
			 ship = new Ship(ID, name);
			
			int index = 0;
		    
				String ida = dataMessage.readUTF();
				String contenta = dataMessage.readUTF();
				String srca = dataMessage.readUTF();
				String dsta = dataMessage.readUTF();
				String typea = dataMessage.readUTF();
				
				PLANET_TYPE src = PLANET_TYPE.valueOf(srca);
				PLANET_TYPE dst = PLANET_TYPE.valueOf(dsta);
				MESSAGE_TYPE Mtype = MESSAGE_TYPE.valueOf(typea);
				
				if(Mtype.equals(MESSAGE_TYPE.NormalMessage)) {
					
					NormalMessage	normal = new NormalMessage(ida, contenta, src, dst, Mtype);
					messages[index++] = normal;
				}else if(Mtype.equals(MESSAGE_TYPE.EncryptedMessage))
				{
					EncryptedMessage encypted = new EncryptedMessage(ida, contenta, src, dst, Mtype);
					messages[index++] = encypted;
				}else if(Mtype.equals(MESSAGE_TYPE.SOSMessage))
				{
					SOSMessage sos = new SOSMessage(ida, contenta, src, dst, Mtype);
					messages[index++] = sos;
				}
		
			
		} catch (IOException io) {
	
			io.printStackTrace();
		}finally
		{
			if(dataShip != null)
			{
				try {
					dataShip.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(dataMessage != null)
			{
				try {
					dataMessage.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		ship.addMessages(messages);;
		
		
		return ship;
	}

}
