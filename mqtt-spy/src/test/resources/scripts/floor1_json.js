function publish()
{
	var Thread = Java.type("java.lang.Thread");

	for (i = 0; i < 20; i++)
	{
		mqttspy.publish("/home/floor1/average", "{ temp: " + (20 + Math.floor((Math.random() * 10) + 1) / 10) + ", " + "energy: " + (100 + Math.floor((Math.random() * 10) + 1)) + "}", 0, false);	

		try 
		{
			Thread.sleep(1000);
		}
		catch(err) 
		{
			return false;				
		}
	}

	return true;
}

publish();
