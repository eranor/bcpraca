// Generated from D:/projects/java/bcpraca3/src/main/java/com/akos/language\Orbbasic.g4 by ANTLR 4.5.1
package com.akos.language;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link OrbbasicParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface OrbbasicVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(OrbbasicParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine(OrbbasicParser.LineContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#linenumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLinenumber(OrbbasicParser.LinenumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(OrbbasicParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#printstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintstmt(OrbbasicParser.PrintstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#printlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintlist(OrbbasicParser.PrintlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#conditionalstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalstmt(OrbbasicParser.ConditionalstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#forstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForstmt(OrbbasicParser.ForstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#nextstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNextstmt(OrbbasicParser.NextstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#branchstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBranchstmt(OrbbasicParser.BranchstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#idxbranchstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdxbranchstmt(OrbbasicParser.IdxbranchstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#delay}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelay(OrbbasicParser.DelayContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#backled}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBackled(OrbbasicParser.BackledContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#vardecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVardecl(OrbbasicParser.VardeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#varname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarname(OrbbasicParser.VarnameContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#varassign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarassign(OrbbasicParser.VarassignContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#neq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNeq(OrbbasicParser.NeqContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(OrbbasicParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(OrbbasicParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#sqrtfunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSqrtfunc(OrbbasicParser.SqrtfuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#rndfunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRndfunc(OrbbasicParser.RndfuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#absfunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbsfunc(OrbbasicParser.AbsfuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#signExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignExpr(OrbbasicParser.SignExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#multExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultExpr(OrbbasicParser.MultExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#addExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(OrbbasicParser.AddExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#relExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelExpr(OrbbasicParser.RelExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(OrbbasicParser.ExpressionContext ctx);
}