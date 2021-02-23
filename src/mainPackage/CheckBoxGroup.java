package mainPackage;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CheckBoxGroup extends Frame {
    public CheckBoxGroup(String title, int width, int height) {
        this.setTitle(title);
        this.setSize(width,height);
    }
    public void addBox(String title,int x,int y)
    {
        customCheckBox box = new customCheckBox(title,x,y);
        box.addField(this);


    }
    private class customCheckBox
    {
        int x = 0;int y = 0;
        Label label;
        Checkbox checkbox;
        String title;
        public customCheckBox(String title,int x,int y)
        {
            this.title = title;
            this.x = x;
            this.y = y;
        }
        public void addField(Frame f)
        {
            checkbox = new Checkbox();
            label = new Label();
            checkbox.setLabel(title);
            label.setText(title);
            checkbox.setBounds(x,y,100,50);
            label.setBounds(110+x,y,200,50);
            label.setForeground(Color.BLACK);
            checkbox.setForeground(Color.BLACK);
            f.add(checkbox);
            f.add(label);
            label.setText(title + " unselected");
            checkbox.addItemListener(
                    new ItemListener() {
                        @Override
                        public void itemStateChanged(ItemEvent e) {
                            if(e.getStateChange() == 1)
                            {
                                label.setText(title + " selected");
                            }
                            else
                            {
                                label.setText(title + " unselected");
                            }
                        }
                    }
            );

        }
    }
}

class CheckBoxMainClass {
    public static void main(String[] args) {
        CheckBoxGroup group = new CheckBoxGroup("Student",500,500);
        group.setVisible(true);
        String[] fields = {"Name","Enrollment","branch","subject"};
        int x = 50;
        int y = 50;
       for(String field:fields)
       {
           group.addBox(field,x,y);
           y+=70;
       }

        group.addWindowListener(
                new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                }
        );
    }
}
