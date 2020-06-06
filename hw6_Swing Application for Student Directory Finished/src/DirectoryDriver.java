import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
/**
 *
 * @author Xi Chen
 * Andrew ID xc4
 * This is a APP about student directory system.
 */
public class DirectoryDriver {
    /**
     * add student button.
     */
    private JButton addButton;
    /**
     * delete student button.
     */
    private JButton deleteButton;
    /**
     * search student ID button.
     */
    private JButton searchID;
    /**
     * search student first name button.
     */
    private JButton searchFirst;
    /**
     * search student last name button.
     */
    private JButton searchLast;
    /**
     * create a text area for result.
     */
    private JTextArea textArea;
    /**
     * named a blue border line.
     */
    private Border blueline;
    /**
     * create a student directory.
     */
    private Directory s = new Directory();
    /**
     * create student instance.
     */
    private Student ab;
    /**
     * create text filed.
     */
    private JTextField field1, field2, field3, field4, field5, field6;
    /**
     * create UI for student system.
     * contructor can invoke method and instance variable
     */
    public DirectoryDriver() {
        //
        //Frame
        //
        JFrame frame = new JFrame("Swing Application for Student Directory");
        frame.setSize(960, 850);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //
        //Instantiate an ActionLister
        //
        ActionListener listener = new MyActionListener();
        KeyListener listener2 = new MykeyListener();
        //
        //Set Font
        //
        Font font = new Font(Font.SERIF, Font.BOLD, 20);
        Font font2 = new Font(Font.SERIF, Font.ROMAN_BASELINE, 18);
        Font font3 = new Font(Font.SERIF, Font.ROMAN_BASELINE, 17);
        //
        //Create Panel
        //
        //the core pane for major layout
        JPanel pane = new JPanel();
        //box layout for major layout, flow from upper to lower.
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        //flowlayout for part1, which form left to right
        JPanel part1 = new JPanel();
        part1.setLayout(new FlowLayout(FlowLayout.LEFT));
        pane.add(part1);
        JPanel part2 = new JPanel();
        part2.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
        pane.add(part2);
        JPanel part3 = new JPanel();
        part3.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 30));
        pane.add(part3);
        //create layout for text area in th center
        JPanel part4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pane.add(part4);
        JPanel name = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pane.add(name);
        //
        //create label
        //
        JLabel label = new JLabel("Student Directory");
        label.setFont(font);
        name.add(label);
        //
        //Titled borders
        //title 1
        TitledBorder title1;
        //title name and color
        title1 = BorderFactory.createTitledBorder(
                blueline, "Add a new student");
        //place put title
        title1.setTitleJustification(TitledBorder.LEADING);
        //set title color
        title1.setTitleColor(Color.blue);
        title1.setTitleFont(font2);
        part1.setBorder(title1);
        //title 2
        TitledBorder title2;
        title2 = BorderFactory.createTitledBorder(
                blueline, "Delete a student");
        title2.setTitleJustification(TitledBorder.LEADING);
        title2.setTitleColor(Color.blue);
        title2.setTitleFont(font2);
        part2.setBorder(title2);
        //title 3
        TitledBorder title3;
        title3 = BorderFactory.createTitledBorder(
                blueline, "Search student(s)");
        title3.setTitleJustification(TitledBorder.LEADING);
        title3.setTitleColor(Color.blue);
        title3.setTitleFont(font2);
        part3.setBorder(title3);
        //tittle 4
        TitledBorder title4;
        title4 = BorderFactory.createTitledBorder(
                blueline, "Results");
        title4.setTitleJustification(TitledBorder.LEADING);
        title4.setTitleColor(Color.blue);
        title4.setTitleFont(font2);
        part4.setBorder(title4);
        //
        //Decorate each box part
        //part1
        JLabel label1 = new JLabel("First Name:");
        label1.setFont(font2);
        field1 = new JTextField(8);
        JLabel label2 = new JLabel("Last Name:");
        field2 = new JTextField(8);
        label2.setFont(font2);
        JLabel label3 = new JLabel("Andrew ID:");
        field3 = new JTextField(8);
        label3.setFont(font2);
        JLabel label4 = new JLabel("Phone Number:");
        field4 = new JTextField(8);
        label4.setFont(font2);
        //add button part1
        addButton = new JButton("Add");
        addButton.setBorder(BorderFactory.createRaisedBevelBorder());
        //ugly ui
        //addButton.setBorder(BorderFactory.createLoweredBevelBorder());
        //set button set
        addButton.setPreferredSize(new Dimension(120, 30));
        addButton.setFont(font2);
        //add label and field to part1
        part1.add(label1);
        part1.add(field1);
        part1.add(label2);
        part1.add(field2);
        part1.add(label3);
        part1.add(field3);
        part1.add(label4);
        part1.add(field4);
        //add button to part1
        addButton.addActionListener(listener);
        part1.add(addButton);
        //
        //decorate part2
        //create label
        JLabel label5 = new JLabel("Andrew ID:");
        label5.setFont(font2);
        field5 = new JTextField(20);
        //add button to part2
        deleteButton = new JButton("Delete");
        deleteButton.setBorder(BorderFactory.createRaisedBevelBorder());
        deleteButton.setPreferredSize(new Dimension(120, 30));
        deleteButton.setFont(font2);
        //add label and field
        part2.add(label5);
        part2.add(field5);
        //add button
        deleteButton.addActionListener(listener);
        part2.add(deleteButton);
        //decorate part3
        //add label part3
        JLabel label6 = new JLabel("Search Key:");
        label6.setFont(font2);
        field6 = new JTextField(20);
        //create button to part3
        searchID = new JButton("By Andrew ID");
        //set button appearance
        searchID.setBorder(BorderFactory.createRaisedBevelBorder());
        //set button size
        searchID.setPreferredSize(new Dimension(140, 30));
        //set button font
        searchID.setFont(font2);
        searchFirst = new JButton("By First Name");
        searchFirst.setBorder(BorderFactory.createRaisedBevelBorder());
        searchFirst.setPreferredSize(new Dimension(140, 30));
        searchFirst.setFont(font2);
        searchLast = new JButton("By Last Name");
        searchLast.setBorder(BorderFactory.createRaisedBevelBorder());
        searchLast.setPreferredSize(new Dimension(140, 30));
        searchLast.setFont(font2);
        //add label and field to part3
        part3.add(label6);
        field6.addKeyListener(listener2);
        part3.add(field6);
        //add button to part3
        searchID.addActionListener(listener);
        part3.add(searchID);
        searchFirst.addActionListener(listener);
        part3.add(searchFirst);
        searchLast.addActionListener(listener);
        part3.add(searchLast);
        //
        //decorate part4
        //add text area to part4 with scroller
        textArea = new JTextArea(20, 70);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setFont(font3);
        JScrollPane scroller = new JScrollPane(textArea);
        scroller.setFont(font3);
        part4.add(scroller);
        //
        //set up
        //
        frame.setContentPane(pane);
        frame.setVisible(true);
    }
    /**
     *
     * @author grein
     * Action listener which can performed the incident
     */
        private class MyActionListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent event) {
                String firstN = field1.getText();
                String lastN = field2.getText();
                String andrewId = field3.getText();
                String phoneN = field4.getText();
                String andrewIdD = field5.getText();
                String search = field6.getText();
               /* s = new Directory();    */
                //event for addbutton
                if (event.getSource() == addButton) {
                    if (firstN == null || firstN.trim().equals("")) {
                        textArea.append("First Name missing\n");
                        return;
                    }
                    if (lastN == null || lastN.trim().equals("")) {
                        textArea.append("Last Name missing\n");
                        return;
                    }
                    if (andrewId == null || andrewId.trim().equals("")) {
                        textArea.append("Andrew ID missing\n");
                        return;
                    }
                    if (phoneN == null || phoneN.trim().equals("")) {
                        phoneN = "";
                    }
                    if (s.searchByAndrewId(andrewId) != null) {
                        textArea.append("Data already contains an "
                                + "entry for this Andrew ID\n");
                        return;
                    }
                    textArea.append("\n");
                    ab = new Student(andrewId);
                    ab.setFirstName(firstN);
                    ab.setLastName(lastN);
                    ab.setPhoneNumber(phoneN);
                    s.addStudent(ab);
                    textArea.append("Student Successfully Added\n");
                    textArea.append(s.searchByAndrewId(andrewId).toString());
                    textArea.append("\n");
                    //clear field
                    field1.setText("");
                    field2.setText("");
                    field3.setText("");
                    field4.setText("");
                    return;
                }
                //event for delete button
                if (event.getSource() == deleteButton) {
                    if (andrewIdD == null || andrewIdD.trim().equals("")) {
                        textArea.append("Andrew ID missing\n");
                        return;
                    }
                    if (s.searchByAndrewId(andrewIdD) == null) {
                        textArea.append("No Matches - Please Check AndrewID\n");
                        textArea.append(andrewIdD);
                        textArea.append("\n");
                        return;
                    }
                    textArea.append("\n");
                    textArea.append("Match - Student Successfully Deleted\n");
                    textArea.append(s.searchByAndrewId(andrewIdD).toString());
                    textArea.append("\n");
                    s.deleteStudent(andrewIdD);
                    field5.setText("");
                    return;
                }
                //event for searchID button
                if (event.getSource() == searchID) {
                    if (search == null || search.trim().equals("")) {
                        textArea.append("Andrew ID missing\n");
                        return;
                    }
                    if (s.searchByAndrewId(search) == null) {
                        textArea.append("No Matches - Please Check AndrewID\n");
                        textArea.append(search);
                        textArea.append("\n");
                        return;
                    }
                    textArea.append("\n");
                    textArea.append("Match - Student Successfully Found\n");
                    textArea.append(s.searchByAndrewId(search).toString());
                    textArea.append("\n");
                    field6.setText("");
                }
                //event for searchFirst name button.
                if (event.getSource() == searchFirst) {
                    if (search == null || search.trim().equals("")) {
                        textArea.append("First Name missing\n");
                        return;
                    }
                    if (s.searchByFirstName(search).isEmpty()) {
                        textArea.append("No Matches - "
                                + "Please Check Frist Name\n");
                        textArea.append(search);
                        textArea.append("\n");
                        return;
                    }
                    textArea.append("\n");
                    textArea.append("Match - Student Successfully Found\n");
                    //print student has the same first name in a list
                    List<Student> sameFirst = s.searchByFirstName(search);
                    for (Student sd : sameFirst) {
                        textArea.append(sd.toString());
                        textArea.append("\n");
                    }
                    textArea.append("\n");
                    field6.setText("");
                }
                //event for search last button
                if (event.getSource() == searchLast) {
                    if (search == null || search.trim().equals("")) {
                        textArea.append("Last Name missing\n");
                        return;
                    }
                    if (s.searchByLastName(search).isEmpty()) {
                        textArea.append("No Matches - Please "
                                + "Check Last Name\n");
                        textArea.append(search);
                        textArea.append("\n");
                        return;
                    }
                    textArea.append("\n");
                    textArea.append("Match - Student Successfully Found\n");
                    List<Student> sameLast = s.searchByLastName(search);
                    for (Student st : sameLast) {
                        textArea.append(st.toString());
                        textArea.append("\n");
                    }
                    textArea.append("\n");
                    field6.setText("");
                }
            }
        }
        /**
         * Key listener for incident.
         * @author Xi Chen
         *
         */
        private class MykeyListener implements KeyListener{
            //cannot put in here
            //String search = field6.getText();
            @Override
            public void keyPressed(KeyEvent event2) {
                String search = field6.getText();
                if (event2.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (search == null || search.trim().equals("")) {
                        textArea.append("Andrew ID missing\n");
                        return;
                    }
                    if (s.searchByAndrewId(search) == null) {
                        textArea.append("No Matches - Please Check AndrewID\n");
                        textArea.append(search);
                        textArea.append("\n");
                        return;
                    }
                    textArea.append("\n");
                    textArea.append("Match - Student Successfully Found\n");
                    textArea.append(s.searchByAndrewId(search).toString());
                    textArea.append("\n");
                    field6.setText("");
                }
            }
            @Override
            public void keyReleased(KeyEvent event2) {
            }
            @Override
            public void keyTyped(KeyEvent event2) {
            }
        }
    /**
     * A simplified version of CSV Reader.
     *
     * Subclass of a BufferedReader to handle a character stream that consists
     * comma separated values (CSVs)
     *
     * Provides an additional instance method, readCSVLine(), that parses line
     * substrings. The substrings are separated by comma in the original input
     * stream. The readCSVLine() method returns an array of references to String
     * The Strings are the values from the line that were separated by commas.
     * if value was surrounded by quotes, the quotes are removed.
     *
     * LimitationsSpaces before or after the comma are not removed. In the first
     * and last quote are removed from a value. Embedding commas in a quoted
     * is not handled properly. (In this case, the comma will separate the value
     * and the quotes will not be removed from the ends of those values.
     *
     * @author Jeffrey Eppinger (jle@cs.cmu.com)
     * Date: October 2, 2007
     */
    public static class CSVReader extends BufferedReader {
        /**
         * Initializes the class.
         * @param in the reader from which to read CSV lines
         */
        public CSVReader(Reader in) {
            super(in);
        }
    /**
     * This is the only additional method. It uses readLine from the superclass
     * to get a line but returns the comma separated values as in an array of
     * strings.
     * @return add the student information to the app
     * @throws IOException throws IOException
     */
    public String[] readCSVLine() throws IOException {

        // Get a line by calling the superclass's readLine method
        String line = super.readLine();

        // If we're at the end of the file, readLine returns null
        // so we return null.
        if (line == null) {
            return null;
        }

        // Count up the number of commas
        int commaCount = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ',') {
                commaCount = commaCount + 1;
            }
        }

        // Allocate an array of the necessary size to return the strings
        String[] values = new String[commaCount + 1];

        // In a loop, set beginIndex and endIndex to the start and end
        // positions of each argment and then use the substring method
        // to create strings for each of the comma separate values

        // Start beginIndex at the beginning of the String, position 0
        int beginIndex = 0;

        for (int i = 0; i < commaCount; i++) {
            // set endIndex to the position of the (next) comma
            int endIndex = line.indexOf(',', beginIndex);

            // if the argument begins and ends with quotes, remove them
            if (line.charAt(beginIndex) == '"'
                    && line.charAt(endIndex - 1) == '"') {

                // If we made it here, we have quotes around our string.
                // Add/substract one from the start/end of the args
                // to substring to get the value. (See else comment
                // below for details on how this works.)
                values[i] = line.substring(beginIndex + 1, endIndex - 1);

            } else {
                // If we name it here, we don't have quotes around
                // our string. Take the substring of this line
                // from the beginIndex to the endIndex. The substring
                // method called on a String will return the portion
                // of the String starting with the beginIndex and up
                // to but not including the endIndex.
                values[i] = line.substring(beginIndex, endIndex);
            }

            // Set beginIndex to the position character after the
            // comma. (Remember, endIndex was set to the position
            // of the comma.)
            beginIndex = endIndex + 1;
        }

        // handle the value that's after the last comma
        if (line.charAt(beginIndex) == '"'
                && line.charAt(line.length() - 1) == '"') {
            values[commaCount] =
                    line.substring(beginIndex + 1, line.length() - 1);
        } else {
            values[commaCount] = line.substring(beginIndex, line.length());
        }

        return values;
    }
    }
    /**
     * Import file in to app.
     * @param args the file input
     * @throws FileNotFoundException Not found file
     * @throws IOException Cannot read
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        DirectoryDriver nnn = new DirectoryDriver();
        // if blank, should not exit.
        if (args.length != 1) {
            nnn.field6.requestFocusInWindow();
            return;
        }
        //if file exist

        FileReader fr = new FileReader(args[0]);
        CSVReader c = new CSVReader(fr);
        //create new Directory for the app
        //
        int lineNum = 0;
        boolean eof = false;

        while (!eof) {
            String[] values = c.readCSVLine();
            if (values == null) {
                eof = true;
            } else {
                lineNum = lineNum + 1;
                //
                //add student from the csv file
                Student gg = new Student(values[2]);
                gg.setFirstName(values[0]);
                gg.setLastName(values[1]);
                gg.setPhoneNumber(values[3]);
                nnn.s.addStudent(gg);
                //focus on field6.
                nnn.field6.requestFocusInWindow();
                //loading information
/*              nnn.textArea.append("New Student Loaded From CSV\n");
                nnn.textArea.append(gg.toString());
                nnn.textArea.append("\n");*/

/*                for (int i = 0; i < values.length; i++) {
                    System.out.print(" \"" + values[i] + "\"");
                }

                System.out.println();*/
            }
        }
        c.close();
        }
}

