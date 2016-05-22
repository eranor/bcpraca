package com.akos.language;


import java.util.LinkedList;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class AbstractSyntaxTree {

    LinkedList<Statement> statements = new LinkedList<>();

    public void parseStatements() {
    }

    public void parseIfStatement(Statement ifStmt) {
        for (Statement stmt : statements) {

        }
    }

}
