// Generated from D:/Ákos/Dropbox/bcpraca3/src/main/java/com/akos/language\Orbbasic.g4 by ANTLR 4.5.1
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
	 * Visit a parse tree produced by {@link OrbbasicParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInput(OrbbasicParser.InputContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#delay}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelay(OrbbasicParser.DelayContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#end}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnd(OrbbasicParser.EndContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#rgb}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRgb(OrbbasicParser.RgbContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#ledc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLedc(OrbbasicParser.LedcContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#backled}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBackled(OrbbasicParser.BackledContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#random}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRandom(OrbbasicParser.RandomContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#goroll}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoroll(OrbbasicParser.GorollContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#heading}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeading(OrbbasicParser.HeadingContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#raw}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRaw(OrbbasicParser.RawContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#locate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocate(OrbbasicParser.LocateContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#basflg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasflg(OrbbasicParser.BasflgContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#data}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitData(OrbbasicParser.DataContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#rstr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRstr(OrbbasicParser.RstrContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#read}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRead(OrbbasicParser.ReadContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#tron}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTron(OrbbasicParser.TronContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#troff}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTroff(OrbbasicParser.TroffContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#reset_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReset_(OrbbasicParser.Reset_Context ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#sleep}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSleep(OrbbasicParser.SleepContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#macrun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMacrun(OrbbasicParser.MacrunContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#mackill}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMackill(OrbbasicParser.MackillContext ctx);
	/**
	 * Visit a parse tree produced by {@link OrbbasicParser#macstat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMacstat(OrbbasicParser.MacstatContext ctx);
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