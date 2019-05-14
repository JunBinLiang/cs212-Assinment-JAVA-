import javax.swing.JMenuBar;

public class Car {
    private String year;
    private String mileage;
    private String model;
    private String make;
    
    
    public Car(String year,String milleage,String model, String make){
       this.year=year;
       this.mileage=milleage;
       this.model=model;
       this.make=make;
    }
    
    public String getMake(){
     return make;
    }
     public String getModel(){
     return model;
    }
      public String getYear(){
     return year;
    }
       public String getMileage(){
     return mileage;
    }
       
       @Override
       public String toString(){
    	   String copyYear=year;
    	   String copyMilleage=mileage;
    	   
    	   if(copyYear.equals("0")) {
    		   copyYear="";
     	  }
    	   if(copyMilleage.equals("0")) {
    		   copyMilleage="";
     	  }
    	   
       
           return make+","+model+","+copyYear+","+copyMilleage;
       }
       
}

