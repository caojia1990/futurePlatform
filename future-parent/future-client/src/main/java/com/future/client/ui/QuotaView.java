package com.future.client.ui;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

public class QuotaView extends JSplitPane {

    /**
     * 
     */
    private static final long serialVersionUID = 4237344928648600404L;

    /**
     * Create the panel.
     */
    public QuotaView() {
        
        JTree tree = new JTree();
        setLeftComponent(tree);
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("均线");
        {
            DefaultMutableTreeNode parent = new DefaultMutableTreeNode("EMA");
            root.add(parent);
        }
        TreeModel treeModel = new DefaultTreeModel(root);
        tree.setModel(treeModel);
    }
    
    public static void main(String[] args) {
        
        JFrame frame = new JFrame();
        frame.setBounds(100, 100, 214, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        QuotaView quotaView = new QuotaView();
        frame.getContentPane().add(quotaView);
        frame.setVisible(true);
        
    }

}
