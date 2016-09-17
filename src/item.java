/**
 * Created by Miles on 9/17/2016.
 */
public class item {
    String name;
    String description;
    int value;
    public item(String name,String description,int value){
        this.name = name;
        this.value = value;
        this.description = description;

    }
    public class weapon extends item{
        int damage;
        int condition;
        public weapon(String name, String description, int damage, int value,int condition){
            super(name,description,value);
            this.damage = damage;
            this.condition = condition;
        }
    }
    public class armor extends item{
        int protection;
        int condition;
        public armor(String name, String description, int protection, int value,int condition){
            super(name,description,value);
            this.protection = protection;
            this.condition = condition;
        }
    }
}
