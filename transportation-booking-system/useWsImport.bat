@echo off
"C:\Program Files\Java\jdk1.8.0_202\bin\wsimport" -d src\main\java\com\exalt\transportationbookingsystem\soapclientautogenerated -keep -p vehicleSoapClient "http://DESKTOP-VK3DF3H:8080/transportation-booking-system-1.0-SNAPSHOT/vehicleSoapClientService?wsdl"
"C:\Program Files\Java\jdk1.8.0_202\bin\wsimport" -d src\main\java\com\exalt\transportationbookingsystem\soapclientautogenerated -keep -p personSoapClient "http://DESKTOP-VK3DF3H:8080/transportation-booking-system-1.0-SNAPSHOT/personSoapClientService?wsdl"
"C:\Program Files\Java\jdk1.8.0_202\bin\wsimport" -d src\main\java\com\exalt\transportationbookingsystem\soapclientautogenerated -keep -p tripSoapClient "http://DESKTOP-VK3DF3H:8080/transportation-booking-system-1.0-SNAPSHOT/tripSoapClientService?wsdl"