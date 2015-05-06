package ygrec;

//import jssc.SerialPortList;
import jssc.SerialPort;
import jssc.SerialPortException;

public class ComPortListener {
	   
//    public static void main(String[] args) {
//        //����� getPortNames() ���������� ������ �����. �������� ������� ��� �������������.
//        String[] portNames = SerialPortList.getPortNames();
//        for(int i = 0; i < portNames.length; i++){
//            System.out.println(portNames[i]);
//        }
//    }
	
    public static void main(String[] args) {
        //� ����������� ������ ������� ��� ����� � ������� �� ����� ��������
        SerialPort serialPort = new SerialPort("COM18");
        try {
            //��������� ����
            serialPort.openPort();
            //���������� ���������. ����� ������������ � ����� ������ serialPort.setParams(9600, 8, 1, 0);
            serialPort.setParams(SerialPort.BAUDRATE_9600, 
                                 SerialPort.DATABITS_8,
                                 SerialPort.STOPBITS_1,
                                 SerialPort.PARITY_NONE);
            //���������� ������ � ����
            serialPort.writeString("+Test\r\n");
            //������ ������ � ���������� 10 ����. ����� ����������� � ������� readBytes(), ���� �� ������� ������
            //����� ������ ����, �� ����� ����� ������� ������� ����������. ����� ������������ ��� ��������� �
            //����������� SerialPortEventListener.
            byte[] buffer = serialPort.readBytes(50);
            System.out.println(buffer);
            //��������� ����
            serialPort.closePort();
        }
        catch (SerialPortException ex) {
            System.out.println(ex);
        }
    }
    
}
//public class ComPortListener {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}
