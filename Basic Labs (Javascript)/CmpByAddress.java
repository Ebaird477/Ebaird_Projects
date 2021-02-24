import java.util.Comparator;

public class CmpByAddress implements Comparator<Person> {


    public int compare(Person a, Person b){
if(a.getMailingAddress().compareTo(b.getMailingAddress()) < 0){

    return -1;


}
else if (a.getMailingAddress().compareTo(b.getMailingAddress()) > 0){
    return 1;
}

else{
    return 0;
}
    





}
}