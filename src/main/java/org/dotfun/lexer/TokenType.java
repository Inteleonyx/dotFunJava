package org.dotfun.lexer;

/**
 * @author Inteleonyx. Created on 07/12/2025
 * @project dotFunJava
 */
public enum TokenType {
    EOF_TOKEN,

    // Identifiers & literals
    IDENTIFIER,
    NUMBER_LITERAL,
    STRING_LITERAL,
    CHAR_LITERAL,

    // Keywords: OOP / Structures
    CLASS,
    INTERFACE,
    EXTENDS,
    IMPORT,
    EXPORT,
    ENUM,
    STRUCT,
    PUBLIC,
    PROTECTED,
    PRIVATE,
    OVERRIDE,
    THIS,
    NEW,
    SUPER,
    CONSTRUCTOR,
    DATA,
    INSTANCEOF,

    // Control Flow
    IF,
    ELSE,
    ELIF,
    WHILE,
    FOR,
    BREAK,
    CONTINUE,

    // Functions
    ASYNC,
    AWAIT,
    FUN,
    RETURN,

    // Literals
    TRUE,
    FALSE,
    NIL,

    // Variables
    LET,
    VAL,
    GLOBAL,

    // Operators (word versions)
    AND,
    OR,
    NOT,
    IS,
    IN,
    OF,

    // --- NOVOS TOKENS DE ERROR HANDLING ---
    TRY,
    CATCH,
    FINALLY,
    THROW,

    // --- NOVOS TOKENS DE SWITCH CASE ---
    TURN, // Keyword 'turn' (seu equivalente a 'switch')
    CASE,
    DEFAULT,

    // Symbols for operators
    PLUS,           // +
    MINUS,          // -
    STAR,           // *
    SLASH,          // /
    PERCENT,        // %
    AND_AND,        // &&
    OR_OR,          // ||
    NOT_BANG,       // !
    EQUAL_EQUAL,    // ==
    COLON,          // :
    GREATER,        // >
    LESS,           // <
    GREATER_EQUAL,  // >=
    LESS_EQUAL,     // <=
    MINUS_MINUS,    // --
    PLUS_PLUS,      // ++
    DOLLAR,         // $

    // Assignment
    EQUAL,          // =

    // Brackets
    LEFT_PAREN,     // (
    RIGHT_PAREN,    // )
    LEFT_BRACE,     // {
    RIGHT_BRACE,    // }
    LEFT_BRACKET,   // [
    RIGHT_BRACKET,  // ]

    //Lambdas
    ARROW,          // ->
    FAT_ARROW,      // =>
    COLON_COLON,    // ::
    QUESTION,       // ?
    ELLIPSIS,       // ...
    BIT_AND, BIT_OR, BIT_XOR,
    SHIFT_LEFT, SHIFT_RIGHT,

    // Punctuation
    COMMA,          // ,
    DOT,            // .
    SEMICOLON,      // ;
}
