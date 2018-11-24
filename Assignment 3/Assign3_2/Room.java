/*
name: Woohyeon Baek
student number: 2017-15782
 */

import java.util.Vector;

public class Room {
    //should contains lists of Animals and Foods
    //you can add more fields or methods.
    private Vector<Animal> animals;
    private Vector<Boolean> foods;

    public Room() {
        //default init
        //Initialize your data structures here.
        animals = new Vector<Animal>();
        foods = new Vector<Boolean>();
    }
    //The following two methods should be constructed.
    //do not modify method name and parameters.
    public void addAnimal(Animal ani) { animals.add(ani); }
    public void addFood(boolean food) { foods.add(food); }
    public Animal getAnimal(int index) {
        //you should edit this method without changing function parameters and name
        return animals.elementAt(index);
    }
    public boolean getFood(int index) {
        //you should edit this method without changing function parameters and name
        return foods.elementAt(index);
    }
    public int getAnimalsSize() {
        //return the size of Animal list, vector, or array
        return animals.size();
    }
    public int getFoodsSize() {
        //return the size of Food list, vector, or array
        return foods.size();
    }
}
