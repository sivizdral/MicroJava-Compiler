// generated with ast extension for cup
// version 0.8
// 17/11/2022 17:54:35


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(GlobalVarDecl GlobalVarDecl);
    public void visit(OptionalDesignatorList OptionalDesignatorList);
    public void visit(Factor Factor);
    public void visit(Statement Statement);
    public void visit(OptionalRelopExpr OptionalRelopExpr);
    public void visit(ConstDeclList ConstDeclList);
    public void visit(OtherConstList OtherConstList);
    public void visit(ExprList ExprList);
    public void visit(DsgStmtEnd DsgStmtEnd);
    public void visit(ConditionIF ConditionIF);
    public void visit(Relop Relop);
    public void visit(OptionalSquares OptionalSquares);
    public void visit(ConstTail ConstTail);
    public void visit(OptMinus OptMinus);
    public void visit(FirstClassVarDecl FirstClassVarDecl);
    public void visit(OtherClassVarDeclList OtherClassVarDeclList);
    public void visit(OtherGlobalVarDeclList OtherGlobalVarDeclList);
    public void visit(MulopFactorList MulopFactorList);
    public void visit(AddopTermList AddopTermList);
    public void visit(VarDecl VarDecl);
    public void visit(Unmatched Unmatched);
    public void visit(Lists Lists);
    public void visit(ConstructorMethodLists ConstructorMethodLists);
    public void visit(OptionalDesignator OptionalDesignator);
    public void visit(OptionalActPars OptionalActPars);
    public void visit(FirstGlobalVarDecl FirstGlobalVarDecl);
    public void visit(Mulop Mulop);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(FirstConst FirstConst);
    public void visit(CondFactAndList CondFactAndList);
    public void visit(Addop Addop);
    public void visit(StatementList StatementList);
    public void visit(OptOptActPars OptOptActPars);
    public void visit(ConstDecl ConstDecl);
    public void visit(ConstructorDeclList ConstructorDeclList);
    public void visit(OtherVarDeclList OtherVarDeclList);
    public void visit(CondTermOrList CondTermOrList);
    public void visit(ReturnType ReturnType);
    public void visit(FirstVarDecl FirstVarDecl);
    public void visit(IdentExprList IdentExprList);
    public void visit(ClassVarDecl ClassVarDecl);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(Extension Extension);
    public void visit(IdentSquares IdentSquares);
    public void visit(ClassVarDeclList ClassVarDeclList);
    public void visit(OptionalNumConst OptionalNumConst);
    public void visit(Matched Matched);
    public void visit(VarDeclList VarDeclList);
    public void visit(TypeIdentList TypeIdentList);
    public void visit(OptionalExpr OptionalExpr);
    public void visit(FormParsOptional FormParsOptional);
    public void visit(ExprOrActPars ExprOrActPars);
    public void visit(MethodDeclList2 MethodDeclList2);
    public void visit(MulopP MulopP);
    public void visit(MulopD MulopD);
    public void visit(MulopM MulopM);
    public void visit(AddopM AddopM);
    public void visit(AddopP AddopP);
    public void visit(RelopLTE RelopLTE);
    public void visit(RelopLT RelopLT);
    public void visit(RelopGTE RelopGTE);
    public void visit(RelopGT RelopGT);
    public void visit(RelopNE RelopNE);
    public void visit(RelopEq RelopEq);
    public void visit(Assignop Assignop);
    public void visit(Label Label);
    public void visit(NoIdentExprList NoIdentExprList);
    public void visit(IdentExprListExpr IdentExprListExpr);
    public void visit(IdentExprListIdent IdentExprListIdent);
    public void visit(DesignatorFE DesignatorFE);
    public void visit(Designator Designator);
    public void visit(ExprOrActParsActPars ExprOrActParsActPars);
    public void visit(ExprOrActParsExpr ExprOrActParsExpr);
    public void visit(NoOptOptActPars NoOptOptActPars);
    public void visit(OptOptActParsX OptOptActParsX);
    public void visit(FactorExpr FactorExpr);
    public void visit(FactorExprActPars FactorExprActPars);
    public void visit(FactorBoolConst FactorBoolConst);
    public void visit(FactorCharConst FactorCharConst);
    public void visit(FactorNumConst FactorNumConst);
    public void visit(FactorActPars FactorActPars);
    public void visit(NoMulopFactorList NoMulopFactorList);
    public void visit(MulopFactorListX MulopFactorListX);
    public void visit(Term Term);
    public void visit(NoAddopTermList NoAddopTermList);
    public void visit(AddopTermListX AddopTermListX);
    public void visit(NoOptMinus NoOptMinus);
    public void visit(OptMinusX OptMinusX);
    public void visit(Expr Expr);
    public void visit(NoOptionalRelopExpr NoOptionalRelopExpr);
    public void visit(OptionalRelopExprX OptionalRelopExprX);
    public void visit(CondFact CondFact);
    public void visit(NoCondFactAndList NoCondFactAndList);
    public void visit(CondFactAndListX CondFactAndListX);
    public void visit(CondTerm CondTerm);
    public void visit(NoCondTermOrList NoCondTermOrList);
    public void visit(CondTermOrListX CondTermOrListX);
    public void visit(ConditionWHILE ConditionWHILE);
    public void visit(ConditionIFError ConditionIFError);
    public void visit(ConditionIFX ConditionIFX);
    public void visit(NoExprList NoExprList);
    public void visit(ExprListX ExprListX);
    public void visit(ActPars ActPars);
    public void visit(NoOptionalDesignatorList NoOptionalDesignatorList);
    public void visit(OptionalDesignatorListX OptionalDesignatorListX);
    public void visit(NoOptionalDesignator NoOptionalDesignator);
    public void visit(OptionalDesignatorX OptionalDesignatorX);
    public void visit(NoOptionalActPars NoOptionalActPars);
    public void visit(OptionalActParsX OptionalActParsX);
    public void visit(DecDsgStmtEnd DecDsgStmtEnd);
    public void visit(IncDsgStmtEnd IncDsgStmtEnd);
    public void visit(ActParsDsgStmtEnd ActParsDsgStmtEnd);
    public void visit(AssignDsgStmtEnd AssignDsgStmtEnd);
    public void visit(ErrorDesignatorStmt ErrorDesignatorStmt);
    public void visit(SecondTypeDesignatorStmt SecondTypeDesignatorStmt);
    public void visit(FirstTypeDesignatorStmt FirstTypeDesignatorStmt);
    public void visit(NoOptionalNumConst NoOptionalNumConst);
    public void visit(OptionalNumConstX OptionalNumConstX);
    public void visit(NoOptionalExpr NoOptionalExpr);
    public void visit(OptionalExprX OptionalExprX);
    public void visit(ElseElse ElseElse);
    public void visit(BlockStmt BlockStmt);
    public void visit(ForeachStmt ForeachStmt);
    public void visit(PrintStmt PrintStmt);
    public void visit(ReadStmt ReadStmt);
    public void visit(ReturnStmt ReturnStmt);
    public void visit(ContinueStmt ContinueStmt);
    public void visit(BreakStmt BreakStmt);
    public void visit(WhileStmt WhileStmt);
    public void visit(MatchedIfElseStmt MatchedIfElseStmt);
    public void visit(DesigStmt DesigStmt);
    public void visit(UnmatchedIfElse UnmatchedIfElse);
    public void visit(UnmatchedIf UnmatchedIf);
    public void visit(UnmatchedStmt UnmatchedStmt);
    public void visit(MatchedStmt MatchedStmt);
    public void visit(Type Type);
    public void visit(IdentSquaresError IdentSquaresError);
    public void visit(IdentSquaresX IdentSquaresX);
    public void visit(NoTypeIdentList NoTypeIdentList);
    public void visit(TypeIdentListX TypeIdentListX);
    public void visit(NoOptionalSquares NoOptionalSquares);
    public void visit(OptionalSquaresX OptionalSquaresX);
    public void visit(FormPars FormPars);
    public void visit(NoReturnType NoReturnType);
    public void visit(ReturnTypeX ReturnTypeX);
    public void visit(MethodDecl MethodDecl);
    public void visit(NoStatementList NoStatementList);
    public void visit(StatementListX StatementListX);
    public void visit(NoFormParsOptional NoFormParsOptional);
    public void visit(FormParsOptionalX FormParsOptionalX);
    public void visit(ConstructorDeclStart ConstructorDeclStart);
    public void visit(FirstConstructorDecl FirstConstructorDecl);
    public void visit(NoConstructorDeclList NoConstructorDeclList);
    public void visit(ConstructorDeclListX ConstructorDeclListX);
    public void visit(MethodDecl2 MethodDecl2);
    public void visit(MDL23 MDL23);
    public void visit(MDL22 MDL22);
    public void visit(MDL21 MDL21);
    public void visit(ListsNoConNoMet ListsNoConNoMet);
    public void visit(ListsMetVoid ListsMetVoid);
    public void visit(ListsMet ListsMet);
    public void visit(ListsCon ListsCon);
    public void visit(ListsConMetVoid ListsConMetVoid);
    public void visit(ListsConMet ListsConMet);
    public void visit(NoConstructorMethodLists NoConstructorMethodLists);
    public void visit(ConstructorMethodListsX ConstructorMethodListsX);
    public void visit(NoVarDeclList NoVarDeclList);
    public void visit(VarDeclListX VarDeclListX);
    public void visit(NoClassVarDeclList NoClassVarDeclList);
    public void visit(ClassVarDeclListX ClassVarDeclListX);
    public void visit(NoExtension NoExtension);
    public void visit(ExtensionError ExtensionError);
    public void visit(ExtensionX ExtensionX);
    public void visit(ClassDeclStart ClassDeclStart);
    public void visit(ClassDecl ClassDecl);
    public void visit(NoOtherGlobalVarDeclList NoOtherGlobalVarDeclList);
    public void visit(OtherGlobalVarDeclListError OtherGlobalVarDeclListError);
    public void visit(OtherGlobalVarDeclListX OtherGlobalVarDeclListX);
    public void visit(NoOtherClassVarDeclList NoOtherClassVarDeclList);
    public void visit(OtherClassVarDeclListX OtherClassVarDeclListX);
    public void visit(NoOtherVarDeclList NoOtherVarDeclList);
    public void visit(OtherVarDeclListX OtherVarDeclListX);
    public void visit(FirstGlobalVarDeclError FirstGlobalVarDeclError);
    public void visit(FirstGlobalVarDeclArrayIdent FirstGlobalVarDeclArrayIdent);
    public void visit(FirstGlobalVarDeclIdentOnly FirstGlobalVarDeclIdentOnly);
    public void visit(FirstClassVarDeclArrayIdent FirstClassVarDeclArrayIdent);
    public void visit(FirstClassVarDeclIdentOnly FirstClassVarDeclIdentOnly);
    public void visit(FirstVarDeclArrayIdent FirstVarDeclArrayIdent);
    public void visit(FirstVarDeclIdentOnly FirstVarDeclIdentOnly);
    public void visit(GlobalVarDeclX GlobalVarDeclX);
    public void visit(ClassVarDeclError ClassVarDeclError);
    public void visit(ClassVarDeclX ClassVarDeclX);
    public void visit(VarDeclX VarDeclX);
    public void visit(ConstTailError ConstTailError);
    public void visit(ConstTailX ConstTailX);
    public void visit(NoOtherConstList NoOtherConstList);
    public void visit(OtherConstListX OtherConstListX);
    public void visit(FirstConstBool FirstConstBool);
    public void visit(FirstConstChar FirstConstChar);
    public void visit(FirstConstNum FirstConstNum);
    public void visit(ConstDeclError ConstDeclError);
    public void visit(ConstDeclX ConstDeclX);
    public void visit(NoMethodDeclList NoMethodDeclList);
    public void visit(MethodDeclListX MethodDeclListX);
    public void visit(NoConstDeclList NoConstDeclList);
    public void visit(ConstDeclListClass ConstDeclListClass);
    public void visit(ConstDeclListVar ConstDeclListVar);
    public void visit(ConstDeclListConst ConstDeclListConst);
    public void visit(ProgName ProgName);
    public void visit(Program Program);

}
