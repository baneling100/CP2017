/*
name: Woohyeon Baek
student number: 2017-15782
 */

public class Carnivore extends Animal {
    //you can add more without changing method parameters and name

    public Carnivore(char _type, String _speciesName, String _name, int _agr) { super(_type, _speciesName, _name, _agr); }
    public String getSpeciesName() {
        //should add “(Carni)” at the end of original speciesName
        //e.g.) “Lion” -> “Lion(Carni)”
        return super.getSpeciesName() + "(Carni)";
    }
}
