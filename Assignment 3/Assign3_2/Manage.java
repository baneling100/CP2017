/*
name: Woohyeon Baek
student number: 2017-15782
 */

import java.util.Vector;

public class Manage {
    //you can add more
    private ManageInfo manageInfo;

    public Manage() {
        //default init
        manageInfo = null;
    }
    public Manage(ManageInfo info) {
        //general constructor you may use
        manageInfo = info;
    }
    public void set(ManageInfo info) {
        //if you prefer default constructor and setting later, you can use this.
        manageInfo = info;
    }
    public Report report() {
        //your final report result must be returned by this method.
        //you should edit this method without changing function parameters and name
        Vector<String> lines = new Vector<String>();
        int length = manageInfo.getLength();
        lines.add(Integer.toString(length));
        for(int i = 0; i < length; i++) {
            int animalsSize = manageInfo.getRoom(i).getAnimalsSize();
            int foodsSize = manageInfo.getRoom(i).getFoodsSize();
            boolean cType = false;
            boolean hType = false;
            for(int j = 0; j < foodsSize; j++) {
                if(manageInfo.getFood(i, j)) cType = true;
                else hType = true;
            }
            String line = "Room " + (i + 1) + " : ";
            for(int j = 0; j < animalsSize; j++)
                if(manageInfo.getAnimal(i, j).getAgr() == 1) {
                    line += "CareTreat, ";
                    break;
                }
            for(int j = 0; j < animalsSize; j++)
                if(manageInfo.getAnimal(i, j).getAgr() == 2) {
                    line += "Dangerous, ";
                    break;
                }
            for(int j = 0; j < animalsSize; j++) {
                char type = manageInfo.getAnimal(i, j).getType();
                if((type == 'C' && !cType) || (type == 'H' && !hType)) {
                    line += "FoodType, ";
                    break;
                }
            }
            if(line.endsWith(", "))
                line = line.substring(0, line.length() - 2);
            lines.add(line);
        }
        return new Report(lines);
    }
}
