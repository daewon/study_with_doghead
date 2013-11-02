# -*- coding: utf-8 -*-

module CALC
  @@operators = { "*" => 2, "/" => 2, "+" => 1, "-" => 1, "(" => -1, ")" => 0 }

  def self.start_paren? token
    token == "("
  end

  def self.end_paren? token
    token == ")"
  end

  def self.paren? token
    (start_paren? token) || (end_paren? token)
  end

  # check token is operator
  def self.operator? token
    not @@operators[token].nil?
  end

  # check priority
  def self.prior? tokenA, tokenB
    @@operators[tokenA] > @@operators[tokenB]
  end

  # transform infix to postfix
  def self.to_postfix infix
    infix, postfix, stack = infix.reverse, [], []

    while not infix.empty? do
      token = infix.pop

      if not operator? token
        postfix << token ; next # continue if token is not operator
      elsif stack.empty? or start_paren? token or start_paren? stack.last
        # do nothing
      elsif end_paren? token
        # pop every stack element before start paren: "("
        while true
          op = stack.pop
          postfix << op unless start_paren? op
          break if start_paren? op
        end
        next # continue current token
      elsif prior? stack.last, token
        postfix << stack.pop
      end

      stack << token
    end

    # print rest operator
    while not stack.empty?
      postfix << stack.pop
    end

    postfix
  end

  def self.binary_function token
    {
      "*" => -> a, b { a.to_f * b.to_f },
        "/" => -> a, b { a.to_f / b.to_f },
        "+" => -> a, b { a.to_i + b.to_i },
        "-" => -> a, b { a.to_i - b.to_i }
    }[token]
  end

  def self.build_exp_tree infix
    tokens = (to_postfix infix)
    root = Tree.new tokens.pop

    build = -> root do
      token = tokens.pop
      if CALC::operator? token
        root.left = build.call(Tree.new token)
      else
        root.left = token
      end

      token = tokens.pop
      if CALC::operator? token
        root.right = build.call(Tree.new token)
      else
        root.right = token
      end
      root
    end

    build.call root unless tokens.empty?
  end

  class Tree
    attr_accessor :left, :right, :value
    def initialize value
      @value = value
    end

    def calc
      node_value = -> node {
        return node.calc if node.kind_of? Tree
        node
      }

      if CALC::operator? value
        fn = CALC::binary_function value
        fn.call *([right, left].map &node_value)
      else
        value
      end
    end
  end

  def self.calc infix
    exp_tree = self.build_exp_tree infix
    exp_tree.calc
  end

  # 문자열 -> 토큰
  def self.lexer expression
    is_operator = -> ch { not @@operators[ch].nil? }
    split_parts = -> exp { [ exp[0], exp[1...exp.length] ] }

    tokens = []
    lex = -> exp do
      head, tail = split_parts.call exp
      return if head.nil? # exit condition

      if is_operator.call head
        tokens << head
      elsif head == " "
        tokens << nil
      elsif (not is_operator.call tokens.last) && (not tokens.last.nil?)
        tokens << tokens.pop + head
      else
        tokens << head
      end

      lex.call tail
    end

    lex.call expression
    tokens = tokens.compact
  end

  def self.run str
    calc(lexer str)
  end
end
