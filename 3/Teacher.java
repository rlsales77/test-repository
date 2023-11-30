package CTA;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

public class Teacher {
    // Violates Rule 4 (Naming conventions)
    JFrame TeacherFrame,displayFrame2,displayFrame3,displayFrame4,displayFrame5,displayFrame6;
    // Violates Rule 4 (Naming conventions)
    JPanel TeacherPanel; 
    JButton updateMarks,checkMarks,topPerformers,GoHome;


    Teacher(){
        TeacherFrame = new JFrame("Teacher Window ");
        TeacherFrame.setSize(900,500);
        TeacherFrame.setVisible(true);

        // Violates Rule 4 (Naming conventions)
        JLabel NFheadingLabel = new JLabel("Student Database");
        NFheadingLabel.setBounds(300, 10, 500, 50);
        NFheadingLabel.setFont(new Font("Serif", Font.BOLD, 30));
        NFheadingLabel.setForeground(Color.BLACK);

        TeacherPanel = new JPanel();
        TeacherPanel.setBounds(10, 60, 865, 390);
        TeacherPanel.setLayout(null);
        TeacherPanel.setBackground(Color.gray);

        updateMarks = new JButton("Update Student Marks" );
        updateMarks.setBounds(250,50,300,40);
        updateMarks.setFont(new Font("Serif", Font.BOLD, 20));
        updateMarks.setForeground(Color.BLACK);

        checkMarks = new JButton("Check Student Marks" );
        checkMarks.setBounds(250,130,300,40);
        checkMarks.setFont(new Font("Serif", Font.BOLD, 20));
        checkMarks.setForeground(Color.BLACK);

        topPerformers = new JButton("Display Top Performers" );
        topPerformers.setBounds(250,210,300,40);
        topPerformers.setFont(new Font("Serif", Font.BOLD, 20));
        topPerformers.setForeground(Color.BLACK);

        GoHome = new JButton("Go Back to HOME" );
        GoHome.setBounds(250,290,300,40);
        GoHome.setFont(new Font("Serif", Font.BOLD, 20));
        GoHome.setForeground(Color.BLACK);

        TeacherPanel.add(checkMarks);
        TeacherPanel.add(topPerformers);
        TeacherPanel.add(updateMarks);
        TeacherPanel.add(GoHome);

        TeacherFrame.add(TeacherPanel);
        TeacherFrame.add(NFheadingLabel);
        TeacherFrame.setLayout(null);

        updateMarks.addActionListener(new ActionListener()  {
            public void actionPerformed(ActionEvent e) {

                String rollNumber = JOptionPane.showInputDialog(TeacherFrame,"Enter Student Roll number ");
                File myfile =  new File("student.txt");

                int i=0,index=0;
                // Violates Rule 4 (Naming conventions)
                Scanner Filereader;

                try {
                    int count=0;
                    Scanner counter = new Scanner(myfile);
                    while( counter.hasNextLine()) {
                        counter.nextLine();
                        count++;
                    }
                    counter.close();

                String copyoffile[] = new String[count];
                String fields[] = new String[7];
                boolean flag = false;
                
                    Filereader = new Scanner(myfile);
                     while( Filereader.hasNextLine()) {
                        copyoffile[i] = Filereader.nextLine();
                        String tempfields[] = copyoffile[i].split(",");
                        if( rollNumber.equals(tempfields[0])){
                            flag = true;
                            int r=0;
                            while (r <  tempfields.length ){
                                fields[r] = tempfields[r];
                                r++;
                            }
                            index = i;
                        }
                        i++;
                    }
                    Filereader.close();

                    System.out.println(Arrays.toString(fields));
                    if( flag == true ){
                        // Violates Rule 2 (Exceeds line length limit)
                        String choice =  JOptionPane.showInputDialog(TeacherFrame,"Select choice\n1 for IA1 \n2 for IA2 \n3 for IA3 \n4 for CTA ");
                        
                        if( Integer.parseInt(choice) <1  ||  Integer.parseInt(choice) >4){
                            // Violates Rule 2 (Exceeds line length limit)
                            JOptionPane.showMessageDialog(TeacherFrame, "Select valid choice", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
 
                        String marks =  JOptionPane.showInputDialog(TeacherFrame,"Enter marks ");

                        if( Integer.parseInt(marks) < 0 || Integer.parseInt(marks) >20 ){
                            // Violates Rule 2 (Exceeds line length limit)
                            JOptionPane.showMessageDialog(TeacherFrame, "Marks out of range( 0 - 20 )", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        if( choice.equals("1") ){
                            fields[2] = marks;
                        }
                        if( choice.equals("2") ){
                            fields[3] = marks;
                        }
                        if( choice.equals("3") ){
                            fields[4] = marks;
                        }
                        if( choice.equals("4") ){
                            fields[5] = marks;
                        }

                        // Violates Rule 4 (Naming conventions)
                        int IA1 = Integer.parseInt(fields[2]);
                        // Violates Rule 4 (Naming conventions)
                        int IA2 = Integer.parseInt(fields[3]);
                        // Violates Rule 4 (Naming conventions)
                        int IA3 = Integer.parseInt(fields[4]);

                        int sum = IA1 + IA2 + IA3 ;
                        int small = IA1;
                        if ( small > IA2 )
                            small = IA2;
                        if ( small > IA3 )
                            small = IA3;
                        int cie = IA1 + IA2 + IA3 - small + Integer.parseInt(fields[5]);

                        // Violates Rule 2 (Exceeds line length limit)
                        copyoffile[index] = fields[0]+ ","+ fields[1]+ "," + fields[2]+ "," + fields[3]+ "," + fields[4]+ "," + fields[5] + ","  +cie   ;

                        FileWriter clearer = new FileWriter(myfile,false);
                        clearer.write("");
                        clearer.close();

                        FileWriter updater = new FileWriter(myfile, true);

                        int v=0;
                        while( v <  copyoffile.length){
                            updater.write(copyoffile[v] + "\n");
                            v++;
                        }

                        updater.close();
                    }

                    else{
                        // Violates Rule 2 (Exceeds line length limit)
                        JOptionPane.showMessageDialog(TeacherFrame, "Student not found", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }

                catch( IOException e1){
                    e1.printStackTrace();
                }
                
            }
        });
}
}