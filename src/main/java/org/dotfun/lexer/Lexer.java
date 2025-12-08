package org.dotfun.lexer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Inteleonyx
 * @project dotFunJava
 */
public class Lexer {

    private final String source;
    private final List<Token> tokens = new ArrayList<>();

    private int start = 0;
    private int current = 0;
    private int line = 1;

    private static final Map<String, TokenType> keywords;
    static {
        keywords = new HashMap<>();

        keywords.put("class", TokenType.CLASS);
        keywords.put("interface", TokenType.INTERFACE);
        keywords.put("extends", TokenType.EXTENDS);
        keywords.put("import", TokenType.IMPORT);
        keywords.put("export", TokenType.EXPORT);
        keywords.put("enum", TokenType.ENUM);
        keywords.put("struct", TokenType.STRUCT);
        keywords.put("public", TokenType.PUBLIC);
        keywords.put("protected", TokenType.PROTECTED);
        keywords.put("private", TokenType.PRIVATE);
        keywords.put("override", TokenType.OVERRIDE);
        keywords.put("this", TokenType.THIS);
        keywords.put("new", TokenType.NEW);
        keywords.put("data", TokenType.DATA);
        keywords.put("constructor", TokenType.CONSTRUCTOR);
        keywords.put("super", TokenType.SUPER);
        keywords.put("instanceof", TokenType.INSTANCEOF);

        keywords.put("if", TokenType.IF);
        keywords.put("else", TokenType.ELSE);
        keywords.put("elif", TokenType.ELIF);
        keywords.put("while", TokenType.WHILE);
        keywords.put("for", TokenType.FOR);
        keywords.put("break", TokenType.BREAK);
        keywords.put("continue", TokenType.CONTINUE);

        keywords.put("async", TokenType.ASYNC);
        keywords.put("await", TokenType.AWAIT);
        keywords.put("fun", TokenType.FUN);
        keywords.put("return", TokenType.RETURN);

        keywords.put("true", TokenType.TRUE);
        keywords.put("false", TokenType.FALSE);
        keywords.put("nil", TokenType.NIL);

        keywords.put("let", TokenType.LET);
        keywords.put("val", TokenType.VAL);
        keywords.put("global", TokenType.GLOBAL);

        keywords.put("and", TokenType.AND);
        keywords.put("or", TokenType.OR);
        keywords.put("not", TokenType.NOT);
        keywords.put("is", TokenType.IS);
        keywords.put("in", TokenType.IN);

        keywords.put("try", TokenType.TRY);
        keywords.put("catch", TokenType.CATCH);
        keywords.put("finally", TokenType.FINALLY);
        keywords.put("throw", TokenType.THROW);

        keywords.put("turn", TokenType.TURN);
        keywords.put("case", TokenType.CASE);
        keywords.put("default", TokenType.DEFAULT);
    }

    public Lexer(String source) {
        this.source = source;
    }

    public List<Token> scanTokens() {
        while (!isAtEnd()) {
            start = current;
            scanToken();
        }
        tokens.add(new Token(TokenType.EOF_TOKEN, "", null, line));
        return tokens;
    }

    private void scanToken() {
        char c = advance();
        switch (c) {
            case '(': addToken(TokenType.LEFT_PAREN); break;
            case ')': addToken(TokenType.RIGHT_PAREN); break;
            case '{': addToken(TokenType.LEFT_BRACE); break;
            case '}': addToken(TokenType.RIGHT_BRACE); break;
            case '[': addToken(TokenType.LEFT_BRACKET); break;
            case ']': addToken(TokenType.RIGHT_BRACKET); break;
            case ',': addToken(TokenType.COMMA); break;
            case ';': addToken(TokenType.SEMICOLON); break;
            case '?': addToken(TokenType.QUESTION); break;

            case '.':
                if (match('.') && match('.')) addToken(TokenType.ELLIPSIS);
                else addToken(TokenType.DOT);
                break;

            case ':':
                if (match(':')) addToken(TokenType.COLON_COLON);
                else addToken(TokenType.COLON);
                break;

            case '+':
                if (match('+')) addToken(TokenType.PLUS_PLUS);
                else addToken(TokenType.PLUS);
                break;

            case '-':
                if (match('-')) addToken(TokenType.MINUS_MINUS);
                else if (match('>')) addToken(TokenType.ARROW);
                else addToken(TokenType.MINUS);
                break;

            case '*': addToken(TokenType.STAR); break;

            case '/':
                if (match('/')) {
                    while (peek() != '\n' && !isAtEnd()) advance();
                } else if (match('*')) {
                    multilineComment();
                } else {
                    addToken(TokenType.SLASH);
                }
                break;

            case '%': addToken(TokenType.PERCENT); break;

            case '&':
                if (match('&')) addToken(TokenType.AND_AND);
                else addToken(TokenType.BIT_AND);
                break;

            case '|':
                if (match('|')) addToken(TokenType.OR_OR);
                else addToken(TokenType.BIT_OR);
                break;

            case '!':
                if (match('=')) addToken(TokenType.NOT_BANG);
                else addToken(TokenType.NOT);
                break;

            case '=':
                if (match('>')) addToken(TokenType.FAT_ARROW);
                else if (match('=')) addToken(TokenType.EQUAL_EQUAL);
                else addToken(TokenType.EQUAL);
                break;

            case '>':
                if (match('>')) addToken(TokenType.SHIFT_RIGHT);
                else if (match('=')) addToken(TokenType.GREATER_EQUAL);
                else addToken(TokenType.GREATER);
                break;

            case '<':
                if (match('<')) addToken(TokenType.SHIFT_LEFT);
                else if (match('=')) addToken(TokenType.LESS_EQUAL);
                else addToken(TokenType.LESS);
                break;

            case '^': addToken(TokenType.BIT_XOR); break;

            case '$': addToken(TokenType.DOLLAR); break;

            case ' ', '\r', '\t':
            case '\n': line++;

            case '"', '\'':
                    literal(c);

            default:
                if (isDigit(c)) {
                    numberLiteral();
                } else if (isAlpha(c)) {
                    identifierOrKeyword();
                } else {
                    error("Unexpected character: " + c);
                }
        }
    }

    private void multilineComment() {
        while (!isAtEnd()) {
            if (peek() == '*' && peekNext() == '/') {
                advance();
                advance();
                return;
            }
            if (peek() == '\n') line++;
            advance();
        }
        error("Unterminated multiline comment");
    }

    private void identifierOrKeyword() {
        while (isAlphaNumeric(peek())) advance();
        String text = source.substring(start, current);
        TokenType type = keywords.getOrDefault(text, TokenType.IDENTIFIER);
        addToken(type);
    }

    private void numberLiteral() {
        while (isDigit(peek())) advance();

        if (peek() == '.' && isDigit(peekNext())) {
            advance();
            while (isDigit(peek())) advance();
        }

        String numberText = source.substring(start, current);
        addToken(TokenType.NUMBER_LITERAL, Double.parseDouble(numberText));
    }

    private void literal(char quote) {
        StringBuilder value = new StringBuilder();

        while (!isAtEnd()) {
            char c = advance();

            if (c == quote) break;

            if (c == '\\') {
                if (isAtEnd()) break;
                char next = advance();
                switch (next) {
                    case 'n' -> value.append('\n');
                    case 't' -> value.append('\t');
                    case 'r' -> value.append('\r');
                    case 'b' -> value.append('\b');
                    case 'f' -> value.append('\f');
                    case '0' -> value.append('\0');
                    case '\\' -> value.append('\\');
                    case '"' -> value.append('"');
                    case '\'' -> value.append('\'');
                    default -> value.append(next);
                }
                continue;
            }

            if (c == '$' && peek() == '{') {
                advance();
                String expr = readInterpolatedExpression();
                value.append("${").append(expr).append("}");
                continue;
            }

            value.append(c);
            if (c == '\n') line++;
        }

        if (isAtEnd()) {
            error("Unterminated literal.");
            return;
        }

        String text = value.toString();

        boolean isChar =
                text.length() == 1;

        if (isChar)
            addToken(TokenType.CHAR_LITERAL, text.charAt(0));
        else
            addToken(TokenType.STRING_LITERAL, text);
    }

    private String readInterpolatedExpression() {
        StringBuilder expr = new StringBuilder();
        int depth = 1;

        while (!isAtEnd() && depth > 0) {
            char c = advance();

            if (c == '{') {
                depth++;
                expr.append(c);
                continue;
            }

            if (c == '}') {
                depth--;
                if (depth == 0) break;
                expr.append(c);
                continue;
            }

            if (c == '\n') line++;
            expr.append(c);
        }

        if (depth != 0) {
            error("Unterminated interpolated expression.");
            return "";
        }

        return expr.toString();
    }

    private boolean match(char expected) {
        if (isAtEnd()) return false;
        if (source.charAt(current) != expected) return false;
        current++;
        return true;
    }

    private char peek() {
        if (isAtEnd()) return '\0';
        return source.charAt(current);
    }

    private char peekNext() {
        if (current + 1 >= source.length()) return '\0';
        return source.charAt(current + 1);
    }

    private boolean isAtEnd() {
        return current >= source.length();
    }

    private char advance() {
        return source.charAt(current++);
    }

    private void addToken(TokenType type) {
        addToken(type, null);
    }

    private void addToken(TokenType type, Object literal) {
        String text = source.substring(start, current);
        tokens.add(new Token(type, text, literal, line));
    }

    private boolean isDigit(char c) { return c >= '0' && c <= '9'; }

    private boolean isAlpha(char c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') ||
                c == '_';
    }

    private boolean isAlphaNumeric(char c) {
        return isAlpha(c) || isDigit(c);
    }

    private void error(String message) {
        throw new RuntimeException("[Line " + line + "] Lexer error: " + message);
    }
}
