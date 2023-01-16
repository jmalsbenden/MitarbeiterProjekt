package Verwaltung;

import mitarbeiter.Buerohengst;
import mitarbeiter.Malocher;
import mitarbeiter.Manager;
import mitarbeiter.Mitarbeiter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Verwaltung_GUI {

    public JPanel newMitarbeiter = new JPanel();
    Popup p;
    Unternehmensverwaltung unternehmensverwaltung = new Unternehmensverwaltung();
    int bueroID = 5100;
    int managerID = 5000;
    int malocherID = 3000;
    JTable mitarbeiterTable = null;

    public void init(){
        JFrame frame = new JFrame("Verwaltung");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1400,900);

        setNavBar(frame);

        setAbteilungsBar(frame);

        setCenter(frame);

        setNewMitarbeiter();

        frame.setVisible(true);
    }


    public void setNewMitarbeiter(){
        GridBagConstraints gbc = new GridBagConstraints();
        GridBagLayout layoutAbteilung = new GridBagLayout();
        newMitarbeiter.setLayout(layoutAbteilung);

        JButton exitBtnPop = new JButton("Zurück");
        gbc.gridy = 0;
        gbc.gridx = 7;
        newMitarbeiter.add(exitBtnPop, gbc);

        JLabel nameL = new JLabel("Name:");
        gbc.gridy = 1;
        gbc.gridx = 0;
        newMitarbeiter.add(nameL, gbc);

        JTextField nameF = new JTextField("");
        nameF.setMinimumSize(new Dimension(80, 25));
        nameF.setPreferredSize(new Dimension(80, 25));
        gbc.gridy = 1;
        gbc.gridx = 1;
        newMitarbeiter.add(nameF, gbc);

        JLabel positionL = new JLabel("Position:");
        gbc.gridy = 2;
        gbc.gridx = 0;
        newMitarbeiter.add(positionL, gbc);

        JComboBox<String> positionF = new JComboBox<>();
        positionF.addItem("Malocher");
        positionF.addItem("Buerohengst");
        positionF.addItem("Manager");
        positionF.setMinimumSize(new Dimension(80, 25));
        positionF.setPreferredSize(new Dimension(80, 25));
        gbc.gridy = 2;
        gbc.gridx = 1;
        newMitarbeiter.add(positionF, gbc);

        JLabel gehaltL = new JLabel("Gehalt:");
        gbc.gridy = 3;
        gbc.gridx = 0;
        newMitarbeiter.add(gehaltL, gbc);

        JTextField gehaltF = new JTextField("");
        gehaltF.setMinimumSize(new Dimension(80, 25));
        gehaltF.setPreferredSize(new Dimension(80, 25));
        gbc.gridy = 3;
        gbc.gridx = 1;
        newMitarbeiter.add(gehaltF, gbc);

        JLabel bonusL = new JLabel("Bonus:");
        gbc.gridy = 4;
        gbc.gridx = 0;
        newMitarbeiter.add(bonusL, gbc);

        JTextField bonusF = new JTextField("");
        bonusF.setMinimumSize(new Dimension(80, 25));
        bonusF.setPreferredSize(new Dimension(80, 25));
        gbc.gridy = 4;
        gbc.gridx = 1;
        newMitarbeiter.add(bonusF, gbc);

        JButton erstellenBtn = new JButton("Erstellen");
        gbc.gridy = 5;
        gbc.gridx = 2;
        newMitarbeiter.add(erstellenBtn, gbc);

        exitBtnPop.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                p.hide();
            }
        });

        erstellenBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mitarbeiterErstllen(nameF.getText(), gehaltF.getText(), positionF.getSelectedItem().toString(), bonusF.getText());
                p.hide();
            }
        });
    }

    public void mitarbeiterErstllen(String name, String gehalt, String klasse, String bonus){
        Mitarbeiter m = null;
        switch (klasse){
            case "Buerohengst":
                m = new Buerohengst(bueroID,name, Integer.parseInt(gehalt));
                bueroID++;
                break;
            case "Malocher":
                m = new Malocher(malocherID,name, Integer.parseInt(gehalt));
                malocherID++;
                break;
            case "Manager":
                m = new Manager(managerID,name, Integer.parseInt(gehalt), Integer.parseInt(bonus));
                managerID++;
                break;
        }
        if(m != null){
            unternehmensverwaltung.add(m);

            //TableModel model = new TableModel(fillMitarbeiterTabelle(unternehmensverwaltung.getMitarbeiterList()));
            //mitarbeiterTable.setModel(model);
        }


    }

    public void setNavBar(JFrame frame){
        JPanel menuBar = new JPanel();

        JButton exitBtn = new JButton("Zurück");
        menuBar.add(exitBtn);

        JButton neuBtn = new JButton("Neu");
        menuBar.add(neuBtn);

        neuBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                PopupFactory pf = new PopupFactory();
                p = pf.getPopup(frame, newMitarbeiter, 180,120);
                //setNewMitarbeiter(p);
                //String string = JOptionPane.showInputDialog(frame, "Name", null);
                p.show();
            }
        });

        JButton deleteBtn = new JButton("Löschen");
        menuBar.add(deleteBtn);

        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
    }

    public void setAbteilungsBar(JFrame frame){
        GridBagConstraints gbc = new GridBagConstraints();

        JPanel abteilungsBar = new JPanel();
        abteilungsBar.setBackground(Color.DARK_GRAY);
        abteilungsBar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagLayout layoutAbteilung = new GridBagLayout();
        abteilungsBar.setLayout(layoutAbteilung);

        //suche
        JTextField suchFeld = new JTextField("");
        suchFeld.setMinimumSize(new Dimension(80, 25));
        suchFeld.setPreferredSize(new Dimension(80, 25));
        gbc.gridx = 0;
        gbc.gridy = 0;
        abteilungsBar.add(suchFeld, gbc);

        JButton suchBtn = new JButton("Suchen");
        gbc.gridx = 1;
        gbc.gridy = 0;
        abteilungsBar.add(suchBtn, gbc);

        //Liste
        String mitarbeiter[] = {"Abteilung1","Abteilung1","Abteilung1","Abteilung1","Abteilung1","Abteilung1","Abteilung1","Abteilung1","Abteilung1","Abteilung1","Abteilung1","Abteilung1","Abteilung1","Abteilung1","Abteilung1",};
        JList abteilungsList = new JList(mitarbeiter);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        //gbc.gridheight = 700;
        abteilungsBar.add(abteilungsList, gbc);

        frame.getContentPane().add(BorderLayout.WEST, abteilungsBar);
    }


    public void setCenter(JFrame frame){

        JPanel mitte = new JPanel();
        mitte.setBackground(Color.LIGHT_GRAY);
        mitte.setLayout(new BorderLayout());
        mitte.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        //Überscrhift
        JLabel AbteilungsUebersicht = new JLabel("Abteilungs Übersicht");
        AbteilungsUebersicht.setFont(AbteilungsUebersicht.getFont().deriveFont(Font.BOLD,30));
        mitte.add(BorderLayout.NORTH, AbteilungsUebersicht);

        //AbteilungsListeÜbersicht

        Mitarbeiter m1 = new Buerohengst(5001, "Jeff", 3245);
        Mitarbeiter m2 = new Buerohengst(5002, "Toto", 12);
        Mitarbeiter m3 = new Buerohengst(5003, "Pierre", 64);
        Mitarbeiter m4 = new Buerohengst(5004, "Michi", 65);

        unternehmensverwaltung.add(m1);
        unternehmensverwaltung.add(m2);
        unternehmensverwaltung.add(m3);
        unternehmensverwaltung.add(m4);

        // Data to be displayed in the JTable

        String[][] data = fillMitarbeiterTabelle(unternehmensverwaltung.getMitarbeiterList());

        // Column Names
        String[] columnNames = { "ID", "Name", "Rolle", "Einkommen" };

        // Initializing the JTable
        mitarbeiterTable = new JTable(data, columnNames);
        //mitarbeiterTable.setBounds(30, 40, 200, 300);
        mitarbeiterTable.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        mitte.add(BorderLayout.CENTER, mitarbeiterTable);





        frame.getContentPane().add(BorderLayout.CENTER, mitte);
    }

    public String[][] fillMitarbeiterTabelle(List<Mitarbeiter> list){
        String[][] data = new String[12][4];

        int index = 0;
        for (Mitarbeiter m :list) {
            data[index][0] = String.valueOf(m.getId());
            data[index][1] = m.getName();
            data[index][2] = String.valueOf(m.getClass());
            data[index][3] = String.valueOf(m.getEinkommen());
            index++;
        }
        return data;
    }
}
