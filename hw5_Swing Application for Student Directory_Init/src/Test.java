import java.util.List;

public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
/*            Student a = new Student("terrylee"); 
            a.setPhoneNumber("412-268-1078");
            a.setFirstName("terry");
            a.setLastName("Lee");*/
            Student b = new Student("jle"); 
            b.setPhoneNumber("412-268-1474");
            b.setFirstName("j");
            b.setLastName("le");
            Student c = new Student("gagalee"); 
            c.setPhoneNumber("412-268-1079");
            c.setFirstName("gaga");
            c.setLastName("Lee");
            //System.out.println(a);
            //System.out.println(b);
            Directory s = new Directory();       
            s.addStudent(b);
            s.addStudent(c);
            //s.checkList();
            //s.checkmap(); 
//            System.out.print(s.searchByLastName("Lee"));
//            System.out.print(s.searchByAndrewId("terrylee"));
//            s.deleteStudent("terrylee");
//            s.checkmap2();
            //s.addStudent(null);
/*            Student a = new Student("terrylee"); 
            a.setPhoneNumber("412-268-1078");
            a.setFirstName("terry");
            a.setLastName("Lee");
            s.addStudent(a);
            s.searchByAndrewId("terrylee").setFirstName("aaa");  
            System.out.println(a);*/
            
            List<Student> vvv = s.searchByLastName("Lee");
            vvv.clear();
            //vvv.add("dddz");
//            System.out.println(vvv);
//            List<Student> hhh = s.searchByLastName("Lee");
//            System.out.println(hhh);
//            //a.setLastName("bbb");
//            System.out.println(a);
//            s.checkmap(); 
            //s.checkmap2(); 
            //s.searchByFirstName("gaga");  
  /*          List<Student> hhh = s.searchByFirstName("gaga");
            List<Student> hhhh = s.searchByFirstName("j");
            System.out.println(hhh);
            System.out.println(hhhh);*/
            //s.deleteStudent("gagalee");
            s.checkmap();
            s.searchByAndrewId("jle");
    }
}
