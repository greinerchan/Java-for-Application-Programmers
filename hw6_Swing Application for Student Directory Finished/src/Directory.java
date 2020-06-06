import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.LinkedList;
/**
 * Title: Student Directory App.
 * @author Xi Chen
 * Andrew ID: xc4
 * Lecturer's Name: Terry Lee
 * Lab Section: HW5
 */
public class Directory {
    /**
     * Define a map which maps by andrewID.
     */
    private Map<String, Student> mapID;
    /**
     * Define a map which is mapping by first name.
     */
    private Map<String, List<Student>> mapFirst;
    /**
     * Define a map which is mapping by last name.
     */
    private Map<String, List<Student>> mapLast;
    /**
     * Create a new list which is list of student.
     */
    private List<Student> listSt = new LinkedList<Student>();
    /**
     * Create a new list which is list student of fist name.
     */
    private List<Student> listFirst;
    /**
     * Create a new list which is list student of last name.
     */
    private List<Student> listLast;
    /**
     * Create a copy list of first name.
     */
    private List<Student> listCopy1;
    /**
     * Create a copy list of last name.
     */
    private List<Student> listCopy2;
/*    private List<Student> listFirstD;
    private List<Student> listLastD;*/
    /**
     * Create three new Hashmaps.
     */
    public Directory() {
        mapID = new HashMap<String, Student>();
        mapFirst = new HashMap<String, List<Student>>();
        mapLast = new HashMap<String, List<Student>>();
    }
    /**
     * add students to this three maps.
     * @param s New student instance.
     */
    public void addStudent(Student s) {
        listFirst = new LinkedList<Student>();
        listLast = new LinkedList<Student>();
        if ((s == null) || (s.getLastName() == null)
                || (s.getFirstName() == null)
                || (mapID.containsKey(s.getAndrewId()))) {
            throw new IllegalArgumentException();
        }
        Student nb = new Student(s.getAndrewId());
        //create a new student
        nb.setFirstName(s.getFirstName());
        nb.setLastName(s.getLastName());
        nb.setPhoneNumber(s.getPhoneNumber());
        mapID.put(nb.getAndrewId(), nb);
        if (mapLast.containsKey(nb.getLastName())) {
/* method1  mapLast.get(s.getLastName()).add(s);
            which is quick method, directly add to the list
            of people has same Last name*/
//method2   create new list of map value
           /* listLast = new LinkedList<Student>();*/
            //save original value to new list
            listLast.addAll(mapLast.get(nb.getLastName()));
            //put key and new list to the map
            //create copy of new student, keep map original
            //add new value new list
            listLast.add(nb);
            mapLast.put(nb.getLastName(), listLast);
        } else {
            listLast.add(nb);
            mapLast.put(nb.getLastName(), listLast);
        }
        if (mapFirst.containsKey(nb.getFirstName())) {
            /*mapFirst.get(nb.getFirstName()).add(nb);
             * this method is not work when pass the reference
             * student*/
            listFirst.addAll(mapFirst.get(nb.getFirstName()));
            listFirst.add(nb);
            mapFirst.put(nb.getFirstName(), listFirst);
        } else {
            /*listFirst = new LinkedList<Student>();*/
            listFirst.add(nb);
            mapFirst.put(nb.getFirstName(), listFirst);
        }
    }
    /**
     * Delete student by reference of andrewId.
     * @param andrewId Student's andrewId.
     */
    public void deleteStudent(String andrewId) {
        if ((andrewId == null) || (mapID.get(andrewId) == null)) {
            throw new IllegalArgumentException();
        } else {
            Student sb = mapID.get(andrewId);
            mapLast.get(sb.getLastName()).remove(sb);
            mapFirst.get(sb.getFirstName()).remove(sb);
            //mapLast.remove(sb.getLastName());
            //mapFirst.remove(sb.getFirstName());
/*            listFirstD = new LinkedList<Student>();
            listFirstD.addAll(mapFirst.get(sb.getFirstName()));
            listFirstD.remove(sb);
            listLastD = new LinkedList<Student>();
            listLastD.addAll(mapLast.get(sb.getLastName()));
            listLastD.remove(sb);*/
            /*mapFirst.put(sb.getFirstName(), listFirstD);  */
/*            wrong!!!
            Cannot do it step by step, since instance sb already
            remove from the list, sb.getFirstName() will work like
            null.getFristName(), null pointer exception.*/
            mapID.remove(andrewId);
        }
        /*
        mapLast.remove(sb.getLastName());
        mapFirst.remove(sb.getFirstName());
        they won't work!!!.
        this will delete all the student
        share the same first/last name*/
    }
    /**
     * Search student by student Id in mapID.
     * @param andrewId Student' ID
     * @return the instance of student
     */
    public Student searchByAndrewId(String andrewId) {
        if (andrewId == null) {
            throw new IllegalArgumentException();
        }
        if (mapID.get(andrewId) == null) {
            return null;
        }
        Student copy4 = mapID.get(andrewId);
        Student copy3 = new Student(andrewId);
        copy3.setFirstName(copy4.getFirstName());
        copy3.setLastName(copy4.getLastName());
        copy3.setPhoneNumber(copy4.getPhoneNumber());
        return copy3;
    }
    /**
     * Search student by student first name in mapFirst.
     * @param firstName Student's first name.
     * @return a instance of searched student.
     */
    public List<Student> searchByFirstName(String firstName) {
        List<Student> nobody = new LinkedList<Student>();
        if (firstName == null) {
            throw new IllegalArgumentException();
        }
        if (mapFirst.get(firstName) == null) {
            return nobody;
        }
        listCopy1 = new LinkedList<Student>();
        List<Student> copy1 = mapFirst.get(firstName);
        int length = copy1.size();
        for (int i = 0; i < length; i++) {
            Student stt = new Student(copy1.get(i).getAndrewId());
            stt.setFirstName(copy1.get(i).getFirstName());
            stt.setLastName(copy1.get(i).getLastName());
            stt.setPhoneNumber(copy1.get(i).getPhoneNumber());
            listCopy1.add(stt);
        }
        return listCopy1;
    }
    /**
     * Search student by last name.
     * @param lastName student's last name.
     * @return an instance of student.
     */
    public List<Student> searchByLastName(String lastName) {
        List<Student> none = new LinkedList<Student>();
        if (lastName == null) {
            throw new IllegalArgumentException();
        }
        if (mapLast.get(lastName) == null) {
            return none;
        }
        listCopy2 = new LinkedList<Student>();
        List<Student> copy2 = mapLast.get(lastName);
        for (int j = 0; j < copy2.size(); j++) {
            Student sd = new Student(copy2.get(j).getAndrewId());
            sd.setFirstName(copy2.get(j).getFirstName());
            sd.setLastName(copy2.get(j).getLastName());
            sd.setPhoneNumber(copy2.get(j).getPhoneNumber());
            listCopy2.add(sd);
        }
        return listCopy2;
    }
    /**
     * return the size of mapID.
     * @return return the size of mapID.
     */
    public int size() {
        return mapID.size();
    }
/*    private static Student copyStudent(Student s) {
        Student nb = new Student(s.getAndrewId());
        //create a new student
        nb.setFirstName(s.getFirstName());
        nb.setLastName(s.getLastName());
        nb.setPhoneNumber(s.getPhoneNumber());
        return nb;
    }*/
    /**
     * print the linkedlist element.
     */
    public void checkList() {
        for (Student element : listSt) {
            System.out.println("Student: " + element);
        }
    }
    /**
     * print the mapLast element.
     */
    public void checkmap() {
        for (List<Student> s : mapLast.values()) {
            System.out.println("mapLast: " + s);
        }
    }
    /**
     * Check the mapFirst element.
     */
    public void checkmap2() {
        for (List<Student> t : mapFirst.values()) {
            System.out.println("mapFirst: " + t);
        }
    }
    /**
     * Check the mapID element.
     */
    public void checkmap3() {
        for (Student f : mapID.values()) {
            System.out.println("mapID: " + f);
        }
    }
}
