package homeWork.homeWork2.panel;


import homeWork.homeWork2.guide.Guidebook;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

import java.util.Date;


public class FileManager extends javax.swing.JFrame {
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private JFrame jFrame1;

    private Guidebook guidebook;
    String copyURL;
    String nameFile;


    public FileManager() {
        initComponents();
    }

    private void initComponents() {
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        guidebook = new Guidebook(this);
        jFrame1 = new JFrame();
        jFrame1.setSize(80, 130);


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1100, 570));

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jButton1.setText("←");
        jButton1.addActionListener(evt -> guidebook.stepDown());

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jButton2.setText("→");
        jButton2.addActionListener(evt -> guidebook.stepUp());

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jButton3.setText("↑");

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, new String[]{"Имя", "Дата изменения", "Тип", "Размер"}) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setFocusCycleRoot(true);
        jTable1.setFocusable(false);
        jTable1.setShowGrid(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(10);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(250);
            jTable1.getColumnModel().getColumn(1).setMinWidth(10);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(250);
            jTable1.getColumnModel().getColumn(2).setMinWidth(10);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(250);
            jTable1.getColumnModel().getColumn(3).setMinWidth(10);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(250);
        }
        jTable1.getAccessibleContext().setAccessibleDescription("");

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Path url = Paths.get(jTextField1.getText() + (jTextField1.getText().equals("") ? "" : FileSystems.getDefault().getSeparator()) + (jTable1.getSelectedRow() == -1 ? "" : jTable1.getValueAt(jTable1.getSelectedRow(), 0)));
                if (evt.getClickCount() == 2 && evt.getButton() == MouseEvent.BUTTON1) {
                    guidebook.listDirFile(url);
                }
                if (evt.getButton() == MouseEvent.BUTTON3) {
                    JList list = new JList();
                    list.setSize(80, 130);
                    list.setModel(new javax.swing.AbstractListModel<String>() {
                        String[] strings = {"Копировать", "Вставить", "Удалить", "Создать папку"};

                        public int getSize() {
                            return strings.length;
                        }

                        public String getElementAt(int i) {
                            return strings[i];
                        }
                    });
                    jFrame1.add(list);
                    jFrame1.setVisible(true);
                    list.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent e) {{
                                switch ((String) list.getSelectedValue()) {
                                    case "Копировать":
                                        if (jTable1.getSelectedRow() != -1 && jTable1.getValueAt(jTable1.getSelectedRow(), 0) != null) {
                                            copyURL = url.toString();
                                            nameFile = url.getFileName().toString();
                                            jFrame1.setVisible(false);
                                            break;
                                        }
                                    case "Вставить":
                                        if (Files.isDirectory(Paths.get(copyURL))) {
                                            guidebook.copyDirectory(new File(copyURL), new File(jTextField1.getText() + FileSystems.getDefault().getSeparator() + nameFile));
                                        } else {
                                            try {
                                                Files.copy(Paths.get(copyURL), Paths.get(jTextField1.getText() + FileSystems.getDefault().getSeparator() + nameFile));
                                            } catch (IOException ex) {
                                            }finally {
                                                guidebook.listDirFile(Paths.get(jTextField1.getText()));
                                                jFrame1.setVisible(false);
                                                break;
                                            }
                                        }

                                    case "Удалить":
                                        try {
                                            if (jTable1.getSelectedRow() != -1 && jTable1.getValueAt(jTable1.getSelectedRow(), 0) != null) {
                                                while (Files.exists(url)) {
                                                    guidebook.delete(url);
                                                }
                                                jFrame1.setVisible(false);
                                                guidebook.listDirFile(Paths.get(jTextField1.getText()));
                                            }
                                        } catch (IOException ex) {
                                            ex.printStackTrace();
                                        }finally {
                                            jFrame1.setVisible(false);
                                            break;
                                        }
                                    case "Создать папку":
                                        int i = 0;
                                        Path paths = Paths.get(jTextField1.getText() + FileSystems.getDefault().getSeparator() + "Новая пака" + (i == 0 ? "" : 1));

                                        while (Files.exists(paths)) {
                                            paths = Paths.get(jTextField1.getText() + FileSystems.getDefault().getSeparator() + "Новая пака " + i++);
                                        }
                                        try {
                                            Files.createDirectories(paths);
                                            guidebook.listDirFile(Paths.get(jTextField1.getText()));
                                            jFrame1.setVisible(false);
                                        } catch (IOException ex) {
                                            ex.printStackTrace();
                                            jFrame1.setVisible(false);
                                        }finally {
                                            jFrame1.setVisible(false);
                                            break;
                                        }
                                }
                            }
                            jFrame1.remove(list);
                        }
                    });
                }
            }
        });

        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 5));
        jButton4.setIcon(new javax.swing.ImageIcon("src/main/java/homeWork/homeWork2/images/cirularArrow.png"));
        jButton4.addActionListener(evt -> {
            if (jTextField1.getText().equals(""))
                return;
            else
                guidebook.listDirFile(Paths.get(jTextField1.getText()));
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        new Object[]{"Этот компьютер"},
                        new Object[]{"Робочий стол"},
                },
                new String[]{
                        "Быстрый доступ"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jTable2.setGridColor(new java.awt.Color(255, 255, 255));
        jTable2.setName("");
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(133);
        }
        guidebook.listRoots();

        jTextField2.setFont(new java.awt.Font("Times New Roman", 0, 10));

        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    if (jTable2.getSelectedRow() != -1) {
                        if (jTable2.getValueAt(0, 0).toString().equals(jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString()))
                            guidebook.listRoots();
                        else if (jTable2.getValueAt(1, 0).toString().equals(jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString()))
                            guidebook.listDirFile(Paths.get("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop"));
                    } else {
                        return;
                    }
                }
            }
        });


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(4, 4, 4)
                                                .addComponent(jButton3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 928, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                                        .addComponent(jScrollPane2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();


    }


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        if (Paths.get(jTextField1.getText()).getParent() == null) {
            guidebook.listRoots();
        } else {
            jTextField1.setText(Paths.get(jTextField1.getText()).getParent().toString());
            guidebook.listDirFile(Paths.get(jTextField1.getText()));
        }
    }


    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {

    }

    public JTable getjTable1() {
        return jTable1;
    }

    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }

    public JTable getjTable2() {
        return jTable2;
    }

    public void setjTable2(JTable jTable2) {
        this.jTable2 = jTable2;
    }

    public JTextField getjTextField1() {
        return jTextField1;
    }

    public void setjTextField1(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
    }

    public JTextField getjTextField2() {
        return jTextField2;
    }

    public void setjTextField2(JTextField jTextField2) {
        this.jTextField2 = jTextField2;
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FileManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FileManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FileManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FileManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new FileManager().setVisible(true));
    }
}


