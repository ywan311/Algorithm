package net.skhu.redblack;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RedBlackTreeViewer {
    static JFrame frame = new JFrame();
    static BinaryTreePanel treePanel = new BinaryTreePanel();

    public static void main(String[] args) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        JPanel buttonPanel = new JPanel();
        JTextField textField = new JTextField(10);
        JButton btnAdd = new JButton("add");
        JButton btnRemove = new JButton("remove");
        JButton btnPrev = new JButton("previous");
        JButton btnNext = new JButton("next");
        ActionListener action = e -> {
            try {
                int value = Integer.parseInt(textField.getText());
                if (e.getSource() == btnAdd) { treePanel.tree.add(value); treePanel.title = "ADD "+value; }
                else { treePanel.tree.remove(value); treePanel.title = "REMOVE " + value; }
                treePanel.capture();
                treePanel.repaint();
                textField.setText("");
                textField.requestFocus();
                btnNext.setEnabled(false);
                btnPrev.setEnabled(treePanel.images.size() >= 2);
            } catch(Exception ex) {}
        };
        ActionListener action2 = e -> {
            if (e.getSource() == btnPrev) treePanel.index = Math.max(treePanel.index - 1, 0);
            else treePanel.index = Math.min(treePanel.index + 1, treePanel.images.size() - 1);
            boolean b = treePanel.index == treePanel.images.size() - 1;
            btnAdd.setEnabled(b); btnRemove.setEnabled(b);
            btnNext.setEnabled(treePanel.index < treePanel.images.size() - 1);
            btnPrev.setEnabled(treePanel.index > 0);
            treePanel.repaint();
        };
        btnAdd.addActionListener(action);
        btnRemove.addActionListener(action);
        btnPrev.addActionListener(action2);
        btnNext.addActionListener(action2);
        btnNext.setEnabled(false); btnPrev.setEnabled(false);
        buttonPanel.add(textField);
        buttonPanel.add(btnAdd);   buttonPanel.add(btnRemove);
        buttonPanel.add(btnPrev);  buttonPanel.add(btnNext);
        buttonPanel.setMaximumSize(new Dimension(2000, 60));
        mainPanel.add(buttonPanel);
        mainPanel.add(treePanel);
        frame.add("Center", mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(1024, 1024);
        frame.getRootPane().setDefaultButton(btnAdd);
    }
}

@SuppressWarnings("serial")
class BinaryTreePanel extends JPanel {
    static final int NODE_WIDTH = 40;
    static final int NODE_HEIGHT = 40;
    RedBlackTree tree = new RedBlackTree();
    String title;
    ArrayList<BufferedImage> images = new ArrayList<>();
    int index = -1;

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        if (index >= 0) ((Graphics2D)graphics).drawImage(images.get(index), 0, 20, null);
    }

    static void drawNode(Graphics2D g, Node node, int x1, int y1, int parentX, int parentY) {
        if (node == Node.NULL) {
            int thisY = y1, thisX = x1 + NODE_WIDTH * 3 / 4;
            g.setColor(Color.BLACK);
            if (parentX >= 0) g.drawLine(thisX + NODE_WIDTH/4, thisY + NODE_HEIGHT/4,
                                                parentX + NODE_WIDTH/2, parentY + NODE_HEIGHT/2);
            Rectangle2D.Double rect = new Rectangle2D.Double(thisX, thisY, NODE_WIDTH/2, NODE_HEIGHT/2);
            g.setColor(Color.BLACK); g.fill(rect);
        } else {
            int leftChildWidth = getWidth(node.left);
            int thisY = y1, thisX = x1 + leftChildWidth;
            drawNode(g, node.left,  x1, thisY + NODE_HEIGHT * 3 / 2, thisX, thisY);
            drawNode(g, node.right, x1 + leftChildWidth, thisY + NODE_HEIGHT * 3 / 2, thisX, thisY);
            g.setColor(Color.BLACK);
            if (parentX >= 0) g.drawLine(thisX + NODE_WIDTH/2, thisY + NODE_HEIGHT/2,
                                                parentX + NODE_WIDTH/2, parentY + NODE_HEIGHT/2);
            Ellipse2D.Double ellipse = new Ellipse2D.Double(thisX, thisY, NODE_WIDTH, NODE_HEIGHT);
            g.setColor(node.color==Node.BLACK ? Color.BLACK : Color.RED); g.fill(ellipse);
            g.setColor(Color.BLACK); g.draw(ellipse);
            g.setColor(Color.WHITE);
            drawCenteredString(g, String.valueOf(node.value), ellipse.getBounds());
        }
    }

    static void drawCenteredString(Graphics2D g, String s, Rectangle rect) {
        FontMetrics metrics = g.getFontMetrics();
        int x = rect.x + (rect.width - metrics.stringWidth(s)) / 2;
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        g.drawString(s, x, y);
    }

    static int getWidth(Node node) {
        if (node == Node.NULL) return NODE_WIDTH;
        return getWidth(node.left) + getWidth(node.right);
    }

    static int getHeight(Node node) {
        if (node == Node.NULL) return NODE_HEIGHT * 3 / 2;
        return Math.max(getHeight(node.left), getHeight(node.right)) + NODE_HEIGHT * 3 / 2;
    }

    void capture() {
        BufferedImage image = new BufferedImage(getWidth(tree.root)+100, getHeight(tree.root)+100,
                                                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();
        super.paint(g);
        g.drawString("(" + (index+2) + ")  " + title, 20, 20);
        drawNode(g, tree.root, 0, NODE_HEIGHT, -1, -1);
        images.add(image);
        index = images.size() - 1;
    }
}
