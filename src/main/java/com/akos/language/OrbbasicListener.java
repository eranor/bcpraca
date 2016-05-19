// Generated from D:/projects/java/bcpraca3/src/main/java/com/akos/language\Orbbasic.g4 by ANTLR 4.5.1
package com.akos.language;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link OrbbasicParser}.
 */
public interface OrbbasicListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(OrbbasicParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(OrbbasicParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(OrbbasicParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(OrbbasicParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#linenumber}.
	 * @param ctx the parse tree
	 */
	void enterLinenumber(OrbbasicParser.LinenumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#linenumber}.
	 * @param ctx the parse tree
	 */
	void exitLinenumber(OrbbasicParser.LinenumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(OrbbasicParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(OrbbasicParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#printstmt}.
	 * @param ctx the parse tree
	 */
	void enterPrintstmt(OrbbasicParser.PrintstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#printstmt}.
	 * @param ctx the parse tree
	 */
	void exitPrintstmt(OrbbasicParser.PrintstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#printlist}.
	 * @param ctx the parse tree
	 */
	void enterPrintlist(OrbbasicParser.PrintlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#printlist}.
	 * @param ctx the parse tree
	 */
	void exitPrintlist(OrbbasicParser.PrintlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#conditionalstmt}.
	 * @param ctx the parse tree
	 */
	void enterConditionalstmt(OrbbasicParser.ConditionalstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#conditionalstmt}.
	 * @param ctx the parse tree
	 */
	void exitConditionalstmt(OrbbasicParser.ConditionalstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#forstmt}.
	 * @param ctx the parse tree
	 */
	void enterForstmt(OrbbasicParser.ForstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#forstmt}.
	 * @param ctx the parse tree
	 */
	void exitForstmt(OrbbasicParser.ForstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#nextstmt}.
	 * @param ctx the parse tree
	 */
	void enterNextstmt(OrbbasicParser.NextstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#nextstmt}.
	 * @param ctx the parse tree
	 */
	void exitNextstmt(OrbbasicParser.NextstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#branchstmt}.
	 * @param ctx the parse tree
	 */
	void enterBranchstmt(OrbbasicParser.BranchstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#branchstmt}.
	 * @param ctx the parse tree
	 */
	void exitBranchstmt(OrbbasicParser.BranchstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#idxbranchstmt}.
	 * @param ctx the parse tree
	 */
	void enterIdxbranchstmt(OrbbasicParser.IdxbranchstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#idxbranchstmt}.
	 * @param ctx the parse tree
	 */
	void exitIdxbranchstmt(OrbbasicParser.IdxbranchstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#delay}.
	 * @param ctx the parse tree
	 */
	void enterDelay(OrbbasicParser.DelayContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#delay}.
	 * @param ctx the parse tree
	 */
	void exitDelay(OrbbasicParser.DelayContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#backled}.
	 * @param ctx the parse tree
	 */
	void enterBackled(OrbbasicParser.BackledContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#backled}.
	 * @param ctx the parse tree
	 */
	void exitBackled(OrbbasicParser.BackledContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#vardecl}.
	 * @param ctx the parse tree
	 */
	void enterVardecl(OrbbasicParser.VardeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#vardecl}.
	 * @param ctx the parse tree
	 */
	void exitVardecl(OrbbasicParser.VardeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#varname}.
	 * @param ctx the parse tree
	 */
	void enterVarname(OrbbasicParser.VarnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#varname}.
	 * @param ctx the parse tree
	 */
	void exitVarname(OrbbasicParser.VarnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#varassign}.
	 * @param ctx the parse tree
	 */
	void enterVarassign(OrbbasicParser.VarassignContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#varassign}.
	 * @param ctx the parse tree
	 */
	void exitVarassign(OrbbasicParser.VarassignContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#neq}.
	 * @param ctx the parse tree
	 */
	void enterNeq(OrbbasicParser.NeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#neq}.
	 * @param ctx the parse tree
	 */
	void exitNeq(OrbbasicParser.NeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(OrbbasicParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(OrbbasicParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunc(OrbbasicParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunc(OrbbasicParser.FuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#sqrtfunc}.
	 * @param ctx the parse tree
	 */
	void enterSqrtfunc(OrbbasicParser.SqrtfuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#sqrtfunc}.
	 * @param ctx the parse tree
	 */
	void exitSqrtfunc(OrbbasicParser.SqrtfuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#rndfunc}.
	 * @param ctx the parse tree
	 */
	void enterRndfunc(OrbbasicParser.RndfuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#rndfunc}.
	 * @param ctx the parse tree
	 */
	void exitRndfunc(OrbbasicParser.RndfuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#absfunc}.
	 * @param ctx the parse tree
	 */
	void enterAbsfunc(OrbbasicParser.AbsfuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#absfunc}.
	 * @param ctx the parse tree
	 */
	void exitAbsfunc(OrbbasicParser.AbsfuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#signExpr}.
	 * @param ctx the parse tree
	 */
	void enterSignExpr(OrbbasicParser.SignExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#signExpr}.
	 * @param ctx the parse tree
	 */
	void exitSignExpr(OrbbasicParser.SignExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#multExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultExpr(OrbbasicParser.MultExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#multExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultExpr(OrbbasicParser.MultExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#addExpr}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(OrbbasicParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#addExpr}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(OrbbasicParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#relExpr}.
	 * @param ctx the parse tree
	 */
	void enterRelExpr(OrbbasicParser.RelExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#relExpr}.
	 * @param ctx the parse tree
	 */
	void exitRelExpr(OrbbasicParser.RelExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(OrbbasicParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(OrbbasicParser.ExpressionContext ctx);
}