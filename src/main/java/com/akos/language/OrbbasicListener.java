// Generated from D:/Akos/Dropbox/bcpraca3/src/main/java/com/akos/language\Orbbasic.g4 by ANTLR 4.5.1
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
	 * Enter a parse tree produced by {@link OrbbasicParser#input}.
	 * @param ctx the parse tree
	 */
	void enterInput(OrbbasicParser.InputContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#input}.
	 * @param ctx the parse tree
	 */
	void exitInput(OrbbasicParser.InputContext ctx);
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
	 * Enter a parse tree produced by {@link OrbbasicParser#end}.
	 * @param ctx the parse tree
	 */
	void enterEnd(OrbbasicParser.EndContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#end}.
	 * @param ctx the parse tree
	 */
	void exitEnd(OrbbasicParser.EndContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#rgb}.
	 * @param ctx the parse tree
	 */
	void enterRgb(OrbbasicParser.RgbContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#rgb}.
	 * @param ctx the parse tree
	 */
	void exitRgb(OrbbasicParser.RgbContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#ledc}.
	 * @param ctx the parse tree
	 */
	void enterLedc(OrbbasicParser.LedcContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#ledc}.
	 * @param ctx the parse tree
	 */
	void exitLedc(OrbbasicParser.LedcContext ctx);
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
	 * Enter a parse tree produced by {@link OrbbasicParser#random}.
	 * @param ctx the parse tree
	 */
	void enterRandom(OrbbasicParser.RandomContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#random}.
	 * @param ctx the parse tree
	 */
	void exitRandom(OrbbasicParser.RandomContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#goroll}.
	 * @param ctx the parse tree
	 */
	void enterGoroll(OrbbasicParser.GorollContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#goroll}.
	 * @param ctx the parse tree
	 */
	void exitGoroll(OrbbasicParser.GorollContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#heading}.
	 * @param ctx the parse tree
	 */
	void enterHeading(OrbbasicParser.HeadingContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#heading}.
	 * @param ctx the parse tree
	 */
	void exitHeading(OrbbasicParser.HeadingContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#raw}.
	 * @param ctx the parse tree
	 */
	void enterRaw(OrbbasicParser.RawContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#raw}.
	 * @param ctx the parse tree
	 */
	void exitRaw(OrbbasicParser.RawContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#locate}.
	 * @param ctx the parse tree
	 */
	void enterLocate(OrbbasicParser.LocateContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#locate}.
	 * @param ctx the parse tree
	 */
	void exitLocate(OrbbasicParser.LocateContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#basflg}.
	 * @param ctx the parse tree
	 */
	void enterBasflg(OrbbasicParser.BasflgContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#basflg}.
	 * @param ctx the parse tree
	 */
	void exitBasflg(OrbbasicParser.BasflgContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#data}.
	 * @param ctx the parse tree
	 */
	void enterData(OrbbasicParser.DataContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#data}.
	 * @param ctx the parse tree
	 */
	void exitData(OrbbasicParser.DataContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#rstr}.
	 * @param ctx the parse tree
	 */
	void enterRstr(OrbbasicParser.RstrContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#rstr}.
	 * @param ctx the parse tree
	 */
	void exitRstr(OrbbasicParser.RstrContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#read}.
	 * @param ctx the parse tree
	 */
	void enterRead(OrbbasicParser.ReadContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#read}.
	 * @param ctx the parse tree
	 */
	void exitRead(OrbbasicParser.ReadContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#tron}.
	 * @param ctx the parse tree
	 */
	void enterTron(OrbbasicParser.TronContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#tron}.
	 * @param ctx the parse tree
	 */
	void exitTron(OrbbasicParser.TronContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#troff}.
	 * @param ctx the parse tree
	 */
	void enterTroff(OrbbasicParser.TroffContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#troff}.
	 * @param ctx the parse tree
	 */
	void exitTroff(OrbbasicParser.TroffContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#reset_}.
	 * @param ctx the parse tree
	 */
	void enterReset_(OrbbasicParser.Reset_Context ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#reset_}.
	 * @param ctx the parse tree
	 */
	void exitReset_(OrbbasicParser.Reset_Context ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#sleep}.
	 * @param ctx the parse tree
	 */
	void enterSleep(OrbbasicParser.SleepContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#sleep}.
	 * @param ctx the parse tree
	 */
	void exitSleep(OrbbasicParser.SleepContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#macrun}.
	 * @param ctx the parse tree
	 */
	void enterMacrun(OrbbasicParser.MacrunContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#macrun}.
	 * @param ctx the parse tree
	 */
	void exitMacrun(OrbbasicParser.MacrunContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#mackill}.
	 * @param ctx the parse tree
	 */
	void enterMackill(OrbbasicParser.MackillContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#mackill}.
	 * @param ctx the parse tree
	 */
	void exitMackill(OrbbasicParser.MackillContext ctx);
	/**
	 * Enter a parse tree produced by {@link OrbbasicParser#macstat}.
	 * @param ctx the parse tree
	 */
	void enterMacstat(OrbbasicParser.MacstatContext ctx);
	/**
	 * Exit a parse tree produced by {@link OrbbasicParser#macstat}.
	 * @param ctx the parse tree
	 */
	void exitMacstat(OrbbasicParser.MacstatContext ctx);
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