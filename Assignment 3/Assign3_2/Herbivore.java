/*
name: Woohyeon Baek
student number: 2017-15782
 */

public class Herbivore extends Animal {
    //you can add more without changing method parameters and name

    public Herbivore(char _type, String _speciesName, String _name, int _agr) { super(_type, _speciesName, _name, _agr); }
    public String getSpeciesName() {
        //should add “(Herbi)” at the end of original speciesName
        //e.g.) “Elephant” -> “Elephant(Herbi)”
        return super.getSpeciesName() + "(Herbi)";
    }
}
