class Sleep{
	
	public static void sleep(long milliseconds){
		try{
			Thread.currentThread().sleep(milliseconds);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}