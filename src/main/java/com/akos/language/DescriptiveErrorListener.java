package com.akos.language;

import javafx.collections.ObservableList;
import org.antlr.v4.runtime.*;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class DescriptiveErrorListener extends BaseErrorListener {

    private final ObservableList<String> errorList;
    private boolean reportSyntaxErrors;

    public DescriptiveErrorListener(ObservableList<String> errorList) {
        this.reportSyntaxErrors = true;
        this.errorList = errorList;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
                            String msg, RecognitionException e) {

        if (!reportSyntaxErrors) {
            return;
        }
        String sourceName = recognizer.getInputStream().getSourceName();
        if (!sourceName.isEmpty()) {
            sourceName = String.format("%s:%d:%d: ", sourceName, line, charPositionInLine);
        }
        // FIXME: 2016. 05. 25. unsupported operation error
        errorList.add(String.format("%sline %d:%d %s%n", sourceName, line, charPositionInLine, msg));
    }

    public void setReportSyntaxErrors(boolean reportSyntaxErrors) {
        this.reportSyntaxErrors = reportSyntaxErrors;
    }

    public boolean reportSyntaxErrors() {
        return reportSyntaxErrors;
    }
}
