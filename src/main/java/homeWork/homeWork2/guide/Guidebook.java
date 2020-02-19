package homeWork.homeWork2.guide;


import homeWork.homeWork2.panel.FileManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.nio.file.*;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;


public class Guidebook extends ArrayList {
    private FileManager fileManager;
    private ArrayList<Path> eventHistory = new ArrayList<>();
    private int step = 0;
    private int upperBound = 0;

    public Guidebook(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    public Object[][] showDisks() {
        if (File.listRoots().length != 0) {
            Object[][] arrObj = new Object[File.listRoots().length][4];
            for (int i = 0; i < arrObj.length; i++) {
                arrObj[i][0] = File.listRoots()[i];
                try {
                    arrObj[i][1] = new SimpleDateFormat("dd.MM.yyyy").format(new Date(Files.getLastModifiedTime(Paths.get(File.listRoots()[i].toURI())).toMillis()));
                } catch (IOException e) {
                    return null;
                }
                arrObj[i][2] = "Локальний диск";
                arrObj[i][3] = Math.round(File.listRoots()[i].getFreeSpace() / Math.pow(1024, 3)) + " свободно из " + Math.round(File.listRoots()[i].getTotalSpace() / Math.pow(1024, 3)) + " ГБ";
            }
            return arrObj;
        }
        return null;
    }

    //Метод для вывода локальных дискок
    public void listRoots() {
        DefaultTableModel model = (DefaultTableModel) fileManager.getjTable1().getModel();
        Object[] listRoots = File.listRoots();
        removeRow(fileManager.getjTable1());
        for (int i = 0; i < listRoots.length; i++) {
            try {
                model.addRow(new Object[]{File.listRoots()[i], new SimpleDateFormat("dd.MM.yyyy").format(new Date(Files.getLastModifiedTime(Paths.get(File.listRoots()[i].toURI())).toMillis())), "Локальний диск", Math.round(File.listRoots()[i].getFreeSpace() / Math.pow(1024, 3)) + " свободно из " + Math.round(File.listRoots()[i].getTotalSpace() / Math.pow(1024, 3)) + " ГБ"});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        fileManager.getjTextField1().setText("");
    }

    //Метод для вывода содержимого каталога или открывает файл
    public void listDirFile(Path url) {
        DefaultTableModel model = (DefaultTableModel) fileManager.getjTable1().getModel();
        try {
            if (Files.isDirectory(url)) {
                fileManager.getjTextField1().setText(url.toString());
                eventHistory.add(Paths.get(fileManager.getjTextField1().getText()));
                Object[] listFile = Files.list(Paths.get(fileManager.getjTextField1().getText())).sorted((v1, v2) -> Files.isDirectory(v1) && !Files.isDirectory(v2) ? -1 : 1).toArray();
                removeRow(fileManager.getjTable1());
                for (int i = 0; i < listFile.length; i++) {
                    Path pathsFile = Paths.get(listFile[i].toString());
                    if (Files.isDirectory(pathsFile)) {
                        model.addRow(new Object[]{pathsFile.getFileName(), new SimpleDateFormat("dd.MM.yyyy").format(new Date(Files.getLastModifiedTime(pathsFile).toMillis())), "Папка с файлами"});
                    } else {
                        try {
                            model.addRow(new Object[]{pathsFile.getFileName(), new SimpleDateFormat("dd.MM.yyyy").format(new Date(Files.getLastModifiedTime(pathsFile).toMillis())), pathsFile.toString().substring(pathsFile.toString().lastIndexOf('.') + 1), Files.size(pathsFile) / 1024 < 1 ? 1 + " КБ" : Math.round(Files.size(pathsFile) / 1024) + " КБ"});
                        } catch (AccessDeniedException ex) {
                            continue;
                        }

                    }
                }
            }
            if (Files.isRegularFile(url)) {
                new Thread(() -> {
                    JFrame frame2 = new JFrame();
                    JLabel jLabel = new JLabel();
                    JTextField textField = new JTextField();
                    frame2.setSize(600, 600);
                    frame2.setVisible(true);
                    String s = null;
                    try {
                        s = Files.probeContentType(url);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    if (s != null && s.substring(0, s.indexOf('/')).equals("image")) {
                        jLabel.setIcon(new ImageIcon(url.toString()));
                        frame2.add(jLabel);
                    } else {
                        try {
                            frame2.add(textField);
                            textField.read(Files.newBufferedReader(url.toAbsolutePath()), null);

                            while (frame2.isVisible()){System.out.toString();}
                            textField.write(Files.newBufferedWriter(url.toAbsolutePath()));
                        } catch (IOException e) {
                        }
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void removeRow(JTable jTable) {
        while (jTable.getRowCount() > 0) {
            ((DefaultTableModel) jTable.getModel()).removeRow(0);
        }
    }

    public void stepUp() {
        if (step < upperBound)
            listDirFile(eventHistory.get(++step));
        while (eventHistory.size()-1 != upperBound)
            eventHistory.remove(upperBound+1);
    }

    public void stepDown() {
        if (upperBound == 0) {
            upperBound = eventHistory.size()-1;
            step = eventHistory.size()-1;
        }
        if (step > 0)
        listDirFile(eventHistory.get(--step));
        while (eventHistory.size()-1 != upperBound)
            eventHistory.remove(upperBound+1);

    }


    public InputStream copyFile(Path path) {
        if (path == null) {
            try {
                return Files.newInputStream(path);
            } catch (IOException e) {
                e.printStackTrace();

            }

        }
        return null;
    }




    public static void copyDirectory(File src, File dst) {
        try {
            if (src.isDirectory()) {
                if (!dst.exists()) {
                    dst.mkdir();
                }
                String files[] = src.list();
                for (String file : files) {
                    File srcFile = new File(src, file);
                    File dstFile = new File(dst, file);
                    copyDirectory(srcFile, dstFile);
                }
            } else {
                InputStream in = new FileInputStream(src);
                OutputStream out = new FileOutputStream(dst);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = in.read(buffer)) > 0) {
                    out.write(buffer, 0, length);
                }
                in.close();
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Path path) throws IOException {
        if (!Files.exists(path))
            return;
        if (Files.isDirectory(path)) {
            for (Path f : Files.newDirectoryStream(path)) {
                delete(f);
            }
        }
        Files.delete(path);
    }
    public int getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(int upperBound) {
        this.upperBound = upperBound;
    }

    public void setStep(int step) {
        this.step = step;
    }
}





