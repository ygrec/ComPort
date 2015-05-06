package ygrec;

//import jssc.SerialPortList;
import jssc.SerialPort;
import jssc.SerialPortException;

public class ComPortListener {
	   
//    public static void main(String[] args) {
//        //Метод getPortNames() возвращает массив строк. Элементы массива уже отсортированы.
//        String[] portNames = SerialPortList.getPortNames();
//        for(int i = 0; i < portNames.length; i++){
//            System.out.println(portNames[i]);
//        }
//    }
	
    public static void main(String[] args) {
        //В конструктор класса передаём имя порта с которым мы будем работать
        SerialPort serialPort = new SerialPort("COM18");
        try {
            //Открываем порт
            serialPort.openPort();
            //Выставляем параметры. Можно использовать и такую строку serialPort.setParams(9600, 8, 1, 0);
            serialPort.setParams(SerialPort.BAUDRATE_9600, 
                                 SerialPort.DATABITS_8,
                                 SerialPort.STOPBITS_1,
                                 SerialPort.PARITY_NONE);
            //Записываем данные в порт
            serialPort.writeString("+Test\r\n");
            //Читаем данные в количестве 10 байт. Будте внимательны с методом readBytes(), если во входном буфере
            //будет меньше байт, то метод будет ожидать нужного количества. Лучше использовать его совместно с
            //интерфейсом SerialPortEventListener.
            byte[] buffer = serialPort.readBytes(50);
            System.out.println(buffer);
            //Закрываем порт
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
