// Generated from /home/sang/Workspace/panda/panda/panda/Panda.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PandaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, Auto=9, 
		Bool=10, Break=11, Byte=12, Case=13, Catch=14, Class=15, Const=16, Continue=17, 
		Default=18, Double=19, Else=20, Enum=21, F32=22, F64=23, False=24, Float=25, 
		For=26, If=27, Int=28, Int8=29, Int16=30, Int32=31, Int64=32, Long=33, 
		Namespace=34, New=35, Null=36, Operator=37, Private=38, Protected=39, 
		Public=40, Return=41, Static=42, Short=43, Switch=44, This=45, Throw=46, 
		True=47, Try=48, Uint=49, Uint8=50, Uint16=51, Uint32=52, Uint64=53, Ulong=54, 
		Ushort=55, Using=56, Void=57, While=58, LeftParen=59, RightParen=60, LeftBracket=61, 
		RightBracket=62, LeftBrace=63, RightBrace=64, Plus=65, Minus=66, Star=67, 
		Div=68, Mod=69, Caret=70, And=71, Or=72, Tilde=73, Not=74, Assign=75, 
		Less=76, Greater=77, PlusAssign=78, MinusAssign=79, DivAssign=80, ModAssign=81, 
		XorAssign=82, AndAssign=83, OrAssign=84, LeftShift=85, RightShift=86, 
		LeftShiftAssign=87, RightShiftAssign=88, Equal=89, NotEqual=90, LessEqual=91, 
		GreaterEqual=92, AndAnd=93, OrOr=94, PlusPlus=95, MinusMinus=96, Comma=97, 
		Question=98, Colon=99, Semi=100, Dot=101, Ellipsis=102, Identifier=103, 
		IntegerLiteral=104, DecimalLiteral=105, OctalLiteral=106, HexadecimalLiteral=107, 
		BinaryLiteral=108, FloatLiteral=109, StringLiteral=110, BooleanLiteral=111, 
		PointerLiteral=112, Whitespace=113, Newline=114, BlockComment=115, LineComment=116;
	public static final int
		RULE_translation_unit = 0, RULE_primary_expression = 1, RULE_id_expression = 2, 
		RULE_unqualified_id = 3, RULE_qualified_id = 4, RULE_nested_name_specifier = 5, 
		RULE_lambda_expression = 6, RULE_lambda_declarator = 7, RULE_post_fix_expression = 8, 
		RULE_expression_list = 9, RULE_unary_expression = 10, RULE_unary_operator = 11, 
		RULE_new_expression = 12, RULE_new_initializer = 13, RULE_cast_expression = 14, 
		RULE_pmexpression = 15, RULE_multiplicativeexpression = 16, RULE_additiveexpression = 17, 
		RULE_shiftexpression = 18, RULE_shiftoperator = 19, RULE_relationalexpression = 20, 
		RULE_equalityexpression = 21, RULE_andexpression = 22, RULE_exclusiveorexpression = 23, 
		RULE_inclusiveorexpression = 24, RULE_logicalandexpression = 25, RULE_logicalorexpression = 26, 
		RULE_conditionalexpression = 27, RULE_assignment_expression = 28, RULE_assignmentoperator = 29, 
		RULE_expression = 30, RULE_constantexpression = 31, RULE_statement = 32, 
		RULE_labeledstatement = 33, RULE_expressionstatement = 34, RULE_compound_statement = 35, 
		RULE_statementseq = 36, RULE_selectionstatement = 37, RULE_condition = 38, 
		RULE_iterationstatement = 39, RULE_forinitstatement = 40, RULE_forrangedeclaration = 41, 
		RULE_forrangeinitializer = 42, RULE_jumpstatement = 43, RULE_declarationstatement = 44, 
		RULE_declaration_sequence = 45, RULE_declaration = 46, RULE_blockdeclaration = 47, 
		RULE_aliasdeclaration = 48, RULE_simpledeclaration = 49, RULE_emptydeclaration = 50, 
		RULE_attributedeclaration = 51, RULE_declspecifier = 52, RULE_declspecifierseq = 53, 
		RULE_storageclass_specifier = 54, RULE_typedef_name = 55, RULE_typespecifier = 56, 
		RULE_trailing_type_specifier = 57, RULE_type_specifier_sequence = 58, 
		RULE_trailing_type_specifier_sequence = 59, RULE_simple_type_specifier = 60, 
		RULE_type_name = 61, RULE_elaboratedtypespecifier = 62, RULE_enum_name = 63, 
		RULE_enum_specifier = 64, RULE_enumhead = 65, RULE_opaqueenumdeclaration = 66, 
		RULE_enumkey = 67, RULE_enumbase = 68, RULE_enumeratorlist = 69, RULE_enumeratordefinition = 70, 
		RULE_enumerator = 71, RULE_namespace_name = 72, RULE_originalnamespace_name = 73, 
		RULE_namespacedefinition = 74, RULE_namednamespacedefinition = 75, RULE_originalnamespacedefinition = 76, 
		RULE_extensionnamespacedefinition = 77, RULE_unnamednamespacedefinition = 78, 
		RULE_namespacebody = 79, RULE_namespacealias = 80, RULE_namespacealiasdefinition = 81, 
		RULE_qualifiednamespacespecifier = 82, RULE_usingdeclaration = 83, RULE_usingdirective = 84, 
		RULE_attribute_specifier_sequence = 85, RULE_attributespecifier = 86, 
		RULE_attributelist = 87, RULE_attribute = 88, RULE_attributetoken = 89, 
		RULE_attributescopedtoken = 90, RULE_attributenamespace = 91, RULE_attributeargumentclause = 92, 
		RULE_balancedtokenseq = 93, RULE_balancedtoken = 94, RULE_initdeclaratorlist = 95, 
		RULE_initdeclarator = 96, RULE_declarator = 97, RULE_ptrdeclarator = 98, 
		RULE_noptrdeclarator = 99, RULE_parametersandqualifiers = 100, RULE_trailing_return_type = 101, 
		RULE_reference_operator = 102, RULE_refqualifier = 103, RULE_declaratorid = 104, 
		RULE_type_id = 105, RULE_abstract_declarator = 106, RULE_ptrabstract_declarator = 107, 
		RULE_noptrabstract_declarator = 108, RULE_abstractpackdeclarator = 109, 
		RULE_noptrabstractpackdeclarator = 110, RULE_parameter_declaration_clause = 111, 
		RULE_parameterdeclarationlist = 112, RULE_parameterdeclaration = 113, 
		RULE_functiondefinition = 114, RULE_functionbody = 115, RULE_initializer = 116, 
		RULE_braceorequalinitializer = 117, RULE_initializerclause = 118, RULE_initializer_list = 119, 
		RULE_braced_init_list = 120, RULE_class_name = 121, RULE_class_specifier = 122, 
		RULE_classhead = 123, RULE_classheadname = 124, RULE_memberspecification = 125, 
		RULE_memberdeclaration = 126, RULE_memberdeclaratorlist = 127, RULE_memberdeclarator = 128, 
		RULE_purespecifier = 129, RULE_baseclause = 130, RULE_basespecifierlist = 131, 
		RULE_basespecifier = 132, RULE_classordecltype = 133, RULE_basetypespecifier = 134, 
		RULE_accessspecifier = 135, RULE_conversion_function_id = 136, RULE_conversiontypeid = 137, 
		RULE_conversiondeclarator = 138, RULE_ctorinitializer = 139, RULE_meminitializerlist = 140, 
		RULE_meminitializer = 141, RULE_meminitializerid = 142, RULE_operator_function_id = 143, 
		RULE_literal_operator_id = 144, RULE_templateparameterlist = 145, RULE_templateparameter = 146, 
		RULE_typeparameter = 147, RULE_simple_template_id = 148, RULE_template_id = 149, 
		RULE_templatename = 150, RULE_templateargumentlist = 151, RULE_templateargument = 152, 
		RULE_type_name_specifier = 153, RULE_tryblock = 154, RULE_functiontryblock = 155, 
		RULE_handler_sequence = 156, RULE_handler = 157, RULE_exception_declaration = 158, 
		RULE_throw_expression = 159, RULE_exception_specification = 160, RULE_type_id_list = 161, 
		RULE_operator = 162, RULE_literal = 163;
	public static final String[] ruleNames = {
		"translation_unit", "primary_expression", "id_expression", "unqualified_id", 
		"qualified_id", "nested_name_specifier", "lambda_expression", "lambda_declarator", 
		"post_fix_expression", "expression_list", "unary_expression", "unary_operator", 
		"new_expression", "new_initializer", "cast_expression", "pmexpression", 
		"multiplicativeexpression", "additiveexpression", "shiftexpression", "shiftoperator", 
		"relationalexpression", "equalityexpression", "andexpression", "exclusiveorexpression", 
		"inclusiveorexpression", "logicalandexpression", "logicalorexpression", 
		"conditionalexpression", "assignment_expression", "assignmentoperator", 
		"expression", "constantexpression", "statement", "labeledstatement", "expressionstatement", 
		"compound_statement", "statementseq", "selectionstatement", "condition", 
		"iterationstatement", "forinitstatement", "forrangedeclaration", "forrangeinitializer", 
		"jumpstatement", "declarationstatement", "declaration_sequence", "declaration", 
		"blockdeclaration", "aliasdeclaration", "simpledeclaration", "emptydeclaration", 
		"attributedeclaration", "declspecifier", "declspecifierseq", "storageclass_specifier", 
		"typedef_name", "typespecifier", "trailing_type_specifier", "type_specifier_sequence", 
		"trailing_type_specifier_sequence", "simple_type_specifier", "type_name", 
		"elaboratedtypespecifier", "enum_name", "enum_specifier", "enumhead", 
		"opaqueenumdeclaration", "enumkey", "enumbase", "enumeratorlist", "enumeratordefinition", 
		"enumerator", "namespace_name", "originalnamespace_name", "namespacedefinition", 
		"namednamespacedefinition", "originalnamespacedefinition", "extensionnamespacedefinition", 
		"unnamednamespacedefinition", "namespacebody", "namespacealias", "namespacealiasdefinition", 
		"qualifiednamespacespecifier", "usingdeclaration", "usingdirective", "attribute_specifier_sequence", 
		"attributespecifier", "attributelist", "attribute", "attributetoken", 
		"attributescopedtoken", "attributenamespace", "attributeargumentclause", 
		"balancedtokenseq", "balancedtoken", "initdeclaratorlist", "initdeclarator", 
		"declarator", "ptrdeclarator", "noptrdeclarator", "parametersandqualifiers", 
		"trailing_return_type", "reference_operator", "refqualifier", "declaratorid", 
		"type_id", "abstract_declarator", "ptrabstract_declarator", "noptrabstract_declarator", 
		"abstractpackdeclarator", "noptrabstractpackdeclarator", "parameter_declaration_clause", 
		"parameterdeclarationlist", "parameterdeclaration", "functiondefinition", 
		"functionbody", "initializer", "braceorequalinitializer", "initializerclause", 
		"initializer_list", "braced_init_list", "class_name", "class_specifier", 
		"classhead", "classheadname", "memberspecification", "memberdeclaration", 
		"memberdeclaratorlist", "memberdeclarator", "purespecifier", "baseclause", 
		"basespecifierlist", "basespecifier", "classordecltype", "basetypespecifier", 
		"accessspecifier", "conversion_function_id", "conversiontypeid", "conversiondeclarator", 
		"ctorinitializer", "meminitializerlist", "meminitializer", "meminitializerid", 
		"operator_function_id", "literal_operator_id", "templateparameterlist", 
		"templateparameter", "typeparameter", "simple_template_id", "template_id", 
		"templatename", "templateargumentlist", "templateargument", "type_name_specifier", 
		"tryblock", "functiontryblock", "handler_sequence", "handler", "exception_declaration", 
		"throw_expression", "exception_specification", "type_id_list", "operator", 
		"literal"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.*'", "'->*'", "'and'", "'or'", "'*='", "'::'", "'->'", "'not'", 
		"'auto'", "'bool'", "'break'", "'byte'", "'case'", "'catch'", "'class'", 
		"'const'", "'continue'", "'default'", "'double'", "'else'", "'enum'", 
		"'f32'", "'f64'", "'false'", "'float'", "'for'", "'if'", "'int'", "'i8'", 
		"'i16'", "'i32'", "'i64'", "'long'", "'namespace'", "'new'", "'null'", 
		"'operator'", "'private'", "'protected'", "'public'", "'return'", "'static'", 
		"'short'", "'switch'", "'this'", "'throw'", "'true'", "'try'", "'uint'", 
		"'u8'", "'u16'", "'u32'", "'u64'", "'ulong'", "'ushort'", "'using'", "'void'", 
		"'while'", "'('", "')'", "'['", "']'", "'{'", "'}'", "'+'", "'-'", "'*'", 
		"'/'", "'%'", "'^'", "'&'", "'|'", "'~'", "'!'", "'='", "'<'", "'>'", 
		"'+='", "'-='", "'/='", "'%='", "'^='", "'&='", "'|='", "'<<'", "'>>'", 
		"'<<='", "'>>='", "'=='", "'!='", "'<='", "'>='", "'&&'", "'||'", "'++'", 
		"'--'", "','", "'?'", "':'", "';'", "'.'", "'...'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, "Auto", "Bool", 
		"Break", "Byte", "Case", "Catch", "Class", "Const", "Continue", "Default", 
		"Double", "Else", "Enum", "F32", "F64", "False", "Float", "For", "If", 
		"Int", "Int8", "Int16", "Int32", "Int64", "Long", "Namespace", "New", 
		"Null", "Operator", "Private", "Protected", "Public", "Return", "Static", 
		"Short", "Switch", "This", "Throw", "True", "Try", "Uint", "Uint8", "Uint16", 
		"Uint32", "Uint64", "Ulong", "Ushort", "Using", "Void", "While", "LeftParen", 
		"RightParen", "LeftBracket", "RightBracket", "LeftBrace", "RightBrace", 
		"Plus", "Minus", "Star", "Div", "Mod", "Caret", "And", "Or", "Tilde", 
		"Not", "Assign", "Less", "Greater", "PlusAssign", "MinusAssign", "DivAssign", 
		"ModAssign", "XorAssign", "AndAssign", "OrAssign", "LeftShift", "RightShift", 
		"LeftShiftAssign", "RightShiftAssign", "Equal", "NotEqual", "LessEqual", 
		"GreaterEqual", "AndAnd", "OrOr", "PlusPlus", "MinusMinus", "Comma", "Question", 
		"Colon", "Semi", "Dot", "Ellipsis", "Identifier", "IntegerLiteral", "DecimalLiteral", 
		"OctalLiteral", "HexadecimalLiteral", "BinaryLiteral", "FloatLiteral", 
		"StringLiteral", "BooleanLiteral", "PointerLiteral", "Whitespace", "Newline", 
		"BlockComment", "LineComment"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Panda.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PandaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class Translation_unitContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(PandaParser.EOF, 0); }
		public Declaration_sequenceContext declaration_sequence() {
			return getRuleContext(Declaration_sequenceContext.class,0);
		}
		public Translation_unitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_translation_unit; }
	}

	public final Translation_unitContext translation_unit() throws RecognitionException {
		Translation_unitContext _localctx = new Translation_unitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_translation_unit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Auto) | (1L << Bool) | (1L << Class) | (1L << Double) | (1L << Enum) | (1L << F32) | (1L << F64) | (1L << Float) | (1L << Int) | (1L << Int8) | (1L << Int16) | (1L << Int32) | (1L << Int64) | (1L << Long) | (1L << Namespace) | (1L << Operator) | (1L << Static) | (1L << Short) | (1L << Uint) | (1L << Uint8) | (1L << Uint16) | (1L << Uint32) | (1L << Uint64) | (1L << Ulong) | (1L << Ushort) | (1L << Using) | (1L << Void) | (1L << LeftParen) | (1L << LeftBracket))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (And - 71)) | (1L << (Semi - 71)) | (1L << (Dot - 71)) | (1L << (Ellipsis - 71)) | (1L << (Identifier - 71)))) != 0)) {
				{
				setState(328);
				declaration_sequence(0);
				}
			}

			setState(331);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Primary_expressionContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode This() { return getToken(PandaParser.This, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Id_expressionContext id_expression() {
			return getRuleContext(Id_expressionContext.class,0);
		}
		public Lambda_expressionContext lambda_expression() {
			return getRuleContext(Lambda_expressionContext.class,0);
		}
		public Primary_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary_expression; }
	}

	public final Primary_expressionContext primary_expression() throws RecognitionException {
		Primary_expressionContext _localctx = new Primary_expressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_primary_expression);
		try {
			setState(341);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(333);
				literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(334);
				match(This);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(335);
				match(LeftParen);
				setState(336);
				expression(0);
				setState(337);
				match(RightParen);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(339);
				id_expression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(340);
				lambda_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Id_expressionContext extends ParserRuleContext {
		public Unqualified_idContext unqualified_id() {
			return getRuleContext(Unqualified_idContext.class,0);
		}
		public Qualified_idContext qualified_id() {
			return getRuleContext(Qualified_idContext.class,0);
		}
		public Id_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id_expression; }
	}

	public final Id_expressionContext id_expression() throws RecognitionException {
		Id_expressionContext _localctx = new Id_expressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_id_expression);
		try {
			setState(345);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(343);
				unqualified_id();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(344);
				qualified_id();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unqualified_idContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PandaParser.Identifier, 0); }
		public Operator_function_idContext operator_function_id() {
			return getRuleContext(Operator_function_idContext.class,0);
		}
		public Conversion_function_idContext conversion_function_id() {
			return getRuleContext(Conversion_function_idContext.class,0);
		}
		public Literal_operator_idContext literal_operator_id() {
			return getRuleContext(Literal_operator_idContext.class,0);
		}
		public Template_idContext template_id() {
			return getRuleContext(Template_idContext.class,0);
		}
		public Unqualified_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unqualified_id; }
	}

	public final Unqualified_idContext unqualified_id() throws RecognitionException {
		Unqualified_idContext _localctx = new Unqualified_idContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_unqualified_id);
		try {
			setState(352);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(347);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(348);
				operator_function_id();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(349);
				conversion_function_id();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(350);
				literal_operator_id();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(351);
				template_id();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Qualified_idContext extends ParserRuleContext {
		public Nested_name_specifierContext nested_name_specifier() {
			return getRuleContext(Nested_name_specifierContext.class,0);
		}
		public Unqualified_idContext unqualified_id() {
			return getRuleContext(Unqualified_idContext.class,0);
		}
		public Qualified_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualified_id; }
	}

	public final Qualified_idContext qualified_id() throws RecognitionException {
		Qualified_idContext _localctx = new Qualified_idContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_qualified_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			nested_name_specifier(0);
			setState(355);
			unqualified_id();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Nested_name_specifierContext extends ParserRuleContext {
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
		public Namespace_nameContext namespace_name() {
			return getRuleContext(Namespace_nameContext.class,0);
		}
		public Nested_name_specifierContext nested_name_specifier() {
			return getRuleContext(Nested_name_specifierContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(PandaParser.Identifier, 0); }
		public Simple_template_idContext simple_template_id() {
			return getRuleContext(Simple_template_idContext.class,0);
		}
		public Nested_name_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nested_name_specifier; }
	}

	public final Nested_name_specifierContext nested_name_specifier() throws RecognitionException {
		return nested_name_specifier(0);
	}

	private Nested_name_specifierContext nested_name_specifier(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Nested_name_specifierContext _localctx = new Nested_name_specifierContext(_ctx, _parentState);
		Nested_name_specifierContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_nested_name_specifier, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(358);
				match(Dot);
				}
				break;
			case 2:
				{
				setState(359);
				type_name();
				setState(360);
				match(Dot);
				}
				break;
			case 3:
				{
				setState(362);
				namespace_name();
				setState(363);
				match(Dot);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(376);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(374);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new Nested_name_specifierContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_nested_name_specifier);
						setState(367);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(368);
						match(Identifier);
						setState(369);
						match(Dot);
						}
						break;
					case 2:
						{
						_localctx = new Nested_name_specifierContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_nested_name_specifier);
						setState(370);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(371);
						simple_template_id();
						setState(372);
						match(Dot);
						}
						break;
					}
					} 
				}
				setState(378);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Lambda_expressionContext extends ParserRuleContext {
		public Compound_statementContext compound_statement() {
			return getRuleContext(Compound_statementContext.class,0);
		}
		public Lambda_declaratorContext lambda_declarator() {
			return getRuleContext(Lambda_declaratorContext.class,0);
		}
		public Lambda_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_expression; }
	}

	public final Lambda_expressionContext lambda_expression() throws RecognitionException {
		Lambda_expressionContext _localctx = new Lambda_expressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_lambda_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LeftParen) {
				{
				setState(379);
				lambda_declarator();
				}
			}

			setState(382);
			compound_statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Lambda_declaratorContext extends ParserRuleContext {
		public Parameter_declaration_clauseContext parameter_declaration_clause() {
			return getRuleContext(Parameter_declaration_clauseContext.class,0);
		}
		public Trailing_return_typeContext trailing_return_type() {
			return getRuleContext(Trailing_return_typeContext.class,0);
		}
		public Lambda_declaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_declarator; }
	}

	public final Lambda_declaratorContext lambda_declarator() throws RecognitionException {
		Lambda_declaratorContext _localctx = new Lambda_declaratorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_lambda_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384);
			match(LeftParen);
			setState(385);
			parameter_declaration_clause();
			setState(386);
			match(RightParen);
			setState(388);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(387);
				trailing_return_type();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Post_fix_expressionContext extends ParserRuleContext {
		public Primary_expressionContext primary_expression() {
			return getRuleContext(Primary_expressionContext.class,0);
		}
		public Simple_type_specifierContext simple_type_specifier() {
			return getRuleContext(Simple_type_specifierContext.class,0);
		}
		public Expression_listContext expression_list() {
			return getRuleContext(Expression_listContext.class,0);
		}
		public Type_name_specifierContext type_name_specifier() {
			return getRuleContext(Type_name_specifierContext.class,0);
		}
		public Braced_init_listContext braced_init_list() {
			return getRuleContext(Braced_init_listContext.class,0);
		}
		public Post_fix_expressionContext post_fix_expression() {
			return getRuleContext(Post_fix_expressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Id_expressionContext id_expression() {
			return getRuleContext(Id_expressionContext.class,0);
		}
		public Post_fix_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_post_fix_expression; }
	}

	public final Post_fix_expressionContext post_fix_expression() throws RecognitionException {
		return post_fix_expression(0);
	}

	private Post_fix_expressionContext post_fix_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Post_fix_expressionContext _localctx = new Post_fix_expressionContext(_ctx, _parentState);
		Post_fix_expressionContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_post_fix_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(412);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(391);
				primary_expression();
				}
				break;
			case 2:
				{
				setState(392);
				simple_type_specifier();
				setState(393);
				match(LeftParen);
				setState(395);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Auto) | (1L << Bool) | (1L << Double) | (1L << F32) | (1L << F64) | (1L << Float) | (1L << Int) | (1L << Int8) | (1L << Int16) | (1L << Int32) | (1L << Int64) | (1L << Long) | (1L << New) | (1L << Operator) | (1L << Short) | (1L << This) | (1L << Throw) | (1L << Uint) | (1L << Uint8) | (1L << Uint16) | (1L << Uint32) | (1L << Uint64) | (1L << Ulong) | (1L << Ushort) | (1L << Void) | (1L << LeftParen) | (1L << LeftBrace))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (Plus - 65)) | (1L << (Minus - 65)) | (1L << (Or - 65)) | (1L << (Tilde - 65)) | (1L << (Not - 65)) | (1L << (PlusPlus - 65)) | (1L << (MinusMinus - 65)) | (1L << (Dot - 65)) | (1L << (Identifier - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (PointerLiteral - 65)))) != 0)) {
					{
					setState(394);
					expression_list();
					}
				}

				setState(397);
				match(RightParen);
				}
				break;
			case 3:
				{
				setState(399);
				type_name_specifier();
				setState(400);
				match(LeftParen);
				setState(402);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Auto) | (1L << Bool) | (1L << Double) | (1L << F32) | (1L << F64) | (1L << Float) | (1L << Int) | (1L << Int8) | (1L << Int16) | (1L << Int32) | (1L << Int64) | (1L << Long) | (1L << New) | (1L << Operator) | (1L << Short) | (1L << This) | (1L << Throw) | (1L << Uint) | (1L << Uint8) | (1L << Uint16) | (1L << Uint32) | (1L << Uint64) | (1L << Ulong) | (1L << Ushort) | (1L << Void) | (1L << LeftParen) | (1L << LeftBrace))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (Plus - 65)) | (1L << (Minus - 65)) | (1L << (Or - 65)) | (1L << (Tilde - 65)) | (1L << (Not - 65)) | (1L << (PlusPlus - 65)) | (1L << (MinusMinus - 65)) | (1L << (Dot - 65)) | (1L << (Identifier - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (PointerLiteral - 65)))) != 0)) {
					{
					setState(401);
					expression_list();
					}
				}

				setState(404);
				match(RightParen);
				}
				break;
			case 4:
				{
				setState(406);
				simple_type_specifier();
				setState(407);
				braced_init_list();
				}
				break;
			case 5:
				{
				setState(409);
				type_name_specifier();
				setState(410);
				braced_init_list();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(439);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(437);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new Post_fix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_post_fix_expression);
						setState(414);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(415);
						match(LeftBracket);
						setState(416);
						expression(0);
						setState(417);
						match(RightBracket);
						}
						break;
					case 2:
						{
						_localctx = new Post_fix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_post_fix_expression);
						setState(419);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(420);
						match(LeftBracket);
						setState(421);
						braced_init_list();
						setState(422);
						match(RightBracket);
						}
						break;
					case 3:
						{
						_localctx = new Post_fix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_post_fix_expression);
						setState(424);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(425);
						match(LeftParen);
						setState(427);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Auto) | (1L << Bool) | (1L << Double) | (1L << F32) | (1L << F64) | (1L << Float) | (1L << Int) | (1L << Int8) | (1L << Int16) | (1L << Int32) | (1L << Int64) | (1L << Long) | (1L << New) | (1L << Operator) | (1L << Short) | (1L << This) | (1L << Throw) | (1L << Uint) | (1L << Uint8) | (1L << Uint16) | (1L << Uint32) | (1L << Uint64) | (1L << Ulong) | (1L << Ushort) | (1L << Void) | (1L << LeftParen) | (1L << LeftBrace))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (Plus - 65)) | (1L << (Minus - 65)) | (1L << (Or - 65)) | (1L << (Tilde - 65)) | (1L << (Not - 65)) | (1L << (PlusPlus - 65)) | (1L << (MinusMinus - 65)) | (1L << (Dot - 65)) | (1L << (Identifier - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (PointerLiteral - 65)))) != 0)) {
							{
							setState(426);
							expression_list();
							}
						}

						setState(429);
						match(RightParen);
						}
						break;
					case 4:
						{
						_localctx = new Post_fix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_post_fix_expression);
						setState(430);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(431);
						match(Dot);
						setState(432);
						id_expression();
						}
						break;
					case 5:
						{
						_localctx = new Post_fix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_post_fix_expression);
						setState(433);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(434);
						match(PlusPlus);
						}
						break;
					case 6:
						{
						_localctx = new Post_fix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_post_fix_expression);
						setState(435);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(436);
						match(MinusMinus);
						}
						break;
					}
					} 
				}
				setState(441);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Expression_listContext extends ParserRuleContext {
		public Initializer_listContext initializer_list() {
			return getRuleContext(Initializer_listContext.class,0);
		}
		public Expression_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression_list; }
	}

	public final Expression_listContext expression_list() throws RecognitionException {
		Expression_listContext _localctx = new Expression_listContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expression_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(442);
			initializer_list(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unary_expressionContext extends ParserRuleContext {
		public Post_fix_expressionContext post_fix_expression() {
			return getRuleContext(Post_fix_expressionContext.class,0);
		}
		public Cast_expressionContext cast_expression() {
			return getRuleContext(Cast_expressionContext.class,0);
		}
		public Unary_operatorContext unary_operator() {
			return getRuleContext(Unary_operatorContext.class,0);
		}
		public New_expressionContext new_expression() {
			return getRuleContext(New_expressionContext.class,0);
		}
		public Unary_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_expression; }
	}

	public final Unary_expressionContext unary_expression() throws RecognitionException {
		Unary_expressionContext _localctx = new Unary_expressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_unary_expression);
		try {
			setState(453);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Auto:
			case Bool:
			case Double:
			case F32:
			case F64:
			case Float:
			case Int:
			case Int8:
			case Int16:
			case Int32:
			case Int64:
			case Long:
			case Operator:
			case Short:
			case This:
			case Uint:
			case Uint8:
			case Uint16:
			case Uint32:
			case Uint64:
			case Ulong:
			case Ushort:
			case Void:
			case LeftParen:
			case LeftBrace:
			case Dot:
			case Identifier:
			case IntegerLiteral:
			case FloatLiteral:
			case StringLiteral:
			case BooleanLiteral:
			case PointerLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(444);
				post_fix_expression(0);
				}
				break;
			case PlusPlus:
				enterOuterAlt(_localctx, 2);
				{
				setState(445);
				match(PlusPlus);
				setState(446);
				cast_expression();
				}
				break;
			case MinusMinus:
				enterOuterAlt(_localctx, 3);
				{
				setState(447);
				match(MinusMinus);
				setState(448);
				cast_expression();
				}
				break;
			case Plus:
			case Minus:
			case Or:
			case Tilde:
			case Not:
				enterOuterAlt(_localctx, 4);
				{
				setState(449);
				unary_operator();
				setState(450);
				cast_expression();
				}
				break;
			case New:
				enterOuterAlt(_localctx, 5);
				{
				setState(452);
				new_expression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unary_operatorContext extends ParserRuleContext {
		public Unary_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_operator; }
	}

	public final Unary_operatorContext unary_operator() throws RecognitionException {
		Unary_operatorContext _localctx = new Unary_operatorContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(455);
			_la = _input.LA(1);
			if ( !(((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (Plus - 65)) | (1L << (Minus - 65)) | (1L << (Or - 65)) | (1L << (Tilde - 65)) | (1L << (Not - 65)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class New_expressionContext extends ParserRuleContext {
		public TerminalNode New() { return getToken(PandaParser.New, 0); }
		public Type_specifier_sequenceContext type_specifier_sequence() {
			return getRuleContext(Type_specifier_sequenceContext.class,0);
		}
		public New_initializerContext new_initializer() {
			return getRuleContext(New_initializerContext.class,0);
		}
		public New_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_new_expression; }
	}

	public final New_expressionContext new_expression() throws RecognitionException {
		New_expressionContext _localctx = new New_expressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_new_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(457);
			match(New);
			setState(458);
			type_specifier_sequence();
			setState(459);
			new_initializer();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class New_initializerContext extends ParserRuleContext {
		public Expression_listContext expression_list() {
			return getRuleContext(Expression_listContext.class,0);
		}
		public Braced_init_listContext braced_init_list() {
			return getRuleContext(Braced_init_listContext.class,0);
		}
		public New_initializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_new_initializer; }
	}

	public final New_initializerContext new_initializer() throws RecognitionException {
		New_initializerContext _localctx = new New_initializerContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_new_initializer);
		int _la;
		try {
			setState(467);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftParen:
				enterOuterAlt(_localctx, 1);
				{
				setState(461);
				match(LeftParen);
				setState(463);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Auto) | (1L << Bool) | (1L << Double) | (1L << F32) | (1L << F64) | (1L << Float) | (1L << Int) | (1L << Int8) | (1L << Int16) | (1L << Int32) | (1L << Int64) | (1L << Long) | (1L << New) | (1L << Operator) | (1L << Short) | (1L << This) | (1L << Throw) | (1L << Uint) | (1L << Uint8) | (1L << Uint16) | (1L << Uint32) | (1L << Uint64) | (1L << Ulong) | (1L << Ushort) | (1L << Void) | (1L << LeftParen) | (1L << LeftBrace))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (Plus - 65)) | (1L << (Minus - 65)) | (1L << (Or - 65)) | (1L << (Tilde - 65)) | (1L << (Not - 65)) | (1L << (PlusPlus - 65)) | (1L << (MinusMinus - 65)) | (1L << (Dot - 65)) | (1L << (Identifier - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (PointerLiteral - 65)))) != 0)) {
					{
					setState(462);
					expression_list();
					}
				}

				setState(465);
				match(RightParen);
				}
				break;
			case LeftBrace:
				enterOuterAlt(_localctx, 2);
				{
				setState(466);
				braced_init_list();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Cast_expressionContext extends ParserRuleContext {
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public Type_idContext type_id() {
			return getRuleContext(Type_idContext.class,0);
		}
		public Cast_expressionContext cast_expression() {
			return getRuleContext(Cast_expressionContext.class,0);
		}
		public Cast_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cast_expression; }
	}

	public final Cast_expressionContext cast_expression() throws RecognitionException {
		Cast_expressionContext _localctx = new Cast_expressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_cast_expression);
		try {
			setState(475);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(469);
				unary_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(470);
				match(LeftParen);
				setState(471);
				type_id();
				setState(472);
				match(RightParen);
				setState(473);
				cast_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PmexpressionContext extends ParserRuleContext {
		public Cast_expressionContext cast_expression() {
			return getRuleContext(Cast_expressionContext.class,0);
		}
		public PmexpressionContext pmexpression() {
			return getRuleContext(PmexpressionContext.class,0);
		}
		public PmexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pmexpression; }
	}

	public final PmexpressionContext pmexpression() throws RecognitionException {
		return pmexpression(0);
	}

	private PmexpressionContext pmexpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PmexpressionContext _localctx = new PmexpressionContext(_ctx, _parentState);
		PmexpressionContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_pmexpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(478);
			cast_expression();
			}
			_ctx.stop = _input.LT(-1);
			setState(488);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(486);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new PmexpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_pmexpression);
						setState(480);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(481);
						match(T__0);
						setState(482);
						cast_expression();
						}
						break;
					case 2:
						{
						_localctx = new PmexpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_pmexpression);
						setState(483);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(484);
						match(T__1);
						setState(485);
						cast_expression();
						}
						break;
					}
					} 
				}
				setState(490);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MultiplicativeexpressionContext extends ParserRuleContext {
		public PmexpressionContext pmexpression() {
			return getRuleContext(PmexpressionContext.class,0);
		}
		public MultiplicativeexpressionContext multiplicativeexpression() {
			return getRuleContext(MultiplicativeexpressionContext.class,0);
		}
		public MultiplicativeexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeexpression; }
	}

	public final MultiplicativeexpressionContext multiplicativeexpression() throws RecognitionException {
		return multiplicativeexpression(0);
	}

	private MultiplicativeexpressionContext multiplicativeexpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MultiplicativeexpressionContext _localctx = new MultiplicativeexpressionContext(_ctx, _parentState);
		MultiplicativeexpressionContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_multiplicativeexpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(492);
			pmexpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(505);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(503);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicativeexpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeexpression);
						setState(494);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(495);
						match(Star);
						setState(496);
						pmexpression(0);
						}
						break;
					case 2:
						{
						_localctx = new MultiplicativeexpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeexpression);
						setState(497);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(498);
						match(Div);
						setState(499);
						pmexpression(0);
						}
						break;
					case 3:
						{
						_localctx = new MultiplicativeexpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeexpression);
						setState(500);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(501);
						match(Mod);
						setState(502);
						pmexpression(0);
						}
						break;
					}
					} 
				}
				setState(507);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AdditiveexpressionContext extends ParserRuleContext {
		public MultiplicativeexpressionContext multiplicativeexpression() {
			return getRuleContext(MultiplicativeexpressionContext.class,0);
		}
		public AdditiveexpressionContext additiveexpression() {
			return getRuleContext(AdditiveexpressionContext.class,0);
		}
		public AdditiveexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveexpression; }
	}

	public final AdditiveexpressionContext additiveexpression() throws RecognitionException {
		return additiveexpression(0);
	}

	private AdditiveexpressionContext additiveexpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AdditiveexpressionContext _localctx = new AdditiveexpressionContext(_ctx, _parentState);
		AdditiveexpressionContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_additiveexpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(509);
			multiplicativeexpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(519);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(517);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
					case 1:
						{
						_localctx = new AdditiveexpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_additiveexpression);
						setState(511);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(512);
						match(Plus);
						setState(513);
						multiplicativeexpression(0);
						}
						break;
					case 2:
						{
						_localctx = new AdditiveexpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_additiveexpression);
						setState(514);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(515);
						match(Minus);
						setState(516);
						multiplicativeexpression(0);
						}
						break;
					}
					} 
				}
				setState(521);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ShiftexpressionContext extends ParserRuleContext {
		public AdditiveexpressionContext additiveexpression() {
			return getRuleContext(AdditiveexpressionContext.class,0);
		}
		public ShiftexpressionContext shiftexpression() {
			return getRuleContext(ShiftexpressionContext.class,0);
		}
		public ShiftoperatorContext shiftoperator() {
			return getRuleContext(ShiftoperatorContext.class,0);
		}
		public ShiftexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shiftexpression; }
	}

	public final ShiftexpressionContext shiftexpression() throws RecognitionException {
		return shiftexpression(0);
	}

	private ShiftexpressionContext shiftexpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ShiftexpressionContext _localctx = new ShiftexpressionContext(_ctx, _parentState);
		ShiftexpressionContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_shiftexpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(523);
			additiveexpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(531);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ShiftexpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_shiftexpression);
					setState(525);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(526);
					shiftoperator();
					setState(527);
					additiveexpression(0);
					}
					} 
				}
				setState(533);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ShiftoperatorContext extends ParserRuleContext {
		public TerminalNode RightShift() { return getToken(PandaParser.RightShift, 0); }
		public TerminalNode LeftShift() { return getToken(PandaParser.LeftShift, 0); }
		public ShiftoperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shiftoperator; }
	}

	public final ShiftoperatorContext shiftoperator() throws RecognitionException {
		ShiftoperatorContext _localctx = new ShiftoperatorContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_shiftoperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(534);
			_la = _input.LA(1);
			if ( !(_la==LeftShift || _la==RightShift) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationalexpressionContext extends ParserRuleContext {
		public ShiftexpressionContext shiftexpression() {
			return getRuleContext(ShiftexpressionContext.class,0);
		}
		public RelationalexpressionContext relationalexpression() {
			return getRuleContext(RelationalexpressionContext.class,0);
		}
		public RelationalexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalexpression; }
	}

	public final RelationalexpressionContext relationalexpression() throws RecognitionException {
		return relationalexpression(0);
	}

	private RelationalexpressionContext relationalexpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RelationalexpressionContext _localctx = new RelationalexpressionContext(_ctx, _parentState);
		RelationalexpressionContext _prevctx = _localctx;
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_relationalexpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(537);
			shiftexpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(553);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(551);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
					case 1:
						{
						_localctx = new RelationalexpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relationalexpression);
						setState(539);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(540);
						match(Less);
						setState(541);
						shiftexpression(0);
						}
						break;
					case 2:
						{
						_localctx = new RelationalexpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relationalexpression);
						setState(542);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(543);
						match(Greater);
						setState(544);
						shiftexpression(0);
						}
						break;
					case 3:
						{
						_localctx = new RelationalexpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relationalexpression);
						setState(545);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(546);
						match(LessEqual);
						setState(547);
						shiftexpression(0);
						}
						break;
					case 4:
						{
						_localctx = new RelationalexpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relationalexpression);
						setState(548);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(549);
						match(GreaterEqual);
						setState(550);
						shiftexpression(0);
						}
						break;
					}
					} 
				}
				setState(555);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class EqualityexpressionContext extends ParserRuleContext {
		public RelationalexpressionContext relationalexpression() {
			return getRuleContext(RelationalexpressionContext.class,0);
		}
		public EqualityexpressionContext equalityexpression() {
			return getRuleContext(EqualityexpressionContext.class,0);
		}
		public EqualityexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityexpression; }
	}

	public final EqualityexpressionContext equalityexpression() throws RecognitionException {
		return equalityexpression(0);
	}

	private EqualityexpressionContext equalityexpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EqualityexpressionContext _localctx = new EqualityexpressionContext(_ctx, _parentState);
		EqualityexpressionContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_equalityexpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(557);
			relationalexpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(567);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(565);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
					case 1:
						{
						_localctx = new EqualityexpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_equalityexpression);
						setState(559);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(560);
						match(Equal);
						setState(561);
						relationalexpression(0);
						}
						break;
					case 2:
						{
						_localctx = new EqualityexpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_equalityexpression);
						setState(562);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(563);
						match(NotEqual);
						setState(564);
						relationalexpression(0);
						}
						break;
					}
					} 
				}
				setState(569);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AndexpressionContext extends ParserRuleContext {
		public EqualityexpressionContext equalityexpression() {
			return getRuleContext(EqualityexpressionContext.class,0);
		}
		public AndexpressionContext andexpression() {
			return getRuleContext(AndexpressionContext.class,0);
		}
		public AndexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andexpression; }
	}

	public final AndexpressionContext andexpression() throws RecognitionException {
		return andexpression(0);
	}

	private AndexpressionContext andexpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AndexpressionContext _localctx = new AndexpressionContext(_ctx, _parentState);
		AndexpressionContext _prevctx = _localctx;
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_andexpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(571);
			equalityexpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(578);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AndexpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_andexpression);
					setState(573);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(574);
					match(And);
					setState(575);
					equalityexpression(0);
					}
					} 
				}
				setState(580);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExclusiveorexpressionContext extends ParserRuleContext {
		public AndexpressionContext andexpression() {
			return getRuleContext(AndexpressionContext.class,0);
		}
		public ExclusiveorexpressionContext exclusiveorexpression() {
			return getRuleContext(ExclusiveorexpressionContext.class,0);
		}
		public ExclusiveorexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exclusiveorexpression; }
	}

	public final ExclusiveorexpressionContext exclusiveorexpression() throws RecognitionException {
		return exclusiveorexpression(0);
	}

	private ExclusiveorexpressionContext exclusiveorexpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExclusiveorexpressionContext _localctx = new ExclusiveorexpressionContext(_ctx, _parentState);
		ExclusiveorexpressionContext _prevctx = _localctx;
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_exclusiveorexpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(582);
			andexpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(589);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExclusiveorexpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_exclusiveorexpression);
					setState(584);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(585);
					match(Caret);
					setState(586);
					andexpression(0);
					}
					} 
				}
				setState(591);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class InclusiveorexpressionContext extends ParserRuleContext {
		public ExclusiveorexpressionContext exclusiveorexpression() {
			return getRuleContext(ExclusiveorexpressionContext.class,0);
		}
		public InclusiveorexpressionContext inclusiveorexpression() {
			return getRuleContext(InclusiveorexpressionContext.class,0);
		}
		public InclusiveorexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inclusiveorexpression; }
	}

	public final InclusiveorexpressionContext inclusiveorexpression() throws RecognitionException {
		return inclusiveorexpression(0);
	}

	private InclusiveorexpressionContext inclusiveorexpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		InclusiveorexpressionContext _localctx = new InclusiveorexpressionContext(_ctx, _parentState);
		InclusiveorexpressionContext _prevctx = _localctx;
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_inclusiveorexpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(593);
			exclusiveorexpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(600);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new InclusiveorexpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_inclusiveorexpression);
					setState(595);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(596);
					match(Or);
					setState(597);
					exclusiveorexpression(0);
					}
					} 
				}
				setState(602);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LogicalandexpressionContext extends ParserRuleContext {
		public InclusiveorexpressionContext inclusiveorexpression() {
			return getRuleContext(InclusiveorexpressionContext.class,0);
		}
		public LogicalandexpressionContext logicalandexpression() {
			return getRuleContext(LogicalandexpressionContext.class,0);
		}
		public LogicalandexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalandexpression; }
	}

	public final LogicalandexpressionContext logicalandexpression() throws RecognitionException {
		return logicalandexpression(0);
	}

	private LogicalandexpressionContext logicalandexpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogicalandexpressionContext _localctx = new LogicalandexpressionContext(_ctx, _parentState);
		LogicalandexpressionContext _prevctx = _localctx;
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_logicalandexpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(604);
			inclusiveorexpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(614);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(612);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						_localctx = new LogicalandexpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_logicalandexpression);
						setState(606);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(607);
						match(AndAnd);
						setState(608);
						inclusiveorexpression(0);
						}
						break;
					case 2:
						{
						_localctx = new LogicalandexpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_logicalandexpression);
						setState(609);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(610);
						match(T__2);
						setState(611);
						inclusiveorexpression(0);
						}
						break;
					}
					} 
				}
				setState(616);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LogicalorexpressionContext extends ParserRuleContext {
		public LogicalandexpressionContext logicalandexpression() {
			return getRuleContext(LogicalandexpressionContext.class,0);
		}
		public LogicalorexpressionContext logicalorexpression() {
			return getRuleContext(LogicalorexpressionContext.class,0);
		}
		public LogicalorexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalorexpression; }
	}

	public final LogicalorexpressionContext logicalorexpression() throws RecognitionException {
		return logicalorexpression(0);
	}

	private LogicalorexpressionContext logicalorexpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogicalorexpressionContext _localctx = new LogicalorexpressionContext(_ctx, _parentState);
		LogicalorexpressionContext _prevctx = _localctx;
		int _startState = 52;
		enterRecursionRule(_localctx, 52, RULE_logicalorexpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(618);
			logicalandexpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(628);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(626);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
					case 1:
						{
						_localctx = new LogicalorexpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_logicalorexpression);
						setState(620);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(621);
						match(OrOr);
						setState(622);
						logicalandexpression(0);
						}
						break;
					case 2:
						{
						_localctx = new LogicalorexpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_logicalorexpression);
						setState(623);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(624);
						match(T__3);
						setState(625);
						logicalandexpression(0);
						}
						break;
					}
					} 
				}
				setState(630);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ConditionalexpressionContext extends ParserRuleContext {
		public LogicalorexpressionContext logicalorexpression() {
			return getRuleContext(LogicalorexpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Assignment_expressionContext assignment_expression() {
			return getRuleContext(Assignment_expressionContext.class,0);
		}
		public ConditionalexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalexpression; }
	}

	public final ConditionalexpressionContext conditionalexpression() throws RecognitionException {
		ConditionalexpressionContext _localctx = new ConditionalexpressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_conditionalexpression);
		try {
			setState(638);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(631);
				logicalorexpression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(632);
				logicalorexpression(0);
				setState(633);
				match(Question);
				setState(634);
				expression(0);
				setState(635);
				match(Colon);
				setState(636);
				assignment_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assignment_expressionContext extends ParserRuleContext {
		public ConditionalexpressionContext conditionalexpression() {
			return getRuleContext(ConditionalexpressionContext.class,0);
		}
		public LogicalorexpressionContext logicalorexpression() {
			return getRuleContext(LogicalorexpressionContext.class,0);
		}
		public AssignmentoperatorContext assignmentoperator() {
			return getRuleContext(AssignmentoperatorContext.class,0);
		}
		public InitializerclauseContext initializerclause() {
			return getRuleContext(InitializerclauseContext.class,0);
		}
		public Throw_expressionContext throw_expression() {
			return getRuleContext(Throw_expressionContext.class,0);
		}
		public Assignment_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment_expression; }
	}

	public final Assignment_expressionContext assignment_expression() throws RecognitionException {
		Assignment_expressionContext _localctx = new Assignment_expressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_assignment_expression);
		try {
			setState(646);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(640);
				conditionalexpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(641);
				logicalorexpression(0);
				setState(642);
				assignmentoperator();
				setState(643);
				initializerclause();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(645);
				throw_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentoperatorContext extends ParserRuleContext {
		public TerminalNode RightShiftAssign() { return getToken(PandaParser.RightShiftAssign, 0); }
		public TerminalNode LeftShiftAssign() { return getToken(PandaParser.LeftShiftAssign, 0); }
		public AssignmentoperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentoperator; }
	}

	public final AssignmentoperatorContext assignmentoperator() throws RecognitionException {
		AssignmentoperatorContext _localctx = new AssignmentoperatorContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_assignmentoperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(648);
			_la = _input.LA(1);
			if ( !(_la==T__4 || ((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & ((1L << (Assign - 75)) | (1L << (PlusAssign - 75)) | (1L << (MinusAssign - 75)) | (1L << (DivAssign - 75)) | (1L << (ModAssign - 75)) | (1L << (XorAssign - 75)) | (1L << (AndAssign - 75)) | (1L << (OrAssign - 75)) | (1L << (LeftShiftAssign - 75)) | (1L << (RightShiftAssign - 75)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Assignment_expressionContext assignment_expression() {
			return getRuleContext(Assignment_expressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 60;
		enterRecursionRule(_localctx, 60, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(651);
			assignment_expression();
			}
			_ctx.stop = _input.LT(-1);
			setState(658);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(653);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(654);
					match(Comma);
					setState(655);
					assignment_expression();
					}
					} 
				}
				setState(660);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ConstantexpressionContext extends ParserRuleContext {
		public ConditionalexpressionContext conditionalexpression() {
			return getRuleContext(ConditionalexpressionContext.class,0);
		}
		public ConstantexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantexpression; }
	}

	public final ConstantexpressionContext constantexpression() throws RecognitionException {
		ConstantexpressionContext _localctx = new ConstantexpressionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_constantexpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(661);
			conditionalexpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public LabeledstatementContext labeledstatement() {
			return getRuleContext(LabeledstatementContext.class,0);
		}
		public ExpressionstatementContext expressionstatement() {
			return getRuleContext(ExpressionstatementContext.class,0);
		}
		public Attribute_specifier_sequenceContext attribute_specifier_sequence() {
			return getRuleContext(Attribute_specifier_sequenceContext.class,0);
		}
		public Compound_statementContext compound_statement() {
			return getRuleContext(Compound_statementContext.class,0);
		}
		public SelectionstatementContext selectionstatement() {
			return getRuleContext(SelectionstatementContext.class,0);
		}
		public IterationstatementContext iterationstatement() {
			return getRuleContext(IterationstatementContext.class,0);
		}
		public JumpstatementContext jumpstatement() {
			return getRuleContext(JumpstatementContext.class,0);
		}
		public DeclarationstatementContext declarationstatement() {
			return getRuleContext(DeclarationstatementContext.class,0);
		}
		public TryblockContext tryblock() {
			return getRuleContext(TryblockContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_statement);
		int _la;
		try {
			setState(689);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(663);
				labeledstatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(665);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftBracket) {
					{
					setState(664);
					attribute_specifier_sequence(0);
					}
				}

				setState(667);
				expressionstatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(669);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftBracket) {
					{
					setState(668);
					attribute_specifier_sequence(0);
					}
				}

				setState(671);
				compound_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(673);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftBracket) {
					{
					setState(672);
					attribute_specifier_sequence(0);
					}
				}

				setState(675);
				selectionstatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(677);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftBracket) {
					{
					setState(676);
					attribute_specifier_sequence(0);
					}
				}

				setState(679);
				iterationstatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(681);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftBracket) {
					{
					setState(680);
					attribute_specifier_sequence(0);
					}
				}

				setState(683);
				jumpstatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(684);
				declarationstatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(686);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftBracket) {
					{
					setState(685);
					attribute_specifier_sequence(0);
					}
				}

				setState(688);
				tryblock();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabeledstatementContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PandaParser.Identifier, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Attribute_specifier_sequenceContext attribute_specifier_sequence() {
			return getRuleContext(Attribute_specifier_sequenceContext.class,0);
		}
		public TerminalNode Case() { return getToken(PandaParser.Case, 0); }
		public ConstantexpressionContext constantexpression() {
			return getRuleContext(ConstantexpressionContext.class,0);
		}
		public TerminalNode Default() { return getToken(PandaParser.Default, 0); }
		public LabeledstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labeledstatement; }
	}

	public final LabeledstatementContext labeledstatement() throws RecognitionException {
		LabeledstatementContext _localctx = new LabeledstatementContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_labeledstatement);
		int _la;
		try {
			setState(711);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(692);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftBracket) {
					{
					setState(691);
					attribute_specifier_sequence(0);
					}
				}

				setState(694);
				match(Identifier);
				setState(695);
				match(Colon);
				setState(696);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(698);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftBracket) {
					{
					setState(697);
					attribute_specifier_sequence(0);
					}
				}

				setState(700);
				match(Case);
				setState(701);
				constantexpression();
				setState(702);
				match(Colon);
				setState(703);
				statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(706);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftBracket) {
					{
					setState(705);
					attribute_specifier_sequence(0);
					}
				}

				setState(708);
				match(Default);
				setState(709);
				match(Colon);
				setState(710);
				statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionstatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionstatement; }
	}

	public final ExpressionstatementContext expressionstatement() throws RecognitionException {
		ExpressionstatementContext _localctx = new ExpressionstatementContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_expressionstatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(714);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Auto) | (1L << Bool) | (1L << Double) | (1L << F32) | (1L << F64) | (1L << Float) | (1L << Int) | (1L << Int8) | (1L << Int16) | (1L << Int32) | (1L << Int64) | (1L << Long) | (1L << New) | (1L << Operator) | (1L << Short) | (1L << This) | (1L << Throw) | (1L << Uint) | (1L << Uint8) | (1L << Uint16) | (1L << Uint32) | (1L << Uint64) | (1L << Ulong) | (1L << Ushort) | (1L << Void) | (1L << LeftParen) | (1L << LeftBrace))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (Plus - 65)) | (1L << (Minus - 65)) | (1L << (Or - 65)) | (1L << (Tilde - 65)) | (1L << (Not - 65)) | (1L << (PlusPlus - 65)) | (1L << (MinusMinus - 65)) | (1L << (Dot - 65)) | (1L << (Identifier - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (PointerLiteral - 65)))) != 0)) {
				{
				setState(713);
				expression(0);
				}
			}

			setState(716);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Compound_statementContext extends ParserRuleContext {
		public StatementseqContext statementseq() {
			return getRuleContext(StatementseqContext.class,0);
		}
		public Compound_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_statement; }
	}

	public final Compound_statementContext compound_statement() throws RecognitionException {
		Compound_statementContext _localctx = new Compound_statementContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_compound_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(718);
			match(LeftBrace);
			setState(720);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Auto) | (1L << Bool) | (1L << Break) | (1L << Case) | (1L << Class) | (1L << Continue) | (1L << Default) | (1L << Double) | (1L << Enum) | (1L << F32) | (1L << F64) | (1L << Float) | (1L << For) | (1L << If) | (1L << Int) | (1L << Int8) | (1L << Int16) | (1L << Int32) | (1L << Int64) | (1L << Long) | (1L << Namespace) | (1L << New) | (1L << Operator) | (1L << Return) | (1L << Static) | (1L << Short) | (1L << Switch) | (1L << This) | (1L << Throw) | (1L << Try) | (1L << Uint) | (1L << Uint8) | (1L << Uint16) | (1L << Uint32) | (1L << Uint64) | (1L << Ulong) | (1L << Ushort) | (1L << Using) | (1L << Void) | (1L << While) | (1L << LeftParen) | (1L << LeftBracket) | (1L << LeftBrace))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (Plus - 65)) | (1L << (Minus - 65)) | (1L << (And - 65)) | (1L << (Or - 65)) | (1L << (Tilde - 65)) | (1L << (Not - 65)) | (1L << (PlusPlus - 65)) | (1L << (MinusMinus - 65)) | (1L << (Semi - 65)) | (1L << (Dot - 65)) | (1L << (Ellipsis - 65)) | (1L << (Identifier - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (PointerLiteral - 65)))) != 0)) {
				{
				setState(719);
				statementseq(0);
				}
			}

			setState(722);
			match(RightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementseqContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementseqContext statementseq() {
			return getRuleContext(StatementseqContext.class,0);
		}
		public StatementseqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementseq; }
	}

	public final StatementseqContext statementseq() throws RecognitionException {
		return statementseq(0);
	}

	private StatementseqContext statementseq(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StatementseqContext _localctx = new StatementseqContext(_ctx, _parentState);
		StatementseqContext _prevctx = _localctx;
		int _startState = 72;
		enterRecursionRule(_localctx, 72, RULE_statementseq, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(725);
			statement();
			}
			_ctx.stop = _input.LT(-1);
			setState(731);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StatementseqContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_statementseq);
					setState(727);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(728);
					statement();
					}
					} 
				}
				setState(733);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class SelectionstatementContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(PandaParser.If, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode Else() { return getToken(PandaParser.Else, 0); }
		public TerminalNode Switch() { return getToken(PandaParser.Switch, 0); }
		public SelectionstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectionstatement; }
	}

	public final SelectionstatementContext selectionstatement() throws RecognitionException {
		SelectionstatementContext _localctx = new SelectionstatementContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_selectionstatement);
		try {
			setState(754);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(734);
				match(If);
				setState(735);
				match(LeftParen);
				setState(736);
				condition();
				setState(737);
				match(RightParen);
				setState(738);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(740);
				match(If);
				setState(741);
				match(LeftParen);
				setState(742);
				condition();
				setState(743);
				match(RightParen);
				setState(744);
				statement();
				setState(745);
				match(Else);
				setState(746);
				statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(748);
				match(Switch);
				setState(749);
				match(LeftParen);
				setState(750);
				condition();
				setState(751);
				match(RightParen);
				setState(752);
				statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DeclspecifierseqContext declspecifierseq() {
			return getRuleContext(DeclspecifierseqContext.class,0);
		}
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public InitializerclauseContext initializerclause() {
			return getRuleContext(InitializerclauseContext.class,0);
		}
		public Attribute_specifier_sequenceContext attribute_specifier_sequence() {
			return getRuleContext(Attribute_specifier_sequenceContext.class,0);
		}
		public Braced_init_listContext braced_init_list() {
			return getRuleContext(Braced_init_listContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_condition);
		int _la;
		try {
			setState(772);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(756);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(758);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftBracket) {
					{
					setState(757);
					attribute_specifier_sequence(0);
					}
				}

				setState(760);
				declspecifierseq();
				setState(761);
				declarator();
				setState(762);
				match(Assign);
				setState(763);
				initializerclause();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(766);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftBracket) {
					{
					setState(765);
					attribute_specifier_sequence(0);
					}
				}

				setState(768);
				declspecifierseq();
				setState(769);
				declarator();
				setState(770);
				braced_init_list();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IterationstatementContext extends ParserRuleContext {
		public TerminalNode While() { return getToken(PandaParser.While, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode For() { return getToken(PandaParser.For, 0); }
		public ForinitstatementContext forinitstatement() {
			return getRuleContext(ForinitstatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForrangedeclarationContext forrangedeclaration() {
			return getRuleContext(ForrangedeclarationContext.class,0);
		}
		public ForrangeinitializerContext forrangeinitializer() {
			return getRuleContext(ForrangeinitializerContext.class,0);
		}
		public IterationstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterationstatement; }
	}

	public final IterationstatementContext iterationstatement() throws RecognitionException {
		IterationstatementContext _localctx = new IterationstatementContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_iterationstatement);
		int _la;
		try {
			setState(801);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(774);
				match(While);
				setState(775);
				match(LeftParen);
				setState(776);
				condition();
				setState(777);
				match(RightParen);
				setState(778);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(780);
				match(For);
				setState(781);
				match(LeftParen);
				setState(782);
				forinitstatement();
				setState(784);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Auto) | (1L << Bool) | (1L << Class) | (1L << Double) | (1L << Enum) | (1L << F32) | (1L << F64) | (1L << Float) | (1L << Int) | (1L << Int8) | (1L << Int16) | (1L << Int32) | (1L << Int64) | (1L << Long) | (1L << New) | (1L << Operator) | (1L << Static) | (1L << Short) | (1L << This) | (1L << Throw) | (1L << Uint) | (1L << Uint8) | (1L << Uint16) | (1L << Uint32) | (1L << Uint64) | (1L << Ulong) | (1L << Ushort) | (1L << Void) | (1L << LeftParen) | (1L << LeftBracket) | (1L << LeftBrace))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (Plus - 65)) | (1L << (Minus - 65)) | (1L << (Or - 65)) | (1L << (Tilde - 65)) | (1L << (Not - 65)) | (1L << (PlusPlus - 65)) | (1L << (MinusMinus - 65)) | (1L << (Dot - 65)) | (1L << (Identifier - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (PointerLiteral - 65)))) != 0)) {
					{
					setState(783);
					condition();
					}
				}

				setState(786);
				match(Semi);
				setState(788);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Auto) | (1L << Bool) | (1L << Double) | (1L << F32) | (1L << F64) | (1L << Float) | (1L << Int) | (1L << Int8) | (1L << Int16) | (1L << Int32) | (1L << Int64) | (1L << Long) | (1L << New) | (1L << Operator) | (1L << Short) | (1L << This) | (1L << Throw) | (1L << Uint) | (1L << Uint8) | (1L << Uint16) | (1L << Uint32) | (1L << Uint64) | (1L << Ulong) | (1L << Ushort) | (1L << Void) | (1L << LeftParen) | (1L << LeftBrace))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (Plus - 65)) | (1L << (Minus - 65)) | (1L << (Or - 65)) | (1L << (Tilde - 65)) | (1L << (Not - 65)) | (1L << (PlusPlus - 65)) | (1L << (MinusMinus - 65)) | (1L << (Dot - 65)) | (1L << (Identifier - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (PointerLiteral - 65)))) != 0)) {
					{
					setState(787);
					expression(0);
					}
				}

				setState(790);
				match(RightParen);
				setState(791);
				statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(793);
				match(For);
				setState(794);
				match(LeftParen);
				setState(795);
				forrangedeclaration();
				setState(796);
				match(Colon);
				setState(797);
				forrangeinitializer();
				setState(798);
				match(RightParen);
				setState(799);
				statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForinitstatementContext extends ParserRuleContext {
		public ExpressionstatementContext expressionstatement() {
			return getRuleContext(ExpressionstatementContext.class,0);
		}
		public SimpledeclarationContext simpledeclaration() {
			return getRuleContext(SimpledeclarationContext.class,0);
		}
		public ForinitstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forinitstatement; }
	}

	public final ForinitstatementContext forinitstatement() throws RecognitionException {
		ForinitstatementContext _localctx = new ForinitstatementContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_forinitstatement);
		try {
			setState(805);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(803);
				expressionstatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(804);
				simpledeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForrangedeclarationContext extends ParserRuleContext {
		public DeclspecifierseqContext declspecifierseq() {
			return getRuleContext(DeclspecifierseqContext.class,0);
		}
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public Attribute_specifier_sequenceContext attribute_specifier_sequence() {
			return getRuleContext(Attribute_specifier_sequenceContext.class,0);
		}
		public ForrangedeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forrangedeclaration; }
	}

	public final ForrangedeclarationContext forrangedeclaration() throws RecognitionException {
		ForrangedeclarationContext _localctx = new ForrangedeclarationContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_forrangedeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(808);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LeftBracket) {
				{
				setState(807);
				attribute_specifier_sequence(0);
				}
			}

			setState(810);
			declspecifierseq();
			setState(811);
			declarator();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForrangeinitializerContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Braced_init_listContext braced_init_list() {
			return getRuleContext(Braced_init_listContext.class,0);
		}
		public ForrangeinitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forrangeinitializer; }
	}

	public final ForrangeinitializerContext forrangeinitializer() throws RecognitionException {
		ForrangeinitializerContext _localctx = new ForrangeinitializerContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_forrangeinitializer);
		try {
			setState(815);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(813);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(814);
				braced_init_list();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JumpstatementContext extends ParserRuleContext {
		public TerminalNode Break() { return getToken(PandaParser.Break, 0); }
		public TerminalNode Newline() { return getToken(PandaParser.Newline, 0); }
		public TerminalNode Continue() { return getToken(PandaParser.Continue, 0); }
		public TerminalNode Return() { return getToken(PandaParser.Return, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Braced_init_listContext braced_init_list() {
			return getRuleContext(Braced_init_listContext.class,0);
		}
		public JumpstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jumpstatement; }
	}

	public final JumpstatementContext jumpstatement() throws RecognitionException {
		JumpstatementContext _localctx = new JumpstatementContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_jumpstatement);
		int _la;
		try {
			setState(830);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(817);
				match(Break);
				setState(818);
				match(Newline);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(819);
				match(Continue);
				setState(820);
				match(Newline);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(821);
				match(Return);
				setState(823);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Auto) | (1L << Bool) | (1L << Double) | (1L << F32) | (1L << F64) | (1L << Float) | (1L << Int) | (1L << Int8) | (1L << Int16) | (1L << Int32) | (1L << Int64) | (1L << Long) | (1L << New) | (1L << Operator) | (1L << Short) | (1L << This) | (1L << Throw) | (1L << Uint) | (1L << Uint8) | (1L << Uint16) | (1L << Uint32) | (1L << Uint64) | (1L << Ulong) | (1L << Ushort) | (1L << Void) | (1L << LeftParen) | (1L << LeftBrace))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (Plus - 65)) | (1L << (Minus - 65)) | (1L << (Or - 65)) | (1L << (Tilde - 65)) | (1L << (Not - 65)) | (1L << (PlusPlus - 65)) | (1L << (MinusMinus - 65)) | (1L << (Dot - 65)) | (1L << (Identifier - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (PointerLiteral - 65)))) != 0)) {
					{
					setState(822);
					expression(0);
					}
				}

				setState(825);
				match(Newline);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(826);
				match(Return);
				setState(827);
				braced_init_list();
				setState(828);
				match(Newline);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationstatementContext extends ParserRuleContext {
		public BlockdeclarationContext blockdeclaration() {
			return getRuleContext(BlockdeclarationContext.class,0);
		}
		public DeclarationstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationstatement; }
	}

	public final DeclarationstatementContext declarationstatement() throws RecognitionException {
		DeclarationstatementContext _localctx = new DeclarationstatementContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_declarationstatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(832);
			blockdeclaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Declaration_sequenceContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public Declaration_sequenceContext declaration_sequence() {
			return getRuleContext(Declaration_sequenceContext.class,0);
		}
		public Declaration_sequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration_sequence; }
	}

	public final Declaration_sequenceContext declaration_sequence() throws RecognitionException {
		return declaration_sequence(0);
	}

	private Declaration_sequenceContext declaration_sequence(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Declaration_sequenceContext _localctx = new Declaration_sequenceContext(_ctx, _parentState);
		Declaration_sequenceContext _prevctx = _localctx;
		int _startState = 90;
		enterRecursionRule(_localctx, 90, RULE_declaration_sequence, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(835);
			declaration();
			}
			_ctx.stop = _input.LT(-1);
			setState(841);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Declaration_sequenceContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_declaration_sequence);
					setState(837);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(838);
					declaration();
					}
					} 
				}
				setState(843);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public BlockdeclarationContext blockdeclaration() {
			return getRuleContext(BlockdeclarationContext.class,0);
		}
		public FunctiondefinitionContext functiondefinition() {
			return getRuleContext(FunctiondefinitionContext.class,0);
		}
		public NamespacedefinitionContext namespacedefinition() {
			return getRuleContext(NamespacedefinitionContext.class,0);
		}
		public EmptydeclarationContext emptydeclaration() {
			return getRuleContext(EmptydeclarationContext.class,0);
		}
		public AttributedeclarationContext attributedeclaration() {
			return getRuleContext(AttributedeclarationContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_declaration);
		try {
			setState(849);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(844);
				blockdeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(845);
				functiondefinition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(846);
				namespacedefinition();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(847);
				emptydeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(848);
				attributedeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockdeclarationContext extends ParserRuleContext {
		public SimpledeclarationContext simpledeclaration() {
			return getRuleContext(SimpledeclarationContext.class,0);
		}
		public NamespacealiasdefinitionContext namespacealiasdefinition() {
			return getRuleContext(NamespacealiasdefinitionContext.class,0);
		}
		public UsingdeclarationContext usingdeclaration() {
			return getRuleContext(UsingdeclarationContext.class,0);
		}
		public UsingdirectiveContext usingdirective() {
			return getRuleContext(UsingdirectiveContext.class,0);
		}
		public AliasdeclarationContext aliasdeclaration() {
			return getRuleContext(AliasdeclarationContext.class,0);
		}
		public OpaqueenumdeclarationContext opaqueenumdeclaration() {
			return getRuleContext(OpaqueenumdeclarationContext.class,0);
		}
		public BlockdeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockdeclaration; }
	}

	public final BlockdeclarationContext blockdeclaration() throws RecognitionException {
		BlockdeclarationContext _localctx = new BlockdeclarationContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_blockdeclaration);
		try {
			setState(857);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(851);
				simpledeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(852);
				namespacealiasdefinition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(853);
				usingdeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(854);
				usingdirective();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(855);
				aliasdeclaration();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(856);
				opaqueenumdeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AliasdeclarationContext extends ParserRuleContext {
		public TerminalNode Using() { return getToken(PandaParser.Using, 0); }
		public TerminalNode Identifier() { return getToken(PandaParser.Identifier, 0); }
		public Type_idContext type_id() {
			return getRuleContext(Type_idContext.class,0);
		}
		public Attribute_specifier_sequenceContext attribute_specifier_sequence() {
			return getRuleContext(Attribute_specifier_sequenceContext.class,0);
		}
		public AliasdeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aliasdeclaration; }
	}

	public final AliasdeclarationContext aliasdeclaration() throws RecognitionException {
		AliasdeclarationContext _localctx = new AliasdeclarationContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_aliasdeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(859);
			match(Using);
			setState(860);
			match(Identifier);
			setState(862);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LeftBracket) {
				{
				setState(861);
				attribute_specifier_sequence(0);
				}
			}

			setState(864);
			match(Assign);
			setState(865);
			type_id();
			setState(866);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpledeclarationContext extends ParserRuleContext {
		public DeclspecifierseqContext declspecifierseq() {
			return getRuleContext(DeclspecifierseqContext.class,0);
		}
		public InitdeclaratorlistContext initdeclaratorlist() {
			return getRuleContext(InitdeclaratorlistContext.class,0);
		}
		public Attribute_specifier_sequenceContext attribute_specifier_sequence() {
			return getRuleContext(Attribute_specifier_sequenceContext.class,0);
		}
		public SimpledeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpledeclaration; }
	}

	public final SimpledeclarationContext simpledeclaration() throws RecognitionException {
		SimpledeclarationContext _localctx = new SimpledeclarationContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_simpledeclaration);
		int _la;
		try {
			setState(882);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Auto:
			case Bool:
			case Class:
			case Double:
			case Enum:
			case F32:
			case F64:
			case Float:
			case Int:
			case Int8:
			case Int16:
			case Int32:
			case Int64:
			case Long:
			case Operator:
			case Static:
			case Short:
			case Uint:
			case Uint8:
			case Uint16:
			case Uint32:
			case Uint64:
			case Ulong:
			case Ushort:
			case Void:
			case LeftParen:
			case And:
			case Semi:
			case Dot:
			case Ellipsis:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(869);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
				case 1:
					{
					setState(868);
					declspecifierseq();
					}
					break;
				}
				setState(872);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Operator || _la==LeftParen || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (And - 71)) | (1L << (Dot - 71)) | (1L << (Ellipsis - 71)) | (1L << (Identifier - 71)))) != 0)) {
					{
					setState(871);
					initdeclaratorlist(0);
					}
				}

				setState(874);
				match(Semi);
				}
				break;
			case LeftBracket:
				enterOuterAlt(_localctx, 2);
				{
				setState(875);
				attribute_specifier_sequence(0);
				setState(877);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
				case 1:
					{
					setState(876);
					declspecifierseq();
					}
					break;
				}
				setState(879);
				initdeclaratorlist(0);
				setState(880);
				match(Semi);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EmptydeclarationContext extends ParserRuleContext {
		public EmptydeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptydeclaration; }
	}

	public final EmptydeclarationContext emptydeclaration() throws RecognitionException {
		EmptydeclarationContext _localctx = new EmptydeclarationContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_emptydeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(884);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributedeclarationContext extends ParserRuleContext {
		public Attribute_specifier_sequenceContext attribute_specifier_sequence() {
			return getRuleContext(Attribute_specifier_sequenceContext.class,0);
		}
		public AttributedeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributedeclaration; }
	}

	public final AttributedeclarationContext attributedeclaration() throws RecognitionException {
		AttributedeclarationContext _localctx = new AttributedeclarationContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_attributedeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(886);
			attribute_specifier_sequence(0);
			setState(887);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclspecifierContext extends ParserRuleContext {
		public Storageclass_specifierContext storageclass_specifier() {
			return getRuleContext(Storageclass_specifierContext.class,0);
		}
		public TypespecifierContext typespecifier() {
			return getRuleContext(TypespecifierContext.class,0);
		}
		public DeclspecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declspecifier; }
	}

	public final DeclspecifierContext declspecifier() throws RecognitionException {
		DeclspecifierContext _localctx = new DeclspecifierContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_declspecifier);
		try {
			setState(891);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Static:
				enterOuterAlt(_localctx, 1);
				{
				setState(889);
				storageclass_specifier();
				}
				break;
			case Auto:
			case Bool:
			case Class:
			case Double:
			case Enum:
			case F32:
			case F64:
			case Float:
			case Int:
			case Int8:
			case Int16:
			case Int32:
			case Int64:
			case Long:
			case Short:
			case Uint:
			case Uint8:
			case Uint16:
			case Uint32:
			case Uint64:
			case Ulong:
			case Ushort:
			case Void:
			case Dot:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(890);
				typespecifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclspecifierseqContext extends ParserRuleContext {
		public DeclspecifierContext declspecifier() {
			return getRuleContext(DeclspecifierContext.class,0);
		}
		public Attribute_specifier_sequenceContext attribute_specifier_sequence() {
			return getRuleContext(Attribute_specifier_sequenceContext.class,0);
		}
		public DeclspecifierseqContext declspecifierseq() {
			return getRuleContext(DeclspecifierseqContext.class,0);
		}
		public DeclspecifierseqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declspecifierseq; }
	}

	public final DeclspecifierseqContext declspecifierseq() throws RecognitionException {
		DeclspecifierseqContext _localctx = new DeclspecifierseqContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_declspecifierseq);
		try {
			setState(900);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(893);
				declspecifier();
				setState(895);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
				case 1:
					{
					setState(894);
					attribute_specifier_sequence(0);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(897);
				declspecifier();
				setState(898);
				declspecifierseq();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Storageclass_specifierContext extends ParserRuleContext {
		public TerminalNode Static() { return getToken(PandaParser.Static, 0); }
		public Storageclass_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_storageclass_specifier; }
	}

	public final Storageclass_specifierContext storageclass_specifier() throws RecognitionException {
		Storageclass_specifierContext _localctx = new Storageclass_specifierContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_storageclass_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(902);
			match(Static);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Typedef_nameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PandaParser.Identifier, 0); }
		public Typedef_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedef_name; }
	}

	public final Typedef_nameContext typedef_name() throws RecognitionException {
		Typedef_nameContext _localctx = new Typedef_nameContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_typedef_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(904);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypespecifierContext extends ParserRuleContext {
		public Trailing_type_specifierContext trailing_type_specifier() {
			return getRuleContext(Trailing_type_specifierContext.class,0);
		}
		public Class_specifierContext class_specifier() {
			return getRuleContext(Class_specifierContext.class,0);
		}
		public Enum_specifierContext enum_specifier() {
			return getRuleContext(Enum_specifierContext.class,0);
		}
		public TypespecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typespecifier; }
	}

	public final TypespecifierContext typespecifier() throws RecognitionException {
		TypespecifierContext _localctx = new TypespecifierContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_typespecifier);
		try {
			setState(909);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(906);
				trailing_type_specifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(907);
				class_specifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(908);
				enum_specifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Trailing_type_specifierContext extends ParserRuleContext {
		public Simple_type_specifierContext simple_type_specifier() {
			return getRuleContext(Simple_type_specifierContext.class,0);
		}
		public ElaboratedtypespecifierContext elaboratedtypespecifier() {
			return getRuleContext(ElaboratedtypespecifierContext.class,0);
		}
		public Type_name_specifierContext type_name_specifier() {
			return getRuleContext(Type_name_specifierContext.class,0);
		}
		public Trailing_type_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trailing_type_specifier; }
	}

	public final Trailing_type_specifierContext trailing_type_specifier() throws RecognitionException {
		Trailing_type_specifierContext _localctx = new Trailing_type_specifierContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_trailing_type_specifier);
		try {
			setState(914);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,78,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(911);
				simple_type_specifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(912);
				elaboratedtypespecifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(913);
				type_name_specifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_specifier_sequenceContext extends ParserRuleContext {
		public TypespecifierContext typespecifier() {
			return getRuleContext(TypespecifierContext.class,0);
		}
		public Attribute_specifier_sequenceContext attribute_specifier_sequence() {
			return getRuleContext(Attribute_specifier_sequenceContext.class,0);
		}
		public Type_specifier_sequenceContext type_specifier_sequence() {
			return getRuleContext(Type_specifier_sequenceContext.class,0);
		}
		public Type_specifier_sequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_specifier_sequence; }
	}

	public final Type_specifier_sequenceContext type_specifier_sequence() throws RecognitionException {
		Type_specifier_sequenceContext _localctx = new Type_specifier_sequenceContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_type_specifier_sequence);
		try {
			setState(923);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(916);
				typespecifier();
				setState(918);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
				case 1:
					{
					setState(917);
					attribute_specifier_sequence(0);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(920);
				typespecifier();
				setState(921);
				type_specifier_sequence();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Trailing_type_specifier_sequenceContext extends ParserRuleContext {
		public Trailing_type_specifierContext trailing_type_specifier() {
			return getRuleContext(Trailing_type_specifierContext.class,0);
		}
		public Attribute_specifier_sequenceContext attribute_specifier_sequence() {
			return getRuleContext(Attribute_specifier_sequenceContext.class,0);
		}
		public Trailing_type_specifier_sequenceContext trailing_type_specifier_sequence() {
			return getRuleContext(Trailing_type_specifier_sequenceContext.class,0);
		}
		public Trailing_type_specifier_sequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trailing_type_specifier_sequence; }
	}

	public final Trailing_type_specifier_sequenceContext trailing_type_specifier_sequence() throws RecognitionException {
		Trailing_type_specifier_sequenceContext _localctx = new Trailing_type_specifier_sequenceContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_trailing_type_specifier_sequence);
		try {
			setState(932);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(925);
				trailing_type_specifier();
				setState(927);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,81,_ctx) ) {
				case 1:
					{
					setState(926);
					attribute_specifier_sequence(0);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(929);
				trailing_type_specifier();
				setState(930);
				trailing_type_specifier_sequence();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Simple_type_specifierContext extends ParserRuleContext {
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
		public Nested_name_specifierContext nested_name_specifier() {
			return getRuleContext(Nested_name_specifierContext.class,0);
		}
		public Simple_template_idContext simple_template_id() {
			return getRuleContext(Simple_template_idContext.class,0);
		}
		public TerminalNode Bool() { return getToken(PandaParser.Bool, 0); }
		public TerminalNode Int8() { return getToken(PandaParser.Int8, 0); }
		public TerminalNode Int16() { return getToken(PandaParser.Int16, 0); }
		public TerminalNode Int32() { return getToken(PandaParser.Int32, 0); }
		public TerminalNode Int64() { return getToken(PandaParser.Int64, 0); }
		public TerminalNode Uint8() { return getToken(PandaParser.Uint8, 0); }
		public TerminalNode Uint16() { return getToken(PandaParser.Uint16, 0); }
		public TerminalNode Uint32() { return getToken(PandaParser.Uint32, 0); }
		public TerminalNode Uint64() { return getToken(PandaParser.Uint64, 0); }
		public TerminalNode Int() { return getToken(PandaParser.Int, 0); }
		public TerminalNode Uint() { return getToken(PandaParser.Uint, 0); }
		public TerminalNode Short() { return getToken(PandaParser.Short, 0); }
		public TerminalNode Ushort() { return getToken(PandaParser.Ushort, 0); }
		public TerminalNode Long() { return getToken(PandaParser.Long, 0); }
		public TerminalNode Ulong() { return getToken(PandaParser.Ulong, 0); }
		public TerminalNode F32() { return getToken(PandaParser.F32, 0); }
		public TerminalNode F64() { return getToken(PandaParser.F64, 0); }
		public TerminalNode Float() { return getToken(PandaParser.Float, 0); }
		public TerminalNode Double() { return getToken(PandaParser.Double, 0); }
		public TerminalNode Void() { return getToken(PandaParser.Void, 0); }
		public TerminalNode Auto() { return getToken(PandaParser.Auto, 0); }
		public Simple_type_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_type_specifier; }
	}

	public final Simple_type_specifierContext simple_type_specifier() throws RecognitionException {
		Simple_type_specifierContext _localctx = new Simple_type_specifierContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_simple_type_specifier);
		try {
			setState(962);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(935);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,83,_ctx) ) {
				case 1:
					{
					setState(934);
					nested_name_specifier(0);
					}
					break;
				}
				setState(937);
				type_name();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(938);
				nested_name_specifier(0);
				setState(939);
				simple_template_id();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(941);
				match(Bool);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(942);
				match(Int8);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(943);
				match(Int16);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(944);
				match(Int32);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(945);
				match(Int64);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(946);
				match(Uint8);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(947);
				match(Uint16);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(948);
				match(Uint32);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(949);
				match(Uint64);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(950);
				match(Int);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(951);
				match(Uint);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(952);
				match(Short);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(953);
				match(Ushort);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(954);
				match(Long);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(955);
				match(Ulong);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(956);
				match(F32);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(957);
				match(F64);
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(958);
				match(Float);
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(959);
				match(Double);
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(960);
				match(Void);
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(961);
				match(Auto);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_nameContext extends ParserRuleContext {
		public Class_nameContext class_name() {
			return getRuleContext(Class_nameContext.class,0);
		}
		public Enum_nameContext enum_name() {
			return getRuleContext(Enum_nameContext.class,0);
		}
		public Typedef_nameContext typedef_name() {
			return getRuleContext(Typedef_nameContext.class,0);
		}
		public Simple_template_idContext simple_template_id() {
			return getRuleContext(Simple_template_idContext.class,0);
		}
		public Type_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_name; }
	}

	public final Type_nameContext type_name() throws RecognitionException {
		Type_nameContext _localctx = new Type_nameContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_type_name);
		try {
			setState(968);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(964);
				class_name();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(965);
				enum_name();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(966);
				typedef_name();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(967);
				simple_template_id();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElaboratedtypespecifierContext extends ParserRuleContext {
		public TerminalNode Class() { return getToken(PandaParser.Class, 0); }
		public TerminalNode Identifier() { return getToken(PandaParser.Identifier, 0); }
		public Attribute_specifier_sequenceContext attribute_specifier_sequence() {
			return getRuleContext(Attribute_specifier_sequenceContext.class,0);
		}
		public Nested_name_specifierContext nested_name_specifier() {
			return getRuleContext(Nested_name_specifierContext.class,0);
		}
		public Simple_template_idContext simple_template_id() {
			return getRuleContext(Simple_template_idContext.class,0);
		}
		public TerminalNode Enum() { return getToken(PandaParser.Enum, 0); }
		public ElaboratedtypespecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elaboratedtypespecifier; }
	}

	public final ElaboratedtypespecifierContext elaboratedtypespecifier() throws RecognitionException {
		ElaboratedtypespecifierContext _localctx = new ElaboratedtypespecifierContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_elaboratedtypespecifier);
		int _la;
		try {
			setState(989);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,89,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(970);
				match(Class);
				setState(972);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftBracket) {
					{
					setState(971);
					attribute_specifier_sequence(0);
					}
				}

				setState(975);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
				case 1:
					{
					setState(974);
					nested_name_specifier(0);
					}
					break;
				}
				setState(977);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(978);
				match(Class);
				setState(979);
				simple_template_id();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(980);
				match(Class);
				setState(981);
				nested_name_specifier(0);
				setState(982);
				simple_template_id();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(984);
				match(Enum);
				setState(986);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,88,_ctx) ) {
				case 1:
					{
					setState(985);
					nested_name_specifier(0);
					}
					break;
				}
				setState(988);
				match(Identifier);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Enum_nameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PandaParser.Identifier, 0); }
		public Enum_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enum_name; }
	}

	public final Enum_nameContext enum_name() throws RecognitionException {
		Enum_nameContext _localctx = new Enum_nameContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_enum_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(991);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Enum_specifierContext extends ParserRuleContext {
		public EnumheadContext enumhead() {
			return getRuleContext(EnumheadContext.class,0);
		}
		public EnumeratorlistContext enumeratorlist() {
			return getRuleContext(EnumeratorlistContext.class,0);
		}
		public Enum_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enum_specifier; }
	}

	public final Enum_specifierContext enum_specifier() throws RecognitionException {
		Enum_specifierContext _localctx = new Enum_specifierContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_enum_specifier);
		int _la;
		try {
			setState(1006);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,91,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(993);
				enumhead();
				setState(994);
				match(LeftBrace);
				setState(996);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(995);
					enumeratorlist(0);
					}
				}

				setState(998);
				match(RightBrace);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1000);
				enumhead();
				setState(1001);
				match(LeftBrace);
				setState(1002);
				enumeratorlist(0);
				setState(1003);
				match(Comma);
				setState(1004);
				match(RightBrace);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumheadContext extends ParserRuleContext {
		public EnumkeyContext enumkey() {
			return getRuleContext(EnumkeyContext.class,0);
		}
		public Attribute_specifier_sequenceContext attribute_specifier_sequence() {
			return getRuleContext(Attribute_specifier_sequenceContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(PandaParser.Identifier, 0); }
		public EnumbaseContext enumbase() {
			return getRuleContext(EnumbaseContext.class,0);
		}
		public Nested_name_specifierContext nested_name_specifier() {
			return getRuleContext(Nested_name_specifierContext.class,0);
		}
		public EnumheadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumhead; }
	}

	public final EnumheadContext enumhead() throws RecognitionException {
		EnumheadContext _localctx = new EnumheadContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_enumhead);
		int _la;
		try {
			setState(1027);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1008);
				enumkey();
				setState(1010);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftBracket) {
					{
					setState(1009);
					attribute_specifier_sequence(0);
					}
				}

				setState(1013);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(1012);
					match(Identifier);
					}
				}

				setState(1016);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Colon) {
					{
					setState(1015);
					enumbase();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1018);
				enumkey();
				setState(1020);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftBracket) {
					{
					setState(1019);
					attribute_specifier_sequence(0);
					}
				}

				setState(1022);
				nested_name_specifier(0);
				setState(1023);
				match(Identifier);
				setState(1025);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Colon) {
					{
					setState(1024);
					enumbase();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpaqueenumdeclarationContext extends ParserRuleContext {
		public EnumkeyContext enumkey() {
			return getRuleContext(EnumkeyContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(PandaParser.Identifier, 0); }
		public Attribute_specifier_sequenceContext attribute_specifier_sequence() {
			return getRuleContext(Attribute_specifier_sequenceContext.class,0);
		}
		public EnumbaseContext enumbase() {
			return getRuleContext(EnumbaseContext.class,0);
		}
		public OpaqueenumdeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opaqueenumdeclaration; }
	}

	public final OpaqueenumdeclarationContext opaqueenumdeclaration() throws RecognitionException {
		OpaqueenumdeclarationContext _localctx = new OpaqueenumdeclarationContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_opaqueenumdeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1029);
			enumkey();
			setState(1031);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LeftBracket) {
				{
				setState(1030);
				attribute_specifier_sequence(0);
				}
			}

			setState(1033);
			match(Identifier);
			setState(1035);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Colon) {
				{
				setState(1034);
				enumbase();
				}
			}

			setState(1037);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumkeyContext extends ParserRuleContext {
		public TerminalNode Enum() { return getToken(PandaParser.Enum, 0); }
		public TerminalNode Class() { return getToken(PandaParser.Class, 0); }
		public EnumkeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumkey; }
	}

	public final EnumkeyContext enumkey() throws RecognitionException {
		EnumkeyContext _localctx = new EnumkeyContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_enumkey);
		try {
			setState(1042);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,100,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1039);
				match(Enum);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1040);
				match(Enum);
				setState(1041);
				match(Class);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumbaseContext extends ParserRuleContext {
		public Type_specifier_sequenceContext type_specifier_sequence() {
			return getRuleContext(Type_specifier_sequenceContext.class,0);
		}
		public EnumbaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumbase; }
	}

	public final EnumbaseContext enumbase() throws RecognitionException {
		EnumbaseContext _localctx = new EnumbaseContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_enumbase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1044);
			match(Colon);
			setState(1045);
			type_specifier_sequence();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumeratorlistContext extends ParserRuleContext {
		public EnumeratordefinitionContext enumeratordefinition() {
			return getRuleContext(EnumeratordefinitionContext.class,0);
		}
		public EnumeratorlistContext enumeratorlist() {
			return getRuleContext(EnumeratorlistContext.class,0);
		}
		public EnumeratorlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumeratorlist; }
	}

	public final EnumeratorlistContext enumeratorlist() throws RecognitionException {
		return enumeratorlist(0);
	}

	private EnumeratorlistContext enumeratorlist(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EnumeratorlistContext _localctx = new EnumeratorlistContext(_ctx, _parentState);
		EnumeratorlistContext _prevctx = _localctx;
		int _startState = 138;
		enterRecursionRule(_localctx, 138, RULE_enumeratorlist, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1048);
			enumeratordefinition();
			}
			_ctx.stop = _input.LT(-1);
			setState(1055);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,101,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new EnumeratorlistContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_enumeratorlist);
					setState(1050);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1051);
					match(Comma);
					setState(1052);
					enumeratordefinition();
					}
					} 
				}
				setState(1057);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,101,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class EnumeratordefinitionContext extends ParserRuleContext {
		public EnumeratorContext enumerator() {
			return getRuleContext(EnumeratorContext.class,0);
		}
		public ConstantexpressionContext constantexpression() {
			return getRuleContext(ConstantexpressionContext.class,0);
		}
		public EnumeratordefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumeratordefinition; }
	}

	public final EnumeratordefinitionContext enumeratordefinition() throws RecognitionException {
		EnumeratordefinitionContext _localctx = new EnumeratordefinitionContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_enumeratordefinition);
		try {
			setState(1063);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1058);
				enumerator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1059);
				enumerator();
				setState(1060);
				match(Assign);
				setState(1061);
				constantexpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumeratorContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PandaParser.Identifier, 0); }
		public EnumeratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumerator; }
	}

	public final EnumeratorContext enumerator() throws RecognitionException {
		EnumeratorContext _localctx = new EnumeratorContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_enumerator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1065);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Namespace_nameContext extends ParserRuleContext {
		public Originalnamespace_nameContext originalnamespace_name() {
			return getRuleContext(Originalnamespace_nameContext.class,0);
		}
		public NamespacealiasContext namespacealias() {
			return getRuleContext(NamespacealiasContext.class,0);
		}
		public Namespace_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespace_name; }
	}

	public final Namespace_nameContext namespace_name() throws RecognitionException {
		Namespace_nameContext _localctx = new Namespace_nameContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_namespace_name);
		try {
			setState(1069);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,103,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1067);
				originalnamespace_name();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1068);
				namespacealias();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Originalnamespace_nameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PandaParser.Identifier, 0); }
		public Originalnamespace_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_originalnamespace_name; }
	}

	public final Originalnamespace_nameContext originalnamespace_name() throws RecognitionException {
		Originalnamespace_nameContext _localctx = new Originalnamespace_nameContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_originalnamespace_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1071);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamespacedefinitionContext extends ParserRuleContext {
		public NamednamespacedefinitionContext namednamespacedefinition() {
			return getRuleContext(NamednamespacedefinitionContext.class,0);
		}
		public UnnamednamespacedefinitionContext unnamednamespacedefinition() {
			return getRuleContext(UnnamednamespacedefinitionContext.class,0);
		}
		public NamespacedefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespacedefinition; }
	}

	public final NamespacedefinitionContext namespacedefinition() throws RecognitionException {
		NamespacedefinitionContext _localctx = new NamespacedefinitionContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_namespacedefinition);
		try {
			setState(1075);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,104,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1073);
				namednamespacedefinition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1074);
				unnamednamespacedefinition();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamednamespacedefinitionContext extends ParserRuleContext {
		public OriginalnamespacedefinitionContext originalnamespacedefinition() {
			return getRuleContext(OriginalnamespacedefinitionContext.class,0);
		}
		public ExtensionnamespacedefinitionContext extensionnamespacedefinition() {
			return getRuleContext(ExtensionnamespacedefinitionContext.class,0);
		}
		public NamednamespacedefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namednamespacedefinition; }
	}

	public final NamednamespacedefinitionContext namednamespacedefinition() throws RecognitionException {
		NamednamespacedefinitionContext _localctx = new NamednamespacedefinitionContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_namednamespacedefinition);
		try {
			setState(1079);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,105,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1077);
				originalnamespacedefinition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1078);
				extensionnamespacedefinition();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OriginalnamespacedefinitionContext extends ParserRuleContext {
		public TerminalNode Namespace() { return getToken(PandaParser.Namespace, 0); }
		public TerminalNode Identifier() { return getToken(PandaParser.Identifier, 0); }
		public NamespacebodyContext namespacebody() {
			return getRuleContext(NamespacebodyContext.class,0);
		}
		public OriginalnamespacedefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_originalnamespacedefinition; }
	}

	public final OriginalnamespacedefinitionContext originalnamespacedefinition() throws RecognitionException {
		OriginalnamespacedefinitionContext _localctx = new OriginalnamespacedefinitionContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_originalnamespacedefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1081);
			match(Namespace);
			setState(1082);
			match(Identifier);
			setState(1083);
			match(LeftBrace);
			setState(1084);
			namespacebody();
			setState(1085);
			match(RightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExtensionnamespacedefinitionContext extends ParserRuleContext {
		public TerminalNode Namespace() { return getToken(PandaParser.Namespace, 0); }
		public Originalnamespace_nameContext originalnamespace_name() {
			return getRuleContext(Originalnamespace_nameContext.class,0);
		}
		public NamespacebodyContext namespacebody() {
			return getRuleContext(NamespacebodyContext.class,0);
		}
		public ExtensionnamespacedefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extensionnamespacedefinition; }
	}

	public final ExtensionnamespacedefinitionContext extensionnamespacedefinition() throws RecognitionException {
		ExtensionnamespacedefinitionContext _localctx = new ExtensionnamespacedefinitionContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_extensionnamespacedefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1087);
			match(Namespace);
			setState(1088);
			originalnamespace_name();
			setState(1089);
			match(LeftBrace);
			setState(1090);
			namespacebody();
			setState(1091);
			match(RightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnnamednamespacedefinitionContext extends ParserRuleContext {
		public TerminalNode Namespace() { return getToken(PandaParser.Namespace, 0); }
		public NamespacebodyContext namespacebody() {
			return getRuleContext(NamespacebodyContext.class,0);
		}
		public UnnamednamespacedefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unnamednamespacedefinition; }
	}

	public final UnnamednamespacedefinitionContext unnamednamespacedefinition() throws RecognitionException {
		UnnamednamespacedefinitionContext _localctx = new UnnamednamespacedefinitionContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_unnamednamespacedefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1093);
			match(Namespace);
			setState(1094);
			match(LeftBrace);
			setState(1095);
			namespacebody();
			setState(1096);
			match(RightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamespacebodyContext extends ParserRuleContext {
		public Declaration_sequenceContext declaration_sequence() {
			return getRuleContext(Declaration_sequenceContext.class,0);
		}
		public NamespacebodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespacebody; }
	}

	public final NamespacebodyContext namespacebody() throws RecognitionException {
		NamespacebodyContext _localctx = new NamespacebodyContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_namespacebody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1099);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Auto) | (1L << Bool) | (1L << Class) | (1L << Double) | (1L << Enum) | (1L << F32) | (1L << F64) | (1L << Float) | (1L << Int) | (1L << Int8) | (1L << Int16) | (1L << Int32) | (1L << Int64) | (1L << Long) | (1L << Namespace) | (1L << Operator) | (1L << Static) | (1L << Short) | (1L << Uint) | (1L << Uint8) | (1L << Uint16) | (1L << Uint32) | (1L << Uint64) | (1L << Ulong) | (1L << Ushort) | (1L << Using) | (1L << Void) | (1L << LeftParen) | (1L << LeftBracket))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (And - 71)) | (1L << (Semi - 71)) | (1L << (Dot - 71)) | (1L << (Ellipsis - 71)) | (1L << (Identifier - 71)))) != 0)) {
				{
				setState(1098);
				declaration_sequence(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamespacealiasContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PandaParser.Identifier, 0); }
		public NamespacealiasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespacealias; }
	}

	public final NamespacealiasContext namespacealias() throws RecognitionException {
		NamespacealiasContext _localctx = new NamespacealiasContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_namespacealias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1101);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamespacealiasdefinitionContext extends ParserRuleContext {
		public TerminalNode Namespace() { return getToken(PandaParser.Namespace, 0); }
		public TerminalNode Identifier() { return getToken(PandaParser.Identifier, 0); }
		public QualifiednamespacespecifierContext qualifiednamespacespecifier() {
			return getRuleContext(QualifiednamespacespecifierContext.class,0);
		}
		public NamespacealiasdefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespacealiasdefinition; }
	}

	public final NamespacealiasdefinitionContext namespacealiasdefinition() throws RecognitionException {
		NamespacealiasdefinitionContext _localctx = new NamespacealiasdefinitionContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_namespacealiasdefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1103);
			match(Namespace);
			setState(1104);
			match(Identifier);
			setState(1105);
			match(Assign);
			setState(1106);
			qualifiednamespacespecifier();
			setState(1107);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QualifiednamespacespecifierContext extends ParserRuleContext {
		public Namespace_nameContext namespace_name() {
			return getRuleContext(Namespace_nameContext.class,0);
		}
		public Nested_name_specifierContext nested_name_specifier() {
			return getRuleContext(Nested_name_specifierContext.class,0);
		}
		public QualifiednamespacespecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiednamespacespecifier; }
	}

	public final QualifiednamespacespecifierContext qualifiednamespacespecifier() throws RecognitionException {
		QualifiednamespacespecifierContext _localctx = new QualifiednamespacespecifierContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_qualifiednamespacespecifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,107,_ctx) ) {
			case 1:
				{
				setState(1109);
				nested_name_specifier(0);
				}
				break;
			}
			setState(1112);
			namespace_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UsingdeclarationContext extends ParserRuleContext {
		public TerminalNode Using() { return getToken(PandaParser.Using, 0); }
		public Nested_name_specifierContext nested_name_specifier() {
			return getRuleContext(Nested_name_specifierContext.class,0);
		}
		public Unqualified_idContext unqualified_id() {
			return getRuleContext(Unqualified_idContext.class,0);
		}
		public UsingdeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_usingdeclaration; }
	}

	public final UsingdeclarationContext usingdeclaration() throws RecognitionException {
		UsingdeclarationContext _localctx = new UsingdeclarationContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_usingdeclaration);
		try {
			setState(1124);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,108,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1114);
				match(Using);
				setState(1115);
				nested_name_specifier(0);
				setState(1116);
				unqualified_id();
				setState(1117);
				match(Semi);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1119);
				match(Using);
				setState(1120);
				match(T__5);
				setState(1121);
				unqualified_id();
				setState(1122);
				match(Semi);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UsingdirectiveContext extends ParserRuleContext {
		public TerminalNode Using() { return getToken(PandaParser.Using, 0); }
		public TerminalNode Namespace() { return getToken(PandaParser.Namespace, 0); }
		public Namespace_nameContext namespace_name() {
			return getRuleContext(Namespace_nameContext.class,0);
		}
		public Attribute_specifier_sequenceContext attribute_specifier_sequence() {
			return getRuleContext(Attribute_specifier_sequenceContext.class,0);
		}
		public Nested_name_specifierContext nested_name_specifier() {
			return getRuleContext(Nested_name_specifierContext.class,0);
		}
		public UsingdirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_usingdirective; }
	}

	public final UsingdirectiveContext usingdirective() throws RecognitionException {
		UsingdirectiveContext _localctx = new UsingdirectiveContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_usingdirective);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LeftBracket) {
				{
				setState(1126);
				attribute_specifier_sequence(0);
				}
			}

			setState(1129);
			match(Using);
			setState(1130);
			match(Namespace);
			setState(1132);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,110,_ctx) ) {
			case 1:
				{
				setState(1131);
				nested_name_specifier(0);
				}
				break;
			}
			setState(1134);
			namespace_name();
			setState(1135);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Attribute_specifier_sequenceContext extends ParserRuleContext {
		public AttributespecifierContext attributespecifier() {
			return getRuleContext(AttributespecifierContext.class,0);
		}
		public Attribute_specifier_sequenceContext attribute_specifier_sequence() {
			return getRuleContext(Attribute_specifier_sequenceContext.class,0);
		}
		public Attribute_specifier_sequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute_specifier_sequence; }
	}

	public final Attribute_specifier_sequenceContext attribute_specifier_sequence() throws RecognitionException {
		return attribute_specifier_sequence(0);
	}

	private Attribute_specifier_sequenceContext attribute_specifier_sequence(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Attribute_specifier_sequenceContext _localctx = new Attribute_specifier_sequenceContext(_ctx, _parentState);
		Attribute_specifier_sequenceContext _prevctx = _localctx;
		int _startState = 170;
		enterRecursionRule(_localctx, 170, RULE_attribute_specifier_sequence, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1138);
			attributespecifier();
			}
			_ctx.stop = _input.LT(-1);
			setState(1144);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,111,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Attribute_specifier_sequenceContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_attribute_specifier_sequence);
					setState(1140);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1141);
					attributespecifier();
					}
					} 
				}
				setState(1146);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,111,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AttributespecifierContext extends ParserRuleContext {
		public AttributelistContext attributelist() {
			return getRuleContext(AttributelistContext.class,0);
		}
		public AttributespecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributespecifier; }
	}

	public final AttributespecifierContext attributespecifier() throws RecognitionException {
		AttributespecifierContext _localctx = new AttributespecifierContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_attributespecifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1147);
			match(LeftBracket);
			setState(1148);
			match(LeftBracket);
			setState(1149);
			attributelist(0);
			setState(1150);
			match(RightBracket);
			setState(1151);
			match(RightBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributelistContext extends ParserRuleContext {
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public AttributelistContext attributelist() {
			return getRuleContext(AttributelistContext.class,0);
		}
		public AttributelistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributelist; }
	}

	public final AttributelistContext attributelist() throws RecognitionException {
		return attributelist(0);
	}

	private AttributelistContext attributelist(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AttributelistContext _localctx = new AttributelistContext(_ctx, _parentState);
		AttributelistContext _prevctx = _localctx;
		int _startState = 174;
		enterRecursionRule(_localctx, 174, RULE_attributelist, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1160);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,113,_ctx) ) {
			case 1:
				{
				setState(1155);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
				case 1:
					{
					setState(1154);
					attribute();
					}
					break;
				}
				}
				break;
			case 2:
				{
				setState(1157);
				attribute();
				setState(1158);
				match(Ellipsis);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1174);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,116,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1172);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,115,_ctx) ) {
					case 1:
						{
						_localctx = new AttributelistContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_attributelist);
						setState(1162);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(1163);
						match(Comma);
						setState(1165);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
						case 1:
							{
							setState(1164);
							attribute();
							}
							break;
						}
						}
						break;
					case 2:
						{
						_localctx = new AttributelistContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_attributelist);
						setState(1167);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(1168);
						match(Comma);
						setState(1169);
						attribute();
						setState(1170);
						match(Ellipsis);
						}
						break;
					}
					} 
				}
				setState(1176);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,116,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AttributeContext extends ParserRuleContext {
		public AttributetokenContext attributetoken() {
			return getRuleContext(AttributetokenContext.class,0);
		}
		public AttributeargumentclauseContext attributeargumentclause() {
			return getRuleContext(AttributeargumentclauseContext.class,0);
		}
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_attribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1177);
			attributetoken();
			setState(1179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,117,_ctx) ) {
			case 1:
				{
				setState(1178);
				attributeargumentclause();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributetokenContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PandaParser.Identifier, 0); }
		public AttributescopedtokenContext attributescopedtoken() {
			return getRuleContext(AttributescopedtokenContext.class,0);
		}
		public AttributetokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributetoken; }
	}

	public final AttributetokenContext attributetoken() throws RecognitionException {
		AttributetokenContext _localctx = new AttributetokenContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_attributetoken);
		try {
			setState(1183);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,118,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1181);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1182);
				attributescopedtoken();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributescopedtokenContext extends ParserRuleContext {
		public AttributenamespaceContext attributenamespace() {
			return getRuleContext(AttributenamespaceContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(PandaParser.Identifier, 0); }
		public AttributescopedtokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributescopedtoken; }
	}

	public final AttributescopedtokenContext attributescopedtoken() throws RecognitionException {
		AttributescopedtokenContext _localctx = new AttributescopedtokenContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_attributescopedtoken);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1185);
			attributenamespace();
			setState(1186);
			match(T__5);
			setState(1187);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributenamespaceContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PandaParser.Identifier, 0); }
		public AttributenamespaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributenamespace; }
	}

	public final AttributenamespaceContext attributenamespace() throws RecognitionException {
		AttributenamespaceContext _localctx = new AttributenamespaceContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_attributenamespace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1189);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributeargumentclauseContext extends ParserRuleContext {
		public BalancedtokenseqContext balancedtokenseq() {
			return getRuleContext(BalancedtokenseqContext.class,0);
		}
		public AttributeargumentclauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeargumentclause; }
	}

	public final AttributeargumentclauseContext attributeargumentclause() throws RecognitionException {
		AttributeargumentclauseContext _localctx = new AttributeargumentclauseContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_attributeargumentclause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1191);
			match(LeftParen);
			setState(1192);
			balancedtokenseq(0);
			setState(1193);
			match(RightParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BalancedtokenseqContext extends ParserRuleContext {
		public BalancedtokenContext balancedtoken() {
			return getRuleContext(BalancedtokenContext.class,0);
		}
		public BalancedtokenseqContext balancedtokenseq() {
			return getRuleContext(BalancedtokenseqContext.class,0);
		}
		public BalancedtokenseqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_balancedtokenseq; }
	}

	public final BalancedtokenseqContext balancedtokenseq() throws RecognitionException {
		return balancedtokenseq(0);
	}

	private BalancedtokenseqContext balancedtokenseq(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BalancedtokenseqContext _localctx = new BalancedtokenseqContext(_ctx, _parentState);
		BalancedtokenseqContext _prevctx = _localctx;
		int _startState = 186;
		enterRecursionRule(_localctx, 186, RULE_balancedtokenseq, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,119,_ctx) ) {
			case 1:
				{
				setState(1196);
				balancedtoken();
				}
				break;
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(1203);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,120,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BalancedtokenseqContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_balancedtokenseq);
					setState(1199);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1200);
					balancedtoken();
					}
					} 
				}
				setState(1205);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,120,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BalancedtokenContext extends ParserRuleContext {
		public BalancedtokenseqContext balancedtokenseq() {
			return getRuleContext(BalancedtokenseqContext.class,0);
		}
		public BalancedtokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_balancedtoken; }
	}

	public final BalancedtokenContext balancedtoken() throws RecognitionException {
		BalancedtokenContext _localctx = new BalancedtokenContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_balancedtoken);
		try {
			setState(1218);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftParen:
				enterOuterAlt(_localctx, 1);
				{
				setState(1206);
				match(LeftParen);
				setState(1207);
				balancedtokenseq(0);
				setState(1208);
				match(RightParen);
				}
				break;
			case LeftBracket:
				enterOuterAlt(_localctx, 2);
				{
				setState(1210);
				match(LeftBracket);
				setState(1211);
				balancedtokenseq(0);
				setState(1212);
				match(RightBracket);
				}
				break;
			case LeftBrace:
				enterOuterAlt(_localctx, 3);
				{
				setState(1214);
				match(LeftBrace);
				setState(1215);
				balancedtokenseq(0);
				setState(1216);
				match(RightBrace);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitdeclaratorlistContext extends ParserRuleContext {
		public InitdeclaratorContext initdeclarator() {
			return getRuleContext(InitdeclaratorContext.class,0);
		}
		public InitdeclaratorlistContext initdeclaratorlist() {
			return getRuleContext(InitdeclaratorlistContext.class,0);
		}
		public InitdeclaratorlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initdeclaratorlist; }
	}

	public final InitdeclaratorlistContext initdeclaratorlist() throws RecognitionException {
		return initdeclaratorlist(0);
	}

	private InitdeclaratorlistContext initdeclaratorlist(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		InitdeclaratorlistContext _localctx = new InitdeclaratorlistContext(_ctx, _parentState);
		InitdeclaratorlistContext _prevctx = _localctx;
		int _startState = 190;
		enterRecursionRule(_localctx, 190, RULE_initdeclaratorlist, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1221);
			initdeclarator();
			}
			_ctx.stop = _input.LT(-1);
			setState(1228);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,122,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new InitdeclaratorlistContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_initdeclaratorlist);
					setState(1223);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1224);
					match(Comma);
					setState(1225);
					initdeclarator();
					}
					} 
				}
				setState(1230);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,122,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class InitdeclaratorContext extends ParserRuleContext {
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public InitdeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initdeclarator; }
	}

	public final InitdeclaratorContext initdeclarator() throws RecognitionException {
		InitdeclaratorContext _localctx = new InitdeclaratorContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_initdeclarator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1231);
			declarator();
			setState(1233);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,123,_ctx) ) {
			case 1:
				{
				setState(1232);
				initializer();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaratorContext extends ParserRuleContext {
		public PtrdeclaratorContext ptrdeclarator() {
			return getRuleContext(PtrdeclaratorContext.class,0);
		}
		public NoptrdeclaratorContext noptrdeclarator() {
			return getRuleContext(NoptrdeclaratorContext.class,0);
		}
		public ParametersandqualifiersContext parametersandqualifiers() {
			return getRuleContext(ParametersandqualifiersContext.class,0);
		}
		public Trailing_return_typeContext trailing_return_type() {
			return getRuleContext(Trailing_return_typeContext.class,0);
		}
		public DeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarator; }
	}

	public final DeclaratorContext declarator() throws RecognitionException {
		DeclaratorContext _localctx = new DeclaratorContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_declarator);
		try {
			setState(1240);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,124,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1235);
				ptrdeclarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1236);
				noptrdeclarator(0);
				setState(1237);
				parametersandqualifiers();
				setState(1238);
				trailing_return_type();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PtrdeclaratorContext extends ParserRuleContext {
		public NoptrdeclaratorContext noptrdeclarator() {
			return getRuleContext(NoptrdeclaratorContext.class,0);
		}
		public Reference_operatorContext reference_operator() {
			return getRuleContext(Reference_operatorContext.class,0);
		}
		public PtrdeclaratorContext ptrdeclarator() {
			return getRuleContext(PtrdeclaratorContext.class,0);
		}
		public PtrdeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ptrdeclarator; }
	}

	public final PtrdeclaratorContext ptrdeclarator() throws RecognitionException {
		PtrdeclaratorContext _localctx = new PtrdeclaratorContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_ptrdeclarator);
		try {
			setState(1246);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Operator:
			case LeftParen:
			case Dot:
			case Ellipsis:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(1242);
				noptrdeclarator(0);
				}
				break;
			case And:
				enterOuterAlt(_localctx, 2);
				{
				setState(1243);
				reference_operator();
				setState(1244);
				ptrdeclarator();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NoptrdeclaratorContext extends ParserRuleContext {
		public DeclaratoridContext declaratorid() {
			return getRuleContext(DeclaratoridContext.class,0);
		}
		public Attribute_specifier_sequenceContext attribute_specifier_sequence() {
			return getRuleContext(Attribute_specifier_sequenceContext.class,0);
		}
		public PtrdeclaratorContext ptrdeclarator() {
			return getRuleContext(PtrdeclaratorContext.class,0);
		}
		public NoptrdeclaratorContext noptrdeclarator() {
			return getRuleContext(NoptrdeclaratorContext.class,0);
		}
		public ParametersandqualifiersContext parametersandqualifiers() {
			return getRuleContext(ParametersandqualifiersContext.class,0);
		}
		public ConstantexpressionContext constantexpression() {
			return getRuleContext(ConstantexpressionContext.class,0);
		}
		public NoptrdeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noptrdeclarator; }
	}

	public final NoptrdeclaratorContext noptrdeclarator() throws RecognitionException {
		return noptrdeclarator(0);
	}

	private NoptrdeclaratorContext noptrdeclarator(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		NoptrdeclaratorContext _localctx = new NoptrdeclaratorContext(_ctx, _parentState);
		NoptrdeclaratorContext _prevctx = _localctx;
		int _startState = 198;
		enterRecursionRule(_localctx, 198, RULE_noptrdeclarator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1257);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Operator:
			case Dot:
			case Ellipsis:
			case Identifier:
				{
				setState(1249);
				declaratorid();
				setState(1251);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,126,_ctx) ) {
				case 1:
					{
					setState(1250);
					attribute_specifier_sequence(0);
					}
					break;
				}
				}
				break;
			case LeftParen:
				{
				setState(1253);
				match(LeftParen);
				setState(1254);
				ptrdeclarator();
				setState(1255);
				match(RightParen);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(1272);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,131,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1270);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,130,_ctx) ) {
					case 1:
						{
						_localctx = new NoptrdeclaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_noptrdeclarator);
						setState(1259);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(1260);
						parametersandqualifiers();
						}
						break;
					case 2:
						{
						_localctx = new NoptrdeclaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_noptrdeclarator);
						setState(1261);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(1262);
						match(LeftBracket);
						setState(1264);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Auto) | (1L << Bool) | (1L << Double) | (1L << F32) | (1L << F64) | (1L << Float) | (1L << Int) | (1L << Int8) | (1L << Int16) | (1L << Int32) | (1L << Int64) | (1L << Long) | (1L << New) | (1L << Operator) | (1L << Short) | (1L << This) | (1L << Uint) | (1L << Uint8) | (1L << Uint16) | (1L << Uint32) | (1L << Uint64) | (1L << Ulong) | (1L << Ushort) | (1L << Void) | (1L << LeftParen) | (1L << LeftBrace))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (Plus - 65)) | (1L << (Minus - 65)) | (1L << (Or - 65)) | (1L << (Tilde - 65)) | (1L << (Not - 65)) | (1L << (PlusPlus - 65)) | (1L << (MinusMinus - 65)) | (1L << (Dot - 65)) | (1L << (Identifier - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (PointerLiteral - 65)))) != 0)) {
							{
							setState(1263);
							constantexpression();
							}
						}

						setState(1266);
						match(RightBracket);
						setState(1268);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,129,_ctx) ) {
						case 1:
							{
							setState(1267);
							attribute_specifier_sequence(0);
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(1274);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,131,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ParametersandqualifiersContext extends ParserRuleContext {
		public Parameter_declaration_clauseContext parameter_declaration_clause() {
			return getRuleContext(Parameter_declaration_clauseContext.class,0);
		}
		public RefqualifierContext refqualifier() {
			return getRuleContext(RefqualifierContext.class,0);
		}
		public Exception_specificationContext exception_specification() {
			return getRuleContext(Exception_specificationContext.class,0);
		}
		public Attribute_specifier_sequenceContext attribute_specifier_sequence() {
			return getRuleContext(Attribute_specifier_sequenceContext.class,0);
		}
		public ParametersandqualifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametersandqualifiers; }
	}

	public final ParametersandqualifiersContext parametersandqualifiers() throws RecognitionException {
		ParametersandqualifiersContext _localctx = new ParametersandqualifiersContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_parametersandqualifiers);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1275);
			match(LeftParen);
			setState(1276);
			parameter_declaration_clause();
			setState(1277);
			match(RightParen);
			setState(1279);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,132,_ctx) ) {
			case 1:
				{
				setState(1278);
				refqualifier();
				}
				break;
			}
			setState(1282);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,133,_ctx) ) {
			case 1:
				{
				setState(1281);
				exception_specification();
				}
				break;
			}
			setState(1285);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,134,_ctx) ) {
			case 1:
				{
				setState(1284);
				attribute_specifier_sequence(0);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Trailing_return_typeContext extends ParserRuleContext {
		public Trailing_type_specifier_sequenceContext trailing_type_specifier_sequence() {
			return getRuleContext(Trailing_type_specifier_sequenceContext.class,0);
		}
		public Abstract_declaratorContext abstract_declarator() {
			return getRuleContext(Abstract_declaratorContext.class,0);
		}
		public Trailing_return_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trailing_return_type; }
	}

	public final Trailing_return_typeContext trailing_return_type() throws RecognitionException {
		Trailing_return_typeContext _localctx = new Trailing_return_typeContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_trailing_return_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1287);
			match(T__6);
			setState(1288);
			trailing_type_specifier_sequence();
			setState(1290);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,135,_ctx) ) {
			case 1:
				{
				setState(1289);
				abstract_declarator();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Reference_operatorContext extends ParserRuleContext {
		public Attribute_specifier_sequenceContext attribute_specifier_sequence() {
			return getRuleContext(Attribute_specifier_sequenceContext.class,0);
		}
		public Reference_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reference_operator; }
	}

	public final Reference_operatorContext reference_operator() throws RecognitionException {
		Reference_operatorContext _localctx = new Reference_operatorContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_reference_operator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1292);
			match(And);
			setState(1294);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,136,_ctx) ) {
			case 1:
				{
				setState(1293);
				attribute_specifier_sequence(0);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RefqualifierContext extends ParserRuleContext {
		public RefqualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_refqualifier; }
	}

	public final RefqualifierContext refqualifier() throws RecognitionException {
		RefqualifierContext _localctx = new RefqualifierContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_refqualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1296);
			_la = _input.LA(1);
			if ( !(_la==And || _la==AndAnd) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaratoridContext extends ParserRuleContext {
		public Id_expressionContext id_expression() {
			return getRuleContext(Id_expressionContext.class,0);
		}
		public DeclaratoridContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaratorid; }
	}

	public final DeclaratoridContext declaratorid() throws RecognitionException {
		DeclaratoridContext _localctx = new DeclaratoridContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_declaratorid);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1299);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ellipsis) {
				{
				setState(1298);
				match(Ellipsis);
				}
			}

			setState(1301);
			id_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_idContext extends ParserRuleContext {
		public Type_specifier_sequenceContext type_specifier_sequence() {
			return getRuleContext(Type_specifier_sequenceContext.class,0);
		}
		public Abstract_declaratorContext abstract_declarator() {
			return getRuleContext(Abstract_declaratorContext.class,0);
		}
		public Type_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_id; }
	}

	public final Type_idContext type_id() throws RecognitionException {
		Type_idContext _localctx = new Type_idContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_type_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1303);
			type_specifier_sequence();
			setState(1305);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,138,_ctx) ) {
			case 1:
				{
				setState(1304);
				abstract_declarator();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Abstract_declaratorContext extends ParserRuleContext {
		public Ptrabstract_declaratorContext ptrabstract_declarator() {
			return getRuleContext(Ptrabstract_declaratorContext.class,0);
		}
		public ParametersandqualifiersContext parametersandqualifiers() {
			return getRuleContext(ParametersandqualifiersContext.class,0);
		}
		public Trailing_return_typeContext trailing_return_type() {
			return getRuleContext(Trailing_return_typeContext.class,0);
		}
		public Noptrabstract_declaratorContext noptrabstract_declarator() {
			return getRuleContext(Noptrabstract_declaratorContext.class,0);
		}
		public AbstractpackdeclaratorContext abstractpackdeclarator() {
			return getRuleContext(AbstractpackdeclaratorContext.class,0);
		}
		public Abstract_declaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abstract_declarator; }
	}

	public final Abstract_declaratorContext abstract_declarator() throws RecognitionException {
		Abstract_declaratorContext _localctx = new Abstract_declaratorContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_abstract_declarator);
		try {
			setState(1315);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,140,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1307);
				ptrabstract_declarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1309);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,139,_ctx) ) {
				case 1:
					{
					setState(1308);
					noptrabstract_declarator(0);
					}
					break;
				}
				setState(1311);
				parametersandqualifiers();
				setState(1312);
				trailing_return_type();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1314);
				abstractpackdeclarator();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ptrabstract_declaratorContext extends ParserRuleContext {
		public Noptrabstract_declaratorContext noptrabstract_declarator() {
			return getRuleContext(Noptrabstract_declaratorContext.class,0);
		}
		public Reference_operatorContext reference_operator() {
			return getRuleContext(Reference_operatorContext.class,0);
		}
		public Ptrabstract_declaratorContext ptrabstract_declarator() {
			return getRuleContext(Ptrabstract_declaratorContext.class,0);
		}
		public Ptrabstract_declaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ptrabstract_declarator; }
	}

	public final Ptrabstract_declaratorContext ptrabstract_declarator() throws RecognitionException {
		Ptrabstract_declaratorContext _localctx = new Ptrabstract_declaratorContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_ptrabstract_declarator);
		try {
			setState(1322);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftParen:
			case LeftBracket:
				enterOuterAlt(_localctx, 1);
				{
				setState(1317);
				noptrabstract_declarator(0);
				}
				break;
			case And:
				enterOuterAlt(_localctx, 2);
				{
				setState(1318);
				reference_operator();
				setState(1320);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,141,_ctx) ) {
				case 1:
					{
					setState(1319);
					ptrabstract_declarator();
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Noptrabstract_declaratorContext extends ParserRuleContext {
		public ParametersandqualifiersContext parametersandqualifiers() {
			return getRuleContext(ParametersandqualifiersContext.class,0);
		}
		public ConstantexpressionContext constantexpression() {
			return getRuleContext(ConstantexpressionContext.class,0);
		}
		public Attribute_specifier_sequenceContext attribute_specifier_sequence() {
			return getRuleContext(Attribute_specifier_sequenceContext.class,0);
		}
		public Ptrabstract_declaratorContext ptrabstract_declarator() {
			return getRuleContext(Ptrabstract_declaratorContext.class,0);
		}
		public Noptrabstract_declaratorContext noptrabstract_declarator() {
			return getRuleContext(Noptrabstract_declaratorContext.class,0);
		}
		public Noptrabstract_declaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noptrabstract_declarator; }
	}

	public final Noptrabstract_declaratorContext noptrabstract_declarator() throws RecognitionException {
		return noptrabstract_declarator(0);
	}

	private Noptrabstract_declaratorContext noptrabstract_declarator(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Noptrabstract_declaratorContext _localctx = new Noptrabstract_declaratorContext(_ctx, _parentState);
		Noptrabstract_declaratorContext _prevctx = _localctx;
		int _startState = 216;
		enterRecursionRule(_localctx, 216, RULE_noptrabstract_declarator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1338);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,145,_ctx) ) {
			case 1:
				{
				setState(1325);
				parametersandqualifiers();
				}
				break;
			case 2:
				{
				setState(1326);
				match(LeftBracket);
				setState(1328);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Auto) | (1L << Bool) | (1L << Double) | (1L << F32) | (1L << F64) | (1L << Float) | (1L << Int) | (1L << Int8) | (1L << Int16) | (1L << Int32) | (1L << Int64) | (1L << Long) | (1L << New) | (1L << Operator) | (1L << Short) | (1L << This) | (1L << Uint) | (1L << Uint8) | (1L << Uint16) | (1L << Uint32) | (1L << Uint64) | (1L << Ulong) | (1L << Ushort) | (1L << Void) | (1L << LeftParen) | (1L << LeftBrace))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (Plus - 65)) | (1L << (Minus - 65)) | (1L << (Or - 65)) | (1L << (Tilde - 65)) | (1L << (Not - 65)) | (1L << (PlusPlus - 65)) | (1L << (MinusMinus - 65)) | (1L << (Dot - 65)) | (1L << (Identifier - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (PointerLiteral - 65)))) != 0)) {
					{
					setState(1327);
					constantexpression();
					}
				}

				setState(1330);
				match(RightBracket);
				setState(1332);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,144,_ctx) ) {
				case 1:
					{
					setState(1331);
					attribute_specifier_sequence(0);
					}
					break;
				}
				}
				break;
			case 3:
				{
				setState(1334);
				match(LeftParen);
				setState(1335);
				ptrabstract_declarator();
				setState(1336);
				match(RightParen);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1353);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,149,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1351);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,148,_ctx) ) {
					case 1:
						{
						_localctx = new Noptrabstract_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_noptrabstract_declarator);
						setState(1340);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(1341);
						parametersandqualifiers();
						}
						break;
					case 2:
						{
						_localctx = new Noptrabstract_declaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_noptrabstract_declarator);
						setState(1342);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(1343);
						match(LeftBracket);
						setState(1345);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Auto) | (1L << Bool) | (1L << Double) | (1L << F32) | (1L << F64) | (1L << Float) | (1L << Int) | (1L << Int8) | (1L << Int16) | (1L << Int32) | (1L << Int64) | (1L << Long) | (1L << New) | (1L << Operator) | (1L << Short) | (1L << This) | (1L << Uint) | (1L << Uint8) | (1L << Uint16) | (1L << Uint32) | (1L << Uint64) | (1L << Ulong) | (1L << Ushort) | (1L << Void) | (1L << LeftParen) | (1L << LeftBrace))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (Plus - 65)) | (1L << (Minus - 65)) | (1L << (Or - 65)) | (1L << (Tilde - 65)) | (1L << (Not - 65)) | (1L << (PlusPlus - 65)) | (1L << (MinusMinus - 65)) | (1L << (Dot - 65)) | (1L << (Identifier - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (PointerLiteral - 65)))) != 0)) {
							{
							setState(1344);
							constantexpression();
							}
						}

						setState(1347);
						match(RightBracket);
						setState(1349);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,147,_ctx) ) {
						case 1:
							{
							setState(1348);
							attribute_specifier_sequence(0);
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(1355);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,149,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AbstractpackdeclaratorContext extends ParserRuleContext {
		public NoptrabstractpackdeclaratorContext noptrabstractpackdeclarator() {
			return getRuleContext(NoptrabstractpackdeclaratorContext.class,0);
		}
		public Reference_operatorContext reference_operator() {
			return getRuleContext(Reference_operatorContext.class,0);
		}
		public AbstractpackdeclaratorContext abstractpackdeclarator() {
			return getRuleContext(AbstractpackdeclaratorContext.class,0);
		}
		public AbstractpackdeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abstractpackdeclarator; }
	}

	public final AbstractpackdeclaratorContext abstractpackdeclarator() throws RecognitionException {
		AbstractpackdeclaratorContext _localctx = new AbstractpackdeclaratorContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_abstractpackdeclarator);
		try {
			setState(1360);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Ellipsis:
				enterOuterAlt(_localctx, 1);
				{
				setState(1356);
				noptrabstractpackdeclarator(0);
				}
				break;
			case And:
				enterOuterAlt(_localctx, 2);
				{
				setState(1357);
				reference_operator();
				setState(1358);
				abstractpackdeclarator();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NoptrabstractpackdeclaratorContext extends ParserRuleContext {
		public NoptrabstractpackdeclaratorContext noptrabstractpackdeclarator() {
			return getRuleContext(NoptrabstractpackdeclaratorContext.class,0);
		}
		public ParametersandqualifiersContext parametersandqualifiers() {
			return getRuleContext(ParametersandqualifiersContext.class,0);
		}
		public ConstantexpressionContext constantexpression() {
			return getRuleContext(ConstantexpressionContext.class,0);
		}
		public Attribute_specifier_sequenceContext attribute_specifier_sequence() {
			return getRuleContext(Attribute_specifier_sequenceContext.class,0);
		}
		public NoptrabstractpackdeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noptrabstractpackdeclarator; }
	}

	public final NoptrabstractpackdeclaratorContext noptrabstractpackdeclarator() throws RecognitionException {
		return noptrabstractpackdeclarator(0);
	}

	private NoptrabstractpackdeclaratorContext noptrabstractpackdeclarator(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		NoptrabstractpackdeclaratorContext _localctx = new NoptrabstractpackdeclaratorContext(_ctx, _parentState);
		NoptrabstractpackdeclaratorContext _prevctx = _localctx;
		int _startState = 220;
		enterRecursionRule(_localctx, 220, RULE_noptrabstractpackdeclarator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1363);
			match(Ellipsis);
			}
			_ctx.stop = _input.LT(-1);
			setState(1378);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,154,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1376);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,153,_ctx) ) {
					case 1:
						{
						_localctx = new NoptrabstractpackdeclaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_noptrabstractpackdeclarator);
						setState(1365);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(1366);
						parametersandqualifiers();
						}
						break;
					case 2:
						{
						_localctx = new NoptrabstractpackdeclaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_noptrabstractpackdeclarator);
						setState(1367);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(1368);
						match(LeftBracket);
						setState(1370);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Auto) | (1L << Bool) | (1L << Double) | (1L << F32) | (1L << F64) | (1L << Float) | (1L << Int) | (1L << Int8) | (1L << Int16) | (1L << Int32) | (1L << Int64) | (1L << Long) | (1L << New) | (1L << Operator) | (1L << Short) | (1L << This) | (1L << Uint) | (1L << Uint8) | (1L << Uint16) | (1L << Uint32) | (1L << Uint64) | (1L << Ulong) | (1L << Ushort) | (1L << Void) | (1L << LeftParen) | (1L << LeftBrace))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (Plus - 65)) | (1L << (Minus - 65)) | (1L << (Or - 65)) | (1L << (Tilde - 65)) | (1L << (Not - 65)) | (1L << (PlusPlus - 65)) | (1L << (MinusMinus - 65)) | (1L << (Dot - 65)) | (1L << (Identifier - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (PointerLiteral - 65)))) != 0)) {
							{
							setState(1369);
							constantexpression();
							}
						}

						setState(1372);
						match(RightBracket);
						setState(1374);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,152,_ctx) ) {
						case 1:
							{
							setState(1373);
							attribute_specifier_sequence(0);
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(1380);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,154,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Parameter_declaration_clauseContext extends ParserRuleContext {
		public ParameterdeclarationlistContext parameterdeclarationlist() {
			return getRuleContext(ParameterdeclarationlistContext.class,0);
		}
		public Parameter_declaration_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_declaration_clause; }
	}

	public final Parameter_declaration_clauseContext parameter_declaration_clause() throws RecognitionException {
		Parameter_declaration_clauseContext _localctx = new Parameter_declaration_clauseContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_parameter_declaration_clause);
		int _la;
		try {
			setState(1391);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,157,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1382);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Auto) | (1L << Bool) | (1L << Class) | (1L << Double) | (1L << Enum) | (1L << F32) | (1L << F64) | (1L << Float) | (1L << Int) | (1L << Int8) | (1L << Int16) | (1L << Int32) | (1L << Int64) | (1L << Long) | (1L << Static) | (1L << Short) | (1L << Uint) | (1L << Uint8) | (1L << Uint16) | (1L << Uint32) | (1L << Uint64) | (1L << Ulong) | (1L << Ushort) | (1L << Void) | (1L << LeftBracket))) != 0) || _la==Dot || _la==Identifier) {
					{
					setState(1381);
					parameterdeclarationlist(0);
					}
				}

				setState(1385);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Ellipsis) {
					{
					setState(1384);
					match(Ellipsis);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1387);
				parameterdeclarationlist(0);
				setState(1388);
				match(Comma);
				setState(1389);
				match(Ellipsis);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterdeclarationlistContext extends ParserRuleContext {
		public ParameterdeclarationContext parameterdeclaration() {
			return getRuleContext(ParameterdeclarationContext.class,0);
		}
		public ParameterdeclarationlistContext parameterdeclarationlist() {
			return getRuleContext(ParameterdeclarationlistContext.class,0);
		}
		public ParameterdeclarationlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterdeclarationlist; }
	}

	public final ParameterdeclarationlistContext parameterdeclarationlist() throws RecognitionException {
		return parameterdeclarationlist(0);
	}

	private ParameterdeclarationlistContext parameterdeclarationlist(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ParameterdeclarationlistContext _localctx = new ParameterdeclarationlistContext(_ctx, _parentState);
		ParameterdeclarationlistContext _prevctx = _localctx;
		int _startState = 224;
		enterRecursionRule(_localctx, 224, RULE_parameterdeclarationlist, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1394);
			parameterdeclaration();
			}
			_ctx.stop = _input.LT(-1);
			setState(1401);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,158,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ParameterdeclarationlistContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_parameterdeclarationlist);
					setState(1396);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1397);
					match(Comma);
					setState(1398);
					parameterdeclaration();
					}
					} 
				}
				setState(1403);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,158,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ParameterdeclarationContext extends ParserRuleContext {
		public DeclspecifierseqContext declspecifierseq() {
			return getRuleContext(DeclspecifierseqContext.class,0);
		}
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public Attribute_specifier_sequenceContext attribute_specifier_sequence() {
			return getRuleContext(Attribute_specifier_sequenceContext.class,0);
		}
		public InitializerclauseContext initializerclause() {
			return getRuleContext(InitializerclauseContext.class,0);
		}
		public Abstract_declaratorContext abstract_declarator() {
			return getRuleContext(Abstract_declaratorContext.class,0);
		}
		public ParameterdeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterdeclaration; }
	}

	public final ParameterdeclarationContext parameterdeclaration() throws RecognitionException {
		ParameterdeclarationContext _localctx = new ParameterdeclarationContext(_ctx, getState());
		enterRule(_localctx, 226, RULE_parameterdeclaration);
		int _la;
		try {
			setState(1435);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,165,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1405);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftBracket) {
					{
					setState(1404);
					attribute_specifier_sequence(0);
					}
				}

				setState(1407);
				declspecifierseq();
				setState(1408);
				declarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1411);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftBracket) {
					{
					setState(1410);
					attribute_specifier_sequence(0);
					}
				}

				setState(1413);
				declspecifierseq();
				setState(1414);
				declarator();
				setState(1415);
				match(Assign);
				setState(1416);
				initializerclause();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1419);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftBracket) {
					{
					setState(1418);
					attribute_specifier_sequence(0);
					}
				}

				setState(1421);
				declspecifierseq();
				setState(1423);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,162,_ctx) ) {
				case 1:
					{
					setState(1422);
					abstract_declarator();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1426);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftBracket) {
					{
					setState(1425);
					attribute_specifier_sequence(0);
					}
				}

				setState(1428);
				declspecifierseq();
				setState(1430);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 59)) & ~0x3f) == 0 && ((1L << (_la - 59)) & ((1L << (LeftParen - 59)) | (1L << (LeftBracket - 59)) | (1L << (And - 59)) | (1L << (Ellipsis - 59)))) != 0)) {
					{
					setState(1429);
					abstract_declarator();
					}
				}

				setState(1432);
				match(Assign);
				setState(1433);
				initializerclause();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctiondefinitionContext extends ParserRuleContext {
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public FunctionbodyContext functionbody() {
			return getRuleContext(FunctionbodyContext.class,0);
		}
		public Attribute_specifier_sequenceContext attribute_specifier_sequence() {
			return getRuleContext(Attribute_specifier_sequenceContext.class,0);
		}
		public DeclspecifierseqContext declspecifierseq() {
			return getRuleContext(DeclspecifierseqContext.class,0);
		}
		public FunctiondefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functiondefinition; }
	}

	public final FunctiondefinitionContext functiondefinition() throws RecognitionException {
		FunctiondefinitionContext _localctx = new FunctiondefinitionContext(_ctx, getState());
		enterRule(_localctx, 228, RULE_functiondefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1438);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LeftBracket) {
				{
				setState(1437);
				attribute_specifier_sequence(0);
				}
			}

			setState(1441);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,167,_ctx) ) {
			case 1:
				{
				setState(1440);
				declspecifierseq();
				}
				break;
			}
			setState(1443);
			declarator();
			setState(1444);
			functionbody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionbodyContext extends ParserRuleContext {
		public Compound_statementContext compound_statement() {
			return getRuleContext(Compound_statementContext.class,0);
		}
		public CtorinitializerContext ctorinitializer() {
			return getRuleContext(CtorinitializerContext.class,0);
		}
		public FunctiontryblockContext functiontryblock() {
			return getRuleContext(FunctiontryblockContext.class,0);
		}
		public TerminalNode Default() { return getToken(PandaParser.Default, 0); }
		public FunctionbodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionbody; }
	}

	public final FunctionbodyContext functionbody() throws RecognitionException {
		FunctionbodyContext _localctx = new FunctionbodyContext(_ctx, getState());
		enterRule(_localctx, 230, RULE_functionbody);
		int _la;
		try {
			setState(1454);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftBrace:
			case Colon:
				enterOuterAlt(_localctx, 1);
				{
				setState(1447);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Colon) {
					{
					setState(1446);
					ctorinitializer();
					}
				}

				setState(1449);
				compound_statement();
				}
				break;
			case Try:
				enterOuterAlt(_localctx, 2);
				{
				setState(1450);
				functiontryblock();
				}
				break;
			case Assign:
				enterOuterAlt(_localctx, 3);
				{
				setState(1451);
				match(Assign);
				setState(1452);
				match(Default);
				setState(1453);
				match(Semi);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitializerContext extends ParserRuleContext {
		public BraceorequalinitializerContext braceorequalinitializer() {
			return getRuleContext(BraceorequalinitializerContext.class,0);
		}
		public Expression_listContext expression_list() {
			return getRuleContext(Expression_listContext.class,0);
		}
		public InitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer; }
	}

	public final InitializerContext initializer() throws RecognitionException {
		InitializerContext _localctx = new InitializerContext(_ctx, getState());
		enterRule(_localctx, 232, RULE_initializer);
		try {
			setState(1461);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftBrace:
			case Assign:
				enterOuterAlt(_localctx, 1);
				{
				setState(1456);
				braceorequalinitializer();
				}
				break;
			case LeftParen:
				enterOuterAlt(_localctx, 2);
				{
				setState(1457);
				match(LeftParen);
				setState(1458);
				expression_list();
				setState(1459);
				match(RightParen);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BraceorequalinitializerContext extends ParserRuleContext {
		public InitializerclauseContext initializerclause() {
			return getRuleContext(InitializerclauseContext.class,0);
		}
		public Braced_init_listContext braced_init_list() {
			return getRuleContext(Braced_init_listContext.class,0);
		}
		public BraceorequalinitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_braceorequalinitializer; }
	}

	public final BraceorequalinitializerContext braceorequalinitializer() throws RecognitionException {
		BraceorequalinitializerContext _localctx = new BraceorequalinitializerContext(_ctx, getState());
		enterRule(_localctx, 234, RULE_braceorequalinitializer);
		try {
			setState(1466);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Assign:
				enterOuterAlt(_localctx, 1);
				{
				setState(1463);
				match(Assign);
				setState(1464);
				initializerclause();
				}
				break;
			case LeftBrace:
				enterOuterAlt(_localctx, 2);
				{
				setState(1465);
				braced_init_list();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitializerclauseContext extends ParserRuleContext {
		public Assignment_expressionContext assignment_expression() {
			return getRuleContext(Assignment_expressionContext.class,0);
		}
		public Braced_init_listContext braced_init_list() {
			return getRuleContext(Braced_init_listContext.class,0);
		}
		public InitializerclauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializerclause; }
	}

	public final InitializerclauseContext initializerclause() throws RecognitionException {
		InitializerclauseContext _localctx = new InitializerclauseContext(_ctx, getState());
		enterRule(_localctx, 236, RULE_initializerclause);
		try {
			setState(1470);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,172,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1468);
				assignment_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1469);
				braced_init_list();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Initializer_listContext extends ParserRuleContext {
		public InitializerclauseContext initializerclause() {
			return getRuleContext(InitializerclauseContext.class,0);
		}
		public Initializer_listContext initializer_list() {
			return getRuleContext(Initializer_listContext.class,0);
		}
		public Initializer_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer_list; }
	}

	public final Initializer_listContext initializer_list() throws RecognitionException {
		return initializer_list(0);
	}

	private Initializer_listContext initializer_list(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Initializer_listContext _localctx = new Initializer_listContext(_ctx, _parentState);
		Initializer_listContext _prevctx = _localctx;
		int _startState = 238;
		enterRecursionRule(_localctx, 238, RULE_initializer_list, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1473);
			initializerclause();
			setState(1475);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,173,_ctx) ) {
			case 1:
				{
				setState(1474);
				match(Ellipsis);
				}
				break;
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(1485);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,175,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Initializer_listContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_initializer_list);
					setState(1477);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1478);
					match(Comma);
					setState(1479);
					initializerclause();
					setState(1481);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,174,_ctx) ) {
					case 1:
						{
						setState(1480);
						match(Ellipsis);
						}
						break;
					}
					}
					} 
				}
				setState(1487);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,175,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Braced_init_listContext extends ParserRuleContext {
		public Initializer_listContext initializer_list() {
			return getRuleContext(Initializer_listContext.class,0);
		}
		public Braced_init_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_braced_init_list; }
	}

	public final Braced_init_listContext braced_init_list() throws RecognitionException {
		Braced_init_listContext _localctx = new Braced_init_listContext(_ctx, getState());
		enterRule(_localctx, 240, RULE_braced_init_list);
		int _la;
		try {
			setState(1497);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,177,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1488);
				match(LeftBrace);
				setState(1489);
				initializer_list(0);
				setState(1491);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(1490);
					match(Comma);
					}
				}

				setState(1493);
				match(RightBrace);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1495);
				match(LeftBrace);
				setState(1496);
				match(RightBrace);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Class_nameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PandaParser.Identifier, 0); }
		public Simple_template_idContext simple_template_id() {
			return getRuleContext(Simple_template_idContext.class,0);
		}
		public Class_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_name; }
	}

	public final Class_nameContext class_name() throws RecognitionException {
		Class_nameContext _localctx = new Class_nameContext(_ctx, getState());
		enterRule(_localctx, 242, RULE_class_name);
		try {
			setState(1501);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,178,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1499);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1500);
				simple_template_id();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Class_specifierContext extends ParserRuleContext {
		public ClassheadContext classhead() {
			return getRuleContext(ClassheadContext.class,0);
		}
		public MemberspecificationContext memberspecification() {
			return getRuleContext(MemberspecificationContext.class,0);
		}
		public Class_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_specifier; }
	}

	public final Class_specifierContext class_specifier() throws RecognitionException {
		Class_specifierContext _localctx = new Class_specifierContext(_ctx, getState());
		enterRule(_localctx, 244, RULE_class_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1503);
			classhead();
			setState(1504);
			match(LeftBrace);
			setState(1506);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Auto) | (1L << Bool) | (1L << Class) | (1L << Double) | (1L << Enum) | (1L << F32) | (1L << F64) | (1L << Float) | (1L << Int) | (1L << Int8) | (1L << Int16) | (1L << Int32) | (1L << Int64) | (1L << Long) | (1L << Operator) | (1L << Private) | (1L << Protected) | (1L << Public) | (1L << Static) | (1L << Short) | (1L << Uint) | (1L << Uint8) | (1L << Uint16) | (1L << Uint32) | (1L << Uint64) | (1L << Ulong) | (1L << Ushort) | (1L << Using) | (1L << Void) | (1L << LeftParen) | (1L << LeftBracket))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (And - 71)) | (1L << (Colon - 71)) | (1L << (Semi - 71)) | (1L << (Dot - 71)) | (1L << (Ellipsis - 71)) | (1L << (Identifier - 71)))) != 0)) {
				{
				setState(1505);
				memberspecification();
				}
			}

			setState(1508);
			match(RightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassheadContext extends ParserRuleContext {
		public TerminalNode Class() { return getToken(PandaParser.Class, 0); }
		public ClassheadnameContext classheadname() {
			return getRuleContext(ClassheadnameContext.class,0);
		}
		public Attribute_specifier_sequenceContext attribute_specifier_sequence() {
			return getRuleContext(Attribute_specifier_sequenceContext.class,0);
		}
		public BaseclauseContext baseclause() {
			return getRuleContext(BaseclauseContext.class,0);
		}
		public ClassheadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classhead; }
	}

	public final ClassheadContext classhead() throws RecognitionException {
		ClassheadContext _localctx = new ClassheadContext(_ctx, getState());
		enterRule(_localctx, 246, RULE_classhead);
		int _la;
		try {
			setState(1525);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,184,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1510);
				match(Class);
				setState(1512);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftBracket) {
					{
					setState(1511);
					attribute_specifier_sequence(0);
					}
				}

				setState(1514);
				classheadname();
				setState(1516);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Colon) {
					{
					setState(1515);
					baseclause();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1518);
				match(Class);
				setState(1520);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftBracket) {
					{
					setState(1519);
					attribute_specifier_sequence(0);
					}
				}

				setState(1523);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Colon) {
					{
					setState(1522);
					baseclause();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassheadnameContext extends ParserRuleContext {
		public Class_nameContext class_name() {
			return getRuleContext(Class_nameContext.class,0);
		}
		public Nested_name_specifierContext nested_name_specifier() {
			return getRuleContext(Nested_name_specifierContext.class,0);
		}
		public ClassheadnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classheadname; }
	}

	public final ClassheadnameContext classheadname() throws RecognitionException {
		ClassheadnameContext _localctx = new ClassheadnameContext(_ctx, getState());
		enterRule(_localctx, 248, RULE_classheadname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1528);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,185,_ctx) ) {
			case 1:
				{
				setState(1527);
				nested_name_specifier(0);
				}
				break;
			}
			setState(1530);
			class_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MemberspecificationContext extends ParserRuleContext {
		public MemberdeclarationContext memberdeclaration() {
			return getRuleContext(MemberdeclarationContext.class,0);
		}
		public MemberspecificationContext memberspecification() {
			return getRuleContext(MemberspecificationContext.class,0);
		}
		public AccessspecifierContext accessspecifier() {
			return getRuleContext(AccessspecifierContext.class,0);
		}
		public MemberspecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberspecification; }
	}

	public final MemberspecificationContext memberspecification() throws RecognitionException {
		MemberspecificationContext _localctx = new MemberspecificationContext(_ctx, getState());
		enterRule(_localctx, 250, RULE_memberspecification);
		int _la;
		try {
			setState(1541);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Auto:
			case Bool:
			case Class:
			case Double:
			case Enum:
			case F32:
			case F64:
			case Float:
			case Int:
			case Int8:
			case Int16:
			case Int32:
			case Int64:
			case Long:
			case Operator:
			case Static:
			case Short:
			case Uint:
			case Uint8:
			case Uint16:
			case Uint32:
			case Uint64:
			case Ulong:
			case Ushort:
			case Using:
			case Void:
			case LeftParen:
			case LeftBracket:
			case And:
			case Colon:
			case Semi:
			case Dot:
			case Ellipsis:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(1532);
				memberdeclaration();
				setState(1534);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Auto) | (1L << Bool) | (1L << Class) | (1L << Double) | (1L << Enum) | (1L << F32) | (1L << F64) | (1L << Float) | (1L << Int) | (1L << Int8) | (1L << Int16) | (1L << Int32) | (1L << Int64) | (1L << Long) | (1L << Operator) | (1L << Private) | (1L << Protected) | (1L << Public) | (1L << Static) | (1L << Short) | (1L << Uint) | (1L << Uint8) | (1L << Uint16) | (1L << Uint32) | (1L << Uint64) | (1L << Ulong) | (1L << Ushort) | (1L << Using) | (1L << Void) | (1L << LeftParen) | (1L << LeftBracket))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (And - 71)) | (1L << (Colon - 71)) | (1L << (Semi - 71)) | (1L << (Dot - 71)) | (1L << (Ellipsis - 71)) | (1L << (Identifier - 71)))) != 0)) {
					{
					setState(1533);
					memberspecification();
					}
				}

				}
				break;
			case Private:
			case Protected:
			case Public:
				enterOuterAlt(_localctx, 2);
				{
				setState(1536);
				accessspecifier();
				setState(1537);
				match(Colon);
				setState(1539);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Auto) | (1L << Bool) | (1L << Class) | (1L << Double) | (1L << Enum) | (1L << F32) | (1L << F64) | (1L << Float) | (1L << Int) | (1L << Int8) | (1L << Int16) | (1L << Int32) | (1L << Int64) | (1L << Long) | (1L << Operator) | (1L << Private) | (1L << Protected) | (1L << Public) | (1L << Static) | (1L << Short) | (1L << Uint) | (1L << Uint8) | (1L << Uint16) | (1L << Uint32) | (1L << Uint64) | (1L << Ulong) | (1L << Ushort) | (1L << Using) | (1L << Void) | (1L << LeftParen) | (1L << LeftBracket))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (And - 71)) | (1L << (Colon - 71)) | (1L << (Semi - 71)) | (1L << (Dot - 71)) | (1L << (Ellipsis - 71)) | (1L << (Identifier - 71)))) != 0)) {
					{
					setState(1538);
					memberspecification();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MemberdeclarationContext extends ParserRuleContext {
		public Attribute_specifier_sequenceContext attribute_specifier_sequence() {
			return getRuleContext(Attribute_specifier_sequenceContext.class,0);
		}
		public DeclspecifierseqContext declspecifierseq() {
			return getRuleContext(DeclspecifierseqContext.class,0);
		}
		public MemberdeclaratorlistContext memberdeclaratorlist() {
			return getRuleContext(MemberdeclaratorlistContext.class,0);
		}
		public FunctiondefinitionContext functiondefinition() {
			return getRuleContext(FunctiondefinitionContext.class,0);
		}
		public UsingdeclarationContext usingdeclaration() {
			return getRuleContext(UsingdeclarationContext.class,0);
		}
		public AliasdeclarationContext aliasdeclaration() {
			return getRuleContext(AliasdeclarationContext.class,0);
		}
		public EmptydeclarationContext emptydeclaration() {
			return getRuleContext(EmptydeclarationContext.class,0);
		}
		public MemberdeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberdeclaration; }
	}

	public final MemberdeclarationContext memberdeclaration() throws RecognitionException {
		MemberdeclarationContext _localctx = new MemberdeclarationContext(_ctx, getState());
		enterRule(_localctx, 252, RULE_memberdeclaration);
		int _la;
		try {
			setState(1557);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,192,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1544);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,189,_ctx) ) {
				case 1:
					{
					setState(1543);
					attribute_specifier_sequence(0);
					}
					break;
				}
				setState(1547);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,190,_ctx) ) {
				case 1:
					{
					setState(1546);
					declspecifierseq();
					}
					break;
				}
				setState(1550);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Operator) | (1L << LeftParen) | (1L << LeftBracket))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (And - 71)) | (1L << (Colon - 71)) | (1L << (Dot - 71)) | (1L << (Ellipsis - 71)) | (1L << (Identifier - 71)))) != 0)) {
					{
					setState(1549);
					memberdeclaratorlist(0);
					}
				}

				setState(1552);
				match(Semi);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1553);
				functiondefinition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1554);
				usingdeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1555);
				aliasdeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1556);
				emptydeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MemberdeclaratorlistContext extends ParserRuleContext {
		public MemberdeclaratorContext memberdeclarator() {
			return getRuleContext(MemberdeclaratorContext.class,0);
		}
		public MemberdeclaratorlistContext memberdeclaratorlist() {
			return getRuleContext(MemberdeclaratorlistContext.class,0);
		}
		public MemberdeclaratorlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberdeclaratorlist; }
	}

	public final MemberdeclaratorlistContext memberdeclaratorlist() throws RecognitionException {
		return memberdeclaratorlist(0);
	}

	private MemberdeclaratorlistContext memberdeclaratorlist(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MemberdeclaratorlistContext _localctx = new MemberdeclaratorlistContext(_ctx, _parentState);
		MemberdeclaratorlistContext _prevctx = _localctx;
		int _startState = 254;
		enterRecursionRule(_localctx, 254, RULE_memberdeclaratorlist, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1560);
			memberdeclarator();
			}
			_ctx.stop = _input.LT(-1);
			setState(1567);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,193,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MemberdeclaratorlistContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_memberdeclaratorlist);
					setState(1562);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1563);
					match(Comma);
					setState(1564);
					memberdeclarator();
					}
					} 
				}
				setState(1569);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,193,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MemberdeclaratorContext extends ParserRuleContext {
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public PurespecifierContext purespecifier() {
			return getRuleContext(PurespecifierContext.class,0);
		}
		public BraceorequalinitializerContext braceorequalinitializer() {
			return getRuleContext(BraceorequalinitializerContext.class,0);
		}
		public ConstantexpressionContext constantexpression() {
			return getRuleContext(ConstantexpressionContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(PandaParser.Identifier, 0); }
		public Attribute_specifier_sequenceContext attribute_specifier_sequence() {
			return getRuleContext(Attribute_specifier_sequenceContext.class,0);
		}
		public MemberdeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberdeclarator; }
	}

	public final MemberdeclaratorContext memberdeclarator() throws RecognitionException {
		MemberdeclaratorContext _localctx = new MemberdeclaratorContext(_ctx, getState());
		enterRule(_localctx, 256, RULE_memberdeclarator);
		int _la;
		try {
			setState(1586);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,198,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1570);
				declarator();
				setState(1572);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,194,_ctx) ) {
				case 1:
					{
					setState(1571);
					purespecifier();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1574);
				declarator();
				setState(1576);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,195,_ctx) ) {
				case 1:
					{
					setState(1575);
					braceorequalinitializer();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1579);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(1578);
					match(Identifier);
					}
				}

				setState(1582);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftBracket) {
					{
					setState(1581);
					attribute_specifier_sequence(0);
					}
				}

				setState(1584);
				match(Colon);
				setState(1585);
				constantexpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PurespecifierContext extends ParserRuleContext {
		public Token val;
		public TerminalNode Assign() { return getToken(PandaParser.Assign, 0); }
		public TerminalNode OctalLiteral() { return getToken(PandaParser.OctalLiteral, 0); }
		public PurespecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_purespecifier; }
	}

	public final PurespecifierContext purespecifier() throws RecognitionException {
		PurespecifierContext _localctx = new PurespecifierContext(_ctx, getState());
		enterRule(_localctx, 258, RULE_purespecifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1588);
			match(Assign);
			setState(1589);
			((PurespecifierContext)_localctx).val = match(OctalLiteral);
			if((((PurespecifierContext)_localctx).val!=null?((PurespecifierContext)_localctx).val.getText():null).compareTo("0")!=0) throw new InputMismatchException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BaseclauseContext extends ParserRuleContext {
		public BasespecifierlistContext basespecifierlist() {
			return getRuleContext(BasespecifierlistContext.class,0);
		}
		public BaseclauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseclause; }
	}

	public final BaseclauseContext baseclause() throws RecognitionException {
		BaseclauseContext _localctx = new BaseclauseContext(_ctx, getState());
		enterRule(_localctx, 260, RULE_baseclause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1592);
			match(Colon);
			setState(1593);
			basespecifierlist(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BasespecifierlistContext extends ParserRuleContext {
		public BasespecifierContext basespecifier() {
			return getRuleContext(BasespecifierContext.class,0);
		}
		public BasespecifierlistContext basespecifierlist() {
			return getRuleContext(BasespecifierlistContext.class,0);
		}
		public BasespecifierlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basespecifierlist; }
	}

	public final BasespecifierlistContext basespecifierlist() throws RecognitionException {
		return basespecifierlist(0);
	}

	private BasespecifierlistContext basespecifierlist(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BasespecifierlistContext _localctx = new BasespecifierlistContext(_ctx, _parentState);
		BasespecifierlistContext _prevctx = _localctx;
		int _startState = 262;
		enterRecursionRule(_localctx, 262, RULE_basespecifierlist, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1596);
			basespecifier();
			setState(1598);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,199,_ctx) ) {
			case 1:
				{
				setState(1597);
				match(Ellipsis);
				}
				break;
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(1608);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,201,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BasespecifierlistContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_basespecifierlist);
					setState(1600);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1601);
					match(Comma);
					setState(1602);
					basespecifier();
					setState(1604);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,200,_ctx) ) {
					case 1:
						{
						setState(1603);
						match(Ellipsis);
						}
						break;
					}
					}
					} 
				}
				setState(1610);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,201,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BasespecifierContext extends ParserRuleContext {
		public BasetypespecifierContext basetypespecifier() {
			return getRuleContext(BasetypespecifierContext.class,0);
		}
		public Attribute_specifier_sequenceContext attribute_specifier_sequence() {
			return getRuleContext(Attribute_specifier_sequenceContext.class,0);
		}
		public AccessspecifierContext accessspecifier() {
			return getRuleContext(AccessspecifierContext.class,0);
		}
		public BasespecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basespecifier; }
	}

	public final BasespecifierContext basespecifier() throws RecognitionException {
		BasespecifierContext _localctx = new BasespecifierContext(_ctx, getState());
		enterRule(_localctx, 264, RULE_basespecifier);
		int _la;
		try {
			setState(1621);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,204,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1612);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftBracket) {
					{
					setState(1611);
					attribute_specifier_sequence(0);
					}
				}

				setState(1614);
				basetypespecifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1616);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftBracket) {
					{
					setState(1615);
					attribute_specifier_sequence(0);
					}
				}

				setState(1618);
				accessspecifier();
				setState(1619);
				basetypespecifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassordecltypeContext extends ParserRuleContext {
		public Class_nameContext class_name() {
			return getRuleContext(Class_nameContext.class,0);
		}
		public Nested_name_specifierContext nested_name_specifier() {
			return getRuleContext(Nested_name_specifierContext.class,0);
		}
		public ClassordecltypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classordecltype; }
	}

	public final ClassordecltypeContext classordecltype() throws RecognitionException {
		ClassordecltypeContext _localctx = new ClassordecltypeContext(_ctx, getState());
		enterRule(_localctx, 266, RULE_classordecltype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1624);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,205,_ctx) ) {
			case 1:
				{
				setState(1623);
				nested_name_specifier(0);
				}
				break;
			}
			setState(1626);
			class_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BasetypespecifierContext extends ParserRuleContext {
		public ClassordecltypeContext classordecltype() {
			return getRuleContext(ClassordecltypeContext.class,0);
		}
		public BasetypespecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basetypespecifier; }
	}

	public final BasetypespecifierContext basetypespecifier() throws RecognitionException {
		BasetypespecifierContext _localctx = new BasetypespecifierContext(_ctx, getState());
		enterRule(_localctx, 268, RULE_basetypespecifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1628);
			classordecltype();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AccessspecifierContext extends ParserRuleContext {
		public TerminalNode Private() { return getToken(PandaParser.Private, 0); }
		public TerminalNode Protected() { return getToken(PandaParser.Protected, 0); }
		public TerminalNode Public() { return getToken(PandaParser.Public, 0); }
		public AccessspecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessspecifier; }
	}

	public final AccessspecifierContext accessspecifier() throws RecognitionException {
		AccessspecifierContext _localctx = new AccessspecifierContext(_ctx, getState());
		enterRule(_localctx, 270, RULE_accessspecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1630);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Private) | (1L << Protected) | (1L << Public))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Conversion_function_idContext extends ParserRuleContext {
		public TerminalNode Operator() { return getToken(PandaParser.Operator, 0); }
		public ConversiontypeidContext conversiontypeid() {
			return getRuleContext(ConversiontypeidContext.class,0);
		}
		public Conversion_function_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conversion_function_id; }
	}

	public final Conversion_function_idContext conversion_function_id() throws RecognitionException {
		Conversion_function_idContext _localctx = new Conversion_function_idContext(_ctx, getState());
		enterRule(_localctx, 272, RULE_conversion_function_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1632);
			match(Operator);
			setState(1633);
			conversiontypeid();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConversiontypeidContext extends ParserRuleContext {
		public Type_specifier_sequenceContext type_specifier_sequence() {
			return getRuleContext(Type_specifier_sequenceContext.class,0);
		}
		public ConversiondeclaratorContext conversiondeclarator() {
			return getRuleContext(ConversiondeclaratorContext.class,0);
		}
		public ConversiontypeidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conversiontypeid; }
	}

	public final ConversiontypeidContext conversiontypeid() throws RecognitionException {
		ConversiontypeidContext _localctx = new ConversiontypeidContext(_ctx, getState());
		enterRule(_localctx, 274, RULE_conversiontypeid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1635);
			type_specifier_sequence();
			setState(1637);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,206,_ctx) ) {
			case 1:
				{
				setState(1636);
				conversiondeclarator();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConversiondeclaratorContext extends ParserRuleContext {
		public Reference_operatorContext reference_operator() {
			return getRuleContext(Reference_operatorContext.class,0);
		}
		public ConversiondeclaratorContext conversiondeclarator() {
			return getRuleContext(ConversiondeclaratorContext.class,0);
		}
		public ConversiondeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conversiondeclarator; }
	}

	public final ConversiondeclaratorContext conversiondeclarator() throws RecognitionException {
		ConversiondeclaratorContext _localctx = new ConversiondeclaratorContext(_ctx, getState());
		enterRule(_localctx, 276, RULE_conversiondeclarator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1639);
			reference_operator();
			setState(1641);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,207,_ctx) ) {
			case 1:
				{
				setState(1640);
				conversiondeclarator();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CtorinitializerContext extends ParserRuleContext {
		public MeminitializerlistContext meminitializerlist() {
			return getRuleContext(MeminitializerlistContext.class,0);
		}
		public CtorinitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ctorinitializer; }
	}

	public final CtorinitializerContext ctorinitializer() throws RecognitionException {
		CtorinitializerContext _localctx = new CtorinitializerContext(_ctx, getState());
		enterRule(_localctx, 278, RULE_ctorinitializer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1643);
			match(Colon);
			setState(1644);
			meminitializerlist();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MeminitializerlistContext extends ParserRuleContext {
		public MeminitializerContext meminitializer() {
			return getRuleContext(MeminitializerContext.class,0);
		}
		public MeminitializerlistContext meminitializerlist() {
			return getRuleContext(MeminitializerlistContext.class,0);
		}
		public MeminitializerlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_meminitializerlist; }
	}

	public final MeminitializerlistContext meminitializerlist() throws RecognitionException {
		MeminitializerlistContext _localctx = new MeminitializerlistContext(_ctx, getState());
		enterRule(_localctx, 280, RULE_meminitializerlist);
		int _la;
		try {
			setState(1657);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,210,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1646);
				meminitializer();
				setState(1648);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Ellipsis) {
					{
					setState(1647);
					match(Ellipsis);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1650);
				meminitializer();
				setState(1652);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Ellipsis) {
					{
					setState(1651);
					match(Ellipsis);
					}
				}

				setState(1654);
				match(Comma);
				setState(1655);
				meminitializerlist();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MeminitializerContext extends ParserRuleContext {
		public MeminitializeridContext meminitializerid() {
			return getRuleContext(MeminitializeridContext.class,0);
		}
		public Expression_listContext expression_list() {
			return getRuleContext(Expression_listContext.class,0);
		}
		public Braced_init_listContext braced_init_list() {
			return getRuleContext(Braced_init_listContext.class,0);
		}
		public MeminitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_meminitializer; }
	}

	public final MeminitializerContext meminitializer() throws RecognitionException {
		MeminitializerContext _localctx = new MeminitializerContext(_ctx, getState());
		enterRule(_localctx, 282, RULE_meminitializer);
		int _la;
		try {
			setState(1669);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,212,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1659);
				meminitializerid();
				setState(1660);
				match(LeftParen);
				setState(1662);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Auto) | (1L << Bool) | (1L << Double) | (1L << F32) | (1L << F64) | (1L << Float) | (1L << Int) | (1L << Int8) | (1L << Int16) | (1L << Int32) | (1L << Int64) | (1L << Long) | (1L << New) | (1L << Operator) | (1L << Short) | (1L << This) | (1L << Throw) | (1L << Uint) | (1L << Uint8) | (1L << Uint16) | (1L << Uint32) | (1L << Uint64) | (1L << Ulong) | (1L << Ushort) | (1L << Void) | (1L << LeftParen) | (1L << LeftBrace))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (Plus - 65)) | (1L << (Minus - 65)) | (1L << (Or - 65)) | (1L << (Tilde - 65)) | (1L << (Not - 65)) | (1L << (PlusPlus - 65)) | (1L << (MinusMinus - 65)) | (1L << (Dot - 65)) | (1L << (Identifier - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (PointerLiteral - 65)))) != 0)) {
					{
					setState(1661);
					expression_list();
					}
				}

				setState(1664);
				match(RightParen);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1666);
				meminitializerid();
				setState(1667);
				braced_init_list();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MeminitializeridContext extends ParserRuleContext {
		public ClassordecltypeContext classordecltype() {
			return getRuleContext(ClassordecltypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(PandaParser.Identifier, 0); }
		public MeminitializeridContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_meminitializerid; }
	}

	public final MeminitializeridContext meminitializerid() throws RecognitionException {
		MeminitializeridContext _localctx = new MeminitializeridContext(_ctx, getState());
		enterRule(_localctx, 284, RULE_meminitializerid);
		try {
			setState(1673);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,213,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1671);
				classordecltype();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1672);
				match(Identifier);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Operator_function_idContext extends ParserRuleContext {
		public TerminalNode Operator() { return getToken(PandaParser.Operator, 0); }
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public Operator_function_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator_function_id; }
	}

	public final Operator_function_idContext operator_function_id() throws RecognitionException {
		Operator_function_idContext _localctx = new Operator_function_idContext(_ctx, getState());
		enterRule(_localctx, 286, RULE_operator_function_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1675);
			match(Operator);
			setState(1676);
			operator();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Literal_operator_idContext extends ParserRuleContext {
		public TerminalNode Operator() { return getToken(PandaParser.Operator, 0); }
		public TerminalNode StringLiteral() { return getToken(PandaParser.StringLiteral, 0); }
		public TerminalNode Identifier() { return getToken(PandaParser.Identifier, 0); }
		public Literal_operator_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal_operator_id; }
	}

	public final Literal_operator_idContext literal_operator_id() throws RecognitionException {
		Literal_operator_idContext _localctx = new Literal_operator_idContext(_ctx, getState());
		enterRule(_localctx, 288, RULE_literal_operator_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1678);
			match(Operator);
			setState(1679);
			match(StringLiteral);
			setState(1680);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TemplateparameterlistContext extends ParserRuleContext {
		public TemplateparameterContext templateparameter() {
			return getRuleContext(TemplateparameterContext.class,0);
		}
		public TemplateparameterlistContext templateparameterlist() {
			return getRuleContext(TemplateparameterlistContext.class,0);
		}
		public TemplateparameterlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateparameterlist; }
	}

	public final TemplateparameterlistContext templateparameterlist() throws RecognitionException {
		return templateparameterlist(0);
	}

	private TemplateparameterlistContext templateparameterlist(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TemplateparameterlistContext _localctx = new TemplateparameterlistContext(_ctx, _parentState);
		TemplateparameterlistContext _prevctx = _localctx;
		int _startState = 290;
		enterRecursionRule(_localctx, 290, RULE_templateparameterlist, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1683);
			templateparameter();
			}
			_ctx.stop = _input.LT(-1);
			setState(1690);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,214,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TemplateparameterlistContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_templateparameterlist);
					setState(1685);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1686);
					match(Comma);
					setState(1687);
					templateparameter();
					}
					} 
				}
				setState(1692);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,214,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TemplateparameterContext extends ParserRuleContext {
		public TypeparameterContext typeparameter() {
			return getRuleContext(TypeparameterContext.class,0);
		}
		public ParameterdeclarationContext parameterdeclaration() {
			return getRuleContext(ParameterdeclarationContext.class,0);
		}
		public TemplateparameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateparameter; }
	}

	public final TemplateparameterContext templateparameter() throws RecognitionException {
		TemplateparameterContext _localctx = new TemplateparameterContext(_ctx, getState());
		enterRule(_localctx, 292, RULE_templateparameter);
		try {
			setState(1695);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,215,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1693);
				typeparameter();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1694);
				parameterdeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeparameterContext extends ParserRuleContext {
		public TerminalNode Class() { return getToken(PandaParser.Class, 0); }
		public TerminalNode Identifier() { return getToken(PandaParser.Identifier, 0); }
		public Type_idContext type_id() {
			return getRuleContext(Type_idContext.class,0);
		}
		public TemplateparameterlistContext templateparameterlist() {
			return getRuleContext(TemplateparameterlistContext.class,0);
		}
		public Id_expressionContext id_expression() {
			return getRuleContext(Id_expressionContext.class,0);
		}
		public TypeparameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeparameter; }
	}

	public final TypeparameterContext typeparameter() throws RecognitionException {
		TypeparameterContext _localctx = new TypeparameterContext(_ctx, getState());
		enterRule(_localctx, 294, RULE_typeparameter);
		int _la;
		try {
			setState(1741);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,225,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1697);
				match(Class);
				setState(1699);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,216,_ctx) ) {
				case 1:
					{
					setState(1698);
					match(Ellipsis);
					}
					break;
				}
				setState(1702);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,217,_ctx) ) {
				case 1:
					{
					setState(1701);
					match(Identifier);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1704);
				match(Class);
				setState(1706);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(1705);
					match(Identifier);
					}
				}

				setState(1708);
				match(Assign);
				setState(1709);
				type_id();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1711);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,219,_ctx) ) {
				case 1:
					{
					setState(1710);
					match(Ellipsis);
					}
					break;
				}
				setState(1714);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,220,_ctx) ) {
				case 1:
					{
					setState(1713);
					match(Identifier);
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1717);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(1716);
					match(Identifier);
					}
				}

				setState(1719);
				match(Assign);
				setState(1720);
				type_id();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1721);
				match(Less);
				setState(1722);
				templateparameterlist(0);
				setState(1723);
				match(Greater);
				setState(1724);
				match(Class);
				setState(1726);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,222,_ctx) ) {
				case 1:
					{
					setState(1725);
					match(Ellipsis);
					}
					break;
				}
				setState(1729);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,223,_ctx) ) {
				case 1:
					{
					setState(1728);
					match(Identifier);
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1731);
				match(Less);
				setState(1732);
				templateparameterlist(0);
				setState(1733);
				match(Greater);
				setState(1734);
				match(Class);
				setState(1736);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(1735);
					match(Identifier);
					}
				}

				setState(1738);
				match(Assign);
				setState(1739);
				id_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Simple_template_idContext extends ParserRuleContext {
		public TemplatenameContext templatename() {
			return getRuleContext(TemplatenameContext.class,0);
		}
		public TemplateargumentlistContext templateargumentlist() {
			return getRuleContext(TemplateargumentlistContext.class,0);
		}
		public Simple_template_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_template_id; }
	}

	public final Simple_template_idContext simple_template_id() throws RecognitionException {
		Simple_template_idContext _localctx = new Simple_template_idContext(_ctx, getState());
		enterRule(_localctx, 296, RULE_simple_template_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1743);
			templatename();
			setState(1744);
			match(Less);
			setState(1746);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Auto) | (1L << Bool) | (1L << Class) | (1L << Double) | (1L << Enum) | (1L << F32) | (1L << F64) | (1L << Float) | (1L << Int) | (1L << Int8) | (1L << Int16) | (1L << Int32) | (1L << Int64) | (1L << Long) | (1L << New) | (1L << Operator) | (1L << Short) | (1L << This) | (1L << Uint) | (1L << Uint8) | (1L << Uint16) | (1L << Uint32) | (1L << Uint64) | (1L << Ulong) | (1L << Ushort) | (1L << Void) | (1L << LeftParen) | (1L << LeftBrace))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (Plus - 65)) | (1L << (Minus - 65)) | (1L << (Or - 65)) | (1L << (Tilde - 65)) | (1L << (Not - 65)) | (1L << (PlusPlus - 65)) | (1L << (MinusMinus - 65)) | (1L << (Dot - 65)) | (1L << (Identifier - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (PointerLiteral - 65)))) != 0)) {
				{
				setState(1745);
				templateargumentlist(0);
				}
			}

			setState(1748);
			match(Greater);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Template_idContext extends ParserRuleContext {
		public Simple_template_idContext simple_template_id() {
			return getRuleContext(Simple_template_idContext.class,0);
		}
		public Operator_function_idContext operator_function_id() {
			return getRuleContext(Operator_function_idContext.class,0);
		}
		public TemplateargumentlistContext templateargumentlist() {
			return getRuleContext(TemplateargumentlistContext.class,0);
		}
		public Literal_operator_idContext literal_operator_id() {
			return getRuleContext(Literal_operator_idContext.class,0);
		}
		public Template_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template_id; }
	}

	public final Template_idContext template_id() throws RecognitionException {
		Template_idContext _localctx = new Template_idContext(_ctx, getState());
		enterRule(_localctx, 298, RULE_template_id);
		int _la;
		try {
			setState(1765);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,229,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1750);
				simple_template_id();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1751);
				operator_function_id();
				setState(1752);
				match(Less);
				setState(1754);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Auto) | (1L << Bool) | (1L << Class) | (1L << Double) | (1L << Enum) | (1L << F32) | (1L << F64) | (1L << Float) | (1L << Int) | (1L << Int8) | (1L << Int16) | (1L << Int32) | (1L << Int64) | (1L << Long) | (1L << New) | (1L << Operator) | (1L << Short) | (1L << This) | (1L << Uint) | (1L << Uint8) | (1L << Uint16) | (1L << Uint32) | (1L << Uint64) | (1L << Ulong) | (1L << Ushort) | (1L << Void) | (1L << LeftParen) | (1L << LeftBrace))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (Plus - 65)) | (1L << (Minus - 65)) | (1L << (Or - 65)) | (1L << (Tilde - 65)) | (1L << (Not - 65)) | (1L << (PlusPlus - 65)) | (1L << (MinusMinus - 65)) | (1L << (Dot - 65)) | (1L << (Identifier - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (PointerLiteral - 65)))) != 0)) {
					{
					setState(1753);
					templateargumentlist(0);
					}
				}

				setState(1756);
				match(Greater);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1758);
				literal_operator_id();
				setState(1759);
				match(Less);
				setState(1761);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Auto) | (1L << Bool) | (1L << Class) | (1L << Double) | (1L << Enum) | (1L << F32) | (1L << F64) | (1L << Float) | (1L << Int) | (1L << Int8) | (1L << Int16) | (1L << Int32) | (1L << Int64) | (1L << Long) | (1L << New) | (1L << Operator) | (1L << Short) | (1L << This) | (1L << Uint) | (1L << Uint8) | (1L << Uint16) | (1L << Uint32) | (1L << Uint64) | (1L << Ulong) | (1L << Ushort) | (1L << Void) | (1L << LeftParen) | (1L << LeftBrace))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (Plus - 65)) | (1L << (Minus - 65)) | (1L << (Or - 65)) | (1L << (Tilde - 65)) | (1L << (Not - 65)) | (1L << (PlusPlus - 65)) | (1L << (MinusMinus - 65)) | (1L << (Dot - 65)) | (1L << (Identifier - 65)) | (1L << (IntegerLiteral - 65)) | (1L << (FloatLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (BooleanLiteral - 65)) | (1L << (PointerLiteral - 65)))) != 0)) {
					{
					setState(1760);
					templateargumentlist(0);
					}
				}

				setState(1763);
				match(Greater);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TemplatenameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PandaParser.Identifier, 0); }
		public TemplatenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templatename; }
	}

	public final TemplatenameContext templatename() throws RecognitionException {
		TemplatenameContext _localctx = new TemplatenameContext(_ctx, getState());
		enterRule(_localctx, 300, RULE_templatename);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1767);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TemplateargumentlistContext extends ParserRuleContext {
		public TemplateargumentContext templateargument() {
			return getRuleContext(TemplateargumentContext.class,0);
		}
		public TemplateargumentlistContext templateargumentlist() {
			return getRuleContext(TemplateargumentlistContext.class,0);
		}
		public TemplateargumentlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateargumentlist; }
	}

	public final TemplateargumentlistContext templateargumentlist() throws RecognitionException {
		return templateargumentlist(0);
	}

	private TemplateargumentlistContext templateargumentlist(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TemplateargumentlistContext _localctx = new TemplateargumentlistContext(_ctx, _parentState);
		TemplateargumentlistContext _prevctx = _localctx;
		int _startState = 302;
		enterRecursionRule(_localctx, 302, RULE_templateargumentlist, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1770);
			templateargument();
			setState(1772);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,230,_ctx) ) {
			case 1:
				{
				setState(1771);
				match(Ellipsis);
				}
				break;
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(1782);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,232,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TemplateargumentlistContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_templateargumentlist);
					setState(1774);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1775);
					match(Comma);
					setState(1776);
					templateargument();
					setState(1778);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,231,_ctx) ) {
					case 1:
						{
						setState(1777);
						match(Ellipsis);
						}
						break;
					}
					}
					} 
				}
				setState(1784);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,232,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TemplateargumentContext extends ParserRuleContext {
		public Type_idContext type_id() {
			return getRuleContext(Type_idContext.class,0);
		}
		public ConstantexpressionContext constantexpression() {
			return getRuleContext(ConstantexpressionContext.class,0);
		}
		public Id_expressionContext id_expression() {
			return getRuleContext(Id_expressionContext.class,0);
		}
		public TemplateargumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateargument; }
	}

	public final TemplateargumentContext templateargument() throws RecognitionException {
		TemplateargumentContext _localctx = new TemplateargumentContext(_ctx, getState());
		enterRule(_localctx, 304, RULE_templateargument);
		try {
			setState(1788);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,233,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1785);
				type_id();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1786);
				constantexpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1787);
				id_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_name_specifierContext extends ParserRuleContext {
		public Nested_name_specifierContext nested_name_specifier() {
			return getRuleContext(Nested_name_specifierContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(PandaParser.Identifier, 0); }
		public Simple_template_idContext simple_template_id() {
			return getRuleContext(Simple_template_idContext.class,0);
		}
		public Type_name_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_name_specifier; }
	}

	public final Type_name_specifierContext type_name_specifier() throws RecognitionException {
		Type_name_specifierContext _localctx = new Type_name_specifierContext(_ctx, getState());
		enterRule(_localctx, 306, RULE_type_name_specifier);
		try {
			setState(1796);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,234,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1790);
				nested_name_specifier(0);
				setState(1791);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1793);
				nested_name_specifier(0);
				setState(1794);
				simple_template_id();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TryblockContext extends ParserRuleContext {
		public TerminalNode Try() { return getToken(PandaParser.Try, 0); }
		public Compound_statementContext compound_statement() {
			return getRuleContext(Compound_statementContext.class,0);
		}
		public Handler_sequenceContext handler_sequence() {
			return getRuleContext(Handler_sequenceContext.class,0);
		}
		public TryblockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tryblock; }
	}

	public final TryblockContext tryblock() throws RecognitionException {
		TryblockContext _localctx = new TryblockContext(_ctx, getState());
		enterRule(_localctx, 308, RULE_tryblock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1798);
			match(Try);
			setState(1799);
			compound_statement();
			setState(1800);
			handler_sequence();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctiontryblockContext extends ParserRuleContext {
		public TerminalNode Try() { return getToken(PandaParser.Try, 0); }
		public Compound_statementContext compound_statement() {
			return getRuleContext(Compound_statementContext.class,0);
		}
		public Handler_sequenceContext handler_sequence() {
			return getRuleContext(Handler_sequenceContext.class,0);
		}
		public CtorinitializerContext ctorinitializer() {
			return getRuleContext(CtorinitializerContext.class,0);
		}
		public FunctiontryblockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functiontryblock; }
	}

	public final FunctiontryblockContext functiontryblock() throws RecognitionException {
		FunctiontryblockContext _localctx = new FunctiontryblockContext(_ctx, getState());
		enterRule(_localctx, 310, RULE_functiontryblock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1802);
			match(Try);
			setState(1804);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Colon) {
				{
				setState(1803);
				ctorinitializer();
				}
			}

			setState(1806);
			compound_statement();
			setState(1807);
			handler_sequence();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Handler_sequenceContext extends ParserRuleContext {
		public HandlerContext handler() {
			return getRuleContext(HandlerContext.class,0);
		}
		public Handler_sequenceContext handler_sequence() {
			return getRuleContext(Handler_sequenceContext.class,0);
		}
		public Handler_sequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_handler_sequence; }
	}

	public final Handler_sequenceContext handler_sequence() throws RecognitionException {
		Handler_sequenceContext _localctx = new Handler_sequenceContext(_ctx, getState());
		enterRule(_localctx, 312, RULE_handler_sequence);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1809);
			handler();
			setState(1811);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,236,_ctx) ) {
			case 1:
				{
				setState(1810);
				handler_sequence();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HandlerContext extends ParserRuleContext {
		public TerminalNode Catch() { return getToken(PandaParser.Catch, 0); }
		public Exception_declarationContext exception_declaration() {
			return getRuleContext(Exception_declarationContext.class,0);
		}
		public Compound_statementContext compound_statement() {
			return getRuleContext(Compound_statementContext.class,0);
		}
		public HandlerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_handler; }
	}

	public final HandlerContext handler() throws RecognitionException {
		HandlerContext _localctx = new HandlerContext(_ctx, getState());
		enterRule(_localctx, 314, RULE_handler);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1813);
			match(Catch);
			setState(1814);
			match(LeftParen);
			setState(1815);
			exception_declaration();
			setState(1816);
			match(RightParen);
			setState(1817);
			compound_statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Exception_declarationContext extends ParserRuleContext {
		public Type_specifier_sequenceContext type_specifier_sequence() {
			return getRuleContext(Type_specifier_sequenceContext.class,0);
		}
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public Attribute_specifier_sequenceContext attribute_specifier_sequence() {
			return getRuleContext(Attribute_specifier_sequenceContext.class,0);
		}
		public Abstract_declaratorContext abstract_declarator() {
			return getRuleContext(Abstract_declaratorContext.class,0);
		}
		public Exception_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exception_declaration; }
	}

	public final Exception_declarationContext exception_declaration() throws RecognitionException {
		Exception_declarationContext _localctx = new Exception_declarationContext(_ctx, getState());
		enterRule(_localctx, 316, RULE_exception_declaration);
		int _la;
		try {
			setState(1833);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,240,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1820);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftBracket) {
					{
					setState(1819);
					attribute_specifier_sequence(0);
					}
				}

				setState(1822);
				type_specifier_sequence();
				setState(1823);
				declarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1826);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftBracket) {
					{
					setState(1825);
					attribute_specifier_sequence(0);
					}
				}

				setState(1828);
				type_specifier_sequence();
				setState(1830);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 59)) & ~0x3f) == 0 && ((1L << (_la - 59)) & ((1L << (LeftParen - 59)) | (1L << (LeftBracket - 59)) | (1L << (And - 59)) | (1L << (Ellipsis - 59)))) != 0)) {
					{
					setState(1829);
					abstract_declarator();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1832);
				match(Ellipsis);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Throw_expressionContext extends ParserRuleContext {
		public TerminalNode Throw() { return getToken(PandaParser.Throw, 0); }
		public Assignment_expressionContext assignment_expression() {
			return getRuleContext(Assignment_expressionContext.class,0);
		}
		public Throw_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_throw_expression; }
	}

	public final Throw_expressionContext throw_expression() throws RecognitionException {
		Throw_expressionContext _localctx = new Throw_expressionContext(_ctx, getState());
		enterRule(_localctx, 318, RULE_throw_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1835);
			match(Throw);
			setState(1837);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,241,_ctx) ) {
			case 1:
				{
				setState(1836);
				assignment_expression();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Exception_specificationContext extends ParserRuleContext {
		public TerminalNode Throw() { return getToken(PandaParser.Throw, 0); }
		public Type_id_listContext type_id_list() {
			return getRuleContext(Type_id_listContext.class,0);
		}
		public Exception_specificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exception_specification; }
	}

	public final Exception_specificationContext exception_specification() throws RecognitionException {
		Exception_specificationContext _localctx = new Exception_specificationContext(_ctx, getState());
		enterRule(_localctx, 320, RULE_exception_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1839);
			match(Throw);
			setState(1840);
			match(LeftParen);
			setState(1842);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Auto) | (1L << Bool) | (1L << Class) | (1L << Double) | (1L << Enum) | (1L << F32) | (1L << F64) | (1L << Float) | (1L << Int) | (1L << Int8) | (1L << Int16) | (1L << Int32) | (1L << Int64) | (1L << Long) | (1L << Short) | (1L << Uint) | (1L << Uint8) | (1L << Uint16) | (1L << Uint32) | (1L << Uint64) | (1L << Ulong) | (1L << Ushort) | (1L << Void))) != 0) || _la==Dot || _la==Identifier) {
				{
				setState(1841);
				type_id_list(0);
				}
			}

			setState(1844);
			match(RightParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_id_listContext extends ParserRuleContext {
		public Type_idContext type_id() {
			return getRuleContext(Type_idContext.class,0);
		}
		public Type_id_listContext type_id_list() {
			return getRuleContext(Type_id_listContext.class,0);
		}
		public Type_id_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_id_list; }
	}

	public final Type_id_listContext type_id_list() throws RecognitionException {
		return type_id_list(0);
	}

	private Type_id_listContext type_id_list(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Type_id_listContext _localctx = new Type_id_listContext(_ctx, _parentState);
		Type_id_listContext _prevctx = _localctx;
		int _startState = 322;
		enterRecursionRule(_localctx, 322, RULE_type_id_list, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1847);
			type_id();
			setState(1849);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,243,_ctx) ) {
			case 1:
				{
				setState(1848);
				match(Ellipsis);
				}
				break;
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(1859);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,245,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Type_id_listContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type_id_list);
					setState(1851);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1852);
					match(Comma);
					setState(1853);
					type_id();
					setState(1855);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,244,_ctx) ) {
					case 1:
						{
						setState(1854);
						match(Ellipsis);
						}
						break;
					}
					}
					} 
				}
				setState(1861);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,245,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class OperatorContext extends ParserRuleContext {
		public TerminalNode New() { return getToken(PandaParser.New, 0); }
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 324, RULE_operator);
		try {
			setState(1906);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case New:
				enterOuterAlt(_localctx, 1);
				{
				setState(1862);
				match(New);
				}
				break;
			case Plus:
				enterOuterAlt(_localctx, 2);
				{
				setState(1863);
				match(Plus);
				}
				break;
			case Minus:
				enterOuterAlt(_localctx, 3);
				{
				setState(1864);
				match(Minus);
				}
				break;
			case Star:
				enterOuterAlt(_localctx, 4);
				{
				setState(1865);
				match(Star);
				}
				break;
			case Div:
				enterOuterAlt(_localctx, 5);
				{
				setState(1866);
				match(Div);
				}
				break;
			case Mod:
				enterOuterAlt(_localctx, 6);
				{
				setState(1867);
				match(Mod);
				}
				break;
			case Caret:
				enterOuterAlt(_localctx, 7);
				{
				setState(1868);
				match(Caret);
				}
				break;
			case And:
				enterOuterAlt(_localctx, 8);
				{
				setState(1869);
				match(And);
				}
				break;
			case Or:
				enterOuterAlt(_localctx, 9);
				{
				setState(1870);
				match(Or);
				}
				break;
			case Tilde:
				enterOuterAlt(_localctx, 10);
				{
				setState(1871);
				match(Tilde);
				}
				break;
			case Not:
				enterOuterAlt(_localctx, 11);
				{
				setState(1872);
				match(Not);
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 12);
				{
				setState(1873);
				match(T__7);
				}
				break;
			case Assign:
				enterOuterAlt(_localctx, 13);
				{
				setState(1874);
				match(Assign);
				}
				break;
			case Less:
				enterOuterAlt(_localctx, 14);
				{
				setState(1875);
				match(Less);
				}
				break;
			case Greater:
				enterOuterAlt(_localctx, 15);
				{
				setState(1876);
				match(Greater);
				}
				break;
			case PlusAssign:
				enterOuterAlt(_localctx, 16);
				{
				setState(1877);
				match(PlusAssign);
				}
				break;
			case MinusAssign:
				enterOuterAlt(_localctx, 17);
				{
				setState(1878);
				match(MinusAssign);
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 18);
				{
				setState(1879);
				match(T__4);
				}
				break;
			case DivAssign:
				enterOuterAlt(_localctx, 19);
				{
				setState(1880);
				match(DivAssign);
				}
				break;
			case ModAssign:
				enterOuterAlt(_localctx, 20);
				{
				setState(1881);
				match(ModAssign);
				}
				break;
			case XorAssign:
				enterOuterAlt(_localctx, 21);
				{
				setState(1882);
				match(XorAssign);
				}
				break;
			case AndAssign:
				enterOuterAlt(_localctx, 22);
				{
				setState(1883);
				match(AndAssign);
				}
				break;
			case OrAssign:
				enterOuterAlt(_localctx, 23);
				{
				setState(1884);
				match(OrAssign);
				}
				break;
			case LeftShift:
				enterOuterAlt(_localctx, 24);
				{
				setState(1885);
				match(LeftShift);
				}
				break;
			case RightShift:
				enterOuterAlt(_localctx, 25);
				{
				setState(1886);
				match(RightShift);
				}
				break;
			case RightShiftAssign:
				enterOuterAlt(_localctx, 26);
				{
				setState(1887);
				match(RightShiftAssign);
				}
				break;
			case LeftShiftAssign:
				enterOuterAlt(_localctx, 27);
				{
				setState(1888);
				match(LeftShiftAssign);
				}
				break;
			case Equal:
				enterOuterAlt(_localctx, 28);
				{
				setState(1889);
				match(Equal);
				}
				break;
			case NotEqual:
				enterOuterAlt(_localctx, 29);
				{
				setState(1890);
				match(NotEqual);
				}
				break;
			case LessEqual:
				enterOuterAlt(_localctx, 30);
				{
				setState(1891);
				match(LessEqual);
				}
				break;
			case GreaterEqual:
				enterOuterAlt(_localctx, 31);
				{
				setState(1892);
				match(GreaterEqual);
				}
				break;
			case AndAnd:
				enterOuterAlt(_localctx, 32);
				{
				setState(1893);
				match(AndAnd);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 33);
				{
				setState(1894);
				match(T__2);
				}
				break;
			case OrOr:
				enterOuterAlt(_localctx, 34);
				{
				setState(1895);
				match(OrOr);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 35);
				{
				setState(1896);
				match(T__3);
				}
				break;
			case PlusPlus:
				enterOuterAlt(_localctx, 36);
				{
				setState(1897);
				match(PlusPlus);
				}
				break;
			case MinusMinus:
				enterOuterAlt(_localctx, 37);
				{
				setState(1898);
				match(MinusMinus);
				}
				break;
			case Comma:
				enterOuterAlt(_localctx, 38);
				{
				setState(1899);
				match(Comma);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 39);
				{
				setState(1900);
				match(T__1);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 40);
				{
				setState(1901);
				match(T__6);
				}
				break;
			case LeftParen:
				enterOuterAlt(_localctx, 41);
				{
				setState(1902);
				match(LeftParen);
				setState(1903);
				match(RightParen);
				}
				break;
			case LeftBracket:
				enterOuterAlt(_localctx, 42);
				{
				setState(1904);
				match(LeftBracket);
				setState(1905);
				match(RightBracket);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode IntegerLiteral() { return getToken(PandaParser.IntegerLiteral, 0); }
		public TerminalNode FloatLiteral() { return getToken(PandaParser.FloatLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(PandaParser.StringLiteral, 0); }
		public TerminalNode BooleanLiteral() { return getToken(PandaParser.BooleanLiteral, 0); }
		public TerminalNode PointerLiteral() { return getToken(PandaParser.PointerLiteral, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 326, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1908);
			_la = _input.LA(1);
			if ( !(((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & ((1L << (IntegerLiteral - 104)) | (1L << (FloatLiteral - 104)) | (1L << (StringLiteral - 104)) | (1L << (BooleanLiteral - 104)) | (1L << (PointerLiteral - 104)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return nested_name_specifier_sempred((Nested_name_specifierContext)_localctx, predIndex);
		case 8:
			return post_fix_expression_sempred((Post_fix_expressionContext)_localctx, predIndex);
		case 15:
			return pmexpression_sempred((PmexpressionContext)_localctx, predIndex);
		case 16:
			return multiplicativeexpression_sempred((MultiplicativeexpressionContext)_localctx, predIndex);
		case 17:
			return additiveexpression_sempred((AdditiveexpressionContext)_localctx, predIndex);
		case 18:
			return shiftexpression_sempred((ShiftexpressionContext)_localctx, predIndex);
		case 20:
			return relationalexpression_sempred((RelationalexpressionContext)_localctx, predIndex);
		case 21:
			return equalityexpression_sempred((EqualityexpressionContext)_localctx, predIndex);
		case 22:
			return andexpression_sempred((AndexpressionContext)_localctx, predIndex);
		case 23:
			return exclusiveorexpression_sempred((ExclusiveorexpressionContext)_localctx, predIndex);
		case 24:
			return inclusiveorexpression_sempred((InclusiveorexpressionContext)_localctx, predIndex);
		case 25:
			return logicalandexpression_sempred((LogicalandexpressionContext)_localctx, predIndex);
		case 26:
			return logicalorexpression_sempred((LogicalorexpressionContext)_localctx, predIndex);
		case 30:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 36:
			return statementseq_sempred((StatementseqContext)_localctx, predIndex);
		case 45:
			return declaration_sequence_sempred((Declaration_sequenceContext)_localctx, predIndex);
		case 69:
			return enumeratorlist_sempred((EnumeratorlistContext)_localctx, predIndex);
		case 85:
			return attribute_specifier_sequence_sempred((Attribute_specifier_sequenceContext)_localctx, predIndex);
		case 87:
			return attributelist_sempred((AttributelistContext)_localctx, predIndex);
		case 93:
			return balancedtokenseq_sempred((BalancedtokenseqContext)_localctx, predIndex);
		case 95:
			return initdeclaratorlist_sempred((InitdeclaratorlistContext)_localctx, predIndex);
		case 99:
			return noptrdeclarator_sempred((NoptrdeclaratorContext)_localctx, predIndex);
		case 108:
			return noptrabstract_declarator_sempred((Noptrabstract_declaratorContext)_localctx, predIndex);
		case 110:
			return noptrabstractpackdeclarator_sempred((NoptrabstractpackdeclaratorContext)_localctx, predIndex);
		case 112:
			return parameterdeclarationlist_sempred((ParameterdeclarationlistContext)_localctx, predIndex);
		case 119:
			return initializer_list_sempred((Initializer_listContext)_localctx, predIndex);
		case 127:
			return memberdeclaratorlist_sempred((MemberdeclaratorlistContext)_localctx, predIndex);
		case 131:
			return basespecifierlist_sempred((BasespecifierlistContext)_localctx, predIndex);
		case 145:
			return templateparameterlist_sempred((TemplateparameterlistContext)_localctx, predIndex);
		case 151:
			return templateargumentlist_sempred((TemplateargumentlistContext)_localctx, predIndex);
		case 161:
			return type_id_list_sempred((Type_id_listContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean nested_name_specifier_sempred(Nested_name_specifierContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean post_fix_expression_sempred(Post_fix_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 8);
		case 5:
			return precpred(_ctx, 3);
		case 6:
			return precpred(_ctx, 2);
		case 7:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean pmexpression_sempred(PmexpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 2);
		case 9:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean multiplicativeexpression_sempred(MultiplicativeexpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 3);
		case 11:
			return precpred(_ctx, 2);
		case 12:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean additiveexpression_sempred(AdditiveexpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 13:
			return precpred(_ctx, 2);
		case 14:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean shiftexpression_sempred(ShiftexpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 15:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean relationalexpression_sempred(RelationalexpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 16:
			return precpred(_ctx, 4);
		case 17:
			return precpred(_ctx, 3);
		case 18:
			return precpred(_ctx, 2);
		case 19:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean equalityexpression_sempred(EqualityexpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 20:
			return precpred(_ctx, 2);
		case 21:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean andexpression_sempred(AndexpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 22:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean exclusiveorexpression_sempred(ExclusiveorexpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 23:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean inclusiveorexpression_sempred(InclusiveorexpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 24:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean logicalandexpression_sempred(LogicalandexpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 25:
			return precpred(_ctx, 2);
		case 26:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean logicalorexpression_sempred(LogicalorexpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 27:
			return precpred(_ctx, 2);
		case 28:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 29:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean statementseq_sempred(StatementseqContext _localctx, int predIndex) {
		switch (predIndex) {
		case 30:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean declaration_sequence_sempred(Declaration_sequenceContext _localctx, int predIndex) {
		switch (predIndex) {
		case 31:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean enumeratorlist_sempred(EnumeratorlistContext _localctx, int predIndex) {
		switch (predIndex) {
		case 32:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean attribute_specifier_sequence_sempred(Attribute_specifier_sequenceContext _localctx, int predIndex) {
		switch (predIndex) {
		case 33:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean attributelist_sempred(AttributelistContext _localctx, int predIndex) {
		switch (predIndex) {
		case 34:
			return precpred(_ctx, 3);
		case 35:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean balancedtokenseq_sempred(BalancedtokenseqContext _localctx, int predIndex) {
		switch (predIndex) {
		case 36:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean initdeclaratorlist_sempred(InitdeclaratorlistContext _localctx, int predIndex) {
		switch (predIndex) {
		case 37:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean noptrdeclarator_sempred(NoptrdeclaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 38:
			return precpred(_ctx, 3);
		case 39:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean noptrabstract_declarator_sempred(Noptrabstract_declaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 40:
			return precpred(_ctx, 5);
		case 41:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean noptrabstractpackdeclarator_sempred(NoptrabstractpackdeclaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 42:
			return precpred(_ctx, 3);
		case 43:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean parameterdeclarationlist_sempred(ParameterdeclarationlistContext _localctx, int predIndex) {
		switch (predIndex) {
		case 44:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean initializer_list_sempred(Initializer_listContext _localctx, int predIndex) {
		switch (predIndex) {
		case 45:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean memberdeclaratorlist_sempred(MemberdeclaratorlistContext _localctx, int predIndex) {
		switch (predIndex) {
		case 46:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean basespecifierlist_sempred(BasespecifierlistContext _localctx, int predIndex) {
		switch (predIndex) {
		case 47:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean templateparameterlist_sempred(TemplateparameterlistContext _localctx, int predIndex) {
		switch (predIndex) {
		case 48:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean templateargumentlist_sempred(TemplateargumentlistContext _localctx, int predIndex) {
		switch (predIndex) {
		case 49:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean type_id_list_sempred(Type_id_listContext _localctx, int predIndex) {
		switch (predIndex) {
		case 50:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3v\u0779\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t\tt\4u\tu\4v\tv\4"+
		"w\tw\4x\tx\4y\ty\4z\tz\4{\t{\4|\t|\4}\t}\4~\t~\4\177\t\177\4\u0080\t\u0080"+
		"\4\u0081\t\u0081\4\u0082\t\u0082\4\u0083\t\u0083\4\u0084\t\u0084\4\u0085"+
		"\t\u0085\4\u0086\t\u0086\4\u0087\t\u0087\4\u0088\t\u0088\4\u0089\t\u0089"+
		"\4\u008a\t\u008a\4\u008b\t\u008b\4\u008c\t\u008c\4\u008d\t\u008d\4\u008e"+
		"\t\u008e\4\u008f\t\u008f\4\u0090\t\u0090\4\u0091\t\u0091\4\u0092\t\u0092"+
		"\4\u0093\t\u0093\4\u0094\t\u0094\4\u0095\t\u0095\4\u0096\t\u0096\4\u0097"+
		"\t\u0097\4\u0098\t\u0098\4\u0099\t\u0099\4\u009a\t\u009a\4\u009b\t\u009b"+
		"\4\u009c\t\u009c\4\u009d\t\u009d\4\u009e\t\u009e\4\u009f\t\u009f\4\u00a0"+
		"\t\u00a0\4\u00a1\t\u00a1\4\u00a2\t\u00a2\4\u00a3\t\u00a3\4\u00a4\t\u00a4"+
		"\4\u00a5\t\u00a5\3\2\5\2\u014c\n\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\5\3\u0158\n\3\3\4\3\4\5\4\u015c\n\4\3\5\3\5\3\5\3\5\3\5\5\5\u0163"+
		"\n\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0170\n\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\7\7\u0179\n\7\f\7\16\7\u017c\13\7\3\b\5\b\u017f\n"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\5\t\u0187\n\t\3\n\3\n\3\n\3\n\3\n\5\n\u018e"+
		"\n\n\3\n\3\n\3\n\3\n\3\n\5\n\u0195\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\5\n\u019f\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n"+
		"\u01ae\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u01b8\n\n\f\n\16\n\u01bb"+
		"\13\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u01c8\n\f\3\r"+
		"\3\r\3\16\3\16\3\16\3\16\3\17\3\17\5\17\u01d2\n\17\3\17\3\17\5\17\u01d6"+
		"\n\17\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u01de\n\20\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\7\21\u01e9\n\21\f\21\16\21\u01ec\13\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u01fa\n\22"+
		"\f\22\16\22\u01fd\13\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7"+
		"\23\u0208\n\23\f\23\16\23\u020b\13\23\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\7\24\u0214\n\24\f\24\16\24\u0217\13\24\3\25\3\25\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u022a"+
		"\n\26\f\26\16\26\u022d\13\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\7\27\u0238\n\27\f\27\16\27\u023b\13\27\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\7\30\u0243\n\30\f\30\16\30\u0246\13\30\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\7\31\u024e\n\31\f\31\16\31\u0251\13\31\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\7\32\u0259\n\32\f\32\16\32\u025c\13\32\3\33\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\7\33\u0267\n\33\f\33\16\33\u026a\13\33\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\7\34\u0275\n\34\f\34\16\34\u0278\13"+
		"\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u0281\n\35\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\5\36\u0289\n\36\3\37\3\37\3 \3 \3 \3 \3 \3 \7 \u0293\n"+
		" \f \16 \u0296\13 \3!\3!\3\"\3\"\5\"\u029c\n\"\3\"\3\"\5\"\u02a0\n\"\3"+
		"\"\3\"\5\"\u02a4\n\"\3\"\3\"\5\"\u02a8\n\"\3\"\3\"\5\"\u02ac\n\"\3\"\3"+
		"\"\3\"\5\"\u02b1\n\"\3\"\5\"\u02b4\n\"\3#\5#\u02b7\n#\3#\3#\3#\3#\5#\u02bd"+
		"\n#\3#\3#\3#\3#\3#\3#\5#\u02c5\n#\3#\3#\3#\5#\u02ca\n#\3$\5$\u02cd\n$"+
		"\3$\3$\3%\3%\5%\u02d3\n%\3%\3%\3&\3&\3&\3&\3&\7&\u02dc\n&\f&\16&\u02df"+
		"\13&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\5\'\u02f5\n\'\3(\3(\5(\u02f9\n(\3(\3(\3(\3(\3(\3(\5(\u0301"+
		"\n(\3(\3(\3(\3(\5(\u0307\n(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\5)\u0313\n)"+
		"\3)\3)\5)\u0317\n)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\5)\u0324\n)\3*\3*"+
		"\5*\u0328\n*\3+\5+\u032b\n+\3+\3+\3+\3,\3,\5,\u0332\n,\3-\3-\3-\3-\3-"+
		"\3-\5-\u033a\n-\3-\3-\3-\3-\3-\5-\u0341\n-\3.\3.\3/\3/\3/\3/\3/\7/\u034a"+
		"\n/\f/\16/\u034d\13/\3\60\3\60\3\60\3\60\3\60\5\60\u0354\n\60\3\61\3\61"+
		"\3\61\3\61\3\61\3\61\5\61\u035c\n\61\3\62\3\62\3\62\5\62\u0361\n\62\3"+
		"\62\3\62\3\62\3\62\3\63\5\63\u0368\n\63\3\63\5\63\u036b\n\63\3\63\3\63"+
		"\3\63\5\63\u0370\n\63\3\63\3\63\3\63\5\63\u0375\n\63\3\64\3\64\3\65\3"+
		"\65\3\65\3\66\3\66\5\66\u037e\n\66\3\67\3\67\5\67\u0382\n\67\3\67\3\67"+
		"\3\67\5\67\u0387\n\67\38\38\39\39\3:\3:\3:\5:\u0390\n:\3;\3;\3;\5;\u0395"+
		"\n;\3<\3<\5<\u0399\n<\3<\3<\3<\5<\u039e\n<\3=\3=\5=\u03a2\n=\3=\3=\3="+
		"\5=\u03a7\n=\3>\5>\u03aa\n>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>"+
		"\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\5>\u03c5\n>\3?\3?\3?\3?\5?\u03cb\n?"+
		"\3@\3@\5@\u03cf\n@\3@\5@\u03d2\n@\3@\3@\3@\3@\3@\3@\3@\3@\3@\5@\u03dd"+
		"\n@\3@\5@\u03e0\n@\3A\3A\3B\3B\3B\5B\u03e7\nB\3B\3B\3B\3B\3B\3B\3B\3B"+
		"\5B\u03f1\nB\3C\3C\5C\u03f5\nC\3C\5C\u03f8\nC\3C\5C\u03fb\nC\3C\3C\5C"+
		"\u03ff\nC\3C\3C\3C\5C\u0404\nC\5C\u0406\nC\3D\3D\5D\u040a\nD\3D\3D\5D"+
		"\u040e\nD\3D\3D\3E\3E\3E\5E\u0415\nE\3F\3F\3F\3G\3G\3G\3G\3G\3G\7G\u0420"+
		"\nG\fG\16G\u0423\13G\3H\3H\3H\3H\3H\5H\u042a\nH\3I\3I\3J\3J\5J\u0430\n"+
		"J\3K\3K\3L\3L\5L\u0436\nL\3M\3M\5M\u043a\nM\3N\3N\3N\3N\3N\3N\3O\3O\3"+
		"O\3O\3O\3O\3P\3P\3P\3P\3P\3Q\5Q\u044e\nQ\3R\3R\3S\3S\3S\3S\3S\3S\3T\5"+
		"T\u0459\nT\3T\3T\3U\3U\3U\3U\3U\3U\3U\3U\3U\3U\5U\u0467\nU\3V\5V\u046a"+
		"\nV\3V\3V\3V\5V\u046f\nV\3V\3V\3V\3W\3W\3W\3W\3W\7W\u0479\nW\fW\16W\u047c"+
		"\13W\3X\3X\3X\3X\3X\3X\3Y\3Y\5Y\u0486\nY\3Y\3Y\3Y\5Y\u048b\nY\3Y\3Y\3"+
		"Y\5Y\u0490\nY\3Y\3Y\3Y\3Y\3Y\7Y\u0497\nY\fY\16Y\u049a\13Y\3Z\3Z\5Z\u049e"+
		"\nZ\3[\3[\5[\u04a2\n[\3\\\3\\\3\\\3\\\3]\3]\3^\3^\3^\3^\3_\3_\5_\u04b0"+
		"\n_\3_\3_\7_\u04b4\n_\f_\16_\u04b7\13_\3`\3`\3`\3`\3`\3`\3`\3`\3`\3`\3"+
		"`\3`\5`\u04c5\n`\3a\3a\3a\3a\3a\3a\7a\u04cd\na\fa\16a\u04d0\13a\3b\3b"+
		"\5b\u04d4\nb\3c\3c\3c\3c\3c\5c\u04db\nc\3d\3d\3d\3d\5d\u04e1\nd\3e\3e"+
		"\3e\5e\u04e6\ne\3e\3e\3e\3e\5e\u04ec\ne\3e\3e\3e\3e\3e\5e\u04f3\ne\3e"+
		"\3e\5e\u04f7\ne\7e\u04f9\ne\fe\16e\u04fc\13e\3f\3f\3f\3f\5f\u0502\nf\3"+
		"f\5f\u0505\nf\3f\5f\u0508\nf\3g\3g\3g\5g\u050d\ng\3h\3h\5h\u0511\nh\3"+
		"i\3i\3j\5j\u0516\nj\3j\3j\3k\3k\5k\u051c\nk\3l\3l\5l\u0520\nl\3l\3l\3"+
		"l\3l\5l\u0526\nl\3m\3m\3m\5m\u052b\nm\5m\u052d\nm\3n\3n\3n\3n\5n\u0533"+
		"\nn\3n\3n\5n\u0537\nn\3n\3n\3n\3n\5n\u053d\nn\3n\3n\3n\3n\3n\5n\u0544"+
		"\nn\3n\3n\5n\u0548\nn\7n\u054a\nn\fn\16n\u054d\13n\3o\3o\3o\3o\5o\u0553"+
		"\no\3p\3p\3p\3p\3p\3p\3p\3p\5p\u055d\np\3p\3p\5p\u0561\np\7p\u0563\np"+
		"\fp\16p\u0566\13p\3q\5q\u0569\nq\3q\5q\u056c\nq\3q\3q\3q\3q\5q\u0572\n"+
		"q\3r\3r\3r\3r\3r\3r\7r\u057a\nr\fr\16r\u057d\13r\3s\5s\u0580\ns\3s\3s"+
		"\3s\3s\5s\u0586\ns\3s\3s\3s\3s\3s\3s\5s\u058e\ns\3s\3s\5s\u0592\ns\3s"+
		"\5s\u0595\ns\3s\3s\5s\u0599\ns\3s\3s\3s\5s\u059e\ns\3t\5t\u05a1\nt\3t"+
		"\5t\u05a4\nt\3t\3t\3t\3u\5u\u05aa\nu\3u\3u\3u\3u\3u\5u\u05b1\nu\3v\3v"+
		"\3v\3v\3v\5v\u05b8\nv\3w\3w\3w\5w\u05bd\nw\3x\3x\5x\u05c1\nx\3y\3y\3y"+
		"\5y\u05c6\ny\3y\3y\3y\3y\5y\u05cc\ny\7y\u05ce\ny\fy\16y\u05d1\13y\3z\3"+
		"z\3z\5z\u05d6\nz\3z\3z\3z\3z\5z\u05dc\nz\3{\3{\5{\u05e0\n{\3|\3|\3|\5"+
		"|\u05e5\n|\3|\3|\3}\3}\5}\u05eb\n}\3}\3}\5}\u05ef\n}\3}\3}\5}\u05f3\n"+
		"}\3}\5}\u05f6\n}\5}\u05f8\n}\3~\5~\u05fb\n~\3~\3~\3\177\3\177\5\177\u0601"+
		"\n\177\3\177\3\177\3\177\5\177\u0606\n\177\5\177\u0608\n\177\3\u0080\5"+
		"\u0080\u060b\n\u0080\3\u0080\5\u0080\u060e\n\u0080\3\u0080\5\u0080\u0611"+
		"\n\u0080\3\u0080\3\u0080\3\u0080\3\u0080\3\u0080\5\u0080\u0618\n\u0080"+
		"\3\u0081\3\u0081\3\u0081\3\u0081\3\u0081\3\u0081\7\u0081\u0620\n\u0081"+
		"\f\u0081\16\u0081\u0623\13\u0081\3\u0082\3\u0082\5\u0082\u0627\n\u0082"+
		"\3\u0082\3\u0082\5\u0082\u062b\n\u0082\3\u0082\5\u0082\u062e\n\u0082\3"+
		"\u0082\5\u0082\u0631\n\u0082\3\u0082\3\u0082\5\u0082\u0635\n\u0082\3\u0083"+
		"\3\u0083\3\u0083\3\u0083\3\u0084\3\u0084\3\u0084\3\u0085\3\u0085\3\u0085"+
		"\5\u0085\u0641\n\u0085\3\u0085\3\u0085\3\u0085\3\u0085\5\u0085\u0647\n"+
		"\u0085\7\u0085\u0649\n\u0085\f\u0085\16\u0085\u064c\13\u0085\3\u0086\5"+
		"\u0086\u064f\n\u0086\3\u0086\3\u0086\5\u0086\u0653\n\u0086\3\u0086\3\u0086"+
		"\3\u0086\5\u0086\u0658\n\u0086\3\u0087\5\u0087\u065b\n\u0087\3\u0087\3"+
		"\u0087\3\u0088\3\u0088\3\u0089\3\u0089\3\u008a\3\u008a\3\u008a\3\u008b"+
		"\3\u008b\5\u008b\u0668\n\u008b\3\u008c\3\u008c\5\u008c\u066c\n\u008c\3"+
		"\u008d\3\u008d\3\u008d\3\u008e\3\u008e\5\u008e\u0673\n\u008e\3\u008e\3"+
		"\u008e\5\u008e\u0677\n\u008e\3\u008e\3\u008e\3\u008e\5\u008e\u067c\n\u008e"+
		"\3\u008f\3\u008f\3\u008f\5\u008f\u0681\n\u008f\3\u008f\3\u008f\3\u008f"+
		"\3\u008f\3\u008f\5\u008f\u0688\n\u008f\3\u0090\3\u0090\5\u0090\u068c\n"+
		"\u0090\3\u0091\3\u0091\3\u0091\3\u0092\3\u0092\3\u0092\3\u0092\3\u0093"+
		"\3\u0093\3\u0093\3\u0093\3\u0093\3\u0093\7\u0093\u069b\n\u0093\f\u0093"+
		"\16\u0093\u069e\13\u0093\3\u0094\3\u0094\5\u0094\u06a2\n\u0094\3\u0095"+
		"\3\u0095\5\u0095\u06a6\n\u0095\3\u0095\5\u0095\u06a9\n\u0095\3\u0095\3"+
		"\u0095\5\u0095\u06ad\n\u0095\3\u0095\3\u0095\3\u0095\5\u0095\u06b2\n\u0095"+
		"\3\u0095\5\u0095\u06b5\n\u0095\3\u0095\5\u0095\u06b8\n\u0095\3\u0095\3"+
		"\u0095\3\u0095\3\u0095\3\u0095\3\u0095\3\u0095\5\u0095\u06c1\n\u0095\3"+
		"\u0095\5\u0095\u06c4\n\u0095\3\u0095\3\u0095\3\u0095\3\u0095\3\u0095\5"+
		"\u0095\u06cb\n\u0095\3\u0095\3\u0095\3\u0095\5\u0095\u06d0\n\u0095\3\u0096"+
		"\3\u0096\3\u0096\5\u0096\u06d5\n\u0096\3\u0096\3\u0096\3\u0097\3\u0097"+
		"\3\u0097\3\u0097\5\u0097\u06dd\n\u0097\3\u0097\3\u0097\3\u0097\3\u0097"+
		"\3\u0097\5\u0097\u06e4\n\u0097\3\u0097\3\u0097\5\u0097\u06e8\n\u0097\3"+
		"\u0098\3\u0098\3\u0099\3\u0099\3\u0099\5\u0099\u06ef\n\u0099\3\u0099\3"+
		"\u0099\3\u0099\3\u0099\5\u0099\u06f5\n\u0099\7\u0099\u06f7\n\u0099\f\u0099"+
		"\16\u0099\u06fa\13\u0099\3\u009a\3\u009a\3\u009a\5\u009a\u06ff\n\u009a"+
		"\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\5\u009b\u0707\n\u009b"+
		"\3\u009c\3\u009c\3\u009c\3\u009c\3\u009d\3\u009d\5\u009d\u070f\n\u009d"+
		"\3\u009d\3\u009d\3\u009d\3\u009e\3\u009e\5\u009e\u0716\n\u009e\3\u009f"+
		"\3\u009f\3\u009f\3\u009f\3\u009f\3\u009f\3\u00a0\5\u00a0\u071f\n\u00a0"+
		"\3\u00a0\3\u00a0\3\u00a0\3\u00a0\5\u00a0\u0725\n\u00a0\3\u00a0\3\u00a0"+
		"\5\u00a0\u0729\n\u00a0\3\u00a0\5\u00a0\u072c\n\u00a0\3\u00a1\3\u00a1\5"+
		"\u00a1\u0730\n\u00a1\3\u00a2\3\u00a2\3\u00a2\5\u00a2\u0735\n\u00a2\3\u00a2"+
		"\3\u00a2\3\u00a3\3\u00a3\3\u00a3\5\u00a3\u073c\n\u00a3\3\u00a3\3\u00a3"+
		"\3\u00a3\3\u00a3\5\u00a3\u0742\n\u00a3\7\u00a3\u0744\n\u00a3\f\u00a3\16"+
		"\u00a3\u0747\13\u00a3\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a4"+
		"\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a4"+
		"\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a4"+
		"\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a4"+
		"\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a4"+
		"\3\u00a4\3\u00a4\5\u00a4\u0775\n\u00a4\3\u00a5\3\u00a5\3\u00a5\2!\f\22"+
		" \"$&*,.\60\62\64\66>J\\\u008c\u00ac\u00b0\u00bc\u00c0\u00c8\u00da\u00de"+
		"\u00e2\u00f0\u0100\u0108\u0124\u0130\u0144\u00a6\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnp"+
		"rtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094"+
		"\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac"+
		"\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4"+
		"\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8\u00da\u00dc"+
		"\u00de\u00e0\u00e2\u00e4\u00e6\u00e8\u00ea\u00ec\u00ee\u00f0\u00f2\u00f4"+
		"\u00f6\u00f8\u00fa\u00fc\u00fe\u0100\u0102\u0104\u0106\u0108\u010a\u010c"+
		"\u010e\u0110\u0112\u0114\u0116\u0118\u011a\u011c\u011e\u0120\u0122\u0124"+
		"\u0126\u0128\u012a\u012c\u012e\u0130\u0132\u0134\u0136\u0138\u013a\u013c"+
		"\u013e\u0140\u0142\u0144\u0146\u0148\2\b\4\2CDJL\3\2WX\6\2\7\7MMPVYZ\4"+
		"\2II__\3\2(*\4\2jjor\2\u0847\2\u014b\3\2\2\2\4\u0157\3\2\2\2\6\u015b\3"+
		"\2\2\2\b\u0162\3\2\2\2\n\u0164\3\2\2\2\f\u016f\3\2\2\2\16\u017e\3\2\2"+
		"\2\20\u0182\3\2\2\2\22\u019e\3\2\2\2\24\u01bc\3\2\2\2\26\u01c7\3\2\2\2"+
		"\30\u01c9\3\2\2\2\32\u01cb\3\2\2\2\34\u01d5\3\2\2\2\36\u01dd\3\2\2\2 "+
		"\u01df\3\2\2\2\"\u01ed\3\2\2\2$\u01fe\3\2\2\2&\u020c\3\2\2\2(\u0218\3"+
		"\2\2\2*\u021a\3\2\2\2,\u022e\3\2\2\2.\u023c\3\2\2\2\60\u0247\3\2\2\2\62"+
		"\u0252\3\2\2\2\64\u025d\3\2\2\2\66\u026b\3\2\2\28\u0280\3\2\2\2:\u0288"+
		"\3\2\2\2<\u028a\3\2\2\2>\u028c\3\2\2\2@\u0297\3\2\2\2B\u02b3\3\2\2\2D"+
		"\u02c9\3\2\2\2F\u02cc\3\2\2\2H\u02d0\3\2\2\2J\u02d6\3\2\2\2L\u02f4\3\2"+
		"\2\2N\u0306\3\2\2\2P\u0323\3\2\2\2R\u0327\3\2\2\2T\u032a\3\2\2\2V\u0331"+
		"\3\2\2\2X\u0340\3\2\2\2Z\u0342\3\2\2\2\\\u0344\3\2\2\2^\u0353\3\2\2\2"+
		"`\u035b\3\2\2\2b\u035d\3\2\2\2d\u0374\3\2\2\2f\u0376\3\2\2\2h\u0378\3"+
		"\2\2\2j\u037d\3\2\2\2l\u0386\3\2\2\2n\u0388\3\2\2\2p\u038a\3\2\2\2r\u038f"+
		"\3\2\2\2t\u0394\3\2\2\2v\u039d\3\2\2\2x\u03a6\3\2\2\2z\u03c4\3\2\2\2|"+
		"\u03ca\3\2\2\2~\u03df\3\2\2\2\u0080\u03e1\3\2\2\2\u0082\u03f0\3\2\2\2"+
		"\u0084\u0405\3\2\2\2\u0086\u0407\3\2\2\2\u0088\u0414\3\2\2\2\u008a\u0416"+
		"\3\2\2\2\u008c\u0419\3\2\2\2\u008e\u0429\3\2\2\2\u0090\u042b\3\2\2\2\u0092"+
		"\u042f\3\2\2\2\u0094\u0431\3\2\2\2\u0096\u0435\3\2\2\2\u0098\u0439\3\2"+
		"\2\2\u009a\u043b\3\2\2\2\u009c\u0441\3\2\2\2\u009e\u0447\3\2\2\2\u00a0"+
		"\u044d\3\2\2\2\u00a2\u044f\3\2\2\2\u00a4\u0451\3\2\2\2\u00a6\u0458\3\2"+
		"\2\2\u00a8\u0466\3\2\2\2\u00aa\u0469\3\2\2\2\u00ac\u0473\3\2\2\2\u00ae"+
		"\u047d\3\2\2\2\u00b0\u048a\3\2\2\2\u00b2\u049b\3\2\2\2\u00b4\u04a1\3\2"+
		"\2\2\u00b6\u04a3\3\2\2\2\u00b8\u04a7\3\2\2\2\u00ba\u04a9\3\2\2\2\u00bc"+
		"\u04ad\3\2\2\2\u00be\u04c4\3\2\2\2\u00c0\u04c6\3\2\2\2\u00c2\u04d1\3\2"+
		"\2\2\u00c4\u04da\3\2\2\2\u00c6\u04e0\3\2\2\2\u00c8\u04eb\3\2\2\2\u00ca"+
		"\u04fd\3\2\2\2\u00cc\u0509\3\2\2\2\u00ce\u050e\3\2\2\2\u00d0\u0512\3\2"+
		"\2\2\u00d2\u0515\3\2\2\2\u00d4\u0519\3\2\2\2\u00d6\u0525\3\2\2\2\u00d8"+
		"\u052c\3\2\2\2\u00da\u053c\3\2\2\2\u00dc\u0552\3\2\2\2\u00de\u0554\3\2"+
		"\2\2\u00e0\u0571\3\2\2\2\u00e2\u0573\3\2\2\2\u00e4\u059d\3\2\2\2\u00e6"+
		"\u05a0\3\2\2\2\u00e8\u05b0\3\2\2\2\u00ea\u05b7\3\2\2\2\u00ec\u05bc\3\2"+
		"\2\2\u00ee\u05c0\3\2\2\2\u00f0\u05c2\3\2\2\2\u00f2\u05db\3\2\2\2\u00f4"+
		"\u05df\3\2\2\2\u00f6\u05e1\3\2\2\2\u00f8\u05f7\3\2\2\2\u00fa\u05fa\3\2"+
		"\2\2\u00fc\u0607\3\2\2\2\u00fe\u0617\3\2\2\2\u0100\u0619\3\2\2\2\u0102"+
		"\u0634\3\2\2\2\u0104\u0636\3\2\2\2\u0106\u063a\3\2\2\2\u0108\u063d\3\2"+
		"\2\2\u010a\u0657\3\2\2\2\u010c\u065a\3\2\2\2\u010e\u065e\3\2\2\2\u0110"+
		"\u0660\3\2\2\2\u0112\u0662\3\2\2\2\u0114\u0665\3\2\2\2\u0116\u0669\3\2"+
		"\2\2\u0118\u066d\3\2\2\2\u011a\u067b\3\2\2\2\u011c\u0687\3\2\2\2\u011e"+
		"\u068b\3\2\2\2\u0120\u068d\3\2\2\2\u0122\u0690\3\2\2\2\u0124\u0694\3\2"+
		"\2\2\u0126\u06a1\3\2\2\2\u0128\u06cf\3\2\2\2\u012a\u06d1\3\2\2\2\u012c"+
		"\u06e7\3\2\2\2\u012e\u06e9\3\2\2\2\u0130\u06eb\3\2\2\2\u0132\u06fe\3\2"+
		"\2\2\u0134\u0706\3\2\2\2\u0136\u0708\3\2\2\2\u0138\u070c\3\2\2\2\u013a"+
		"\u0713\3\2\2\2\u013c\u0717\3\2\2\2\u013e\u072b\3\2\2\2\u0140\u072d\3\2"+
		"\2\2\u0142\u0731\3\2\2\2\u0144\u0738\3\2\2\2\u0146\u0774\3\2\2\2\u0148"+
		"\u0776\3\2\2\2\u014a\u014c\5\\/\2\u014b\u014a\3\2\2\2\u014b\u014c\3\2"+
		"\2\2\u014c\u014d\3\2\2\2\u014d\u014e\7\2\2\3\u014e\3\3\2\2\2\u014f\u0158"+
		"\5\u0148\u00a5\2\u0150\u0158\7/\2\2\u0151\u0152\7=\2\2\u0152\u0153\5>"+
		" \2\u0153\u0154\7>\2\2\u0154\u0158\3\2\2\2\u0155\u0158\5\6\4\2\u0156\u0158"+
		"\5\16\b\2\u0157\u014f\3\2\2\2\u0157\u0150\3\2\2\2\u0157\u0151\3\2\2\2"+
		"\u0157\u0155\3\2\2\2\u0157\u0156\3\2\2\2\u0158\5\3\2\2\2\u0159\u015c\5"+
		"\b\5\2\u015a\u015c\5\n\6\2\u015b\u0159\3\2\2\2\u015b\u015a\3\2\2\2\u015c"+
		"\7\3\2\2\2\u015d\u0163\7i\2\2\u015e\u0163\5\u0120\u0091\2\u015f\u0163"+
		"\5\u0112\u008a\2\u0160\u0163\5\u0122\u0092\2\u0161\u0163\5\u012c\u0097"+
		"\2\u0162\u015d\3\2\2\2\u0162\u015e\3\2\2\2\u0162\u015f\3\2\2\2\u0162\u0160"+
		"\3\2\2\2\u0162\u0161\3\2\2\2\u0163\t\3\2\2\2\u0164\u0165\5\f\7\2\u0165"+
		"\u0166\5\b\5\2\u0166\13\3\2\2\2\u0167\u0168\b\7\1\2\u0168\u0170\7g\2\2"+
		"\u0169\u016a\5|?\2\u016a\u016b\7g\2\2\u016b\u0170\3\2\2\2\u016c\u016d"+
		"\5\u0092J\2\u016d\u016e\7g\2\2\u016e\u0170\3\2\2\2\u016f\u0167\3\2\2\2"+
		"\u016f\u0169\3\2\2\2\u016f\u016c\3\2\2\2\u0170\u017a\3\2\2\2\u0171\u0172"+
		"\f\4\2\2\u0172\u0173\7i\2\2\u0173\u0179\7g\2\2\u0174\u0175\f\3\2\2\u0175"+
		"\u0176\5\u012a\u0096\2\u0176\u0177\7g\2\2\u0177\u0179\3\2\2\2\u0178\u0171"+
		"\3\2\2\2\u0178\u0174\3\2\2\2\u0179\u017c\3\2\2\2\u017a\u0178\3\2\2\2\u017a"+
		"\u017b\3\2\2\2\u017b\r\3\2\2\2\u017c\u017a\3\2\2\2\u017d\u017f\5\20\t"+
		"\2\u017e\u017d\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u0181"+
		"\5H%\2\u0181\17\3\2\2\2\u0182\u0183\7=\2\2\u0183\u0184\5\u00e0q\2\u0184"+
		"\u0186\7>\2\2\u0185\u0187\5\u00ccg\2\u0186\u0185\3\2\2\2\u0186\u0187\3"+
		"\2\2\2\u0187\21\3\2\2\2\u0188\u0189\b\n\1\2\u0189\u019f\5\4\3\2\u018a"+
		"\u018b\5z>\2\u018b\u018d\7=\2\2\u018c\u018e\5\24\13\2\u018d\u018c\3\2"+
		"\2\2\u018d\u018e\3\2\2\2\u018e\u018f\3\2\2\2\u018f\u0190\7>\2\2\u0190"+
		"\u019f\3\2\2\2\u0191\u0192\5\u0134\u009b\2\u0192\u0194\7=\2\2\u0193\u0195"+
		"\5\24\13\2\u0194\u0193\3\2\2\2\u0194\u0195\3\2\2\2\u0195\u0196\3\2\2\2"+
		"\u0196\u0197\7>\2\2\u0197\u019f\3\2\2\2\u0198\u0199\5z>\2\u0199\u019a"+
		"\5\u00f2z\2\u019a\u019f\3\2\2\2\u019b\u019c\5\u0134\u009b\2\u019c\u019d"+
		"\5\u00f2z\2\u019d\u019f\3\2\2\2\u019e\u0188\3\2\2\2\u019e\u018a\3\2\2"+
		"\2\u019e\u0191\3\2\2\2\u019e\u0198\3\2\2\2\u019e\u019b\3\2\2\2\u019f\u01b9"+
		"\3\2\2\2\u01a0\u01a1\f\f\2\2\u01a1\u01a2\7?\2\2\u01a2\u01a3\5> \2\u01a3"+
		"\u01a4\7@\2\2\u01a4\u01b8\3\2\2\2\u01a5\u01a6\f\13\2\2\u01a6\u01a7\7?"+
		"\2\2\u01a7\u01a8\5\u00f2z\2\u01a8\u01a9\7@\2\2\u01a9\u01b8\3\2\2\2\u01aa"+
		"\u01ab\f\n\2\2\u01ab\u01ad\7=\2\2\u01ac\u01ae\5\24\13\2\u01ad\u01ac\3"+
		"\2\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01af\3\2\2\2\u01af\u01b8\7>\2\2\u01b0"+
		"\u01b1\f\5\2\2\u01b1\u01b2\7g\2\2\u01b2\u01b8\5\6\4\2\u01b3\u01b4\f\4"+
		"\2\2\u01b4\u01b8\7a\2\2\u01b5\u01b6\f\3\2\2\u01b6\u01b8\7b\2\2\u01b7\u01a0"+
		"\3\2\2\2\u01b7\u01a5\3\2\2\2\u01b7\u01aa\3\2\2\2\u01b7\u01b0\3\2\2\2\u01b7"+
		"\u01b3\3\2\2\2\u01b7\u01b5\3\2\2\2\u01b8\u01bb\3\2\2\2\u01b9\u01b7\3\2"+
		"\2\2\u01b9\u01ba\3\2\2\2\u01ba\23\3\2\2\2\u01bb\u01b9\3\2\2\2\u01bc\u01bd"+
		"\5\u00f0y\2\u01bd\25\3\2\2\2\u01be\u01c8\5\22\n\2\u01bf\u01c0\7a\2\2\u01c0"+
		"\u01c8\5\36\20\2\u01c1\u01c2\7b\2\2\u01c2\u01c8\5\36\20\2\u01c3\u01c4"+
		"\5\30\r\2\u01c4\u01c5\5\36\20\2\u01c5\u01c8\3\2\2\2\u01c6\u01c8\5\32\16"+
		"\2\u01c7\u01be\3\2\2\2\u01c7\u01bf\3\2\2\2\u01c7\u01c1\3\2\2\2\u01c7\u01c3"+
		"\3\2\2\2\u01c7\u01c6\3\2\2\2\u01c8\27\3\2\2\2\u01c9\u01ca\t\2\2\2\u01ca"+
		"\31\3\2\2\2\u01cb\u01cc\7%\2\2\u01cc\u01cd\5v<\2\u01cd\u01ce\5\34\17\2"+
		"\u01ce\33\3\2\2\2\u01cf\u01d1\7=\2\2\u01d0\u01d2\5\24\13\2\u01d1\u01d0"+
		"\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2\u01d3\3\2\2\2\u01d3\u01d6\7>\2\2\u01d4"+
		"\u01d6\5\u00f2z\2\u01d5\u01cf\3\2\2\2\u01d5\u01d4\3\2\2\2\u01d6\35\3\2"+
		"\2\2\u01d7\u01de\5\26\f\2\u01d8\u01d9\7=\2\2\u01d9\u01da\5\u00d4k\2\u01da"+
		"\u01db\7>\2\2\u01db\u01dc\5\36\20\2\u01dc\u01de\3\2\2\2\u01dd\u01d7\3"+
		"\2\2\2\u01dd\u01d8\3\2\2\2\u01de\37\3\2\2\2\u01df\u01e0\b\21\1\2\u01e0"+
		"\u01e1\5\36\20\2\u01e1\u01ea\3\2\2\2\u01e2\u01e3\f\4\2\2\u01e3\u01e4\7"+
		"\3\2\2\u01e4\u01e9\5\36\20\2\u01e5\u01e6\f\3\2\2\u01e6\u01e7\7\4\2\2\u01e7"+
		"\u01e9\5\36\20\2\u01e8\u01e2\3\2\2\2\u01e8\u01e5\3\2\2\2\u01e9\u01ec\3"+
		"\2\2\2\u01ea\u01e8\3\2\2\2\u01ea\u01eb\3\2\2\2\u01eb!\3\2\2\2\u01ec\u01ea"+
		"\3\2\2\2\u01ed\u01ee\b\22\1\2\u01ee\u01ef\5 \21\2\u01ef\u01fb\3\2\2\2"+
		"\u01f0\u01f1\f\5\2\2\u01f1\u01f2\7E\2\2\u01f2\u01fa\5 \21\2\u01f3\u01f4"+
		"\f\4\2\2\u01f4\u01f5\7F\2\2\u01f5\u01fa\5 \21\2\u01f6\u01f7\f\3\2\2\u01f7"+
		"\u01f8\7G\2\2\u01f8\u01fa\5 \21\2\u01f9\u01f0\3\2\2\2\u01f9\u01f3\3\2"+
		"\2\2\u01f9\u01f6\3\2\2\2\u01fa\u01fd\3\2\2\2\u01fb\u01f9\3\2\2\2\u01fb"+
		"\u01fc\3\2\2\2\u01fc#\3\2\2\2\u01fd\u01fb\3\2\2\2\u01fe\u01ff\b\23\1\2"+
		"\u01ff\u0200\5\"\22\2\u0200\u0209\3\2\2\2\u0201\u0202\f\4\2\2\u0202\u0203"+
		"\7C\2\2\u0203\u0208\5\"\22\2\u0204\u0205\f\3\2\2\u0205\u0206\7D\2\2\u0206"+
		"\u0208\5\"\22\2\u0207\u0201\3\2\2\2\u0207\u0204\3\2\2\2\u0208\u020b\3"+
		"\2\2\2\u0209\u0207\3\2\2\2\u0209\u020a\3\2\2\2\u020a%\3\2\2\2\u020b\u0209"+
		"\3\2\2\2\u020c\u020d\b\24\1\2\u020d\u020e\5$\23\2\u020e\u0215\3\2\2\2"+
		"\u020f\u0210\f\3\2\2\u0210\u0211\5(\25\2\u0211\u0212\5$\23\2\u0212\u0214"+
		"\3\2\2\2\u0213\u020f\3\2\2\2\u0214\u0217\3\2\2\2\u0215\u0213\3\2\2\2\u0215"+
		"\u0216\3\2\2\2\u0216\'\3\2\2\2\u0217\u0215\3\2\2\2\u0218\u0219\t\3\2\2"+
		"\u0219)\3\2\2\2\u021a\u021b\b\26\1\2\u021b\u021c\5&\24\2\u021c\u022b\3"+
		"\2\2\2\u021d\u021e\f\6\2\2\u021e\u021f\7N\2\2\u021f\u022a\5&\24\2\u0220"+
		"\u0221\f\5\2\2\u0221\u0222\7O\2\2\u0222\u022a\5&\24\2\u0223\u0224\f\4"+
		"\2\2\u0224\u0225\7]\2\2\u0225\u022a\5&\24\2\u0226\u0227\f\3\2\2\u0227"+
		"\u0228\7^\2\2\u0228\u022a\5&\24\2\u0229\u021d\3\2\2\2\u0229\u0220\3\2"+
		"\2\2\u0229\u0223\3\2\2\2\u0229\u0226\3\2\2\2\u022a\u022d\3\2\2\2\u022b"+
		"\u0229\3\2\2\2\u022b\u022c\3\2\2\2\u022c+\3\2\2\2\u022d\u022b\3\2\2\2"+
		"\u022e\u022f\b\27\1\2\u022f\u0230\5*\26\2\u0230\u0239\3\2\2\2\u0231\u0232"+
		"\f\4\2\2\u0232\u0233\7[\2\2\u0233\u0238\5*\26\2\u0234\u0235\f\3\2\2\u0235"+
		"\u0236\7\\\2\2\u0236\u0238\5*\26\2\u0237\u0231\3\2\2\2\u0237\u0234\3\2"+
		"\2\2\u0238\u023b\3\2\2\2\u0239\u0237\3\2\2\2\u0239\u023a\3\2\2\2\u023a"+
		"-\3\2\2\2\u023b\u0239\3\2\2\2\u023c\u023d\b\30\1\2\u023d\u023e\5,\27\2"+
		"\u023e\u0244\3\2\2\2\u023f\u0240\f\3\2\2\u0240\u0241\7I\2\2\u0241\u0243"+
		"\5,\27\2\u0242\u023f\3\2\2\2\u0243\u0246\3\2\2\2\u0244\u0242\3\2\2\2\u0244"+
		"\u0245\3\2\2\2\u0245/\3\2\2\2\u0246\u0244\3\2\2\2\u0247\u0248\b\31\1\2"+
		"\u0248\u0249\5.\30\2\u0249\u024f\3\2\2\2\u024a\u024b\f\3\2\2\u024b\u024c"+
		"\7H\2\2\u024c\u024e\5.\30\2\u024d\u024a\3\2\2\2\u024e\u0251\3\2\2\2\u024f"+
		"\u024d\3\2\2\2\u024f\u0250\3\2\2\2\u0250\61\3\2\2\2\u0251\u024f\3\2\2"+
		"\2\u0252\u0253\b\32\1\2\u0253\u0254\5\60\31\2\u0254\u025a\3\2\2\2\u0255"+
		"\u0256\f\3\2\2\u0256\u0257\7J\2\2\u0257\u0259\5\60\31\2\u0258\u0255\3"+
		"\2\2\2\u0259\u025c\3\2\2\2\u025a\u0258\3\2\2\2\u025a\u025b\3\2\2\2\u025b"+
		"\63\3\2\2\2\u025c\u025a\3\2\2\2\u025d\u025e\b\33\1\2\u025e\u025f\5\62"+
		"\32\2\u025f\u0268\3\2\2\2\u0260\u0261\f\4\2\2\u0261\u0262\7_\2\2\u0262"+
		"\u0267\5\62\32\2\u0263\u0264\f\3\2\2\u0264\u0265\7\5\2\2\u0265\u0267\5"+
		"\62\32\2\u0266\u0260\3\2\2\2\u0266\u0263\3\2\2\2\u0267\u026a\3\2\2\2\u0268"+
		"\u0266\3\2\2\2\u0268\u0269\3\2\2\2\u0269\65\3\2\2\2\u026a\u0268\3\2\2"+
		"\2\u026b\u026c\b\34\1\2\u026c\u026d\5\64\33\2\u026d\u0276\3\2\2\2\u026e"+
		"\u026f\f\4\2\2\u026f\u0270\7`\2\2\u0270\u0275\5\64\33\2\u0271\u0272\f"+
		"\3\2\2\u0272\u0273\7\6\2\2\u0273\u0275\5\64\33\2\u0274\u026e\3\2\2\2\u0274"+
		"\u0271\3\2\2\2\u0275\u0278\3\2\2\2\u0276\u0274\3\2\2\2\u0276\u0277\3\2"+
		"\2\2\u0277\67\3\2\2\2\u0278\u0276\3\2\2\2\u0279\u0281\5\66\34\2\u027a"+
		"\u027b\5\66\34\2\u027b\u027c\7d\2\2\u027c\u027d\5> \2\u027d\u027e\7e\2"+
		"\2\u027e\u027f\5:\36\2\u027f\u0281\3\2\2\2\u0280\u0279\3\2\2\2\u0280\u027a"+
		"\3\2\2\2\u02819\3\2\2\2\u0282\u0289\58\35\2\u0283\u0284\5\66\34\2\u0284"+
		"\u0285\5<\37\2\u0285\u0286\5\u00eex\2\u0286\u0289\3\2\2\2\u0287\u0289"+
		"\5\u0140\u00a1\2\u0288\u0282\3\2\2\2\u0288\u0283\3\2\2\2\u0288\u0287\3"+
		"\2\2\2\u0289;\3\2\2\2\u028a\u028b\t\4\2\2\u028b=\3\2\2\2\u028c\u028d\b"+
		" \1\2\u028d\u028e\5:\36\2\u028e\u0294\3\2\2\2\u028f\u0290\f\3\2\2\u0290"+
		"\u0291\7c\2\2\u0291\u0293\5:\36\2\u0292\u028f\3\2\2\2\u0293\u0296\3\2"+
		"\2\2\u0294\u0292\3\2\2\2\u0294\u0295\3\2\2\2\u0295?\3\2\2\2\u0296\u0294"+
		"\3\2\2\2\u0297\u0298\58\35\2\u0298A\3\2\2\2\u0299\u02b4\5D#\2\u029a\u029c"+
		"\5\u00acW\2\u029b\u029a\3\2\2\2\u029b\u029c\3\2\2\2\u029c\u029d\3\2\2"+
		"\2\u029d\u02b4\5F$\2\u029e\u02a0\5\u00acW\2\u029f\u029e\3\2\2\2\u029f"+
		"\u02a0\3\2\2\2\u02a0\u02a1\3\2\2\2\u02a1\u02b4\5H%\2\u02a2\u02a4\5\u00ac"+
		"W\2\u02a3\u02a2\3\2\2\2\u02a3\u02a4\3\2\2\2\u02a4\u02a5\3\2\2\2\u02a5"+
		"\u02b4\5L\'\2\u02a6\u02a8\5\u00acW\2\u02a7\u02a6\3\2\2\2\u02a7\u02a8\3"+
		"\2\2\2\u02a8\u02a9\3\2\2\2\u02a9\u02b4\5P)\2\u02aa\u02ac\5\u00acW\2\u02ab"+
		"\u02aa\3\2\2\2\u02ab\u02ac\3\2\2\2\u02ac\u02ad\3\2\2\2\u02ad\u02b4\5X"+
		"-\2\u02ae\u02b4\5Z.\2\u02af\u02b1\5\u00acW\2\u02b0\u02af\3\2\2\2\u02b0"+
		"\u02b1\3\2\2\2\u02b1\u02b2\3\2\2\2\u02b2\u02b4\5\u0136\u009c\2\u02b3\u0299"+
		"\3\2\2\2\u02b3\u029b\3\2\2\2\u02b3\u029f\3\2\2\2\u02b3\u02a3\3\2\2\2\u02b3"+
		"\u02a7\3\2\2\2\u02b3\u02ab\3\2\2\2\u02b3\u02ae\3\2\2\2\u02b3\u02b0\3\2"+
		"\2\2\u02b4C\3\2\2\2\u02b5\u02b7\5\u00acW\2\u02b6\u02b5\3\2\2\2\u02b6\u02b7"+
		"\3\2\2\2\u02b7\u02b8\3\2\2\2\u02b8\u02b9\7i\2\2\u02b9\u02ba\7e\2\2\u02ba"+
		"\u02ca\5B\"\2\u02bb\u02bd\5\u00acW\2\u02bc\u02bb\3\2\2\2\u02bc\u02bd\3"+
		"\2\2\2\u02bd\u02be\3\2\2\2\u02be\u02bf\7\17\2\2\u02bf\u02c0\5@!\2\u02c0"+
		"\u02c1\7e\2\2\u02c1\u02c2\5B\"\2\u02c2\u02ca\3\2\2\2\u02c3\u02c5\5\u00ac"+
		"W\2\u02c4\u02c3\3\2\2\2\u02c4\u02c5\3\2\2\2\u02c5\u02c6\3\2\2\2\u02c6"+
		"\u02c7\7\24\2\2\u02c7\u02c8\7e\2\2\u02c8\u02ca\5B\"\2\u02c9\u02b6\3\2"+
		"\2\2\u02c9\u02bc\3\2\2\2\u02c9\u02c4\3\2\2\2\u02caE\3\2\2\2\u02cb\u02cd"+
		"\5> \2\u02cc\u02cb\3\2\2\2\u02cc\u02cd\3\2\2\2\u02cd\u02ce\3\2\2\2\u02ce"+
		"\u02cf\7f\2\2\u02cfG\3\2\2\2\u02d0\u02d2\7A\2\2\u02d1\u02d3\5J&\2\u02d2"+
		"\u02d1\3\2\2\2\u02d2\u02d3\3\2\2\2\u02d3\u02d4\3\2\2\2\u02d4\u02d5\7B"+
		"\2\2\u02d5I\3\2\2\2\u02d6\u02d7\b&\1\2\u02d7\u02d8\5B\"\2\u02d8\u02dd"+
		"\3\2\2\2\u02d9\u02da\f\3\2\2\u02da\u02dc\5B\"\2\u02db\u02d9\3\2\2\2\u02dc"+
		"\u02df\3\2\2\2\u02dd\u02db\3\2\2\2\u02dd\u02de\3\2\2\2\u02deK\3\2\2\2"+
		"\u02df\u02dd\3\2\2\2\u02e0\u02e1\7\35\2\2\u02e1\u02e2\7=\2\2\u02e2\u02e3"+
		"\5N(\2\u02e3\u02e4\7>\2\2\u02e4\u02e5\5B\"\2\u02e5\u02f5\3\2\2\2\u02e6"+
		"\u02e7\7\35\2\2\u02e7\u02e8\7=\2\2\u02e8\u02e9\5N(\2\u02e9\u02ea\7>\2"+
		"\2\u02ea\u02eb\5B\"\2\u02eb\u02ec\7\26\2\2\u02ec\u02ed\5B\"\2\u02ed\u02f5"+
		"\3\2\2\2\u02ee\u02ef\7.\2\2\u02ef\u02f0\7=\2\2\u02f0\u02f1\5N(\2\u02f1"+
		"\u02f2\7>\2\2\u02f2\u02f3\5B\"\2\u02f3\u02f5\3\2\2\2\u02f4\u02e0\3\2\2"+
		"\2\u02f4\u02e6\3\2\2\2\u02f4\u02ee\3\2\2\2\u02f5M\3\2\2\2\u02f6\u0307"+
		"\5> \2\u02f7\u02f9\5\u00acW\2\u02f8\u02f7\3\2\2\2\u02f8\u02f9\3\2\2\2"+
		"\u02f9\u02fa\3\2\2\2\u02fa\u02fb\5l\67\2\u02fb\u02fc\5\u00c4c\2\u02fc"+
		"\u02fd\7M\2\2\u02fd\u02fe\5\u00eex\2\u02fe\u0307\3\2\2\2\u02ff\u0301\5"+
		"\u00acW\2\u0300\u02ff\3\2\2\2\u0300\u0301\3\2\2\2\u0301\u0302\3\2\2\2"+
		"\u0302\u0303\5l\67\2\u0303\u0304\5\u00c4c\2\u0304\u0305\5\u00f2z\2\u0305"+
		"\u0307\3\2\2\2\u0306\u02f6\3\2\2\2\u0306\u02f8\3\2\2\2\u0306\u0300\3\2"+
		"\2\2\u0307O\3\2\2\2\u0308\u0309\7<\2\2\u0309\u030a\7=\2\2\u030a\u030b"+
		"\5N(\2\u030b\u030c\7>\2\2\u030c\u030d\5B\"\2\u030d\u0324\3\2\2\2\u030e"+
		"\u030f\7\34\2\2\u030f\u0310\7=\2\2\u0310\u0312\5R*\2\u0311\u0313\5N(\2"+
		"\u0312\u0311\3\2\2\2\u0312\u0313\3\2\2\2\u0313\u0314\3\2\2\2\u0314\u0316"+
		"\7f\2\2\u0315\u0317\5> \2\u0316\u0315\3\2\2\2\u0316\u0317\3\2\2\2\u0317"+
		"\u0318\3\2\2\2\u0318\u0319\7>\2\2\u0319\u031a\5B\"\2\u031a\u0324\3\2\2"+
		"\2\u031b\u031c\7\34\2\2\u031c\u031d\7=\2\2\u031d\u031e\5T+\2\u031e\u031f"+
		"\7e\2\2\u031f\u0320\5V,\2\u0320\u0321\7>\2\2\u0321\u0322\5B\"\2\u0322"+
		"\u0324\3\2\2\2\u0323\u0308\3\2\2\2\u0323\u030e\3\2\2\2\u0323\u031b\3\2"+
		"\2\2\u0324Q\3\2\2\2\u0325\u0328\5F$\2\u0326\u0328\5d\63\2\u0327\u0325"+
		"\3\2\2\2\u0327\u0326\3\2\2\2\u0328S\3\2\2\2\u0329\u032b\5\u00acW\2\u032a"+
		"\u0329\3\2\2\2\u032a\u032b\3\2\2\2\u032b\u032c\3\2\2\2\u032c\u032d\5l"+
		"\67\2\u032d\u032e\5\u00c4c\2\u032eU\3\2\2\2\u032f\u0332\5> \2\u0330\u0332"+
		"\5\u00f2z\2\u0331\u032f\3\2\2\2\u0331\u0330\3\2\2\2\u0332W\3\2\2\2\u0333"+
		"\u0334\7\r\2\2\u0334\u0341\7t\2\2\u0335\u0336\7\23\2\2\u0336\u0341\7t"+
		"\2\2\u0337\u0339\7+\2\2\u0338\u033a\5> \2\u0339\u0338\3\2\2\2\u0339\u033a"+
		"\3\2\2\2\u033a\u033b\3\2\2\2\u033b\u0341\7t\2\2\u033c\u033d\7+\2\2\u033d"+
		"\u033e\5\u00f2z\2\u033e\u033f\7t\2\2\u033f\u0341\3\2\2\2\u0340\u0333\3"+
		"\2\2\2\u0340\u0335\3\2\2\2\u0340\u0337\3\2\2\2\u0340\u033c\3\2\2\2\u0341"+
		"Y\3\2\2\2\u0342\u0343\5`\61\2\u0343[\3\2\2\2\u0344\u0345\b/\1\2\u0345"+
		"\u0346\5^\60\2\u0346\u034b\3\2\2\2\u0347\u0348\f\3\2\2\u0348\u034a\5^"+
		"\60\2\u0349\u0347\3\2\2\2\u034a\u034d\3\2\2\2\u034b\u0349\3\2\2\2\u034b"+
		"\u034c\3\2\2\2\u034c]\3\2\2\2\u034d\u034b\3\2\2\2\u034e\u0354\5`\61\2"+
		"\u034f\u0354\5\u00e6t\2\u0350\u0354\5\u0096L\2\u0351\u0354\5f\64\2\u0352"+
		"\u0354\5h\65\2\u0353\u034e\3\2\2\2\u0353\u034f\3\2\2\2\u0353\u0350\3\2"+
		"\2\2\u0353\u0351\3\2\2\2\u0353\u0352\3\2\2\2\u0354_\3\2\2\2\u0355\u035c"+
		"\5d\63\2\u0356\u035c\5\u00a4S\2\u0357\u035c\5\u00a8U\2\u0358\u035c\5\u00aa"+
		"V\2\u0359\u035c\5b\62\2\u035a\u035c\5\u0086D\2\u035b\u0355\3\2\2\2\u035b"+
		"\u0356\3\2\2\2\u035b\u0357\3\2\2\2\u035b\u0358\3\2\2\2\u035b\u0359\3\2"+
		"\2\2\u035b\u035a\3\2\2\2\u035ca\3\2\2\2\u035d\u035e\7:\2\2\u035e\u0360"+
		"\7i\2\2\u035f\u0361\5\u00acW\2\u0360\u035f\3\2\2\2\u0360\u0361\3\2\2\2"+
		"\u0361\u0362\3\2\2\2\u0362\u0363\7M\2\2\u0363\u0364\5\u00d4k\2\u0364\u0365"+
		"\7f\2\2\u0365c\3\2\2\2\u0366\u0368\5l\67\2\u0367\u0366\3\2\2\2\u0367\u0368"+
		"\3\2\2\2\u0368\u036a\3\2\2\2\u0369\u036b\5\u00c0a\2\u036a\u0369\3\2\2"+
		"\2\u036a\u036b\3\2\2\2\u036b\u036c\3\2\2\2\u036c\u0375\7f\2\2\u036d\u036f"+
		"\5\u00acW\2\u036e\u0370\5l\67\2\u036f\u036e\3\2\2\2\u036f\u0370\3\2\2"+
		"\2\u0370\u0371\3\2\2\2\u0371\u0372\5\u00c0a\2\u0372\u0373\7f\2\2\u0373"+
		"\u0375\3\2\2\2\u0374\u0367\3\2\2\2\u0374\u036d\3\2\2\2\u0375e\3\2\2\2"+
		"\u0376\u0377\7f\2\2\u0377g\3\2\2\2\u0378\u0379\5\u00acW\2\u0379\u037a"+
		"\7f\2\2\u037ai\3\2\2\2\u037b\u037e\5n8\2\u037c\u037e\5r:\2\u037d\u037b"+
		"\3\2\2\2\u037d\u037c\3\2\2\2\u037ek\3\2\2\2\u037f\u0381\5j\66\2\u0380"+
		"\u0382\5\u00acW\2\u0381\u0380\3\2\2\2\u0381\u0382\3\2\2\2\u0382\u0387"+
		"\3\2\2\2\u0383\u0384\5j\66\2\u0384\u0385\5l\67\2\u0385\u0387\3\2\2\2\u0386"+
		"\u037f\3\2\2\2\u0386\u0383\3\2\2\2\u0387m\3\2\2\2\u0388\u0389\7,\2\2\u0389"+
		"o\3\2\2\2\u038a\u038b\7i\2\2\u038bq\3\2\2\2\u038c\u0390\5t;\2\u038d\u0390"+
		"\5\u00f6|\2\u038e\u0390\5\u0082B\2\u038f\u038c\3\2\2\2\u038f\u038d\3\2"+
		"\2\2\u038f\u038e\3\2\2\2\u0390s\3\2\2\2\u0391\u0395\5z>\2\u0392\u0395"+
		"\5~@\2\u0393\u0395\5\u0134\u009b\2\u0394\u0391\3\2\2\2\u0394\u0392\3\2"+
		"\2\2\u0394\u0393\3\2\2\2\u0395u\3\2\2\2\u0396\u0398\5r:\2\u0397\u0399"+
		"\5\u00acW\2\u0398\u0397\3\2\2\2\u0398\u0399\3\2\2\2\u0399\u039e\3\2\2"+
		"\2\u039a\u039b\5r:\2\u039b\u039c\5v<\2\u039c\u039e\3\2\2\2\u039d\u0396"+
		"\3\2\2\2\u039d\u039a\3\2\2\2\u039ew\3\2\2\2\u039f\u03a1\5t;\2\u03a0\u03a2"+
		"\5\u00acW\2\u03a1\u03a0\3\2\2\2\u03a1\u03a2\3\2\2\2\u03a2\u03a7\3\2\2"+
		"\2\u03a3\u03a4\5t;\2\u03a4\u03a5\5x=\2\u03a5\u03a7\3\2\2\2\u03a6\u039f"+
		"\3\2\2\2\u03a6\u03a3\3\2\2\2\u03a7y\3\2\2\2\u03a8\u03aa\5\f\7\2\u03a9"+
		"\u03a8\3\2\2\2\u03a9\u03aa\3\2\2\2\u03aa\u03ab\3\2\2\2\u03ab\u03c5\5|"+
		"?\2\u03ac\u03ad\5\f\7\2\u03ad\u03ae\5\u012a\u0096\2\u03ae\u03c5\3\2\2"+
		"\2\u03af\u03c5\7\f\2\2\u03b0\u03c5\7\37\2\2\u03b1\u03c5\7 \2\2\u03b2\u03c5"+
		"\7!\2\2\u03b3\u03c5\7\"\2\2\u03b4\u03c5\7\64\2\2\u03b5\u03c5\7\65\2\2"+
		"\u03b6\u03c5\7\66\2\2\u03b7\u03c5\7\67\2\2\u03b8\u03c5\7\36\2\2\u03b9"+
		"\u03c5\7\63\2\2\u03ba\u03c5\7-\2\2\u03bb\u03c5\79\2\2\u03bc\u03c5\7#\2"+
		"\2\u03bd\u03c5\78\2\2\u03be\u03c5\7\30\2\2\u03bf\u03c5\7\31\2\2\u03c0"+
		"\u03c5\7\33\2\2\u03c1\u03c5\7\25\2\2\u03c2\u03c5\7;\2\2\u03c3\u03c5\7"+
		"\13\2\2\u03c4\u03a9\3\2\2\2\u03c4\u03ac\3\2\2\2\u03c4\u03af\3\2\2\2\u03c4"+
		"\u03b0\3\2\2\2\u03c4\u03b1\3\2\2\2\u03c4\u03b2\3\2\2\2\u03c4\u03b3\3\2"+
		"\2\2\u03c4\u03b4\3\2\2\2\u03c4\u03b5\3\2\2\2\u03c4\u03b6\3\2\2\2\u03c4"+
		"\u03b7\3\2\2\2\u03c4\u03b8\3\2\2\2\u03c4\u03b9\3\2\2\2\u03c4\u03ba\3\2"+
		"\2\2\u03c4\u03bb\3\2\2\2\u03c4\u03bc\3\2\2\2\u03c4\u03bd\3\2\2\2\u03c4"+
		"\u03be\3\2\2\2\u03c4\u03bf\3\2\2\2\u03c4\u03c0\3\2\2\2\u03c4\u03c1\3\2"+
		"\2\2\u03c4\u03c2\3\2\2\2\u03c4\u03c3\3\2\2\2\u03c5{\3\2\2\2\u03c6\u03cb"+
		"\5\u00f4{\2\u03c7\u03cb\5\u0080A\2\u03c8\u03cb\5p9\2\u03c9\u03cb\5\u012a"+
		"\u0096\2\u03ca\u03c6\3\2\2\2\u03ca\u03c7\3\2\2\2\u03ca\u03c8\3\2\2\2\u03ca"+
		"\u03c9\3\2\2\2\u03cb}\3\2\2\2\u03cc\u03ce\7\21\2\2\u03cd\u03cf\5\u00ac"+
		"W\2\u03ce\u03cd\3\2\2\2\u03ce\u03cf\3\2\2\2\u03cf\u03d1\3\2\2\2\u03d0"+
		"\u03d2\5\f\7\2\u03d1\u03d0\3\2\2\2\u03d1\u03d2\3\2\2\2\u03d2\u03d3\3\2"+
		"\2\2\u03d3\u03e0\7i\2\2\u03d4\u03d5\7\21\2\2\u03d5\u03e0\5\u012a\u0096"+
		"\2\u03d6\u03d7\7\21\2\2\u03d7\u03d8\5\f\7\2\u03d8\u03d9\5\u012a\u0096"+
		"\2\u03d9\u03e0\3\2\2\2\u03da\u03dc\7\27\2\2\u03db\u03dd\5\f\7\2\u03dc"+
		"\u03db\3\2\2\2\u03dc\u03dd\3\2\2\2\u03dd\u03de\3\2\2\2\u03de\u03e0\7i"+
		"\2\2\u03df\u03cc\3\2\2\2\u03df\u03d4\3\2\2\2\u03df\u03d6\3\2\2\2\u03df"+
		"\u03da\3\2\2\2\u03e0\177\3\2\2\2\u03e1\u03e2\7i\2\2\u03e2\u0081\3\2\2"+
		"\2\u03e3\u03e4\5\u0084C\2\u03e4\u03e6\7A\2\2\u03e5\u03e7\5\u008cG\2\u03e6"+
		"\u03e5\3\2\2\2\u03e6\u03e7\3\2\2\2\u03e7\u03e8\3\2\2\2\u03e8\u03e9\7B"+
		"\2\2\u03e9\u03f1\3\2\2\2\u03ea\u03eb\5\u0084C\2\u03eb\u03ec\7A\2\2\u03ec"+
		"\u03ed\5\u008cG\2\u03ed\u03ee\7c\2\2\u03ee\u03ef\7B\2\2\u03ef\u03f1\3"+
		"\2\2\2\u03f0\u03e3\3\2\2\2\u03f0\u03ea\3\2\2\2\u03f1\u0083\3\2\2\2\u03f2"+
		"\u03f4\5\u0088E\2\u03f3\u03f5\5\u00acW\2\u03f4\u03f3\3\2\2\2\u03f4\u03f5"+
		"\3\2\2\2\u03f5\u03f7\3\2\2\2\u03f6\u03f8\7i\2\2\u03f7\u03f6\3\2\2\2\u03f7"+
		"\u03f8\3\2\2\2\u03f8\u03fa\3\2\2\2\u03f9\u03fb\5\u008aF\2\u03fa\u03f9"+
		"\3\2\2\2\u03fa\u03fb\3\2\2\2\u03fb\u0406\3\2\2\2\u03fc\u03fe\5\u0088E"+
		"\2\u03fd\u03ff\5\u00acW\2\u03fe\u03fd\3\2\2\2\u03fe\u03ff\3\2\2\2\u03ff"+
		"\u0400\3\2\2\2\u0400\u0401\5\f\7\2\u0401\u0403\7i\2\2\u0402\u0404\5\u008a"+
		"F\2\u0403\u0402\3\2\2\2\u0403\u0404\3\2\2\2\u0404\u0406\3\2\2\2\u0405"+
		"\u03f2\3\2\2\2\u0405\u03fc\3\2\2\2\u0406\u0085\3\2\2\2\u0407\u0409\5\u0088"+
		"E\2\u0408\u040a\5\u00acW\2\u0409\u0408\3\2\2\2\u0409\u040a\3\2\2\2\u040a"+
		"\u040b\3\2\2\2\u040b\u040d\7i\2\2\u040c\u040e\5\u008aF\2\u040d\u040c\3"+
		"\2\2\2\u040d\u040e\3\2\2\2\u040e\u040f\3\2\2\2\u040f\u0410\7f\2\2\u0410"+
		"\u0087\3\2\2\2\u0411\u0415\7\27\2\2\u0412\u0413\7\27\2\2\u0413\u0415\7"+
		"\21\2\2\u0414\u0411\3\2\2\2\u0414\u0412\3\2\2\2\u0415\u0089\3\2\2\2\u0416"+
		"\u0417\7e\2\2\u0417\u0418\5v<\2\u0418\u008b\3\2\2\2\u0419\u041a\bG\1\2"+
		"\u041a\u041b\5\u008eH\2\u041b\u0421\3\2\2\2\u041c\u041d\f\3\2\2\u041d"+
		"\u041e\7c\2\2\u041e\u0420\5\u008eH\2\u041f\u041c\3\2\2\2\u0420\u0423\3"+
		"\2\2\2\u0421\u041f\3\2\2\2\u0421\u0422\3\2\2\2\u0422\u008d\3\2\2\2\u0423"+
		"\u0421\3\2\2\2\u0424\u042a\5\u0090I\2\u0425\u0426\5\u0090I\2\u0426\u0427"+
		"\7M\2\2\u0427\u0428\5@!\2\u0428\u042a\3\2\2\2\u0429\u0424\3\2\2\2\u0429"+
		"\u0425\3\2\2\2\u042a\u008f\3\2\2\2\u042b\u042c\7i\2\2\u042c\u0091\3\2"+
		"\2\2\u042d\u0430\5\u0094K\2\u042e\u0430\5\u00a2R\2\u042f\u042d\3\2\2\2"+
		"\u042f\u042e\3\2\2\2\u0430\u0093\3\2\2\2\u0431\u0432\7i\2\2\u0432\u0095"+
		"\3\2\2\2\u0433\u0436\5\u0098M\2\u0434\u0436\5\u009eP\2\u0435\u0433\3\2"+
		"\2\2\u0435\u0434\3\2\2\2\u0436\u0097\3\2\2\2\u0437\u043a\5\u009aN\2\u0438"+
		"\u043a\5\u009cO\2\u0439\u0437\3\2\2\2\u0439\u0438\3\2\2\2\u043a\u0099"+
		"\3\2\2\2\u043b\u043c\7$\2\2\u043c\u043d\7i\2\2\u043d\u043e\7A\2\2\u043e"+
		"\u043f\5\u00a0Q\2\u043f\u0440\7B\2\2\u0440\u009b\3\2\2\2\u0441\u0442\7"+
		"$\2\2\u0442\u0443\5\u0094K\2\u0443\u0444\7A\2\2\u0444\u0445\5\u00a0Q\2"+
		"\u0445\u0446\7B\2\2\u0446\u009d\3\2\2\2\u0447\u0448\7$\2\2\u0448\u0449"+
		"\7A\2\2\u0449\u044a\5\u00a0Q\2\u044a\u044b\7B\2\2\u044b\u009f\3\2\2\2"+
		"\u044c\u044e\5\\/\2\u044d\u044c\3\2\2\2\u044d\u044e\3\2\2\2\u044e\u00a1"+
		"\3\2\2\2\u044f\u0450\7i\2\2\u0450\u00a3\3\2\2\2\u0451\u0452\7$\2\2\u0452"+
		"\u0453\7i\2\2\u0453\u0454\7M\2\2\u0454\u0455\5\u00a6T\2\u0455\u0456\7"+
		"f\2\2\u0456\u00a5\3\2\2\2\u0457\u0459\5\f\7\2\u0458\u0457\3\2\2\2\u0458"+
		"\u0459\3\2\2\2\u0459\u045a\3\2\2\2\u045a\u045b\5\u0092J\2\u045b\u00a7"+
		"\3\2\2\2\u045c\u045d\7:\2\2\u045d\u045e\5\f\7\2\u045e\u045f\5\b\5\2\u045f"+
		"\u0460\7f\2\2\u0460\u0467\3\2\2\2\u0461\u0462\7:\2\2\u0462\u0463\7\b\2"+
		"\2\u0463\u0464\5\b\5\2\u0464\u0465\7f\2\2\u0465\u0467\3\2\2\2\u0466\u045c"+
		"\3\2\2\2\u0466\u0461\3\2\2\2\u0467\u00a9\3\2\2\2\u0468\u046a\5\u00acW"+
		"\2\u0469\u0468\3\2\2\2\u0469\u046a\3\2\2\2\u046a\u046b\3\2\2\2\u046b\u046c"+
		"\7:\2\2\u046c\u046e\7$\2\2\u046d\u046f\5\f\7\2\u046e\u046d\3\2\2\2\u046e"+
		"\u046f\3\2\2\2\u046f\u0470\3\2\2\2\u0470\u0471\5\u0092J\2\u0471\u0472"+
		"\7f\2\2\u0472\u00ab\3\2\2\2\u0473\u0474\bW\1\2\u0474\u0475\5\u00aeX\2"+
		"\u0475\u047a\3\2\2\2\u0476\u0477\f\3\2\2\u0477\u0479\5\u00aeX\2\u0478"+
		"\u0476\3\2\2\2\u0479\u047c\3\2\2\2\u047a\u0478\3\2\2\2\u047a\u047b\3\2"+
		"\2\2\u047b\u00ad\3\2\2\2\u047c\u047a\3\2\2\2\u047d\u047e\7?\2\2\u047e"+
		"\u047f\7?\2\2\u047f\u0480\5\u00b0Y\2\u0480\u0481\7@\2\2\u0481\u0482\7"+
		"@\2\2\u0482\u00af\3\2\2\2\u0483\u0485\bY\1\2\u0484\u0486\5\u00b2Z\2\u0485"+
		"\u0484\3\2\2\2\u0485\u0486\3\2\2\2\u0486\u048b\3\2\2\2\u0487\u0488\5\u00b2"+
		"Z\2\u0488\u0489\7h\2\2\u0489\u048b\3\2\2\2\u048a\u0483\3\2\2\2\u048a\u0487"+
		"\3\2\2\2\u048b\u0498\3\2\2\2\u048c\u048d\f\5\2\2\u048d\u048f\7c\2\2\u048e"+
		"\u0490\5\u00b2Z\2\u048f\u048e\3\2\2\2\u048f\u0490\3\2\2\2\u0490\u0497"+
		"\3\2\2\2\u0491\u0492\f\3\2\2\u0492\u0493\7c\2\2\u0493\u0494\5\u00b2Z\2"+
		"\u0494\u0495\7h\2\2\u0495\u0497\3\2\2\2\u0496\u048c\3\2\2\2\u0496\u0491"+
		"\3\2\2\2\u0497\u049a\3\2\2\2\u0498\u0496\3\2\2\2\u0498\u0499\3\2\2\2\u0499"+
		"\u00b1\3\2\2\2\u049a\u0498\3\2\2\2\u049b\u049d\5\u00b4[\2\u049c\u049e"+
		"\5\u00ba^\2\u049d\u049c\3\2\2\2\u049d\u049e\3\2\2\2\u049e\u00b3\3\2\2"+
		"\2\u049f\u04a2\7i\2\2\u04a0\u04a2\5\u00b6\\\2\u04a1\u049f\3\2\2\2\u04a1"+
		"\u04a0\3\2\2\2\u04a2\u00b5\3\2\2\2\u04a3\u04a4\5\u00b8]\2\u04a4\u04a5"+
		"\7\b\2\2\u04a5\u04a6\7i\2\2\u04a6\u00b7\3\2\2\2\u04a7\u04a8\7i\2\2\u04a8"+
		"\u00b9\3\2\2\2\u04a9\u04aa\7=\2\2\u04aa\u04ab\5\u00bc_\2\u04ab\u04ac\7"+
		">\2\2\u04ac\u00bb\3\2\2\2\u04ad\u04af\b_\1\2\u04ae\u04b0\5\u00be`\2\u04af"+
		"\u04ae\3\2\2\2\u04af\u04b0\3\2\2\2\u04b0\u04b5\3\2\2\2\u04b1\u04b2\f\3"+
		"\2\2\u04b2\u04b4\5\u00be`\2\u04b3\u04b1\3\2\2\2\u04b4\u04b7\3\2\2\2\u04b5"+
		"\u04b3\3\2\2\2\u04b5\u04b6\3\2\2\2\u04b6\u00bd\3\2\2\2\u04b7\u04b5\3\2"+
		"\2\2\u04b8\u04b9\7=\2\2\u04b9\u04ba\5\u00bc_\2\u04ba\u04bb\7>\2\2\u04bb"+
		"\u04c5\3\2\2\2\u04bc\u04bd\7?\2\2\u04bd\u04be\5\u00bc_\2\u04be\u04bf\7"+
		"@\2\2\u04bf\u04c5\3\2\2\2\u04c0\u04c1\7A\2\2\u04c1\u04c2\5\u00bc_\2\u04c2"+
		"\u04c3\7B\2\2\u04c3\u04c5\3\2\2\2\u04c4\u04b8\3\2\2\2\u04c4\u04bc\3\2"+
		"\2\2\u04c4\u04c0\3\2\2\2\u04c5\u00bf\3\2\2\2\u04c6\u04c7\ba\1\2\u04c7"+
		"\u04c8\5\u00c2b\2\u04c8\u04ce\3\2\2\2\u04c9\u04ca\f\3\2\2\u04ca\u04cb"+
		"\7c\2\2\u04cb\u04cd\5\u00c2b\2\u04cc\u04c9\3\2\2\2\u04cd\u04d0\3\2\2\2"+
		"\u04ce\u04cc\3\2\2\2\u04ce\u04cf\3\2\2\2\u04cf\u00c1\3\2\2\2\u04d0\u04ce"+
		"\3\2\2\2\u04d1\u04d3\5\u00c4c\2\u04d2\u04d4\5\u00eav\2\u04d3\u04d2\3\2"+
		"\2\2\u04d3\u04d4\3\2\2\2\u04d4\u00c3\3\2\2\2\u04d5\u04db\5\u00c6d\2\u04d6"+
		"\u04d7\5\u00c8e\2\u04d7\u04d8\5\u00caf\2\u04d8\u04d9\5\u00ccg\2\u04d9"+
		"\u04db\3\2\2\2\u04da\u04d5\3\2\2\2\u04da\u04d6\3\2\2\2\u04db\u00c5\3\2"+
		"\2\2\u04dc\u04e1\5\u00c8e\2\u04dd\u04de\5\u00ceh\2\u04de\u04df\5\u00c6"+
		"d\2\u04df\u04e1\3\2\2\2\u04e0\u04dc\3\2\2\2\u04e0\u04dd\3\2\2\2\u04e1"+
		"\u00c7\3\2\2\2\u04e2\u04e3\be\1\2\u04e3\u04e5\5\u00d2j\2\u04e4\u04e6\5"+
		"\u00acW\2\u04e5\u04e4\3\2\2\2\u04e5\u04e6\3\2\2\2\u04e6\u04ec\3\2\2\2"+
		"\u04e7\u04e8\7=\2\2\u04e8\u04e9\5\u00c6d\2\u04e9\u04ea\7>\2\2\u04ea\u04ec"+
		"\3\2\2\2\u04eb\u04e2\3\2\2\2\u04eb\u04e7\3\2\2\2\u04ec\u04fa\3\2\2\2\u04ed"+
		"\u04ee\f\5\2\2\u04ee\u04f9\5\u00caf\2\u04ef\u04f0\f\4\2\2\u04f0\u04f2"+
		"\7?\2\2\u04f1\u04f3\5@!\2\u04f2\u04f1\3\2\2\2\u04f2\u04f3\3\2\2\2\u04f3"+
		"\u04f4\3\2\2\2\u04f4\u04f6\7@\2\2\u04f5\u04f7\5\u00acW\2\u04f6\u04f5\3"+
		"\2\2\2\u04f6\u04f7\3\2\2\2\u04f7\u04f9\3\2\2\2\u04f8\u04ed\3\2\2\2\u04f8"+
		"\u04ef\3\2\2\2\u04f9\u04fc\3\2\2\2\u04fa\u04f8\3\2\2\2\u04fa\u04fb\3\2"+
		"\2\2\u04fb\u00c9\3\2\2\2\u04fc\u04fa\3\2\2\2\u04fd\u04fe\7=\2\2\u04fe"+
		"\u04ff\5\u00e0q\2\u04ff\u0501\7>\2\2\u0500\u0502\5\u00d0i\2\u0501\u0500"+
		"\3\2\2\2\u0501\u0502\3\2\2\2\u0502\u0504\3\2\2\2\u0503\u0505\5\u0142\u00a2"+
		"\2\u0504\u0503\3\2\2\2\u0504\u0505\3\2\2\2\u0505\u0507\3\2\2\2\u0506\u0508"+
		"\5\u00acW\2\u0507\u0506\3\2\2\2\u0507\u0508\3\2\2\2\u0508\u00cb\3\2\2"+
		"\2\u0509\u050a\7\t\2\2\u050a\u050c\5x=\2\u050b\u050d\5\u00d6l\2\u050c"+
		"\u050b\3\2\2\2\u050c\u050d\3\2\2\2\u050d\u00cd\3\2\2\2\u050e\u0510\7I"+
		"\2\2\u050f\u0511\5\u00acW\2\u0510\u050f\3\2\2\2\u0510\u0511\3\2\2\2\u0511"+
		"\u00cf\3\2\2\2\u0512\u0513\t\5\2\2\u0513\u00d1\3\2\2\2\u0514\u0516\7h"+
		"\2\2\u0515\u0514\3\2\2\2\u0515\u0516\3\2\2\2\u0516\u0517\3\2\2\2\u0517"+
		"\u0518\5\6\4\2\u0518\u00d3\3\2\2\2\u0519\u051b\5v<\2\u051a\u051c\5\u00d6"+
		"l\2\u051b\u051a\3\2\2\2\u051b\u051c\3\2\2\2\u051c\u00d5\3\2\2\2\u051d"+
		"\u0526\5\u00d8m\2\u051e\u0520\5\u00dan\2\u051f\u051e\3\2\2\2\u051f\u0520"+
		"\3\2\2\2\u0520\u0521\3\2\2\2\u0521\u0522\5\u00caf\2\u0522\u0523\5\u00cc"+
		"g\2\u0523\u0526\3\2\2\2\u0524\u0526\5\u00dco\2\u0525\u051d\3\2\2\2\u0525"+
		"\u051f\3\2\2\2\u0525\u0524\3\2\2\2\u0526\u00d7\3\2\2\2\u0527\u052d\5\u00da"+
		"n\2\u0528\u052a\5\u00ceh\2\u0529\u052b\5\u00d8m\2\u052a\u0529\3\2\2\2"+
		"\u052a\u052b\3\2\2\2\u052b\u052d\3\2\2\2\u052c\u0527\3\2\2\2\u052c\u0528"+
		"\3\2\2\2\u052d\u00d9\3\2\2\2\u052e\u052f\bn\1\2\u052f\u053d\5\u00caf\2"+
		"\u0530\u0532\7?\2\2\u0531\u0533\5@!\2\u0532\u0531\3\2\2\2\u0532\u0533"+
		"\3\2\2\2\u0533\u0534\3\2\2\2\u0534\u0536\7@\2\2\u0535\u0537\5\u00acW\2"+
		"\u0536\u0535\3\2\2\2\u0536\u0537\3\2\2\2\u0537\u053d\3\2\2\2\u0538\u0539"+
		"\7=\2\2\u0539\u053a\5\u00d8m\2\u053a\u053b\7>\2\2\u053b\u053d\3\2\2\2"+
		"\u053c\u052e\3\2\2\2\u053c\u0530\3\2\2\2\u053c\u0538\3\2\2\2\u053d\u054b"+
		"\3\2\2\2\u053e\u053f\f\7\2\2\u053f\u054a\5\u00caf\2\u0540\u0541\f\5\2"+
		"\2\u0541\u0543\7?\2\2\u0542\u0544\5@!\2\u0543\u0542\3\2\2\2\u0543\u0544"+
		"\3\2\2\2\u0544\u0545\3\2\2\2\u0545\u0547\7@\2\2\u0546\u0548\5\u00acW\2"+
		"\u0547\u0546\3\2\2\2\u0547\u0548\3\2\2\2\u0548\u054a\3\2\2\2\u0549\u053e"+
		"\3\2\2\2\u0549\u0540\3\2\2\2\u054a\u054d\3\2\2\2\u054b\u0549\3\2\2\2\u054b"+
		"\u054c\3\2\2\2\u054c\u00db\3\2\2\2\u054d\u054b\3\2\2\2\u054e\u0553\5\u00de"+
		"p\2\u054f\u0550\5\u00ceh\2\u0550\u0551\5\u00dco\2\u0551\u0553\3\2\2\2"+
		"\u0552\u054e\3\2\2\2\u0552\u054f\3\2\2\2\u0553\u00dd\3\2\2\2\u0554\u0555"+
		"\bp\1\2\u0555\u0556\7h\2\2\u0556\u0564\3\2\2\2\u0557\u0558\f\5\2\2\u0558"+
		"\u0563\5\u00caf\2\u0559\u055a\f\4\2\2\u055a\u055c\7?\2\2\u055b\u055d\5"+
		"@!\2\u055c\u055b\3\2\2\2\u055c\u055d\3\2\2\2\u055d\u055e\3\2\2\2\u055e"+
		"\u0560\7@\2\2\u055f\u0561\5\u00acW\2\u0560\u055f\3\2\2\2\u0560\u0561\3"+
		"\2\2\2\u0561\u0563\3\2\2\2\u0562\u0557\3\2\2\2\u0562\u0559\3\2\2\2\u0563"+
		"\u0566\3\2\2\2\u0564\u0562\3\2\2\2\u0564\u0565\3\2\2\2\u0565\u00df\3\2"+
		"\2\2\u0566\u0564\3\2\2\2\u0567\u0569\5\u00e2r\2\u0568\u0567\3\2\2\2\u0568"+
		"\u0569\3\2\2\2\u0569\u056b\3\2\2\2\u056a\u056c\7h\2\2\u056b\u056a\3\2"+
		"\2\2\u056b\u056c\3\2\2\2\u056c\u0572\3\2\2\2\u056d\u056e\5\u00e2r\2\u056e"+
		"\u056f\7c\2\2\u056f\u0570\7h\2\2\u0570\u0572\3\2\2\2\u0571\u0568\3\2\2"+
		"\2\u0571\u056d\3\2\2\2\u0572\u00e1\3\2\2\2\u0573\u0574\br\1\2\u0574\u0575"+
		"\5\u00e4s\2\u0575\u057b\3\2\2\2\u0576\u0577\f\3\2\2\u0577\u0578\7c\2\2"+
		"\u0578\u057a\5\u00e4s\2\u0579\u0576\3\2\2\2\u057a\u057d\3\2\2\2\u057b"+
		"\u0579\3\2\2\2\u057b\u057c\3\2\2\2\u057c\u00e3\3\2\2\2\u057d\u057b\3\2"+
		"\2\2\u057e\u0580\5\u00acW\2\u057f\u057e\3\2\2\2\u057f\u0580\3\2\2\2\u0580"+
		"\u0581\3\2\2\2\u0581\u0582\5l\67\2\u0582\u0583\5\u00c4c\2\u0583\u059e"+
		"\3\2\2\2\u0584\u0586\5\u00acW\2\u0585\u0584\3\2\2\2\u0585\u0586\3\2\2"+
		"\2\u0586\u0587\3\2\2\2\u0587\u0588\5l\67\2\u0588\u0589\5\u00c4c\2\u0589"+
		"\u058a\7M\2\2\u058a\u058b\5\u00eex\2\u058b\u059e\3\2\2\2\u058c\u058e\5"+
		"\u00acW\2\u058d\u058c\3\2\2\2\u058d\u058e\3\2\2\2\u058e\u058f\3\2\2\2"+
		"\u058f\u0591\5l\67\2\u0590\u0592\5\u00d6l\2\u0591\u0590\3\2\2\2\u0591"+
		"\u0592\3\2\2\2\u0592\u059e\3\2\2\2\u0593\u0595\5\u00acW\2\u0594\u0593"+
		"\3\2\2\2\u0594\u0595\3\2\2\2\u0595\u0596\3\2\2\2\u0596\u0598\5l\67\2\u0597"+
		"\u0599\5\u00d6l\2\u0598\u0597\3\2\2\2\u0598\u0599\3\2\2\2\u0599\u059a"+
		"\3\2\2\2\u059a\u059b\7M\2\2\u059b\u059c\5\u00eex\2\u059c\u059e\3\2\2\2"+
		"\u059d\u057f\3\2\2\2\u059d\u0585\3\2\2\2\u059d\u058d\3\2\2\2\u059d\u0594"+
		"\3\2\2\2\u059e\u00e5\3\2\2\2\u059f\u05a1\5\u00acW\2\u05a0\u059f\3\2\2"+
		"\2\u05a0\u05a1\3\2\2\2\u05a1\u05a3\3\2\2\2\u05a2\u05a4\5l\67\2\u05a3\u05a2"+
		"\3\2\2\2\u05a3\u05a4\3\2\2\2\u05a4\u05a5\3\2\2\2\u05a5\u05a6\5\u00c4c"+
		"\2\u05a6\u05a7\5\u00e8u\2\u05a7\u00e7\3\2\2\2\u05a8\u05aa\5\u0118\u008d"+
		"\2\u05a9\u05a8\3\2\2\2\u05a9\u05aa\3\2\2\2\u05aa\u05ab\3\2\2\2\u05ab\u05b1"+
		"\5H%\2\u05ac\u05b1\5\u0138\u009d\2\u05ad\u05ae\7M\2\2\u05ae\u05af\7\24"+
		"\2\2\u05af\u05b1\7f\2\2\u05b0\u05a9\3\2\2\2\u05b0\u05ac\3\2\2\2\u05b0"+
		"\u05ad\3\2\2\2\u05b1\u00e9\3\2\2\2\u05b2\u05b8\5\u00ecw\2\u05b3\u05b4"+
		"\7=\2\2\u05b4\u05b5\5\24\13\2\u05b5\u05b6\7>\2\2\u05b6\u05b8\3\2\2\2\u05b7"+
		"\u05b2\3\2\2\2\u05b7\u05b3\3\2\2\2\u05b8\u00eb\3\2\2\2\u05b9\u05ba\7M"+
		"\2\2\u05ba\u05bd\5\u00eex\2\u05bb\u05bd\5\u00f2z\2\u05bc\u05b9\3\2\2\2"+
		"\u05bc\u05bb\3\2\2\2\u05bd\u00ed\3\2\2\2\u05be\u05c1\5:\36\2\u05bf\u05c1"+
		"\5\u00f2z\2\u05c0\u05be\3\2\2\2\u05c0\u05bf\3\2\2\2\u05c1\u00ef\3\2\2"+
		"\2\u05c2\u05c3\by\1\2\u05c3\u05c5\5\u00eex\2\u05c4\u05c6\7h\2\2\u05c5"+
		"\u05c4\3\2\2\2\u05c5\u05c6\3\2\2\2\u05c6\u05cf\3\2\2\2\u05c7\u05c8\f\3"+
		"\2\2\u05c8\u05c9\7c\2\2\u05c9\u05cb\5\u00eex\2\u05ca\u05cc\7h\2\2\u05cb"+
		"\u05ca\3\2\2\2\u05cb\u05cc\3\2\2\2\u05cc\u05ce\3\2\2\2\u05cd\u05c7\3\2"+
		"\2\2\u05ce\u05d1\3\2\2\2\u05cf\u05cd\3\2\2\2\u05cf\u05d0\3\2\2\2\u05d0"+
		"\u00f1\3\2\2\2\u05d1\u05cf\3\2\2\2\u05d2\u05d3\7A\2\2\u05d3\u05d5\5\u00f0"+
		"y\2\u05d4\u05d6\7c\2\2\u05d5\u05d4\3\2\2\2\u05d5\u05d6\3\2\2\2\u05d6\u05d7"+
		"\3\2\2\2\u05d7\u05d8\7B\2\2\u05d8\u05dc\3\2\2\2\u05d9\u05da\7A\2\2\u05da"+
		"\u05dc\7B\2\2\u05db\u05d2\3\2\2\2\u05db\u05d9\3\2\2\2\u05dc\u00f3\3\2"+
		"\2\2\u05dd\u05e0\7i\2\2\u05de\u05e0\5\u012a\u0096\2\u05df\u05dd\3\2\2"+
		"\2\u05df\u05de\3\2\2\2\u05e0\u00f5\3\2\2\2\u05e1\u05e2\5\u00f8}\2\u05e2"+
		"\u05e4\7A\2\2\u05e3\u05e5\5\u00fc\177\2\u05e4\u05e3\3\2\2\2\u05e4\u05e5"+
		"\3\2\2\2\u05e5\u05e6\3\2\2\2\u05e6\u05e7\7B\2\2\u05e7\u00f7\3\2\2\2\u05e8"+
		"\u05ea\7\21\2\2\u05e9\u05eb\5\u00acW\2\u05ea\u05e9\3\2\2\2\u05ea\u05eb"+
		"\3\2\2\2\u05eb\u05ec\3\2\2\2\u05ec\u05ee\5\u00fa~\2\u05ed\u05ef\5\u0106"+
		"\u0084\2\u05ee\u05ed\3\2\2\2\u05ee\u05ef\3\2\2\2\u05ef\u05f8\3\2\2\2\u05f0"+
		"\u05f2\7\21\2\2\u05f1\u05f3\5\u00acW\2\u05f2\u05f1\3\2\2\2\u05f2\u05f3"+
		"\3\2\2\2\u05f3\u05f5\3\2\2\2\u05f4\u05f6\5\u0106\u0084\2\u05f5\u05f4\3"+
		"\2\2\2\u05f5\u05f6\3\2\2\2\u05f6\u05f8\3\2\2\2\u05f7\u05e8\3\2\2\2\u05f7"+
		"\u05f0\3\2\2\2\u05f8\u00f9\3\2\2\2\u05f9\u05fb\5\f\7\2\u05fa\u05f9\3\2"+
		"\2\2\u05fa\u05fb\3\2\2\2\u05fb\u05fc\3\2\2\2\u05fc\u05fd\5\u00f4{\2\u05fd"+
		"\u00fb\3\2\2\2\u05fe\u0600\5\u00fe\u0080\2\u05ff\u0601\5\u00fc\177\2\u0600"+
		"\u05ff\3\2\2\2\u0600\u0601\3\2\2\2\u0601\u0608\3\2\2\2\u0602\u0603\5\u0110"+
		"\u0089\2\u0603\u0605\7e\2\2\u0604\u0606\5\u00fc\177\2\u0605\u0604\3\2"+
		"\2\2\u0605\u0606\3\2\2\2\u0606\u0608\3\2\2\2\u0607\u05fe\3\2\2\2\u0607"+
		"\u0602\3\2\2\2\u0608\u00fd\3\2\2\2\u0609\u060b\5\u00acW\2\u060a\u0609"+
		"\3\2\2\2\u060a\u060b\3\2\2\2\u060b\u060d\3\2\2\2\u060c\u060e\5l\67\2\u060d"+
		"\u060c\3\2\2\2\u060d\u060e\3\2\2\2\u060e\u0610\3\2\2\2\u060f\u0611\5\u0100"+
		"\u0081\2\u0610\u060f\3\2\2\2\u0610\u0611\3\2\2\2\u0611\u0612\3\2\2\2\u0612"+
		"\u0618\7f\2\2\u0613\u0618\5\u00e6t\2\u0614\u0618\5\u00a8U\2\u0615\u0618"+
		"\5b\62\2\u0616\u0618\5f\64\2\u0617\u060a\3\2\2\2\u0617\u0613\3\2\2\2\u0617"+
		"\u0614\3\2\2\2\u0617\u0615\3\2\2\2\u0617\u0616\3\2\2\2\u0618\u00ff\3\2"+
		"\2\2\u0619\u061a\b\u0081\1\2\u061a\u061b\5\u0102\u0082\2\u061b\u0621\3"+
		"\2\2\2\u061c\u061d\f\3\2\2\u061d\u061e\7c\2\2\u061e\u0620\5\u0102\u0082"+
		"\2\u061f\u061c\3\2\2\2\u0620\u0623\3\2\2\2\u0621\u061f\3\2\2\2\u0621\u0622"+
		"\3\2\2\2\u0622\u0101\3\2\2\2\u0623\u0621\3\2\2\2\u0624\u0626\5\u00c4c"+
		"\2\u0625\u0627\5\u0104\u0083\2\u0626\u0625\3\2\2\2\u0626\u0627\3\2\2\2"+
		"\u0627\u0635\3\2\2\2\u0628\u062a\5\u00c4c\2\u0629\u062b\5\u00ecw\2\u062a"+
		"\u0629\3\2\2\2\u062a\u062b\3\2\2\2\u062b\u0635\3\2\2\2\u062c\u062e\7i"+
		"\2\2\u062d\u062c\3\2\2\2\u062d\u062e\3\2\2\2\u062e\u0630\3\2\2\2\u062f"+
		"\u0631\5\u00acW\2\u0630\u062f\3\2\2\2\u0630\u0631\3\2\2\2\u0631\u0632"+
		"\3\2\2\2\u0632\u0633\7e\2\2\u0633\u0635\5@!\2\u0634\u0624\3\2\2\2\u0634"+
		"\u0628\3\2\2\2\u0634\u062d\3\2\2\2\u0635\u0103\3\2\2\2\u0636\u0637\7M"+
		"\2\2\u0637\u0638\7l\2\2\u0638\u0639\b\u0083\1\2\u0639\u0105\3\2\2\2\u063a"+
		"\u063b\7e\2\2\u063b\u063c\5\u0108\u0085\2\u063c\u0107\3\2\2\2\u063d\u063e"+
		"\b\u0085\1\2\u063e\u0640\5\u010a\u0086\2\u063f\u0641\7h\2\2\u0640\u063f"+
		"\3\2\2\2\u0640\u0641\3\2\2\2\u0641\u064a\3\2\2\2\u0642\u0643\f\3\2\2\u0643"+
		"\u0644\7c\2\2\u0644\u0646\5\u010a\u0086\2\u0645\u0647\7h\2\2\u0646\u0645"+
		"\3\2\2\2\u0646\u0647\3\2\2\2\u0647\u0649\3\2\2\2\u0648\u0642\3\2\2\2\u0649"+
		"\u064c\3\2\2\2\u064a\u0648\3\2\2\2\u064a\u064b\3\2\2\2\u064b\u0109\3\2"+
		"\2\2\u064c\u064a\3\2\2\2\u064d\u064f\5\u00acW\2\u064e\u064d\3\2\2\2\u064e"+
		"\u064f\3\2\2\2\u064f\u0650\3\2\2\2\u0650\u0658\5\u010e\u0088\2\u0651\u0653"+
		"\5\u00acW\2\u0652\u0651\3\2\2\2\u0652\u0653\3\2\2\2\u0653\u0654\3\2\2"+
		"\2\u0654\u0655\5\u0110\u0089\2\u0655\u0656\5\u010e\u0088\2\u0656\u0658"+
		"\3\2\2\2\u0657\u064e\3\2\2\2\u0657\u0652\3\2\2\2\u0658\u010b\3\2\2\2\u0659"+
		"\u065b\5\f\7\2\u065a\u0659\3\2\2\2\u065a\u065b\3\2\2\2\u065b\u065c\3\2"+
		"\2\2\u065c\u065d\5\u00f4{\2\u065d\u010d\3\2\2\2\u065e\u065f\5\u010c\u0087"+
		"\2\u065f\u010f\3\2\2\2\u0660\u0661\t\6\2\2\u0661\u0111\3\2\2\2\u0662\u0663"+
		"\7\'\2\2\u0663\u0664\5\u0114\u008b\2\u0664\u0113\3\2\2\2\u0665\u0667\5"+
		"v<\2\u0666\u0668\5\u0116\u008c\2\u0667\u0666\3\2\2\2\u0667\u0668\3\2\2"+
		"\2\u0668\u0115\3\2\2\2\u0669\u066b\5\u00ceh\2\u066a\u066c\5\u0116\u008c"+
		"\2\u066b\u066a\3\2\2\2\u066b\u066c\3\2\2\2\u066c\u0117\3\2\2\2\u066d\u066e"+
		"\7e\2\2\u066e\u066f\5\u011a\u008e\2\u066f\u0119\3\2\2\2\u0670\u0672\5"+
		"\u011c\u008f\2\u0671\u0673\7h\2\2\u0672\u0671\3\2\2\2\u0672\u0673\3\2"+
		"\2\2\u0673\u067c\3\2\2\2\u0674\u0676\5\u011c\u008f\2\u0675\u0677\7h\2"+
		"\2\u0676\u0675\3\2\2\2\u0676\u0677\3\2\2\2\u0677\u0678\3\2\2\2\u0678\u0679"+
		"\7c\2\2\u0679\u067a\5\u011a\u008e\2\u067a\u067c\3\2\2\2\u067b\u0670\3"+
		"\2\2\2\u067b\u0674\3\2\2\2\u067c\u011b\3\2\2\2\u067d\u067e\5\u011e\u0090"+
		"\2\u067e\u0680\7=\2\2\u067f\u0681\5\24\13\2\u0680\u067f\3\2\2\2\u0680"+
		"\u0681\3\2\2\2\u0681\u0682\3\2\2\2\u0682\u0683\7>\2\2\u0683\u0688\3\2"+
		"\2\2\u0684\u0685\5\u011e\u0090\2\u0685\u0686\5\u00f2z\2\u0686\u0688\3"+
		"\2\2\2\u0687\u067d\3\2\2\2\u0687\u0684\3\2\2\2\u0688\u011d\3\2\2\2\u0689"+
		"\u068c\5\u010c\u0087\2\u068a\u068c\7i\2\2\u068b\u0689\3\2\2\2\u068b\u068a"+
		"\3\2\2\2\u068c\u011f\3\2\2\2\u068d\u068e\7\'\2\2\u068e\u068f\5\u0146\u00a4"+
		"\2\u068f\u0121\3\2\2\2\u0690\u0691\7\'\2\2\u0691\u0692\7p\2\2\u0692\u0693"+
		"\7i\2\2\u0693\u0123\3\2\2\2\u0694\u0695\b\u0093\1\2\u0695\u0696\5\u0126"+
		"\u0094\2\u0696\u069c\3\2\2\2\u0697\u0698\f\3\2\2\u0698\u0699\7c\2\2\u0699"+
		"\u069b\5\u0126\u0094\2\u069a\u0697\3\2\2\2\u069b\u069e\3\2\2\2\u069c\u069a"+
		"\3\2\2\2\u069c\u069d\3\2\2\2\u069d\u0125\3\2\2\2\u069e\u069c\3\2\2\2\u069f"+
		"\u06a2\5\u0128\u0095\2\u06a0\u06a2\5\u00e4s\2\u06a1\u069f\3\2\2\2\u06a1"+
		"\u06a0\3\2\2\2\u06a2\u0127\3\2\2\2\u06a3\u06a5\7\21\2\2\u06a4\u06a6\7"+
		"h\2\2\u06a5\u06a4\3\2\2\2\u06a5\u06a6\3\2\2\2\u06a6\u06a8\3\2\2\2\u06a7"+
		"\u06a9\7i\2\2\u06a8\u06a7\3\2\2\2\u06a8\u06a9\3\2\2\2\u06a9\u06d0\3\2"+
		"\2\2\u06aa\u06ac\7\21\2\2\u06ab\u06ad\7i\2\2\u06ac\u06ab\3\2\2\2\u06ac"+
		"\u06ad\3\2\2\2\u06ad\u06ae\3\2\2\2\u06ae\u06af\7M\2\2\u06af\u06d0\5\u00d4"+
		"k\2\u06b0\u06b2\7h\2\2\u06b1\u06b0\3\2\2\2\u06b1\u06b2\3\2\2\2\u06b2\u06b4"+
		"\3\2\2\2\u06b3\u06b5\7i\2\2\u06b4\u06b3\3\2\2\2\u06b4\u06b5\3\2\2\2\u06b5"+
		"\u06d0\3\2\2\2\u06b6\u06b8\7i\2\2\u06b7\u06b6\3\2\2\2\u06b7\u06b8\3\2"+
		"\2\2\u06b8\u06b9\3\2\2\2\u06b9\u06ba\7M\2\2\u06ba\u06d0\5\u00d4k\2\u06bb"+
		"\u06bc\7N\2\2\u06bc\u06bd\5\u0124\u0093\2\u06bd\u06be\7O\2\2\u06be\u06c0"+
		"\7\21\2\2\u06bf\u06c1\7h\2\2\u06c0\u06bf\3\2\2\2\u06c0\u06c1\3\2\2\2\u06c1"+
		"\u06c3\3\2\2\2\u06c2\u06c4\7i\2\2\u06c3\u06c2\3\2\2\2\u06c3\u06c4\3\2"+
		"\2\2\u06c4\u06d0\3\2\2\2\u06c5\u06c6\7N\2\2\u06c6\u06c7\5\u0124\u0093"+
		"\2\u06c7\u06c8\7O\2\2\u06c8\u06ca\7\21\2\2\u06c9\u06cb\7i\2\2\u06ca\u06c9"+
		"\3\2\2\2\u06ca\u06cb\3\2\2\2\u06cb\u06cc\3\2\2\2\u06cc\u06cd\7M\2\2\u06cd"+
		"\u06ce\5\6\4\2\u06ce\u06d0\3\2\2\2\u06cf\u06a3\3\2\2\2\u06cf\u06aa\3\2"+
		"\2\2\u06cf\u06b1\3\2\2\2\u06cf\u06b7\3\2\2\2\u06cf\u06bb\3\2\2\2\u06cf"+
		"\u06c5\3\2\2\2\u06d0\u0129\3\2\2\2\u06d1\u06d2\5\u012e\u0098\2\u06d2\u06d4"+
		"\7N\2\2\u06d3\u06d5\5\u0130\u0099\2\u06d4\u06d3\3\2\2\2\u06d4\u06d5\3"+
		"\2\2\2\u06d5\u06d6\3\2\2\2\u06d6\u06d7\7O\2\2\u06d7\u012b\3\2\2\2\u06d8"+
		"\u06e8\5\u012a\u0096\2\u06d9\u06da\5\u0120\u0091\2\u06da\u06dc\7N\2\2"+
		"\u06db\u06dd\5\u0130\u0099\2\u06dc\u06db\3\2\2\2\u06dc\u06dd\3\2\2\2\u06dd"+
		"\u06de\3\2\2\2\u06de\u06df\7O\2\2\u06df\u06e8\3\2\2\2\u06e0\u06e1\5\u0122"+
		"\u0092\2\u06e1\u06e3\7N\2\2\u06e2\u06e4\5\u0130\u0099\2\u06e3\u06e2\3"+
		"\2\2\2\u06e3\u06e4\3\2\2\2\u06e4\u06e5\3\2\2\2\u06e5\u06e6\7O\2\2\u06e6"+
		"\u06e8\3\2\2\2\u06e7\u06d8\3\2\2\2\u06e7\u06d9\3\2\2\2\u06e7\u06e0\3\2"+
		"\2\2\u06e8\u012d\3\2\2\2\u06e9\u06ea\7i\2\2\u06ea\u012f\3\2\2\2\u06eb"+
		"\u06ec\b\u0099\1\2\u06ec\u06ee\5\u0132\u009a\2\u06ed\u06ef\7h\2\2\u06ee"+
		"\u06ed\3\2\2\2\u06ee\u06ef\3\2\2\2\u06ef\u06f8\3\2\2\2\u06f0\u06f1\f\3"+
		"\2\2\u06f1\u06f2\7c\2\2\u06f2\u06f4\5\u0132\u009a\2\u06f3\u06f5\7h\2\2"+
		"\u06f4\u06f3\3\2\2\2\u06f4\u06f5\3\2\2\2\u06f5\u06f7\3\2\2\2\u06f6\u06f0"+
		"\3\2\2\2\u06f7\u06fa\3\2\2\2\u06f8\u06f6\3\2\2\2\u06f8\u06f9\3\2\2\2\u06f9"+
		"\u0131\3\2\2\2\u06fa\u06f8\3\2\2\2\u06fb\u06ff\5\u00d4k\2\u06fc\u06ff"+
		"\5@!\2\u06fd\u06ff\5\6\4\2\u06fe\u06fb\3\2\2\2\u06fe\u06fc\3\2\2\2\u06fe"+
		"\u06fd\3\2\2\2\u06ff\u0133\3\2\2\2\u0700\u0701\5\f\7\2\u0701\u0702\7i"+
		"\2\2\u0702\u0707\3\2\2\2\u0703\u0704\5\f\7\2\u0704\u0705\5\u012a\u0096"+
		"\2\u0705\u0707\3\2\2\2\u0706\u0700\3\2\2\2\u0706\u0703\3\2\2\2\u0707\u0135"+
		"\3\2\2\2\u0708\u0709\7\62\2\2\u0709\u070a\5H%\2\u070a\u070b\5\u013a\u009e"+
		"\2\u070b\u0137\3\2\2\2\u070c\u070e\7\62\2\2\u070d\u070f\5\u0118\u008d"+
		"\2\u070e\u070d\3\2\2\2\u070e\u070f\3\2\2\2\u070f\u0710\3\2\2\2\u0710\u0711"+
		"\5H%\2\u0711\u0712\5\u013a\u009e\2\u0712\u0139\3\2\2\2\u0713\u0715\5\u013c"+
		"\u009f\2\u0714\u0716\5\u013a\u009e\2\u0715\u0714\3\2\2\2\u0715\u0716\3"+
		"\2\2\2\u0716\u013b\3\2\2\2\u0717\u0718\7\20\2\2\u0718\u0719\7=\2\2\u0719"+
		"\u071a\5\u013e\u00a0\2\u071a\u071b\7>\2\2\u071b\u071c\5H%\2\u071c\u013d"+
		"\3\2\2\2\u071d\u071f\5\u00acW\2\u071e\u071d\3\2\2\2\u071e\u071f\3\2\2"+
		"\2\u071f\u0720\3\2\2\2\u0720\u0721\5v<\2\u0721\u0722\5\u00c4c\2\u0722"+
		"\u072c\3\2\2\2\u0723\u0725\5\u00acW\2\u0724\u0723\3\2\2\2\u0724\u0725"+
		"\3\2\2\2\u0725\u0726\3\2\2\2\u0726\u0728\5v<\2\u0727\u0729\5\u00d6l\2"+
		"\u0728\u0727\3\2\2\2\u0728\u0729\3\2\2\2\u0729\u072c\3\2\2\2\u072a\u072c"+
		"\7h\2\2\u072b\u071e\3\2\2\2\u072b\u0724\3\2\2\2\u072b\u072a\3\2\2\2\u072c"+
		"\u013f\3\2\2\2\u072d\u072f\7\60\2\2\u072e\u0730\5:\36\2\u072f\u072e\3"+
		"\2\2\2\u072f\u0730\3\2\2\2\u0730\u0141\3\2\2\2\u0731\u0732\7\60\2\2\u0732"+
		"\u0734\7=\2\2\u0733\u0735\5\u0144\u00a3\2\u0734\u0733\3\2\2\2\u0734\u0735"+
		"\3\2\2\2\u0735\u0736\3\2\2\2\u0736\u0737\7>\2\2\u0737\u0143\3\2\2\2\u0738"+
		"\u0739\b\u00a3\1\2\u0739\u073b\5\u00d4k\2\u073a\u073c\7h\2\2\u073b\u073a"+
		"\3\2\2\2\u073b\u073c\3\2\2\2\u073c\u0745\3\2\2\2\u073d\u073e\f\3\2\2\u073e"+
		"\u073f\7c\2\2\u073f\u0741\5\u00d4k\2\u0740\u0742\7h\2\2\u0741\u0740\3"+
		"\2\2\2\u0741\u0742\3\2\2\2\u0742\u0744\3\2\2\2\u0743\u073d\3\2\2\2\u0744"+
		"\u0747\3\2\2\2\u0745\u0743\3\2\2\2\u0745\u0746\3\2\2\2\u0746\u0145\3\2"+
		"\2\2\u0747\u0745\3\2\2\2\u0748\u0775\7%\2\2\u0749\u0775\7C\2\2\u074a\u0775"+
		"\7D\2\2\u074b\u0775\7E\2\2\u074c\u0775\7F\2\2\u074d\u0775\7G\2\2\u074e"+
		"\u0775\7H\2\2\u074f\u0775\7I\2\2\u0750\u0775\7J\2\2\u0751\u0775\7K\2\2"+
		"\u0752\u0775\7L\2\2\u0753\u0775\7\n\2\2\u0754\u0775\7M\2\2\u0755\u0775"+
		"\7N\2\2\u0756\u0775\7O\2\2\u0757\u0775\7P\2\2\u0758\u0775\7Q\2\2\u0759"+
		"\u0775\7\7\2\2\u075a\u0775\7R\2\2\u075b\u0775\7S\2\2\u075c\u0775\7T\2"+
		"\2\u075d\u0775\7U\2\2\u075e\u0775\7V\2\2\u075f\u0775\7W\2\2\u0760\u0775"+
		"\7X\2\2\u0761\u0775\7Z\2\2\u0762\u0775\7Y\2\2\u0763\u0775\7[\2\2\u0764"+
		"\u0775\7\\\2\2\u0765\u0775\7]\2\2\u0766\u0775\7^\2\2\u0767\u0775\7_\2"+
		"\2\u0768\u0775\7\5\2\2\u0769\u0775\7`\2\2\u076a\u0775\7\6\2\2\u076b\u0775"+
		"\7a\2\2\u076c\u0775\7b\2\2\u076d\u0775\7c\2\2\u076e\u0775\7\4\2\2\u076f"+
		"\u0775\7\t\2\2\u0770\u0771\7=\2\2\u0771\u0775\7>\2\2\u0772\u0773\7?\2"+
		"\2\u0773\u0775\7@\2\2\u0774\u0748\3\2\2\2\u0774\u0749\3\2\2\2\u0774\u074a"+
		"\3\2\2\2\u0774\u074b\3\2\2\2\u0774\u074c\3\2\2\2\u0774\u074d\3\2\2\2\u0774"+
		"\u074e\3\2\2\2\u0774\u074f\3\2\2\2\u0774\u0750\3\2\2\2\u0774\u0751\3\2"+
		"\2\2\u0774\u0752\3\2\2\2\u0774\u0753\3\2\2\2\u0774\u0754\3\2\2\2\u0774"+
		"\u0755\3\2\2\2\u0774\u0756\3\2\2\2\u0774\u0757\3\2\2\2\u0774\u0758\3\2"+
		"\2\2\u0774\u0759\3\2\2\2\u0774\u075a\3\2\2\2\u0774\u075b\3\2\2\2\u0774"+
		"\u075c\3\2\2\2\u0774\u075d\3\2\2\2\u0774\u075e\3\2\2\2\u0774\u075f\3\2"+
		"\2\2\u0774\u0760\3\2\2\2\u0774\u0761\3\2\2\2\u0774\u0762\3\2\2\2\u0774"+
		"\u0763\3\2\2\2\u0774\u0764\3\2\2\2\u0774\u0765\3\2\2\2\u0774\u0766\3\2"+
		"\2\2\u0774\u0767\3\2\2\2\u0774\u0768\3\2\2\2\u0774\u0769\3\2\2\2\u0774"+
		"\u076a\3\2\2\2\u0774\u076b\3\2\2\2\u0774\u076c\3\2\2\2\u0774\u076d\3\2"+
		"\2\2\u0774\u076e\3\2\2\2\u0774\u076f\3\2\2\2\u0774\u0770\3\2\2\2\u0774"+
		"\u0772\3\2\2\2\u0775\u0147\3\2\2\2\u0776\u0777\t\7\2\2\u0777\u0149\3\2"+
		"\2\2\u00f9\u014b\u0157\u015b\u0162\u016f\u0178\u017a\u017e\u0186\u018d"+
		"\u0194\u019e\u01ad\u01b7\u01b9\u01c7\u01d1\u01d5\u01dd\u01e8\u01ea\u01f9"+
		"\u01fb\u0207\u0209\u0215\u0229\u022b\u0237\u0239\u0244\u024f\u025a\u0266"+
		"\u0268\u0274\u0276\u0280\u0288\u0294\u029b\u029f\u02a3\u02a7\u02ab\u02b0"+
		"\u02b3\u02b6\u02bc\u02c4\u02c9\u02cc\u02d2\u02dd\u02f4\u02f8\u0300\u0306"+
		"\u0312\u0316\u0323\u0327\u032a\u0331\u0339\u0340\u034b\u0353\u035b\u0360"+
		"\u0367\u036a\u036f\u0374\u037d\u0381\u0386\u038f\u0394\u0398\u039d\u03a1"+
		"\u03a6\u03a9\u03c4\u03ca\u03ce\u03d1\u03dc\u03df\u03e6\u03f0\u03f4\u03f7"+
		"\u03fa\u03fe\u0403\u0405\u0409\u040d\u0414\u0421\u0429\u042f\u0435\u0439"+
		"\u044d\u0458\u0466\u0469\u046e\u047a\u0485\u048a\u048f\u0496\u0498\u049d"+
		"\u04a1\u04af\u04b5\u04c4\u04ce\u04d3\u04da\u04e0\u04e5\u04eb\u04f2\u04f6"+
		"\u04f8\u04fa\u0501\u0504\u0507\u050c\u0510\u0515\u051b\u051f\u0525\u052a"+
		"\u052c\u0532\u0536\u053c\u0543\u0547\u0549\u054b\u0552\u055c\u0560\u0562"+
		"\u0564\u0568\u056b\u0571\u057b\u057f\u0585\u058d\u0591\u0594\u0598\u059d"+
		"\u05a0\u05a3\u05a9\u05b0\u05b7\u05bc\u05c0\u05c5\u05cb\u05cf\u05d5\u05db"+
		"\u05df\u05e4\u05ea\u05ee\u05f2\u05f5\u05f7\u05fa\u0600\u0605\u0607\u060a"+
		"\u060d\u0610\u0617\u0621\u0626\u062a\u062d\u0630\u0634\u0640\u0646\u064a"+
		"\u064e\u0652\u0657\u065a\u0667\u066b\u0672\u0676\u067b\u0680\u0687\u068b"+
		"\u069c\u06a1\u06a5\u06a8\u06ac\u06b1\u06b4\u06b7\u06c0\u06c3\u06ca\u06cf"+
		"\u06d4\u06dc\u06e3\u06e7\u06ee\u06f4\u06f8\u06fe\u0706\u070e\u0715\u071e"+
		"\u0724\u0728\u072b\u072f\u0734\u073b\u0741\u0745\u0774";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}