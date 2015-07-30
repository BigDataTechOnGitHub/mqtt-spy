function publish()
{
	var Thread = Java.type("java.lang.Thread");

	for (i = 0; i < 20; i++)
	{
		mqttspy.publish("home/kitchen/current", (20 + Math.floor((Math.random() * 10) + 1) / 10), 0, false);

		if (i == 10)
		{
			Thread.sleep(10000);
		}

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
