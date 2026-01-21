package com.dsa.design;

import java.util.*;

/**
 * Design In-Memory File System (LeetCode 588)
 * 
 * Design a data structure that simulates an in-memory file system.
 */
public class FileSystem {

    class FileNode {
        boolean isFile;
        StringBuilder content;
        TreeMap<String, FileNode> children;

        public FileNode() {
            isFile = false;
            content = new StringBuilder();
            children = new TreeMap<>();
        }
    }

    FileNode root;

    public FileSystem() {
        root = new FileNode();
    }

    public List<String> ls(String path) {
        FileNode node = traverse(path);
        List<String> result = new ArrayList<>();
        if (node.isFile) {
            result.add(path.substring(path.lastIndexOf("/") + 1));
        } else {
            result.addAll(node.children.keySet());
        }
        return result;
    }

    public void mkdir(String path) {
        traverse(path);
    }

    public void addContentToFile(String filePath, String content) {
        FileNode node = traverse(filePath);
        node.isFile = true;
        node.content.append(content);
    }

    public String readContentFromFile(String filePath) {
        FileNode node = traverse(filePath);
        return node.content.toString();
    }

    private FileNode traverse(String path) {
        FileNode curr = root;
        if (path.equals("/"))
            return curr;

        String[] parts = path.split("/");
        for (int i = 1; i < parts.length; i++) {
            curr.children.putIfAbsent(parts[i], new FileNode());
            curr = curr.children.get(parts[i]);
        }
        return curr;
    }
}
