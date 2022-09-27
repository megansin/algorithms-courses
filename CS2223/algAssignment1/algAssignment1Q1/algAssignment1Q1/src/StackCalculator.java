public class StackCalculator {

    private String input;
    private Stack<String> ops  = new Stack<String>();
    private Stack<Double> vals = new Stack<Double>();

    public StackCalculator(){}

    //read string and put into ops and vals stacks
    public void calculate(String input){

        String[] splitted = input.split("\\s+");
        for (String s : splitted) {
            if (s.equals("("));
            else if (s.equals("+")) {
                ops.push(s);
            }
            else if (s.equals("-")){
                ops.push(s);
            }
            else if (s.equals("*")){
                ops.push(s);
            }
            else if (s.equals("/")){
                ops.push(s);
            }
            else if (s.equals("abs")){
                ops.push(s);
            }
            else if (s.equals("!")){
                ops.push(s);
            }
            else if (s.equals("sqrt")){
                ops.push(s);
            }
            else if (s.equals(")")){
                //evaluate
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+")){
                    v = vals.pop() + v;
                }
                else if (op.equals("-")){
                    v = vals.pop() - v;
                }
                else if (op.equals("*")){
                    v = vals.pop() * v;
                }
                else if (op.equals("/")){
                    v = vals.pop() / v;
                }
                else if (op.equals("sqrt")){
                    v = Math.sqrt(v);
                }
                else if (op.equals("abs")){
                    v = Math.abs(v);
                }
                else if (op.equals("!")){
                    double tot = 1;
                    for (int i = 2; i < v+1; i++) {
                        tot *= i;
                    }
                    v = tot;
                }
                vals.push(v);
            }
            else vals.push(Double.parseDouble(s));
        }

        System.out.println(String.format("%s = %f", input, vals.pop() ));

    }


}
