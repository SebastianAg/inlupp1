package inlupp1;

//Authors: Fredrik Sander & Sebastian Agfemalm

public class FactorNode implements INode {

    //Must exist
    public Lexeme integer;

    //Or must exist
    public Lexeme id;

    //Or must exist
    public Lexeme leftParantesis;
    public ExpressionNode expression;
    public Lexeme rightParantesis;

    @Override
    public Object evaluate(Object[] args) throws Exception {
        if (integer != null)
            return integer.value().toString();

        if (integer == null && id != null)
            return Double.toString(Evaluator.getValue(id.value().toString()));

        if (integer == null && id == null)
            return "(" + expression.evaluate(args) + ")";

        return null;
    }

    @Override
    public void buildString(StringBuilder builder, int tabs) {
        builder.append(StringUtil.prependTabs("FactorNode\n", tabs));
        if (integer != null)
        {
            builder.append(StringUtil.prependTabs(integer.toString() + "\n", tabs + 1));
        } else if (id != null) {
            builder.append(StringUtil.prependTabs(id.toString() + "\n", tabs + 1));
        } else if (leftParantesis != null && expression != null && rightParantesis != null)
        {
            builder.append(StringUtil.prependTabs(leftParantesis.toString() + "\n", tabs + 1));
            expression.buildString(builder, tabs + 1);
            builder.append(StringUtil.prependTabs(rightParantesis.toString() + "\n", tabs + 1));
        }
    }
}
