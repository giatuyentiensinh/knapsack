package main;

import com.oy.shared.lm.graph.Graph;
import com.oy.shared.lm.graph.GraphEdge;
import com.oy.shared.lm.graph.GraphFactory;
import com.oy.shared.lm.graph.GraphNode;
import com.oy.shared.lm.out.GRAPHtoDOTtoGIF;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.MouseInputAdapter;

public class BTToiuuBaiToanCaiTui extends javax.swing.JFrame {

    private int[] a, c, xopt, x, index;
    private int weight, w, cost, n, fopt;
    private Graph g = GraphFactory.newGraph();
    private GraphNode[] gn;
    private GraphNode after = g.addNode();
    private final HandScroll hScroll = new HandScroll(new ImageIcon(getClass().getResource("ThuVien.jpg")));

    public BTToiuuBaiToanCaiTui() {
        initComponents();
        setLocationRelativeTo(this);
    }

    public void ConnectNode(GraphNode parent, GraphNode child, int i, String str, int j) {
        child = g.addNode();
        child.getInfo().setCaption(str.substring(0, str.indexOf("\n")));
        child.getInfo().setFooter(str.substring(str.indexOf("\n")));
        GraphEdge xy = g.addEdge(parent, child);
        xy.getInfo().setCaption("x(" + (i + 1) + ") = " + j);
        gn[i + 1] = child;
    }

    public void Try(int i) {
        int t = (int) (w - weight) / a[i];
        for (int j = t; j >= 0; j--) {
            x[i] = j;
            cost += c[i] * x[i];
            weight += a[i] * x[i];
            if (i != n - 1) {
                String str = "cost = " + cost + "\nw = " + (w - weight) + ", g = " + (cost + (float) (w - weight) * c[i + 1] / a[i + 1]);
                GraphNode child = null;
                ConnectNode(gn[i], child, i, str, x[i]);
            }
            if (i == n - 1) {
                if (cost > fopt) {
                    fopt = cost;
                    System.arraycopy(x, 0, xopt, 0, n);
                    String str = "xopt(";
                    for (int l = 0; l < n; l++) {
                        str += String.valueOf(xopt[l]);
                        if (l != n - 1) {
                            str += ",";
                        }
                    }
                    str += ")\nfopt = " + fopt;
                    ConnectNode(gn[n - 1], gn[n], i, str, x[i]);
                }
            } else if (cost + (w - weight) * c[i + 1] / a[i + 1] > fopt) {
                Try(i + 1);
            }
            cost -= c[i] * x[i];
            weight -= a[i] * x[i];
        }
    }

    public void writeTextF(JTextField tf, int[] arr) {
        String str = "";
        for (int i = 0; i < n; i++) {
            str += arr[i] + " ; ";
        }
        tf.setText(str.substring(0, str.lastIndexOf(";")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frame = new javax.swing.JFrame();
        DPanelAbout = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        taAbout = new javax.swing.JTextArea();
        lbAthor = new javax.swing.JLabel();
        lbTitle = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lbTitle1 = new javax.swing.JLabel();
        DpanelTool = new javax.swing.JDesktopPane();
        lbNum = new javax.swing.JLabel();
        btReset = new javax.swing.JButton();
        btStart = new javax.swing.JButton();
        tfNum = new javax.swing.JTextField();
        lbFopt = new javax.swing.JLabel();
        tfFopt = new javax.swing.JTextField();
        lbCost = new javax.swing.JLabel();
        tfCost = new javax.swing.JTextField();
        lbWeight = new javax.swing.JLabel();
        tfWeight = new javax.swing.JTextField();
        lbW = new javax.swing.JLabel();
        tfW = new javax.swing.JTextField();
        lbXopt = new javax.swing.JLabel();
        tfXopt = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        panel = new javax.swing.JPanel() {
            ImageIcon icon = new ImageIcon(getClass().getResource("url.png"));
            public void paintComponent(Graphics g) {
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        SPanel = new javax.swing.JScrollPane(hScroll);
        mnbar = new javax.swing.JMenuBar();
        mnFile = new javax.swing.JMenu();
        miAbout = new javax.swing.JMenuItem();
        miSave = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        miExit = new javax.swing.JMenuItem();
        mnEdit = new javax.swing.JMenu();
        miStart = new javax.swing.JMenuItem();
        miReset = new javax.swing.JMenuItem();

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.setTitle("About");
        frame.setBounds(new java.awt.Rectangle(350, 240, 461, 389));
        frame.setResizable(false);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                frameWindowClosing(evt);
            }
        });

        DPanelAbout.setBackground(new java.awt.Color(204, 204, 255));

        taAbout.setColumns(20);
        taAbout.setFont(new java.awt.Font("Monospaced", 2, 14)); // NOI18N
        taAbout.setLineWrap(true);
        taAbout.setRows(5);
        taAbout.setText("Một nhà thám hiểm cần đem theo một cái túi có trọng lượng không quá b. Có đồ vật có thể đem theo. Đồ vật thứ j có trọng lượng là aj và giá trị sử dụng là cj (j = 1, 2, 3 ..., n). Hỏi rằng nhà thám hiểm cần đem theo các đồ vật nào để cho tổng giá trị sử dụng của các đồ vật mang theo là lớn nhất ?\n");
        taAbout.setWrapStyleWord(true);
        taAbout.setEnabled(false);
        jScrollPane1.setViewportView(taAbout);

        lbAthor.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        lbAthor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAthor.setText("Nguyễn Gia Tuyến - Nguyễn Thị Thuỷ");

        lbTitle.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Thuật toán nhánh cận");

        lbTitle1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lbTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle1.setText("Bài toán cái túi");

        javax.swing.GroupLayout DPanelAboutLayout = new javax.swing.GroupLayout(DPanelAbout);
        DPanelAbout.setLayout(DPanelAboutLayout);
        DPanelAboutLayout.setHorizontalGroup(
            DPanelAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(DPanelAboutLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(lbTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 85, Short.MAX_VALUE))
            .addGroup(DPanelAboutLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DPanelAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbAthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jScrollPane1)
        );
        DPanelAboutLayout.setVerticalGroup(
            DPanelAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DPanelAboutLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lbTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbAthor)
                .addContainerGap())
        );
        DPanelAbout.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DPanelAbout.setLayer(lbAthor, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DPanelAbout.setLayer(lbTitle, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DPanelAbout.setLayer(jSeparator2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DPanelAbout.setLayer(lbTitle1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout frameLayout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(frameLayout);
        frameLayout.setHorizontalGroup(
            frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frameLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(DPanelAbout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        frameLayout.setVerticalGroup(
            frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DPanelAbout)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bài toán cái túi");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));

        DpanelTool.setBackground(new java.awt.Color(204, 255, 102));

        lbNum.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbNum.setText("Số lượng các đồ vật");

        btReset.setText("Reset");
        btReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btResetActionPerformed(evt);
            }
        });

        btStart.setText("Start");
        btStart.setEnabled(false);
        btStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btStartActionPerformed(evt);
            }
        });

        tfNum.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfNumKeyPressed(evt);
            }
        });

        lbFopt.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        lbFopt.setText("Giá trị tối ưu");

        tfFopt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tfFopt.setForeground(new java.awt.Color(255, 0, 0));
        tfFopt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfFopt.setEnabled(false);

        lbCost.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbCost.setText("Giá trị sử dụng của từng đồ vật");

        tfCost.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfCost.setEnabled(false);
        tfCost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfCostMouseClicked(evt);
            }
        });

        lbWeight.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbWeight.setText("Khối lượng của từng đồ vật");

        tfWeight.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfWeight.setEnabled(false);
        tfWeight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfWeightMouseClicked(evt);
            }
        });

        lbW.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbW.setText("Khối lượng của cái túi");

        tfW.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfW.setEnabled(false);
        tfW.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfWKeyPressed(evt);
            }
        });

        lbXopt.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        lbXopt.setText("Phương án tối ưu");

        tfXopt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tfXopt.setForeground(new java.awt.Color(255, 0, 0));
        tfXopt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfXopt.setEnabled(false);

        javax.swing.GroupLayout DpanelToolLayout = new javax.swing.GroupLayout(DpanelTool);
        DpanelTool.setLayout(DpanelToolLayout);
        DpanelToolLayout.setHorizontalGroup(
            DpanelToolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DpanelToolLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DpanelToolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DpanelToolLayout.createSequentialGroup()
                        .addGroup(DpanelToolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbXopt, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(DpanelToolLayout.createSequentialGroup()
                                .addComponent(lbW, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfW, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DpanelToolLayout.createSequentialGroup()
                        .addGroup(DpanelToolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfWeight, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfXopt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCost, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DpanelToolLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(btStart)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btReset)
                                .addGap(25, 25, 25))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DpanelToolLayout.createSequentialGroup()
                                .addComponent(lbNum, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfNum, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DpanelToolLayout.createSequentialGroup()
                                .addComponent(lbCost, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DpanelToolLayout.createSequentialGroup()
                                .addComponent(lbFopt, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfFopt)))
                        .addContainerGap())))
            .addComponent(jSeparator1)
        );
        DpanelToolLayout.setVerticalGroup(
            DpanelToolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DpanelToolLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(DpanelToolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DpanelToolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbW, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addComponent(lbCost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbWeight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(DpanelToolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFopt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfFopt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbXopt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(tfXopt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(DpanelToolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btReset)
                    .addComponent(btStart))
                .addContainerGap())
        );
        DpanelTool.setLayer(lbNum, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DpanelTool.setLayer(btReset, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DpanelTool.setLayer(btStart, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DpanelTool.setLayer(tfNum, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DpanelTool.setLayer(lbFopt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DpanelTool.setLayer(tfFopt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DpanelTool.setLayer(lbCost, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DpanelTool.setLayer(tfCost, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DpanelTool.setLayer(lbWeight, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DpanelTool.setLayer(tfWeight, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DpanelTool.setLayer(lbW, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DpanelTool.setLayer(tfW, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DpanelTool.setLayer(lbXopt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DpanelTool.setLayer(tfXopt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DpanelTool.setLayer(jSeparator1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 213, Short.MAX_VALUE)
        );

        SPanel.setWheelScrollingEnabled(false);

        mnFile.setMnemonic('F');
        mnFile.setText("File");

        miAbout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        miAbout.setMnemonic('A');
        miAbout.setText("About");
        miAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAboutActionPerformed(evt);
            }
        });
        mnFile.add(miAbout);

        miSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        miSave.setMnemonic('S');
        miSave.setText("Save");
        miSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSaveActionPerformed(evt);
            }
        });
        mnFile.add(miSave);
        mnFile.add(jSeparator3);

        miExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        miExit.setMnemonic('x');
        miExit.setText("Exit");
        miExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miExitActionPerformed(evt);
            }
        });
        mnFile.add(miExit);

        mnbar.add(mnFile);

        mnEdit.setMnemonic('E');
        mnEdit.setText("Edit");

        miStart.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        miStart.setMnemonic('S');
        miStart.setText("Start");
        miStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miStartActionPerformed(evt);
            }
        });
        mnEdit.add(miStart);

        miReset.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, java.awt.event.InputEvent.SHIFT_MASK));
        miReset.setMnemonic('R');
        miReset.setText("Reset");
        miReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miResetActionPerformed(evt);
            }
        });
        mnEdit.add(miReset);

        mnbar.add(mnEdit);

        setJMenuBar(mnbar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DpanelTool)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(DpanelTool, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(SPanel)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfNumKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNumKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                n = Integer.parseInt(tfNum.getText());
                if (n <= 0) {
                    JOptionPane.showMessageDialog(null, "Bạn nhập vào một số không phải là số nguyên dương !!!\nBạn phải nhập vào một số nguyên dương", "Error", JOptionPane.ERROR_MESSAGE);
                    tfNum.requestFocus();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Bạn vừa nhập vào một ký tự!!!\nbạn phải nhập vào một số nguyên dương", "Error", JOptionPane.ERROR_MESSAGE);
                tfNum.requestFocus();
            }
            if (n > 0) {
                a = new int[n];
                c = new int[n];
                xopt = new int[n];
                x = new int[n];
                index = new int[n];
                gn = new GraphNode[n + 1];
                weight = cost = fopt = 0;
                gn[0] = g.addNode();
                gn[0].getInfo().setCaption("Root");
                gn[0].getInfo().setFooter("f = 0");
                for (int i = 0; i < n; i++) {
                    index[i] = i;
                }
                tfW.setEnabled(true);
            }
            tfNum.transferFocus();
        }
    }//GEN-LAST:event_tfNumKeyPressed

    private void tfWKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfWKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                w = Integer.parseInt(tfW.getText());
                if (w <= 0) {
                    JOptionPane.showMessageDialog(null, "Bạn nhập vào một số không phải là số nguyên dương !!!\nBạn phải nhập vào một số nguyên dương", "Error", JOptionPane.ERROR_MESSAGE);
                    tfW.requestFocus();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Bạn vừa nhập vào một ký tự!!!\nbạn phải nhập vào một số nguyên dương", "Error", JOptionPane.ERROR_MESSAGE);
                tfW.requestFocus();
            }
            if (w > 0) {
//                tfWeight.setEnabled(true);
//                tfCost.setEnabled(true);
                tfW.transferFocus();
                JOptionPane.showMessageDialog(null, "Click vào phần \"" + lbWeight.getText() + "\" và phần \"" + lbCost.getText() + "\" để tiếp tục", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_tfWKeyPressed

    private void tfCostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfCostMouseClicked
        if (tfW.isEnabled() == true) {
            String str;
            for (int i = 0; i < n; i++) {
                str = JOptionPane.showInputDialog(null, "Nhập c[" + (i + 1) + "]", "Nhập giá trị của từng đồ vật", JOptionPane.INFORMATION_MESSAGE);
                if (c[i] < 0) {
                    JOptionPane.showMessageDialog(null, "Số nhập vào là số âm\nNhập lại!", "Error", JOptionPane.ERROR_MESSAGE);
                    tfCost.requestFocus();
                }
                c[i] = Integer.parseInt(str);
            }
            str = "";
            for (int i = 0; i < n; i++) {
                str += c[i] + " ; ";
            }
            tfCost.setText(str.substring(0, str.lastIndexOf(";")));
            if (tfWeight.getText().equals("")) {
                btStart.setEnabled(true);
                miStart.setEnabled(true);
            }
        }
    }//GEN-LAST:event_tfCostMouseClicked

    private void tfWeightMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfWeightMouseClicked
        if (tfW.isEnabled() == true) {
            String str;
            for (int i = 0; i < n; i++) {
                str = JOptionPane.showInputDialog(null, "Nhập a[" + (i + 1) + "]", "Nhập khối lượng của từng đồ vật", JOptionPane.INFORMATION_MESSAGE);
                if (a[i] < 0) {
                    JOptionPane.showMessageDialog(null, "Số nhập vào là số âm\nNhập lại!", "Error", JOptionPane.ERROR_MESSAGE);
                    tfW.requestFocus();
                }
                a[i] = Integer.parseInt(str);
            }
            str = "";
            for (int i = 0; i < n; i++) {
                str += a[i] + " ; ";
            }
            tfWeight.setText(str.substring(0, str.lastIndexOf(";")));
            if (tfCost.getText().equals("")) {
                btStart.setEnabled(true);
                miStart.setEnabled(true);
            }
        }
    }//GEN-LAST:event_tfWeightMouseClicked

    private void btResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btResetActionPerformed
        btStart.setEnabled(false);
        miStart.setEnabled(false);
        tfNum.setText("");
        tfCost.setText("");
        tfCost.setEnabled(false);
        tfWeight.setText("");
        tfWeight.setEnabled(false);
        tfW.setText("");
        tfW.setEnabled(false);
        tfFopt.setText("");
        tfFopt.setEnabled(false);
        tfXopt.setText("");
        tfXopt.setEnabled(false);
        g = null;
        after = null;
        g = GraphFactory.newGraph();
        after = g.addNode();
        tfNum.requestFocus();
    }//GEN-LAST:event_btResetActionPerformed

    private void btStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btStartActionPerformed
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((float) c[i] / a[i] < (float) c[j] / a[j]) {
                    int tmp = c[i];
                    c[i] = c[j];
                    c[j] = tmp;
                    tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                    tmp = index[i];
                    index[i] = index[j];
                    index[j] = tmp;
                }
            }
        }

        writeTextF(tfCost, c);
        writeTextF(tfWeight, a);
        String str = "f(x) = ";
        for (int i = 0; i < n; i++) {
            if (c[i] != 1) {
                str += c[i] + ".x" + (i + 1);
            } else {
                str += "x" + (i + 1);
            }
            if (i != n - 1) {
                str += " + ";
            } else {
                str += "\n         ";
            }
        }
        for (int i = 0; i < n; i++) {
            if (a[i] != 1) {
                str += a[i] + ".x" + (i + 1);
            } else {
                str += "x" + (i + 1);
            }
            if (i != n - 1) {
                str += " + ";
            } else {
                str += " <= " + w;
            }
        }
        after.getInfo().setCaption(str);
        Try(0);
        tfFopt.setText(String.valueOf(fopt));
        tfXopt.setEnabled(true);
        tfFopt.setEnabled(true);
        writeTextF(tfXopt, xopt);
        final String dot = "File dot.dot";
        final String png = "picture.png";
        g.getInfo().setCaption("School of Information and Communication Technology");
        try {
            GRAPHtoDOTtoGIF.transform(g, dot, png, "bin\\dot.exe");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error loaded Picture !!!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        try {
            BufferedImage image = ImageIO.read(new File("picture.png"));
            ImageIcon icon = new ImageIcon(image.getScaledInstance(image.getWidth(), image.getHeight(), BufferedImage.SCALE_SMOOTH));
            hScroll.setIcon(icon);
        } catch (IOException ex) {

        }

    }//GEN-LAST:event_btStartActionPerformed

    private void miStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miStartActionPerformed
        btStartActionPerformed(null);
    }//GEN-LAST:event_miStartActionPerformed

    private void miResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miResetActionPerformed
        btResetActionPerformed(null);
    }//GEN-LAST:event_miResetActionPerformed

    private void miExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_miExitActionPerformed

    private void miAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAboutActionPerformed
        frame.setVisible(true);
        frame.setLocationRelativeTo(frame);
    }//GEN-LAST:event_miAboutActionPerformed

    private void frameWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_frameWindowClosing
        frame.setVisible(false);
    }//GEN-LAST:event_frameWindowClosing

    private void miSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSaveActionPerformed
        JFileChooser choose = new JFileChooser("D:\\");
        choose.setDialogTitle("Save picture");
        if (choose.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File output = choose.getSelectedFile();
            File input = new File("picture.png");
            try {
                FileInputStream fis;
                try (FileOutputStream fos = new FileOutputStream(output)) {
                    fis = new FileInputStream(input);
                    try (BufferedOutputStream bos = new BufferedOutputStream(fos); BufferedInputStream bis = new BufferedInputStream(fis)) {
                        int ch;
                        while ((ch = bis.read()) != -1) {
                            bos.write(ch);
                        }
                    }
                }
                fis.close();
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "File not save", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "File not save", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_miSaveActionPerformed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(BTToiuuBaiToanCaiTui.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new BTToiuuBaiToanCaiTui().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane DPanelAbout;
    private javax.swing.JDesktopPane DpanelTool;
    private javax.swing.JScrollPane SPanel;
    private javax.swing.JButton btReset;
    private javax.swing.JButton btStart;
    private javax.swing.JFrame frame;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JLabel lbAthor;
    private javax.swing.JLabel lbCost;
    private javax.swing.JLabel lbFopt;
    private javax.swing.JLabel lbNum;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbTitle1;
    private javax.swing.JLabel lbW;
    private javax.swing.JLabel lbWeight;
    private javax.swing.JLabel lbXopt;
    private javax.swing.JMenuItem miAbout;
    private javax.swing.JMenuItem miExit;
    private javax.swing.JMenuItem miReset;
    private javax.swing.JMenuItem miSave;
    private javax.swing.JMenuItem miStart;
    private javax.swing.JMenu mnEdit;
    private javax.swing.JMenu mnFile;
    private javax.swing.JMenuBar mnbar;
    private javax.swing.JPanel panel;
    private javax.swing.JTextArea taAbout;
    private javax.swing.JTextField tfCost;
    private javax.swing.JTextField tfFopt;
    private javax.swing.JTextField tfNum;
    private javax.swing.JTextField tfW;
    private javax.swing.JTextField tfWeight;
    private javax.swing.JTextField tfXopt;
    // End of variables declaration//GEN-END:variables
}

class HandScroll extends JLabel {

    public HandScroll(ImageIcon i) {
        super(i);
        MouseInputAdapter mia = new MouseInputAdapter() {
            int m_XDifference, m_YDifference;
            boolean m_dragging;
            Container c;

            @Override
            public void mouseDragged(MouseEvent e) {
                c = HandScroll.this.getParent();
                if (c instanceof JViewport) {
                    JViewport jv = (JViewport) c;
                    Point p = jv.getViewPosition();
                    int newX = p.x - (e.getX() - m_XDifference);
                    int newY = p.y - (e.getY() - m_YDifference);

                    int maxX = HandScroll.this.getWidth() - jv.getWidth();
                    int maxY = HandScroll.this.getHeight() - jv.getHeight();
                    if (newX < 0) {
                        newX = 0;
                    }
                    if (newX > maxX) {
                        newX = maxX;
                    }
                    if (newY < 0) {
                        newY = 0;
                    }
                    if (newY > maxY) {
                        newY = maxY;
                    }

                    jv.setViewPosition(new Point(newX, newY));
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
                m_XDifference = e.getX();
                m_YDifference = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        };
        addMouseMotionListener(mia);
        addMouseListener(mia);
    }
}
