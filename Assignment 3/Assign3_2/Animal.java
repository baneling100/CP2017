/*
name: Woohyeon Baek
student number: 2017-15782
 */

public class Animal {
    private char type;    //Carnivore, Herbivore, or Omnivore
    private String speciesName;  //Name of species
    private String name;  //Name of ID of individual
    private int agr; //agressive level of an Animal
    //you can add more here

    //You should use this constructor.
    public Animal(char _type, String _speciesName, String _name, int _agr) {
        type = _type; speciesName = _speciesName;
        name = _name;  agr = _agr;
    }
    public String getSpeciesName() {
        //should return speciesName
        //you should edit this method without changing function parameters and name
        return speciesName;
    }
    public String getName() {
        //should return name
        //you should edit this method without changing function parameters and name
        return name;
    }
    //you can add more here
    public char getType() { return type; }

    public int getAgr() { return agr; }
}
