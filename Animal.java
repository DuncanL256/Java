public class Animal {
    int age;
    String animalType;
    String sound;
    int swam;
    
    public Animal(){
        age = 15;
        animalType = "wild";
        sound = "meow";
    }

    public Animal(String name){
        /** 
        age = 20;
        animalType = name;
        sound = "bark";
        */
    }

    public void getAge()
    {
        System.out.println("My age is:" + age);
    }

    public void swim(int swam){

        System.out.println("Distance swam is: " + swam);
    }

    public static void main(String[] args) {
        int age = 20;
        String animalType = "dog";
        String sound = "bark";
        
        System.out.println(" ");
        System.out.println("This is my age: " + age);
        System.out.println("This is my type: " + animalType);
        System.out.println("This is my sound: " + sound);
        System.out.println(" ");
    }
}