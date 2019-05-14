
public class Car {
    private int year;
    private int mileage;
    private String model;
    private String make;
    
    public Car(int year,int milleage,String model, String make){
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
      public int getYear(){
     return year;
    }
       public int getMileage(){
     return mileage;
    }
       
       @Override
       public String toString(){
       
           return make+","+model+","+Integer.toString(year)+","+Integer.toString(mileage);
       }
       
}

