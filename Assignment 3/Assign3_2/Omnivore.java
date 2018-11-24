/*
name: Woohyeon Baek
student number: 2017-15782
 */

public class Omnivore extends Animal {
    //you can add more without changing method parameters and name

    public Omnivore(char _type, String _speciesName, String _name, int _agr) { super(_type, _speciesName, _name, _agr); }
    public String getSpeciesName() {
        //should add “(Omni)” at the end of original speciesName
        //e.g.) “Chimpanzee” -> “Chimpanzee(Omni)”
        return super.getSpeciesName() + "(Omni)";
    }
}
