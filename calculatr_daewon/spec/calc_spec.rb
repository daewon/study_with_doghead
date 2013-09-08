require './calc'

describe CALC do
  before :each do;end

  it "to_postfix" do
    CALC::to_postfix(%w(27 / 3 + 12)).should eql %w(27 3 / 12 +)
    CALC::to_postfix(%w(27 / ( 3 + 12 ))).should eql %w(27 3 12 + /)
    CALC::to_postfix(%w(27 + 3 / 12)).should eql %w(27 3 12 / +)

    CALC::to_postfix(%w(12 + 13 * 20)).should eql %w(12 13 20 * +)
    CALC::to_postfix(%w(( 12 + 13 ) * 20)).should eql %w(12 13 + 20 *)

    CALC::to_postfix(%w(( 12 + ( 13 - 10 ) ) * 20)).should eql %w(12 13 10 - + 20 *)
    CALC::to_postfix(%w(( ( 12 + 13 ) * 10 ) / 20)).should eql %w(12 13 + 10 * 20 /)
  end

  it "operator?" do
    %w(/ + - * \) \().all? do |token|
      CALC::operator?(token).should eql true
    end
  end

  it "calc" do
    CALC::calc(%w(1 + 2)).should eql 3
    CALC::calc(%w(1 * 2 + 3)).should eql 5
    CALC::calc(%w(1 * ( 2 + 3 ))).should eql 5.0
    CALC::calc(%w(4 / 2)).should eql 2.0

    CALC::calc(%w(( 12 + ( 13 - 10 ) ) * 20)).should eql 300.0
    CALC::calc(%w(( ( 12 + 13 ) * 10 ) + 20)).should eql 270
  end

  it "lexer" do
    CALC::lexer("1+2").should eql %w(1 + 2)
    CALC::lexer("1.0+2.23").should eql %w(1.0 + 2.23)
    CALC::lexer("1*2+   3").should eql %w(1 * 2 + 3)
    CALC::lexer("(12 +13)* 20").should eql %w(( 12 + 13 ) * 20)

    CALC::lexer("(12+(13-10))*20").should eql %w(( 12 + ( 13 - 10 ) ) * 20)
    CALC::lexer("((12+13)*10)+20").should eql %w(( ( 12 + 13 ) * 10 ) + 20)

    CALC::lexer("((0.5-12.12+13.0)*10.9)+20.1212").should eql %w(( ( 0.5 - 12.12 + 13.0 ) * 10.9 ) + 20.1212)
  end

  it "run" do
    CALC::run("1+2").should eql 3
    CALC::run("1.0+2").should eql 3

    CALC::run("1*2+   3").should eql 5
    CALC::run("(12 +13)* 20").should eql 500.0

    CALC::run("(12+(13-10))*20").should eql 300.0
    CALC::run("((12+13)*10)+20").should eql 270
  end
end
