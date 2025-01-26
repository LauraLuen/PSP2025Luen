package unit2;

class Chef99Threads implements Runnable {

    private String chefName;
    private String order;
    private int processingTime;  
    private static int orderCount = 0;  // Counter variable shared in all threads  

    public Chef99Threads(String chefName, String order, int processingTime) {
        this.chefName = chefName;
        this.order = order;
        this.processingTime = processingTime;
    }
    
    public void run() {
        	int currentOrderNumber;
	        	//counter used in synchronized block so numbers don't duplicate 
			        synchronized (Chef99Threads.class) {
			            orderCount++;
			            currentOrderNumber = orderCount;
			        }

        System.out.println(chefName + " started cooking " + order + " #" + currentOrderNumber);

        try {
            Thread.sleep(processingTime);  
        } catch (InterruptedException e) {
            System.out.println("Interruption in order " + order + " by " + chefName);
            e.printStackTrace();
        }

        // Simulate completion of the order
        System.out.println(chefName + " finished cooking " + order + " #" + currentOrderNumber);
    }
    
    public static void main(String[] args) {

        Chef99Threads chefCooking = new Chef99Threads("Arguiñano", "Marmitako", 2000);
        
        for (int i = 0; i < 99; i++) {      
            // Instantiate threads
            Thread hilo = new Thread(chefCooking);
            // start threads
            hilo.start();
        }
    }
}
