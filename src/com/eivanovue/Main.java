package com.eivanovue;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

public class Main {

    public Document doc = Jsoup.parse("<html></html>");


    public static void main(String[] args) throws IOException {
	 Main main = new Main();
	 main.createHtml();
	 main.exploreDirectories();
    }

    private void exploreDirectories() throws IOException {
        File dir = new File("./Corpus");
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                if(child.isDirectory()){
                    System.out.println(child.getName());
                    System.out.println("-----INSIDE-----");
                    File[] directoryChildren = child.listFiles();
                    assert directoryChildren != null;
                    for( File childChild : directoryChildren) {
                       System.out.println(childChild.getName() + " " + child.getPath());

                   }
                    System.out.println("-----END-----");
                } else {
                    System.out.println(child.getName() + " " + child.getPath());
                }
            }
        } else {
            System.out.println("Directory contains no files please..");
        }
    }
    private void createHtml() {
        doc.head().append("    <style>\n" +
                "        table {\n" +
                "            margin-left:auto;\n" +
                "            margin-right:auto;\n" +
                "        }\n" +
                "        td, th {\n" +
                "            border: 1px solid #ddd;\n" +
                "            text-align: left;\n" +
                "        }\n" +
                "\n" +
                "        table {\n" +
                "            border-collapse: collapse;\n" +
                "            width: 50%;\n" +
                "        }\n" +
                "\n" +
                "        th, td {\n" +
                "            padding: 15px;\n" +
                "        }\n" +
                "    </style>");
        doc.body().appendElement("table").appendElement("tr").appendElement("th");
        doc.body().select("table").append("<tr><td></td></tr>");
        System.out.println(doc.toString());
    }
}
